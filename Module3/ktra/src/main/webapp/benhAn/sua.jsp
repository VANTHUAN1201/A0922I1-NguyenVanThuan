<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus-FPT
  Date: 4/17/2023
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa bệnh án</title>
    <style>
        .gradient-custom-3 {
            /* fallback for old browsers */
            background: #84fab0;

            /* Chrome 10-25, Safari 5.1-6 */
            background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 0.5), rgba(143, 211, 244, 0.5));

            /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            background: linear-gradient(to right, rgba(132, 250, 176, 0.5), rgba(143, 211, 244, 0.5))
        }
        .gradient-custom-4 {
            /* fallback for old browsers */
            background: #84fab0;

            /* Chrome 10-25, Safari 5.1-6 */
            background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 1), rgba(143, 211, 244, 1));

            /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            background: linear-gradient(to right, rgba(132, 250, 176, 1), rgba(143, 211, 244, 1))
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<section class="vh-100 bg-image"
         style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-6">
                            <h1 class="text-uppercase text-center mb-5">Sửa thông tin bệnh án</h1>
                            <form action="/benhAn?action=edit" method="post">
                                <%--                                <input type="hidden" name="action" value="create">--%>
                                <div class="form-outline mb-3">
                                    <label class="form-label" for="maBenhAn">Mã bệnh án: </label>
                                    <input readonly id="maBenhAn" name="maBenhAn" value="${benhNhan.maBenhAn}" class="form-control form-control-lg" />
                                </div>
                                <div class="form-outline mb-3">
                                    <label class="form-label" for="maBenhNhan">Mã bệnh nhân: </label>
                                    <input readonly id="maBenhNhan" name="maBenhNhan" value="${benhNhan.maBenhNhan}" class="form-control form-control-lg" />
                                </div>
                                <div class="form-outline mb-3">
                                    <label class="form-label" for="tenBenhNhan">Tên bệnh nhân: </label>
                                    <input type="text" id="tenBenhNhan" name="tenBenhNhan" value="${benhNhan.tenBenhNhan}" class="form-control form-control-lg" />
                                </div>
                                <div class="form-outline mb-3">
                                    <label class="form-label" for="ngayNhap">Ngày nhập viện: </label>
                                    <input type="date" id="ngayNhap" name="ngayNhap" value="${benhNhan.ngayNhap}" class="form-control form-control-lg" />

                                </div>
                                <div class="form-outline mb-3">
                                    <label class="form-label" for="ngayRa">Ngày ra viện: </label>
                                    <input type="date" id="ngayRa" name="ngayRa" value="${benhNhan.ngayRa}" class="form-control form-control-lg" />
                                </div>
                                <div class="form-outline mb-3">
                                    <label class="form-label" for="liDo">Lý do nhập viện: </label>
                                    <input type="text" id="liDo" name="liDo" value="${benhNhan.liDo}" class="form-control form-control-lg" />
                                </div>
                                <div class="d-flex justify-content-center">
                                    <a href="/benhAn" class="btn btn-info"
                                       style="font-size: 20px ;margin-right: 50px">Trở về danh sách</a>
                                    <button type="submit"
                                            class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Sửa</button>

                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
