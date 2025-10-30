<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member JPA #02</h1>
	
	<a href="insert">데이터 추가</a><p/>
	<a href="selectAll">데이터 전체 조회</a><p/>
	<a href="selecById?id=1">데이터 조회 - by Id</a><p/>
	
	<hr>
	
	<a href="selectByName?name=김두한">데이터 조회 - by Name</a><p/>
	<a href="selectByEmail?email=Glare6237@naver.com">데이터 조회 - by Email</a><p/>
	<a href="selectByNameLike?name=영">리스트 조회 - Name Like</a><p/>
	<a href="selectByNameLikeNameDesc?name=철">데이터 조회 - Name Like Name Desc</a><p/>
</body>
</html>