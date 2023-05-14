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
    <title>Từ điển</title>
  </head>
  <body>
  <h1 style="font-weight: bold;text-align: center;">Từ điển</h1>
  <div style="margin-left: 25%;margin-right: 25%">
    <form method="post" action="/money">
      <input name="t_usd" id="t_usd" value="${usd}" type="text">
      <button type="submit" style="background-color: chartreuse">Tra cứu</button>
      <label>chuyển đổi thành: </label>
      <input id="vnd" readonly value="${usd*23460}"><span>(vnd)</span>
    </form>
  </div>

  </body>
</html>
