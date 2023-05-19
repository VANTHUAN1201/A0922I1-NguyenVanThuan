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
      label{
        padding-right: 10px;
      }
    </style>
  </head>
  <body>
  <h1 style="font-weight: bold;text-align: center;">Sandwich Condiments</h1>
  <div style="margin-left: 25%;margin-right: 25%">
    <form action="/save" method="post">
      <input type="checkbox" id="lettuce" name="condiment" value="lettuce" >
      <label for="lettuce"> Lettuce</label>
      <input type="checkbox" id="tomato" name="condiment" value="tomato">
      <label for="tomato"> Tomato</label>
      <input type="checkbox" id="mustard" name="condiment" value="mustard">
      <label for="mustard"> Mustard</label>
      <input type="checkbox" id="sprouts" name="condiment" value="sprouts">
      <label for="sprouts"> Sprouts</label><br>
      <input type="submit" value="Save">
      <p>Sandwich Condiments:
        <c:forEach items="${result}" var="item">
          <span>${item}</span>
        </c:forEach> </p>

    </form>
  </div>

  </body>
</html>
