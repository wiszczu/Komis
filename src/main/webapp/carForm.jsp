<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 09:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car data form</title>
</head>
<body>
<form action="save-car-data" method="POST">
    <label> Brand: </label>
    <input type="text" name="brand" value="-- brand --"><br>
    <label> Model: </label>
    <input type="text" name="model" value="-- model --"><br>
    <label> Year of production: </label><br>
    <select name="production">
        <option value="">-- produced --</option>
        <% for (int i = 0; i + 1980 <= 2019; i++) {%>
        <option value="<%=i+1980%>"><%=i+1980%></option>
        <%}%>
    </select><br>
    <label> Mileage: </label><br>
    <input type="text" name="mileage" value="-- mileage --"><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
