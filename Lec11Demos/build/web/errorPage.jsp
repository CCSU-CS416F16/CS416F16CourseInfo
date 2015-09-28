<%-- 
    Document   : errorPage
    Created on : Oct 7, 2011, 12:44:20 PM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<%@page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <img src="http://www.wyndsongwrites.com/wp-content/uploads/2011/02/fail-whale1.jpg" /><br/>
        <%
                   out.println(exception.toString());
        %>
    </body>
</html>
