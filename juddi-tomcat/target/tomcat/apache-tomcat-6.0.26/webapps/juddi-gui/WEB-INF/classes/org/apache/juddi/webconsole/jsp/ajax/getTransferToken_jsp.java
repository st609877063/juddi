package org.apache.juddi.webconsole.jsp.ajax;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.juddi.webconsole.resources.ResourceLoader;
import javax.xml.bind.JAXB;
import java.io.StringWriter;
import org.apache.juddi.jaxb.PrintUDDI;
import org.uddi.custody_v3.TransferToken;
import javax.xml.datatype.DatatypeFactory;
import java.util.List;
import java.util.ArrayList;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;
import org.apache.juddi.webconsole.hub.UddiHub;
import org.apache.juddi.webconsole.hub.UddiHub;

public final class getTransferToken_jsp extends org.apache.sling.scripting.jsp.jasper.runtime.HttpJspBase
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
      out.write(" \n");
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
      org.apache.sling.scripting.jsp.jasper.runtime.JspRuntimeLibrary.include(request, response, "../csrf.jsp", out, false);
      out.write('\n');

    if (request.getMethod().equalsIgnoreCase("POST")) {
        String keylist = request.getParameter("keylist");
        if (keylist == null) {
            response.setStatus(400);
        } else {

            UddiHub x = UddiHub.getInstance(application, session);
            Holder<byte[]> outToken = new Holder<byte[]>();
            Holder<XMLGregorianCalendar> outXcal = new Holder<XMLGregorianCalendar>();
            DatatypeFactory df = DatatypeFactory.newInstance();
            outXcal.value = df.newXMLGregorianCalendar();
            Holder<String> transferTo = new Holder<String>();
            //transferTo.value = username;
            //  List<String> keys = new ArrayList<String>();

            /*if (tmodellist != null) {
             String[] tmodelkeys = tmodellist.split(",");
             for (int i = 0; i < tmodelkeys.length; i++) {
             keys.add(tmodelkeys[i]);
             }
             }*/
            org.uddi.custody_v3.KeyBag keys = new org.uddi.custody_v3.KeyBag();

            if (keylist != null) {
                String[] keylists = keylist.split(",");

                for (int i = 0; i < keylists.length; i++) {
                    keys.getKey().add(keylists[i]);
                }
            }

            String msg = x.GetCustodyTransferToken(keys, transferTo, outXcal, outToken);
            if (msg != null) {
                out.write(msg);
                response.setStatus(400);
            } else {
                TransferToken tt = new TransferToken();
                tt.setExpirationTime(outXcal.value);
                tt.setNodeID(transferTo.value);
                tt.setOpaqueToken(outToken.value);
                try {
                    StringWriter sw = new StringWriter();
//BREAK is replaced via javascript in a popup
                    sw.write(ResourceLoader.GetResource(session, "actions.savethis") + "  BREAK  ");
                    sw.write(ResourceLoader.GetResource(session, "items.transfertoken") + ": BREAK ");
                    JAXB.marshal(tt, sw);


                    sw.write(" BREAK BREAK" + ResourceLoader.GetResource(session, "items.transferkeys") + ": BREAK ");
                    JAXB.marshal(keys, sw);
                    out.write(sw.toString());


                } catch (Exception ex) {
                    response.setStatus(406);
                    out.write(ex.getMessage());
                }


                //out.write(new String(outToken.value) + "<br>");
            }
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
