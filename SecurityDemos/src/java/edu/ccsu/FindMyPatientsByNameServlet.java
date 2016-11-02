/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author cwilliam
 */
@WebServlet(name = "FindMyPatientsByNameServlet", urlPatterns = {"/FindMyPatientsByNameServlet"})
public class FindMyPatientsByNameServlet extends HttpServlet {
    @Resource(name="jdbc/Lect8aDB")
    DataSource dataSource;
    
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
            out.println("<title>Servlet DisplayNames</title>");  
            out.println("</head>");
            out.println("<body>");
            String firstName = request.getParameter("firstName");
            if (firstName==null){
                firstName="";
            }

            Connection connection = dataSource.getConnection();
            Statement stmt = connection.createStatement();
            // Simulate being logged in
            request.getSession().setAttribute("user","Chad");
            String user = (String)request.getSession().getAttribute("user");
            // Susceptible to SQL injection
            String sql = "select * from person where authorized = '"+user+"' and firstname = '"+firstName+"'";
            System.out.println("SQL to execute: "+sql);
            ResultSet resultSet = stmt.executeQuery(sql);
            out.println("<h1>Results</h1>");
            while(resultSet.next()){
                out.println("<a href=\"EditPersonServlet?id="+resultSet.getString("id")+"\">");
                out.println(resultSet.getString("firstName")+" "+resultSet.getString("lastName")+"</a><br/>");
            }
            resultSet.close();
            stmt.close();
            connection.close();
            out.println("</body>");
            out.println("</html>");
        }catch(Exception e){
            out.println("Exception occurred "+e.getMessage());
            e.printStackTrace();
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
