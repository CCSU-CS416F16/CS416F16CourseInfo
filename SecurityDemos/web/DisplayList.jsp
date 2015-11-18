<%-- 
    Document   : DisplayList
    Created on : Nov 16, 2015, 1:30:05 AM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <% session.setAttribute("user", "Bob"); %>
    <p style="color:red">Susceptible to XSS</p>
    <table>
      <c:forEach var="record" items="${records}">
        <tr>
          <td>${record}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
