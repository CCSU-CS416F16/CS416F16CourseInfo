/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.jpa;

import edu.ccsu.beans.Login;
import edu.ccsu.beans.Person;
import edu.ccsu.beans.Phone;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author cw1491
 */
@WebServlet(name = "AddPhoneServlet", urlPatterns = {"/AddPhoneServlet"})
public class AddPhoneServlet extends HttpServlet {
    @PersistenceUnit(unitName = "Lec16DemosPU")
    private EntityManagerFactory entityManagerFactory;
    
  /**
   * Processes requests for both HTTP
   * <code>GET</code> and
   * <code>POST</code> methods.
   *
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
      out.println("<title>Servlet AddCityServlet</title>");      
      out.println("</head>");
      out.println("<body>");
      String loginId = request.getParameter("login");
      String pNumber = request.getParameter("pNumber");
      String type = request.getParameter("type");
      if (type!=null&&type.length()==0){
          type=null;
      }
      
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();
      Login login = entityManager.find(Login.class, loginId);
      Phone phone = entityManager.find(Phone.class, pNumber);
      if (phone == null){
          phone = new Phone();
          phone.setNumber(pNumber);
          if (type!=null){
              phone.setType(type);
          }
          entityManager.persist(phone);
      }else if (type!=null){
          phone.setType(type);
          entityManager.persist(phone);
      }
      Person person = login.getPerson();
      Set<Phone> phones = person.getPhones();
      phones.add(phone);
      person.setPhones(phones);
      Set<Person> persons = phone.getPersons();
      persons.add(person);
      phone.setPersons(persons);
      entityManager.persist(person);
      entityManager.persist(phone);

      entityManager.getTransaction().commit();
      out.println("Phone added to "+person.getFirstName());
      out.println("</body>");
      out.println("</html>");
    }catch(Exception e){
      out.println(e.getMessage());
    } finally {      
      out.close();
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP
   * <code>GET</code> method.
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
   * Handles the HTTP
   * <code>POST</code> method.
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
