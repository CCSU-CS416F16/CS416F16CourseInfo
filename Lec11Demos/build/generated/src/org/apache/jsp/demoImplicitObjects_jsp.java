package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demoImplicitObjects_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Demonstration of implicit objects</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr><td colspan=\"2\"/>Use of session and context objects:</td></tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>session counter</td>\n");
      out.write("                <td>\n");
      out.write("                    ");

                        Integer sessionCounter = (Integer) session.getAttribute("counter");
                        if (sessionCounter == null) {
                            sessionCounter = new Integer(0);
                        }
                        sessionCounter += 1;
                        session.setAttribute("counter", sessionCounter);
                        out.println(sessionCounter);
                    
      out.write("\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>context counter</td>\n");
      out.write("                <td>\n");
      out.write("                    ");

                        Integer contextCounter = (Integer) application.getAttribute("counter");
                        if (contextCounter == null) {
                            contextCounter = new Integer(1);
                        }
                        contextCounter *= 2;
                        application.setAttribute("counter", contextCounter);
                        out.println(contextCounter);
                    
      out.write("\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("                Read the session attribute using <b>JSP expressions</b>: \n");
      out.write("                ");
      out.print( application.getAttribute("counter") );
      out.write("\n");
      out.write("        <br/>\n");
      out.write("        <a href=\"pageWithError.jsp\">Link to page with error</a>\n");
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
