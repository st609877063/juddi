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
package org.apache.juddi.validation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Hashtable;
import java.util.Map;
import org.apache.juddi.api.impl.UDDIv2InquiryImpl;

import org.uddi.api_v2.*;
import org.uddi.v2_service.DispositionReport;

import org.apache.juddi.v3.client.UDDIv2Constants;
import org.apache.juddi.v3.client.mapping.MapUDDIv3Tov2;
import org.apache.juddi.v3.error.ErrorMessage;
import org.apache.juddi.v3.error.FatalErrorException;
import org.apache.juddi.v3.error.InvalidCombinationException;
import org.apache.juddi.v3.error.InvalidKeyPassedException;
import org.apache.juddi.v3.error.UnsupportedException;
import org.apache.juddi.v3.error.ValueNotAllowedException;
import org.uddi.v3_service.DispositionReportFaultMessage;

/**
 * This class handles validation for uddi v2 inquiry functions
 *
 * @author <a href="mailto:alexoree@apache.org">Alex O'Ree</a>
 */
public class ValidateInquiryv2 {

        public static final String VER = "2.0";

        public static void validateGetBusinessDetail(GetBusinessDetail body) throws DispositionReport {

                // No null input
                if (body == null) {
                        throw MapUDDIv3Tov2.MapException(new FatalErrorException(new ErrorMessage("errors.NullInput")),UDDIv2InquiryImpl.getNodeID());
                }
                validateVersion(body.getGeneric());

                // No null or empty list
                List<String> entityKeyList = body.getBusinessKey();
                if (entityKeyList == null || entityKeyList.size() == 0) {
                         throw MapUDDIv3Tov2.MapException(new InvalidKeyPassedException(new ErrorMessage("errors.invalidkey.NoKeys")),UDDIv2InquiryImpl.getNodeID());
                }

                HashSet<String> dupCheck = new HashSet<String>();
                int i = 0;
                for (String entityKey : entityKeyList) {

                        // Per section 4.4: keys must be case-folded
                        entityKey = entityKey.toLowerCase();
                        entityKeyList.set(i, entityKey);

                        boolean inserted = dupCheck.add(entityKey);
                        if (!inserted) {
                                 throw MapUDDIv3Tov2.MapException(new InvalidKeyPassedException(new ErrorMessage("errors.invalidkey.DuplicateKey", entityKey)),UDDIv2InquiryImpl.getNodeID());
                        }

                        i++;
                }
        }

        public static void validateGetServiceDetail(GetServiceDetail body) throws DispositionReport {

                // No null input
                if (body == null) {
                         throw MapUDDIv3Tov2.MapException(new FatalErrorException(new ErrorMessage("errors.NullInput")),UDDIv2InquiryImpl.getNodeID());
                }

                validateVersion(body.getGeneric());
                // No null or empty list
                List<String> entityKeyList = body.getServiceKey();
                if (entityKeyList == null || entityKeyList.size() == 0) {
                         throw MapUDDIv3Tov2.MapException(new InvalidKeyPassedException(new ErrorMessage("errors.invalidkey.NoKeys")),UDDIv2InquiryImpl.getNodeID());
                }

                HashSet<String> dupCheck = new HashSet<String>();
                int i = 0;
                for (String entityKey : entityKeyList) {

                        // Per section 4.4: keys must be case-folded
                        entityKey = entityKey.toLowerCase();
                        entityKeyList.set(i, entityKey);

                        boolean inserted = dupCheck.add(entityKey);
                        if (!inserted) {
                                 throw MapUDDIv3Tov2.MapException(new InvalidKeyPassedException(new ErrorMessage("errors.invalidkey.DuplicateKey", entityKey)),UDDIv2InquiryImpl.getNodeID());
                        }

                        i++;
                }
        }

