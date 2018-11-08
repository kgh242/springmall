<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sampelList</title>
<!-- bootStrap CDN -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- JQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(()=>{
		$('#addButton').click(()=>{
			alert('가입페이지로 이동합니다.');
			$('#addForm').submit();
		});
		$('#delete').click(()=>{
			alert('삭제되었습니다.');
		})
	});
</script>
</head>
<body>
	<div class="container">
	<h1>sampleList</h1>
		<table class="table">
			<thead>
				<tr class="table-active">
					<td>Sample NO</td>
					<td>Sample ID</td>
					<td>Sample PW</td>
					<td>DELETE</td>
					<td>UPDATE</td>
				</tr>
			</thead>
			<tbody>
				<!-- model안의 sampleList 가져옴 -->
				<c:forEach var="sample" items="${sampleList}">
					<tr>
						<td>${sample.sampleNo}</td>
						<td>${sample.sampleId}</td>
						<td>${sample.samplePw}</td>
						<td><a href="/sample/removeSample?sampleNo=${sample.sampleNo}" id="delete">DELETE</a></td>
						<td><a href="/sample/modifySample?sampleNo=${sample.sampleNo}">UPDATE</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${startRow >9}">
			<a href="/sample/sampleList?startRow=${startRow -10}">
				<button type="button" class="btn btn-outline-secondary">이전</button>
			</a>
		</c:if>
		<c:if test="${startRow < totalCount-10}">
			<a href="/sample/sampleList?startRow=${startRow +10}">
				<button type="button" class="btn btn-outline-secondary">다음</button>
			</a>
		</c:if>
		<form action="/sample/addSample" method="get" id="addForm">
			<div align="center">
				<button id="addButton" type="button" class="btn btn-primary">회원등록</button>
			</div>
		</form>
	</div>
</body>
</html>