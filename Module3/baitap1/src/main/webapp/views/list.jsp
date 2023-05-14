<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->
<!--<%@ page contentType="text/html;charset=UTF-8" language="java" %>-->
<!DOCTYPE html>
<html >
<head>
    <title>Show list</title>
    <link crossorigin="anonymous" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet"/>
</head>

<body>
<c:url var="urlCreatePage" value="/houseServlet?action=goCreatePage"/>
<c:url var="urlUpdatePage" value="/houseServlet?action=goUpdatePage"/>
<c:url var="urlDelete" value="/houseServlet?action=delete"/>
<c:url var="urlList" value="/houseServlet"/>

<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <button
                    class="navbar-toggler"
                    type="button"
                    data-mdb-toggle="collapse"
                    data-mdb-target="#navbarTogglerDemo03"
                    aria-controls="navbarTogglerDemo03"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
            >
                <i class="fas fa-bars"></i>
            </button>
            <a class="navbar-brand" href="${urlCreatePage}"> (+) Add new product </a>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${urlList}">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/login?action=logout">Logout</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled"
                        >Disabled</a
                        >
                    </li>
                </ul>

                <form action="${urlList}" class="d-flex input-group w-auto" method="get">
                    <input type="hidden" name="action" value="search">
                    <input
                            aria-label="Search"
                            class="form-control"
                            placeholder="find by id"
                            type="search"
                            name="searchId"
                    />
                    <input
                            aria-label="Search"
                            class="form-control"
                            placeholder="find by name"
                            type="search"
                            name="searchName"
                            value="${searchName}"
                    />
                    <button
                            class="btn btn-outline-primary"
                            type="submit"
                            data-mdb-ripple-color="dark"
                    >
                        Search
                    </button>
                </form>
            </div>
        </div>
    </nav>

    <div class="p-5 text-center bg-light" style="margin-top: 8px;">
        <c:if test="${message != null}">
            <h1>${message}</h1>
        </c:if>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>#</th>
                <th>Id</th>
                <th>HH Name</th>
                <th>Quantity</th>
                <th>Date</th>
                <th>Address</th>
                <th colspan="2">Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${houses}" var="item" varStatus="loop">
                <tr>
                    <td>${loop.count}</td>
                    <td>${item.id}</td>
                    <td>${item.hhName}</td>
                    <td>${item.count}</td>
                    <td>${item.hhDate}</td>
                    <td>${item.address}</td>
                    <td><a href="${urlUpdatePage}&id=${item.id}">
                        <i class="fa-regular fa-pen-to-square fa-2x"></i>
                    </a>
                    </td>
                    <td>
                        <a
                                onclick="showDeleteModal('${item.id}','${item.infoPersonInHouse}')"
                                type="button" data-bs-toggle="modal" data-bs-target="#deleteModal" >
                            <i class="bi bi-exclamation-square"></i>
<%--                        <i class="fa-regular fa-circle-xmark fa-2x"></i>--%>
                    </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <nav aria-label="...">
            <ul class="pagination">
                <c:if test="${index == 1}">
                    <li class="page-item disabled">
                        <a class="page-link" href="#">Previous</a>
                    </li>
                </c:if>
                <c:if test="${index != 1}">
                    <li class="page-item ">
                        <a class="page-link" href="${urlList}?index=${index - 1}&searchName=${searchName}">Previous</a>
                    </li>
                </c:if>

                <c:forEach begin="1" end="${pages}" var="item">
                    <li class="${index == item ? "page-item active" : "page-item"}">
                        <a class="page-link" href="${urlList}?index=${item}&searchName=${searchName}">${item}</a>
                    </li>
                </c:forEach>

                <c:if test="${index == pages}">
                    <li class="page-item disabled">
                        <a class="page-link" href="#">Next</a>
                    </li>
                </c:if>
                <c:if test="${index != pages}">
                    <li class="page-item ">
                        <a class="page-link" href="${urlList}?index=${index + 1}&searchName=${searchName}">Next</a>
                    </li>
                </c:if>
            </ul>
        </nav>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p id="infoPersonInHouse"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <form action="${urlList}">
<%--                    <input type="hidden" name="action" value="delete">--%>
<%--                    <input type="hidden" name="id" value="" id="reponseData">--%>
                    <%--                <button type="button" class="btn btn-primary">  Save changes</button>--%>
                </form>
            </div>
        </div>
    </div>
</div>

<script crossorigin="anonymous"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>

<script>
    function showDeleteModal(id,name) {
        document.getElementById('infoPersonInHouse').innerHTML = name;
        document.getElementById('reponseData').value = id;
    }

</script>
</body>
</html>
