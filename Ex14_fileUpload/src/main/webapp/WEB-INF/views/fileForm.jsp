<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileForm</title>
</head>
<body>
	<form action="upload" method="post" enctype="multipart/form-data">
		파일 : <input type="file" name="files" multiple="true">
		<input type="submit" value="File Upload">
	</form>
</body>
</html>