        public static void validateGetBindingDetail(GetBindingDetail body) throws DispositionReport {

                // No null input
                if (body == null) {
                         throw MapUDDIv3Tov2.MapException(new FatalErrorException(new ErrorMessage("errors.NullInput")),UDDIv2InquiryImpl.getNodeID());
                }

                validateVersion(body.getGeneric());
                // No null or empty list
                List<String> entityKeyList = body.getBindingKey();
                if (entityKeyList == null || entityKeyList.size() == 0) {
                         throw MapUDDIv3Tov2.MapException(new InvalidKeyPassedException(new ErrorMessage("errors.invalidkey.NoKeys")),UDDIv2InquiryImpl.getNodeID());
                }

                HashSet<String> dupCheck = new HashSet<String>();
                int i = 0;
                for (String entityKey : entityKeyList) {

                        // Per section 4.4: keys must be case-folded
                        entityKey = entityKey.toLowerCase();
                        entityKeyList.set(i, entityKey);

                        boolean inserted = dupCheck.add(entityKey);
                        if (!inserted) {
                                 throw MapUDDIv3Tov2.MapException(new InvalidKeyPassedException(new ErrorMessage("errors.invalidkey.DuplicateKey", entityKey)),UDDIv2InquiryImpl.getNodeID());
                        }

                        i++;
                }
        }

        public static void validateGetTModelDetail(GetTModelDetail body) throws DispositionReport {

                // No null input
                if (body == null) {
                         throw MapUDDIv3Tov2.MapException(new FatalErrorException(new ErrorMessage("errors.NullInput")),UDDIv2InquiryImpl.getNodeID());
                }

                validateVersion(body.getGeneric());
                // No null or empty list
                List<String> entityKeyList = body.getTModelKey();
                if (entityKeyList == null || entityKeyList.size() == 0) {
                         throw MapUDDIv3Tov2.MapException(new InvalidKeyPassedException(new ErrorMessage("errors.invalidkey.NoKeys")),UDDIv2InquiryImpl.getNodeID());
                }

                HashSet<String> dupCheck = new HashSet<String>();
                int i = 0;
                for (String entityKey : entityKeyList) {

                        // Per section 4.4: keys must be case-folded
                        entityKey = entityKey.toLowerCase();
                        entityKeyList.set(i, entityKey);

                        boolean inserted = dupCheck.add(entityKey);
                        if (!inserted) {
                                 throw MapUDDIv3Tov2.MapException(new InvalidKeyPassedException(new ErrorMessage("errors.invalidkey.DuplicateKey", entityKey)),UDDIv2InquiryImpl.getNodeID());
                        }

                        i++;
                }
        }

        public static void validateFindBusiness(FindBusiness body) throws DispositionReport {
                // No null input
                if (body == null) {
                         throw MapUDDIv3Tov2.MapException(new FatalErrorException(new ErrorMessage("errors.NullInput")),UDDIv2InquiryImpl.getNodeID());
                }

                validateVersion(body.getGeneric());
                if (body.getCategoryBag() == null && body.getTModelBag() == null && body.getName().size() == 0
                     && body.getIdentifierBag() == null && body.getDiscoveryURLs() == null) {
                         throw MapUDDIv3Tov2.MapException(new FatalErrorException(new ErrorMessage("errors.findbusiness.NoInput")),UDDIv2InquiryImpl.getNodeID());
                }

                validateNames(body.getName());
                validateFindQualifiers(body.getFindQualifiers());
                validateFindBusinessesFindQualifiers(body.getFindQualifiers());
                validateTModelBag(body.getTModelBag());
                validateDiscoveryUrls(body.getDiscoveryURLs());
                validateIdentifierBag(body.getIdentifierBag());
                validateCategoryBag(body.getCategoryBag());

        }

        public static void validateFindService(FindService body) throws DispositionReport {
                // No null input
                if (body == null) {
                         throw MapUDDIv3Tov2.MapException(new  FatalErrorException(new ErrorMessage("errors.NullInput")),UDDIv2InquiryImpl.getNodeID());
                }
                validateVersion(body.getGeneric());

                if (body.getCategoryBag() == null
                     && (body.getTModelBag() == null || body.getTModelBag().getTModelKey().size() == 0)
                     && body.getName().size() == 0 && body.getBusinessKey() == null) {
                         throw MapUDDIv3Tov2.MapException(new FatalErrorException(new ErrorMessage("errors.findservice.NoInput")),UDDIv2InquiryImpl.getNodeID());
                }

                validateNames(body.getName());
                validateFindQualifiers(body.getFindQualifiers());
                validateFindServiceFindQualifiers(body.getFindQualifiers());
                validateTModelBag(body.getTModelBag());
                validateCategoryBag(body.getCategoryBag());

        }

