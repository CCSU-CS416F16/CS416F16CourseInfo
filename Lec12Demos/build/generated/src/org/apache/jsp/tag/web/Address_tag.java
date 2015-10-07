package org.apache.jsp.tag.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Address_tag
    extends javax.servlet.jsp.tagext.SimpleTagSupport
    implements org.apache.jasper.runtime.JspSourceDependent {


  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private JspContext jspContext;
  private java.io.Writer _jspx_sout;
  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public void setJspContext(JspContext ctx) {
    super.setJspContext(ctx);
    java.util.ArrayList _jspx_nested = null;
    java.util.ArrayList _jspx_at_begin = null;
    java.util.ArrayList _jspx_at_end = null;
    this.jspContext = new org.apache.jasper.runtime.JspContextWrapper(ctx, _jspx_nested, _jspx_at_begin, _jspx_at_end, null);
  }

  public JspContext getJspContext() {
    return this.jspContext;
  }
  private java.lang.String addressType;

  public java.lang.String getAddressType() {
    return this.addressType;
  }

  public void setAddressType(java.lang.String addressType) {
    this.addressType = addressType;
  }

  public Object getDependants() {
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
    if( getAddressType() != null ) {
      _jspx_page_context.setAttribute("addressType", getAddressType());
}

    try {
      out.write("\n");
      out.write("\n");
      out.write("\n");
      edu.ccsu.beans.Address address = null;
      synchronized (request) {
        address = (edu.ccsu.beans.Address) _jspx_page_context.getAttribute("address", PageContext.REQUEST_SCOPE);
        if (address == null){
          address = new edu.ccsu.beans.Address();
          _jspx_page_context.setAttribute("address", address, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<table border=\"1\">\n");
      out.write("    <tr><td colspan=\"2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${addressType}", java.lang.String.class, (PageContext)this.getJspContext(), null));
      out.write("</td></tr>\n");
      out.write("    <tr><td>Street address: </td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${address.streetAddress}", java.lang.String.class, (PageContext)this.getJspContext(), null));
      out.write("</td></tr>\n");
      out.write("    <tr><td>City: </td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${address.city}", java.lang.String.class, (PageContext)this.getJspContext(), null));
      out.write("</td></tr>\n");
      out.write("    <tr><td>State: </td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${address.state}", java.lang.String.class, (PageContext)this.getJspContext(), null));
      out.write("</td></tr>\n");
      out.write("</table>");
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
