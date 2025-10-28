<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" ></script>
</head>
<body>
	<br>
	<h3 align="center">글쓰기</h3>
	<br>
	<form action="write" method="post" class="mb-3 row">
		<label for="writer" class="col-sm-2 col-form-label">작성자</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="writer" name="writer">
		</div>
		<br><br>
		<label for="title" class="col-sm-2 col-form-label">제목</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="title" name="title">
		</div>
		<br><br>
		<label for="content" class="col-sm-2 col-form-label">글 내용</label>
		<div class="col-sm-10">
			<textarea rows="25" cols="75" id="content" name="content"></textarea>
		</div>
		<br><br>
		<div align="center">
			<button class="btn btn-outline-primary">글 작성</button>&emsp;&emsp;
			<a href="list"><button type="button" class="btn btn-outline-dark">목록으로</button></a>
		</div>
	</form>
</body>
</html>