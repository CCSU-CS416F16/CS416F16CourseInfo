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
    <title>Create related demo</title>
  </head>
  <body>
    <h1>Add person and example related info</h1>
    <form method="POST" action="CreatePersonRelatedBeansDemoServlet">
      First name:<input type="text" name="firstName"/><br/>
      <input type="submit" value="Add Person and related beans"/>
    </form>
  </body>
</html>
