<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ModifySample</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(()=>{
		$('#modifyButton').click(()=>{
			alert('수정되었습니다.');
			$('#modifyForm').submit();
		});
		$('#listButton').click(()=>{
			$('#listForm').submit();
		});
	});
</script>
</head>
<body>
	<div class="container">
	<h1>Sample 수정화면</h1>
		<form action="/sample/modifySample" method="post" id="modifyForm">
			<table class="table">
				<tr>
					<td>No</td>
					<td><input type="text" name="sampleNo" class="form-control" value="${sample.sampleNo}" readonly></td>
				</tr>
				<tr>
					<td>ID</td>
					<td><input type="text" name="sampleId" class="form-control" value="${sample.sampleId}" readonly></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="text" name="samplePw" class="form-control" value="${sample.samplePw}"></td>
				</tr>
			</table>
			<div><button id="modifyButton" type="button" class="btn btn-primary">수정</button></div>
		</form>
			<form action="/sample/sampleList" id="listForm">
			<button id="listButton" type="button" class="btn btn-warning">처음으로</button>
		</form>
	</div>
</body>
</html>