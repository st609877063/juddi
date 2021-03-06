package org.apache.juddi.webconsole.jsp.ajax;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.juddi.webconsole.hub.UddiHub;

public final class getCert_jsp extends org.apache.sling.scripting.jsp.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;


    String type = request.getParameter("type");
    String id = request.getParameter("id");
    int index = 0;
    try {
        index = Integer.parseInt(request.getParameter("index"));
    } catch (Exception ex) {
    } 

    UddiHub x = UddiHub.getInstance(application, session);
    String data = null;
    if (type.equalsIgnoreCase("business")) {
        data = (x.GetCertificate(UddiHub.FindType.Business, id, index));
    } else if (type.equalsIgnoreCase("service")) {
        data = (x.GetCertificate(UddiHub.FindType.Service, id, index));
    } else if (type.equalsIgnoreCase("bindingTemplate")) {
        data = (x.GetCertificate(UddiHub.FindType.BindingTemplate, id, index));
    } else if (type.equalsIgnoreCase("tModel")) {
        data = (x.GetCertificate(UddiHub.FindType.tModel, id, index));
    }
    if (data != null && !data.startsWith("Error")) {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "inline; filename=cert.crt");
        out.write("-----BEGIN CERTIFICATE-----" + System.getProperty("line.separator"));
        out.write(data + System.getProperty("line.separator"));
        out.write("-----END CERTIFICATE-----" + System.getProperty("line.separator"));
    } else {
        response.setStatus(500);
        out.write(data);
    }


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
