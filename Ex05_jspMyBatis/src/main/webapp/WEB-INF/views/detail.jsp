<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		width: 500px;
	}
	.content {
		padding-left: 50px;
	}
</style>
</head>
<body>
	<br>
	<h4 align="center">상세 보기</h4>
	<hr>
	<div class="content">
	작성자 :  ${detailBoard.writer}<br>
	제목 : ${detailBoard.title}	<br>
	내용 : ${detailBoard.content}
	</div>
	<hr>
	<p align="right"><a href="list"><button type="button" class="btn btn-outline-success">목록보기</button></a></p>
</body>
</html>