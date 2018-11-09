<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(()=>{
		$('#loginButton').click(()=>{
			$('#loginForm').submit();
		});
	});
</script>
</head>
<body>
	<div class="container">
	<h1>Login</h1>
		<form action="/sample/loginSample" method="post" id="loginForm">
			<table class="table">
				<tr>
					<td><label for="sampleId">ID:</label>
					<td><input type="text" class="form-control" name="sampleId"></td>
				</tr>
				<tr>
					<td><label for="samplePw">PW:</label></td>
					<td><input type="text" class="form-control" name="samplePw"></td>
				</tr>
			</table>
			<button id="loginButton" type="button" class="btn btn-primary">로그인</button>
		</form>
	</div>
</body>
</html>