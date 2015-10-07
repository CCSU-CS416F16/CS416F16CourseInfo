<%-- 
    Document   : result.jsp
    Created on : Oct 12, 2011, 1:34:10 PM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ad" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="address" scope="request" class="edu.ccsu.beans.Address" />
<jsp:setProperty name="address" property="*"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>My address</h1>
        <ad:Address addressType="Shipping"/>
    </body>
</html>
