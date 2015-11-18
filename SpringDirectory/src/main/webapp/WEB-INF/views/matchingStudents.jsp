<%-- 
    Returns table of matching students not full HTML page
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="normal-table">
  <thead>
    <tr>
      <th>Key</th>
      <th>First name</th>
      <th>Last name</th>
      <th>Phone number</th>
      <th>Teacher</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="student" items="${students}">
      <tr>
        <td><c:out value="${student.id}"/></td>
        <td><c:out value="${student.firstname}"/></td>
        <td><c:out value="${student.lastname}"/></td>
        <td><c:out value="${student.phonenumber}"/></td>
        <td>
          <c:if test="${not empty student.assignedClass}">
            <a href="studentsinclass-${student.assignedClass.id}"><c:out value="${student.assignedClass.teachername}"/></a>
          </c:if> 
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
