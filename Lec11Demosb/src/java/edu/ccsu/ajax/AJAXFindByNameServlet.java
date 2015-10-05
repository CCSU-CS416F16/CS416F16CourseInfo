/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@WebServlet(name = "AJAXFindByNameServlet", urlPatterns = {"/AJAXFindByNameServlet"})
public class AJAXFindByNameServlet extends HttpServlet {
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
        response.setContentType("application/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String firstNameStart = request.getParameter("firstName");
            if (firstNameStart==null){
                firstNameStart="";
            }
            firstNameStart+="%";
            Connection connection = dataSource.getConnection();
            String selectSQL = "select * from person where firstname like ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectSQL);
            selectStatement.setString(1, firstNameStart);
            ResultSet resultSet = selectStatement.executeQuery();
            //Note I'm only doing this so I can print out the XML document created
            //for explanation purposes only you don't need to create this buffer
            String outString = "";
            //out.println("<PEOPLE>");
            outString += "<PEOPLE>\n";
            while(resultSet.next()){
                //out.println("<PERSON><FIRSTNAME>"+resultSet.getString("firstName")+"</FIRSTNAME><LASTNAME>"+resultSet.getString("lastName")+"</LASTNAME></PERSON>");
              outString += "<PERSON><FIRSTNAME>"+resultSet.getString("firstName")+"</FIRSTNAME><LASTNAME>"+resultSet.getString("lastName")+"</LASTNAME></PERSON>\n";
            }
            //out.println("</PEOPLE>");
            outString += "</PEOPLE>";
            out.println(outString);
            System.out.println(outString);
            resultSet.close();
            selectStatement.close();
            connection.close();
            
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
