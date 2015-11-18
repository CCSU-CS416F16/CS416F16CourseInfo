<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>List of students</title>
    <link href="<c:url value="${webappRoot}/resources/css/style.css" />"
          rel="stylesheet" />
  </head>
  <body>
    <div class="container">
      <h1>List of students</h1>
      <c:if test="${not empty students}">
        <h2>Students in <c:out value="${teacher}"/></h2>
        <table class="normal-table">
          <thead>
            <tr>
              <th>Key</th>
              <th>First name</th>
              <th>Last name</th>
              <th>Phone number</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="student" items="${students}">
              <tr>
                <td><c:out value="${student.id}"/></td>
                <td><c:out value="${student.firstname}"/></td>
                <td><c:out value="${student.lastname}"/></td>
                <td><c:out value="${student.phonenumber}"/></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </c:if>
      <a href="addstudent">Add a student</a><br/>
      <a href="classes">List classes</a>
    </div>
  </body>
</html>