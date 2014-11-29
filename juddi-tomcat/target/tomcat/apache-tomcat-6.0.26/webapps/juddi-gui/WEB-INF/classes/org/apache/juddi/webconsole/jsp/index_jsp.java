package org.apache.juddi.webconsole.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.sling.scripting.jsp.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");

    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 0) {
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i] != null && cookies[i].getName() != null && cookies[i].getName().equalsIgnoreCase("locale")) {
                if (cookies[i].getValue() != null) {
                    session.setAttribute("locale", cookies[i].getValue());
                    response.sendRedirect("home.jsp");
                    return;
                }
            }
        }
    }
    if (request.getMethod().equalsIgnoreCase("post")) {
        String lang = request.getParameter("language");
        String checked=request.getParameter("setcookie");
        if (lang != null) {
            session.setAttribute("locale", lang);
            if (checked != null && checked.equalsIgnoreCase("on")) {
                Cookie cookie = new Cookie("locale", lang);
                cookie.setMaxAge(Integer.MAX_VALUE);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
            response.sendRedirect("home.jsp");
        }
    }

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Welcome to Apache jUDDI</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta name=\"description\" content=\"Apache jUDDI\">\n");
      out.write("        <meta name=\"author\" content=\"Apache Software Foundation\">\n");
      out.write("\n");
      out.write("        <!-- Le styles -->\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"favicon.ico\" />\n");
      out.write("        <link href=\"css/bootstrap-responsive.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("          <script src=\"js/html5shiv.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("\n");
      out.write("        <!-- Fav and touch icons -->\n");
      out.write("\n");
      out.write("        <link rel=\"shortcut icon\" href=\"ico/favicon.png\">\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            body {\n");
      out.write("                padding: 0px 0px 0px 0px;\n");
      out.write("                margin: 0px 0px 0px 0px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div style=\"width:100%; height: 100%; position:absolute; text-align: center; vertical-align: middle; padding: 0px; margin: 0px; \n");
      out.write("             background-image: url('img/bluemarble2.jpg'); background-repeat: no-repeat; background-position-x: center;\n");
      out.write("             background-position-y: center; background-size: cover\">\n");
      out.write("            <div style=\"color: black; background-color: whitesmoke; \n");
      out.write("                 background: rgb(235, 235, 235); /* Fall-back for browsers that don't\n");
      out.write("                                    support rgba */\n");
      out.write("                 background: rgba(235, 235, 235, .7);width:60%; position: relative; left:20%; top:25%; height:50%; vertical-align: middle\">\n");
      out.write("                <br><br>\n");
      out.write("                <h1>Welcome to jUDDI</h1>\n");
      out.write("                <form method=\"POST\">\n");
      out.write("\n");
      out.write("                    <select id=\"language\" name=\"language\" >\n");
      out.write("                        <option value=\"en\" selected>English</option>\n");
      out.write("                        <option value=\"es\" >Español</option>\n");
      out.write("                    </select>\n");
      out.write("                    <br>\n");
      out.write("                    <input type=\"checkbox\" name=\"setcookie\" checked> Remember my decision<br>\n");
      out.write("                    <button type=\"submit\" value=\"Go\" class=\"btn btn-primary\">Go</button>\n");
      out.write("                </form>\n");
      out.write("                <b>We welcome help internationalizing jUDDI!</b>\n");
      out.write("                <noscript>Your browser does not support JavaScript! Functionality will be so severely reduced, that you might as well give up, sorry!</noscript>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
