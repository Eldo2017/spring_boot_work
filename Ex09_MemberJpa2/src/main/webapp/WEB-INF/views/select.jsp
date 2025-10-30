<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Detail</title>
</head>
<body>
<h1>Member JPA #02 - selectById</h1>

<c:if test="${member != null}">
    <p>아이디 : ${member.id}</p>
    <p>이메일 : ${member.email}</p>
    <p>이름 : ${member.username}</p>
</c:if>

<c:if test="${member == null}">
    <p>해당 ID의 회원이 존재하지 않습니다.</p>
</c:if>

</body>
</html>