        public static void validateFindBinding(FindBinding body) throws DispositionReport {
                // No null input
                if (body == null) {
                         throw MapUDDIv3Tov2.MapException(new FatalErrorException(new ErrorMessage("errors.NullInput")),UDDIv2InquiryImpl.getNodeID());
                }
                validateVersion(body.getGeneric());

                if (body.getServiceKey() == null && body.getTModelBag() == null) {
                         throw MapUDDIv3Tov2.MapException(new FatalErrorException(new ErrorMessage("errors.findbinding.NoInput")),UDDIv2InquiryImpl.getNodeID());
                }

                validateFindQualifiers(body.getFindQualifiers());
                validateTModelBag(body.getTModelBag());
                validateFindingBindingFindQualifiers(body.getFindQualifiers());

        }

        public static void validateFindTModel(FindTModel body, boolean nullAllowed) throws DispositionReport {
                if (body == null) {
                        // When FindTModel objects are embedded in other find calls, null is allowed.
                        if (nullAllowed) {
                                return;
                        } else {
                                 throw MapUDDIv3Tov2.MapException(new FatalErrorException(new ErrorMessage("errors.NullInput")),UDDIv2InquiryImpl.getNodeID());
                        }
                }
                validateVersion(body.getGeneric());

                if (body.getCategoryBag() == null && body.getIdentifierBag() == null && body.getName() == null) {
                         throw MapUDDIv3Tov2.MapException(new FatalErrorException(new ErrorMessage("errors.findtmodel.NoInput")),UDDIv2InquiryImpl.getNodeID());
                }

                validateFindQualifiers(body.getFindQualifiers());
                validateIdentifierBag(body.getIdentifierBag());
                validateCategoryBag(body.getCategoryBag());
                validateFindTModelFindQualifiers(body.getFindQualifiers());
        }

        public static void validateFindRelatedBusinesses(FindRelatedBusinesses body, boolean nullAllowed) throws DispositionReport {
                if (body == null) {
                        // When FindRelatedBusinesses objects are embedded in other find calls, null is allowed.
                        if (nullAllowed) {
                                return;
                        } else {
                                 throw MapUDDIv3Tov2.MapException(new FatalErrorException(new ErrorMessage("errors.NullInput")),UDDIv2InquiryImpl.getNodeID());
                        }
                }
                validateVersion(body.getGeneric());

                if ((body.getBusinessKey() == null || body.getBusinessKey().length() == 0)) {
                         throw MapUDDIv3Tov2.MapException(new FatalErrorException(new ErrorMessage("errors.findrelatedbusiness.NoInput")),UDDIv2InquiryImpl.getNodeID());
                }

                if (body.getBusinessKey() != null && body.getBusinessKey().length() > 0) {

                        // Per section 4.4: keys must be case-folded
                        body.setBusinessKey(body.getBusinessKey().toLowerCase());
                }

                KeyedReference keyedRef = body.getKeyedReference();
                if (keyedRef != null) {
                        if (keyedRef.getTModelKey() == null || keyedRef.getTModelKey().length() == 0
                             || keyedRef.getKeyName() == null || keyedRef.getKeyName().length() == 0
                             || keyedRef.getKeyValue() == null || keyedRef.getKeyValue().length() == 0) {
                                 throw MapUDDIv3Tov2.MapException(new ValueNotAllowedException(new ErrorMessage("errors.findrelatedbusiness.BlankKeyedRef")),UDDIv2InquiryImpl.getNodeID());
                        }

                        validateKeyedReference(keyedRef);
                }
                validateFindQualifiers(body.getFindQualifiers());
                validateFindRelatedBusinessesFindQualifiers(body.getFindQualifiers());
        }

        public static void validateNames(List<Name> names) throws DispositionReport {
                if (names != null) {
                        for (Name n : names) {
                                if (n.getValue() == null || n.getValue().length() == 0) {
                                         throw MapUDDIv3Tov2.MapException(new ValueNotAllowedException(new ErrorMessage("errors.names.NoValue")),UDDIv2InquiryImpl.getNodeID());
                                }
                                try{
                                        ValidatePublish.validateLang(n.getLang());
                                }catch (DispositionReportFaultMessage ex){
                                        throw MapUDDIv3Tov2.MapException(ex, UDDIv2InquiryImpl.getNodeID());
                                }
                        }
                }
        }

