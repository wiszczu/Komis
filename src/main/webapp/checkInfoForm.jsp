<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Brand: </td>
        <td><%= request.getParameter("brand")%></td>
    </tr>
    <tr>
        <td>Model: </td>
        <td><%= request.getParameter("model")%></td>
    </tr>
    <tr>
        <td>Year of Production: </td>
        <td><%= request.getParameter("production")%></td>
    </tr>
    <tr>
        <td>Mileage: </td>
        <td><%= request.getParameter("mileage")%></td>
    </tr>
    <tr>
        <td>Capacity: </td>
        <td><%= request.getParameter("capacity")%></td>
    </tr>
</table>
<form action="save-car-data">
    <input type="hidden" name="brand" value="<%= request.getParameter("brand")%>">
    <input type="hidden" name="model" value="<%= request.getParameter("model")%>">
    <input type="hidden" name="production" value="<%= request.getParameter("production")%>">
    <input type="hidden" name="mileage" value="<%= request.getParameter("mileage")%>">
    <input type="hidden" name="capacity" value="<%= request.getParameter("capacity")%>">
    <input type="submit" value="Accept">
</form>

<%@include file="companyInfo.html"%>
</body>
</html>
