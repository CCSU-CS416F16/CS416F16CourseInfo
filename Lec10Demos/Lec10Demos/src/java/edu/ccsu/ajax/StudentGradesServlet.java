/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cw1491
 */
@WebServlet(name = "StudentGradesServlet", urlPatterns = {"/StudentGradesServlet"})
public class StudentGradesServlet extends HttpServlet {

    private Map studentGrades = new HashMap();

    public StudentGradesServlet() {
        studentGrades.put("chad", "87");
        studentGrades.put("charles", "89");
        studentGrades.put("calvin", "92");
        studentGrades.put("chuck", "97");
        studentGrades.put("chris", "82");
        studentGrades.put("christine", "94");
        studentGrades.put("charlene", "84");
    }

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            String name = request.getParameter("name");
            out.println("<STUDENTS>");
            Set studentNames = studentGrades.keySet();
            Iterator studentsIter = studentNames.iterator();
            while (studentsIter.hasNext()) {
                String studentName = (String) studentsIter.next();
                String grade = (String) studentGrades.get(studentName);
                out.println("<STUDENT><NAME>" + studentName + "</NAME><GRADE>" + grade + "</GRADE></STUDENT>");
            }
            out.println("</STUDENTS>");
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
