<%--
  Created by IntelliJ IDEA.
  User: Asus-FPT
  Date: 4/11/2023
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                        <div class="card-body p-5">
                            <h2 class="text-uppercase text-center mb-5">Edit product</h2>

                            <form action="/product?action=edit" method="post">

<%--                                <input type="hidden" name="action" value="create">--%>
                                <div class="form-outline mb-4">
                                    <label class="form-label">Id product</label>
                                    <input readonly name="id" value="${product.id}">


                                </div>
                                <div class="form-outline mb-4">

                                    <label class="form-label" for="newName">Name product</label>
                                    <input type="" id="name" name="newName" value="${product.name}" class="form-control form-control-lg" />
                                </div>
                                <div class="form-outline mb-4">
                                    <label class="form-label" for="newBrand">Brand product</label>
                                    <input type="text" id="brand" name="newBrand" value="${product.brand}" class="form-control form-control-lg" />

                                </div>
                                <div class="form-outline mb-4">
                                    <label class="form-label" for="newPrice">Price product</label>
                                    <input type="text" id="price" name="newPrice" value="${product.price}" class="form-control form-control-lg" />

                                </div>
                                <div class="form-outline mb-4">
                                    <label class="form-label" for="newImage">Image product</label>
                                    <input type="text" id="image" name="newImage" value="${product.image}" class="form-control form-control-lg" />

                                </div>
                                <div class="d-flex justify-content-center">
                                    <button type="submit"
                                            class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Save</button>

                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

</body>
</html>
