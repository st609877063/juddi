/*
 * Copyright 2001-2008 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.juddi.api.impl;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.xml.ws.Holder;

import org.uddi.api_v3.AddPublisherAssertions;
import org.uddi.api_v3.AssertionStatusItem;
import org.uddi.api_v3.BindingDetail;
import org.uddi.api_v3.BusinessDetail;
import org.uddi.api_v3.CompletionStatus;
import org.uddi.api_v3.DeleteBinding;
import org.uddi.api_v3.DeleteBusiness;
import org.uddi.api_v3.DeletePublisherAssertions;
import org.uddi.api_v3.DeleteService;
import org.uddi.api_v3.DeleteTModel;
import org.uddi.api_v3.GetRegisteredInfo;
import org.uddi.api_v3.InfoSelection;
import org.uddi.api_v3.PublisherAssertion;
import org.uddi.api_v3.RegisteredInfo;
import org.uddi.api_v3.SaveBinding;
import org.uddi.api_v3.SaveBusiness;
import org.uddi.api_v3.SaveService;
import org.uddi.api_v3.SaveTModel;
import org.uddi.api_v3.ServiceDetail;
import org.uddi.api_v3.TModelDetail;
import org.uddi.v3_service.DispositionReportFaultMessage;
import org.uddi.v3_service.UDDIPublicationPortType;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.juddi.mapping.MappingApiToModel;
import org.apache.juddi.mapping.MappingModelToApi;
import org.apache.juddi.v3.error.ErrorMessage;
import org.apache.juddi.v3.error.FatalErrorException;
import org.apache.juddi.validation.ValidatePublish;
import org.apache.juddi.query.FetchBusinessEntitiesQuery;
import org.apache.juddi.query.FetchTModelsQuery;
import org.apache.juddi.query.FindBusinessByPublisherQuery;
import org.apache.juddi.query.FindTModelByPublisherQuery;
import org.apache.juddi.query.FindPublisherAssertionByBusinessQuery;
import org.apache.juddi.query.DeletePublisherAssertionByBusinessQuery;
import org.apache.juddi.query.TModelQuery;
import org.apache.juddi.model.UddiEntityPublisher;
import org.apache.juddi.api.util.PublicationQuery;
import org.apache.juddi.api.util.QueryStatus;
import org.apache.juddi.config.AppConfig;
import org.apache.juddi.config.PersistenceManager;
import org.apache.juddi.config.Property;
import org.apache.juddi.query.util.DynamicQuery;
import org.apache.juddi.query.util.FindQualifiers;
import org.uddi.api_v3.ListDescription;

/**
 * This class implements the UDDI Publication Service
 * @author <a href="mailto:jfaath@apache.org">Jeff Faath</a> (and many others)
 */
@WebService(serviceName="UDDIPublicationService", 
			endpointInterface="org.uddi.v3_service.UDDIPublicationPortType",
			targetNamespace = "urn:uddi-org:v3_service")
public class UDDIPublicationImpl extends AuthenticatedService implements UDDIPublicationPortType {

        private static Log log = LogFactory.getLog(UDDIInquiryImpl.class);
        private UDDIServiceCounter serviceCounter;
    
        public UDDIPublicationImpl() {
            super();
            serviceCounter = ServiceCounterLifecycleResource.getServiceCounter(UDDIPublicationImpl.class);
        }
	
        
        
