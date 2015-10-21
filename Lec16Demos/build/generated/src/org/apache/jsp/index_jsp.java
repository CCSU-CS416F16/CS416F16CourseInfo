package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Review</h1>\n");
      out.write("        <a href=\"AddCity.jsp\">Add city</a><br/>\n");
      out.write("        <a href=\"LookupCityByState.jsp\">Lookup city by state</a><br/>\n");
      out.write("        <h1>Login examples</h1>\n");
      out.write("        <a href=\"AddPersonLogin.jsp\">Add login and person</a><br/>\n");
      out.write("        <a href=\"LoginRetrievalServlet\">Retrieve all logins</a><br/>\n");
      out.write("        <a href=\"AddAddress.jsp\">Add address</a><br/>\n");
      out.write("        <a href=\"AddressRetrievalServlet\">Display addresses</a><br/>\n");
      out.write("        <a href=\"AddPhone.jsp\">Add phone to person</a><br/>\n");
      out.write("        <a href=\"PersonPhonesServlet\">Display people with their phones</a><br/>\n");
      out.write("        <a href=\"PersonRetrievalServlet\">Retrieve all people</a><br/>\n");
      out.write("        <h1>To complete</h1>\n");
      out.write("        <a href=\"AddVenue.jsp\">Add venue</a><br/>\n");
      out.write("        <a href=\"DisplayVenuesServlet\">Display venues</a><br/>\n");
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
}
