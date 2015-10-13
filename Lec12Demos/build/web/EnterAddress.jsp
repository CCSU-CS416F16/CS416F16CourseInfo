<%-- 
    Document   : EnterAddress
    Created on : Oct 8, 2013, 2:15:17 PM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Enter address</title>
  </head>
  <body>
    <form action="TagResult.jsp" method="Get">
         Street address: <input type="text" name="streetAddress"/><br/>
         City: <input type="text" name="city"/><br/>
         State: <input type="text" name="state"/><br/>
         <input type="submit" value="Go"/>
    </form>
  </body>
</html>
