<%@ page import="java.util.List" %>
<%@ page import="pl.altkom.web.tomek.Client" %><%--
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
        <th>Name</th>
        <th>Surname</th>
        <th>Age</th>
        <th>Region</th>
        <th>Gender</th>
        <th>Delete</th>
    </tr>
    <% Object oList = request.getAttribute("clList");%>
    <% List list = (List) oList; %>

    <% for (Object o : list) {%>
    <% Client c = (Client) o;%>
    <tr>
        <td><%=c.getName()%></td>
        <td><%=c.getSurname()%></td>
        <td><%=c.getAge()%></td>
        <td><%=c.getRegion()%></td>
        <td><%=c.getGender()%></td>
        <td>
            <form action = "delete-user-by-id">
                <input type="hidden" name="id" value="<%=c.getId()%>">
                <input type="submit" value="Delete">
            </form>
        </td>
    </tr>
    <%}%>
</table>

</body>
</html>
