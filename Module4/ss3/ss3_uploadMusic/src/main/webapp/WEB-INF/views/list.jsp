<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
  <title>List Music</title>
  <style>
  </style>
</head>
<body>
<h1>List Music </h1>
<a href="/upload">Upload </a>
<table border="1px solid">
    <tr>
        <th>NameSong</th>
        <th>Singer</th>
        <th>Kind of music</th>
        <th>Link</th>
    </tr>
    <c:forEach items="${musicList}" var="music">
        <tr>
            <td>${music.name}</td>
            <td>${music.singer}</td>
            <td>${music.kindOfMusic}</td>
            <td><a href="${music.link}" target="_blank"> Nghe nhạc</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
