/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.jpa;

import edu.ccsu.beans.Address;
import edu.ccsu.beans.Login;
import edu.ccsu.beans.Person;
import edu.ccsu.beans.Phone;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cw1491
 */
@WebServlet(name = "CreatePersonRelatedBeansDemoServlet", urlPatterns = {"/CreatePersonRelatedBeansDemoServlet"})
public class CreatePersonRelatedBeansDemoServlet extends HttpServlet {

  @PersistenceUnit(unitName = "Lec16DemosPU")
  private EntityManagerFactory entityManagerFactory;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Generate a bunch of related beans</title>");
      out.println("</head>");
      out.println("<body>");
      String firstName = request.getParameter("firstName");

      Person person = new Person();
      person.setFirstName(firstName);

      // Create related Login
      Login login = new Login();
      login.setId(firstName + "-login");
      login.setPassword(firstName + "-password");
      person.setLogin(login);
      login.setPerson(person);

      // Create related addresses
      Set<Address> addresses = new HashSet();
      Address address = new Address();
      address.setStreet(firstName + "-1-Main St.");
      address.setPerson(person);
      addresses.add(address);
      Address address2 = new Address();
      address2.setStreet(firstName + "-2-Main St.");
      address2.setPerson(person);
      addresses.add(address2);
      person.setAddresses(addresses);

      //Create related Phones
      Set<Phone> phones = new HashSet();
      Set<Person> persons = new HashSet();
      persons.add(person);
      Phone phone = new Phone();
      phone.setNumber(firstName + "1-456");
      phone.setPersons(persons);
      phones.add(phone);
      Phone phone2 = new Phone();
      phone2.setNumber(firstName + "2-789");
      phone2.setPersons(persons);
      phones.add(phone2);
      person.setPhones(phones);

      EntityManager entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();
      entityManager.persist(person);
      entityManager.persist(login);
      for (Address a : addresses) {
        entityManager.persist(a);
      }
      for (Phone p : phones) {
        entityManager.persist(p);
      }
      entityManager.getTransaction().commit();
      out.println("ID: " + person.getID() + " name: " + person.getFirstName() + " added with related beans");
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      out.println(e.getMessage());
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
