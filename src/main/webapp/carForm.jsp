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
<%--    <meta charset="UTF-8">--%>
    <title>Car info form</title>
</head>
<body>
<form action="checkInfoForm.jsp" method="POST">
    <select name="brand">
        <option >brand</option>
        <option >Audi</option>
        <option >Fiat</option>
        <option >Ford</option>
        <option >Kia</option>
        <option >Mazda</option>
        <option >Opel</option>
        <option >Skoda</option>
    </select><br>
    <label> Model: </label>
    <input type="text" name="model" value=""><br>
    <label> Year of production: </label><br>
    <select name="production">
        <option value="">produced in</option>
        <% for (int i = 2019; i >= 1990; i--) {%>
        <option value="<%=i%>"><%=i%></option>
        <%}%>
    </select><br>
    <select name="mileage">
        <option>mileage [km]</option>
        <option>0-50k</option>
        <option>50-100k</option>
        <option>100-150k</option>
        <option>150-250k</option>
        <option>250-500k</option>
        <option>more than 500k</option>
    </select><br>
    <select name="capacity">
        <option value="">capacity (passengers)</option>
        <option value="2">2</option>
        <option value="2">4</option>
        <option value="5">5</option>
        <option value="7">7</option>
        <option value="8+">8 and more</option>
    </select><br>
    <input type="submit" value="Submit">
</form>

<%@include file="companyInfo.html"%>

</body>
</html>
