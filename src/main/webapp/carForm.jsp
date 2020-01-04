<%@ page import="pl.altkom.web.tomek.Car" %><%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 09:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
<%--    <meta charset="UTF-8">--%>
    <title>Car info form</title>
</head>
<body>

<c:set var="brands" value="Audi,Fiat,Ford,Kia,Mazda,Opel,Skoda"/>

<jsp:useBean id="car" class="pl.altkom.web.tomek.Car" scope="session">
    <% car.setBrand("brand"); %>
    <% car.setModel("model"); %>
    <% car.setProduction(2019); %>
    <% car.setMileage("mileage"); %>
    <% car.setCapacity("capacity"); %>
</jsp:useBean>

<% Car carEdit = (Car) request.getSession().getAttribute("car"); %>

<form action="checkInfoForm.jsp" method="POST">
    <select name="brand">
        <c:forEach var="b" items="${brands}">
            <c:choose>
                <c:when test="${b eq car.brand}">
                    <option selected="selected"><c:out value="${b}"/></option>
                </c:when>
                <c:otherwise>
                    <option><c:out value="${b}"/></option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select><br>
    <label> Model: </label>
    <input type="text" name="model" value="<c:out value='${car.model}'/>"><br>
    <label> Year of production: </label><br>
    <select name="production">
        <option>produced in</option>
        <% for (int i = 2019; i >= 1990; i--) {%>
            <% if (carEdit.getProduction() == i) { %>
                <option selected="selected"><%=i%></option>
            <% } else { %>
                <option><%=i%></option>
            <%}%>
        <%}%>
    </select><br>
    <select name="mileage">
        <option selected="selected"><%=carEdit.getMileage()%></option>
        <option>0-50k</option>
        <option>50-100k</option>
        <option>100-150k</option>
        <option>150-250k</option>
        <option>250-500k</option>
        <option>more than 500k</option>
    </select><br>

    <select name="capacity">
        <option>capacity</option>
        <% for (int i = 1; i <= 9; i++) {%>
            <% if (carEdit.getCapacity().equals(String.valueOf(i))) { %>
                <option selected="selected"><%=i%></option>
            <% } else { %>
                <option><%=i%></option>
            <%}%>
        <%}%>
    </select><br>
    <input type="submit" value="Submit">
</form>

<%@include file="companyInfo.html"%>

</body>

</html>