package org.apache.juddi.webconsole.jsp.ajax;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.Set;
import java.util.Set;
import java.util.Properties;
import java.io.StringReader;
import javax.xml.bind.JAXB;
import org.apache.juddi.webconsole.resources.ResourceLoader;
import org.apache.juddi.jaxb.JAXBMarshaller;
import org.uddi.api_v3.TModel;
import org.uddi.api_v3.BindingTemplate;
import org.uddi.api_v3.BusinessService;
import org.uddi.api_v3.BusinessEntity;
import org.apache.juddi.jaxb.EntityCreator;
import org.apache.juddi.webconsole.hub.UddiHub;
import org.apache.juddi.jaxb.PrintUDDI;

public final class saveFromXML_jsp extends org.apache.sling.scripting.jsp.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      out.write("\n");
      out.write("\n");


    UddiHub x = UddiHub.getInstance(application, session);
    if (request.getMethod().equalsIgnoreCase("POST")) {
        String type = request.getParameter("type");
        String id = request.getParameter("id");
        if ((type != null && type.length() != 0) && (id != null && id.length() != 0)) {


            String signedxml = request.getParameter("data");
            if (signedxml == null) {
                out.write("no input");
            } else {
                signedxml = signedxml.trim();
                if (signedxml.startsWith("<?xml ")) {
                    int idx = signedxml.indexOf(">");
                    signedxml = signedxml.substring(idx + 1, signedxml.length()).trim();

                }
                signedxml = signedxml.trim();

                Object j = null;// JAXBMarshaller.unmarshallFromString(signedxml, JAXBMarshaller.PACKAGE_UDDIAPI);
                StringReader sr = new StringReader(signedxml);
                String msg = null;
                if (type.equalsIgnoreCase("business")) {
                    BusinessEntity be = (BusinessEntity) JAXB.unmarshal(sr, BusinessEntity.class);
                    msg = (x.SaveBusinessDetails(be));
                } else if (type.equalsIgnoreCase("service")) {
                    BusinessService be = (BusinessService) JAXB.unmarshal(sr, BusinessService.class);
                    msg = (x.SaveServiceDetails(be));
                } else if (type.equalsIgnoreCase("bindingTemplate")) {
                    BindingTemplate be = (BindingTemplate) JAXB.unmarshal(sr, BindingTemplate.class);
                    msg = (x.SaveBindingTemplate(be));
                } else if (type.equalsIgnoreCase("tModel")) {
                    TModel be = (TModel) JAXB.unmarshal(sr, TModel.class);
                    msg = (x.SaveTModel(be));
                } else {
                    msg = (ResourceLoader.GetResource(session, "errors.unknownentity"));
                }
                if (msg.contains(ResourceLoader.GetResource(session, "errors.generic")))
                        response.setStatus(406);
                out.write(msg);
            }
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
