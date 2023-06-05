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
    <title>Update setting gmail</title>
</head>
<body>
<h1> Settings Gmail update</h1>
<form:form action="/update" method="post" modelAttribute="gmail">
    <table>
        <tr>
            <td>Langusges:</td>
            <td colspan="3">
                <form:select path="languages">
                    <form:option value="NONE"> --SELECT--</form:option>
                    <form:option value="English">English</form:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                    <form:option value="Japanese">Japanese</form:option>
                    <form:option value="Chinese">Chinese</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page size:</td>
            <td>Show</td>
            <td><form:select  path="pageSize">
                <form:option value="5">5</form:option>
                <form:option value="10">10</form:option>
                <form:option value="15">15</form:option>
                <form:option value="25">25</form:option>
                <form:option value="50">50</form:option>
                <form:option value="100">100</form:option>
            </form:select></td>
            <td>emails per page</td>
        </tr>
        <tr>
            <td>Spam filter:</td>
            <td><form:checkbox path="spamsFilter"/></td>
            <td colspan="2">Enable spams filter</td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td colspan="3"><form:textarea path="signature" /></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td><input type="submit" value="update"></td>
            <td><input type="reset" value="cancel"></td>
        </tr>
    </table>

</form:form>

</body>
</html>
