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
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">--%>
    <style>
        * { box-sizing: border-box; }
        body {
            background: #aedaa6
        }

        .card {
            width: 650px;
            position: absolute;
            background: white;
            margin: 0 auto;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);
            transition: all 0.3s;
        }
        .card.hover {
             box-shadow: 0 8px 17px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
         }

        nav {

            width: 100%;
            color: #727272;
            text-transform: uppercase;
            padding: 20px;
            border-bottom: 2px solid #efefef;
            font-size: 12px;
        }
        .photo {

            padding: 30px;
            width: 45%;
            text-align: center;
            float: left;
            max-height: 240px;
        }

        .description {

            padding: 30px;
            float: left;
            width: 55%;
            border-left: 2px solid #efefef;
        }

        h1 {
            color: #515151;
            font-weight: 300;
            padding-top: 15px;
            margin: 0;
            font-size: 30px;
            font-weight: 300;
        }

        h2 {
            color: #515151;
            margin: 0;
            text-transform: uppercase;
            font-weight: 500;
        }

        h4 {
            margin: 0;
            color: #727272;
            text-transform: uppercase;
            font-weight: 500;
            font-size: 12px
        }

        p {
            font-size: 12px;
            line-height: 20px;
            color: #727272;
            padding: 20px 0;
            margin: 0;
        }

        button {

            outline: 0;
            border: 0;
            background: none;
            border: 1px solid #d9d9d9;
            padding: 8px 0px;
            margin-bottom: 30px;
            color: #515151;
            text-transform: uppercase;
            width: 125px;
            font-family: inherit;
            margin-right: 5px;
            transition: all 0.3s ease;
            font-weight: 500;
        }

        button.hover {

         // background: darken(white, 2%);
             border: 1px solid #aedaa6;
             color: #aedaa6;
             cursor: pointer;
         }

    </style>
</head>
<body>

  <h1 style="text-align: center">Detail Product</h1>
  <div class="card">
      <nav>
          <a href="/product" role="button" style="color: blue">Come back</a>
      </nav>
      <div class="photo">
          <img src="data/image/${product.image}" width="100px">
      </div>
      <div class="description">
          <h2>Name product: ${product.name}</h2>
          <h4>IdProduct:${product.id}</h4>
          <h1>${product.price} vnđ</h1>
          <p>Brand: ${product.brand}</p>
      </div>
  </div>
</body>
</html>
