package org.apache.juddi.webconsole.jsp.ajax;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.juddi.webconsole.resources.ResourceLoader;
import org.apache.commons.lang.StringEscapeUtils;
import java.util.Properties;
import java.io.InputStream;
import java.net.URL;
import org.apache.juddi.webconsole.AES;
import org.apache.juddi.webconsole.hub.UddiHub;
import org.apache.juddi.webconsole.CrossSiteRequestForgeryException;
import org.apache.juddi.webconsole.hub.UddiHub;

public final class loginpost_jsp extends org.apache.sling.scripting.jsp.jasper.runtime.HttpJspBase
    implements org.apache.sling.scripting.jsp.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/ajax/../csrf.jsp");
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
      out.write("\n");

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


      out.write('\n');
      out.write('\n');
  URL prop = application.getResource("/WEB-INF/config.properties");
        boolean ok = true;
        if (prop == null) { 
                try {
                        prop = application.getResource("WEB-INF/config.properties");
                } catch (Exception e) {
                        // ignore
                }

        }
        if (prop == null) {
                try {
                prop = application.getResource("META-INF/config.properties");
                } catch (Exception e) {
                        // ignore
                }

        }
        if (prop == null) {
                prop = application.getResource("/META-INF/config.properties");

        }
        if (prop == null) {
                response.setStatus(406);

                out.write("Contact the sysadmin. Cannot locate the configuration file.");
                ok = false;
        }

        InputStream in = prop.openStream();
        Properties p = new Properties();
        p.load(in);
        in.close();
        session.setAttribute("username", request.getParameter("username"));
        if (request.getParameter("password") == null || request.getParameter("password").length() == 0) {
                response.setStatus(406);
                ok = false;
                out.write(ResourceLoader.GetResource(session, "error.nopassword"));
        }
        if (request.getParameter("username") == null || request.getParameter("username").length() == 0) {
                response.setStatus(406);
                ok = false;
                out.write(ResourceLoader.GetResource(session, "error.nousername"));
        }
        if (ok) {
                try {
                        session.setAttribute("password", AES.Encrypt(request.getParameter("password"), (String) p.get("key")));
                } catch (Exception ex) {
                        response.setStatus(406);

                        out.write(StringEscapeUtils.escapeHtml(ex.getMessage()));
                }

               //fix for JUDDI-834, do not uncomment UddiHub.reset(request.getSession());
                UddiHub x = UddiHub.getInstance(application, request.getSession());

                String msg = x.verifyLogin();
                if (msg != null) {
                        session.removeAttribute("username");
                        session.removeAttribute("password");
                        out.write(msg);
                                                response.setStatus(406);
                }
        }



      out.write('\n');
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
