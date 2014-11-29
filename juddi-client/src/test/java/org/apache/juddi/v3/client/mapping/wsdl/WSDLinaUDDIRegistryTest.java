/*
 * Copyright 2001-2009 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.juddi.v3.client.mapping.wsdl;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.wsdl.Binding;
import javax.wsdl.Definition;
import javax.wsdl.PortType;
import javax.wsdl.WSDLException;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.juddi.jaxb.EntityCreator;
import org.apache.juddi.jaxb.PrintUDDI;
import org.apache.juddi.v3.client.UDDIConstants;
import org.apache.juddi.v3.client.mapping.URLLocalizerDefaultImpl;
import org.apache.juddi.v3.client.mapping.wsdl.ReadWSDL;
import org.apache.juddi.v3.client.mapping.wsdl.WSDL2UDDI;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.uddi.api_v3.BindingTemplate;
import org.uddi.api_v3.BusinessService;
import org.uddi.api_v3.BusinessServices;
import org.uddi.api_v3.KeyedReference;
import org.uddi.api_v3.TModel;
import org.uddi.v3_service.UDDISecurityPortType;

/**
 * @author <a href="mailto:kstam@apache.org">Kurt T Stam</a>
 * @author <a href="mailto:alexoree@apache.org">Alex O'Ree</a>
 */
public class WSDLinaUDDIRegistryTest {

        PrintUDDI<TModel> pTModel = new PrintUDDI<TModel>();
        static ReadWSDL rw = new ReadWSDL();
        static Definition wsdlDefinition = null;
        static Definition wsdlDefinitionLongDescriptions = null;
        static Properties properties = new Properties();
        static String wsdlURL = null;
        static boolean serialize = false;

        public WSDLinaUDDIRegistryTest() {
                if (System.getProperty("debug") != null && System.getProperty("debug").equalsIgnoreCase("true")) {
                        serialize = true;
                }
        }

        @BeforeClass
        public static void before() throws Exception {
                try {
                        wsdlDefinition = rw.readWSDL("wsdl/sample.wsdl");
                        wsdlDefinitionLongDescriptions = rw.readWSDL("wsdl/sample_1.wsdl");
                        properties.put("keyDomain", "uddi.joepublisher.com");
                        properties.put("businessName", "samplebusiness");
                        properties.put("serverName", "api.example.org");
                        properties.put("serverPort", "80");
                        wsdlURL = wsdlDefinition.getDocumentBaseURI();
                } catch (WSDLException e) {
                        e.printStackTrace();
                        Assert.fail(e.getMessage());
                }
        }

        @Test
        public void test_3_2_1_UDDI_portType_tModel() throws WSDLException, IOException, JAXBException, ConfigurationException {

                WSDL2UDDI wsdl2UDDI = new WSDL2UDDI(null, new URLLocalizerDefaultImpl(), properties);
                Set<TModel> tModels = new HashSet<TModel>();
                @SuppressWarnings("unchecked")
                Map<QName, PortType> portTypes = (Map<QName, PortType>) wsdlDefinition.getAllPortTypes();
                Set<TModel> portTypeTModels = wsdl2UDDI.createWSDLPortTypeTModels(wsdlURL, portTypes);
                tModels.addAll(portTypeTModels);

                Assert.assertEquals(1, tModels.size());

                TModel tModel = tModels.iterator().next();
                System.out.println("UDDI PortType TModel " + tModel.getName().getValue());
                if (serialize) {
                        System.out.println(pTModel.print(tModel));
                }

                //now compare to the spec example
                String porttypeXml = "wsdl/uddiv3-xml/3_2_1_porttype.xml";
                TModel specTModel = (org.uddi.api_v3.TModel) EntityCreator.buildFromDoc(porttypeXml, EntityCreator.UDDIv3_Package);

                //making sure the names are the same
                Assert.assertEquals(specTModel.getName().getValue(), tModel.getName().getValue());
                //We should have a overviewDoc with one overviewURL which should end with "/sample.wsdl"
                Assert.assertNotNull(tModel.getOverviewDoc());
                Assert.assertEquals(1, tModel.getOverviewDoc().size());
                Assert.assertNotNull(tModel.getOverviewDoc().get(0).getOverviewURL());

                Assert.assertTrue(specTModel.getOverviewDoc().get(0).getOverviewURL().getValue().endsWith("/sample.wsdl"));
                Assert.assertTrue(tModel.getOverviewDoc().get(0).getOverviewURL().getValue().endsWith("/sample.wsdl"));

                //We should have a categoryBag with 2 keyedReferences
                Assert.assertNotNull(tModel.getCategoryBag());
                Assert.assertNotNull(tModel.getCategoryBag().getKeyedReference());
                Assert.assertEquals(2, tModel.getCategoryBag().getKeyedReference().size());
                for (KeyedReference keyedReference : tModel.getCategoryBag().getKeyedReference()) {
                        boolean match = false;
                        Iterator<KeyedReference> iter = specTModel.getCategoryBag().getKeyedReference().iterator();
                        while (iter.hasNext() && match == false) {
                                KeyedReference specKeyedRef = iter.next();
                                if (specKeyedRef.getTModelKey().equals(keyedReference.getTModelKey())) {
                                        match = true;
                                        Assert.assertEquals(specKeyedRef.getKeyName(), keyedReference.getKeyName());
                                        Assert.assertEquals(specKeyedRef.getKeyValue(), keyedReference.getKeyValue());
                                }
                        }
                        //expecting a match for each keyedReference
                        Assert.assertTrue("Expected a match for keyedReference " + keyedReference.getTModelKey(), match);
                }
        }

