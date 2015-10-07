package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class TagIndex_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/WEB-INF/tlds/my_tag_library.tld");
    _jspx_dependants.add("/WEB-INF/tags/FieldTag.tag");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>    \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"TagResult.jsp\">\n");
      out.write("            <table>\n");
      out.write("                ");
      if (_jspx_meth_my_LabeledTextField_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                ");
      if (_jspx_meth_my_LabeledTextField_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                ");
      if (_jspx_meth_my_LabeledTextField_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                ");
      if (_jspx_meth_ad_FieldTag_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </table>\n");
      out.write("            <input type=\"submit\" value=\"Submit\" />\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_my_LabeledTextField_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  my:LabeledTextField
    edu.ccsu.customtags.LabeledTextField _jspx_th_my_LabeledTextField_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(edu.ccsu.customtags.LabeledTextField.class) : new edu.ccsu.customtags.LabeledTextField();
    _jspx_th_my_LabeledTextField_0.setJspContext(_jspx_page_context);
    _jspx_th_my_LabeledTextField_0.setLabel("First Name");
    _jspx_th_my_LabeledTextField_0.setName("first");
    _jspx_th_my_LabeledTextField_0.doTag();
    return false;
  }

  private boolean _jspx_meth_my_LabeledTextField_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  my:LabeledTextField
    edu.ccsu.customtags.LabeledTextField _jspx_th_my_LabeledTextField_1 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(edu.ccsu.customtags.LabeledTextField.class) : new edu.ccsu.customtags.LabeledTextField();
    _jspx_th_my_LabeledTextField_1.setJspContext(_jspx_page_context);
    _jspx_th_my_LabeledTextField_1.setLabel("Last Name");
    _jspx_th_my_LabeledTextField_1.setName("last");
    _jspx_th_my_LabeledTextField_1.doTag();
    return false;
  }

  private boolean _jspx_meth_my_LabeledTextField_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  my:LabeledTextField
    edu.ccsu.customtags.LabeledTextField _jspx_th_my_LabeledTextField_2 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(edu.ccsu.customtags.LabeledTextField.class) : new edu.ccsu.customtags.LabeledTextField();
    _jspx_th_my_LabeledTextField_2.setJspContext(_jspx_page_context);
    _jspx_th_my_LabeledTextField_2.setLabel("Street Address");
    _jspx_th_my_LabeledTextField_2.setName("streetAddress");
    _jspx_th_my_LabeledTextField_2.setValue("11 Main St.");
    _jspx_th_my_LabeledTextField_2.doTag();
    return false;
  }

  private boolean _jspx_meth_ad_FieldTag_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ad:FieldTag
    org.apache.jsp.tag.web.FieldTag_tag _jspx_th_ad_FieldTag_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.FieldTag_tag.class) : new org.apache.jsp.tag.web.FieldTag_tag();
    _jspx_th_ad_FieldTag_0.setJspContext(_jspx_page_context);
    _jspx_th_ad_FieldTag_0.setLabel("City");
    _jspx_th_ad_FieldTag_0.setName("city");
    _jspx_th_ad_FieldTag_0.setValue("New Britain");
    _jspx_th_ad_FieldTag_0.doTag();
    return false;
  }
}
