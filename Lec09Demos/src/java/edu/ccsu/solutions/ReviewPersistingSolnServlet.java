/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.solutions;

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
@WebServlet(name = "ReviewPersistingSolnServlet", urlPatterns = {"/ReviewPersistingSolnServlet", "*.reviewSoln"})
public class ReviewPersistingSolnServlet extends HttpServlet {

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
            out.println("<title>Servlet ReviewPersistingServlet</title>");
            out.println("</head>");
            out.println("<body>");

            // Get number of names across sessions (remember it may not have already been set
            Integer numNames = (Integer) getServletContext().getAttribute("numNamesSoln");
            if (numNames == null) {
                numNames = new Integer(0);
            }


            // Get name from request
            String name = request.getParameter("fullname");

            // if name is present it means it is not already on 
            // the session so add it to the session
            if (name != null) {
                HttpSession session = request.getSession();
                session.setAttribute("nameSoln", name);
                // update number of names entered across all sessions (context)
                // if it doesn't already exist in the session you will need to create 
                // the attribute
                ServletContext context = getServletContext();
                numNames = (Integer) context.getAttribute("numNamesSoln");
                if (numNames == null) {
                    numNames = new Integer(0);
                }
                numNames = new Integer(numNames.intValue() + 1);
                context.setAttribute("numNamesSoln", numNames);
            } else {
                name = (String) request.getSession().getAttribute("nameSoln");
            }

            boolean nameInSession = request.getSession().getAttribute("nameSoln") != null;
            // if there is a name already in the session don't do this part
            if (!nameInSession) {
                out.println("<form action=\"ReviewPersistingSolnServlet\" method=\"GET\">");
                out.println("<fieldset>");
                out.println("<legend>Persisting Servlet</legend>");
                out.println("name: <input type=\"text\" name=\"fullname\"/><br/>");
                out.println("<input type=\"submit\" value=\"Submit\" />");
                out.println("</fieldset>");
                out.println("</form>");

            } else {
                out.println("Name=" + name + "<br/>");
            }

            // Print out the number of names entered across all sessions
            out.println("Number of names: " + numNames);

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
