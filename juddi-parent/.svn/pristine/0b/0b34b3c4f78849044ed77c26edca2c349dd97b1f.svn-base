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
package org.apache.juddi.v2.tck;

import java.util.Arrays;

import javax.xml.ws.BindingProvider;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.juddi.v3.client.UDDIv2Constants;
import org.apache.juddi.v3.client.config.UDDIClient;
import org.apache.juddi.v3.client.transport.JAXWSv2TranslationTransport;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.uddi.api_v2.*;
import org.uddi.v2_service.*;

/**
 * This test case exercises a number of the FindXXX API's in the UDDI Inquiry
 * spec. It also checks for the service catching invalid or incorrect
 * combinations of find qualifiers.<br><br>
 *
 * Most of the tests in this class reference's valid and invalid combinations of
 * Find Qualifiers. See <a
 * href="http://uddi.org/pubs/uddi-v3.0.2-20041019.htm#_Ref535479804">UDDI spec
 * on valid find qualifiers</a>
 *
 * http://uddi.org/pubs/ProgrammersAPI-V2.04-Published-20020719.htm#_Toc13195659
 *
 * @author <a href="mailto:jfaath@apache.org">Jeff Faath</a>
 * @author <a href="mailto:kstam@apache.org">Kurt T Stam</a>
 * @author <a href="mailto:alexoree@apache.org">Alex O'Ree</a>
 */
public class UDDI_070_FindEntityIntegrationTest {

        private static final Log logger = LogFactory.getLog(UDDI_070_FindEntityIntegrationTest.class);
        private static TckTModel tckTModel = null;
        private static TckBusiness tckBusiness = null;
        private static TckBusinessService tckBusinessService = null;
        private static TckBindingTemplate tckBindingTemplate = null;
        private static TckFindEntity tckFindEntity = null;
        private static String authInfoJoe = null;
        private static UDDIClient manager;
        private static Inquire inquiry = null;

        @AfterClass
        public static void stopManager() throws ConfigurationException {
                Assume.assumeTrue(TckPublisher.isEnabled());
                tckTModel.deleteCreatedTModels(authInfoJoe);
                manager.stop();
        }

