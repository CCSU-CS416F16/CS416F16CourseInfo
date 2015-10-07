<%-- 
    Document   : SolnItemTagFile
    Created on : Oct 12, 2011, 5:34:59 PM
    Author     : cw1491
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="store" required="true"%>
<jsp:useBean id="item" scope="request" class="edu.ccsu.solns.Item" />
<%-- any content can be specified here e.g.: --%>
<h2>${store}</h2>
<table border="1">
    <tr><td>Item</td><td>${item.itemName}</td></tr>
    <tr><td>Cost</td><td>${item.itemCost}</td></tr>
</table>