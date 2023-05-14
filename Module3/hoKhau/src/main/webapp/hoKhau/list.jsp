<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus-FPT
  Date: 4/17/2023
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách hộ khẩu</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">

</head>
<body>
    <h1 style="text-align: center"><a href="/hoKhau"> Quản lí hộ khẩu</a></h1>
    <div style="margin-left: 38%; margin-top: 5vh;">
        <form action="/hoKhau?action=searchName" method="post">
            <input type="text" name="str" size="40" placeholder="Enter the name of the country you want to search for.. ">
            <button type="submit">Search</button>

        </form>
    </div>
    <div class="container">
        <a class="button" href="/hoKhau?action=create" >Add New</a>
        <table class="table" id="tableProduct">
            <thead>
            <tr>
<%--                <th>STT</th>--%>
                <th>Mã Hộ Khẩu</th>
                <th>Tên chủ hộ</th>
                <th>Số lượng Thành Viên</th>
                <th>Ngày lập hộ khẩu</th>
                <th>Địa chỉ nhà</th>
                <th>Chức năng</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="listHk" items="${hokhauList}">
                <tr>
                    <td>${listHk.maHk}</td>
                    <td>${listHk.tenChuHo}</td>
                    <td>${listHk.sl}</td>
                    <td>${listHk.ngaylap}</td>
                    <td>${listHk.diaChi}</td>
                    <td>
                        <a class="btn btn-primary" href="/hoKhau?action=edit&maHk=${listHk.maHk}" role="button">Chỉnh sửa</a>
                        <a class="btn btn-danger" href="/hoKhau?action=showHK&maHk=${listHk.maHk}" role="button"
                           data-toggle="modal" data-target="#show">Xem Thành viên</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="show" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Danh Sách Thành viên</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#tableProduct').DataTable({
                'pageLength' : 5,
                'searching' : false,
                pagingType: 'full_numbers',
            });
        });
        function showHK(maHK,cmnd, name,ngSinh) {
            console.log(id, name);
            document.getElementById("studentName").innerText = name;
            document.getElementById("studentId").value = id;
        }

    </script>
</body>
</html>
