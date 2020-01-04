<%@ page import="java.util.List" %>
<%@ page import="pl.altkom.web.tomek.Client" %>
<%@ page import="pl.altkom.web.tomek.Car" %><%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <style>table, tr, th, td {border: 1px solid; border-collapse: collapse; text-align: left}</style>
</head>
<body>

<table>
    <tr>
        <th>Brand</th>
        <th>Model</th>
        <th>Produced in</th>
        <th>Mileage [km]</th>
        <th>Capacity [passengers]</th>
    </tr>
    <% Object oList = request.getAttribute("clList");%>
    <% List list = (List) oList; %>

    <% for (Object o : list) {%>
    <% Car c = (Car) o;%>
    <tr>
        <td><%=c.getBrand()%></td>
        <td><%=c.getModel()%></td>
        <td><%=c.getProduction()%></td>
        <td><%=c.getMileage()%></td>
        <td><%=c.getCapacity()%></td>
        <td>
            <form action = "">
                <input type="hidden" name="id" value="<%=c.getId()%>">
                <input type="submit" value="Delete">
            </form>
            <form action = "">
                <input type="hidden" name="id" value="<%=c.getId()%>">
                <input type="hidden" name="name" value="<%=c.getBrand()%>">
                <input type="hidden" name="surname" value="<%=c.getModel()%>">
                <input type="hidden" name="age" value="<%=c.getProduction()%>">
                <input type="hidden" name="region" value="<%=c.getMileage()%>">
                <input type="hidden" name="gender" value="<%=c.getCapacity()%>">
                <input type="submit" value="Edit">
            </form>
        </td>
    </tr>
    <%}%>
</table>

</body>
</html>