        public static void validateTModelBag(TModelBag tmodelBag) throws DispositionReport {
                // tmodelBag is optional
                if (tmodelBag == null) {
                        return;
                }

                if (tmodelBag.getTModelKey() == null || tmodelBag.getTModelKey().size() == 0) {
                         throw MapUDDIv3Tov2.MapException(new ValueNotAllowedException(new ErrorMessage("errors.tmodelbag.NoInput")),UDDIv2InquiryImpl.getNodeID());
                }

                List<String> keyList = tmodelBag.getTModelKey();
                int i = 0;
                for (String key : keyList) {
                        // Per section 4.4: keys must be case-folded
                        key = key.toLowerCase();
                        keyList.set(i, key);
                        i++;
                }

        }

        public static void validateDiscoveryUrls(DiscoveryURLs discUrls) throws DispositionReport {
                // Discovery Urls is optional
                if (discUrls == null) {
                        return;
                }

                // If discUrls does exist, it must have at least one element
                List<DiscoveryURL> discUrlList = discUrls.getDiscoveryURL();
                if (discUrlList == null || discUrlList.size() == 0) {
                         throw MapUDDIv3Tov2.MapException(new ValueNotAllowedException(new ErrorMessage("errors.discurls.NoInput")),UDDIv2InquiryImpl.getNodeID());
                }
        }

        public static void validateCategoryBag(CategoryBag categories) throws DispositionReport {

                // Category bag is optional
                if (categories == null) {
                        return;
                }

                // If category bag does exist, it must have at least one element
                List<KeyedReference> elems = categories.getKeyedReference();

                if ((elems == null || elems.size() == 0)) {
                         throw MapUDDIv3Tov2.MapException(new ValueNotAllowedException(new ErrorMessage("errors.categorybag.NoInput")),UDDIv2InquiryImpl.getNodeID());
                }

                for (KeyedReference elem : elems) {
                        validateKeyedReference(elem);
                }

        }

        public static void validateIdentifierBag(IdentifierBag identifiers) throws DispositionReport {

                // Identifier bag is optional
                if (identifiers == null) {
                        return;
                }

                // If category bag does exist, it must have at least one element
                List<KeyedReference> keyedRefList = identifiers.getKeyedReference();
                if (keyedRefList == null || keyedRefList.size() == 0) {
                         throw MapUDDIv3Tov2.MapException(new ValueNotAllowedException(new ErrorMessage("errors.identifierbag.NoInput")),UDDIv2InquiryImpl.getNodeID());
                }

                for (KeyedReference keyedRef : keyedRefList) {
                        validateKeyedReference(keyedRef);
                }
        }

        public static void validateKeyedReference(KeyedReference kr) throws DispositionReport {
                if (kr == null) {
                         throw MapUDDIv3Tov2.MapException(new ValueNotAllowedException(new ErrorMessage("errors.keyedreference.NullInput")),UDDIv2InquiryImpl.getNodeID());
                }

                // Keyed references must contain a tModelKey and keyValue
                if (kr.getTModelKey() == null || kr.getTModelKey().length() == 0) {
                         throw MapUDDIv3Tov2.MapException(new ValueNotAllowedException(new ErrorMessage("errors.keyedreference.NoTModelKey")),UDDIv2InquiryImpl.getNodeID());
                }

                // Per section 4.4: keys must be case-folded
                kr.setTModelKey(kr.getTModelKey().toLowerCase());

                if (kr.getKeyValue() == null || kr.getKeyValue().length() == 0) {
                         throw MapUDDIv3Tov2.MapException(new ValueNotAllowedException(new ErrorMessage("errors.keyedreference.NoKeyValue")),UDDIv2InquiryImpl.getNodeID());
                }
        }

