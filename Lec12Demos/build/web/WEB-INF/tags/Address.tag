<%-- 
    Document   : Address
    Created on : Oct 12, 2011, 1:53:48 PM
    Author     : cw1491
--%>

<%@tag description="Address input tag" pageEncoding="UTF-8"%>
<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="addressType"%>
<%@attribute name="passedAddress" required="true" type="edu.ccsu.beans.Address" %>

<table border="1">
    <tr style="background:lightgrey"><th colspan="2">${addressType}</th></tr>
    <tr><td>Street address: </td><td>${passedAddress.streetAddress}</td></tr>
    <tr><td>City: </td><td>${passedAddress.city}</td></tr>
    <tr><td>State: </td><td>${passedAddress.state}</td></tr>
</table>