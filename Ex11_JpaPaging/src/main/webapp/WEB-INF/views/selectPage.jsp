<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JPA Paging - Name Like Paging</h1>
	
	총 회원 수 : ${totalElements}<p/>
	총 페이지 수 : ${totalPages}<p/>
	한 페이지 당 회원 수 : ${size}<p/>
	현재 페이지 : ${pPage}<p/>
	현재 페이지 당 회원 수 : ${ePage}<p/>
	<p/>
	<c:forEach var="m" items="${members}">
		ID : ${m.id}<p/>
		Name : ${m.name}<p/>
		Email : ${m.email}<p/>
	</c:forEach>
</body>
</html>