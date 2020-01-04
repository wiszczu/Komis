<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:useBean id="car" class="pl.altkom.web.tomek.Car" scope="session"/>
<%--<jsp:setProperty name="car" property="brand"/>--%>
<%--<jsp:setProperty name="car" property="model"/>--%>
<%--<jsp:setProperty name="car" property="production"/>--%>
<%--<jsp:setProperty name="car" property="mileage"/>--%>
<%--<jsp:setProperty name="car" property="capacity"/>--%>
<jsp:setProperty name="car" property="*"/>


<table>
    <tr>
        <td>Brand: </td>
        <td><c:out value="${car.brand}"/></td>
    </tr>
    <tr>
        <td>Model: </td>
        <td><c:out value="${car.model}"/></td>
    </tr>
    <tr>
        <td>Year of Production: </td>
        <td><c:out value="${car.production}"/></td>
    </tr>
    <tr>
        <td>Mileage: </td>
        <td><c:out value="${car.mileage}"/></td>
    </tr>
    <tr>
        <td>Capacity: </td>
        <td><c:out value="${car.capacity}"/></td>
    </tr>
</table>

<form action="carForm.jsp">
    <input type="submit" value="Edit">
</form>

<form action="save-car-data">
    <input type="submit" value="Accept and Save">
</form>

<%@include file="companyInfo.html"%>
</body>
</html>
