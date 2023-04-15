<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 style="text-align: center">Customers</h1>
    <div>
        <a href="/product?action=create" role="button">Create</a>
    </div>
    <table class="table">
        <tr>
            <th style="color: darkgoldenrod">Id</th>
            <th style="color: darkgoldenrod">Name</th>
            <th style="color: darkgoldenrod">Brand</th>
            <th style="color: darkgoldenrod">Price</th>
            <th style="color: darkgoldenrod">Image</th>
            <th style="color: darkgoldenrod">Action</th>
        </tr>
        <c:forEach items='${productList}' var="list">
            <tr>
                <td>${list.id}</td>
                <td>${list.name}</td>
                <td>${list.brand}</td>
                <td>${list.price}</td>
                <td><img src="data/image/${list.image}" width="60px"></td>
                <td style="margin-right: 10px">
                    <a href="/product?action=detail&id=${list.getId()}" role="button" >Detail</a>
                    <a href="/product?action=edit&id=${list.getId()}" role="button">Edit</a>
                    <a href="/product?action=delete&id=${list.getId()}" role="button">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
