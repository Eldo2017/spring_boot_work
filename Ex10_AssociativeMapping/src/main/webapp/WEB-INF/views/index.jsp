<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	a {
		text-decoration: none,
		color: black;
		cursor: pointer;
	}
	
	a:hover {
		background-color: gold;
	}
</style>
</head>
<body>
	<form action="minsert" method="post">
		ID : <input name="id"><p/>
		Name : <input name="name"><p/>
		Password : <input type="password" name="passwd"><p/>
		<input type="submit" value="회원가입">
	</form>
	
	<form action="binsert" method="post">
		Title : <input name="title"><p/>
		Content : <input name="content"><p/>
		<input type="hidden" name="id" value="Yetzu3396">
		<input type="submit" value="등록하기">
	</form>
	
	<form action="mupdate">
		ID : <input name="id"><p/>
		Name : <input name="name"><p/>
		<input type="submit" value="수정하기">
	</form>
</body>
</html>