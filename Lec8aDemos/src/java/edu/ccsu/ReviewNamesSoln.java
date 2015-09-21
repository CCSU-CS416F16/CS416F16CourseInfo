/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cwilliam
 */
@WebServlet(name = "ReviewNamesSoln", urlPatterns = {"/ReviewNamesSoln","*.reviewSoln"})
public class ReviewNamesSoln extends HttpServlet {

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
            HashSet names = new HashSet();
            ServletContext context = getServletContext();
            if (context.getAttribute("names")!=null){
                names = (HashSet)context.getAttribute("names");
            }
            String name = request.getParameter("name");
            if (name != null && name.length()>0){
                names.add(name);
            }
            context.setAttribute("names", names);
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReviewNamesSoln</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"ReviewNamesSoln\" method=\"GET\">");
            out.println("Enter a name: <input type=\"textbox\" name=\"name\"/><br/>");
            out.println("<input type=\"submit\" value=\"Add name\"/>");
            out.println("</form>");
            out.println("Unique names:<br/>");
            out.println("<ul>");
            Iterator iterator = names.iterator();
            while (iterator.hasNext()){
                name = (String)iterator.next();
                out.println("<li>"+name+"</li>");
            }
            out.println("</ul>");
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
