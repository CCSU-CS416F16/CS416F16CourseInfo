<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add class</title>
</head>
<body>
	<form:form modelAttribute="student" action="studentsaved" method="post">
    <table>
      <tr><td>First name</td><td><form:input type="text" path="firstname"/></td></tr>
		<tr><td>Last name</td><td><form:input type="text" path="lastname"/></td></tr>
    <tr><td>Phone number</td><td><form:input type="text" path="phonenumber"/></td></tr>
    <tr><td>Class</td><td><form:select path="newAssignedClassId" items="${classChoices}" /></td></tr>
    </table>
		<input type="submit" value="Save student"/>
	</form:form>
</body>
</html>