        @BeforeClass
        public static void startManager() throws ConfigurationException {
                Assume.assumeTrue(TckPublisher.isEnabled());
                manager = new UDDIClient();
                manager.start();

                logger.debug("Getting auth tokens..");
                try {
                        JAXWSv2TranslationTransport transport = (JAXWSv2TranslationTransport) manager.getTransport("uddiv2");
                        Publish security = transport.getUDDIv2PublishService();
                        authInfoJoe = TckSecurity.getAuthToken(security, TckPublisher.getJoePublisherId(), TckPublisher.getJoePassword());
                        //Assert.assertNotNull(authInfoJoe);

                        Publish publication = transport.getUDDIv2PublishService();
                        inquiry = transport.getUDDIv2InquiryService();

                        if (!TckPublisher.isUDDIAuthMode()) {
                                TckSecurity.setCredentials((BindingProvider) publication, TckPublisher.getJoePublisherId(), TckPublisher.getJoePassword());
                                TckSecurity.setCredentials((BindingProvider) inquiry, TckPublisher.getJoePublisherId(), TckPublisher.getJoePassword());
                        }

                        tckTModel = new TckTModel(publication, inquiry);
                        tckBusiness = new TckBusiness(publication, inquiry);
                        tckBusinessService = new TckBusinessService(publication, inquiry);
                        tckBindingTemplate = new TckBindingTemplate(publication, inquiry);
                        tckFindEntity = new TckFindEntity(inquiry);

                } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                        Assert.fail("Could not obtain authInfo token.");
                }
        }

        @Test
        public void findEntities() {
                Assume.assumeTrue(TckPublisher.isEnabled());
                try {
                        tckTModel.saveJoePublisherTmodel(authInfoJoe, true);
                        tckBusiness.saveJoePublisherBusiness(authInfoJoe);
                        tckBusinessService.saveJoePublisherService(authInfoJoe);
                        tckBindingTemplate.saveJoePublisherBinding(authInfoJoe);
                        tckFindEntity.findBusiness();
                        tckFindEntity.findService(null);
                        tckFindEntity.findBinding(null);
                        tckFindEntity.findTModel(null);
                        tckFindEntity.getNonExitingBusiness();
                } catch (Exception e) {
                        e.printStackTrace();
                        Assert.fail(e.getMessage() + e.getClass().getCanonicalName());
                } catch (Throwable t) {
                        t.printStackTrace();
                        Assert.fail(t.getMessage() + t.getClass().getCanonicalName());
                } finally {
                        tckBindingTemplate.deleteJoePublisherBinding(authInfoJoe);
                        tckBusinessService.deleteJoePublisherService(authInfoJoe);
                        tckBusiness.deleteJoePublisherBusiness(authInfoJoe);
                        tckTModel.deleteJoePublisherTmodel(authInfoJoe);
                }
        }

        private void before() {
                tckTModel.saveJoePublisherTmodel(authInfoJoe, true);
                tckBusiness.saveJoePublisherBusiness(authInfoJoe);
                tckBusinessService.saveJoePublisherService(authInfoJoe);
        }

        private void after() {
                tckBusiness.deleteJoePublisherBusiness(authInfoJoe);
                tckTModel.deleteJoePublisherTmodel(authInfoJoe);
        }

        private void findbusinsess(String[] fq, String criteria) throws Exception {
                FindBusiness fb = new FindBusiness();
                //fb.setAuthInfo(authInfoJoe);
                fb.setGeneric("2.0");
                fb.setFindQualifiers(new FindQualifiers());
                fb.getFindQualifiers().getFindQualifier().addAll(Arrays.asList(fq));

                fb.getName().add(new Name(criteria, null));
                inquiry.findBusiness(fb);
        }

        private void findservice(String[] fq, String criteria) throws Exception {
                FindService fb = new FindService();
                //fb.setAuthInfo(authInfoJoe);
                fb.setGeneric("2.0");
                fb.setFindQualifiers(new FindQualifiers());
                fb.getFindQualifiers().getFindQualifier().addAll(Arrays.asList(fq));
                fb.getName().add(new Name(criteria, null));
                inquiry.findService(fb);
        }

        private void findtmodel(String[] fq, String criteria) throws Exception {
                FindTModel fb = new FindTModel();
                //fb.setAuthInfo(authInfoJoe);
                fb.setGeneric("2.0");
                fb.setFindQualifiers(new FindQualifiers());
                fb.getFindQualifiers().getFindQualifier().addAll(Arrays.asList(fq));
                fb.setName(new Name(criteria, null));
                inquiry.findTModel(fb);
        }

        private void findbinding(String[] fq) throws Exception {
                before();
                FindBinding fb = new FindBinding();
                //fb.setAuthInfo(authInfoJoe);
                fb.setGeneric("2.0");
                fb.setServiceKey(TckBusinessService.JOE_SERVICE_KEY);
                fb.setFindQualifiers(new FindQualifiers());
                fb.getFindQualifiers().getFindQualifier().addAll(Arrays.asList(fq));
                fb.setTModelBag(new TModelBag());
                fb.getTModelBag().getTModelKey().add("uuid:A035A07C-F362-44DD-8F95-E2B134BF43B4");
                //general key words
                inquiry.findBinding(fb);
                after();
        }

        private void findrelated(String[] fq) throws Exception {
                before();
                FindRelatedBusinesses fb = new FindRelatedBusinesses();
                fb.setBusinessKey(TckBusiness.JOE_BUSINESS_KEY);
                fb.setGeneric("2.0");
                //fb.setAuthInfo(authInfoJoe);
                fb.setFindQualifiers(new FindQualifiers());
                fb.getFindQualifiers().getFindQualifier().addAll(Arrays.asList(fq));
                inquiry.findRelatedBusinesses(fb);
                after();
        }

        @Test
        public void exactNameMatch_1() throws Exception {
                findbusinsess(new String[]{UDDIv2Constants.exactNameMatch}, "Joe");
        }

        @Test
        public void exactNameMatch_2() throws Exception {
                findservice(new String[]{UDDIv2Constants.exactNameMatch}, "Joe");
        }

        @Test
        public void exactNameMatch_3() throws Exception {
                findtmodel(new String[]{UDDIv2Constants.exactNameMatch}, "Joe");
        }

        @Test
        public void exactNameMatch_4() throws Exception {
                try {
                        findbinding(new String[]{UDDIv2Constants.exactNameMatch});
                        Assert.fail("unexpected success");
                } catch (Exception ex) {
                        logger.info("Expected failure: " + ex.getMessage());
                        logger.debug("Expected failure: " + ex.getMessage(), ex);
                }
        }

        @Test
        public void exactNameMatch_5() throws Exception {
                try {
                        findrelated(new String[]{UDDIv2Constants.exactNameMatch});
                        Assert.fail("unexpected success");
                } catch (Exception ex) {
                        logger.info("Expected failure: " + ex.getMessage());
                        logger.debug("Expected failure: " + ex.getMessage(), ex);
                }
        }

        @Test
        public void caseSensitiveMatch_1() throws Exception {
                findbusinsess(new String[]{UDDIv2Constants.caseSensitiveMatch}, "Joe");
        }

        @Test
        public void caseSensitiveMatch_2() throws Exception {
                findservice(new String[]{UDDIv2Constants.caseSensitiveMatch}, "Joe");
        }

        @Test
        public void caseSensitiveMatch_3() throws Exception {
                findtmodel(new String[]{UDDIv2Constants.caseSensitiveMatch}, "Joe");
        }

        @Test
        public void caseSensitiveMatch_4() throws Exception {
                try {
                        findbinding(new String[]{UDDIv2Constants.caseSensitiveMatch});
                        Assert.fail("unexpected success");
                } catch (Exception ex) {
                        logger.info("Expected failure: " + ex.getMessage());
                        logger.debug("Expected failure: " + ex.getMessage(), ex);
                }
        }

        @Test
        public void caseSensitiveMatch_5() throws Exception {
                try {
                        findrelated(new String[]{UDDIv2Constants.caseSensitiveMatch});
                        Assert.fail("unexpected success");
                } catch (Exception ex) {
                        logger.info("Expected failure: " + ex.getMessage());
                        logger.debug("Expected failure: " + ex.getMessage(), ex);
                }
        }

        @Test
        public void sortByNameAsc_1() throws Exception {
                findbusinsess(new String[]{UDDIv2Constants.sortByNameAsc}, "Joe");
        }

        @Test
        public void sortByNameAsc_2() throws Exception {
                findservice(new String[]{UDDIv2Constants.sortByNameAsc}, "Joe");
        }

        @Test
        public void sortByNameAsc_3() throws Exception {
                findtmodel(new String[]{UDDIv2Constants.sortByNameAsc}, "Joe");
        }

        @Test
        public void sortByNameAsc_4() throws Exception {
                try {
                        findbinding(new String[]{UDDIv2Constants.sortByNameAsc});
                        Assert.fail("unexpected success");
                } catch (Exception ex) {
                        logger.info("Expected failure: " + ex.getMessage());
                        logger.debug("Expected failure: " + ex.getMessage(), ex);
                }
        }

        @Test
        public void sortByNameAsc_5() throws Exception {
                findrelated(new String[]{UDDIv2Constants.sortByNameAsc});
        }

        @Test
        public void sortByNameDesc_1() throws Exception {
                findbusinsess(new String[]{UDDIv2Constants.sortByNameDesc}, "Joe");
        }

        @Test
        public void sortByNameDesc_2() throws Exception {
                findservice(new String[]{UDDIv2Constants.sortByNameDesc}, "Joe");
        }

        @Test
        public void sortByNameDesc_3() throws Exception {
                findtmodel(new String[]{UDDIv2Constants.sortByNameDesc}, "Joe");
        }

        @Test
        public void sortByNameDesc_4() throws Exception {
                try {
                        findbinding(new String[]{UDDIv2Constants.sortByNameDesc});
                        Assert.fail("unexpected success");
                } catch (Exception ex) {
                        logger.info("Expected failure: " + ex.getMessage());
                        logger.debug("Expected failure: " + ex.getMessage(), ex);
                }
        }

        @Test
        public void sortByNameDesc_5() throws Exception {
                findrelated(new String[]{UDDIv2Constants.sortByNameDesc});
        }

        @Test
        public void sortByDateAsc_1() throws Exception {
                findbusinsess(new String[]{UDDIv2Constants.sortByDateAsc}, "Joe");
        }

        @Test
        public void sortByDateAsc_2() throws Exception {
                findservice(new String[]{UDDIv2Constants.sortByDateAsc}, "Joe");
        }

        @Test
        public void sortByDateAsc_3() throws Exception {
                findtmodel(new String[]{UDDIv2Constants.sortByDateAsc}, "Joe");
        }

        @Test
        public void sortByDateAsc_4() throws Exception {
                findbinding(new String[]{UDDIv2Constants.sortByDateAsc});
        }

        @Test
        public void sortByDateAsc_5() throws Exception {
                findrelated(new String[]{UDDIv2Constants.sortByDateAsc});
        }

        @Test
        public void sortByDateDesc_1() throws Exception {
                findbusinsess(new String[]{UDDIv2Constants.sortByDateDesc}, "Joe");
        }

        @Test
        public void sortByDateDesc_2() throws Exception {
                findservice(new String[]{UDDIv2Constants.sortByDateDesc}, "Joe");
        }

        @Test
        public void sortByDateDesc_3() throws Exception {
                findtmodel(new String[]{UDDIv2Constants.sortByDateDesc}, "Joe");
        }

        @Test
        public void sortByDateDesc_4() throws Exception {
                findbinding(new String[]{UDDIv2Constants.sortByDateDesc});
        }

        @Test
        public void sortByDateDesc_5() throws Exception {
                findrelated(new String[]{UDDIv2Constants.sortByDateDesc});
        }

        @Test
        public void orLikeKeys_1() throws Exception {
                findbusinsess(new String[]{UDDIv2Constants.orLikeKeys}, "Joe");
        }

        @Test
        public void orLikeKeys_2() throws Exception {
                findservice(new String[]{UDDIv2Constants.orLikeKeys}, "Joe");
        }

        @Test
        public void orLikeKeys_3() throws Exception {
                findtmodel(new String[]{UDDIv2Constants.orLikeKeys}, "Joe");
        }

        @Test
        public void orLikeKeys_4() throws Exception {
                try {
                        findbinding(new String[]{UDDIv2Constants.orLikeKeys});
                        Assert.fail("unexpected success");
                } catch (Exception ex) {
                        logger.info("Expected failure: " + ex.getMessage());
                        logger.debug("Expected failure: " + ex.getMessage(), ex);
                }
        }

        @Test
        public void orLikeKeys_5() throws Exception {
                try {
                        findrelated(new String[]{UDDIv2Constants.orLikeKeys});
                        Assert.fail("unexpected success");
                } catch (Exception ex) {
                        logger.info("Expected failure: " + ex.getMessage());
                        logger.debug("Expected failure: " + ex.getMessage(), ex);
                }
        }

        @Test
        public void orAllKeys_1() throws Exception {
                findbusinsess(new String[]{UDDIv2Constants.orAllKeys}, "Joe");
        }

        @Test
        public void orAllKeys_2() throws Exception {
                findservice(new String[]{UDDIv2Constants.orAllKeys}, "Joe");
        }

        @Test
        public void orAllKeys_3() throws Exception {
                findtmodel(new String[]{UDDIv2Constants.orAllKeys}, "Joe");
        }

        /**
         * This test should pass, but juddi fails for some reason with business
         * service not found
         *
         * @throws Exception
         */
        @Test
        public void orAllKeys_4() throws Exception {
                logger.info("Hello world!");
                try {
                        findbinding(new String[]{UDDIv2Constants.orAllKeys});

                } catch (Exception ex) {
                        logger.error("fail", ex);
                        throw ex;
                }
        }

        @Test
        public void orAllKeys_5() throws Exception {
                try {
                        findrelated(new String[]{UDDIv2Constants.orAllKeys});
                        Assert.fail("unexpected success");
                } catch (Exception ex) {
                        logger.info("Expected failure: " + ex.getMessage());
                        logger.debug("Expected failure: " + ex.getMessage(), ex);
                }
        }

        @Test
        public void combineCategoryBags_1() throws Exception {
                findbusinsess(new String[]{UDDIv2Constants.combineCategoryBags}, "Joe");
        }

        @Test
        public void combineCategoryBags_2() throws Exception {
                try {
                        findservice(new String[]{UDDIv2Constants.combineCategoryBags}, "Joe");
                        Assert.fail("unexpected success");
                } catch (Exception ex) {
                        logger.info("Expected failure: " + ex.getMessage());
                        logger.debug("Expected failure: " + ex.getMessage(), ex);
                }
        }

        @Test
        public void combineCategoryBags_3() throws Exception {
                try {
                        findtmodel(new String[]{UDDIv2Constants.combineCategoryBags}, "Joe");
                        Assert.fail("unexpected success");
                } catch (Exception ex) {
                        logger.info("Expected failure: " + ex.getMessage());
                        logger.debug("Expected failure: " + ex.getMessage(), ex);
                }
        }

        @Test
        public void combineCategoryBags_4() throws Exception {
                try {
                        findbinding(new String[]{UDDIv2Constants.combineCategoryBags});
                        Assert.fail("unexpected success");
                } catch (Exception ex) {
                        logger.info("Expected failure: " + ex.getMessage());
                        logger.debug("Expected failure: " + ex.getMessage(), ex);
                }
        }

        @Test
        public void combineCategoryBags_5() throws Exception {
                try {
                        findrelated(new String[]{UDDIv2Constants.combineCategoryBags});
                        Assert.fail("unexpected success");
                } catch (Exception ex) {
                        logger.info("Expected failure: " + ex.getMessage());
                        logger.debug("Expected failure: " + ex.getMessage(), ex);
                }
        }

        @Test
        public void serviceSubset_1() throws Exception {
                findbusinsess(new String[]{UDDIv2Constants.serviceSubset}, "Joe");
        }

        @Test
        public void serviceSubset_2() throws Exception {
                try {
                        findservice(new String[]{UDDIv2Constants.serviceSubset}, "Joe");
                        Assert.fail("unexpected success");
                } catch (Exception ex) {
                        logger.info("Expected failure: " + ex.getMessage());
                        logger.debug("Expected failure: " + ex.getMessage(), ex);
                }
        }

        @Test
        public void serviceSubset_3() throws Exception {
                try {
                        findtmodel(new String[]{UDDIv2Constants.serviceSubset}, "Joe");
                        Assert.fail("unexpected success");
                } catch (Exception ex) {
                        logger.info("Expected failure: " + ex.getMessage());
                        logger.debug("Expected failure: " + ex.getMessage(), ex);
                }
        }

        @Test
        public void serviceSubset_4() throws Exception {
                try {
                        findbinding(new String[]{UDDIv2Constants.serviceSubset});
                        Assert.fail("unexpected success");
                } catch (Exception ex) {
                        logger.info("Expected failure: " + ex.getMessage());
                        logger.debug("Expected failure: " + ex.getMessage(), ex);
                }
        }

        @Test
        public void serviceSubset_5() throws Exception {
                try {
                        findrelated(new String[]{UDDIv2Constants.serviceSubset});
                        Assert.fail("unexpected success");
                } catch (Exception ex) {
                        logger.info("Expected failure: " + ex.getMessage());
                        logger.debug("Expected failure: " + ex.getMessage(), ex);
                }
        }

        @Test
        public void andAllKeys_1() throws Exception {
                findbusinsess(new String[]{UDDIv2Constants.andAllKeys}, "Joe");
        }

        @Test
        public void andAllKeys_2() throws Exception {
                try {
                        findservice(new String[]{UDDIv2Constants.andAllKeys}, "Joe");
                        Assert.fail("unexpected success");
                } catch (Exception ex) {
                        logger.info("Expected failure: " + ex.getMessage());
                        logger.debug("Expected failure: " + ex.getMessage(), ex);
                }
        }

        @Test
        public void andAllKeys_3() throws Exception {
                findtmodel(new String[]{UDDIv2Constants.andAllKeys}, "Joe");
        }

        @Test
        public void andAllKeys_4() throws Exception {
                try {
                        findbinding(new String[]{UDDIv2Constants.andAllKeys});
                        Assert.fail("unexpected success");
                } catch (Exception ex) {
                        logger.info("Expected failure: " + ex.getMessage());
                        logger.debug("Expected failure: " + ex.getMessage(), ex);
                }
        }

        @Test
        public void andAllKeys_5() throws Exception {
                try {
                        findrelated(new String[]{UDDIv2Constants.andAllKeys});
                        Assert.fail("unexpected success");
                } catch (Exception ex) {
                        logger.info("Expected failure: " + ex.getMessage());
                        logger.debug("Expected failure: " + ex.getMessage(), ex);
                }
        }
}
