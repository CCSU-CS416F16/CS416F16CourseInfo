<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Add class</title>
  </head>
  <body>
    <form action="classsaved" method="post">
      <table>
        <tr><td>Room number</td><td><input type="text" name="roomnumber"/></td></tr>
        <tr><td>Teacher name</td><td><input type="text" name="teachername"/></td></tr>
        <tr><td colspan="2"><input type="submit" value="Save class"/></td></tr>
      </table>
    </form>
  </body>
</html>