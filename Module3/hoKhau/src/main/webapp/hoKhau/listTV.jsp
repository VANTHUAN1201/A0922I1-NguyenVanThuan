<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus-FPT
  Date: 5/5/2023
  Time: 12:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh Sách thành viên</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div>
  <h1 style="text-align: center">Danh sách thành viên</h1>
</div>
<div class="container">
  <table class="table">
    <thead>
    <tr>
      <%--                <th>STT</th>--%>
      <th>Mã Hộ Khẩu</th>
      <th>CMND</th>
      <th>Tên thành viên</th>
      <th>Ngày sinh</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="thanhVienList" items="${thanhVienList}">
      <tr>
        <td>${thanhVienList.maHk}</td>
        <td>${thanhVienList.cmnd}</td>
        <td>${thanhVienList.ten}</td>
        <td>${thanhVienList.ngSinh}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <div style="text-align: right; right: 100px">
    <a class="btn  btn-primary" href="/hoKhau" role="button">Đóng</a>
  </div>
</div>

</body>
</html>
