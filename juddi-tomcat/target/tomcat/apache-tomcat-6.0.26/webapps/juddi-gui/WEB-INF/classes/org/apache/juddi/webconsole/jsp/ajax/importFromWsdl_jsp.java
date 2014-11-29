package org.apache.juddi.webconsole.jsp.ajax;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.juddi.webconsole.resources.ResourceLoader;
import org.apache.juddi.v3.client.config.TokenResolver;
import org.uddi.api_v3.Name;
import org.uddi.api_v3.BusinessEntity;
import java.util.ArrayList;
import java.util.List;
import org.apache.juddi.webconsole.hub.builders.Printers;
import org.apache.commons.lang.StringEscapeUtils;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.wsdl.PortType;
import java.util.Map;
import org.uddi.api_v3.BusinessServices;
import org.apache.juddi.v3.client.mapping.wsdl.WSDL2UDDI;
import org.apache.juddi.v3.client.mapping.URLLocalizerDefaultImpl;
import java.util.Properties;
import javax.wsdl.Definition;
import org.apache.juddi.v3.client.mapping.wsdl.ReadWSDL;
import org.apache.juddi.v3.client.config.UDDIClerk;
import org.uddi.api_v3.TModel;
import java.net.URL;
import org.apache.juddi.webconsole.CrossSiteRequestForgeryException;
import org.apache.juddi.webconsole.hub.UddiHub;

