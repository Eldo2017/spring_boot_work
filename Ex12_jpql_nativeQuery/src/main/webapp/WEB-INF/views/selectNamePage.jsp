<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JPQL_NativeQuery</title>
</head>
<body>
	<h1>JPQL_NativeQuery</h1>
	총 회원수 : ${totalElements}<p/>
	총 페이지 : ${totalPages}<p/>
	한 페이지당 회원수 : ${size}<p/>
	현재 페이지 : ${pageNumber}<p/>
	<hr>
	<c:forEach var="m" items="${members}">
		아이디 : ${m.id}<p/>
		이름 : ${m.name}<p/>
		이메일 : ${m.email}<hr>
	</c:forEach>
</body>
</html>