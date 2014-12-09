/**
 * OWLS查询服务接口声明
 */
package com.pku.wlj.owl_s_service;

import java.rmi.Remote;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import EDU.cmu.Atlas.owls1_1.profile.implementation.ProfileImpl;

/**
 * @author wlj
 *
 */
//@WebService(name = "OWL_S_Inquiry_PortType", targetNamespace = "urn:uddi-org:owl_s_service")
//@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@WebService
public interface OWL_SInquiryPortType extends Remote {
//	 @WebMethod(operationName = "find_profile", action = "find_profile")
//	    @WebResult(name = "bindingPrifle", targetNamespace = "urn:uddi-org:owl_s_service", partName = "body")
//	@WebMethod(exclude=true)
	public ArrayList<ProfileImpl> ProfileInquiryEntry(int service_id);
}
