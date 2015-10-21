<%-- 
    Document   : AddAddress
    Created on : Nov 7, 2012, 2:14:53 PM
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
    <h1>Add address to person</h1>
    <form method="POST" action="AddAddressServlet">
      Login:<input type="text" name="login"/><br/>
      City:<input type="text" name="city"/><br/>
      State:<input type="text" name="state"/><br/>
      <input type="submit" value="Add Address"/>
    </form>
  </body>
</html>
