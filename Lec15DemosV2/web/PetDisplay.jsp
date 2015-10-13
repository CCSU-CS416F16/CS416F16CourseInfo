<%-- 
    Document   : PetDisplay
    Created on : Nov 5, 2012, 3:12:29 PM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Matching Pets</h1>
  <c:forEach var="pet" items="${pets}">
    <c:out value="${pet.name}" /> <c:out value="${pet.age}" /><br/>
</c:forEach>
</table>
<a href="index.jsp">Back to Index</a><br/>
</body>
</html>
