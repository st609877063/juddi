package org.apache.juddi.webconsole.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class quickref_005fident_jsp extends org.apache.sling.scripting.jsp.jasper.runtime.HttpJspBase
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
      out.write("<div class=\"btn-group\">\n");
      out.write("        <a class=\"btn dropdown-toggle btn-info\" data-toggle=\"dropdown\"  href=\"#\">Identifiers<span class=\"caret\"></span></a>\n");
      out.write("        <ul class=\"dropdown-menu\">\n");
      out.write("                <li><a href=\"javascript:AddIdentKeyReferenceParam('uddi:uddi.org:ubr:identifier:dnb.com:d-u-n-s','D-U-N-S:My Company','12-345-6789');\">D-U-N-S</a></li>\n");
      out.write("                <li><a href=\"javascript:AddIdentKeyReferenceParam('uddi:uddi.org:ubr:identifier:owningbusiness','uddi-org:owningBusiness','key');\">Owning Business</a></li>\n");
      out.write("                <li><a href=\"javascript:AddIdentKeyReferenceParam('uddi:uddi.org:identifier:taxid','uddi-org:taxid','');\">Tax ID</a></li>\n");
      out.write("                <li><a href=\"javascript:AddIdentKeyReferenceParam('uddi:uddi.org:ubr:identifier:thomasregister.com:supplierid','thomasregister-com:supplierID:My Business','01234567');\">Thomas Registry Supplier ID</a></li>\n");
      out.write("                <li><a href=\"javascript:AddIdentKeyReferenceParam('uddi:uddi.org:ubr:identifier:iso6523icd','','');\">ISO 6523 ICD</a></li>\n");
      out.write("        </ul>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<br><br>\n");
      out.write("\n");
      out.write("\n");
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
