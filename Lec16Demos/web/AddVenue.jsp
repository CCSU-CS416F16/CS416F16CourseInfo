<%-- 
    Document   : AddVenue
    Created on : Nov 12, 2012, 4:32:12 PM
    Author     : cwilliam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Venue</h1>
        <form method="POST" action="AddVenueServlet">
            City id:<input type="text" name="cityId"/>(lookup in DB table)<br/>
            Venue name:<input type="text" name="venueName"/><br/>
            <input type="submit" value="Add venue"/>
        </form>
    </body>
</html>
