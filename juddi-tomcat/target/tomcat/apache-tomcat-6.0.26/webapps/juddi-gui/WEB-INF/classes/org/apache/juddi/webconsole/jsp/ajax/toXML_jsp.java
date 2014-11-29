package org.apache.juddi.webconsole.jsp.ajax;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.xml.bind.JAXB;
import org.apache.juddi.webconsole.resources.ResourceLoader;
import org.apache.juddi.jaxb.JAXBMarshaller;
import org.apache.juddi.jaxb.EntityCreator;
import org.apache.juddi.webconsole.hub.UddiHub;
import org.apache.juddi.jaxb.PrintUDDI;

public final class toXML_jsp extends org.apache.sling.scripting.jsp.jasper.runtime.HttpJspBase
    implements org.apache.sling.scripting.jsp.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;


//<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
//NO NOT UNCOMMENT  
//   response.setContentType("text/xml");
    UddiHub x = UddiHub.getInstance(application, session);

    String type = request.getParameter("type");
    String id = request.getParameter("id");
    if ((type != null && type.length() != 0) && (id != null && id.length() != 0)) {
        Object j = null;
        if (type.equalsIgnoreCase("business")) {
            j = x.GetBusinessDetailsAsObject(id); 
        } else if (type.equalsIgnoreCase("service")) {
            j = x.GetServiceDetailsAsObject(id);
        } else if (type.equalsIgnoreCase("bindingTemplate")) {
            j = x.GetBindingDetailsAsObject(id);
        } else if (type.equalsIgnoreCase("tModel")) {
            j = x.GettModelDetailsAsObject(id);
        }
        else if (type.equalsIgnoreCase("subscription")) {
            j = x.GetSubscriptionDetails(id);
        }
        if (j != null) {
            JAXB.marshal(j, out);
         //   out.write(JAXBMarshaller.marshallToString(j, JAXBMarshaller.PACKAGE_UDDIAPI));
            // out.write(EntityCreator.outputEntityToString(j, "org.apache.juddi.api_v3"));
        } else {
            out.write(ResourceLoader.GetResource(session, "items.unknown"));
            response.setStatus(406);
        }
    }

    //get parameter type
    //fetch from UDDI
    //convert to string and output




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
