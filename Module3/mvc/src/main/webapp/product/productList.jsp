<%--
  Created by IntelliJ IDEA.
  User: Asus-FPT
  Date: 4/10/2023
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h1>Customers</h1>
<p>
    <a href="/product?action=create">Create new customer</a>
</p>
<table class="">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Brand</td>
        <td>Price</td>
        <td>Image</td>
    </tr>
    <c:forEach items='${productList}' var="list">
        <tr>
            <td><a href="/product?action=view&id=${customer.getId()}">${customer.getName()}</a></td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td><a href="/customers?action=edit&id=${customer.getId()}">edit</a></td>
            <td><a href="/customers?action=delete&id=${customer.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
