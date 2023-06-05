<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus-FPT
  Date: 5/22/2023
  Time: 8:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload music</title>
</head>
<body>
<h1> Upload Music</h1>
<form:form action="/upload" method="post" modelAttribute="music">
    <fieldset>
        <legend>Add music</legend>
        <table>
            <tr>
                <td>Song name:</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Singer</td>
                <td><form:input path="singer"/></td>
            </tr>
            <tr>
                <td>Kind of music</td>
                <td><form:input path="kindOfMusic"/></td>
            </tr>
            <tr>
                <td>Link</td>
                <td><form:input path="link"/></td>
            </tr>
            <tr>
                <td><input type="reset" value="reset" ></td>
                <td><input type="submit" value="submit"></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
