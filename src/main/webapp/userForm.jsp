<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 09:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>User data form</title>
</head>
<body>
    <form action="save-user-data" method="POST">
        <label> Name: </label>
        <input type="text" name="name" value="--write your name--"><br>
        <label> Surname: </label>
        <input type="text" name="surname" value="--write your surname--"><br>
        <label> Age: </label><br>
        <select name="age">
            <option value="">--choose your age--</option>
            <% for (int i = 0; i <=100; i++) {%>
            <option value="<%=i%>"><%=i%></option>
            <%}%>
        </select><br>
        <label> Region: </label><br>
        <select name="region">
            <option value="">--choose your region--</option>
            <option value="africa">Africa</option>
            <option value="asia">Asia</option>
            <option value="europe">Europe</option>
            <option value="north america">North America</option>
        </select><br>
        <label> Gender: </label><br>
        <input type="radio" name="gender" value="male"> Male<br>
        <input type="radio" name="gender" value="female"> Female<br>
        <input type="radio" name="gender" value="other"> Other<br>
        <input type="submit" value="Submit">
    </form>

</body>
</html>
