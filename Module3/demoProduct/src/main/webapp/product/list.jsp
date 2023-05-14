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
    <title>List Product</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">

</head>
<body>
    <h1 style="text-align: center"><a href="/product"> List product Management</a></h1>
    <div style="margin-left: 38%; margin-top: 5vh;">
        <form action="/product?action=searchName" method="post">
            <input type="text" name="str" size="40" placeholder="Enter the name of the country you want to search for.. ">
            <button type="submit">Search</button>

        </form>
    </div>
    <div class="container">
        <a class="button" href="/product?action=create" >Add New</a>
        <table class="table" id="tableProduct">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Amount</th>
                <th>category</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="listProduct" items="${listProduct}">
                <tr>
                    <td>${listProduct.id}</td>
                    <td>${listProduct.name}</td>
                    <td>${listProduct.price}</td>
                    <td>${listProduct.amount}</td>
                    <c:forEach var="listCategory" items="${listCategory}">
                        <c:set var = "id" scope = "session" value = "${listCategory.id_category}"/>
                        <c:if test="${listProduct.id_category==id}">
                            <td><c:out value = "${listCategory.category_name}"/></td>
                        </c:if>
                    </c:forEach>
                    <td>
                        <a class="btn btn-primary" href="/product?action=edit&id=${listProduct.id}" role="button">Edit</a>
                        <a class="btn btn-danger" href="/product?action=delete&id=${listProduct.id}" role="button"
                            onclick="return confirm('Are you sure you want to delete  ?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
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

    </script>
</body>
</html>
