<%-- 
    Document   : BeanScope
    Created on : Oct 10, 2011, 1:19:43 PM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="errorPage.jsp"%>
<jsp:useBean id="pageCounter" scope="page" class="edu.ccsu.BeanCounter" />
<jsp:useBean id="sessionCounter" scope="session" class="edu.ccsu.BeanCounter" />
<jsp:setProperty name="pageCounter" property="*" />
<jsp:setProperty name="sessionCounter" property="numberOfBeans" param="numberOfBeans"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bean Counter scope page</h1>
            Current number of beans:<br/>
            Session:<jsp:getProperty name="sessionCounter" property="numberOfBeans" /><br/>
            Page:<jsp:getProperty name="pageCounter" property="numberOfBeans" /><br/>
            <%= pageCounter.getNumberOfBeans() %>
        <form action="beanCounter.jsp">            
            Number to add:<input type="text" name="numberOfBeans" value="0" /><br/>
            <input type="submit" value="Add Beans" />
        </form>
    </body>
</html>
