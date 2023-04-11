<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>product</title>
    <style>
        body{
            text-align: center;
        }
        input{
             margin: 10px;

        }
        button{
            margin-left: 10px;
        }

    </style>
</head>
<body>
<h1>Product Discount Calculator</h1>
<form action="/discount" method="post">
    <label for="description">Product Description:</label>
    <input id="description" name="description" type="text">
    <label for="price">List Price:</label>
    <input id="price" name="price" type="text">
    <label for="discount">Discount Percent:</label>
    <input id="discount" name="discount" type="text" size="5">
    <label for="discount">(%)</label>
    <button type="submit">Calculator</button>
</form>
</body>
</html>