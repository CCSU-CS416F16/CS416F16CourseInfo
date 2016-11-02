<%-- 
    Document   : SolnCDResults
    Created on : Oct 10, 2011, 5:00:02 PM
    Author     : cw1491
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="errorPage.jsp"%>
<%@page import="java.util.*;"%>
<%@page import="edu.ccsu.SolnCDBean;"%>
<jsp:useBean id="enteredCD" scope="page" class="edu.ccsu.SolnCDBean" />
<jsp:setProperty name="enteredCD" property="*" />
<jsp:useBean id="AverageRatings" scope="session" class="edu.ccsu.SolnCDEntries" />
<jsp:setProperty name="AverageRatings" property="ratings" param="rating" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td><b>Artist</b></td>
                <td><b>Title</b></td>
                <td><b>Rating</b></td>
            </tr>
            <tr>
                <td><jsp:getProperty name="enteredCD" property="artist" /></td>
                <td><jsp:getProperty name="enteredCD" property="title" /></td>
                <td><jsp:getProperty name="enteredCD" property="rating" /></td>
            </tr>
        </table>
        <%
            Integer numEntered = (Integer) application.getAttribute("numEntered");
            if (numEntered == null) {
                numEntered = new Integer(0);
            }
            numEntered++;
            application.setAttribute("numEntered", numEntered);
            out.println("Number entered: " + numEntered+"<br/>");

            // store cds
            List cds = (List) session.getAttribute("cds");
            if (cds == null) {
                cds = new ArrayList();
            }
            cds.add(enteredCD);
            session.setAttribute("cds", cds);
         %>
         <table border="1">
           <tr><th>Artist</th><th>Album</th></tr>
         <%
            for (int i = 0; i < cds.size(); i++) {
                SolnCDBean cdBean = (SolnCDBean) cds.get(i);
         %>
            <tr><td><%=cdBean.getArtist()%></td><td><%=cdBean.getTitle()%></td></tr>
         <% } %>
         </table>
        <br/>
        Rating average: <%=AverageRatings.getAverageRatings()%>
    </body>
</html>
