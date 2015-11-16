<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of classes</title>
<link href="<c:url value="${webappRoot}/resources/css/style.css" />"
	rel="stylesheet" />
</head>
<body>
	<div class="container">
		<h1>List of classes at the school</h1>
		<c:if test="${not empty schoolClasses}">

			<table class="normal-table">
				<thead>
					<tr>
						<th>Key</th>
						<th>Class name</th>
						<th>Teacher name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="schoolClass" items="${schoolClasses}">
						<tr>
							<td>${schoolClass.id}</td>
							<td>${schoolClass.roomnumber}</td>
							<td>${schoolClass.teachername}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

	</div>
</body>
</html>