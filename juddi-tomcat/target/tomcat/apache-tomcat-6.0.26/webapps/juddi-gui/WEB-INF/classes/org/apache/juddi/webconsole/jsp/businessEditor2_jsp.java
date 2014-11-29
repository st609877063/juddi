package org.apache.juddi.webconsole.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URLEncoder;
import org.uddi.api_v3.IdentifierBag;
import org.uddi.api_v3.CategoryBag;
import org.uddi.api_v3.Contacts;
import org.uddi.api_v3.BusinessEntity;
import org.apache.juddi.webconsole.PostBackConstants;
import org.apache.juddi.webconsole.hub.UddiHub;
import org.apache.juddi.api_v3.Node;
import java.util.List;
import org.apache.juddi.webconsole.hub.UddiHub;
import org.apache.juddi.webconsole.resources.ResourceLoader;
import org.apache.juddi.webconsole.hub.UddiHub;
import org.apache.juddi.webconsole.resources.ResourceLoader;
import org.apache.juddi.webconsole.CrossSiteRequestForgeryException;
import org.apache.juddi.webconsole.hub.UddiHub;
import org.apache.juddi.webconsole.hub.UddiHub;
import org.apache.juddi.webconsole.resources.ResourceLoader;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.juddi.webconsole.resources.ResourceLoader;
import org.apache.juddi.webconsole.resources.ResourceLoader;
import org.apache.juddi.webconsole.resources.ResourceLoader;
import org.apache.juddi.webconsole.hub.UddiHub;
import org.apache.commons.lang.StringEscapeUtils;
import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.io.InputStream;
import java.util.jar.JarFile;
import java.net.URL;
import java.util.Enumeration;
import org.apache.juddi.webconsole.resources.ResourceLoader;

public final class businessEditor2_jsp extends org.apache.sling.scripting.jsp.jasper.runtime.HttpJspBase
    implements org.apache.sling.scripting.jsp.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(11);
    _jspx_dependants.add("/header-top.jsp");
    _jspx_dependants.add("/user/banner.jsp");
    _jspx_dependants.add("/autoLogoutModal.jsp");
    _jspx_dependants.add("/csrf.jsp");
    _jspx_dependants.add("/login.jsp");
    _jspx_dependants.add("/quickref_catbag.jsp");
    _jspx_dependants.add("/quickref_krgrp.jsp");
    _jspx_dependants.add("/quickref_ident.jsp");
    _jspx_dependants.add("/keyHelpModal.jsp");
    _jspx_dependants.add("/tmodelChooser.jsp");
    _jspx_dependants.add("/header-bottom.jsp");
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\n");
        //this is to catch someone that bookmarked a page after selecting a language
        Cookie[] cookies2 = request.getCookies();
        if (cookies2 != null && cookies2.length > 0) {
                for (int i = 0; i < cookies2.length; i++) {
                        if (cookies2[i] != null && cookies2[i].getName() != null && cookies2[i].getName().equalsIgnoreCase("locale")) {
                                if (cookies2[i].getValue() != null) {
                                        session.setAttribute("locale", cookies2[i].getValue());
                                }
                        }
                }
        }
        if (session.getAttribute("locale") == null) {
                //last chance, default to english
                session.setAttribute("locale", "en");
        }

      out.write("<html lang=\"");
      out.print((String) session.getAttribute("locale"));
      out.write("\" dir=\"");
      out.print(ResourceLoader.GetResource(session, "direction"));
      out.write("\">\n");
      out.write("        <head>\n");
      out.write("                <meta charset=\"utf-8\">\n");
      out.write("                <title>");
      out.print(ResourceLoader.GetResource(session, "title"));
      out.write("</title>\n");
      out.write("                <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("                <meta name=\"description\" content=\"");
      out.print(ResourceLoader.GetResource(session, "description"));
      out.write("\">\n");
      out.write("                <meta name=\"author\" content=\"Apache Software Foundation\">\n");
      out.write("\n");
      out.write("                <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("                <link href=\"css/bootstrap-datetimepicker.min.css\" rel=\"stylesheet\">\n");
      out.write("                <link href=\"css/bootstrap-timepicker.min.css\" rel=\"stylesheet\">\n");
      out.write("                <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\n");
      out.write("                <link rel=\"stylesheet\" href=\"css/ui-lightness/jquery-ui-1.10.2.custom.min.css\">\n");
      out.write("                <!--[if IE 7]>\n");
      out.write("                <link rel=\"stylesheet\" href=\"css/font-awesome-ie7.min.css\">\n");
      out.write("                <![endif]-->\n");
      out.write("\n");
      out.write("                <link rel=\"shortcut icon\" href=\"favicon.ico\" />\n");
      out.write("                <style type=\"text/css\">\n");
      out.write("                        body {\n");
      out.write("                                padding-top: 60px;\n");
      out.write("                                padding-bottom: 40px;\n");
      out.write("                        }\n");
      out.write("                        .tab-content {\n");
      out.write("                                overflow: visible;\n");
      out.write("                            }\n");
      out.write("                </style>\n");
      out.write("                <link href=\"css/bootstrap-responsive.min.css\" rel=\"stylesheet\">\n");
      out.write("                <link href=\"css/bootstrap-modal.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("                <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->\n");
      out.write("                <!--[if lt IE 9]>\n");
      out.write("                  <script src=\"js/html5shiv.js\"></script>\n");
      out.write("                <![endif]-->\n");
      out.write("\n");
      out.write("                <!-- Fav and touch icons -->\n");
      out.write("\n");
      out.write("                <link rel=\"shortcut icon\" href=\"ico/favicon.png\">\n");
      out.write("                <script src=\"js/jquery-1.9.1.js\"></script>\n");
      out.write("                <script src=\"js/i18n.js.jsp\"></script>\n");
      out.write("                <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("                <script src=\"js/bootstrap-datetimepicker.min.js\"></script>\n");
      out.write("                <script src=\"js/bootstrap-timepicker.min.js\"></script>\n");
      out.write("                <script src=\"js/bootstrap-modalmanager.js\"></script>\n");
      out.write("                <script src=\"js/bootstrap-modal.js\"></script>\n");
      out.write("                <script src=\"js/jquery.jeditable.js\"></script>\n");
      out.write("                <script src=\"js/jquery-ui-1.10.2.custom.min.js\"></script>\n");
      out.write("                <script src=\"js/main.js\"></script>\n");
      out.write("        </head>\n");
      out.write("\n");
      out.write("        <body>\n");
      out.write("                ");

    UddiHub internal_ = UddiHub.getInstance(application, session);
    if (internal_.isAutoLogoutEnabled()) {


      out.write("<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("    var timer1, timer2;\n");
      out.write("    document.onkeypress = resetTimer;\n");
      out.write("    document.onmousemove = resetTimer;\n");
      out.write("    function resetTimer()\n");
      out.write("    {\n");
      out.write("\n");
      out.write("        $(\"#autologout\").modal('hide');\n");
      out.write("        clearTimeout(timer1);\n");
      out.write("        clearTimeout(timer2);\n");
      out.write("\n");
      out.write("        // waiting time in minutes\n");
      out.write("        var wait = ");
      out.print(internal_.GetAutoLogoutDuration());
      out.write(";\n");
      out.write("\n");
      out.write("        // alert user one minute before\n");
      out.write("        timer1 = setTimeout(\"alertUser()\", (wait) - 30000);\n");
      out.write("\n");
      out.write("        // logout user\n");
      out.write("        timer2 = setTimeout(\"logout()\", wait);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function alertUser()\n");
      out.write("    {\n");
      out.write("        window.console && console.log(\"trigger automatic logout warning\");\n");
      out.write("        $(\"#autologout\").modal('hide');\n");
      out.write("        $(\"#autologout\").modal('show');\n");
      out.write("        // document.getElementById('timeoutPopup').style.display = 'block';\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function logout()\n");
      out.write("    {\n");
      out.write("        window.console && console.log(\"trigger automatic logout\");\n");
      out.write("        window.location.href = 'logoutredir.jsp';\n");
      out.write("    }\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"modal hide fade container\" id=\"autologout\">\n");
      out.write("    <div class=\"modal-header\">\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("        <h3>");
      out.print(ResourceLoader.GetResource(session, "pages.serviceimport.content.sslwarning"));
      out.write("</h3>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"modal-body\">\n");
      out.write("        ");
      out.print(ResourceLoader.GetResource(session, "pages.session.expire"));
      out.write("</div>\n");
      out.write("    <div class=\"modal-footer\">\n");
      out.write("\n");
      out.write("        <a href=\"javascript:closeXmlPop('autologout');\" class=\"btn\">");
      out.print(ResourceLoader.GetResource(session, "modal.close"));
      out.write("</a>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");

    }


      out.write("<form id=\"uddiform\">\n");
      out.write("                        ");

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


      out.write("<input type=\"hidden\" name=\"nonce\" id=\"nonce\" value=\"");
      out.print(StringEscapeUtils.escapeHtml((String) session.getAttribute("nonce")));
      out.write("\" />\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        <div class=\"modal hide fade container\" id=\"alert\">\n");
      out.write("                                <div class=\"modal-header\">\n");
      out.write("                                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("                                        <h3>");
      out.print(ResourceLoader.GetResource(session, "actions.result"));
      out.write("</h3>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"modal-body\">\n");
      out.write("                                        <div id=\"alert_results\"><i class=\"icon-2x icon-thumbs-up\"></i></div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"modal-footer\">\n");
      out.write("\n");
      out.write("                                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">");
      out.print(ResourceLoader.GetResource(session, "modal.close"));
      out.write("</button>\n");
      out.write("                                </div>\n");
      out.write("                        </div>\n");
      out.write("    \n");
      out.write("                        ");

                                UddiHub hub = UddiHub.getInstance(application, session);
                                Cookie[] cs = request.getCookies();
                                String newnode=null;
                                if (cs!=null){
                                        for (int i=0; i < cs.length; i++){
                                                if (cs[i].getName().equalsIgnoreCase("current_node")){
                                                        newnode = cs[i].getValue();
                                                        break;
                                                }
                                        }
                                }
                                hub.switchNodes(newnode);
                        
      out.write("<div class=\"navbar navbar-inverse navbar-fixed-top\">\n");
      out.write("                                <div class=\"navbar-inner\">\n");
      out.write("                                        <div class=\"container\">\n");
      out.write("                                                <button type=\"button\" class=\"btn btn-navbar\" data-toggle=\"collapse\" data-target=\".nav-collapse\">\n");
      out.write("                                                        <span class=\"icon-bar\"></span>\n");
      out.write("                                                        <span class=\"icon-bar\"></span>\n");
      out.write("                                                        <span class=\"icon-bar\"></span>\n");
      out.write("                                                </button>\n");
      out.write("                                                <a class=\"brand\" href=\"home.jsp\" style=\"padding-left:19px; padding-top:0px; padding-bottom:0px\"><img src=\"img/logo2.png\"></a>\n");
      out.write("                                                <div class=\"nav-collapse collapse\">\n");
      out.write("                                                        <ul class=\"nav\">\n");
      out.write("                                                                <li class=\"dropdown\"><a href=\"home.jsp\" data-toggle=\"dropdown\" class=\"dropdowb-town\"><i class=\"icon-home icon-large\"></i>");
      out.print(ResourceLoader.GetResource(session, "navbar.home"));
      out.write("<b class=\"caret\"></b></a>\n");
      out.write("                                                                        <ul class=\"dropdown-menu\">\n");
      out.write("                                                                                <li><a href=\"reginfo.jsp\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.create.mybiz.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.create.mybiz"));
      out.write("</a></li>\n");
      out.write("                                                                                <li><a href=\"assertions.jsp\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.publisherassertions.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.publisherassertions"));
      out.write("</a></li>\n");
      out.write("                                                                                <li><a href=\"transfer.jsp\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.transfer.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.transfer"));
      out.write("</a></li>\n");
      out.write("                                                                                <li class=\"divider\"></li>\n");
      out.write("                                                                                <li><a href=\"viewSubscriptions.jsp\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.subscriptions.view.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.subscriptions.view"));
      out.write("</a></li>\n");
      out.write("                                                                                <li><a href=\"editSubscription.jsp\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.subscriptions.create.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.subscriptions.create"));
      out.write("</a></li>\n");
      out.write("                                                                                <li><a href=\"subscriptionFeed.jsp\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.subscriptions.feed.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.subscriptions.feed"));
      out.write("</a></li>\n");
      out.write("                                                                        </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                                </li>\n");
      out.write("                                                                <li class=\"dropdown\" ><a href=\"#\" data-toggle=\"dropdown\" class=\"dropdowb-town\"><i class=\"icon-search icon-large\"></i>");
      out.print(ResourceLoader.GetResource(session, "navbar.discover"));
      out.write("<b class=\"caret\"></b></a>\n");
      out.write("                                                                        <ul class=\"dropdown-menu\">\n");
      out.write("                                                                                <li><a href=\"businessBrowse.jsp\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.businesses.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.businesses"));
      out.write("</a></li>\n");
      out.write("                                                                                <li><a href=\"serviceBrowse.jsp\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.services.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.services"));
      out.write("</a></li>\n");
      out.write("                                                                                <li><a href=\"tmodelBrowse.jsp\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.tmodels.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.tmodels"));
      out.write("</a></li>\n");
      out.write("                                                                                        ");
