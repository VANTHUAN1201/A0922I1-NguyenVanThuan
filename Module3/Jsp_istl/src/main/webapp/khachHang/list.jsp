<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus-FPT
  Date: 4/7/2023
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin khách hàng</title>
    <link rel="stylesheet" href="static/css/bootstrap.css">
</head>
<body>
<h1 style="text-align: center">Thông tin khách hàng</h1>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Họ và tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${khachHangList}" var="kh">
        <tr>
            <td>${kh.ten}</td>
            <td>${kh.ngSinh}</td>
            <td>${kh.diaChi}</td>
            <td><img src="static/image/${kh.anh}" width="100px" height="100px"></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
