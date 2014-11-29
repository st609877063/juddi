package org.apache.juddi.webconsole.jsp.ajax;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.juddi.v3.client.cryptor.DigSigUtil;
import org.apache.juddi.jaxb.JAXBMarshaller;
import org.apache.juddi.jaxb.EntityCreator;
import org.apache.juddi.webconsole.hub.UddiHub;
import org.apache.juddi.webconsole.resources.ResourceLoader;

public final class validateSignature_jsp extends org.apache.sling.scripting.jsp.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    //org.apache.juddi.jaxb.PrintUDDI p = new PrintUDDI();
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
        if (j != null) {
            UddiHub hub = UddiHub.getInstance(application, session);
            
            org.apache.juddi.v3.client.cryptor.DigSigUtil dsig = new DigSigUtil(hub.GetDigitalSignatureConfig());

            AtomicReference<String> msg = new AtomicReference<String>();
            // dsig.put(DigSigUtil., value);
            boolean success = dsig.verifySignedUddiEntity(j, msg);
            if (!success) {
                out.write("<span class=\"label label-important\">" + ResourceLoader.GetResource(session, "items.signatures.invalid") + msg.get() + "</span>");
            } else {
                out.write("<span class=\"label label-success\">" + ResourceLoader.GetResource(session, "items.signatures.valid") + "</span>");
            }
        } else {
            //response.setStatus(500);
            out.write(ResourceLoader.GetResource(session, "items.unknown"));
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
