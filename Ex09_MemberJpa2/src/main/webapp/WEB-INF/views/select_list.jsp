
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member JPA #02</title>
</head>
<body>
	<h1>Member JPA #02 - Select ${title}</h1>
	<c:forEach var="m" items="${mList}">
		아이디 : ${m.id}<p/>
		이름 : ${m.name}<p/>
		이메일 : ${m.email}<hr>
	</c:forEach>
</body>
</html>
