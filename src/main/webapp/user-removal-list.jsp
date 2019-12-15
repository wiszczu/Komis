<%@ page import="pl.altkom.web.tomek.Client" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 09:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>choose user to be removed</title>
</head>
<body>

    <% Object oList = request.getAttribute("clList");%>
    <% List list = (List) oList; %>


<form action="delete-user">
    <select name="deleteUser">
        <% for (Object o : list) { %>
            <% Client c = (Client) o;%>
            <option> <%=c.getName()%> <%=c.getSurname()%></option>
        <%} %>
    </select>
    <input type="submit" value="Delete this user">
</form>


</body>
</html>
