package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class beanCounter_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      			"errorPage.jsp", true, 8192, true);
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
      edu.ccsu.BeanCounter pageCounter = null;
      synchronized (_jspx_page_context) {
        pageCounter = (edu.ccsu.BeanCounter) _jspx_page_context.getAttribute("pageCounter", PageContext.PAGE_SCOPE);
        if (pageCounter == null){
          pageCounter = new edu.ccsu.BeanCounter();
          _jspx_page_context.setAttribute("pageCounter", pageCounter, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      edu.ccsu.BeanCounter sessionCounter = null;
      synchronized (session) {
        sessionCounter = (edu.ccsu.BeanCounter) _jspx_page_context.getAttribute("sessionCounter", PageContext.SESSION_SCOPE);
        if (sessionCounter == null){
          sessionCounter = new edu.ccsu.BeanCounter();
          _jspx_page_context.setAttribute("sessionCounter", sessionCounter, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("pageCounter"), request);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("sessionCounter"), "numberOfBeans", request.getParameter("numberOfBeans"), request, "numberOfBeans", false);
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Bean Counter scope page</h1>\n");
      out.write("            Current number of beans:<br/>\n");
      out.write("            Session:");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((edu.ccsu.BeanCounter)_jspx_page_context.findAttribute("sessionCounter")).getNumberOfBeans())));
      out.write("<br/>\n");
      out.write("            Page:");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((edu.ccsu.BeanCounter)_jspx_page_context.findAttribute("pageCounter")).getNumberOfBeans())));
      out.write("<br/>\n");
      out.write("            ");
      out.print( pageCounter.getNumberOfBeans() );
      out.write("\n");
      out.write("        <form action=\"beanCounter.jsp\">            \n");
      out.write("            Number to add:<input type=\"text\" name=\"numberOfBeans\" value=\"0\" /><br/>\n");
      out.write("            <input type=\"submit\" value=\"Add Beans\" />\n");
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
}
