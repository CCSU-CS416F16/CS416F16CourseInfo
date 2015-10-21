<%-- 
    Document   : AddCity
    Created on : Nov 6, 2012, 10:35:46 AM
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
    <h1>AddCity</h1>
    <form method="POST" action="AddCityServlet">
      City name:<input type="text" name="name"/><br/>
      State:<input type="text" name="state"/><br/>
      Population:<input type="text" name="population"/><br/>
      <input type="submit" value="AddCity"/>
    </form>
  </body>
</html>
