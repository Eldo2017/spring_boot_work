<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" ></script>
<style>
	body {
		margin: 0 auto;
		width: 800px;
	}
	a {
		text-decoration:none; color:black; cursor:pointer;
	}
</style>
</head>
<body>
	<br>
	<p>총 레코드수 : ${totalRecord}</p>
	<table class="table">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="b" items="${list}">
			<tr>
				<td>${b.boardno}</td>
				<td><a href="detail?boardno=${b.boardno}">${b.title}</a></td>
				<td>${b.writer}</td>
				<td><a href="detail?boardno=${b.boardno}"><button type="button" class="btn btn-outline-danger">삭제</button></a></td>
			</tr>
		</c:forEach>
	</table>
	<p align="right"><a href="writeForm"><button type="button" class="btn btn-outline-info">글쓰기</button></a>
</body>
</html>