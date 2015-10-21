<%-- 
    Document   : AddPersonLogin
    Created on : Nov 7, 2012, 11:48:39 AM
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
    <h1>Add person and login</h1>
    <form method="POST" action="AddPersonLoginServlet">
      Login:<input type="text" name="login"/><br/>
      Password:<input type="text" name="password"/><br/>
      First name:<input type="text" name="firstName"/><br/>
      <input type="submit" value="Add Person and login"/>
    </form>
  </body>
</html>