//                                        <li><a href="publisherBrowse.jsp" title="<%=ResourceLoader.GetResource(session, "navbar.publishers.tooltip")">ResourceLoader.GetResource(session, "navbar.publishers")</a></li>
                                                                                               
      out.write("<li class=\"divider\"> </li>\n");
      out.write("\n");
      out.write("                                                                                <li><a href=\"search.jsp\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.search.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.search"));
      out.write("</a></li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                                        </ul>\n");
      out.write("                                                                </li>\n");
      out.write("                                                                <li class=\"dropdown\"><a href=\"#\" data-toggle=\"dropdown\" class=\"dropdowb-town\"><i class=\"icon-pencil icon-large\"></i>");
      out.print(ResourceLoader.GetResource(session, "navbar.create"));
      out.write("<b class=\"caret\"></b></a>\n");
      out.write("                                                                        <ul class=\"dropdown-menu\">\n");
      out.write("                                                                                <li><a href=\"businessEditor2.jsp\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.create.business.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.create.business"));
      out.write("</a></li>\n");
      out.write("                                                                                <li><a href=\"businessBrowse.jsp\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.create.service.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.create.service"));
      out.write("</a></li>\n");
      out.write("                                                                                <li><a href=\"importFromWsdl.jsp\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.create.serviceimport.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.create.serviceimport"));
      out.write("</a></li>\n");
      out.write("                                                                                <li><a href=\"importFromWadl.jsp\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.create.serviceimport.tooltip.wadl"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.create.serviceimport.wadl"));
      out.write("</a></li>\n");
      out.write("                                                                                <li><a href=\"tmodelEditor.jsp\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.create.tmodel.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.create.tmodel"));
      out.write("</a></li>\n");
      out.write("                                                                                <li><a href=\"tmodelPartitions.jsp\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.create.tmodelkeygen.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.create.tmodelkeygen"));
      out.write("</a></li>\n");
      out.write("                                                                                <li><a href=\"editSubscription.jsp\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.subscriptions.create.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.subscriptions"));
      out.write("</a></li>\n");
      out.write("                                                                                <li><a href=\"advanced.jsp\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.advanced"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.advanced"));
      out.write("</a></li>\n");
      out.write("                                                                        </ul>\n");
      out.write("                                                                </li>\n");
      out.write("\n");
      out.write("                                                                <li class=\"dropdown\"><a href=\"#\" data-toggle=\"dropdown\" class=\"dropdowb-town\"><i class=\"icon-cog icon-large\"></i>");
      out.print(ResourceLoader.GetResource(session, "navbar.settings"));
      out.write("<b class=\"caret\"></b></a>\n");
      out.write("                                                                        <ul class=\"dropdown-menu\">\n");
      out.write("                                                                                <li><a href=\"settings.jsp\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.settings.config.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.settings.config"));
      out.write("</a></li>\n");
      out.write("                                                                                <li class=\"divider\"></li>\n");
      out.write("                                                                                <li><a href=\"#\" data-toggle=\"tooltip\" data-container=\"body\" class=\"uddi_tooltips\" title=\"");
      out.print(ResourceLoader.GetResource(session, "items.switchnode.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "items.switchnode"));
      out.write("</a></li>\n");
      out.write("                                                                                \n");
      out.write("                                                                                        ");

                                                                                                List<Node> nodes = hub.GetJuddiClientConfig().getUDDINodeList();
                                                                                                for (int i = 0; i < nodes.size(); i++) {
                                                                                                        out.write("<li><a href=\"javascript:switchNode('" + StringEscapeUtils.escapeHtml(nodes.get(i).getName()) + "')\" title=\"" + StringEscapeUtils.escapeHtml(nodes.get(i).getDescription()) + "\" >");
                                                                                                        if (hub.getNodeName().equals(nodes.get(i).getName())) {
                                                                                                                out.write("<i class=\"icon icon-check\"></i> ");
                                                                                                        } else {
                                                                                                                out.write("<i class=\"icon icon-check-empty\"></i> ");
                                                                                                        }
                                                                                                        out.write(StringEscapeUtils.escapeHtml(nodes.get(i).getName()));
                                                                                                        if (hub.getNodeName().equals(nodes.get(i).getName())) {
                                                                                                                out.write("(" + ResourceLoader.GetResource(session, "items.active") + ")");
                                                                                                        }
                                                                                                        out.write("</a></li>");
                                                                                                }
                                                                                        
      out.write("</ul>\n");
      out.write("                                                                </li>\n");
      out.write("                                                                <script type=\"text/javascript\">\n");
      out.write("                                                                         $('.uddi_tooltips').tooltip();\n");
      out.write("                                                                        function switchNode(name) {\n");
      out.write("                                                                                var postbackdata = new Array();\n");
      out.write("                                                                                postbackdata.push({\n");
      out.write("                                                                                        name: \"nonce\",\n");
      out.write("                                                                                        value: $(\"#nonce\").val()\n");
      out.write("                                                                                });\n");
      out.write("                                                                                postbackdata.push({\n");
      out.write("                                                                                        name: \"node\",\n");
      out.write("                                                                                        value: name\n");
      out.write("                                                                                });\n");
      out.write("                                                                                window.console && console.log('reconfiguring node name');\n");
      out.write("                                                                                var request = $.ajax({\n");
      out.write("                                                                                        url: 'ajax/switch.jsp',\n");
      out.write("                                                                                        type: \"POST\",\n");
      out.write("                                                                                        cache: false,\n");
      out.write("                                                                                        data: postbackdata\n");
      out.write("                                                                                });\n");
      out.write("\n");
      out.write("                                                                                request.done(function(msg) {\n");
      out.write("                                                                                        window.console && console.log(msg);\n");
      out.write("                                                                                        window.console && console.log('postback done to div ' );\n");
      out.write("                                                                                        $(\"#\" + jqSelector('nodeswitcherdetails')).html(msg);\n");
      out.write("                                                                                        $(\"#nodeswitcher\").modal();\n");
      out.write("                                                                                });\n");
      out.write("\n");
      out.write("                                                                                request.fail(function(jqXHR, textStatus) {\n");
      out.write("                                                                                        window.console && console.log('postback failed ');\n");
      out.write("                                                                                        $(\"#\" + jqSelector('nodeswitcherdetails')).html(\"An error occured! \" + jqXHR.responseText + textStatus);\n");
      out.write("                                                                                        $(\"#nodeswitcher\").modal();\n");
      out.write("                                                                                });\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                                        }\n");
      out.write("                                                                </script>\n");
      out.write("\n");
      out.write("                                                                <li class=\"dropdown\"><a href=\"#\" data-toggle=\"dropdown\" class=\"dropdowb-town\"><i class=\"icon-question-sign icon-large\"></i>");
      out.print(ResourceLoader.GetResource(session, "navbar.help"));
      out.write("<b class=\"caret\"></b></a>\n");
      out.write("                                                                        <ul class=\"dropdown-menu\">\n");
      out.write("                                                                                <li><a href=\"http://juddi.apache.org/docs.html\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.help.userguide"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.help.userguide"));
      out.write("</a></li>\n");
      out.write("                                                                                <li><a href=\"http://wiki.apache.org/juddi\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.help.wiki"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.help.wiki"));
      out.write("</a></li>\n");
      out.write("                                                                                <li><a href=\"http://juddi.apache.org/issue-tracking.html\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.help.bugreport"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.help.bugreport"));
      out.write("</a></li>\n");
      out.write("                                                                                <li><a href=\"http://juddi.apache.org/\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.help.website"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.help.website"));
      out.write("</a></li>\n");
      out.write("                                                                                <li><a href=\"http://mail-archives.apache.org/mod_mbox/juddi-user/\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.help.mailinglist"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.help.mailinglist"));
      out.write("</a></li>\n");
      out.write("                                                                                <li><a href=\"http://svn.apache.org/viewvc/juddi/\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.help.source"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.help.source"));
      out.write("</a></li>\n");
      out.write("                                                                                <li><a href=\"about.jsp\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.help.about.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "navbar.help.about"));
      out.write("</a></li>\n");
      out.write("\n");
      out.write("                                                                        </ul>\n");
      out.write("                                                                </li>\n");
      out.write("                                                        </ul>\n");
      out.write("                                                        <div id=\"loginfield\">\n");
      out.write("                                                                ");
      out.write("<div class=\"navbar-form pull-right\">\n");
      out.write("\n");
      out.write("    ");

        if (session.getAttribute("username") != null && session.getAttribute("password") != null
                && ((String) session.getAttribute("username")).length() > 0 && ((String) session.getAttribute("password")).length() > 0) {
            //we're probably logged in

    
      out.write("<script type=\"text/javascript\">\n");
      out.write("        loggedin = true;\n");
      out.write("    </script>\n");
      out.write("    <a class=\"btn\" title=\"");
      out.print(ResourceLoader.GetResource(session, "navbar.login.logout"));
      out.write("\" href=\"javascript:logout();\">\n");
      out.write("        ");

                if (!request.isSecure() ||  !UddiHub.getInstance(application, session).isSecure()) {
            
      out.write("<i class=\"icon-warning-sign\" title=\"");
      out.print(ResourceLoader.GetResource(session, "warning.ssl"));
      out.write("\"></i>\n");
      out.write("            ");

                }
            
      out.write("<i class=\"icon-user\"></i>\n");
      out.write("        ");

            out.write(ResourceLoader.GetResource(session, "items.welcome") + " " + StringEscapeUtils.escapeHtml((String) session.getAttribute("username")) + "</a>");

        } else {
        
      out.write("<script type=\"text/javascript\">\n");
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
            
      out.write("<i class=\"icon-warning-sign\" title=\"");
      out.print(ResourceLoader.GetResource(session, "warning.ssl"));
      out.write("\"></i>\n");
      out.write("            ");

                }
            
      out.print(ResourceLoader.GetResource(session, "navbar.login.button"));
      out.write("</button>\n");
      out.write("        ");

            }
        
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
      out.write("</div>\n");
      out.write("                                                </div><!--/.nav-collapse -->\n");
      out.write("                                        </div>\n");
      out.write("                                </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                                                        \n");
      out.write("                                                        \n");
      out.write("<div class=\"modal hide fade container\" id=\"nodeswitcher\">\n");
      out.write("    <div class=\"modal-header\">\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("        <h3>");
      out.print(ResourceLoader.GetResource(session, "items.switchnode"));
      out.write("</h3>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"modal-body\">\n");
      out.write("            <div id=\"nodeswitcherdetails\"></div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"modal-footer\">\n");
      out.write("\n");
      out.write("            <a href=\"index.jsp\" class=\"btn btn-primary\" >");
      out.print(ResourceLoader.GetResource(session, "actions.continue"));
      out.write("</a>\n");
      out.write("    </div>\n");
      out.write("</div>");
      out.write("<div class=\"container\">\n");
      out.write("\n");
      out.write("   <!-- Main hero unit for a primary marketing message or call to action -->\n");
      out.write("   <div class=\"well\" >\n");
      out.write("      <h1>");
      out.print(ResourceLoader.GetResource(session, "pages.businesseditor.title"));
      out.write("</h1>\n");
      out.write("   </div>\n");
      out.write("\n");
      out.write("   <!-- Example row of columns -->\n");
      out.write("   <div class=\"row\">\n");
      out.write("      <div class=\"span12\" >\n");
      out.write("         <script type=\"text/javascript\" src=\"js/businessEditor.js\"></script>\n");
      out.write("         <div id=\"businesseditor\">\n");
      out.write("            ");

               boolean newitem = false;

               UddiHub x = UddiHub.getInstance(application, request.getSession());
               String bizid = request.getParameter("id");
               if (bizid == null || bizid.isEmpty()) {
                  //response.sendRedirect("browse.jsp");
                  newitem = true;
               }

               BusinessEntity bd = null;
               if (!newitem) {
                  bd = x.GetBusinessDetails(bizid);
               } else {
                  bd = new BusinessEntity();
               }
               if (bd == null) {
                  bd = new BusinessEntity();
                  newitem = true;
               }

            
                   if (!newitem) {
                  out.write("<i class=\"icon-lock icon-large\"></i>");
               }
            
      out.write('<');
      out.write('b');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "pages.businesskey"));
      out.write("</b>-\n");
      out.write("            ");
      out.print(ResourceLoader.GetResource(session, "pages.businesskey.description"));
      out.write("<a href=\"javascript:ShowKeyHelp();\"><i class=\"icon-question-sign icon-large\"></i> ");
      out.print(ResourceLoader.GetResource(session, "navbar.help"));
      out.write("</a>\n");
      out.write("            <br>\n");
      out.write("            <div style=\"border-width: 2px; border-style: solid;\" class=\"");


               if (newitem) {
                  out.write("edit");
               } else {
                  out.write("noedit");
               }

                 
      out.write("\" id=\"");
      out.print(PostBackConstants.BUSINESSKEY);
      out.write("\">\n");
      out.write("               ");

                  if (!newitem) {
                     out.write(StringEscapeUtils.escapeHtml(bd.getBusinessKey()));
                  }
                  if (bd.getContacts() == null) {
                     bd.setContacts(new Contacts());
                  }
                  if (bd.getCategoryBag() == null) {
                     bd.setCategoryBag(new CategoryBag());
                  }
                  if (bd.getIdentifierBag() == null) {
                     bd.setIdentifierBag(new IdentifierBag());
                  }
               
      out.write("</div><br>\n");
      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("               var currentNameEntries =");
      out.print( bd.getName().size() - 1);
      out.write(";\n");
      out.write("               var currentDisco =");
      out.print( bd.getContacts().getContact().size() - 1);
      out.write(";\n");
      out.write("               var currentDescriptionEntries =");
      out.print( bd.getDescription().size() - 1);
      out.write(";\n");
      out.write("               var currentContacts =");
      out.print( bd.getContacts().getContact().size() - 1);
      out.write(";\n");
      out.write("               var currentcatkeyref =");
      out.print(bd.getCategoryBag().getKeyedReference().size());
      out.write(";\n");
      out.write("               var currentcatkeyrefgrp =");
      out.print(bd.getCategoryBag().getKeyedReferenceGroup().size());
      out.write(";\n");
      out.write("               var currentident =");
      out.print(bd.getIdentifierBag().getKeyedReference().size());
      out.write(";\n");
      out.write("               ");

                int contactnames=0;
                int contactemails=0;
                int contactdescriptions=0;
                int contactphones=0;
                int contactaddresses=0;
                int contactaddressLines=0;
                if (bd.getContacts()!=null){
                        for (int i=0; i < bd.getContacts().getContact().size(); i++){
                                contactnames += bd.getContacts().getContact().get(i).getPersonName().size();
                                contactemails+= bd.getContacts().getContact().get(i).getEmail().size();
                                contactdescriptions +=bd.getContacts().getContact().get(i).getDescription().size();
                                contactphones+=bd.getContacts().getContact().get(i).getPhone().size();
                                contactaddresses+=bd.getContacts().getContact().get(i).getAddress().size();
                                for (int k=0; k < bd.getContacts().getContact().get(i).getAddress().size(); k++){
                                        contactaddressLines +=bd.getContacts().getContact().get(i).getAddress().get(k).getAddressLine().size();
                                }
                        }
                }
                int currentcatkeyrefgrpitems=0;
               if (bd.getCategoryBag()!=null){
                       for (int i=0; i < bd.getCategoryBag().getKeyedReferenceGroup().size(); i++){
                               currentcatkeyrefgrpitems+=bd.getCategoryBag().getKeyedReferenceGroup().get(i).getKeyedReference().size();
                       }
               }
               
      out.write("\n");
      out.write("               var contactname=");
      out.print(contactnames);
      out.write(";\n");
      out.write("               var contactemail=");
      out.print(contactemails);
      out.write(";\n");
      out.write("               var contactdescription=");
      out.print(contactdescriptions);
      out.write(";\n");
      out.write("               var contactphone=");
      out.print(contactphones);
      out.write(";\n");
      out.write("               var contactaddress=");
      out.print(contactaddresses);
      out.write(";\n");
      out.write("               var contactaddresslines=");
      out.print(contactaddressLines);
      out.write(";\n");
      out.write("               var currentcatkeyrefgrpitems=");
      out.print(currentcatkeyrefgrpitems);
      out.write(";\n");
      out.write("\n");
      out.write("            </script>\n");
      out.write("\n");
      out.write("            <ul class=\"nav nav-tabs\" id=\"myTab\">\n");
      out.write("               <li class=\"active\"><a  href=\"#general\">");
      out.print(ResourceLoader.GetResource(session, "pages.editor.tabnav.general"));
      out.write("</a></li>\n");
      out.write("\n");
      out.write("               <li><a href=\"#discovery\" >");
      out.print(ResourceLoader.GetResource(session, "pages.editor.tabnav.discovery"));
      out.write("</a></li>\n");
      out.write("               <li><a href=\"#contacts\" >");
      out.print(ResourceLoader.GetResource(session, "pages.editor.tabnav.contacts"));
      out.write("</a></li>\n");
      out.write("               <li><a href=\"#categories\" >");
      out.print(ResourceLoader.GetResource(session, "pages.editor.tabnav.categories"));
      out.write("</a></li>\n");
      out.write("\n");
      out.write("               <li><a href=\"#identifiers\" >");
      out.print(ResourceLoader.GetResource(session, "pages.editor.tabnav.identifiers"));
      out.write("</a></li>\n");
      out.write("               <li><a href=\"#services\" >");
      out.print(ResourceLoader.GetResource(session, "pages.editor.tabnav.services"));
      out.write("</a></li>\n");
      out.write("               <li><a href=\"#signatures\" id=\"sigtagheader\">");
      out.print(ResourceLoader.GetResource(session, "pages.editor.tabnav.signatures"));
      out.write("</a></li>\n");
      out.write("\n");
      out.write("               <li><a href=\"#opinfo\" >");
      out.print(ResourceLoader.GetResource(session, "pages.editor.tabnav.opinfo"));
      out.write("</a></li>\n");
      out.write("               <li><a href=\"#relations\" >");
      out.print(ResourceLoader.GetResource(session, "pages.editor.tabnav.relatedbusinesses"));
      out.write("</a></li>\n");
      out.write("            </ul>\n");
      out.write("            <script>\n");
      out.write("               $(function() {\n");
      out.write("                  $('#myTab').tab;//('show');\n");
      out.write("               })\n");
      out.write("               $('#myTab a[href=#general]').click(function(e) {\n");
      out.write("                  e.preventDefault();\n");
      out.write("                  $(this).tab('show');\n");
      out.write("               });\n");
      out.write("               $('#myTab a[href=#discovery]').click(function(e) {\n");
      out.write("                  e.preventDefault();\n");
      out.write("                  $(this).tab('show');\n");
      out.write("               });\n");
      out.write("               $('#myTab a[href=#contacts]').click(function(e) {\n");
      out.write("                  e.preventDefault();\n");
      out.write("                  $(this).tab('show');\n");
      out.write("               });\n");
      out.write("               $('#myTab a[href=#categories]').click(function(e) {\n");
      out.write("                  e.preventDefault();\n");
      out.write("                  $(this).tab('show');\n");
      out.write("               });\n");
      out.write("               $('#myTab a[href=#identifiers]').click(function(e) {\n");
      out.write("                  e.preventDefault();\n");
      out.write("                  $(this).tab('show');\n");
      out.write("               });\n");
      out.write("               $('#myTab a[href=#services]').click(function(e) {\n");
      out.write("                  e.preventDefault();\n");
      out.write("                  $(this).tab('show');\n");
      out.write("               });\n");
      out.write("               $('#myTab a[href=#signatures]').click(function(e) {\n");
      out.write("                  e.preventDefault();\n");
      out.write("                  $(this).tab('show');\n");
      out.write("               });\n");
      out.write("               $('#myTab a[href=#opinfo]').click(function(e) {\n");
      out.write("                  e.preventDefault();\n");
      out.write("                  $(this).tab('show');\n");
      out.write("               });\n");
      out.write("               $('#myTab a[href=#relations]').click(function(e) {\n");
      out.write("                  e.preventDefault();\n");
      out.write("                  $(this).tab('show');\n");
      out.write("               });\n");
      out.write("\n");
      out.write("            </script>\n");
      out.write("            <div class=\"tab-content\">\n");
      out.write("               <div class=\"tab-pane active\" id=\"general\">\n");
      out.write("                  <a href=\"javascript:AddName();\"><i class=\"icon-plus-sign icon-large\"></i></a> <b>");
      out.print(ResourceLoader.GetResource(session, "items.name"));
      out.write("</b> - \n");
      out.write("                     ");
      out.print(ResourceLoader.GetResource(session, "items.business.name.description"));
      out.write("<div id=\"nameContainer\" style=\"border-width: 2px; border-style: solid;\" >\n");
      out.write("                     ");

                        for (int i = 0; i < bd.getName().size(); i++) {
                           out.write("<div id=\"" + PostBackConstants.NAME + i + "\" style=\"border-width:1px; border-style:solid\" >");
                           out.write("<div style=\"float:left; height:100%\"><a href=\"javascript:Remove('Name" + i + "');\"><i class=\"icon-trash icon-large\"></i></a></div>");
                           out.write("<div style=\"float:left\"> " + ResourceLoader.GetResource(session, "items.value") + ":&nbsp;</div>"
                                   + "<div class=\"edit\" id=\"" + PostBackConstants.NAME + i + PostBackConstants.VALUE + "\">" + (bd.getName().get(i).getValue() != null ? StringEscapeUtils.escapeHtml(bd.getName().get(i).getValue()) : "") + "</div>");
                           out.write("<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.lang") + "&nbsp;</div>"
                                   + "<div class=\"edit\" id=\"" + PostBackConstants.NAME + i + PostBackConstants.LANG + "\">");
                           if (bd.getName().get(i).getLang() != null) {
                              out.write(StringEscapeUtils.escapeHtml(bd.getName().get(i).getLang()));
                           }
                           out.write("</div>");

                           out.write("</div>");
                        }
                     
      out.write("</div>\n");
      out.write("                  <Br>\n");
      out.write("                  <a href=\"javascript:AddDescription();\"><i class=\"icon-plus-sign  icon-large\"></i></a> <b>");
      out.print(ResourceLoader.GetResource(session, "items.description"));
      out.write("</b>- \n");
      out.write("                  ");
      out.print(ResourceLoader.GetResource(session, "items.businesses.description"));
      out.write(".\n");
      out.write("                  <div id=\"Description\" style=\"border-width: 2px; border-style: solid;\" >\n");
      out.write("                     ");

                        for (int i = 0; i < bd.getDescription().size(); i++) {
                           out.write("<div id=\"" + PostBackConstants.DESCRIPTION + i + "\" style=\"border-width:1px; border-style:solid\">");
                           out.write("<div style=\"float:left;height:100%\"><a href=\"javascript:Remove('Description" + i + "');\"><i class=\"icon-trash icon-large\"></i></a></div>");
                           out.write("<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.value") + ":&nbsp;</div>"
                                   + "<div class=\"edit\" id=\"" + PostBackConstants.DESCRIPTION + i + PostBackConstants.VALUE + "\">" + StringEscapeUtils.escapeHtml(bd.getDescription().get(i).getValue()) + "</div>");
                           out.write("<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.lang") + ":&nbsp;</div>"
                                   + "<div class=\"edit\" id=\"" + PostBackConstants.DESCRIPTION + i + PostBackConstants.LANG + "\">"
                                   + (bd.getDescription().get(i).getLang() == null ? "" : StringEscapeUtils.escapeHtml(bd.getDescription().get(i).getLang())) + "</div>");

                           out.write("</div>");
                        }
                     
      out.write("</div>\n");
      out.write("               </div>\n");
      out.write("               <div class=\"tab-pane \" id=\"discovery\">\n");
      out.write("\n");
      out.write("                  <a href=\"javascript:AddDisco();\"><i class=\"icon-plus-sign icon-large\"></i></a>\n");
      out.write("                  <b>");
      out.print(ResourceLoader.GetResource(session, "items.discoveryurl"));
      out.write("</b>- ");
      out.print(ResourceLoader.GetResource(session, "items.discoveryurl.description"));
      out.write("<div id=\"discoContainer\" style=\"border-width: 2px; border-style: solid;\" >\n");
      out.write("                     ");

                        if (bd.getDiscoveryURLs() != null) {
                           for (int i = 0; i < bd.getDiscoveryURLs().getDiscoveryURL().size(); i++) {

                              out.write("<div id=\"disco" + i + "\" style=\"border-width:1px; border-style:solid\">");
                              out.write("<div style=\"float:left;height:100%\"><a href=\"javascript:Remove('disco" + i + "');\"><i class=\"icon-trash icon-large\"></i></a></div>");
                              out.write("<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.value") + ":&nbsp;</div>"
                                      + "<div class=\"edit\" id=\"" + PostBackConstants.DISCOVERYURL + i + PostBackConstants.VALUE + "\">" + StringEscapeUtils.escapeHtml(bd.getDiscoveryURLs().getDiscoveryURL().get(i).getValue()) + "</div>");
                              out.write("<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.type") + ":&nbsp;</div>"
                                      + "<div class=\"edit\" id=\"" + PostBackConstants.DISCOVERYURL + i + PostBackConstants.TYPE + "\">" + StringEscapeUtils.escapeHtml(bd.getDiscoveryURLs().getDiscoveryURL().get(i).getUseType()) + "</div>");

                              out.write("</div>");

                           }
                        }

                     
      out.write("</div>\n");
      out.write("               </div>\n");
      out.write("               <div class=\"tab-pane \" id=\"contacts\">\n");
      out.write("                  <a href=\"javascript:AddContact();\"><i class=\"icon-plus-sign icon-large\"></i></a>\n");
      out.write("                  <b>");
      out.print(ResourceLoader.GetResource(session, "items.contacts"));
      out.write("</b>-\n");
      out.write("                  ");
      out.print(ResourceLoader.GetResource(session, "items.contacts.description"));
      out.write("<br>\n");
      out.write("\n");
      out.write("                  <div id=\"contactsContainer\" style=\"border-width: 2px; border-style: solid;\" >\n");
      out.write("                     ");

                        if (bd.getContacts() == null) {
                           bd.setContacts(new Contacts());
                        }
                        for (int i = 0; i < bd.getContacts().getContact().size(); i++) {
                           //this is the outer framework, the add buttons
                           out.write("<div id=\"" + PostBackConstants.CONTACT_PREFIX + i + "\" style=\"border-width:2px; border-style:solid; border-color:red\" >"
                                   + "<div style=\"float:left;height:100%\"><a href=\"javascript:Remove('" + PostBackConstants.CONTACT_PREFIX + i
                                   + "');\"><i class=\"icon-trash icon-large\"></i></a></div>"
                                   + "<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.contact.type") + ": &nbsp;</div>"
                                   + "<div class=\"edit\" id=\"" + PostBackConstants.CONTACT_PREFIX + i + PostBackConstants.TYPE + "\">"
                                   + (bd.getContacts().getContact().get(i).getUseType()!=null?StringEscapeUtils.escapeHtml(bd.getContacts().getContact().get(i).getUseType()):"")
                                   + "</div>"
                                   + "<a href=\"javascript:AddContactName('" + i + "');\"><i class=\"icon-plus-sign icon-large\"></i></a>" + ResourceLoader.GetResource(session, "items.name") + " &nbsp"
                                   + "<a href=\"javascript:AddContactEmail('" + i + "');\"><i class=\"icon-plus-sign icon-large\"></i></a>" + ResourceLoader.GetResource(session, "items.email") + " &nbsp"
                                   + "<a href=\"javascript:AddContactDescription('" + i + "');\"><i class=\"icon-plus-sign icon-large\"></i></a>" + ResourceLoader.GetResource(session, "items.description") + " &nbsp"
                                   + "<a href=\"javascript:AddContactPhone('" + i + "');\"><i class=\"icon-plus-sign icon-large\"></i></a>" + ResourceLoader.GetResource(session, "items.phone") + " &nbsp"
                                   + "<a href=\"javascript:AddContactAddress('" + i + "');\"><i class=\"icon-plus-sign icon-large\"></i></a>" + ResourceLoader.GetResource(session, "items.address") + " &nbsp");
                           int contactid = i;
                           //person name
                           for (int k = 0; k < bd.getContacts().getContact().get(i).getPersonName().size(); k++) {

                              int contactname = k;
                              out.write("<div id=\"" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.NAME + contactname + "\" style=\"border-width:1px; border-style:solid\" >"
                                      + "<div style=\"float:left;height:100%\"><a href=\"javascript:Remove('" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.NAME + contactname
                                      + "');\"><i class=\"icon-trash icon-large\"></i></a></div>"
                                      + "<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.name") + ": &nbsp;</div>"
                                      + "<div class=\"edit\" id=\"" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.NAME + contactname + PostBackConstants.VALUE + "\">"
                                      + (bd.getContacts().getContact().get(i).getPersonName().get(k).getValue()!=null?StringEscapeUtils.escapeHtml(bd.getContacts().getContact().get(i).getPersonName().get(k).getValue()) :"")
                                   + "</div>"
                                      + "<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.lang") + ": &nbsp;</div>"
                                      + "<div class=\"edit\" id=\"" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.NAME + contactname + PostBackConstants.LANG + "\">"
                                      + (bd.getContacts().getContact().get(i).getPersonName().get(k).getLang() == null ? ""
                                      : StringEscapeUtils.escapeHtml(bd.getContacts().getContact().get(i).getPersonName().get(k).getLang())) + "</div>"
                                      + "</div>");
                              //  + "</div>");
                           }
                           //email
                           for (int k = 0; k < bd.getContacts().getContact().get(i).getEmail().size(); k++) {
                              int contactemail = k;
                              out.write("<div id=\"" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.EMAIL + contactemail + "\" style=\"border-width:1px; border-style:solid\" >"
                                      + "<div style=\"float:left;height:100%\"><a href=\"javascript:Remove('" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.EMAIL + contactemail
                                      + "');\"><i class=\"icon-trash icon-large\"></i></a></div>"
                                      + "<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.type") + ": &nbsp;</div>"
                                      + "<div class=\"edit\" id=\"" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.EMAIL + contactemail + PostBackConstants.TYPE + "\">"
                                      + (bd.getContacts().getContact().get(i).getEmail().get(k).getUseType()!=null?StringEscapeUtils.escapeHtml(bd.getContacts().getContact().get(i).getEmail().get(k).getUseType()):"")
                                      + "</div>"
                                      + "<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.value") + ": &nbsp;</div>"
                                      + "<div class=\"edit\" id=\"" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.EMAIL + contactemail + PostBackConstants.VALUE + "\">"
                                      + (bd.getContacts().getContact().get(i).getEmail().get(k).getValue()!=null?StringEscapeUtils.escapeHtml(bd.getContacts().getContact().get(i).getEmail().get(k).getValue()) :"")
                                      + "</div>"
                                      + "</div>");
                           }
                             //out.write("</div>");
                           //contact description
                           for (int k = 0; k < bd.getContacts().getContact().get(i).getDescription().size(); k++) {
                              int contactdescription = k;
                              out.write("<div id=\"" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.DESCRIPTION + contactdescription + "\" style=\"border-width:1px; border-style:solid\" >"
                                      + "<div style=\"float:left;height:100%\"><a href=\"javascript:Remove('" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.DESCRIPTION + contactdescription
                                      + "');\"><i class=\"icon-trash icon-large\"></i></a></div>"
                                      + "<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.description") + ": &nbsp;</div>"
                                      + "<div class=\"edit\" id=\"" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.DESCRIPTION + contactdescription + PostBackConstants.VALUE + "\">"
                                      + (bd.getContacts().getContact().get(i).getDescription().get(k).getValue()!=null?StringEscapeUtils.escapeHtml(bd.getContacts().getContact().get(i).getDescription().get(k).getValue()):"")
                                      + "</div>"
                                      + "<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.lang") + ": &nbsp;</div>"
                                      + "<div class=\"edit\" id=\"" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.DESCRIPTION + contactdescription + PostBackConstants.LANG + "\">"
                                      + (bd.getContacts().getContact().get(i).getDescription().get(k).getLang()!=null?StringEscapeUtils.escapeHtml(bd.getContacts().getContact().get(i).getDescription().get(k).getLang()):"")
                                      + "</div>" //keep it
                                      + "</div>");
                           }

                           //contact phone
                           for (int k = 0; k < bd.getContacts().getContact().get(i).getPhone().size(); k++) {
                              int contactphone = k;
                              out.write("<div id=\"" + PostBackConstants.CONTACT_PREFIX
                                      + contactid
                                      + PostBackConstants.PHONE
                                      + contactphone
                                      + "\" style=\"border-width:1px; border-style:solid\" >"
                                      + "<div style=\"float:left;height:100%\"><a href=\"javascript:Remove('"
                                      + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.PHONE + contactphone
                                      + "');\"><i class=\"icon-trash icon-large\"></i></a></div>"
                                      + "<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.phone") + ": &nbsp;</div>"
                                      + "<div class=\"edit\" id=\"" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.PHONE + contactphone + PostBackConstants.VALUE + "\">"
                                      + (bd.getContacts().getContact().get(i).getPhone().get(k).getValue()!=null?StringEscapeUtils.escapeHtml(bd.getContacts().getContact().get(i).getPhone().get(k).getValue()):"")
                                      + "</div>"
                                      + "<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.type") + ": &nbsp;</div>"
                                      + "<div class=\"edit\" id=\"" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.PHONE + contactphone + PostBackConstants.TYPE + "\">"
                                      + (bd.getContacts().getContact().get(i).getPhone().get(k).getUseType()!=null?StringEscapeUtils.escapeHtml(bd.getContacts().getContact().get(i).getPhone().get(k).getUseType()):"")
                                      + "</div>"
                                      + "</div>");

                           }

                           //contact addresses
                           for (int k = 0; k < bd.getContacts().getContact().get(i).getAddress().size(); k++) {
                              int contactaddress = k;
                              out.write("<div id=\"" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.ADDRESS + contactaddress + "\" style=\"border-width:1px; border-style:solid\" >"
                                      + "<div style=\"float:left;height:100%\"><a href=\"javascript:Remove('" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.ADDRESS + contactaddress
                                      + "');\"><i class=\"icon-trash icon-large\"></i></a>" + ResourceLoader.GetResource(session, "items.address") + "</div><br>"
                                      + "<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.lang") + ": &nbsp;</div>"
                                      + "<div class=\"edit\" id=\"" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.ADDRESS + contactaddress + PostBackConstants.LANG + "\">"
                                      + (bd.getContacts().getContact().get(i).getAddress().get(k).getLang()!=null ? StringEscapeUtils.escapeHtml(bd.getContacts().getContact().get(i).getAddress().get(k).getLang()):"")
                                      + "</div>"
                                      + "<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.sortcode") + ": &nbsp;</div>"
                                      + "<div class=\"edit\" id=\"" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.ADDRESS + contactaddress + PostBackConstants.SORTCODE + "\">"
                                      + (bd.getContacts().getContact().get(i).getAddress().get(k).getSortCode()!=null ? StringEscapeUtils.escapeHtml(bd.getContacts().getContact().get(i).getAddress().get(k).getSortCode()) : "" )
                                      + "</div>"
                                      + "<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.type") + ": &nbsp;</div>"
                                      + "<div class=\"edit\" id=\"" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.ADDRESS + contactaddress + PostBackConstants.TYPE + "\">"
                                      + (bd.getContacts().getContact().get(i).getAddress().get(k).getUseType()!=null ? StringEscapeUtils.escapeHtml(bd.getContacts().getContact().get(i).getAddress().get(k).getUseType()) : "")
                                      + "</div>"
                                      + "<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.tmodel.key") + " (<a href=\"javascript:tModelModal('" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.ADDRESS + contactaddress + PostBackConstants.KEYNAME + "')\" >" + "<i class=\"icon-list-alt icon-large\"></i>" + ResourceLoader.GetResource(session, "items.picker") + "</a>): &nbsp;</div>"
                                      + "<div class=\"edit\" id=\"" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.ADDRESS + contactaddress + PostBackConstants.KEYNAME + "\">"
                                      + (bd.getContacts().getContact().get(i).getAddress().get(k).getTModelKey()!=null ? StringEscapeUtils.escapeHtml(bd.getContacts().getContact().get(i).getAddress().get(k).getTModelKey()) : "" )
                                      + "</div>"
                                      + "<div><br><a href=\"javascript:AddContactAddressLine('" + contactid + PostBackConstants.ADDRESS + contactaddress + "');\">"
                                      + "<i class=\"icon-plus-sign icon-large\"></i></a> " + ResourceLoader.GetResource(session, "items.addressline.add") + "</div>");

                              for (int j = 0; j < bd.getContacts().getContact().get(i).getAddress().get(k).getAddressLine().size(); j++) {
                                 int contactaddresslines = j;
                                 out.write("<div id=\"" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.ADDRESS + k + PostBackConstants.ADDRESSLINE + contactaddresslines
                                         + "\" style=\"border-width:1px; border-style:solid\" >"
                                         + "<div style=\"float:left;height:100%\"><a href=\"javascript:Remove('" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.ADDRESS + k + PostBackConstants.ADDRESSLINE + contactaddresslines
                                         + "');\"><i class=\"icon-trash icon-large\"></i></a></div>"
                                         + "<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.addressvalue") + ": &nbsp;</div>"
                                         + "<div class=\"edit\" id=\"" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.ADDRESS + k + PostBackConstants.ADDRESSLINE + contactaddresslines + PostBackConstants.VALUE + "\">"
                                         + (bd.getContacts().getContact().get(i).getAddress().get(k).getAddressLine().get(j).getValue()!=null ? StringEscapeUtils.escapeHtml(bd.getContacts().getContact().get(i).getAddress().get(k).getAddressLine().get(j).getValue()):"")
                                         + "</div>"
                                         + "<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.keyname.optional") + ": &nbsp;</div>"
                                         + "<div class=\"edit\" id=\"" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.ADDRESS + k + PostBackConstants.ADDRESSLINE + contactaddresslines + PostBackConstants.KEYNAME + "\">"
                                         + (bd.getContacts().getContact().get(i).getAddress().get(k).getAddressLine().get(j).getKeyName()!=null ? StringEscapeUtils.escapeHtml(bd.getContacts().getContact().get(i).getAddress().get(k).getAddressLine().get(j).getKeyName()) : "")
                                         + "</div>"
                                         + "<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.keyvalue.optional") + ": &nbsp;</div>"
                                         + "<div class=\"edit\" id=\"" + PostBackConstants.CONTACT_PREFIX + contactid + PostBackConstants.ADDRESS + k + PostBackConstants.ADDRESSLINE + contactaddresslines + PostBackConstants.KEYVALUE + "\">"
                                         + (bd.getContacts().getContact().get(i).getAddress().get(k).getAddressLine().get(j).getKeyValue()!=null ? StringEscapeUtils.escapeHtml(bd.getContacts().getContact().get(i).getAddress().get(k).getAddressLine().get(j).getKeyValue()) :"")
                                         + "</div>"
                                         + "</div>");
                              }   //address line loop
                              out.write("</div>");

                           }     //end of address loop
                           out.write("</div>");
                        }//end of contact loop


                     
      out.write("</div><!-- contact container -->\n");
      out.write("               </div><!-- contact tab -->\n");
      out.write("               <div class=\"tab-pane \" id=\"categories\">\n");
      out.write("\n");
      out.write("                  <b>");
      out.print(ResourceLoader.GetResource(session, "pages.editor.tabnav.categories"));
      out.write("</b>- \n");
      out.write("                  ");
      out.print(ResourceLoader.GetResource(session, "items.categories.description"));
      out.write("<br><br>\n");
      out.write("                  <b>");
      out.print(ResourceLoader.GetResource(session, "items.keyrefcats"));
      out.write(":</b><br>\n");
      out.write("                  <a href=\"javascript:AddCategoryKeyReference();\"><i class=\"icon-plus-sign icon-large\"></i></a> ");
      out.print(ResourceLoader.GetResource(session, "items.keyrefcat.add"));
      out.write("<Br>\n");
      out.write("                  ");
      out.write("<div class=\"btn-group\">\n");
      out.write("        <a class=\"btn dropdown-toggle btn-info\" data-toggle=\"dropdown\"  href=\"#\">WSDL/WADL/XML<span class=\"caret\"></span></a>\n");
      out.write("        <ul class=\"dropdown-menu\">\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:wadl:types','uddi-org:types:wadl','wadlDeployment');\">WADL</a></li>\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:wsdl:types','uddi-org:types:wsdl','wsdlDeployment');\">WSDL Types</a></li>\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:wsdl:address','uddi-org:types:wsdl','wsdlDeployment');\">WSDL Address</a></li>\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:wsdl:categorization:protocol','uddi-org:types:wsdl','wsdlDeployment');\">WSDL Protocol</a></li>\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:wsdl:categorization:transport','uddi-org:types:wsdl','wsdlDeployment');\">WSDL Transport</a></li>\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:wsdl:porttypereference','uddi-org:types:wsdl','wsdlDeployment');\">WSDL Port Type</a></li>\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:xml:localname','uddi.org:xml:localname','localName');\">XML Local Name</a></li>\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:xml:namespace','uddi.org:xml:namespace','urn:mynamespace');\">XML Namespace</a></li>\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:bpel:types','uddi.org:bpel:types','bpel');\">BPEL Type</a></li>\n");
      out.write("        </ul>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"btn-group\">\n");
      out.write("        <a class=\"btn dropdown-toggle btn-info\" data-toggle=\"dropdown\"  href=\"#\">");
      out.print(ResourceLoader.GetResource(session, "items.categorizations.uddi"));
      out.write("<span class=\"caret\"></span></a>\n");
      out.write("        <ul class=\"dropdown-menu\">\n");
      out.write("             <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:categorization:general_keywords','uddi-org:general_keywords','keyword');\">Keywords</a></li>\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:ubr:taxonomy:naics','uddi.org:version','1.0');\">Version</a></li>\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:categorization:entitykeyvalues','entityKeyValues','');\">Entity Key Values</a></li>\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:categorization:nodes','uddi.org:categorization:nodes','node');\">UDDI Node</a></li>\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:ubr:identifier:owningbusiness','uddi.org:owningbusiness','businessKey');\">Owning Business</a></li>\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:categorization:validatedby','uddi.org:validatedBy','');\">Validated By</a></li>\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:categorization:derivedfrom','uddi-org:derivedFrom','');\">Derived From</a></li>\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:identifier:isreplacedby','uddi-org:isReplacedBy','');\">Is Replaced By</a></li>\n");
      out.write("       </ul>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"btn-group\">\n");
      out.write("     <a class=\"btn dropdown-toggle btn-info\" data-toggle=\"dropdown\"  href=\"#\">");
      out.print(ResourceLoader.GetResource(session, "items.categorizations"));
      out.write("<span class=\"caret\"></span></a>\n");
      out.write("        <ul class=\"dropdown-menu\">\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:ubr:categorization:iso3166','geoLocation:Baltimore,MD','US-MD');\">ISO 3166 Location</a></li>\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:ubr:categorization:naics:1997','','123456789');\">NAICS 1997</a></li>\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:ubr:categorization:naics:2002','','123456789');\">NAICS 2002</a></li>\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:ubr:categorization:naics:2007','','123456789');\">NAICS 2007</a></li>\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:ubr:categorization:naics:2012','','123456789');\">NAICS 2012</a></li>\n");
      out.write("                <li><a href=\"javascript:AddCategoryKeyReferenceParam('uddi:uddi.org:ubr:categorizationgroup:wgs84','wgs84','');\">World Geodetic System 1984</a></li>\n");
      out.write("       </ul>\n");
      out.write("</div>\n");
      out.write("<br><br>");
      out.write("<div id=\"catContainer\" style=\"border-width: 2px; border-style: solid;\" >\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                     ");

                        if (bd.getCategoryBag() == null) {
                           bd.setCategoryBag(new CategoryBag());
                        }
                        //                        out.write("Keyed Reference Categories:");
                        for (int i = 0; i < bd.getCategoryBag().getKeyedReference().size(); i++) {

                           out.write("<div id=\"" + PostBackConstants.CATBAG_KEY_REF + i + "\" style=\"border-width:2px; border-style:solid\">");
                           out.write("<div style=\"float:left;height:100%\"><a href=\"javascript:Remove('" + PostBackConstants.CATBAG_KEY_REF + i + "');\"><i class=\"icon-trash icon-large\"></i></a></div>");
                           out.write("<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.key") + " (<a href=\"javascript:tModelModal('" + PostBackConstants.CATBAG_KEY_REF + i + PostBackConstants.VALUE + "')\" >"
                                   + "<i class=\"icon-list-alt icon-large\"></i>" + ResourceLoader.GetResource(session, "items.picker") + "</a>) "
                                   + "<a href=\"tmodelEditor.jsp?id=" + URLEncoder.encode(bd.getCategoryBag().getKeyedReference().get(i).getTModelKey(), "UTF8") + "\"><i class=\"icon-zoom-in icon-large\"></i></a>"
                                   + ": &nbsp;</div>"
                                   + "<div class=\"edit\" id=\"" + PostBackConstants.CATBAG_KEY_REF + i + PostBackConstants.VALUE + "\">" + 
                                (bd.getCategoryBag().getKeyedReference().get(i).getTModelKey()!=null?StringEscapeUtils.escapeHtml(bd.getCategoryBag().getKeyedReference().get(i).getTModelKey()):"")
                                + "</div>");
                           out.write("<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.name") + ": &nbsp;</div>"
                                   + "<div class=\"edit\" id=\"" + PostBackConstants.CATBAG_KEY_REF + i + PostBackConstants.KEYNAME + "\">" + 
                                (bd.getCategoryBag().getKeyedReference().get(i).getKeyName()!=null?StringEscapeUtils.escapeHtml(bd.getCategoryBag().getKeyedReference().get(i).getKeyName()):"")
                                + "</div>");
                           out.write("<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.value") + ": &nbsp;</div>"
                                   + "<div class=\"edit\" id=\"" + PostBackConstants.CATBAG_KEY_REF + i + PostBackConstants.KEYVALUE + "\">" + 
                                (bd.getCategoryBag().getKeyedReference().get(i).getKeyValue()!=null?StringEscapeUtils.escapeHtml(bd.getCategoryBag().getKeyedReference().get(i).getKeyValue()) :"")
                                + "</div>");
                           out.write("</div>");
                        }
                     
      out.write("</div>\n");
      out.write("                  <br>\n");
      out.write("                  <b>");
      out.print(ResourceLoader.GetResource(session, "items.keyrefgroup"));
      out.write(":</b><br>\n");
      out.write("                  <a href=\"javascript:AddCategoryKeyReferenceGroup();\"><i class=\"icon-plus-sign icon-large\"></i></a> ");
      out.print(ResourceLoader.GetResource(session, "items.keyrefgroup.add"));
      out.write("<br>\n");
      out.write("                  ");
      out.write("<div class=\"btn-group\">\n");
      out.write("        <a class=\"btn dropdown-toggle btn-info\" data-toggle=\"dropdown\"  href=\"#\">Identifiers<span class=\"caret\"></span></a>\n");
      out.write("        <ul class=\"dropdown-menu\">\n");
      out.write("                <li><a href=\"javascript:AddWGS1984();\">World Geodetic System 1984</a></li>\n");
      out.write("                <li><a href=\"javascript:AddISO3166UNSPSC();\">UNSPSC & ISO3166</a></li>\n");
      out.write("        </ul>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<br><br>");
      out.write("<div id=\"catContainerGrp\" style=\"border-width: 2px; border-style: solid;\" >\n");
      out.write("\n");
      out.write("\n");
      out.write("                     ");

                        for (int i = 0; i < bd.getCategoryBag().getKeyedReferenceGroup().size(); i++) {

                           out.write("<div id=\"" + PostBackConstants.CATBAG_KEY_REF_GRP + i + "\" style=\"border-width:2px; border-style:solid\">"
                                   + "<div style=\"float:left;height:100%\"><a href=\"javascript:Remove('" + PostBackConstants.CATBAG_KEY_REF_GRP + i + "');\"><i class=\"icon-trash icon-large\"></i></a></div>"
                                   + "<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.key") + " (<a href=\"javascript:tModelModal('" + PostBackConstants.CATBAG_KEY_REF_GRP + i + PostBackConstants.VALUE + "')\" >" + "<i class=\"icon-list-alt icon-large\"></i>" + ResourceLoader.GetResource(session, "items.picker") + "</a>) "
                                   + "<a href=\"tmodelEditor.jsp?id=" + URLEncoder.encode(bd.getCategoryBag().getKeyedReferenceGroup().get(i).getTModelKey(), "UTF8") + "\"><i class=\"icon-zoom-in icon-large\"></i></a>"
                                   + ": &nbsp;</div>"
                                   + "<div class=\"edit\" id=\"" + PostBackConstants.CATBAG_KEY_REF_GRP + i + PostBackConstants.VALUE + "\">"
                                   + StringEscapeUtils.escapeHtml(bd.getCategoryBag().getKeyedReferenceGroup().get(i).getTModelKey())
                                   + "</div>"
                                   + "<div id=\"" + PostBackConstants.CATBAG_KEY_REF_GRP + i + PostBackConstants.KEY_REF + "\" style=\"border-width:1px; border-style:solid\">"
                                   + "<div style=\"float:left;height:100%\"><a href=\"javascript:AddCategoryKeyReferenceGroupKeyRef('" + PostBackConstants.CATBAG_KEY_REF_GRP + i + "');\"><i class=\"icon-plus-sign icon-large\"></i></a></div>"
                                   + ResourceLoader.GetResource(session, "items.keyrefcat.add")
                                   + "</div>");
                           for (int k = 0; k < bd.getCategoryBag().getKeyedReferenceGroup().get(i).getKeyedReference().size(); k++) {

                              out.write("<div id=\"" + PostBackConstants.CATBAG_KEY_REF_GRP + i + PostBackConstants.KEY_REF + k + "\" style=\"border-width:1px; border-style:solid\">");
                              out.write("<div style=\"float:left;height:100%\"><a href=\"javascript:Remove('" + PostBackConstants.CATBAG_KEY_REF_GRP + i + PostBackConstants.KEY_REF + k + "');\"><i class=\"icon-trash icon-large\"></i></a></div>");
                              out.write("<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.key") + " (<a href=\"javascript:tModelModal('" + PostBackConstants.CATBAG_KEY_REF_GRP + i + PostBackConstants.KEY_REF + k + PostBackConstants.VALUE + "')\" >" + "<i class=\"icon-list-alt icon-large\"></i>" + ResourceLoader.GetResource(session, "items.picker") + "</a>) "
                                      + "<a href=\"tmodelEditor.jsp?id=" + URLEncoder.encode(bd.getCategoryBag().getKeyedReferenceGroup().get(i).getKeyedReference().get(k).getTModelKey(), "UTF8") + "\"><i class=\"icon-zoom-in icon-large\"></i></a>"
                                      + ": &nbsp;</div>"
                                      + "<div class=\"edit\" id=\"" + PostBackConstants.CATBAG_KEY_REF_GRP + i + PostBackConstants.KEY_REF + k + PostBackConstants.VALUE + "\">" + 
                                   (bd.getCategoryBag().getKeyedReferenceGroup().get(i).getKeyedReference().get(k).getTModelKey()!=null?StringEscapeUtils.escapeHtml(bd.getCategoryBag().getKeyedReferenceGroup().get(i).getKeyedReference().get(k).getTModelKey()):"")
                                   + "</div>");
                              out.write("<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.name") + ":  &nbsp;</div>"
                                      + "<div class=\"edit\" id=\"" + PostBackConstants.CATBAG_KEY_REF_GRP + i + PostBackConstants.KEY_REF + k + PostBackConstants.KEYNAME + "\">" + 
                                   (bd.getCategoryBag().getKeyedReferenceGroup().get(i).getKeyedReference().get(k).getKeyName()!=null?StringEscapeUtils.escapeHtml(bd.getCategoryBag().getKeyedReferenceGroup().get(i).getKeyedReference().get(k).getKeyName()):"")
                                   + "</div>");
                              out.write("<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.value") + ": &nbsp;</div>"
                                      + "<div class=\"edit\" id=\"" + PostBackConstants.CATBAG_KEY_REF_GRP + i + PostBackConstants.KEY_REF + k + PostBackConstants.KEYVALUE + "\">" + 
                                   (bd.getCategoryBag().getKeyedReferenceGroup().get(i).getKeyedReference().get(k).getKeyValue()!=null?StringEscapeUtils.escapeHtml(bd.getCategoryBag().getKeyedReferenceGroup().get(i).getKeyedReference().get(k).getKeyValue()):"")
                                   + "</div>");
                              out.write("</div>");
                           }

                           out.write("</div>");
                        }


                     
      out.write("</div>\n");
      out.write("               </div>\n");
      out.write("               <div class=\"tab-pane \" id=\"identifiers\">\n");
      out.write("                  <b>");
      out.print(ResourceLoader.GetResource(session, "items.identifiers"));
      out.write("</b>- \n");
      out.write("                  ");
      out.print(ResourceLoader.GetResource(session, "items.identifiers.description"));
      out.write("<Br>\n");
      out.write("                  <a href=\"javascript:AddIdentKeyReference();\"><i class=\"icon-plus-sign icon-large\"></i></a> ");
      out.print(ResourceLoader.GetResource(session, "items.keyrefcat.add"));
      out.write("<Br>\n");
      out.write("                  ");
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
      out.write("<div id=\"identContainer\" style=\"border-width: 2px; border-style: solid;\" >\n");
      out.write("                     ");

                        for (int i = 0; i < bd.getIdentifierBag().getKeyedReference().size(); i++) {
                           out.write("<div id=\"identbagkeyref" + i + "\" style=\"border-width:2px; border-style:solid\">");
                           out.write("<div style=\"float:left;height:100%\"><a href=\"javascript:Remove('identbagkeyref" + i + "');\"><i class=\"icon-trash icon-large\"></i></a></div>");
                           out.write("<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.key") + " (<a href=\"javascript:tModelModal('" + PostBackConstants.IDENT_KEY_REF + i + PostBackConstants.VALUE + "')\" >" + "<i class=\"icon-list-alt icon-large\"></i> " + ResourceLoader.GetResource(session, "items.picker") + "</a>) "
                                   + "<a href=\"tmodelEditor.jsp?id=" + URLEncoder.encode(bd.getIdentifierBag().getKeyedReference().get(i).getTModelKey(), "UTF8") + "\"><i class=\"icon-zoom-in icon-large\"></i></a>"
                                   + ":  &nbsp;</div>"
                                   + "<div class=\"edit\" id=\"" + PostBackConstants.IDENT_KEY_REF + i + PostBackConstants.VALUE + "\">" + 
                                (bd.getIdentifierBag().getKeyedReference().get(i).getTModelKey()!=null?
                                     StringEscapeUtils.escapeHtml(bd.getIdentifierBag().getKeyedReference().get(i).getTModelKey()):"")
                                + "</div>");
                           out.write("<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.name") + ":  &nbsp;</div>"
                                   + "<div class=\"edit\" id=\"" + PostBackConstants.IDENT_KEY_REF + i + PostBackConstants.KEYNAME + "\">" + 
                                (bd.getIdentifierBag().getKeyedReference().get(i).getKeyName()!=null?StringEscapeUtils.escapeHtml(bd.getIdentifierBag().getKeyedReference().get(i).getKeyName()) :"")
                                + "</div>");
                           out.write("<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.value") + ": &nbsp;</div>"
                                   + "<div class=\"edit\" id=\"" + PostBackConstants.IDENT_KEY_REF + i + PostBackConstants.KEYVALUE + "\">" + 
                                (bd.getIdentifierBag().getKeyedReference().get(i).getKeyValue()!=null?StringEscapeUtils.escapeHtml(bd.getIdentifierBag().getKeyedReference().get(i).getKeyValue()):"")
                                + "</div>");
                           out.write("</div>");
                        }
                     
      out.write("</div>\n");
      out.write("                  <br><br>\n");
      out.write("               </div>\n");
      out.write("               <div class=\"tab-pane \" id=\"services\">\n");
      out.write("                  <b>");
      out.print(ResourceLoader.GetResource(session, "pages.businesseditor.businesslist"));
      out.write("</b> - \n");
      out.write("                  ");

                     if (bd.getBusinessServices() != null) {
                        out.write(Integer.toString(bd.getBusinessServices().getBusinessService().size()));
                     } else {
                        out.write("0 ");
                     }
                  
      out.print(ResourceLoader.GetResource(session, "pages.businesseditor.businesslist2"));
