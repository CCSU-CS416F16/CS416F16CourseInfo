/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.json;

import java.io.IOException;
import java.io.PrintWriter;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonBuilderFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cwilliam
 */
@WebServlet(name = "AjaxJsonCDDemoServlet", urlPatterns = {"/AjaxJsonCDDemoServlet"})
public class AjaxJsonCDDemoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
            JsonBuilderFactory factory = Json.createBuilderFactory(null);
            JsonArray jsonObj = factory.createArrayBuilder()
                    .add(factory.createObjectBuilder()
                            .add("artist", "Green Day")
                            .add("title", "Dookie")
                            .add("year", 1994)
                            .add("musician", factory.createArrayBuilder()
                                    .add(factory.createObjectBuilder()
                                            .add("first", "Billy Joe")
                                            .add("last", "Armstrong"))
                                    .add(factory.createObjectBuilder()
                                            .add("first", "Tre")
                                            .add("last", "Cool"))
                            )
                    )
                    .add(factory.createObjectBuilder()
                            .add("artist", "Pear Jam")
                            .add("title", "Ten")
                            .add("year", 1991)
                            .add("musician", factory.createArrayBuilder()
                                    .add(factory.createObjectBuilder()
                                            .add("first", "Eddie")
                                            .add("last", "Vedder"))
                                    .add(factory.createObjectBuilder()
                                            .add("first", "Mike")
                                            .add("last", "McCready"))
                            )
                    )
                    .build();
            out.println(jsonObj.toString());
            
            // Not required, for lecture purposes only
            request.getServletContext().log(jsonObj.toString());
        } catch (Exception e) {
            request.getServletContext().log(e.getMessage());
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
