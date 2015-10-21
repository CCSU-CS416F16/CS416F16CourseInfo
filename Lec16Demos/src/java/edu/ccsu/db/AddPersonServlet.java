/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.db;

import edu.ccsu.beans.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author cw1491
 */
@WebServlet(name = "AddPersonServlet", urlPatterns = {"/AddPersonServlet"})
public class AddPersonServlet extends HttpServlet {

    @Resource(name = "jdbc/Lect16DB")
    private DataSource dataSource;

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
            Person newPerson = new Person();
            newPerson.setFirstName(request.getParameter("firstName"));
            newPerson.setLastName(request.getParameter("lastName"));
            newPerson.setAge(request.getParameter("age"));

            // Connect to database
            Connection connection = dataSource.getConnection();

            // Find the max person id to determine what the next person id should be
            String sql = "select max(id) from person";
            PreparedStatement maxIdSelect = connection.prepareStatement(sql);
            ResultSet results = maxIdSelect.executeQuery();
            results.next();
            int maxId = results.getInt(1);
            newPerson.setID(maxId + 1);
            results.close();
            maxIdSelect.close();


            // Add the new person to the DB
            sql = "insert into Person values (?, ?, ?, ?)";
            PreparedStatement insertPerson = connection.prepareStatement(sql);
            insertPerson.setInt(1, newPerson.getID());
            insertPerson.setString(2, newPerson.getFirstName());
            insertPerson.setString(3, newPerson.getLastName());
            if (newPerson.getAge()!=null){
                insertPerson.setInt(4, newPerson.getAge());
            }else{
                insertPerson.setNull(4, Types.INTEGER);
            }
            int recordsAffected = insertPerson.executeUpdate();
            insertPerson.close();
            connection.close();
            if (recordsAffected == 0) {
                out.println("Insert failed");
            } else {
                request.getRequestDispatcher("NamesLikeServlet").forward(request, response);
            }
        } catch (Exception e) {
            out.println("Error Occurred");
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
