package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class resultSoln_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      edu.ccsu.solns.Item item = null;
      synchronized (request) {
        item = (edu.ccsu.solns.Item) _jspx_page_context.getAttribute("item", PageContext.REQUEST_SCOPE);
        if (item == null){
          item = new edu.ccsu.solns.Item();
          _jspx_page_context.setAttribute("item", item, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("item"), request);
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Item name</th>\n");
      out.write("                <td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((edu.ccsu.solns.Item)_jspx_page_context.findAttribute("item")).getItemName())));
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th>Item cost</th>\n");
      out.write("                <td>");
      out.print(item.getItemCost() );
      out.write("</td> \n");
      out.write("                ");
 /* <td><jsp:getProperty name="item" property="itemCost" /></td> */ 
      out.write("\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        ");

            Double totalCost = (Double) session.getAttribute("totalCost");
            if (totalCost == null) {
                totalCost = 0.0;
            }
            totalCost += item.getItemCost();
            session.setAttribute("totalCost", totalCost);
        
      out.write("\n");
      out.write("        Total cost: ");
      out.print(session.getAttribute("totalCost"));
      out.write(" \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("    ");
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
