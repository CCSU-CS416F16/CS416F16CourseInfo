<%-- 
    Document   : Address
    Created on : Oct 12, 2011, 1:53:48 PM
    Author     : cw1491
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<jsp:useBean id="address" scope="request" class="edu.ccsu.beans.Address" />
<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="addressType"%>

<table border="1">
    <tr style="background:lightgrey"><th colspan="2">${addressType}</th></tr>
    <tr><td>Street address: </td><td>${address.streetAddress}</td></tr>
    <tr><td>City: </td><td>${address.city}</td></tr>
    <tr><td>State: </td><td>${address.state}</td></tr>
</table>