        private static void validateFindQualifiers(FindQualifiers findQualifiers) throws DispositionReport {
                if (findQualifiers == null) {
                        return;
                }

                List<String> fqList = findQualifiers.getFindQualifier();
                if (fqList == null || fqList.size() == 0) {
                       return;
                }

                Hashtable<String, String> fqTable = new Hashtable<String, String>();
                for (String fq : fqList) {
                        String result = fqTable.put(fq.toUpperCase(), fq.toUpperCase());
                        if (result != null) {
                                 throw MapUDDIv3Tov2.MapException(new ValueNotAllowedException(new ErrorMessage("errors.findqualifiers.DuplicateValue", result)),UDDIv2InquiryImpl.getNodeID());
                        }

                        ValidateSupportedFindQualifier(fq);

                        // Invalid combo: andAllKeys, orAllKeys, and orLikeKeys
                        if (fq.equalsIgnoreCase(UDDIv2Constants.andAllKeys)) {
                                if (fqTable.get(UDDIv2Constants.orAllKeys.toUpperCase()) != null || fqTable.get(UDDIv2Constants.orLikeKeys.toUpperCase()) != null) {
                                         throw MapUDDIv3Tov2.MapException(new InvalidCombinationException(new ErrorMessage("errors.findqualifiers.InvalidCombo", fq + " & " + UDDIv2Constants.orAllKeys + " " + UDDIv2Constants.orLikeKeys)),UDDIv2InquiryImpl.getNodeID());
                                }
                        } else if (fq.equalsIgnoreCase(UDDIv2Constants.orLikeKeys)) {
                                if (fqTable.get(UDDIv2Constants.orAllKeys.toUpperCase()) != null || fqTable.get(UDDIv2Constants.andAllKeys.toUpperCase()) != null) {
                                         throw MapUDDIv3Tov2.MapException(new InvalidCombinationException(new ErrorMessage("errors.findqualifiers.InvalidCombo", fq + " & " + UDDIv2Constants.andAllKeys + " " + UDDIv2Constants.orLikeKeys)),UDDIv2InquiryImpl.getNodeID());
                                }
                        } else if (fq.equalsIgnoreCase(UDDIv2Constants.orAllKeys)) {
                                if (fqTable.get(UDDIv2Constants.orLikeKeys.toUpperCase()) != null || fqTable.get(UDDIv2Constants.andAllKeys.toUpperCase()) != null) {
                                         throw MapUDDIv3Tov2.MapException(new InvalidCombinationException(new ErrorMessage("errors.findqualifiers.InvalidCombo", fq + " & " + UDDIv2Constants.andAllKeys + " " + UDDIv2Constants.orLikeKeys)),UDDIv2InquiryImpl.getNodeID());
                                }
                        }

                        // Invalid combo: sortByNameAsc and sortByNameDesc
                        //handled by uddiv3
                        // Invalid combo: sortByDateAsc and sortByDateDesc
                        //handle by uddiv3
                        // Invalid combo: combineCategoryBags, serviceSubset and bindingSubset 
                        //handled by uddiv3
                }
        }

