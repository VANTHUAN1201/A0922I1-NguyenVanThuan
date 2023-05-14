<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus-FPT
  Date: 4/17/2023
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List user</title>
    <style>
       body{
            margin: 0;
        }
       h1{
           text-align: center;
       }
       div.tbl{
           margin-top: 10px;
           width: 80%;
           margin-left: 10%;
           margin-right: 10%;
       }
       table, th, td{
           border:1px solid #868585;
       }
       table{
           border-collapse:collapse;
           width:100%;
       }
       th, td{
           text-align:left;
           padding:10px;
       }
       table tr:nth-child(odd){
           background-color:#eee;
       }
       table tr:nth-child(even){
           background-color:white;
       }
       table tr:nth-child(1){
           background-color:skyblue;
       }
       .button {
           /*font: bold 11px Arial;*/
           text-decoration: none;
           background-color: #EEEEEE;
           color: #333333;
           padding: 2px 6px 2px 6px;
           border-top: 1px solid #CCCCCC;
           border-right: 1px solid #333333;
           border-bottom: 1px solid #333333;
           border-left: 1px solid #CCCCCC;
       }
    </style>
</head>
<body>
<h1><a href="/user"> List User Management</a></h1>
<div style="display: flex;justify-content: center">
    <div style="display: flex;justify-content:space-evenly;width: 80%">
        <form action="/user?action=findByCountry" method="post">
            <input type="text" name="str" size="50" placeholder="Enter the name of the country you want to search for.. ">
            <button type="submit">Search</button>

        </form>
        <div>
            <a class="button" href="/user?action=create" >Add New</a>
        </div>
        <div>
            <a href="/user?action=descName" class="button">descending name</a>
        </div>
        <div>
            <a href="/user?action=ascName" class="button">ascending  name</a>
        </div>

    </div>
</div>
<div class="tbl">
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="list" items="${userList}">
            <tr>
                <td>${list.id}</td>
                <td>${list.name}</td>
                <td>${list.email}</td>
                <td>${list.country}</td>
                <td>
                    <a href="/user?action=edit&id=${list.id}">Edit</a>
                    <a href="/user?action=delete&id=${list.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
