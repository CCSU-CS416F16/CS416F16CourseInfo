<%-- 
    Document   : AddressTag
    Created on : Oct 12, 2011, 1:20:05 PM
    Author     : cw1491
--%>

<%@tag description="Address input tag" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="label" required="true"%>
<%@attribute name="name" required="true"%>
<%@attribute name="value"%>
<tr>
    <th>${label}</th>
    <td><input type="text" name="${name}" value="${value}"/></td>
</tr>
