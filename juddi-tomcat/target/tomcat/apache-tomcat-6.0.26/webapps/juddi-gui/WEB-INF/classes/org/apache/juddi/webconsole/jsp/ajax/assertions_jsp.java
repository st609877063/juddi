package org.apache.juddi.webconsole.jsp.ajax;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.uddi.api_v3.CompletionStatus;
import org.uddi.api_v3.AssertionStatusItem;
import org.apache.commons.lang.StringEscapeUtils;
import java.util.concurrent.atomic.AtomicReference;
import javax.xml.ws.Holder;
import org.apache.juddi.webconsole.resources.ResourceLoader;
import org.apache.juddi.webconsole.PostBackConstants;
import java.util.List;
import org.uddi.api_v3.PublisherAssertion;
import org.apache.juddi.webconsole.hub.UddiHub;

public final class assertions_jsp extends org.apache.sling.scripting.jsp.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      org.apache.sling.scripting.jsp.jasper.runtime.JspRuntimeLibrary.include(request, response, "../csrf.jsp", out, false);
      out.write('\n');
 
    UddiHub x = UddiHub.getInstance(application, session);
    if (request.getMethod().equalsIgnoreCase("post")) {
        if (request.getParameter("action") != null) {
            String action = request.getParameter("action");
            if (action.equalsIgnoreCase("delete")) {
                String msg = x.DeletePublisherAssertion(request.getParameter("tokey"), request.getParameter("fromkey"), request.getParameter("tmodelkey"), request.getParameter("keyname"), request.getParameter("keyvalue"));
                if (!msg.equals(ResourceLoader.GetResource(session, "actions.saved"))) {
                    response.setStatus(406);
                }
                out.write(msg);
            }
        } else {
            String msg = x.AddPublisherAssertion(request.getParameter("tokey"), request.getParameter("fromkey"), request.getParameter("tmodelkey"), request.getParameter("keyname"), request.getParameter("keyvalue"));
            if (!msg.equals(ResourceLoader.GetResource(session, "actions.saved"))) {
                response.setStatus(406);
            }
            out.write(msg);
        }
    } else {

        List<AssertionStatusItem> data = null;
        AtomicReference<String> msg = new AtomicReference<String>();
        data = x.GetPublisherAssertions(msg);
        if (msg != null && msg.get() != null) {
            out.write(UddiHub.ToErrorAlert(msg.get()));
        } else if (data == null || data.isEmpty())
                //TODO revise this
            out.write(UddiHub.ToErrorAlert(ResourceLoader.GetResource(session, "errors.nodatareturned")));
        else {


      out.write("\n");
      out.write("<table class=\"table table-hover\">\n");
      out.write("    <tr><th>");
      out.print(ResourceLoader.GetResource(session, "items.publisherassertions.from"));
      out.write("</th>\n");
      out.write("        <th>");
      out.print(ResourceLoader.GetResource(session, "items.publisherassertions.to"));
      out.write("</th>\n");
      out.write("        <th>");
      out.print(ResourceLoader.GetResource(session, "items.publisherassertions.relationship"));
      out.write("</th>\n");
      out.write("        <th>");
      out.print(ResourceLoader.GetResource(session, "items.actions"));
      out.write("</th>\n");
      out.write("        <th>");
      out.print(ResourceLoader.GetResource(session, "items.status"));
      out.write("</th>\n");
      out.write("    </tr>\n");
      out.write("        ");

   
        
            for (int i = 0; i < data.size(); i++) {
                out.write("<tr><td>");
                out.write(data.get(i).getFromKey());
                out.write("</td><td>");
                out.write(data.get(i).getToKey());
                out.write("</td><td>");
                if (data.get(i).getKeyedReference() != null) {
                    out.write("<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.key") + " :</div><div id=\"" + PostBackConstants.VALUE + "\" class=\"edit\">" + data.get(i).getKeyedReference().getTModelKey());
                    out.write("<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.name") + " :</div><div id=\"" + PostBackConstants.KEYNAME + "\" class=\"edit\">" + data.get(i).getKeyedReference().getKeyName());
                    out.write("<div style=\"float:left\">" + ResourceLoader.GetResource(session, "items.value") + " :</div><div id=\"" + PostBackConstants.KEYVALUE + "\" class=\"edit\">" + data.get(i).getKeyedReference().getKeyValue());
                }
                out.write("</td><td>");
                if (data.get(i).getCompletionStatus() == CompletionStatus.STATUS_FROM_KEY_INCOMPLETE ||
                        data.get(i).getCompletionStatus() == CompletionStatus.STATUS_TO_KEY_INCOMPLETE)
                                       {
                     out.write("<a class=\"btn btn-primary\" href=\"javascript:approveAssertion('"
                        + StringEscapeUtils.escapeJavaScript(data.get(i).getFromKey())
                        + "','"
                        + StringEscapeUtils.escapeJavaScript(data.get(i).getToKey())
                        + "','"
                        + StringEscapeUtils.escapeJavaScript(data.get(i).getKeyedReference().getTModelKey())
                        + "','"
                        + StringEscapeUtils.escapeJavaScript(data.get(i).getKeyedReference().getKeyName())
                        + "','"
                        + StringEscapeUtils.escapeJavaScript(data.get(i).getKeyedReference().getKeyValue())
                        + "');"
                        + "\">" + ResourceLoader.GetResource(session, "actions.approve") + "</a>");
                }
                out.write("<a class=\"btn btn-primary\" href=\"javascript:removeAssertion('"
                        + StringEscapeUtils.escapeJavaScript(data.get(i).getFromKey())
                        + "','"
                        + StringEscapeUtils.escapeJavaScript(data.get(i).getToKey())
                        + "','"
                        + StringEscapeUtils.escapeJavaScript(data.get(i).getKeyedReference().getTModelKey())
                        + "','"
                        + StringEscapeUtils.escapeJavaScript(data.get(i).getKeyedReference().getKeyName())
                        + "','"
                        + StringEscapeUtils.escapeJavaScript(data.get(i).getKeyedReference().getKeyValue())
                        + "');"
                        + "\">" + ResourceLoader.GetResource(session, "actions.delete") + "</a>");
                out.write("</td><td>");
                out.write(data.get(i).getCompletionStatus().toString());
                out.write("</td></tr>");
                
            }

        
      out.write("\n");
      out.write("</table>\n");

        }
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
