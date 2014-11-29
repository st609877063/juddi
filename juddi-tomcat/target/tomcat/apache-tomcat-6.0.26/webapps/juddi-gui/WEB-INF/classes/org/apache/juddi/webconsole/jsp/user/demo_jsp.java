package org.apache.juddi.webconsole.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.juddi.webconsole.resources.ResourceLoader;

public final class demo_jsp extends org.apache.sling.scripting.jsp.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"modal hide fade container \" id=\"banner\">\n");
      out.write("        <div class=\"modal-header\">\n");
      out.write("                <a href=\"javascript:$('#banner').modal('hide');\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</a>\n");
      out.write("                <h3>Welcome</h3>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"modal-body\" align=\"center\">\n");
      out.write("\t\t\n");
      out.write("                <i class=\"icon-thumbs-up icon-4x\"></i><br>\n");
      out.write("                Hi there! Thank's for checking out jUDDI's cloud instance. You are free to do whatever you want here.<br>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<br>\n");
      out.write("\t\t\t\t<i class=\"icon-warning-sign icon-4x\"></i><br>\n");
      out.write("                As such, do not rely on any information provided here. It's probably all made up by people just like you.<br><br>\n");
      out.write("                In order to create, update or delete content, you'll need to <b>sign in</b>. Just make up a username and stick with it. Passwords are not validated.<br><br>\n");
      out.write("                If you run into a problem, please file a <a href=\"http://juddi.apache.org/issue-tracking.html\" target=\"_newtab\">bug report</a> so that we can fix it.\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"modal-footer\">\n");
      out.write("                <a href=\"javascript:$('#banner').modal('hide');\" class=\"btn btn-primary\" data-dismiss=\"modal\">");
      out.print(ResourceLoader.GetResource(session, "modal.close"));
      out.write("</a>\n");
      out.write("        </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("        function setCookieBanner(cname, cvalue, exdays)\n");
      out.write("        {\n");
      out.write("                var d = new Date();\n");
      out.write("                d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));\n");
      out.write("                var expires = \"expires=\" + d.toGMTString();\n");
      out.write("                document.cookie = cname + \"=\" + cvalue + \"; \" + expires;\n");
      out.write("        }\n");
      out.write("        function getCookieBanner(cname)\n");
      out.write("        {\n");
      out.write("                var name = cname + \"=\";\n");
      out.write("                var ca = document.cookie.split(';');\n");
      out.write("                for (var i = 0; i < ca.length; i++)\n");
      out.write("                {\n");
      out.write("                        var c = ca[i].trim();\n");
      out.write("                        if (c.indexOf(name) == 0)\n");
      out.write("                                return c.substring(name.length, c.length);\n");
      out.write("                }\n");
      out.write("                return \"\";\n");
      out.write("        }\n");
      out.write("        function checkCookieBanner()\n");
      out.write("        {\n");
      out.write("                var username = getCookieBanner(\"bannerseen\");\n");
      out.write("                if (username != \"\")\n");
      out.write("                {\n");
      out.write("                        //alert(\"Welcome again \" + username);\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                        $('#banner').modal();\n");
      out.write("\n");
      out.write("                        setCookieBanner(\"bannerseen\", \"true\", 1);\n");
      out.write("\n");
      out.write("                }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        $(document).ready(function() {\n");
      out.write("                checkCookieBanner();\n");
      out.write("        });\n");
      out.write("        \n");
      out.write("</script>");
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