        @Test
        public void test_3_2_2_UDDI_binding_tModel() throws WSDLException, JAXBException, IOException, ConfigurationException {

                WSDL2UDDI wsdl2UDDI = new WSDL2UDDI(null, new URLLocalizerDefaultImpl(), properties);
                @SuppressWarnings("unchecked")
                Map<QName, Binding> bindings = (Map<QName, Binding>) wsdlDefinition.getAllBindings();
                Set<TModel> tModels = wsdl2UDDI.createWSDLBindingTModels(wsdlURL, bindings);

                //Now check
                Assert.assertEquals(1, tModels.size());

                TModel tModel = tModels.iterator().next();
                System.out.println("UDDI Binding TModel " + tModel.getName().getValue());
                if (serialize) {
                        System.out.println(pTModel.print(tModel));
                }

                //Compare to the spec example
                String bindingtmodelXml = "wsdl/uddiv3-xml/3_2_2_bindingtmodel.xml";
                TModel specTModel = (org.uddi.api_v3.TModel) EntityCreator.buildFromDoc(bindingtmodelXml, EntityCreator.UDDIv3_Package);

                //Make sure the names are the same
                Assert.assertEquals(specTModel.getName().getValue(), tModel.getName().getValue());
                //We should have a overviewDoc with one overviewURL which should end with "/sample.wsdl"
                Assert.assertNotNull(tModel.getOverviewDoc());
                Assert.assertEquals(1, tModel.getOverviewDoc().size());
                Assert.assertNotNull(tModel.getOverviewDoc().get(0).getOverviewURL());

                //We should have a categoryBag with 6 keyedReferences
                Assert.assertNotNull(tModel.getCategoryBag());
                Assert.assertNotNull(tModel.getCategoryBag().getKeyedReference());
                Assert.assertEquals(6, tModel.getCategoryBag().getKeyedReference().size());
                for (KeyedReference keyedReference : tModel.getCategoryBag().getKeyedReference()) {
                        boolean match = false;
                        Iterator<KeyedReference> iter = specTModel.getCategoryBag().getKeyedReference().iterator();
                        while (iter.hasNext() && match == false) {
                                KeyedReference specKeyedRef = iter.next();
                                if (specKeyedRef.getTModelKey().equals(keyedReference.getTModelKey())) {
                                        match = true;
                                        Assert.assertEquals(specKeyedRef.getKeyName(), keyedReference.getKeyName());
                                        Assert.assertEquals(specKeyedRef.getKeyValue(), keyedReference.getKeyValue());
                                }
                        }
                        //expecting a match for each keyedReference
                        Assert.assertTrue("Expected a match for keyedReference " + keyedReference.getTModelKey(), match);
                }
        }

