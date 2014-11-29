package org.apache.juddi.webconsole.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.juddi.webconsole.resources.ResourceLoader;

public final class serviceChooser_jsp extends org.apache.sling.scripting.jsp.jasper.runtime.HttpJspBase
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
      out.write("<div class=\"modal hide fade container \" id=\"serviceChooser\" tabindex=\"102\">\n");
      out.write("   <div class=\"modal-header\">\n");
      out.write("      <a href=\"javascript:$('#serviceChooser').modal('hide');\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</a>\n");
      out.write("      <h3>");
      out.print(ResourceLoader.GetResource(session, "items.service.chooser"));
      out.write(" </h3>\n");
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

      out.write('\n');
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
