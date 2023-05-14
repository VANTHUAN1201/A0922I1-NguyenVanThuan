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
    <title>Danh sách sách</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">

</head>
<body>
    <h1 style="text-align: center"> Danh sách bệnh án</h1>
    <div class="container">
        <table class="table" id="tableBA">
            <thead>
            <tr>
                <th>Mã bệnh án</th>
                <th>Mã bệnh nhân </th>
                <th>Tên bệnh nhân</th>
                <th>Ngày nhập viện</th>
                <th>Ngày ra viện</th>
                <th>Ly do nhập viện</th>
                <th>Chức năng</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="benhNhanList" items="${benhNhanList}">
                <tr>
                    <td>${benhNhanList.maBenhAn}</td>
                    <td>${benhNhanList.maBenhNhan}</td>
                    <td>${benhNhanList.tenBenhNhan}</td>
                    <td>${benhNhanList.ngayNhap}</td>
                    <td>${benhNhanList.ngayRa}</td>
                    <td>${benhNhanList.liDo}</td>
                    <td>
                        <a class="btn btn-primary" href="/benhAn?action=edit&maBenhNhan=${benhNhanList.maBenhNhan}" role="button">sửa</a>
                        <a class="btn btn-primary" href="/benhAn?action=delete&maBenhNhan=${benhNhanList.maBenhNhan}" role="button">xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
<%--    <!-- Modal -->--%>
<%--    <div class="modal fade" id="show" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">--%>
<%--        <div class="modal-dialog" role="document">--%>
<%--            <div class="modal-content">--%>
<%--                <div class="modal-header">--%>
<%--                    <h5 class="modal-title">Danh Sách Thành viên</h5>--%>
<%--                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                        <span aria-hidden="true">&times;</span>--%>
<%--                    </button>--%>
<%--                </div>--%>

<%--                <div class="modal-footer">--%>
<%--                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#tableBA').DataTable({
                'pageLength' : 5,
                'searching' : false,
                pagingType: 'full_numbers',
            });
        });

    </script>

</body>
</html>
