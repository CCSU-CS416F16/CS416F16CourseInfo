<%-- 
    Document   : index
    Created on : Oct 26, 2011, 10:58:34 AM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <%
        // Build an ArrayList for use in this page
        ArrayList nameList = new ArrayList();
        nameList.add("Chad");
        nameList.add("John");
        nameList.add("Bob");
        nameList.add("Sam");
        request.setAttribute("nameList", nameList);
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL demo</title>
    </head>
    <body>
        <h1>JSTL test</h1>
        <c:set var="name" scope="application" value="${param.name}" />
        <c:choose>
            <c:when test="${empty name}">
                No name specified
            </c:when>
            <c:when test="${name == 'Chad'}">
                Chad rocks!
            </c:when>
            <c:otherwise>
                <c:out value="Hi ${name}"/>
            </c:otherwise>
        </c:choose>
        <br/>
        <h2>For each Name:</h2>
        <c:forEach var="item" items="${nameList}">
            Name: <c:out value="${item}"/> <br/>
        </c:forEach>

        <h2> String delimited</h2>
        <c:set var="myString" scope="request" value="Here is my delimited string" />
        <c:forTokens items="${myString}" delims=" ,|" var="myToken">
            <c:out value="Next token: ${myToken}"/><br/>
        </c:forTokens>

        <c:choose>
            <c:when test="${name == 'redirect'}">
                <c:redirect url="redirected.jsp"/>
            </c:when>
        </c:choose>
        <h2>Exception handling</h2>
        <c:catch var="e">
            Some good content then create an exception<br/>
            <%
                String str = null;
                str.charAt(0);
            %>
            This is never reached because of the exception
        </c:catch>
        Here is some code after the catch<br/>
        <c:if test="${!empty e}">
            There was an exception: <br/>
            <c:out value="${e}"/>
        </c:if>

        <h2>Internationalization</h2>
        <fmt:setLocale value="en_US"/>
        <fmt:message key='greeting'/><br/>
        <fmt:message key='message'/><br/>


        <fmt:setLocale value="es_ES"/>
        <fmt:message key='greeting'/><br/>
        <fmt:message key='message'/><br/>
        <fmt:setLocale value="en_US"/>

        <h2>Formatting text</h2>
        <fmt:parseDate value="04/02/1976" pattern="MM/dd/yyyy" var="myDate"/>
        <fmt:parseNumber value="40,000.00" var="myNumber"/>
        <fmt:formatDate value="${myDate}" pattern="M/d/yy"/><br/>
        <fmt:formatNumber value="${myNumber}"/>

    </body>
</html>
