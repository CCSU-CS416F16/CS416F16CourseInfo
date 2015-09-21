/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;

/**
 *
 * @author cw1491
 */
public class PersistingServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            
            // Session count
            Integer sessionCount = (Integer)session.getAttribute("sessionCount");
            if (sessionCount == null){
                sessionCount = new Integer(1);
                session.setAttribute("sessionCount", sessionCount);
            }else{
                session.setAttribute("sessionCount", new Integer(sessionCount.intValue()+1));
            }
            
            // Context count
            ServletContext context = request.getServletContext();
            Integer contextCount = (Integer)context.getAttribute("contextCount");
            if (contextCount == null){
                contextCount = new Integer(1);
                context.setAttribute("contextCount", contextCount);
            }else{
                context.setAttribute("contextCount", contextCount.intValue()+1);
            }
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PersistingServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Hello " + request.getParameter("name") + "</h1>");
            out.println("Session count="+sessionCount+"<br/>");
            out.println("Context count="+contextCount+"<br/>");
            
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
