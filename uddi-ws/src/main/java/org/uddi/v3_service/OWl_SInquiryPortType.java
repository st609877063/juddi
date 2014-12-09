package org.uddi.v3_service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.uddi.api_v3.FindBusiness;

import EDU.cmu.Atlas.owls1_1.grounding.WsdlGrounding;
/**
 * owl-s的查询接口
 * @author Administrator
 *
 */
@WebService(name = "OWL_S_Inquiry_PortType", targetNamespace = "urn:uddi-org:v3_service")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    org.uddi.custody_v3.ObjectFactory.class,
    org.uddi.repl_v3.ObjectFactory.class,
    org.uddi.subr_v3.ObjectFactory.class,
    org.uddi.api_v3.ObjectFactory.class,
    org.uddi.vscache_v3.ObjectFactory.class,
    org.uddi.vs_v3.ObjectFactory.class,
    org.uddi.sub_v3.ObjectFactory.class,
    org.w3._2000._09.xmldsig_.ObjectFactory.class,
    org.uddi.policy_v3.ObjectFactory.class,
    org.uddi.policy_v3_instanceparms.ObjectFactory.class
})
public interface OWl_SInquiryPortType extends Remote {
	
	@WebMethod(operationName = "find_wsdl_grounding", action = "find_wsdl_grounding")
    @WebResult(name = "wsdlgroundinglist", targetNamespace = "urn:uddi-org:api_v3", partName = "uri")
	public WsdlGrounding findWsdlGrounding(
			@WebParam(name = "find_business", targetNamespace = "urn:uddi-org:api_v3", partName = "uri") String uri)
	throws DispositionReportFaultMessage, RemoteException;
}
