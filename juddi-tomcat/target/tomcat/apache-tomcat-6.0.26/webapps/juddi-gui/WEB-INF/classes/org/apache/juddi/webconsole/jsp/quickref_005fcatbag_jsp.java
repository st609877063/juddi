package org.apache.juddi.webconsole.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.juddi.webconsole.resources.ResourceLoader;

public final class quickref_005fcatbag_jsp extends org.apache.sling.scripting.jsp.jasper.runtime.HttpJspBase
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
