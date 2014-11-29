package org.apache.juddi.webconsole.jsp.js;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.juddi.webconsole.resources.ResourceLoader;

public final class i18n_js_jsp extends org.apache.sling.scripting.jsp.jasper.runtime.HttpJspBase
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
      response.setContentType("application/javascript;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("//<script type=\"text/javascript\">\n");
      out.write("    var i18n_clicktoedit=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.clicktoedit")));
      out.write("\";\n");
      out.write("    var i18n_loading=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.loading")));
      out.write("\";\n");
      out.write("    var i18n_login=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "navbar.login.button")));
      out.write("\";\n");
      out.write("    var il8n_picker=\"");
      out.print( org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.picker")));
      out.write("\";\n");
      out.write("    var i18n_name=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.name")));
      out.write("\";\n");
      out.write("    var i18n_value=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.value")));
      out.write("\";\n");
      out.write("    var i18n_key=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.key")));
      out.write("\";\n");
      out.write("    var i18n_lang=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.lang")));
      out.write("\";\n");
      out.write("    var i18n_email=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.email")));
      out.write("\";\n");
      out.write("    var i18n_type=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.type")));
      out.write("\";\n");
      out.write("    var i18n_ok=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "actions.ok")));
      out.write("\";\n");
      out.write("    var i18n_descriptionAdd=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.description.add")));
      out.write("\";\n");
      out.write("    var i18n_description=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.description")));
      out.write("\";\n");
      out.write("    var i18n_contactPrimary=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.contact.primary")));
      out.write("\";\n");
      out.write("    var i18n_contactType=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.contact.type")));
      out.write("\";\n");
      out.write("    var i18n_contactTypeDefault=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.contact.default")));
      out.write("\";\n");
      out.write("    var i18n_address=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.address")));
      out.write("\";\n");
      out.write("    var i18n_addressValue=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.addressvalue")));
      out.write("\";\n");
      out.write("    var i18n_addressDefaultType=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.addresstype.default")));
      out.write("\";\n");
      out.write("    var i18n_addressLineAdd=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.addressline.add")));
      out.write("\";\n");
      out.write("    \n");
      out.write("    var i18n_keyname_optional=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.keyname.optional")));
      out.write("\";\n");
      out.write("    var i18n_keyvalue_optional=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.keyvalue.optional")));
      out.write("\";\n");
      out.write("    \n");
      out.write("    var i18n_addrefcat=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.keyrefcat.add")));
      out.write("\"; \n");
      out.write("    \n");
      out.write("    var i18n_addressSortCode=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.sortcode")));
      out.write("\";\n");
      out.write("    var i18n_phone=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.phone")));
      out.write("\";\n");
      out.write("    \n");
      out.write("    var i18n_phoneType=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.phone.types")));
      out.write("\";\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    var i18n_bindingTemplateKey=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.bindingtemplate.key")));
      out.write("\";\n");
      out.write("    var i18n_bindingTemplateDescriptionAdd=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.bindingtemplate.description.add")));
      out.write("\";\n");
      out.write("    var i18n_accesspoint=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.accesspoint")));
      out.write("\";\n");
      out.write("    var i18n_accesspointType=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.accesspoint.type")));
      out.write("\";\n");
      out.write("    var i18n_accesspointValue=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.accesspoint.value")));
      out.write("\";\n");
      out.write("    \n");
      out.write("    var i18n_tmodelinstanceinfo=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.tmodelinstance.info")));
      out.write("\";\n");
      out.write("    var i18n_tmodelinstanceinfoDescription=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.tmodelinstance.info.desc")));
      out.write("\";\n");
      out.write("    var i18n_tmodelinstanceinfoAdd=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.tmodelinstance.add")));
      out.write("\";\n");
      out.write("    var i18n_bindingTemplateKeyRefCat=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.bindingtemplate.keyrefcat")));
      out.write("\";\n");
      out.write("    var i18n_bindingTemplateKeyRefCatGrp=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.bindingtemplate.keyrefgrp")));
      out.write("\";\n");
      out.write("    \n");
      out.write("    var i18n_keyRefGrpAdd=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.keyrefgroup.add")));
      out.write("\";\n");
      out.write("    var i18n_accesspointDescription=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.accesspoint.description")));
      out.write("\";\n");
      out.write("    var i18n_tmodelkey=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.tmodel.key")));
      out.write("\";\n");
      out.write("    var i18n_tmodelInstanceParams=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.tmodelinstance.parameters")));
      out.write("\";\n");
      out.write("    var i18n_tmodelInstanceDescription=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.tmodelinstance.description")));
      out.write("\"; \n");
      out.write("    var i18n_tmodelInstanceDescription2=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.tmodelinstance.description2")));
      out.write("\"; \n");
      out.write("    var i18n_tmodelInstanceDescriptionAdd=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.tmodelinstance.description.add")));
      out.write("\"; \n");
      out.write("    \n");
      out.write("    var i18n_overviewdoc=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.overviewurl")));
      out.write("\"; \n");
      out.write("    var i18n_overviewdocDescription=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.overviewurl.description")));
      out.write("\"; \n");
      out.write("    var i18n_overviewdocadd=\"");
      out.print(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(ResourceLoader.GetResource(session, "items.overviewurl.add")));
      out.write("\"; \n");
      out.write("    //items.overviewurl.description.add\n");
      out.write("    //items.name.add\n");
      out.write("    //items.overviewurl.description.add\n");
      out.write("    //items.bindingtemplate.add\n");
      out.write("    //items.bindingtemplate.description.add\n");
      out.write("//</script>");
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
