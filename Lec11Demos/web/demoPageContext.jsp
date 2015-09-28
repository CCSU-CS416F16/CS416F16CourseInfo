<%-- 
    Document   : PageContextDemo
    Created on : Oct 7, 2011, 12:34:53 PM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read page context</title>
    </head>
    <body>
        application scope:<br/> 
        <%
            Enumeration applicationAttributeNames = pageContext.getAttributeNamesInScope(pageContext.APPLICATION_SCOPE);
            while (applicationAttributeNames.hasMoreElements()) {
              String attrName = applicationAttributeNames.nextElement().toString();
                out.println(attrName +  "<br/>");
            }
            application.setAttribute("beanCounterCalled",new Integer(5));
        %> 
    </body>
</html>
