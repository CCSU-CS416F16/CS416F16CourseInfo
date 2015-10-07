<%-- 
    Document   : Example2ResultsSoln
    Created on : Oct 26, 2011, 4:55:30 PM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <c:out value="${param.firstName}"/></h1>
        <c:choose>
            <c:when test="${param.age=='adult'}">
                You are an adult
            </c:when>
            <c:when test="${param.age=='minor'}">
                Who is your parent <input type="text" name="parent" value="" />
            </c:when>
            <c:otherwise>
                <c:redirect url="Example2Entry.jsp"/>
            </c:otherwise>
        </c:choose>

    </body>
</html>
