<%-- 
    Document   : demoImplicitObjects
    Created on : Oct 7, 2011, 11:51:41 AM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Demonstration of implicit objects</title>
    </head>
    <body>
        <table border="1">
            <tr><td colspan="2"/>Use of session and context objects:</td></tr>
            <tr>
                <td>session counter</td>
                <td>
                    <%
                        Integer sessionCounter = (Integer) session.getAttribute("counter");
                        if (sessionCounter == null) {
                            sessionCounter = new Integer(0);
                        }
                        sessionCounter += 1;
                        session.setAttribute("counter", sessionCounter);
                        out.println(sessionCounter);
                    %>
                </td>
            </tr>
            <tr>
                <td>context counter</td>
                <td>
                    <%
                        Integer contextCounter = (Integer) application.getAttribute("counter");
                        if (contextCounter == null) {
                            contextCounter = new Integer(1);
                        }
                        contextCounter *= 2;
                        application.setAttribute("counter", contextCounter);
                        out.println(contextCounter);
                    %>
                </td>
            </tr>
        </table>
                Read the session attribute using <b>JSP expressions</b>: 
                <%= application.getAttribute("counter") %>
        <br/>
        <a href="pageWithError.jsp">Link to page with error</a>
    </body>
</html>
