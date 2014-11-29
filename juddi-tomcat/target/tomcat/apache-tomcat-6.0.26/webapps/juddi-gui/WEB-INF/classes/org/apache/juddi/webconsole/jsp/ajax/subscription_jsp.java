package org.apache.juddi.webconsole.jsp.ajax;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.juddi.webconsole.resources.ResourceLoader;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.juddi.webconsole.hub.builders.Builders;
import org.uddi.sub_v3.Subscription;
import org.apache.juddi.webconsole.hub.UddiHub;

public final class subscription_jsp extends org.apache.sling.scripting.jsp.jasper.runtime.HttpJspBase
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
      org.apache.sling.scripting.jsp.jasper.runtime.JspRuntimeLibrary.include(request, response, "../csrf.jsp", out, false);
      out.write('\n');

    if (request.getMethod().equalsIgnoreCase("POST")) { 
        UddiHub x = UddiHub.getInstance(application, session);
        if (request.getParameter("DELETE") != null) {
             String msg=( x.RemoveSubscription(request.getParameter("DELETE")));
             if (msg.contains(ResourceLoader.GetResource(session, "errors.generic")))
                response.setStatus(406);
             out.write(msg);
        } else {
            AtomicReference<String> outmsg = new AtomicReference<String>();
            Subscription sub = Builders.BuildClientSubscription(request.getParameterMap(), outmsg, session);
            if (sub == null) {
                    response.setStatus(406);
                out.write(outmsg.get());
            } else {
                out.write(x.AddSubscription(sub));
            }
        }
    } else {
        response.setStatus(500);
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
