<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h1 class="text-center">All Users</h1>
<div class="container">

    <style>
        table {
            border-collapse: collapse;
            background-color: #f7f7f7;
        }
        th, td {
            border: 1px solid #000;
            text-align: center;
            padding: 8px;
        }
        thead th {
            position: sticky;
            top: 0;
            background-color: #dcdcde;
            z-index: 2;
        }
        tbody {
            max-height: 340px;
            overflow-y: auto;
            display: block;
            width: 100%;
            scrollbar-width:none;
        }
        thead, tbody tr {
            display: table;
            width: 100%;
            table-layout: fixed;
        }
    </style>

    <div style="height: 400px; overflow-y: auto; width: 75rem; scrollbar-width:none;">
        <table class="table table-border border-dark" style=" border-bottom: 1px solid black" >
            <thead>
                <tr>
                    <th style="width: 2rem;">ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>DOB</th>
                    <th>Qualification</th>
                    <th>Email</th>
                    <th>Mobile</th>
                    <th>Password</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody class="text-center" >
             <c:forEach
                var="user"
                items="${users}"
                varStatus="status"
              >
              
                <tr>
                    <td style="width: 2rem;">${user.id}</td>
                 
                <td>${user.name }</td>
                <td>${user.gender}</td>
                <td>${user.dob}</td>
                <td>${user.qualification}</td>
                <td>${user.email}</td>
                <td>${user.mobile}</td>
                <td>${user.password}</td>
                
                <td ">
                        <form action="${pageContext.request.contextPath}/deleteuser/${user.id}" method="post" style="display: inline">
                            <input type="submit" value="Delete" class="btn btn-danger" />
                        </form>
                        <form action="${pageContext.request.contextPath}/edituser" method="get" style="display: inline">
                            <input type="submit" value="Edit" class="btn btn-secondary" />
                        </form>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
