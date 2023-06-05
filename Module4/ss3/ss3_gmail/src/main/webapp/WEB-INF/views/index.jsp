
<%--
  Created by IntelliJ IDEA.
  User: Asus-FPT
  Date: 5/22/2023
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Setting gmail</title>
  <style>
  </style>
</head>
<body>
<h1>Setting </h1>
<table>
    <tr>
      <td>Languages:</td>
      <td>${gmail.languages}</td>
    </tr>
    <tr>
      <td>Page Size:</td>
      <td>${gmail.pageSize}</td>
    </tr>
    <tr>
      <td>Spams filter:</td>
      <td>${gmail.spamsFilter}</td>
    </tr>
    <tr>
      <td>Signature:</td>
      <td>${gmail.signature}</td>
    </tr>
    <tr>
      <td colspan="2"><a href="/update">edit</a></td>
    </tr>
</table>
</body>
</html>
