<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addSample</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(()=>{
		$('#addButton').click(()=>{
			alert('등록되었습니다.');
			$('#addForm').submit();
		});
		$('#listButton').click(()=>{
			$('#listForm').submit();
		});
	});
</script>
</head>
<body>
	<div class="container">
	<h1>AddSample</h1>
		<form action="/sample/addSample" method="post" id="addForm" enctype="multipart/form-data">
			<table class="table">
				<tr>
					<td><label for="sampleId">ID:</label></td>
					<td><input type="text" class="form-control" name="sampleId"></td>
				</tr>
				<tr>
					<td><label for="samplePw">PW:</label></td>
					<td><input type="text" class="form-control" name="samplePw"></td>
				</tr>
				<tr>
					<td><label for="multipartFile">파일업로드:</label></td>
					<td><input type="file" class="form-control" name="multipartFile"></td>
				</tr>
			</table>
			<button id="addButton" type="button" class="btn btn-primary">등록</button>
		</form>
		<form action="/sample/sampleList" id="listForm">
			<button id="listButton" type="button" class="btn btn-warning">처음으로</button>
		</form>
	</div>
</body>
</html>