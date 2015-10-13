<%-- 
    Document   : JDBCDeletePerson
    Created on : Nov 5, 2012, 11:13:00 AM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Delete person</h1>
    <form action="JDBCDeletePersonServlet" method="POST">
      Last name:<input type="text" name="lastName"/><br/>
      <input type="submit" value="Delete person"/>
    </form>
    <a href="index.jsp">Back to Index</a><br/>
  </body>
</html>
