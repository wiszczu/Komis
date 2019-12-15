<%--added BASIC authentication for entering /hello page
  Created by IntelliJ IDEA.
  User: student
  Date: 14.12.2019
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP file test</title>
    <style>
        table, tr, th, td {border: 1px solid; border-collapse: collapse; text-align: center}
    </style>
</head>
<body>

<%!
    int silnia(int n) {
        if (n<=1) return 1;
        return n*silnia(n-1);
    }
%>

<% int n; %>
<% if (request.getParameter("n") != null) {%>
<% n = Integer.valueOf(request.getParameter("n"));%>
<%} else { n = 10;}%>

<table>
    <tr>
        <th>n</th>
        <th>n!</th>
    </tr>
    <% for (int i = 1; i <= n; i++) { %>
    <tr>
        <td><%= i%></td>
        <td><%= silnia(i)%></td>
    </tr>
    <%} %>
</table>

</body>
</html>
