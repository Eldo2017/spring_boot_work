<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Login</h2>
	<form action="/login_check" method="post">
		<c:if test="${param.error != null}">
			<p>
				Login 실패<br>
				${error_msg}
			</p>
		</c:if>
		ID : <input name="username"><br>
		PW : <input type="password" name="pwd"><br>
		<input type="submit" value="LOGIN">
		
	</form>
</body>
</html>