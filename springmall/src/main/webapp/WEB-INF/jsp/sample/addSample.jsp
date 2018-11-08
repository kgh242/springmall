<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addSample</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<h1>AddSample</h1>
	<form action = "<%=request.getContextPath()%>/SampleController" method="post">
		<table class="table">
			<tr>
				<input type="hidden" value="sampleNo">
			</tr>
			<tr>
				<td>ID</td>
				<td><input type="text" name="sampleId"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="text" name="samplePw"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="제출"/></td>
			</tr>
		</table>
	</form>
</body>
</html>