        @Test
        public void test_3_2_3_UDDI_businessService_and_bindingTemplate() throws JAXBException, IOException, ConfigurationException {
                WSDL2UDDI wsdl2UDDI = new WSDL2UDDI(null, new URLLocalizerDefaultImpl(), properties);

                BusinessServices businessServices = wsdl2UDDI.createBusinessServices(wsdlDefinition);
                PrintUDDI<BusinessService> servicePrinter = new PrintUDDI<BusinessService>();

                Assert.assertEquals(1, businessServices.getBusinessService().size());

                BusinessService businessService = businessServices.getBusinessService().get(0);

                System.out.println(businessService.getName().get(0).getValue());
                if (serialize) {
                        System.out.println(servicePrinter.print(businessService));
                }

                //Compare to the spec example
                String businessServiceXml = "wsdl/uddiv3-xml/3_2_3_business_service.xml";
                BusinessService specBusinessService = (org.uddi.api_v3.BusinessService) EntityCreator.buildFromDoc(businessServiceXml, EntityCreator.UDDIv3_Package);

                //Make sure the names are the same
                Assert.assertEquals(specBusinessService.getName().get(0).getValue(), businessService.getName().get(0).getValue());
                //We should have a overviewDoc with one overviewURL which should end with "/sample.wsdl"
                Assert.assertNotNull(businessService.getBindingTemplates());
                Assert.assertEquals(1, businessService.getBindingTemplates().getBindingTemplate().size());
                BindingTemplate bindingTemplate = businessService.getBindingTemplates().getBindingTemplate().get(0);
                Assert.assertNotNull(bindingTemplate);
                BindingTemplate specBindingTemplate = specBusinessService.getBindingTemplates().getBindingTemplate().get(0);

                Assert.assertEquals(specBindingTemplate.getBindingKey(), bindingTemplate.getBindingKey());
                Assert.assertEquals(specBindingTemplate.getServiceKey(), bindingTemplate.getServiceKey());
                Assert.assertEquals(specBindingTemplate.getAccessPoint().getValue(), bindingTemplate.getAccessPoint().getValue());
                Assert.assertTrue(2 <= bindingTemplate.getTModelInstanceDetails().getTModelInstanceInfo().size());
                //first binding/tmodelInstanceDetails
                Assert.assertEquals(specBindingTemplate.getTModelInstanceDetails().getTModelInstanceInfo().get(0).getTModelKey(),
                        bindingTemplate.getTModelInstanceDetails().getTModelInstanceInfo().get(0).getTModelKey());
                Assert.assertEquals(specBindingTemplate.getTModelInstanceDetails().getTModelInstanceInfo().get(0).getInstanceDetails().getInstanceParms(),
                        bindingTemplate.getTModelInstanceDetails().getTModelInstanceInfo().get(0).getInstanceDetails().getInstanceParms());
                //second binding/tmodelInstanceDetails
                Assert.assertEquals(specBindingTemplate.getTModelInstanceDetails().getTModelInstanceInfo().get(1).getTModelKey(),
                        bindingTemplate.getTModelInstanceDetails().getTModelInstanceInfo().get(1).getTModelKey());

                //Compare categoryBag
                //We should have a categoryBag with 3 keyedReferences
                Assert.assertNotNull(businessService.getCategoryBag());
                Assert.assertNotNull(businessService.getCategoryBag().getKeyedReference());
                Assert.assertEquals(3, businessService.getCategoryBag().getKeyedReference().size());
                for (KeyedReference keyedReference : businessService.getCategoryBag().getKeyedReference()) {
                        boolean match = false;
                        Iterator<KeyedReference> iter = specBusinessService.getCategoryBag().getKeyedReference().iterator();
                        while (iter.hasNext() && match == false) {
                                KeyedReference specKeyedRef = iter.next();
                                if (specKeyedRef.getTModelKey().equals(keyedReference.getTModelKey())) {
                                        match = true;
                                        Assert.assertEquals(specKeyedRef.getKeyName(), keyedReference.getKeyName());
                                        Assert.assertEquals(specKeyedRef.getKeyValue(), keyedReference.getKeyValue());
                                }
                        }
                        //expecting a match for each keyedReference
                        Assert.assertTrue("Expected a match for keyedReference " + keyedReference.getTModelKey(), match);
                }

        }

        @Test
        public void test_3_2_3_UDDI_businessService_and_bindingTemplateLongDescriptions() throws JAXBException, IOException, ConfigurationException {
                WSDL2UDDI wsdl2UDDI = new WSDL2UDDI(null, new URLLocalizerDefaultImpl(), properties);

                BusinessServices businessServices = wsdl2UDDI.createBusinessServices(wsdlDefinitionLongDescriptions);
                PrintUDDI<BusinessService> servicePrinter = new PrintUDDI<BusinessService>();

                Assert.assertEquals(1, businessServices.getBusinessService().size());

                BusinessService businessService = businessServices.getBusinessService().get(0);

                System.out.println(businessService.getName().get(0).getValue());
                if (serialize) {
                        System.out.println(servicePrinter.print(businessService));
                }

                for (int i = 0; i < businessService.getDescription().size(); i++) {
                        Assert.assertTrue(businessService.getDescription().get(i).getValue().length() <= UDDIConstants.MAX_description_length);
                        Assert.assertTrue(businessService.getDescription().get(i).getLang().length() <= UDDIConstants.MAX_xml_lang_length);
                }
                if (businessService.getBindingTemplates() != null) {
                        for (int i = 0; i < businessService.getBindingTemplates().getBindingTemplate().size(); i++) {
                                for (int k = 0; k < businessService.getBindingTemplates().getBindingTemplate().get(i).getDescription().size(); k++) {
                                        for (int i2 = 0; i2 < businessService.getBindingTemplates().getBindingTemplate().get(i).getDescription().size(); i2++) {
                                                Assert.assertTrue(Integer.toString(businessService.getBindingTemplates().getBindingTemplate().get(i).getDescription().get(i2).getValue().length()), businessService.getBindingTemplates().getBindingTemplate().get(i).getDescription().get(i2).getValue().length() <= UDDIConstants.MAX_description_length);
                                                Assert.assertTrue(businessService.getBindingTemplates().getBindingTemplate().get(i).getDescription().get(i2).getLang().length() <= UDDIConstants.MAX_xml_lang_length);
                                        }
                                }

                        }
                }

        }

}