public final class importFromWsdl_jsp extends org.apache.sling.scripting.jsp.jasper.runtime.HttpJspBase
    implements org.apache.sling.scripting.jsp.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/ajax/../csrf.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.sling.scripting.jsp.jasper.runtime.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.sling.scripting.jsp.jasper.runtime.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.sling.scripting.jsp.jasper.runtime.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    //this is to catch someone that bookmarked a page after selecting a language
    Cookie[] cookies3 = request.getCookies();
    if (cookies3 != null && cookies3.length > 0) {
        for (int i = 0; i < cookies3.length; i++) {
            if (cookies3[i] != null && cookies3[i].getName() != null && cookies3[i].getName().equalsIgnoreCase("locale")) {
                if (cookies3[i].getValue() != null) {
                    session.setAttribute("locale", cookies3[i].getValue());
                }
            }
        }
    }
    if (session.getAttribute("locale")==null){
        //last change, default to english
        session.setAttribute("locale", "en");
    }
    String currentNonce = null;

    if (request.getMethod().equalsIgnoreCase("post")) {

        if ((request.getParameter("nonce") == null || request.getParameter("nonce").isEmpty())) {
            //reject it
            session.removeAttribute("nonce");
            response.sendRedirect("index.jsp");
            UddiHub.log.warn( "CSRF Test failed, no nonce guid." + request.getRemoteAddr() + request.getRemoteUser());
            throw new CrossSiteRequestForgeryException();
        } else {

            String noncestr = (String) session.getAttribute("nonce");
            if (noncestr == null) {
                //no session variable to test against, reject it
                UddiHub.log.warn( "CSRF Test failed, no session guid." + request.getRemoteAddr() + request.getRemoteUser());
                session.removeAttribute("nonce");
                throw new CrossSiteRequestForgeryException("Cross Site Request Forgery");
            }
            String postedstr = request.getParameter("nonce");

            //check session against existing nonce, if match
            //generate new one, add to page and session
            //else redirect to index page
            if (noncestr.equals(postedstr)) {
                currentNonce = noncestr;
                //OK
                // current = UUID.randomUUID();
                //session.removeAttribute("nonce");
                // session.setAttribute("nonce", current.toString());
                UddiHub.log.debug("CSRF Test passed.");
            } else {
                //mismatch, reject it
                UddiHub.log.warn( "CSRF Test failed, session did not match nonce guid." + request.getRemoteAddr() + request.getRemoteUser());
                session.removeAttribute("nonce");
                throw new CrossSiteRequestForgeryException("Cross Site Request Forgery");
            }
        }
    } else {
        //HTTP GET or otherwise message
        if ((currentNonce == null) || currentNonce.isEmpty()) {
            currentNonce = (String)session.getAttribute("nonce");
            if (currentNonce == null) {
                currentNonce = java.util.UUID.randomUUID().toString();
            }
            session.setAttribute("nonce", currentNonce);
        }

    }


      out.write('\n');
      out.write('\n');

    if (request.getMethod().equalsIgnoreCase("POST")) {
        String method = request.getParameter("formaction");
        if (method != null && method.length() > 0) {

            if (method.equalsIgnoreCase("preview") || method.equalsIgnoreCase("save")) {
                UddiHub x = UddiHub.getInstance(application, session);
                //Fetch the WSDL w/wo credentials
                String uri = request.getParameter("wsdlurl");
                String username = request.getParameter("wsdlusername");
                String password = request.getParameter("wsdlpassword");
                String keydomain = request.getParameter("keydomain");
                String businessname = request.getParameter("businessname");
                boolean ignoreSSL = false;
                try {
                    ignoreSSL = Boolean.parseBoolean(request.getParameter("ignoressl"));
                } catch (Exception ex) {
                }
                try {
                    URL url = new URL(uri);
                    //"http://graphical.weather.gov/xml/SOAP_server/ndfdXMLserver.php?wsdl");
                    String domain = url.getHost();
                    //TModel keygen = UDDIClerk.createKeyGenator("uddi:" + domain + ":keygenerator", domain, "en");

                    ReadWSDL rw = new ReadWSDL();
                    rw.setIgnoreSSLErrors(ignoreSSL);
                    Definition wsdlDefinition = rw.readWSDL(url, username, password);
                    Properties properties = new Properties();
                    properties.put("keyDomain", keydomain);
                    properties.put("businessName", businessname);
                    properties.put("serverName", url.getHost());
                    properties.put("serverPort", url.getPort());
                    String wsdlURL = wsdlDefinition.getDocumentBaseURI();
                    WSDL2UDDI wsdl2UDDI = new WSDL2UDDI(null, new URLLocalizerDefaultImpl(), properties);
                    BusinessServices businessServices = wsdl2UDDI.createBusinessServices(wsdlDefinition);
                    @SuppressWarnings("unchecked")
                    Map<QName, PortType> portTypes = (Map<QName, PortType>) wsdlDefinition.getAllPortTypes();
                    Set<TModel> portTypeTModels = wsdl2UDDI.createWSDLPortTypeTModels(wsdlURL, portTypes);
                    Map allBindings = wsdlDefinition.getAllBindings();
                    Set<TModel> bindingTmodels = wsdl2UDDI.createWSDLBindingTModels(wsdlURL, allBindings);
                    List<TModel> tmodels = new ArrayList<TModel>();
                    tmodels.addAll(bindingTmodels);
                    tmodels.addAll(portTypeTModels);

                    boolean createKeyGen = false;
                    TModel keygen = UDDIClerk.createKeyGenator("uddi:" + keydomain + ":keygenerator", 
                            keydomain + " Key Generator Partition", (String) session.getAttribute("locale"));
                    if (x.getTmodelDetails(keygen.getTModelKey()) == null) {
                        createKeyGen = true;
                    }
                    out.write("<i class=\"icon-thumbs-up icon-large\"></i> WSDL successfully parsed! This will create " + portTypeTModels.size()
                            + " portType tmodel(s), " + bindingTmodels.size()
                            + " binding tModel(s), " + allBindings.size() +" binding(s), " +
                            ((createKeyGen==true) ? "one tModel Key Generator, " : "")
                            + " and " + businessServices.getBusinessService().size() + " service(s) attached to the business with "
                            + "the key " + StringEscapeUtils.escapeHtml(businessname) + " .<br>");
                    out.write("Services:<br><ul>");
                    for (int i = 0; i < businessServices.getBusinessService().size(); i++) {
                        out.write("<li>Key: "
                                + StringEscapeUtils.escapeHtml(businessServices.getBusinessService().get(i).getServiceKey())
                                + " <br>Name: "
                                + StringEscapeUtils.escapeHtml(Printers.ListNamesToString(businessServices.getBusinessService().get(i).getName())));
                        if (businessServices.getBusinessService().get(i).getBindingTemplates() != null) {
                            out.write("<br>Binding Templates:<ul>");
                            for (int k = 0; k < businessServices.getBusinessService().get(i).getBindingTemplates().getBindingTemplate().size(); k++) {
                                out.write("<li>Key: " + StringEscapeUtils.escapeHtml(businessServices.getBusinessService().get(i).getBindingTemplates().getBindingTemplate().get(k).getBindingKey())
                                        + "<br>Access Point: ");
                                if (businessServices.getBusinessService().get(i).getBindingTemplates().getBindingTemplate().get(k).getAccessPoint() != null) {
                                    out.write(StringEscapeUtils.escapeHtml(
                                            businessServices.getBusinessService().get(i).getBindingTemplates().getBindingTemplate().get(k).getAccessPoint().getValue()));
                                }
                                out.write("</li>");
                            }
                            out.write("</ul>");
                        }
                        out.write("</li>");
                    }
                    out.write("</ul>");

                    out.write("tModels<br><ul>");
                    for (int i = 0; i < tmodels.size(); i++) {
                        out.write("<li>Key: "
                                + StringEscapeUtils.escapeHtml(tmodels.get(i).getTModelKey())
                                + " Name: "
                                + StringEscapeUtils.escapeHtml(tmodels.get(i).getName().getValue())
                                + "</li>");
                    }
                    out.write("</ul>");

                    if (method.equalsIgnoreCase("save")) {
                        
                        //forgot the key generator

                        StringBuilder result = new StringBuilder();
                        if (createKeyGen)
                                                       {
                            result.append("Saving tModel " + StringEscapeUtils.escapeHtml( keygen.getName().getValue())  + "..." +x.SaveTModel(keygen)).append("<br>");
                        }
                        for (int i = 0; i < tmodels.size(); i++) {
                            result.append("Saving tModel " + StringEscapeUtils.escapeHtml( tmodels.get(i).getName().getValue())  + "..." + x.SaveTModel(tmodels.get(i))).append("<br>");
                        }

                        BusinessEntity biz = x.GetBusinessDetails(businessname);
                        if (biz != null) {
                            if (biz.getBusinessServices() == null) {
                                biz.setBusinessServices(new BusinessServices());
                            }

                        } else {
                            biz = new BusinessEntity();
                            biz.setBusinessKey( TokenResolver.replaceTokens("uddi:${keyDomain}:business_${businessName}", properties).toLowerCase() );
                            biz.getName().add(new Name(businessname, "en"));
                        }
                        if (biz.getBusinessServices() == null) {
                            biz.setBusinessServices(new BusinessServices());
                        }
                        for (int i = 0; i < businessServices.getBusinessService().size(); i++) {
                            businessServices.getBusinessService().get(i).setBusinessKey(biz.getBusinessKey());
                            biz.getBusinessServices().getBusinessService().add(businessServices.getBusinessService().get(i));
                        }
                        result.append("Saving business " + StringEscapeUtils.escapeHtml( biz.getName().get(0).getValue())  + " along with our imported service(s)..." + x.SaveBusinessDetails(biz));
                        out.write(result.toString());
                    }

                } catch (Exception ex) {
                     response.setStatus(406);
                        String msg = x.HandleException(ex);
                        if (msg.contains(ResourceLoader.GetResource(session, "errors.generic")))
                                response.setStatus(406);
                        out.write(msg);
                }
            } else {
                  response.setStatus(406);
                out.write(ResourceLoader.GetResource(session, "errors.generic"));
            }
        } else {
              response.setStatus(406);
                out.write(ResourceLoader.GetResource(session, "errors.generic"));
        }
    } else {
          response.setStatus(406);
                out.write(ResourceLoader.GetResource(session, "errors.generic"));
    }




      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
