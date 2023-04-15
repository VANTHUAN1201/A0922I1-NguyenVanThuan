<%--
  Created by IntelliJ IDEA.
  User: Asus-FPT
  Date: 4/12/2023
  Time: 6:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>detail product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>

  <h1 style="text-align: center">Delete Product</h1>
  <div>  </div>
  <div>  </div>
  <form method="post" action="/product?action=delete">
      <input type="hidden" name="id" value="${product.id}">
      <div style="display: flex; justify-content: space-evenly;width: 60% ;top: 5vh " >
          <div>
                  <img src="data/image/${product.image}" width="200px">
          </div>
          <div class="description">
              <h2>Name product: ${product.name}</h2>
              <h4>IdProduct:${product.id}</h4>
              <h1>${product.price} vnđ</h1>
              <p>Brand: ${product.brand}</p>
              <div style="margin-right: 10px">
                  <button type="submit">delete</button>
                  <a href="/product" role="button" style="color: blue;border: #727272">Come back</a>
              </div>
          </div>
      </div>
  </form>

</body>
</html>