if (!newitem) {
                  
      out.write("<br>\n");
      out.write("                  <a href=\"serviceEditor.jsp?bizid=");
      out.print(URLEncoder.encode(bd.getBusinessKey(), "UTF-8"));
      out.write("\"><i class=\"icon-plus-sign icon-large\"></i> ");
      out.print(ResourceLoader.GetResource(session, "items.service.add"));
      out.write("</a>\n");
      out.write("                  <br>\n");
      out.write("                  <table class=\"table table-hover\"><tr>\n");
      out.write("                        <th>");
      out.print(ResourceLoader.GetResource(session, "items.name"));
      out.write("</th>\n");
      out.write("                        <th>");
      out.print(ResourceLoader.GetResource(session, "items.key"));
      out.write("</th>\n");
      out.write("                        <th>");
      out.print(ResourceLoader.GetResource(session, "items.bindingtemplate"));
      out.write("</th></tr>\n");
      out.write("                           ");

                              if (bd.getBusinessServices() != null) {
                                 for (int i = 0; i < bd.getBusinessServices().getBusinessService().size(); i++) {
                           
      out.write("<tr>\n");
      out.write("                        <td>");

                           if (!bd.getBusinessServices().getBusinessService().get(i).getName().isEmpty()) {
                              out.write(StringEscapeUtils.escapeHtml(bd.getBusinessServices().getBusinessService().get(i).getName().get(0).getValue()));
                           }
                           
      out.write("</td><td><a href=\"serviceEditor.jsp?id=");
      out.print(URLEncoder.encode(bd.getBusinessServices().getBusinessService().get(i).getServiceKey(),"UTF8"));
      out.write("\">\n");
      out.write("                              ");

                                 out.write(StringEscapeUtils.escapeHtml(bd.getBusinessServices().getBusinessService().get(i).getServiceKey()));
                              
      out.write("<i class=\"icon-edit icon-large\"></i></a>\n");
      out.write("                        </td><td>\n");
      out.write("                           ");

                              if (bd.getBusinessServices().getBusinessService().get(i).getBindingTemplates() == null) {
                                 out.write("0");
                              } else {
                                 out.write(Integer.toString(bd.getBusinessServices().getBusinessService().get(i).getBindingTemplates().getBindingTemplate().size()));
                              }
                           
      out.write("</td>\n");
      out.write("                     </tr>\n");
      out.write("                     ");

                           }
                        }
                     
      out.write("</table>\n");
      out.write("                                    ");

                     }
                  else
                  {
                       out.write("<br><div class=\"alert alert-error\">" + ResourceLoader.GetResource(session, "items.business.noservice") + "</div>");
                  }
                  
      out.write("</div>\n");
      out.write("               <div class=\"tab-pane\" id=\"signatures\"><b>");
      out.print(ResourceLoader.GetResource(session, "items.dsigs"));
      out.write("</b>\n");
      out.write("                  <br>\n");
      out.write("                  ");

                     //icon-exclamation-sign
                     if (bd.getSignature().isEmpty()) {
                        out.write(ResourceLoader.GetResource(session, "items.signed.not"));
                     } else {
                        out.write(ResourceLoader.GetResource(session, "items.signed") + " " + bd.getSignature().size());
                  
      out.write("<table class=\"table table-hover\">\n");
      out.write("                     <tr><th>#</th>\n");
      out.write("                        <th>");
      out.print(ResourceLoader.GetResource(session, "pages.signatures.signedby"));
      out.write("</th>\n");
      out.write("                        <th></th>\n");
      out.write("                        <th>");
      out.print(ResourceLoader.GetResource(session, "pages.signatures.status"));
      out.write("</th></tr>\n");
      out.write("\n");
      out.write("                     ");

                        for (int k = 0; k < bd.getSignature().size(); k++) {
                           out.write("<tr><td>" + k + "</td><td>");
                           out.write(x.SignatureToReadable(bd.getSignature().get(k)));
                           out.write("</td><td>");
                           out.write("<a href=\"ajax/getCert.jsp?type=business&id=" + URLEncoder.encode(bd.getBusinessKey(), "UTF-8") + "&index=" + k + "\">" + ResourceLoader.GetResource(session, "items.signed.viewcert") + "</a>");
                           out.write("</td><td><div id=\"digsig" + k + "\">" + ResourceLoader.GetResource(session, "items.loading") + "</div>");
                     
      out.write("<script type=\"text/javascript\">\n");
      out.write("                        $.get(\"ajax/validateSignature.jsp?type=business&id=");
      out.print(StringEscapeUtils.escapeJavaScript(bd.getBusinessKey()));
      out.write("\", function(data) {\n");
      out.write("                           $(\"#digsig");
      out.print(k);
      out.write("\").html(data);\n");
      out.write("                           if (data.indexOf(\"invalid\") !== -1)\n");
      out.write("                           {\n");
      out.write("                              $(\"#sigtagheader\").html($(\"#sigtagheader\").html() + \"<i class=\\\"icon-thumbs-down icon-large\\\" style=\\\"color:red\\\"></i>\");\n");
      out.write("                           }\n");
      out.write("                           else\n");
      out.write("                           {\n");
      out.write("                              $(\"#sigtagheader\").html($(\"#sigtagheader\").html() + \"<i class=\\\"icon-thumbs-up icon-large\\\" style=\\\"color:green\\\"></i>\");\n");
      out.write("                           }\n");
      out.write("                        })\n");
      out.write("                     </script>\n");
      out.write("                     ");

                           out.write("</td></tr>");
                        }
                     
      out.write("</table>\n");
      out.write("                  ");

                     }
                  
      out.write("</div>\n");
      out.write("\n");
      out.write("               <div class=\"tab-pane\" id=\"opinfo\">\n");
      out.write("                  ");

                     if (!newitem) {
                  
      out.write("<script type=\"text/javascript\">\n");
      out.write("                     $.get(\"ajax/opInfo.jsp?id=");
      out.print(StringEscapeUtils.escapeJavaScript(bd.getBusinessKey()));
      out.write("\", function(data) {\n");
      out.write("                        $(\"#opinfodiv\").html(data);\n");
      out.write("                     })\n");
      out.write("                  </script>\n");
      out.write("                  <div id=\"opinfodiv\"></div>\n");
      out.write("                  ");

                     }
                  
      out.write("</div>\n");
      out.write("               <div class=\"tab-pane\" id=\"relations\">\n");
      out.write("                  ");

                     if (!newitem) {

                  
      out.write("<script type=\"text/javascript\">\n");
      out.write("                     var data2 = new Array();\n");
      out.write("                     data2.push({\n");
      out.write("                        name: \"selection\",\n");
      out.write("                        value: \"key\"});\n");
      out.write("                     data2.push({\n");
      out.write("                        name: \"nonce\",\n");
      out.write("                        value: \"");
      out.print((String) session.getAttribute("nonce"));
      out.write("\"});\n");
      out.write("                     data2.push({\n");
      out.write("                        name: \"searchfor\",\n");
      out.write("                        value: \"RelatedBusiness\"\n");
      out.write("                     });\n");
      out.write("                     data2.push({\n");
      out.write("                        name: \"searchcontent\",\n");
      out.write("                        value: \"");
      out.print(StringEscapeUtils.escapeJavaScript(bd.getBusinessKey()));
      out.write("\"\n");
      out.write("                     });\n");
      out.write("\n");
      out.write("                     $.ajax({url: \"ajax/search.jsp\", type: \"post\", data: data2,\n");
      out.write("                        success: function(x) {\n");
      out.write("                           $(\"#relationresults\").html(x);\n");
      out.write("                        }});\n");
      out.write("\n");
      out.write("                  </script>\n");
      out.write("                  <a href=\"assertions.jsp?fromkey=");
      out.print(URLEncoder.encode(bizid, "UTF-8"));
      out.write("\"> <i class=\"icon-plus-sign icon-large\"></i>\n");
      out.write("                     ");
      out.print(ResourceLoader.GetResource(session, "items.publisherassertion.add"));
      out.write("</a><br>\n");
      out.write("                  <div id=\"relationresults\"></div>\n");
      out.write("\n");
      out.write("                  ");

                     }
                  
      out.write("</div>\n");
      out.write("            </div>\n");
      out.write("         </div>\n");
      out.write("         <div><br>\n");
      out.write("            ");

               if (bd.getSignature().isEmpty()) {
            
      out.write("<a class=\"btn btn-primary \" href=\"javascript:saveBusiness();\"><i class=\"icon-save icon-large\"></i> ");
      out.print(ResourceLoader.GetResource(session, "actions.save"));
      out.write("</a>\n");
      out.write("            ");
  } else {
            
      out.write("<a href=\"#confirmDialog\" role=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\"><i class=\"icon-save icon-large\"></i> ");
      out.print(ResourceLoader.GetResource(session, "actions.save"));
      out.write("</a>\n");
      out.write("\n");
      out.write("            ");
        }
               if (!newitem) {

            
      out.write(" | \n");
      out.write("            <a class=\"btn btn-danger \" href=\"javascript:deleteBusiness();\"><i class=\"icon-trash icon-large\"></i> ");
      out.print(ResourceLoader.GetResource(session, "actions.delete"));
      out.write("</a> |\n");
      out.write("            <a class=\"btn btn-success \" href=\"signer.jsp?id=");
      out.print(URLEncoder.encode(bizid, "UTF-8"));
      out.write("&type=business\"><i class=\"icon-pencil icon-large\"></i> ");
      out.print(ResourceLoader.GetResource(session, "actions.sign"));
      out.write("</a> |\n");
      out.write("            <a class=\"btn btn-info \" href=\"editSubscription.jsp?bizid=");
      out.print(URLEncoder.encode(bizid, "UTF-8"));
      out.write("\" title=\"");
      out.print(ResourceLoader.GetResource(session, "actions.subscribe.description"));
      out.write("\"><i class=\"icon-rss icon-large\"></i> ");
      out.print(ResourceLoader.GetResource(session, "actions.subscribe"));
      out.write("</a> |\n");
      out.write("            <a class=\"btn btn-warning \"  href=\"transfer.jsp?biz=");
      out.print(URLEncoder.encode(bizid, "UTF-8"));
      out.write("\" title=\"");
      out.print(ResourceLoader.GetResource(session, "actions.transfer.description"));
      out.write("\"><i class=\"icon-exchange icon-large\"></i> ");
      out.print(ResourceLoader.GetResource(session, "actions.transfer"));
      out.write("</a> |\n");
      out.write("            <a class=\"btn \"  href=\"javascript:ViewAsXML();\"><i class=\"icon-screenshot icon-large\"></i> ");
      out.print(ResourceLoader.GetResource(session, "actions.asxml"));
      out.write("</a>\n");
      out.write("\n");
      out.write("            ");

            //            <a class="btn "  href="javascript:showAddress();"><i class="icon-screenshot icon-large"></i> Address</a>
                  //TODO for 3.2.1 <a class="btn "  href="javascript:Copy();"><i class="icon-copy icon-large"></i> <%=ResourceLoader.GetResource(session, "actions.copy")% ></a>
               }
            
      out.write("<script type=\"text/javascript\">\n");
      out.write("               Reedit();\n");
      out.write("               ");

                   if (!newitem) {

               
      out.write("\n");
      out.write("                    function showAddress(){\n");
      out.write("                         $(\"#addressInputModal\").modal('show');\n");
      out.write("                    }\n");
      out.write("               function ViewAsXML()\n");
      out.write("               {\n");
      out.write("                  $.get(\"ajax/toXML.jsp?id=");
      out.print(URLEncoder.encode(bizid, "UTF-8"));
      out.write("&type=business\", function(data) {\n");
      out.write("                     window.console && console.log('asXml success');\n");
      out.write("\n");
      out.write("                     $(\"#viewAsXmlContent\").html(safe_tags_replace(data));\n");
      out.write("                     $(\"#viewAsXml\").modal('show');\n");
      out.write("                  });\n");
      out.write("\n");
      out.write("               }\n");
      out.write("               \n");
      out.write("               function saveAnyway(){\n");
      out.write("                  saveBusiness();\n");
      out.write("                  $('#confirmDialog').modal('hide');\n");
      out.write("               }\n");
      out.write("               ");

                   }
               
      out.write("</script>\n");
      out.write("\n");
      out.write("         </div>\n");
      out.write("      </div>\n");
      out.write("   </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("   <div class=\"modal hide fade\" id=\"confirmDialog\">\n");
      out.write("      <div class=\"modal-header\">\n");
      out.write("         <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("         <h3>");
      out.print(ResourceLoader.GetResource(session, "modal.digitalsignaturewarning.title"));
      out.write("</h3>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"modal-body\">\n");
      out.write("         <p>");
      out.print(ResourceLoader.GetResource(session, "modal.digitalsignaturewarning.body"));
      out.write("</p>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"modal-footer\">\n");
      out.write("         <a href=\"javascript:closeXmlPop('confirmDialog');\" class=\"btn\" >");
      out.print(ResourceLoader.GetResource(session, "modal.close"));
      out.write("</a>\n");
      out.write("         <a href=\"javascript:saveAnyway();\" class=\"btn btn-primary\">\n");
      out.write("            ");
      out.print(ResourceLoader.GetResource(session, "modal.savechanges"));
      out.write("</a>\n");
      out.write("      </div>\n");
      out.write("   </div>\n");
      out.write("\n");
      out.write("   ");

      if (!newitem) {

   
      out.write("<div class=\"modal hide fade container\" id=\"viewAsXml\">\n");
      out.write("      <div class=\"modal-header\">\n");
      out.write("         <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("         <h3>");
      out.print(ResourceLoader.GetResource(session, "actions.asxml"));
      out.write("</h3>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"modal-body\" id=\"viewAsXmlContent\">\n");
      out.write("      </div>\n");
      out.write("      <div class=\"modal-footer\">\n");
      out.write("         <a href=\"ajax/toXML.jsp?id=");
      out.print(URLEncoder.encode(bd.getBusinessKey(), "UTF-8"));
      out.write("&type=business\" class=\"btn btn-primary\" target=\"_blank\">\n");
      out.write("              ");
      out.print(ResourceLoader.GetResource(session, "actions.popout"));
      out.write("</a> \n");
      out.write("         <a href=\"javascript:closeXmlPop('viewAsXml');\" class=\"btn\">");
      out.print(ResourceLoader.GetResource(session, "modal.close"));
      out.write("</a>\n");
      out.write("      </div>\n");
      out.write("   </div>\n");
      out.write("   ");

      }
      /*
      <div class="modal hide fade container" id="addressInputModal">
      <div class="modal-header"> 
         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
         <h3>Business Contact Address</h3>
      </div>
      <div class="modal-body" id="addressInputModalBody">
           <input type="text" id="addressinput_tmodelkey" value="uddi:uddi.org:ubr:postaladdress">
           
      </div>
      <div class="modal-footer">
         <a href="#" class="btn btn-primary" target="_blank"><ResourceLoader.GetResource(session, "actions.popout")</a> 
         <button type="button" class="btn" data-dismiss="modal" aria-hidden="true">&times;</button>
      </div>
   </div>
   
      */
   
      out.write("<script type=\"text/javascript\">\n");
      out.write("    function ShowKeyHelp()\n");
      out.write("    {\n");
      out.write("        $(\"#aboutKeys\").modal('show');\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<div class=\"modal hide fade container\" id=\"aboutKeys\">\n");
      out.write("    <div class=\"modal-header\">\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("        <h3>");
      out.print(ResourceLoader.GetResource(session, "navbar.help"));
      out.write("</h3>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"modal-body\">\n");
      out.write("        ");
      out.print(ResourceLoader.GetResource(session, "pages.uddikeys"));
      out.write("</div>\n");
      out.write("    <div class=\"modal-footer\">\n");
      out.write("\n");
      out.write("        <a href=\"javascript:closeXmlPop('aboutKeys');\" class=\"btn\">");
      out.print(ResourceLoader.GetResource(session, "modal.close"));
      out.write("</a>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<div class=\"modal hide fade container\" id=\"tmodelChooser\" tabindex=\"101\">\n");
      out.write("   <div class=\"modal-header\">\n");
      out.write("      <a href=\"javascript:$('#tmodelChooser').modal('hide');\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</a>\n");
      out.write("      <h3>");
      out.print(ResourceLoader.GetResource(session, "items.tmodel.chooser"));
      out.write("</h3>\n");
      out.write("   </div>\n");
      out.write("   <div class=\"modal-body\">\n");
      out.write("\n");
      out.write("      <table class=\"table-bordered table-condensed\">\n");
      out.write("         <tr>\n");
      out.write("            <td>\n");
      out.write("               <table>\n");
      out.write("                  <tr><td>");
      out.print(ResourceLoader.GetResource(session, "totals.records"));
      out.write("</td><td><span id=\"totalrecords\"></span></td></tr>\n");
      out.write("                  <tr><td>");
      out.print(ResourceLoader.GetResource(session, "totals.recordsreturned"));
      out.write("</td><td><span id=\"displayrecords\"></span></td></tr>\n");
      out.write("                  <tr><td>");
      out.print(ResourceLoader.GetResource(session, "totals.offset"));
      out.write("</td><td><span id=\"offset\">0</span></td></tr>\n");
      out.write("               </table>\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("               <table>\n");
      out.write("                  <tr><td>");
      out.print(ResourceLoader.GetResource(session, "items.name"));
      out.write("</td><td><input type=\"text\" id=\"name_tmodel\" value=\"%\"></td></tr>\n");
      out.write("                  <tr><td>");
      out.print(ResourceLoader.GetResource(session, "items.lang"));
      out.write("</td><td><input type=\"text\" id=\"lang_tmodel\" value=\"\"></td></tr>\n");
      out.write("               </table>\n");
      out.write("            </td>\n");
      out.write("            \n");
      out.write("         </tr>\n");
      out.write("      </table>\n");
      out.write("\n");
      out.write("      <a href=\"javascript:pagedownChooserTmodel();\"><i class=\"icon-circle-arrow-left disabled icon-2x\" id=\"pageup\"></i></a>\n");
      out.write("      <a href=\"javascript:reloadTmodelModal();\"><i class=\"icon-refresh icon-2x\"></i></a>\n");
      out.write("      <a href=\"javascript:pageupChooserTmodel();\"><i class=\"icon-circle-arrow-right disabled icon-2x\" id=\"pagedown\"></i></a>\n");
      out.write("\n");
      out.write("      <div id=\"tmodellist\">\n");
      out.write("         <img src=\"img/bigrollergreen.gif\" title=\"Loading\"/>\n");
      out.write("      </div>\n");
      out.write("      <script src=\"js/tmodelsearch.js\"></script>\n");
      out.write("      <script src=\"js/tmodelChooser.js\"></script>\n");
      out.write("      <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("         $(\"#tmodelChooser\").keydown(function(e) {\n");
      out.write("            //if ($(\"#tmodelChooser\").dialog(\"isOpen\") === true)\n");
      out.write("            {\n");
      out.write("               if (e.which == 37) { // left\n");
      out.write("                  pagedownChooserTmodel();\n");
      out.write("               }\n");
      out.write("               else if (e.which == 39) { // right\n");
      out.write("                  pageupChooserTmodel();\n");
      out.write("               }\n");
      out.write("            }\n");
      out.write("         });\n");
      out.write("         $('.edit').editable(function(value, settings) {\n");
      out.write("            window.console && console.log(value + this + settings);\n");
      out.write("            reloadTmodelModal();\n");
      out.write("            //  RenderTmodelListBySearch('%', offset, maxrecords);\n");
      out.write("            return(value);\n");
      out.write("         }, {\n");
      out.write("            type: 'text',\n");
      out.write("            submit: i18n_ok\n");
      out.write("         });\n");
      out.write("         //only init the data when required reloadTmodelModal();\n");
      out.write("      </script>\n");
      out.write("\n");
      out.write("   </div>\n");
      out.write("   <div class=\"modal-footer\">\n");
      out.write("      <a href=\"#\" class=\"btn\" data-dismiss=\"modal\">");
      out.print(ResourceLoader.GetResource(session, "actions.cancel"));
      out.write("</a>\n");
      out.write("      <a href=\"javascript:$('#tmodelChooser').modal('hide');\" class=\"btn btn-primary\" data-dismiss=\"modal\">");
      out.print(ResourceLoader.GetResource(session, "actions.select"));
      out.write("</a>\n");
      out.write("   </div>\n");
      out.write("</div>\n");

//<a href="javascript:tModelCancel();" class="close" class="btn btn-danger">Cancel</a>
//<a href="javascript:tModelModal();" class="btn" >Pick a tModel</a>

      out.write("<!-- container div is in header bottom-->\n");
      out.write("   ");
      out.write("</div> <!-- /container -->\n");
      out.write("</form>\n");
      out.write("<div style=\"\n");
      out.write("     padding: 0px 0px 0px 0px; bottom: 0px; margin: 0px 0px 0px 0px; width:100%; text-align: center; position: fixed; \n");
      out.write("     background-color: white; \n");
      out.write("     \"><center><footer>v");

     out.write(StringEscapeUtils.escapeHtml(org.apache.juddi.v3.client.Release.getRegistryVersion()));
     
      out.write(" - <a href=\"http://www.apache.org\">");
      out.print(ResourceLoader.GetResource(session, "footer.apachecopyright"));
      out.write("</a>. \n");
      out.write("     ");
      out.print(ResourceLoader.GetResource(session, "items.nowconnectedto"));
      out.write(": \n");
      out.write("     ");
      out.print(StringEscapeUtils.escapeHtml(UddiHub.getInstance(application, session).getNodeName()) );
      out.write("</footer></center></div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
