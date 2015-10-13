<%-- 
    Document   : JPAAddPet
    Created on : Nov 5, 2012, 12:04:34 PM
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
    <h1>Add Pet</h1>
    <form action="JPAAddPet" method="POST">
      Name:<input type="text" name="name"/><br/>
      Type:<input type="text" name="type"/><br/>
      Age:<input type="text" name="age"/><br/>
      <input type="submit" value="Add pet"/>
    </form>
    <a href="index.jsp">Back to Index</a><br/>
  </body>
</html>
