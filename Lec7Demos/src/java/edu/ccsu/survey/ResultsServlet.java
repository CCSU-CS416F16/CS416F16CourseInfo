/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.survey;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cw1491
 */
@WebServlet(name = "ResultsServlet", urlPatterns = {"/ResultsServlet"})
public class ResultsServlet extends HttpServlet {

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
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResultsServlet</title>");
            out.println("</head>");
            out.println("<body>");
            HttpSession session = request.getSession();
            if (request.getParameter("name") != null) {
                session.setAttribute("name", request.getParameter("name"));
            }
            if (request.getParameter("sex") != null) {
                session.setAttribute("sex", request.getParameter("sex"));
            }
            out.println("Name: " + session.getAttribute("name") + "<br/>");
            out.println("Sex: " + session.getAttribute("sex") + "<br/>");

            
            // Get Info
            ServletContext context = getServletContext();
            Integer numMales = (Integer) context.getAttribute("numMales");
            if (numMales == null) {
                numMales = new Integer(0);
            }
            Integer numFemales = (Integer) context.getAttribute("numFemales");
            if (numFemales == null) {
                numFemales = new Integer(0);
            }
            String sex = request.getParameter("sex");
            if (sex.equals("Male")){
                numMales = new Integer(numMales.intValue()+1);
            }else{
                numFemales = new Integer(numFemales.intValue()+1);
            }
            context.setAttribute("numMales", numMales);
            context.setAttribute("numFemales", numFemales);
            out.println("Site statistics: <br/>");
            out.println("Male: " + (100 * numMales.intValue() / (numMales.intValue()+numFemales.intValue())) + "%<br/>");
            out.println("Female: " + (100 * numFemales.intValue() / (numMales.intValue()+numFemales.intValue())) + "%<br/>");
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
