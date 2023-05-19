<%--
  Created by IntelliJ IDEA.
  User: Asus-FPT
  Date: 5/12/2023
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>chuyển đổi tiền tệ</title>
  </head>
  <body>
  <h1 style="font-weight: bold;text-align: center;">Chuyển đổi tiền tệ</h1>
  <div style="margin-left: 25%;margin-right: 25%">
    <form method="post" action="/money">
      <label for="t_usd">Số tiền: </label>
      <input name="t_usd" id="t_usd" value="${usd}" type="text">
      <span>(usd)</span>
      <button type="submit" style="background-color: chartreuse">Chuyển đổi</button>
      <label>chuyển đổi thành: </label>
      <input id="vnd" readonly value="${usd*23460}"><span>(vnd)</span>
    </form>
  </div>

  </body>
</html>
