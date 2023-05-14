<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->
<!--<%@ page contentType="text/html;charset=UTF-8" language="java" %>-->
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link crossorigin="anonymous" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" rel="stylesheet">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet"/>
</head>
<body>
<%--<c:url value="/customer?action=doSave" var="${urlSave}"/>--%>

<div class="container">
    <form action="/houseServlet?action=doSave" method="post">
        <div style="margin-top: 8px;">
            <h1>Update Form</h1>
        </div>
        <div>
            <c:if test="${message != null}">
                <p>${message}</p>
            </c:if>
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form1Example1">Id</label>
            <input class="form-control" id="form1Example1" type="text" name="id"
                   value="${item.id != null ? item.id : ""}"
            ${item.id != null ? "readonly" : ""} style="color: darkgray"/>
<%--            <c:if test="${error != null}">${error.get("id")}</c:if>--%>
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form1Example2">Name</label>
            <input class="form-control" id="form1Example2" type="text" name="hhName" value="${item.hhName != null ? item.hhName : ""}"/>
            <c:if test="${error != null}">${error.get("name")}</c:if>
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form1Example3">Date</label>
            <input class="form-control" id="form1Example3" type="date" name="hhDate" value="${item.hhDate != null ? item.hhDate : ""}"/>
            <c:if test="${error != null}">${error.get("date")}</c:if>
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form1Example4">Quantity</label>
            <input class="form-control" id="form1Example4" type="number" name="count" value="${item.count != null ? item.count : ""}" readonly style="color: darkgray"/>
<%--            <c:if test="${error != null}">${error.get("quantity")}</c:if>--%>
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form1Example5">Address</label>
            <input class="form-control" id="form1Example5" type="text" name="address" value="${item.address != null ? item.address : ""}"/>
            <c:if test="${error != null}">${error.get("address")}</c:if>
        </div>
        <div>
            <button class="btn btn-primary btn-block" type="submit">Submit</button>
        </div>
    </form>
</div>

<script crossorigin="anonymous"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
