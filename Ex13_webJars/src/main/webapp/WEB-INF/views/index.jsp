<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/webjars/bootstrap/5.3.8/css/bootstrap.min.css" rel="stylesheet">
<script src="/webjars/bootstrap/5.3.8/js/bootstrap.min.js"></script>
<script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
<title>webJars</title>
</head>
<body>
	<button type="button" class="btn btn-primary" onclick="test1();">fadeOut</button>&emsp;
	<button type="button" class="btn btn-outline-warning" onclick="test2();">fadeIn</button>
	<p/>
	<img id="img1" src="/img/img1.jpg">
	<script type="text/javascript">
		function test1() {
			$("#img1").fadeOut(1000);
		}
		
		function test2() {
			$("#img1").fadeIn(1000);
		}
	</script>
</body>
</html>