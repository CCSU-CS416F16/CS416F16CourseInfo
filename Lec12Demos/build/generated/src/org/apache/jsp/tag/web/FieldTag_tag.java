package org.apache.jsp.tag.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FieldTag_tag
    extends javax.servlet.jsp.tagext.SimpleTagSupport
    implements org.apache.jasper.runtime.JspSourceDependent {


  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private JspContext jspContext;
  private java.io.Writer _jspx_sout;
  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public void setJspContext(JspContext ctx) {
    super.setJspContext(ctx);
    java.util.ArrayList<String> _jspx_nested = null;
    java.util.ArrayList<String> _jspx_at_begin = null;
    java.util.ArrayList<String> _jspx_at_end = null;
    this.jspContext = new org.apache.jasper.runtime.JspContextWrapper(ctx, _jspx_nested, _jspx_at_begin, _jspx_at_end, null);
  }

  public JspContext getJspContext() {
    return this.jspContext;
  }
  private java.lang.String label;
  private java.lang.String name;
  private java.lang.String value;

  public java.lang.String getLabel() {
    return this.label;
  }

  public void setLabel(java.lang.String label) {
    this.label = label;
  }

  public java.lang.String getName() {
    return this.name;
  }

  public void setName(java.lang.String name) {
    this.name = name;
  }

  public java.lang.String getValue() {
    return this.value;
  }

  public void setValue(java.lang.String value) {
    this.value = value;
  }

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void doTag() throws JspException, java.io.IOException {
    PageContext _jspx_page_context = (PageContext)jspContext;
    HttpServletRequest request = (HttpServletRequest) _jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse) _jspx_page_context.getResponse();
    HttpSession session = _jspx_page_context.getSession();
    ServletContext application = _jspx_page_context.getServletContext();
    ServletConfig config = _jspx_page_context.getServletConfig();
    JspWriter out = jspContext.getOut();
    if( getLabel() != null ) {
      _jspx_page_context.setAttribute("label", getLabel());
}
    if( getName() != null ) {
      _jspx_page_context.setAttribute("name", getName());
}
    if( getValue() != null ) {
      _jspx_page_context.setAttribute("value", getValue());
}

    try {
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("    <th>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${label}", java.lang.String.class, (PageContext)this.getJspContext(), null));
      out.write("</th>\n");
      out.write("    <td><input type=\"text\" name=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${name}", java.lang.String.class, (PageContext)this.getJspContext(), null));
      out.write("\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${value}", java.lang.String.class, (PageContext)this.getJspContext(), null));
      out.write("\"/></td>\n");
      out.write("</tr>\n");
    } catch( Throwable t ) {
      if( t instanceof SkipPageException )
          throw (SkipPageException) t;
      if( t instanceof java.io.IOException )
          throw (java.io.IOException) t;
      if( t instanceof IllegalStateException )
          throw (IllegalStateException) t;
      if( t instanceof JspException )
          throw (JspException) t;
      throw new JspException(t);
    } finally {
      ((org.apache.jasper.runtime.JspContextWrapper) jspContext).syncEndTagFile();
    }
  }
}
