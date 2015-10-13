<%-- 
    Document   : index
    Created on : Oct 12, 2011, 12:51:35 PM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/my_tag_library"%>
<%@taglib prefix="ad" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>    
    </head>
    <body>
        <form action="TagResult.jsp">
            <table>
                <my:LabeledTextField label="First Name" name="first" />
                <my:LabeledTextField label="Last Name" name="last" />
                <my:LabeledTextField label="Street Address" name="streetAddress" value="11 Main St." />
                <ad:FieldTag label="City" name="city" value="New Britain"/>
            </table>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
