<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member JPA #02 - selectAll</title>
</head>
<body>
<h1>Member JPA #02 - selectAll</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Email</th>
        <th>Name</th>
    </tr>
    <c:forEach var="m" items="${list}">
        <tr>
            <td>${m.id}</td>
            <td>${m.email}</td>
            <td>${m.username}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>