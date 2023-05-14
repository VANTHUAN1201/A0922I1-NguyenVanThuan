<%--
  Created by IntelliJ IDEA.
  User: Asus-FPT
  Date: 5/5/2023
  Time: 8:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thống kê sách</title>
</head>
<body>
<h1 style="text-align: center"> Danh sách sách</h1>
<div class="container">
  <table class="table">
    <thead>
    <tr>
      <th>Mã mượn Sách</th>
      <th>Tên Sách</th>
      <th>Tác giả</th>
      <th>Tên học Sinh</th>
      <th>Số lượng</th>
      <th>Mô tả</th>
      <th>Chức năng</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="muonList" items="${muonList}">
      <tr>
        <td>${sachList.maSach}</td>
        <td>${sachList.tenSach}</td>
        <td>${sachList.tacGia}</td>
        <td>${sachList.moTa}</td>
        <td>${sachList.sl}</td>
        <td>
          <a class="btn btn-primary" href="/sach?action=muon&maSach=${sachList.maSach}" role="button">Mượn</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
