<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 04.01.2020
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>

<html>
<head>
    <title>Title</title>
    <style>table, tr, th, td {
        border: 1px solid;
        border-collapse: collapse;
        text-align: left;} </style>
</head>
<body>

<sql:setDataSource dataSource="jdbc:komis" var="db"/>

<sql:query var="cars" dataSource="${db}">
    SELECT * FROM pojazd
</sql:query>

<table>
    <tr>
        <th>Brand</th>
        <th>Model</th>
        <th>Produced in</th>
        <th>Mileage [km]</th>
        <th>Capacity</th>
        <th>Edytuj</th>
    </tr>

<c:forEach var="item" items="${cars.rows}">
    <tr>
    <td><c:out value="${item.marka}"/></td>
    <td><c:out value="${item.typ}"/></td>
    <td><c:out value="${item.rok}"/></td>
    <td><c:out value="${item.przebieg}"/></td>
    <td><c:out value="${item.pojemnosc}"/></td>
    <td>
        <form action="edit-car-from-list.jsp">
            <input type="submit" value="Edit">
        </form>
    </td>
    </tr>
</c:forEach>

</table>

</body>
</html>
