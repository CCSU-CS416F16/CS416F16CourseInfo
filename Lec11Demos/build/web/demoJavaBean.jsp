<%-- 
    Document   : demoJavaBean
    Created on : Oct 7, 2011, 3:16:00 PM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="errorPage.jsp"%>
<jsp:useBean id="myPerson" scope="page" class="edu.ccsu.Person" />
<jsp:setProperty name="myPerson" property="firstName" value="John" />
<jsp:setProperty name="myPerson" property="lastName" value="Doe" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>My person</h1><form name="myForm" action="demoReadJavaBean.jsp">
            First name:<input type="text" name="firstName" value="<jsp:getProperty name="myPerson" property="firstName" />" /><br/>
            Last name:<input type="text" name="lastName" value="<jsp:getProperty name="myPerson" property="lastName" />" /><br/>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
