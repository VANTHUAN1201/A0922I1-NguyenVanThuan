<%--
  Created by IntelliJ IDEA.
  User: Asus-FPT
  Date: 5/12/2023
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Sandwich Condiments</title>
    <style>

    </style>
  </head>
  <body>
  <h1 style="font-weight: bold;text-align: center;"> Caculator</h1>
  <div style="margin-left: 25%;margin-right: 25%">
    <form action="caculator" method="post">
      <input type="text" name="num1" value="${num1}">
      <input type="text" name="num2" value="${num2}"><br><br>
      <button type="submit" value="+" name="calculation">Additon(+)</button>
      <button type="submit" value="-" name="calculation">Subtraction(-)</button>
      <button type="submit" value="*" name="calculation">Multiplication(*)</button>
      <button type="submit" value="/" name="calculation">Division(/)</button>
    </form>
    <p>Result: ${result}</p>
  </div>

  </body>
</html>
