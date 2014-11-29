package org.apache.juddi.webconsole.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.juddi.v3.client.UDDIConstants;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import javax.xml.datatype.DatatypeFactory;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.uddi.sub_v3.SubscriptionFilter;
import org.apache.juddi.webconsole.hub.builders.SubscriptionHelper;
import java.util.List;
import org.uddi.sub_v3.Subscription;
import java.net.URLEncoder;
import org.uddi.api_v3.*;
import org.apache.juddi.webconsole.PostBackConstants;
import org.apache.juddi.webconsole.hub.*;
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

public final class editSubscription_jsp extends org.apache.sling.scripting.jsp.jasper.runtime.HttpJspBase
    implements org.apache.sling.scripting.jsp.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(10);
    _jspx_dependants.add("/header-top.jsp");
    _jspx_dependants.add("/user/banner.jsp");
    _jspx_dependants.add("/autoLogoutModal.jsp");
    _jspx_dependants.add("/csrf.jsp");
    _jspx_dependants.add("/login.jsp");
    _jspx_dependants.add("/tmodelChooser.jsp");
    _jspx_dependants.add("/bindingChooser.jsp");
    _jspx_dependants.add("/businessChooser.jsp");
    _jspx_dependants.add("/serviceChooser.jsp");
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
      out.write("    <!-- Main hero unit for a primary marketing message or call to action -->\n");
      out.write("    <div class=\"well\">\n");
      out.write("        <h1>");
      out.print(ResourceLoader.GetResource(session, "navbar.subscriptions"));
      out.write("</h1>\n");
      out.write("    </div>\n");
      out.write("    ");

        //TODO use this page as a subscription editor
        Subscription sub = null;
        boolean newitem = false;
        UddiHub x = UddiHub.getInstance(application, session);
        if (request.getParameter("id") != null) {
            sub = x.GetSubscriptionDetails(request.getParameter("id"));
        }
        if (sub == null) {
            sub = new Subscription();
            sub.setMaxEntities(50);
            sub.setBrief(false);
            GregorianCalendar gcal = new GregorianCalendar();
            gcal.setTimeInMillis(System.currentTimeMillis());
            gcal.add(Calendar.YEAR, 1);
            DatatypeFactory df = DatatypeFactory.newInstance();
            sub.setNotificationInterval(df.newDuration(1000 * 60 * 15));
            sub.setExpiresAfter(df.newXMLGregorianCalendar(gcal));
            sub.setSubscriptionFilter(new SubscriptionFilter());
            newitem = true;
            if (request.getParameter("svcid") != null) {
                sub.getSubscriptionFilter().setGetServiceDetail(new GetServiceDetail());
                sub.getSubscriptionFilter().getGetServiceDetail().getServiceKey().add(request.getParameter("svcid"));
            }
            if (request.getParameter("bizid") != null) {
                sub.getSubscriptionFilter().setGetBusinessDetail(new GetBusinessDetail());
                sub.getSubscriptionFilter().getGetBusinessDetail().getBusinessKey().add(request.getParameter("bizid"));
            }
            if (request.getParameter("tid") != null) {
                sub.getSubscriptionFilter().setGetTModelDetail(new GetTModelDetail());
                sub.getSubscriptionFilter().getGetTModelDetail().getTModelKey().add(request.getParameter("tid"));
            }
            if (request.getParameter("bindingTemplate") != null) {
                sub.getSubscriptionFilter().setGetBindingDetail(new GetBindingDetail());
                sub.getSubscriptionFilter().getGetBindingDetail().getBindingKey().add(request.getParameter("bindingTemplate"));
            }

        }

    
      out.write("<!-- Example row of columns -->\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"span12\">\n");
      out.write("            ");
      out.print(ResourceLoader.GetResource(session, "pages.subscription.content"));
      out.write("<div class=\"accordion\" id=\"accordion2\">\n");
      out.write("                <div class=\"accordion-group\">\n");
      out.write("                    <div class=\"accordion-heading\">\n");
      out.write("                        <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#accordion2\" href=\"#collapseOne\">\n");
      out.write("                            ");
      out.print(ResourceLoader.GetResource(session, "pages.subscription.step1"));
      out.write("</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"collapseOne\" class=\"accordion-body collapse in\">\n");
      out.write("                        <div class=\"accordion-inner\">\n");
      out.write("                            <div class=\"btn-group\" id=\"alertType\" data-toggle=\"buttons-radio\">\n");
      out.write("                                <button onclick=\"return toggleType1(false);\" id=\"btn-specificitem\" value=\"specificItem\" class=\"btn ");

                                    if (newitem || SubscriptionHelper.isSpecificItem(sub)) {
                                        out.write(" active");
                                    }
                                        
      out.write("\" >\n");
      out.write("                                    ");
      out.print(ResourceLoader.GetResource(session, "pages.subscription.step1.specific"));
      out.write("</button>\n");
      out.write("                                <button onclick=\"return toggleType1(false);\" id=\"btn-searchresults\" value=\"searchResults\" class=\"btn ");

                                    if (!newitem && !SubscriptionHelper.isSpecificItem(sub)) {
                                        out.write(" active");
                                    }
                                        
      out.write("\">\n");
      out.write("                                    ");
      out.print(ResourceLoader.GetResource(session, "pages.subscription.step1.search"));
      out.write("</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("                        </script>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"accordion-group\">\n");
      out.write("                    <div class=\"accordion-heading\">\n");
      out.write("                        <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#accordion2\" href=\"#collapseTwo\">\n");
      out.write("\n");
      out.write("                            ");
      out.print(ResourceLoader.GetResource(session, "pages.subscription.step2"));
      out.write("</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"collapseTwo\" class=\"accordion-body collapse\">\n");
      out.write("                        <div class=\"accordion-inner\">\n");
      out.write("                            <div id=\"specific\" class=\"");
      out.print(SubscriptionHelper.isSpecificItem(sub) ? "" : "hide");
      out.write("\">\n");
      out.write("                                ");
      out.print(ResourceLoader.GetResource(session, "pages.subscription.specificitem"));
      out.write(":<Br>\n");
      out.write("                                <div class=\"btn-group\" id=\"alertCriteraSingleItem\" data-toggle=\"buttons-radio\">\n");
      out.write("                                    <button onclick=\"javascript:clearbox();\n");
      out.write("                                        return false;\" class=\"btn ");
      out.print(SubscriptionHelper.isBindingSpecific(sub));
      out.write("\" value=\"binding\">");
      out.print(ResourceLoader.GetResource(session, "items.bindingtemplate"));
      out.write("</button>\n");
      out.write("                                    <button onclick=\"javascript:clearbox();\n");
      out.write("                                        return false;\" class=\"btn ");
      out.print(SubscriptionHelper.isBusinessSpecific(sub));
      out.write("\" value=\"business\">");
      out.print(ResourceLoader.GetResource(session, "items.business"));
      out.write("</button>\n");
      out.write("                                    <button onclick=\"javascript:clearbox();\n");
      out.write("                                        return false;\" class=\"btn ");
      out.print(SubscriptionHelper.isServiceSpecific(sub));
      out.write("\" value=\"service\">");
      out.print(ResourceLoader.GetResource(session, "items.service"));
      out.write("</button>\n");
      out.write("                                    <button onclick=\"javascript:clearbox();\n");
      out.write("                                        return false;\" class=\"btn ");
      out.print(SubscriptionHelper.isTModelSpecific(sub));
      out.write("\" value=\"tmodel\">");
      out.print(ResourceLoader.GetResource(session, "items.tmodel"));
      out.write("</button>\n");
      out.write("                                    <button onclick=\"javascript:publisherAssertionPicker();\n");
      out.write("                                        return false;\" class=\"btn ");
      out.print(SubscriptionHelper.isPublisherAssertionSpecific(sub));
      out.write("\" value=\"publisherAssertion\">");
      out.print(ResourceLoader.GetResource(session, "items.publisherassertion.status"));
      out.write("</button>\n");
      out.write("                                </div><br><br>\n");
      out.write("                                <div id=\"keylistcontainer\">\n");
      out.write("                                    <a href=\"javascript:additem();\" class=\"btn\" >");
      out.print(ResourceLoader.GetResource(session, "actions.add"));
      out.write("</a>\n");
      out.write("                                    <a href=\"javascript:removeitem();\" class=\"btn\" >");
      out.print(ResourceLoader.GetResource(session, "actions.remove"));
      out.write("</a> \n");
      out.write("                                    <select  id=\"keylist\" size=\"5\" style=\"width:300px; height: 70px\">\n");
      out.write("                                        ");
      out.print(SubscriptionHelper.getItemKeySpecific(sub));
      out.write("</select>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div id=\"pubassertcontainer\" class=\"\">\n");
      out.write("                                    <div style=\"float:left\">");
      out.print(ResourceLoader.GetResource(session, "items.key"));
      out.write(": &nbsp;</div>\n");
      out.write("                                    <div class=\"\" id=\"itemKey\">");

                                        if (!SubscriptionHelper.isPublisherAssertionSpecific(sub).trim().equals("")) {
                                            out.write(StringEscapeUtils.escapeHtml(SubscriptionHelper.getItemKeySpecific(sub)));
                                        }
                                        
      out.write("</div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"basedonresults\" class=\"");
      out.print(SubscriptionHelper.isSpecificItem(sub) ? "hide" : "");
      out.write("\">\n");
      out.write("                                ");
      out.print(ResourceLoader.GetResource(session, "search.results"));
      out.write(":<br>\n");
      out.write("                                <div class=\"btn-group\" id=\"alertCriteraMultipleItem\" data-toggle=\"buttons-radio\">\n");
      out.write("                                    <button onclick=\"return false;\" class=\"btn ");
      out.print(SubscriptionHelper.isFindBinding(sub));
      out.write("\" value=\"binding\">");
      out.print(ResourceLoader.GetResource(session, "items.bindingtemplate"));
      out.write("</button>\n");
      out.write("                                    <button onclick=\"return false;\" class=\"btn ");
      out.print(SubscriptionHelper.isFindBusiness(sub));
      out.write("\" value=\"business\">");
      out.print(ResourceLoader.GetResource(session, "items.business"));
      out.write("</button>\n");
      out.write("                                    <button onclick=\"return false;\" class=\"btn ");
      out.print(SubscriptionHelper.isFindService(sub));
      out.write("\" value=\"service\">");
      out.print(ResourceLoader.GetResource(session, "items.service"));
      out.write("</button>\n");
      out.write("                                    <button onclick=\"return false;\" class=\"btn ");
      out.print(SubscriptionHelper.isFindTModel(sub));
      out.write("\" value=\"tmodel\">");
      out.print(ResourceLoader.GetResource(session, "items.tmodel"));
      out.write("</button>\n");
      out.write("                                    <button onclick=\"return false;\" class=\"btn ");
      out.print(SubscriptionHelper.isFindRelatedBusinesses(sub));
      out.write("\" value=\"relatedBusiness\">");
      out.print(ResourceLoader.GetResource(session, "pages.editor.tabnav.relatedbusinesses"));
      out.write("</button>\n");
      out.write("                                </div>\n");
      out.write("                                <br><br>\n");
      out.write("                                ");
      out.print(ResourceLoader.GetResource(session, "items.findqualifiers"));
      out.write("<br>\n");
      out.write("                                <table class=\"table\">\n");
      out.write("                                    <tr>\n");
      out.write("\n");
      out.write("                                        <td><input class=\"fq\" type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.AND_ALL_KEYS));
      out.write(" name=\"");
      out.print(UDDIConstants.AND_ALL_KEYS);
      out.write("\" value=\"");
      out.print(UDDIConstants.AND_ALL_KEYS);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.AND_ALL_KEYS);
      out.write("</td>\n");
      out.write("                                        <td><input class=\"fq\" type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.APPROXIMATE_MATCH));
      out.write(" name=\"");
      out.print(UDDIConstants.APPROXIMATE_MATCH);
      out.write("\" value=\"");
      out.print(UDDIConstants.APPROXIMATE_MATCH);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.APPROXIMATE_MATCH);
      out.write("</td>\n");
      out.write("                                        <td><input class=\"fq\"  type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.BINARY_SORT));
      out.write(" name=\"");
      out.print(UDDIConstants.BINARY_SORT);
      out.write("\" value=\"");
      out.print(UDDIConstants.BINARY_SORT);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.BINARY_SORT);
      out.write("</td>\n");
      out.write("                                        <td><input class=\"fq\"  type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.BINDING_SUBSET));
      out.write(" name=\"");
      out.print(UDDIConstants.BINDING_SUBSET);
      out.write("\" value=\"");
      out.print(UDDIConstants.BINDING_SUBSET);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.BINDING_SUBSET);
      out.write("</td>\n");
      out.write("                                        <td><input class=\"fq\"  type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.CASE_INSENSITIVE_MATCH));
      out.write(" name=\"");
      out.print(UDDIConstants.CASE_INSENSITIVE_MATCH);
      out.write("\" value=\"");
      out.print(UDDIConstants.CASE_INSENSITIVE_MATCH);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.CASE_INSENSITIVE_MATCH);
      out.write("</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td><input class=\"fq\"  type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.CASE_INSENSITIVE_SORT));
      out.write(" name=\"");
      out.print(UDDIConstants.CASE_INSENSITIVE_SORT);
      out.write("\" value=\"");
      out.print(UDDIConstants.CASE_INSENSITIVE_SORT);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.CASE_INSENSITIVE_SORT);
      out.write("</td>\n");
      out.write("                                        <td><input class=\"fq\"  type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.CASE_SENSITIVE_MATCH));
      out.write(" name=\"");
      out.print(UDDIConstants.CASE_SENSITIVE_MATCH);
      out.write("\" value=\"");
      out.print(UDDIConstants.CASE_SENSITIVE_MATCH);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.CASE_SENSITIVE_MATCH);
      out.write("</td>\n");
      out.write("                                        <td><input class=\"fq\"  type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.CASE_SENSITIVE_SORT));
      out.write(" name=\"");
      out.print(UDDIConstants.CASE_SENSITIVE_SORT);
      out.write("\" value=\"");
      out.print(UDDIConstants.CASE_SENSITIVE_SORT);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.CASE_SENSITIVE_SORT);
      out.write("</td>\n");
      out.write("                                        <td><input class=\"fq\"  type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.COMBINE_CATEGORY_BAGS));
      out.write(" name=\"");
      out.print(UDDIConstants.COMBINE_CATEGORY_BAGS);
      out.write("\" value=\"");
      out.print(UDDIConstants.COMBINE_CATEGORY_BAGS);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.COMBINE_CATEGORY_BAGS);
      out.write("</td>\n");
      out.write("                                        <td><input class=\"fq\"  type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.DIACRITIC_INSENSITIVE_MATCH));
      out.write(" name=\"");
      out.print(UDDIConstants.DIACRITIC_INSENSITIVE_MATCH);
      out.write("\" value=\"");
      out.print(UDDIConstants.DIACRITIC_INSENSITIVE_MATCH);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.DIACRITIC_INSENSITIVE_MATCH);
      out.write("</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td><input class=\"fq\"  type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.DIACRITIC_SENSITIVE_MATCH));
      out.write(" name=\"");
      out.print(UDDIConstants.DIACRITIC_SENSITIVE_MATCH);
      out.write("\" value=\"");
      out.print(UDDIConstants.DIACRITIC_SENSITIVE_MATCH);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.DIACRITIC_SENSITIVE_MATCH);
      out.write("</td>\n");
      out.write("                                        <td><input class=\"fq\"  type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.EXACT_MATCH));
      out.write(" name=\"");
      out.print(UDDIConstants.EXACT_MATCH);
      out.write("\" value=\"");
      out.print(UDDIConstants.EXACT_MATCH);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.EXACT_MATCH);
      out.write("</td>\n");
      out.write("                                        <td><input class=\"fq\"  type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.OR_ALL_KEYS));
      out.write(" name=\"");
      out.print(UDDIConstants.OR_ALL_KEYS);
      out.write("\" value=\"");
      out.print(UDDIConstants.OR_ALL_KEYS);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.OR_ALL_KEYS);
      out.write("</td>\n");
      out.write("                                        <td><input class=\"fq\"  type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.OR_LIKE_KEYS));
      out.write(" name=\"");
      out.print(UDDIConstants.OR_LIKE_KEYS);
      out.write("\" value=\"");
      out.print(UDDIConstants.OR_LIKE_KEYS);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.OR_LIKE_KEYS);
      out.write("</td>\n");
      out.write("                                        <td><input class=\"fq\"  type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.SERVICE_SUBSET));
      out.write(" name=\"");
      out.print(UDDIConstants.SERVICE_SUBSET);
      out.write("\" value=\"");
      out.print(UDDIConstants.SERVICE_SUBSET);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.SERVICE_SUBSET);
      out.write("</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td><input class=\"fq\"  type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.SIGNATURE_PRESENT));
      out.write(" name=\"");
      out.print(UDDIConstants.SIGNATURE_PRESENT);
      out.write("\" value=\"");
      out.print(UDDIConstants.SIGNATURE_PRESENT);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.SIGNATURE_PRESENT);
      out.write("</td>\n");
      out.write("                                        <td><input class=\"fq\"  type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.SORT_BY_DATE_ASC));
      out.write(" name=\"");
      out.print(UDDIConstants.SORT_BY_DATE_ASC);
      out.write("\" value=\"");
      out.print(UDDIConstants.SORT_BY_DATE_ASC);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.SORT_BY_DATE_ASC);
      out.write("</td>\n");
      out.write("                                        <td><input class=\"fq\"  type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.SORT_BY_DATE_DESC));
      out.write(" name=\"");
      out.print(UDDIConstants.SORT_BY_DATE_DESC);
      out.write("\" value=\"");
      out.print(UDDIConstants.SORT_BY_DATE_DESC);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.SORT_BY_DATE_DESC);
      out.write("</td>\n");
      out.write("                                        <td><input class=\"fq\"  type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.SORT_BY_NAME_ASC));
      out.write(" name=\"");
      out.print(UDDIConstants.SORT_BY_NAME_ASC);
      out.write("\" value=\"");
      out.print(UDDIConstants.SORT_BY_NAME_ASC);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.SORT_BY_NAME_ASC);
      out.write("</td>\n");
      out.write("                                        <td><input class=\"fq\"  type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.SORT_BY_NAME_DESC));
      out.write(" name=\"");
      out.print(UDDIConstants.SORT_BY_NAME_DESC);
      out.write("\" value=\"");
      out.print(UDDIConstants.SORT_BY_NAME_DESC);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.SORT_BY_NAME_DESC);
      out.write("</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td><input class=\"fq\"  type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.SUPPRESS_PROJECTED_SERVICES));
      out.write(" name=\"");
      out.print(UDDIConstants.SUPPRESS_PROJECTED_SERVICES);
      out.write("\" value=\"");
      out.print(UDDIConstants.SUPPRESS_PROJECTED_SERVICES);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.SUPPRESS_PROJECTED_SERVICES);
      out.write("</td>\n");
      out.write("                                        <td><input class=\"fq\"  type=\"checkbox\" ");
      out.print(SubscriptionHelper.containsFindQualifier(sub,UDDIConstants.UTS_10));
      out.write(" name=\"");
      out.print(UDDIConstants.UTS_10);
      out.write("\" value=\"");
      out.print(UDDIConstants.UTS_10);
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(UDDIConstants.UTS_10);
      out.write("</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </table>\n");
      out.write("                                <div>\n");
      out.write("\n");
      out.write("                                    <input type=\"text\" placeholder=\"");
      out.print(ResourceLoader.GetResource(session, "items.name"));
      out.write("...\" id=\"searchcontent\" value=\"");
      out.print(StringEscapeUtils.escapeHtml(SubscriptionHelper.getSearchName(sub)));
      out.write("\">\n");
      out.write("                                    <input type=\"text\" placeholder=\"");
      out.print(ResourceLoader.GetResource(session, "items.lang"));
      out.write("...\" id=\"searchlang\" value=\"");
      out.print(StringEscapeUtils.escapeHtml(SubscriptionHelper.getSearchLang(sub)));
      out.write("\"><br></div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"accordion-group\">\n");
      out.write("                    <div class=\"accordion-heading\">\n");
      out.write("                        <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#accordion2\" href=\"#collapseThree\">\n");
      out.write("                            ");
      out.print(ResourceLoader.GetResource(session, "pages.subscription.step3"));
      out.write("</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"collapseThree\" class=\"accordion-body collapse\">\n");
      out.write("                        <div class=\"accordion-inner\">\n");
      out.write("                            <div class=\"btn-group\" id=\"alertTransport\" data-toggle=\"buttons-radio\">\n");
      out.write("                                <button id=\"btn-bindingTemplate\" onclick=\"return toggleTransport1();\" value=\"bindingTemplate\" class=\"btn ");
      out.print(((sub.getBindingKey() != null && sub.getBindingKey().trim().length()>0)? " active " : ""));
      out.write("\" \n");
      out.write("                                        title=\"");
      out.print(ResourceLoader.GetResource(session, "pages.subscription.step3.direct.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "pages.subscription.step3.direct"));
      out.write("</button>\n");
      out.write("                                <button id=\"btn-manual\" onclick=\"return toggleTransport1();\" value=\"manual\" class=\"btn ");
      out.print(((sub.getBindingKey() == null || sub.getBindingKey().trim().length()==0) ? " active " : ""));
      out.write("\" \n");
      out.write("                                        title=\"");
      out.print(ResourceLoader.GetResource(session, "pages.subscription.step3.pickup.tooltip"));
      out.write('"');
      out.write('>');
      out.print(ResourceLoader.GetResource(session, "pages.subscription.step3.pickup"));
      out.write("</button>\n");
      out.write("                            </div><br>\n");
      out.write("                            <div class=\"");
      out.print(((sub.getBindingKey() != null && sub.getBindingKey().trim().length()>0) ? "" : " hide "));
      out.write("\" id=\"bindingKeyDiv\">\n");
      out.write("                                ");
      out.print(ResourceLoader.GetResource(session, "pages.subscription.step3.content"));
      out.write('<');
      out.write('b');
      out.write('>');
      out.print(UDDIConstants.TRANSPORT_HTTP);
      out.write("</b>.\n");
      out.write("                                <input type=\"text\" id=\"bindingKey\" placeholder=\"");
      out.print(ResourceLoader.GetResource(session, "items.bindingtemplate.key"));
      out.write("\" style=\"width:360px\">\n");
      out.write("                                <button onClick=\"javascript:bindingModal('bindingKey', 'val');\n");
      out.write("                                        return false;\" class=\"btn \">");
      out.print(ResourceLoader.GetResource(session, "actions.select"));
      out.write("</button>\n");
      out.write("                            </div>\n");
      out.write("                            <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("                            </script>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"accordion-group\">\n");
      out.write("                    <div class=\"accordion-heading\">\n");
      out.write("                        <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#accordion2\" href=\"#collapse4\">\n");
      out.write("                            ");
      out.print(ResourceLoader.GetResource(session, "pages.subscription.step4"));
      out.write("</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"collapse4\" class=\"accordion-body collapse\">\n");
      out.write("                        <div class=\"accordion-inner\">\n");
      out.write("                            <a name=\"step4anchor\"></a>\n");
      out.write("                            <div style=\"float:left\">");
      out.print(ResourceLoader.GetResource(session, "items.maxrecords.callback"));
      out.write("<a href=\"#step4anchor\" class=\"uddi_tooltips\" data-toggle=\"tooltip\" data-container=\"body\" title=\"");
      out.print(ResourceLoader.GetResource(session, "items.maxrecords.callback.tooltip"));
      out.write("\"><i class=\"icon-question-sign\"></i></a>: &nbsp;</div>\n");
      out.write("                            <div class=\"edit\" id=\"maxRecords\">");

                                if (sub.getMaxEntities() != null) {
                                    out.write(sub.getMaxEntities().toString());
                                }
                                
      out.write("</div>\n");
      out.write("                            <div style=\"float:left\">");
      out.print(ResourceLoader.GetResource(session, "items.subscriptionbrief"));
      out.write("<a href=\"#step4anchor\" class=\"uddi_tooltips\" data-toggle=\"tooltip\" data-container=\"body\" title=\"");
      out.print(ResourceLoader.GetResource(session, "items.subscriptionbrief.tooltip"));
      out.write("\"><i class=\"icon-question-sign\"></i></a>: &nbsp;</div>\n");
      out.write("                            <div> <input type=\"checkbox\" id=\"brief\" \n");
      out.write("                                         ");

                                             out.write(sub.isBrief() ? "checked" : "");
                                         
      out.write(" >\n");
      out.write("                            </div><br>\n");
      out.write("                            ");
      out.print(ResourceLoader.GetResource(session, "items.expiration"));
      out.write(": \n");
      out.write("                            <div id=\"datetimepicker2\" class=\"input-append date\">\n");
      out.write("                                <input data-format=\"MM/dd/yyyy HH:mm:ss PP\" type=\"text\"  value=\"");

                                    if (sub.getExpiresAfter() != null && !newitem) {
                                        Date d = sub.getExpiresAfter().toGregorianCalendar().getTime();
                                        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
                                        String dateStr = dateFormat.format(d);
                                        if (dateStr != null) {
                                            out.write(StringEscapeUtils.escapeHtml(dateStr));
                                        }
                                    }
                                       
      out.write("\"></input>\n");
      out.write("\n");
      out.write("                                <span class=\"add-on\">\n");
      out.write("                                    <i data-time-icon=\"icon-time\" data-date-icon=\"icon-calendar\">\n");
      out.write("                                    </i>\n");
      out.write("                                </span>\n");
      out.write("                            </div>\n");
      out.write("                            <script type=\"text/javascript\">\n");
      out.write("                                $(document).ready(function() {\n");
      out.write("                                    $('.uddi_tooltips').tooltip();\n");
      out.write("\n");
      out.write("                                    $('#datetimepicker2').datetimepicker({\n");
      out.write("                                        language: '");
      out.print(StringEscapeUtils.escapeJavaScript((String) session.getAttribute("locale")));
      out.write("',\n");
      out.write("                                        pick12HourFormat: true\n");
      out.write("                                    });\n");
      out.write("                                });\n");
      out.write("                            </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <div style=\"\">");
      out.print(ResourceLoader.GetResource(session, "items.notificationinterval"));
      out.write(": &nbsp;</div>\n");
      out.write("\n");
      out.write("                            <div class=\"input-append bootstrap-timepicker\">\n");
      out.write("                                <input id=\"timepicker2\" type=\"text\" class=\"input-small\" placeholder=\"(hh:mm:ss)\" value=\"");

                                    if (sub.getNotificationInterval() != null) {
                                        out.write(sub.getNotificationInterval().getHours() + ":"
                                                + sub.getNotificationInterval().getMinutes() + ":"
                                                + sub.getNotificationInterval().getSeconds());
                                    }
                                       
      out.write("\">\n");
      out.write("                                <span class=\"add-on\">\n");
      out.write("                                    <i class=\"icon-time\"></i>\n");
      out.write("                                </span>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <script type=\"text/javascript\">\n");
      out.write("                                $('#timepicker2').timepicker({\n");
      out.write("                                    minuteStep: 1,\n");
      out.write("                                    defaultTime: '00:05:00',\n");
      out.write("                                    showSeconds: true,\n");
      out.write("                                    template: 'modal',\n");
      out.write("                                    showMeridian: false\n");
      out.write("                                });\n");
      out.write("                            </script>\n");
      out.write("                            <br>\n");
      out.write("\n");
      out.write("                            <div style=\"float:left\">Subscription Key: &nbsp;</div>\n");
      out.write("                            <div class=\"edit\" id=\"subkey\">");

                                if (sub.getSubscriptionKey() != null) {
                                    out.write(StringEscapeUtils.escapeHtml(sub.getSubscriptionKey()));
                                }
                                
      out.write("</div>\n");
      out.write("                                ");
      out.print(ResourceLoader.GetResource(session, "pages.subscription.aboutkeys"));
      out.write("</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <a  class=\"btn btn-primary\" href=\"javascript:saveSubscription();\"><i class=\"icon-save icon-large\"></i> ");
      out.print(ResourceLoader.GetResource(session, "actions.save"));
      out.write("</a>\n");
      out.write("            ");
 if (!newitem){
      out.write("<a  class=\"btn \" href=\"javascript:ViewAsXML();\"><i class=\"icon-screenshot icon-large\"></i> ");
      out.print(ResourceLoader.GetResource(session, "actions.asxml"));
      out.write("</a>\n");
      out.write("                <div class=\"modal hide fade container\" id=\"viewAsXml\">\n");
      out.write("                   <div class=\"modal-header\">\n");
      out.write("                      <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("                      <h3>");
      out.print(ResourceLoader.GetResource(session, "actions.asxml"));
      out.write("</h3>\n");
      out.write("                   </div>\n");
      out.write("\n");
      out.write("                   <div class=\"modal-body\" id=\"viewAsXmlContent\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                   </div>\n");
      out.write("                   <div class=\"modal-footer\">\n");
      out.write("                      <a href=\"ajax/toXML.jsp?id=");
      out.print(URLEncoder.encode(sub.getSubscriptionKey(), "UTF-8"));
      out.write("&type=subscription\" class=\"btn btn-primary\" target=\"_blank\">");
      out.print(ResourceLoader.GetResource(session, "actions.popout"));
      out.write("</a> \n");
      out.write("                      <a href=\"javascript:closeXmlPop('viewAsXml');\" class=\"btn\">");
      out.print(ResourceLoader.GetResource(session, "modal.close"));
      out.write("</a>\n");
      out.write("                   </div>\n");
      out.write("                </div>   \n");
      out.write("                   <script type=\"text/javascript\">\n");
      out.write("         function ViewAsXML()\n");
      out.write("         {\n");
      out.write("            $.get(\"ajax/toXML.jsp?id=");
      out.print(URLEncoder.encode(sub.getSubscriptionKey(), "UTF-8"));
      out.write("&type=subscription\", function(data) {\n");
      out.write("               window.console && console.log('asXml success');\n");
      out.write("               $(\"#viewAsXmlContent\").html(safe_tags_replace(data));\n");
      out.write("               $(\"#viewAsXml\").modal('show');\n");
      out.write("            });\n");
      out.write("\n");
      out.write("         }\n");
      out.write("         </script>\n");
      out.write("            ");
 }
      out.write("</div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"modal hide fade \" id=\"assertionStatusChooser\">\n");
      out.write("        <div class=\"modal-header\">\n");
      out.write("            <a href=\"javascript:$('#assertionStatusChooser').modal('hide');\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</a>\n");
      out.write("            <h3>");
      out.print(ResourceLoader.GetResource(session, "items.assertion.chooser"));
      out.write("</h3>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"modal-body\">\n");
      out.write("            <select id=\"assertionName\" style=\"width:100%\">\n");
      out.write("                ");

                    for (int i = 0; i < CompletionStatus.values().length; i++) {
                        out.write("<option value=\""
                                + StringEscapeUtils.escapeHtml(CompletionStatus.values()[i].toString()) + "\">"
                                + StringEscapeUtils.escapeHtml(CompletionStatus.values()[i].toString()) + "</option>");
                    }
                
      out.write("</select><br>\n");
      out.write("            ");
      out.print(ResourceLoader.GetResource(session, "words.explanation"));
      out.write("<br>\n");
      out.write("            <ul>\n");
      out.write("                ");

                    for (int i = 0; i < CompletionStatus.values().length; i++) {
                        out.write("<li><b>" + StringEscapeUtils.escapeHtml(CompletionStatus.values()[i].toString()) + "</b> = "
                                + ResourceLoader.GetResource(session, "items.subscription.CompletionStatus." + CompletionStatus.values()[i].toString()) + "</li>");
                    }
                
      out.write("</ul>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"modal-footer\">\n");
      out.write("            <a href=\"#\" class=\"btn\" data-dismiss=\"modal\">");
      out.print(ResourceLoader.GetResource(session, "actions.cancel"));
      out.write("</a> | \n");
      out.write("            <a href=\"javascript:assertionSuccess();\" class=\"btn btn-primary\" >");
      out.print(ResourceLoader.GetResource(session, "actions.select"));
      out.write("</a>\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                function assertionSuccess()\n");
      out.write("                {\n");
      out.write("                    $(\"#itemKey\").html($('#assertionName option:selected').val());\n");
      out.write("                    $('#assertionStatusChooser').modal('hide');\n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\" src=\"js/editSubscription.js\"></script>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("        ");

            if (!SubscriptionHelper.isPublisherAssertionSpecific(sub).equals("")) {
                out.write("publisherAssertionPicker();");
            }
        
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    ");
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

      out.write("<div class=\"modal hide fade container \" id=\"bindingChooser\" tabindex=\"103\">\n");
      out.write("   <div class=\"modal-header\">\n");
      out.write("      <a href=\"javascript:$('#bindingChooser').modal('hide');\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</a>\n");
      out.write("      <h3>");
      out.print(ResourceLoader.GetResource(session, "items.binding.chooser"));
      out.write("</h3>\n");
      out.write("   </div>\n");
      out.write("   <div class=\"modal-body\">\n");
      out.write("      <table class=\"table-bordered table-striped\">\n");
      out.write("         <tr>\n");
      out.write("            <td>\n");
      out.write("               <table>\n");
      out.write("                  <tr><td>");
      out.print(ResourceLoader.GetResource(session, "totals.records"));
      out.write("</td><td><span id=\"totalrecordsBinding\"></span></td></tr>\n");
      out.write("                  <tr><td>");
      out.print(ResourceLoader.GetResource(session, "totals.recordsreturned"));
      out.write("</td><td><span id=\"displayrecordsBinding\"></span></td></tr>\n");
      out.write("                  <tr><td>");
      out.print(ResourceLoader.GetResource(session, "totals.offset"));
      out.write("</td><td><span id=\"offsetBinding\">0</span></td></tr>\n");
      out.write("               </table>\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("               <table>\n");
      out.write("\n");
      out.write("                  <tr><td>");
      out.print(ResourceLoader.GetResource(session, "items.name"));
      out.write("</td><td><input type=\"text\" id=\"name_binding\" value=\"%\"></td></tr>\n");
      out.write("                  <tr><td>");
      out.print(ResourceLoader.GetResource(session, "items.lang"));
      out.write("</td><td><input type=\"text\" id=\"lang_binding\" value=\"\"></td></tr>\n");
      out.write("               </table>\n");
      out.write("            </td>\n");
      out.write("         </tr>\n");
      out.write("      </table>\n");
      out.write("      <a href=\"javascript:pagedownChooserBinding();\"><i class=\"icon-circle-arrow-left disabled icon-2x\" id=\"pageupBinding\"></i></a>\n");
      out.write("      <a href=\"javascript:reloadBindingModal();\"><i class=\"icon-refresh icon-2x\"></i></a>\n");
      out.write("      <a href=\"javascript:pageupChooserBinding();\"><i class=\"icon-circle-arrow-right disabled icon-2x\" id=\"pagedownBinding\"></i></a>\n");
      out.write("\n");
      out.write("      <div id=\"bindinglist\">\n");
      out.write("         <img src=\"img/bigrollergreen.gif\" title=\"Loading\"/>\n");
      out.write("      </div>\n");
      out.write("      <script src=\"js/bindingChooser.js\"></script>\n");
      out.write("      <script type=\"text/javascript\">\n");
      out.write("         $(\"#bindingChooser\").keydown(function(e) {\n");
      out.write("            if (e.which == 37) { // left\n");
      out.write("               pagedownChooserBinding();\n");
      out.write("            }\n");
      out.write("            else if (e.which == 39) { // right\n");
      out.write("               pageupChooserBinding();\n");
      out.write("            }\n");
      out.write("         });\n");
      out.write("         $('.edit').editable(function(value, settings) {\n");
      out.write("            window.console && console.log(value + this + settings);\n");
      out.write("            reloadBindingModal();\n");
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
      out.write("      <a href=\"javascript:$('#bindingChooser').modal('hide');\" class=\"btn btn-primary\" data-dismiss=\"modal\">");
      out.print(ResourceLoader.GetResource(session, "actions.select"));
      out.write("</a>\n");
      out.write("   </div>\n");
      out.write("</div>\n");

//<a href="javascript:tModelCancel();" class="close" class="btn btn-danger">Cancel</a>
//<a href="javascript:tModelModal();" class="btn" >Pick a tModel</a>

//<a href="javascript:$('#bindingChooser').modal();" class="btn btn-primary" data-dismiss="modal">< %=ResourceLoader.GetResource(session, "actions.select")% ></a>

      out.write("<div class=\"modal hide fade container \" id=\"businessChooser\" tabindex=\"100\">\n");
      out.write("   <div class=\"modal-header\">\n");
      out.write("      <a href=\"javascript:$('#businessChooser').modal('hide');\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</a>\n");
      out.write("      <h3>");
      out.print(ResourceLoader.GetResource(session, "items.business.chooser"));
      out.write("</h3>\n");
      out.write("   </div>\n");
      out.write("   <div class=\"modal-body\">\n");
      out.write("      <table class=\"table-bordered table-striped\">\n");
      out.write("         <tr>\n");
      out.write("            <td>\n");
      out.write("               <table>\n");
      out.write("                  <tr><td>");
      out.print(ResourceLoader.GetResource(session, "totals.records"));
      out.write("</td><td><span id=\"totalrecordsBusiness\"></span></td></tr>\n");
      out.write("                  <tr><td>");
      out.print(ResourceLoader.GetResource(session, "totals.recordsreturned"));
      out.write("</td><td><span id=\"displayrecordsBusiness\"></span></td></tr>\n");
      out.write("                  <tr><td>");
      out.print(ResourceLoader.GetResource(session, "totals.offset"));
      out.write("</td><td><span id=\"offsetBusiness\">0</span></td></tr>\n");
      out.write("               </table>\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("               <table>\n");
      out.write("                  <tr><td>");
      out.print(ResourceLoader.GetResource(session, "items.name"));
      out.write("</td><td><input type=\"text\" id=\"name_business\" value=\"%\" ></td></tr>\n");
      out.write("                  <tr><td>");
      out.print(ResourceLoader.GetResource(session, "items.lang"));
      out.write("</td><td><input type=\"text\" id=\"lang_business\" ></td></tr>\n");
      out.write("               </table>\n");
      out.write("            </td>\n");
      out.write("         </tr>\n");
      out.write("      </table>\n");
      out.write("      <a href=\"javascript:pagedownChooserBusiness();\"><i class=\"icon-circle-arrow-left disabled icon-2x\" id=\"pageupBusiness\"></i></a>\n");
      out.write("      <a href=\"javascript:reloadBusinessModal();\"><i class=\"icon-refresh icon-2x\"></i></a>\n");
      out.write("      <a href=\"javascript:pageupChooserBusiness();\"><i class=\"icon-circle-arrow-right disabled icon-2x\" id=\"pagedownBusiness\"></i></a>\n");
      out.write("\n");
      out.write("      <div id=\"businesslist\">\n");
      out.write("         <img src=\"img/bigrollergreen.gif\" title=\"Loading\"/>\n");
      out.write("      </div>\n");
      out.write("      <script src=\"js/businessChooser.js\"></script>\n");
      out.write("      <script type=\"text/javascript\">\n");
      out.write("         $(\"#businessChooser\").keydown(function(e) {\n");
      out.write("\n");
      out.write("            if (e.which == 37) { // left\n");
      out.write("               pagedownChooserBusiness();\n");
      out.write("            }\n");
      out.write("            else if (e.which == 39) { // right\n");
      out.write("               pageupChooserBusiness();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("         });\n");
      out.write("         $('.edit').editable(function(value, settings) {\n");
      out.write("            window.console && console.log(value + this + settings);\n");
      out.write("            reloadBusinessModal();\n");
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
      out.write("      <a href=\"javascript:$('#businessChooser').modal('hide');\" class=\"btn btn-primary\" data-dismiss=\"modal\">");
      out.print(ResourceLoader.GetResource(session, "actions.select"));
      out.write("</a>\n");
      out.write("   </div>\n");
      out.write("</div>\n");
      out.write("<div class=\"modal hide fade container \" id=\"serviceChooser\" tabindex=\"102\">\n");
      out.write("   <div class=\"modal-header\">\n");
      out.write("      <a href=\"javascript:$('#serviceChooser').modal('hide');\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</a>\n");
      out.write("      <h3>");
      out.print(ResourceLoader.GetResource(session, "items.service.chooser"));
      out.write("</h3>\n");
      out.write("   </div>\n");
      out.write("   <div class=\"modal-body\">\n");
      out.write("      <table class=\"table-bordered table-condensed\">\n");
      out.write("         <tr>\n");
      out.write("            <td>\n");
      out.write("               <table>\n");
      out.write("                  <tr><td>");
      out.print(ResourceLoader.GetResource(session, "totals.records"));
      out.write("</td><td><span id=\"totalrecordsService\"></span></td></tr>\n");
      out.write("                  <tr><td>");
      out.print(ResourceLoader.GetResource(session, "totals.recordsreturned"));
      out.write("</td><td><span id=\"displayrecordsService\"></span></td></tr>\n");
      out.write("                  <tr><td>");
      out.print(ResourceLoader.GetResource(session, "totals.offset"));
      out.write("</td><td><span id=\"offsetService\">0</span></td></tr>\n");
      out.write("               </table>\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("               <table>\n");
      out.write("                  <tr><td>");
      out.print(ResourceLoader.GetResource(session, "items.name"));
      out.write("</td><td><input type=\"text\" id=\"name_Service\" value=\"%\"></td></tr>\n");
      out.write("                  <tr><td>");
      out.print(ResourceLoader.GetResource(session, "items.lang"));
      out.write("</td><td><input type=\"text\" id=\"lang_Service\" ></td></tr>\n");
      out.write("               </table>\n");
      out.write("            </td>\n");
      out.write("         </tr>\n");
      out.write("      </table>\n");
      out.write("\n");
      out.write("      <a href=\"javascript:pagedownChooserService();\"><i class=\"icon-circle-arrow-left disabled icon-2x\" id=\"pageupService\"></i></a>\n");
      out.write("      <a href=\"javascript:reloadServiceModal();\"><i class=\"icon-refresh icon-2x\"></i></a>\n");
      out.write("      <a href=\"javascript:pageupChooserService();\"><i class=\"icon-circle-arrow-right disabled icon-2x\" id=\"pagedownService\"></i></a>\n");
      out.write("\n");
      out.write("      <div id=\"servicelist\">\n");
      out.write("         <img src=\"img/bigrollergreen.gif\" title=\"Loading\"/>\n");
      out.write("      </div>\n");
      out.write("      <script src=\"js/serviceChooser.js\"></script>\n");
      out.write("      <script type=\"text/javascript\">\n");
      out.write("         $(\"#serviceChooser\").keydown(function(e) {\n");
      out.write("            if (e.which == 37) { // left\n");
      out.write("               pagedownChooserService();\n");
      out.write("            }\n");
      out.write("            else if (e.which == 39) { // right\n");
      out.write("               pageupChooserService();\n");
      out.write("            }\n");
      out.write("         });\n");
      out.write("         $('.edit').editable(function(value, settings) {\n");
      out.write("            window.console && console.log(value + this + settings);\n");
      out.write("            reloadServiceModal();\n");
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
      out.write("      <a href=\"javascript:$('#serviceChooser').modal('hide');\" class=\"btn btn-primary\" data-dismiss=\"modal\">");
      out.print(ResourceLoader.GetResource(session, "actions.select"));
      out.write("</a>\n");
      out.write("   </div>\n");
      out.write("</div>\n");

//<a href="javascript:tModelCancel();" class="close" class="btn btn-danger">Cancel</a>
//<a href="javascript:tModelModal();" class="btn" >Pick a tModel</a>

//<a href="javascript:$('#bindingChooser').modal();" class="btn btn-primary" data-dismiss="modal">< %=ResourceLoader.GetResource(session, "actions.select")% ></a>

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
