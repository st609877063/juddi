package org.apache.juddi.webconsole.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.juddi.webconsole.hub.UddiHub;
import org.apache.juddi.webconsole.resources.ResourceLoader;
import org.apache.commons.lang.StringEscapeUtils;

public final class login_jsp extends org.apache.sling.scripting.jsp.jasper.runtime.HttpJspBase
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
      out.write("<div class=\"navbar-form pull-right\">\n");
      out.write("\n");
      out.write("    ");

        if (session.getAttribute("username") != null && session.getAttribute("password") != null
                && ((String) session.getAttribute("username")).length() > 0 && ((String) session.getAttribute("password")).length() > 0) {
            //we're probably logged in

    
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        loggedin = true;\n");
      out.write("    </script>\n");
      out.write("    <a class=\"btn\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.login.logout"));
      out.write("\" href=\"javascript:logout();\">\n");
      out.write("        ");

                if (!request.isSecure() ||  !UddiHub.getInstance(application, session).isSecure()) {
            
      out.write("\n");
      out.write("            <i class=\"icon-warning-sign\" title=\"");
      out.print(ResourceLoader.GetResource(session, "warning.ssl"));
      out.write("\"></i>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        \n");
      out.write("        <i class=\"icon-user\"></i>\n");
      out.write("        ");

            out.write(ResourceLoader.GetResource(session, "items.welcome") + " " + StringEscapeUtils.escapeHtml((String) session.getAttribute("username")) + "</a>");

        } else {
        
      out.write("\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            loggedin = false;\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        <input class=\"span2\" type=\"text\" placeholder=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.login.username"));
      out.write("\" name=\"username\" id=\"username\">\n");
      out.write("        <input class=\"span2\" type=\"password\" placeholder=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.login.password"));
      out.write("\" name=\"password\" id=\"password\">\n");
      out.write("        <button type=\"button\" onclick=\"javascript:Login();\" class=\"btn\" id=\"loginbutton\">\n");
      out.write("            ");

                if (!request.isSecure()) {
            
      out.write("\n");
      out.write("            <i class=\"icon-warning-sign\" title=\"");
      out.print(ResourceLoader.GetResource(session, "warning.ssl"));
      out.write("\"></i>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("            ");
      out.print(ResourceLoader.GetResource(session, "navbar.login.button"));
      out.write("\n");
      out.write("        </button>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("        \n");
      out.write("<div class=\"modal hide fade container\" id=\"loginfailure\">\n");
      out.write("    <div class=\"modal-header\">\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("        <h3>");
      out.print(ResourceLoader.GetResource(session, "errors.generic"));
      out.write("</h3>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"modal-body\">\n");
      out.write("            <i class=\"icon-4x icon-thumbs-down\"></i><br>\n");
      out.write("            <div id=\"loginfailuredetails\"></div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"modal-footer\">\n");
      out.write("\n");
      out.write("        <button type=\"button\" class=\"btn\" data-dismiss=\"modal\" >");
      out.print(ResourceLoader.GetResource(session, "modal.close"));
      out.write("</button>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("    ");
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