	public void addPublisherAssertions(AddPublisherAssertions body)
			throws DispositionReportFaultMessage {
	        long startTime = System.currentTimeMillis();

		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			UddiEntityPublisher publisher = this.getEntityPublisher(em, body.getAuthInfo());
			
			new ValidatePublish(publisher).validateAddPublisherAssertions(em, body);
	
			List<org.uddi.api_v3.PublisherAssertion> apiPubAssertionList = body.getPublisherAssertion();
			for (org.uddi.api_v3.PublisherAssertion apiPubAssertion : apiPubAssertionList) {
				
				org.apache.juddi.model.PublisherAssertion modelPubAssertion = new org.apache.juddi.model.PublisherAssertion();
				
				MappingApiToModel.mapPublisherAssertion(apiPubAssertion, modelPubAssertion);
				
				org.apache.juddi.model.PublisherAssertion existingPubAssertion = em.find(modelPubAssertion.getClass(), modelPubAssertion.getId());
				boolean persistNewAssertion = true;
				if (existingPubAssertion != null) {
					if (modelPubAssertion.getTmodelKey().equalsIgnoreCase(existingPubAssertion.getTmodelKey()) &&
						modelPubAssertion.getKeyName().equalsIgnoreCase(existingPubAssertion.getKeyName()) &&
						modelPubAssertion.getKeyValue().equalsIgnoreCase(existingPubAssertion.getKeyValue())) {
						// This pub assertion is already been "asserted".  Simply need to set the "check" value on the existing (and persistent) assertion
						if (publisher.isOwner(existingPubAssertion.getBusinessEntityByFromKey()))
							existingPubAssertion.setFromCheck("true");
						if (publisher.isOwner(existingPubAssertion.getBusinessEntityByToKey()))
							existingPubAssertion.setToCheck("true");
						
						persistNewAssertion = false;
					}
					else {
						// Otherwise, it is a new relationship between these entities.  Remove the old one so the new one can be added.
						// TODO: the model only seems to allow one assertion per two business (primary key is fromKey and toKey). Spec seems to imply as 
						// many relationships as desired (the differentiator would be the keyedRef values).
						em.remove(existingPubAssertion);
					}
				}
	
				if (persistNewAssertion) {
					org.apache.juddi.model.BusinessEntity beFrom = em.find(org.apache.juddi.model.BusinessEntity.class, modelPubAssertion.getId().getFromKey());
					org.apache.juddi.model.BusinessEntity beTo = em.find(org.apache.juddi.model.BusinessEntity.class, modelPubAssertion.getId().getToKey());
					modelPubAssertion.setBusinessEntityByFromKey(beFrom);
					modelPubAssertion.setBusinessEntityByToKey(beTo);
	
					modelPubAssertion.setFromCheck("false");
					modelPubAssertion.setToCheck("false");
	
					em.persist(modelPubAssertion);
					
					if (publisher.isOwner(modelPubAssertion.getBusinessEntityByFromKey()))
						modelPubAssertion.setFromCheck("true");
					if (publisher.isOwner(modelPubAssertion.getBusinessEntityByToKey()))
						modelPubAssertion.setToCheck("true");
				}
				
			}
	
			tx.commit();
                        long procTime = System.currentTimeMillis() - startTime;
                        serviceCounter.update(PublicationQuery.ADD_PUBLISHERASSERTIONS, 
                                QueryStatus.SUCCESS, procTime);			
                } catch (DispositionReportFaultMessage drfm) {
                    long procTime = System.currentTimeMillis() - startTime;
                    serviceCounter.update(PublicationQuery.ADD_PUBLISHERASSERTIONS, QueryStatus.FAILED, procTime);                      
                    throw drfm;
                } finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}

	public void deleteBinding(DeleteBinding body)
			throws DispositionReportFaultMessage {
	        long startTime = System.currentTimeMillis();

		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
	
			UddiEntityPublisher publisher = this.getEntityPublisher(em, body.getAuthInfo());
			
			new ValidatePublish(publisher).validateDeleteBinding(em, body);
			
			List<String> entityKeyList = body.getBindingKey();
			for (String entityKey : entityKeyList) {
				Object obj = em.find(org.apache.juddi.model.BindingTemplate.class, entityKey);
	
				((org.apache.juddi.model.BindingTemplate)obj).getBusinessService().setModifiedIncludingChildren(new Date());
				// JUDDI-421:  now the businessEntity parent will have it's modifiedIncludingChildren set
				((org.apache.juddi.model.BindingTemplate)obj).getBusinessService().getBusinessEntity().setModifiedIncludingChildren(new Date());
				
				em.remove(obj);
			}
	
			tx.commit();
                        long procTime = System.currentTimeMillis() - startTime;
                        serviceCounter.update(PublicationQuery.DELETE_BINDING, 
                                QueryStatus.SUCCESS, procTime);                      
                } catch (DispositionReportFaultMessage drfm) {
                    long procTime = System.currentTimeMillis() - startTime;
                    serviceCounter.update(PublicationQuery.DELETE_BINDING, QueryStatus.FAILED, procTime);                      
                    throw drfm;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}

	public void deleteBusiness(DeleteBusiness body)
			throws DispositionReportFaultMessage {
	        long startTime = System.currentTimeMillis();

		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
	
			UddiEntityPublisher publisher = this.getEntityPublisher(em, body.getAuthInfo());
	
			new ValidatePublish(publisher).validateDeleteBusiness(em, body);
			
			List<String> entityKeyList = body.getBusinessKey();
			for (String entityKey : entityKeyList) {
				Object obj = em.find(org.apache.juddi.model.BusinessEntity.class, entityKey);
				em.remove(obj);
			}
	
			tx.commit();
                        long procTime = System.currentTimeMillis() - startTime;
                        serviceCounter.update(PublicationQuery.DELETE_BUSINESS, QueryStatus.SUCCESS, procTime);               
                } catch (DispositionReportFaultMessage drfm) {
                    long procTime = System.currentTimeMillis() - startTime;
                    serviceCounter.update(PublicationQuery.DELETE_BUSINESS, QueryStatus.FAILED, procTime);                      
                    throw drfm;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}

	public void deletePublisherAssertions(DeletePublisherAssertions body)
			throws DispositionReportFaultMessage {
	        long startTime = System.currentTimeMillis();

		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
	
			UddiEntityPublisher publisher = this.getEntityPublisher(em, body.getAuthInfo());
	
			new ValidatePublish(publisher).validateDeletePublisherAssertions(em, body);
			
			List<org.uddi.api_v3.PublisherAssertion> entityList = body.getPublisherAssertion();
			for (org.uddi.api_v3.PublisherAssertion entity : entityList) {
				org.apache.juddi.model.PublisherAssertionId pubAssertionId = new org.apache.juddi.model.PublisherAssertionId(entity.getFromKey(), entity.getToKey());
				Object obj = em.find(org.apache.juddi.model.PublisherAssertion.class, pubAssertionId);
				em.remove(obj);
			}
	
			tx.commit();
                        long procTime = System.currentTimeMillis() - startTime;
                        serviceCounter.update(PublicationQuery.DELETE_PUBLISHERASSERTIONS, 
                                QueryStatus.SUCCESS, procTime);
                } catch (DispositionReportFaultMessage drfm) {
                    long procTime = System.currentTimeMillis() - startTime;
                    serviceCounter.update(PublicationQuery.DELETE_PUBLISHERASSERTIONS, QueryStatus.FAILED, procTime);                      
                    throw drfm;                        
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}

	public void deleteService(DeleteService body)
			throws DispositionReportFaultMessage {
	        long startTime = System.currentTimeMillis();

		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
	
			UddiEntityPublisher publisher = this.getEntityPublisher(em, body.getAuthInfo());
			
			new ValidatePublish(publisher).validateDeleteService(em, body);
			
			List<String> entityKeyList = body.getServiceKey();
			for (String entityKey : entityKeyList) {
				Object obj = em.find(org.apache.juddi.model.BusinessService.class, entityKey);
				
				((org.apache.juddi.model.BusinessService)obj).getBusinessEntity().setModifiedIncludingChildren(new Date());
				
				em.remove(obj);
			}
	
			tx.commit();
                        long procTime = System.currentTimeMillis() - startTime;
                        serviceCounter.update(PublicationQuery.DELETE_SERVICE, 
                                QueryStatus.SUCCESS, procTime);
                } catch (DispositionReportFaultMessage drfm) {
                    long procTime = System.currentTimeMillis() - startTime;
                    serviceCounter.update(PublicationQuery.DELETE_SERVICE, QueryStatus.FAILED, procTime);                      
                    throw drfm;                                               
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}


	public void deleteTModel(DeleteTModel body)
			throws DispositionReportFaultMessage {
	        long startTime = System.currentTimeMillis();

		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
	
			UddiEntityPublisher publisher = this.getEntityPublisher(em, body.getAuthInfo());
	
			new ValidatePublish(publisher).validateDeleteTModel(em, body);
	
			// tModels are only lazily deleted!
			List<String> entityKeyList = body.getTModelKey();
			for (String entityKey : entityKeyList) {
				Object obj = em.find(org.apache.juddi.model.Tmodel.class, entityKey);
				((org.apache.juddi.model.Tmodel)obj).setDeleted(true);
				
			}
			
			tx.commit();
                        long procTime = System.currentTimeMillis() - startTime;
                        serviceCounter.update(PublicationQuery.DELETE_TMODEL, QueryStatus.SUCCESS, procTime);                      
                } catch (DispositionReportFaultMessage drfm) {
                    long procTime = System.currentTimeMillis() - startTime;
                    serviceCounter.update(PublicationQuery.DELETE_TMODEL, QueryStatus.FAILED, procTime);                      
                    throw drfm;                                               
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}


	public List<AssertionStatusItem> getAssertionStatusReport(String authInfo,
			CompletionStatus completionStatus)
			throws DispositionReportFaultMessage {
	        long startTime = System.currentTimeMillis();

		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
	
			UddiEntityPublisher publisher = this.getEntityPublisher(em, authInfo);
	
			List<org.uddi.api_v3.AssertionStatusItem> result = PublicationHelper.getAssertionStatusItemList(publisher, completionStatus, em);
	
			tx.commit();
                        long procTime = System.currentTimeMillis() - startTime;
                        serviceCounter.update(PublicationQuery.GET_ASSERTIONSTATUSREPORT, 
                                QueryStatus.SUCCESS, procTime);                      

			return result;
                } catch (DispositionReportFaultMessage drfm) {
                    long procTime = System.currentTimeMillis() - startTime;
                    serviceCounter.update(PublicationQuery.GET_ASSERTIONSTATUSREPORT, QueryStatus.FAILED, procTime);                      
                    throw drfm;                                               
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}

	public List<PublisherAssertion> getPublisherAssertions(String authInfo)
			throws DispositionReportFaultMessage {
	        long startTime = System.currentTimeMillis();

		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
	
			UddiEntityPublisher publisher = this.getEntityPublisher(em, authInfo);
			
			List<org.uddi.api_v3.PublisherAssertion> result = new ArrayList<org.uddi.api_v3.PublisherAssertion>(0);
	
			List<?> businessKeysFound = null;
			businessKeysFound = FindBusinessByPublisherQuery.select(em, null, publisher, businessKeysFound);
			
			List<org.apache.juddi.model.PublisherAssertion> pubAssertionList = FindPublisherAssertionByBusinessQuery.select(em, businessKeysFound, null);
                        if (pubAssertionList!=null)
			for(org.apache.juddi.model.PublisherAssertion modelPubAssertion : pubAssertionList) {
				org.uddi.api_v3.PublisherAssertion apiPubAssertion = new org.uddi.api_v3.PublisherAssertion();
	
				MappingModelToApi.mapPublisherAssertion(modelPubAssertion, apiPubAssertion);
				
				result.add(apiPubAssertion);
			}
			
			tx.commit();
                        long procTime = System.currentTimeMillis() - startTime;
                        serviceCounter.update(PublicationQuery.GET_PUBLISHERASSERTIONS, 
                                QueryStatus.SUCCESS, procTime);                      
			return result;
                } catch (DispositionReportFaultMessage drfm) {
                    long procTime = System.currentTimeMillis() - startTime;
                    serviceCounter.update(PublicationQuery.GET_PUBLISHERASSERTIONS, 
                            QueryStatus.FAILED, procTime);                      
                    throw drfm;                                               			
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}


	public RegisteredInfo getRegisteredInfo(GetRegisteredInfo body)
			throws DispositionReportFaultMessage {
	        long startTime = System.currentTimeMillis();

		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
	
			UddiEntityPublisher publisher = this.getEntityPublisher(em, body.getAuthInfo());
			
			new ValidatePublish(publisher).validateRegisteredInfo(body);

			List<?> businessKeysFound = null;
			businessKeysFound = FindBusinessByPublisherQuery.select(em, null, publisher, businessKeysFound);
	
			
			List<?> tmodelKeysFound = null;

			if (body.getInfoSelection().equals(InfoSelection.HIDDEN))
				tmodelKeysFound = FindTModelByPublisherQuery.select(em, null, publisher, tmodelKeysFound, new DynamicQuery.Parameter(TModelQuery.ENTITY_ALIAS + ".deleted",  Boolean.TRUE, DynamicQuery.PREDICATE_EQUALS));
			else if (body.getInfoSelection().equals(InfoSelection.VISIBLE))
				tmodelKeysFound = FindTModelByPublisherQuery.select(em, null, publisher, tmodelKeysFound, new DynamicQuery.Parameter(TModelQuery.ENTITY_ALIAS + ".deleted",  Boolean.FALSE, DynamicQuery.PREDICATE_EQUALS));
			else
				tmodelKeysFound = FindTModelByPublisherQuery.select(em, null, publisher, tmodelKeysFound);
				
			RegisteredInfo result = new RegisteredInfo();
			
			// Sort and retrieve the final results
			List<?> queryResults = FetchBusinessEntitiesQuery.select(em, new FindQualifiers(), businessKeysFound, null, null, null);
			if (queryResults.size() > 0) {
				result.setBusinessInfos(new org.uddi.api_v3.BusinessInfos());
				
				for (Object item : queryResults) {
					org.apache.juddi.model.BusinessEntity modelBusinessEntity = (org.apache.juddi.model.BusinessEntity)item;
					org.uddi.api_v3.BusinessInfo apiBusinessInfo = new org.uddi.api_v3.BusinessInfo();
					
					MappingModelToApi.mapBusinessInfo(modelBusinessEntity, apiBusinessInfo);
					
					result.getBusinessInfos().getBusinessInfo().add(apiBusinessInfo);
				}
			}
	
			// Sort and retrieve the final results
			queryResults = FetchTModelsQuery.select(em, new FindQualifiers(), tmodelKeysFound, null, null, null);
			if (queryResults.size() > 0) {
				result.setTModelInfos(new org.uddi.api_v3.TModelInfos());
				
				for (Object item : queryResults) {
					org.apache.juddi.model.Tmodel modelTModel = (org.apache.juddi.model.Tmodel)item;
					org.uddi.api_v3.TModelInfo apiTModelInfo = new org.uddi.api_v3.TModelInfo();
					
					MappingModelToApi.mapTModelInfo(modelTModel, apiTModelInfo);
					
					result.getTModelInfos().getTModelInfo().add(apiTModelInfo);
				}
			}
			
			tx.commit();	
                        long procTime = System.currentTimeMillis() - startTime;
                        serviceCounter.update(PublicationQuery.GET_REGISTEREDINFO, 
                                QueryStatus.SUCCESS, procTime);                      

			return result;
                } catch (DispositionReportFaultMessage drfm) {
                    long procTime = System.currentTimeMillis() - startTime;
                    serviceCounter.update(PublicationQuery.GET_REGISTEREDINFO, 
                            QueryStatus.FAILED, procTime);                      
                    throw drfm;                                                                 
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}


	public BindingDetail saveBinding(SaveBinding body)
			throws DispositionReportFaultMessage {
	        long startTime = System.currentTimeMillis();

		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			UddiEntityPublisher publisher = this.getEntityPublisher(em, body.getAuthInfo());
			
			ValidatePublish validator = new ValidatePublish(publisher);
			validator.validateSaveBinding(em, body, null);
	
			BindingDetail result = new BindingDetail();
                        result.setListDescription(new ListDescription());
			List<org.uddi.api_v3.BindingTemplate> apiBindingTemplateList = body.getBindingTemplate();
			for (org.uddi.api_v3.BindingTemplate apiBindingTemplate : apiBindingTemplateList) {
				
				org.apache.juddi.model.BindingTemplate modelBindingTemplate = new org.apache.juddi.model.BindingTemplate();
                                
				org.apache.juddi.model.BusinessService modelBusinessService = new org.apache.juddi.model.BusinessService();
				modelBusinessService.setEntityKey(apiBindingTemplate.getServiceKey());
				
				MappingApiToModel.mapBindingTemplate(apiBindingTemplate, modelBindingTemplate, modelBusinessService);
	
				setOperationalInfo(em, modelBindingTemplate, publisher, false);
	
				em.persist(modelBindingTemplate);
				
				result.getBindingTemplate().add(apiBindingTemplate);
                                result.getListDescription().setActualCount(result.getListDescription().getActualCount()+1);
                                result.getListDescription().setIncludeCount(result.getListDescription().getIncludeCount()+1);
				validator.validateSaveBindingMax(em, modelBindingTemplate.getBusinessService().getEntityKey());
			}
	
			tx.commit();
                        long procTime = System.currentTimeMillis() - startTime;
                        serviceCounter.update(PublicationQuery.SAVE_BINDING, 
                                QueryStatus.SUCCESS, procTime);                      

			return result;
                } catch (DispositionReportFaultMessage drfm) {
                    long procTime = System.currentTimeMillis() - startTime;
                    serviceCounter.update(PublicationQuery.SAVE_BINDING, 
                            QueryStatus.FAILED, procTime);                      
                    throw drfm;                                                                 
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}


	public BusinessDetail saveBusiness(SaveBusiness body)
			throws DispositionReportFaultMessage {
	        long startTime = System.currentTimeMillis();
               if (!body.getBusinessEntity().isEmpty()) {
                log.debug("Inbound save business request for key " + body.getBusinessEntity().get(0).getBusinessKey());
                 }
                EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			UddiEntityPublisher publisher = this.getEntityPublisher(em, body.getAuthInfo());
			
			ValidatePublish validator = new ValidatePublish(publisher);
			validator.validateSaveBusiness(em, body, null);
	
			BusinessDetail result = new BusinessDetail();
			
			List<org.uddi.api_v3.BusinessEntity> apiBusinessEntityList = body.getBusinessEntity();
			for (org.uddi.api_v3.BusinessEntity apiBusinessEntity : apiBusinessEntityList) {
				
				org.apache.juddi.model.BusinessEntity modelBusinessEntity = new org.apache.juddi.model.BusinessEntity();
				
				MappingApiToModel.mapBusinessEntity(apiBusinessEntity, modelBusinessEntity);

				setOperationalInfo(em, modelBusinessEntity, publisher);
	
				em.persist(modelBusinessEntity);
	
				result.getBusinessEntity().add(apiBusinessEntity);
			}
			
			//check how many business this publisher owns.
			validator.validateSaveBusinessMax(em);
	
			tx.commit();
                        long procTime = System.currentTimeMillis() - startTime;
                        serviceCounter.update(PublicationQuery.SAVE_BUSINESS, 
                                QueryStatus.SUCCESS, procTime);                      

			return result;
                } catch (DispositionReportFaultMessage drfm) {
                    long procTime = System.currentTimeMillis() - startTime;
                    serviceCounter.update(PublicationQuery.SAVE_BUSINESS, 
                            QueryStatus.FAILED, procTime);                      
                    throw drfm;                                                                 	
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}


	public ServiceDetail saveService(SaveService body)
			throws DispositionReportFaultMessage {
	        long startTime = System.currentTimeMillis();

		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
	
			UddiEntityPublisher publisher = this.getEntityPublisher(em, body.getAuthInfo());
			
			ValidatePublish validator = new ValidatePublish(publisher);
			validator.validateSaveService(em, body, null);
			
			ServiceDetail result = new ServiceDetail();
	
			List<org.uddi.api_v3.BusinessService> apiBusinessServiceList = body.getBusinessService();
			for (org.uddi.api_v3.BusinessService apiBusinessService : apiBusinessServiceList) {
				
				org.apache.juddi.model.BusinessService modelBusinessService = new org.apache.juddi.model.BusinessService();
				org.apache.juddi.model.BusinessEntity modelBusinessEntity = new org.apache.juddi.model.BusinessEntity();
				modelBusinessEntity.setEntityKey(apiBusinessService.getBusinessKey());
				
				MappingApiToModel.mapBusinessService(apiBusinessService, modelBusinessService, modelBusinessEntity);
	
				setOperationalInfo(em, modelBusinessService, publisher, false);

				em.persist(modelBusinessService);
				
				result.getBusinessService().add(apiBusinessService);
				
				validator.validateSaveServiceMax(em, modelBusinessService.getBusinessEntity().getEntityKey());
			}
			
			
			tx.commit();
                        long procTime = System.currentTimeMillis() - startTime;
                        serviceCounter.update(PublicationQuery.SAVE_SERVICE, 
                                QueryStatus.SUCCESS, procTime);                      

			return result;
                } catch (DispositionReportFaultMessage drfm) {
                    long procTime = System.currentTimeMillis() - startTime;
                    serviceCounter.update(PublicationQuery.SAVE_SERVICE, 
                            QueryStatus.FAILED, procTime);                      
                    throw drfm;                                                                         			
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}


	public TModelDetail saveTModel(SaveTModel body)
			throws DispositionReportFaultMessage {
	        long startTime = System.currentTimeMillis();

		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
	
			UddiEntityPublisher publisher = this.getEntityPublisher(em, body.getAuthInfo());
	
			new ValidatePublish(publisher).validateSaveTModel(em, body, null);
	
			TModelDetail result = new TModelDetail();
	
			List<org.uddi.api_v3.TModel> apiTModelList = body.getTModel();
			for (org.uddi.api_v3.TModel apiTModel : apiTModelList) {
				
				org.apache.juddi.model.Tmodel modelTModel = new org.apache.juddi.model.Tmodel();
				
				MappingApiToModel.mapTModel(apiTModel, modelTModel);
	
				setOperationalInfo(em, modelTModel, publisher);
	
				em.persist(modelTModel);
				
				result.getTModel().add(apiTModel);
				
			}
	
			tx.commit();
                        long procTime = System.currentTimeMillis() - startTime;
                        serviceCounter.update(PublicationQuery.SAVE_TMODEL, 
                                QueryStatus.SUCCESS, procTime);                      

			return result;
                } catch (DispositionReportFaultMessage drfm) {
                    long procTime = System.currentTimeMillis() - startTime;
                    serviceCounter.update(PublicationQuery.SAVE_TMODEL, 
                            QueryStatus.FAILED, procTime);                      
                    throw drfm;                                                                                                 
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}


	public void setPublisherAssertions(String authInfo,
			Holder<List<PublisherAssertion>> publisherAssertion)
			throws DispositionReportFaultMessage {
	        long startTime = System.currentTimeMillis();

		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
	
			UddiEntityPublisher publisher = this.getEntityPublisher(em, authInfo);
			
			new ValidatePublish(publisher).validateSetPublisherAssertions(em, publisherAssertion);
			
			List<?> businessKeysFound = null;
			businessKeysFound = FindBusinessByPublisherQuery.select(em, null, publisher, businessKeysFound);
	
			// First, wipe out all previous assertions associated with this publisher
			DeletePublisherAssertionByBusinessQuery.delete(em, businessKeysFound);
			
			// Slate is clean for all assertions involving this publisher, now we simply need to add the new ones (and they will all be "new").
			List<org.uddi.api_v3.PublisherAssertion> apiPubAssertionList = publisherAssertion.value;
			for (org.uddi.api_v3.PublisherAssertion apiPubAssertion : apiPubAssertionList) {
				
				org.apache.juddi.model.PublisherAssertion modelPubAssertion = new org.apache.juddi.model.PublisherAssertion();
				
				MappingApiToModel.mapPublisherAssertion(apiPubAssertion, modelPubAssertion);
				
				org.apache.juddi.model.BusinessEntity beFrom = em.find(org.apache.juddi.model.BusinessEntity.class, modelPubAssertion.getId().getFromKey());
				org.apache.juddi.model.BusinessEntity beTo = em.find(org.apache.juddi.model.BusinessEntity.class, modelPubAssertion.getId().getToKey());
				modelPubAssertion.setBusinessEntityByFromKey(beFrom);
				modelPubAssertion.setBusinessEntityByToKey(beTo);
				
				modelPubAssertion.setFromCheck("false");
				modelPubAssertion.setToCheck("false");
				
				em.persist(modelPubAssertion);
	
				if (publisher.isOwner(modelPubAssertion.getBusinessEntityByFromKey()))
					modelPubAssertion.setFromCheck("true");
				if (publisher.isOwner(modelPubAssertion.getBusinessEntityByToKey()))
					modelPubAssertion.setToCheck("true");
				
			}
	
			tx.commit();
                        long procTime = System.currentTimeMillis() - startTime;
                        serviceCounter.update(PublicationQuery.SET_PUBLISHERASSERTIONS, 
                                QueryStatus.SUCCESS, procTime);                      
                } catch (DispositionReportFaultMessage drfm) {
                    long procTime = System.currentTimeMillis() - startTime;
                    serviceCounter.update(PublicationQuery.SET_PUBLISHERASSERTIONS, 
                            QueryStatus.FAILED, procTime);                      
                    throw drfm;                                                                                                 
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}

	private void setOperationalInfo(EntityManager em, org.apache.juddi.model.BusinessEntity uddiEntity, UddiEntityPublisher publisher) throws DispositionReportFaultMessage {

		uddiEntity.setAuthorizedName(publisher.getAuthorizedName());

		Date now = new Date();
		uddiEntity.setModified(now);
		uddiEntity.setModifiedIncludingChildren(now);

		String nodeId = "";
		try 
		{ nodeId = AppConfig.getConfiguration().getString(Property.JUDDI_NODE_ID); } 
		catch (ConfigurationException ce) 
		{ throw new FatalErrorException(new ErrorMessage("errors.configuration.Retrieval", Property.JUDDI_NODE_ID)); }
		uddiEntity.setNodeId(nodeId);
		
		org.apache.juddi.model.BusinessEntity existingUddiEntity = em.find(uddiEntity.getClass(), uddiEntity.getEntityKey());
		if (existingUddiEntity != null)
			uddiEntity.setCreated(existingUddiEntity.getCreated());
		else
			uddiEntity.setCreated(now);
		
		List<org.apache.juddi.model.BusinessService> serviceList = uddiEntity.getBusinessServices();
		for (org.apache.juddi.model.BusinessService service : serviceList)
			setOperationalInfo(em, service, publisher, true);
		
		
		if (existingUddiEntity != null)
			em.remove(existingUddiEntity);
		
	}

	private void setOperationalInfo(EntityManager em, org.apache.juddi.model.BusinessService uddiEntity, UddiEntityPublisher publisher, boolean isChild) throws DispositionReportFaultMessage {

		uddiEntity.setAuthorizedName(publisher.getAuthorizedName());

		Date now = new Date();
		uddiEntity.setModified(now);
		uddiEntity.setModifiedIncludingChildren(now);
		
		if(!isChild) {
			org.apache.juddi.model.BusinessEntity parent = em.find(org.apache.juddi.model.BusinessEntity.class, uddiEntity.getBusinessEntity().getEntityKey());
			parent.setModifiedIncludingChildren(now);
			em.persist(parent);
		}

		String nodeId = "";
		try 
		{ nodeId = AppConfig.getConfiguration().getString(Property.JUDDI_NODE_ID); } 
		catch (ConfigurationException ce) 
		{ throw new FatalErrorException(new ErrorMessage("errors.configuration.Retrieval", Property.JUDDI_NODE_ID)); }
		uddiEntity.setNodeId(nodeId);
		
		org.apache.juddi.model.BusinessService existingUddiEntity = em.find(uddiEntity.getClass(), uddiEntity.getEntityKey());
		if (existingUddiEntity != null) {
			uddiEntity.setCreated(existingUddiEntity.getCreated());
		}
		else
			uddiEntity.setCreated(now);
		
		List<org.apache.juddi.model.BindingTemplate> bindingList = uddiEntity.getBindingTemplates();
		for (org.apache.juddi.model.BindingTemplate binding : bindingList)
			setOperationalInfo(em, binding, publisher, true);
		
		
		if (existingUddiEntity != null)
			em.remove(existingUddiEntity);
		
	}

	private void setOperationalInfo(EntityManager em, org.apache.juddi.model.BindingTemplate uddiEntity, UddiEntityPublisher publisher, boolean isChild) throws DispositionReportFaultMessage {

		uddiEntity.setAuthorizedName(publisher.getAuthorizedName());

		Date now = new Date();
		uddiEntity.setModified(now);
		uddiEntity.setModifiedIncludingChildren(now);

		if(!isChild) {
			org.apache.juddi.model.BusinessService parent = em.find(org.apache.juddi.model.BusinessService.class, uddiEntity.getBusinessService().getEntityKey());
			parent.setModifiedIncludingChildren(now);
			em.persist(parent);
			
			// JUDDI-421:  now the businessEntity parent will have it's modifiedIncludingChildren set
			org.apache.juddi.model.BusinessEntity businessParent = em.find(org.apache.juddi.model.BusinessEntity.class, parent.getBusinessEntity().getEntityKey());
			businessParent.setModifiedIncludingChildren(now);
			em.persist(businessParent);
		}

		String nodeId = "";
		try 
		{ nodeId = AppConfig.getConfiguration().getString(Property.JUDDI_NODE_ID); } 
		catch (ConfigurationException ce) 
		{ throw new FatalErrorException(new ErrorMessage("errors.configuration.Retrieval", Property.JUDDI_NODE_ID)); }
		uddiEntity.setNodeId(nodeId);
		
		org.apache.juddi.model.BindingTemplate existingUddiEntity = em.find(uddiEntity.getClass(), uddiEntity.getEntityKey());
		if (existingUddiEntity != null)
			uddiEntity.setCreated(existingUddiEntity.getCreated());
		else
			uddiEntity.setCreated(now);
		
		if (existingUddiEntity != null)
			em.remove(existingUddiEntity);
		
	}
	
	private void setOperationalInfo(EntityManager em, org.apache.juddi.model.Tmodel uddiEntity, UddiEntityPublisher publisher) throws DispositionReportFaultMessage {

		uddiEntity.setAuthorizedName(publisher.getAuthorizedName());
		
		Date now = new Date();
		uddiEntity.setModified(now);
		uddiEntity.setModifiedIncludingChildren(now);

		String nodeId = "";
		try 
		{ nodeId = AppConfig.getConfiguration().getString(Property.JUDDI_NODE_ID); } 
		catch (ConfigurationException ce) 
		{ throw new FatalErrorException(new ErrorMessage("errors.configuration.Retrieval", Property.JUDDI_NODE_ID)); }
		uddiEntity.setNodeId(nodeId);
		
		org.apache.juddi.model.Tmodel existingUddiEntity = em.find(uddiEntity.getClass(), uddiEntity.getEntityKey());
		if (existingUddiEntity != null)
			uddiEntity.setCreated(existingUddiEntity.getCreated());
		else
			uddiEntity.setCreated(now);
		
		if (existingUddiEntity != null)
			em.remove(existingUddiEntity);
		
	}

	
}
