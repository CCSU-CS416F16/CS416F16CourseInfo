<%-- 
    Document   : demoReadJavaBean
    Created on : Oct 7, 2011, 3:23:35 PM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="myPerson" scope="page" class="edu.ccsu.Person" />
<jsp:setProperty name="myPerson" property="firstName" param="firstName" />
<jsp:setProperty name="myPerson" property="lastName" param="lastName" />
<%-- <jsp:setProperty name="myPerson" property="*"/> --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <jsp:getProperty name="myPerson" property="firstName" /> <jsp:getProperty name="myPerson" property="lastName" />!</h1>
        <h1>Hello <%= myPerson.getFirstName() %> <%= myPerson.getLastName() %>!</h1>
    </body>
</html>