        private static void validateFindingBindingFindQualifiers(FindQualifiers findQualifiers) throws DispositionReport {
                if (findQualifiers == null) {
                        return;
                }
                for (int i = 0; i < findQualifiers.getFindQualifier().size(); i++) {
                        if (!findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.orAllKeys)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.sortByDateAsc)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.sortByDateDesc)) {
                                 throw MapUDDIv3Tov2.MapException(new UnsupportedException(new ErrorMessage("errors.Unsupported.findQualifier", findQualifiers.getFindQualifier().get(i))),UDDIv2InquiryImpl.getNodeID());
                        }

                }
        }

        private static void validateFindRelatedBusinessesFindQualifiers(FindQualifiers findQualifiers) throws DispositionReport {
                if (findQualifiers == null) {
                        return;
                }
                for (int i = 0; i < findQualifiers.getFindQualifier().size(); i++) {
                        if (!findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.sortByNameAsc)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.sortByNameDesc)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.sortByDateAsc)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.sortByDateDesc)) {
                                 throw MapUDDIv3Tov2.MapException(new UnsupportedException(new ErrorMessage("errors.Unsupported.findQualifier", findQualifiers.getFindQualifier().get(i))),UDDIv2InquiryImpl.getNodeID());
                        }
                }
        }

        private static void validateFindBusinessesFindQualifiers(FindQualifiers findQualifiers) throws DispositionReport {
                if (findQualifiers == null) {
                        return;
                }
                for (int i = 0; i < findQualifiers.getFindQualifier().size(); i++) {
                        if (!findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.exactNameMatch)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.caseSensitiveMatch)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.sortByNameAsc)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.sortByNameDesc)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.sortByDateAsc)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.sortByDateDesc)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.orLikeKeys)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.orAllKeys)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.serviceSubset)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.combineCategoryBags)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.andAllKeys)) {
                                 throw MapUDDIv3Tov2.MapException(new UnsupportedException(new ErrorMessage("errors.Unsupported.findQualifier", findQualifiers.getFindQualifier().get(i))),UDDIv2InquiryImpl.getNodeID());
                        }
                }
        }

        private static void validateFindServiceFindQualifiers(FindQualifiers findQualifiers) throws DispositionReport {
                if (findQualifiers == null) {
                        return;
                }
                for (int i = 0; i < findQualifiers.getFindQualifier().size(); i++) {
                        if (!findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.exactNameMatch)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.caseSensitiveMatch)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.sortByNameAsc)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.sortByNameDesc)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.sortByDateAsc)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.sortByDateDesc)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.orLikeKeys)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.orAllKeys) //&& !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.serviceSubset)
                             // && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.combineCategoryBags)
                             //&& !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.andAllKeys)
                             ) {
                                 throw MapUDDIv3Tov2.MapException(new UnsupportedException(new ErrorMessage("errors.Unsupported.findQualifier", findQualifiers.getFindQualifier().get(i))),UDDIv2InquiryImpl.getNodeID());
                        }
                }
        }

        private static void validateFindTModelFindQualifiers(FindQualifiers findQualifiers) throws DispositionReport {
                if (findQualifiers == null) {
                        return;
                }
                for (int i = 0; i < findQualifiers.getFindQualifier().size(); i++) {
                        if (!findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.exactNameMatch)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.caseSensitiveMatch)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.sortByNameAsc)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.sortByNameDesc)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.sortByDateAsc)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.sortByDateDesc)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.orLikeKeys)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.orAllKeys)
                             //&& !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.serviceSubset)
                             // && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.combineCategoryBags)
                             && !findQualifiers.getFindQualifier().get(i).equalsIgnoreCase(UDDIv2Constants.andAllKeys)) {
                                 throw MapUDDIv3Tov2.MapException(new UnsupportedException(new ErrorMessage("errors.Unsupported.findQualifier", findQualifiers.getFindQualifier().get(i))),UDDIv2InquiryImpl.getNodeID());
                        }
                }
        }

        static Map<String, Boolean> supportedFindqualifiers = null;

        private static void ValidateSupportedFindQualifier(String fq) throws DispositionReport {
                if (supportedFindqualifiers == null || supportedFindqualifiers.isEmpty()) {
                        InitFindQualifierMap();
                }
                if (supportedFindqualifiers.get(fq.toLowerCase()) == null) {
                         throw MapUDDIv3Tov2.MapException(new UnsupportedException(new ErrorMessage("errors.Unsupported.findQualifier", fq)),UDDIv2InquiryImpl.getNodeID());
                }
        }

        private static void InitFindQualifierMap() {
                supportedFindqualifiers = new HashMap<String, Boolean>();
                supportedFindqualifiers.put(UDDIv2Constants.andAllKeys.toLowerCase(), true);
                supportedFindqualifiers.put(UDDIv2Constants.caseSensitiveMatch.toLowerCase(), true);
                supportedFindqualifiers.put(UDDIv2Constants.combineCategoryBags.toLowerCase(), true);
                supportedFindqualifiers.put(UDDIv2Constants.exactNameMatch.toLowerCase(), true);
                supportedFindqualifiers.put(UDDIv2Constants.orAllKeys.toLowerCase(), true);
                supportedFindqualifiers.put(UDDIv2Constants.orLikeKeys.toLowerCase(), true);
                supportedFindqualifiers.put(UDDIv2Constants.serviceSubset.toLowerCase(), true);
                supportedFindqualifiers.put(UDDIv2Constants.sortByDateAsc.toLowerCase(), true);
                supportedFindqualifiers.put(UDDIv2Constants.sortByDateDesc.toLowerCase(), true);
                supportedFindqualifiers.put(UDDIv2Constants.sortByNameAsc.toLowerCase(), true);
                supportedFindqualifiers.put(UDDIv2Constants.sortByNameDesc.toLowerCase(), true);

        }

        private static void validateVersion(String generic) throws DispositionReport {
                if (!VER.equalsIgnoreCase(generic)) {
                        throw MapUDDIv3Tov2.MapException(new UnsupportedException(new ErrorMessage("E_unrecognizedVersion", generic)), UDDIv2InquiryImpl.getNodeID());
                }
        }

        public static void validateBusinessDetailExt(GetBusinessDetailExt body) throws DispositionReport {
                // No null input
                if (body == null) {
                         throw MapUDDIv3Tov2.MapException(new FatalErrorException(new ErrorMessage("errors.NullInput")),UDDIv2InquiryImpl.getNodeID());
                }

                validateVersion(body.getGeneric());
                if (body.getBusinessKey().isEmpty())
                        throw MapUDDIv3Tov2.MapException(new FatalErrorException(new ErrorMessage("errors.NullInput")),UDDIv2InquiryImpl.getNodeID());
                        
                
                
        }
}
