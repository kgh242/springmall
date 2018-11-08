<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sampelList</title>
<!-- bootStrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- JQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<h1>sampleList</h1>
	<table class="table">
		<thead>
			<tr>
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
					<td><a href="/sample/removeSample?sampleNo=${sample.sampleNo}">DELETE</a></td>
					<td><a href="/sample/removeSample?sampleNo=${sample.sampleNo}">UPDATE</a></td>
				</tr>
			</c:forEach>
				<tr>
					<td colspan="5"><a href="/sample/addSample"><button>회원가입</button></a></td>
				</tr>
		</tbody>
	</table>
		<c:if test="${startRow >9}">
			<a href="/sample/sampleList?startRow=${startRow -10}"><button>이전</button></a>
		</c:if>
		<c:if test="${startRow < totalCount-10}">
			<a href="/sample/sampleList?startRow=${startRow +10}"><button>다음</button></a>
		</c:if>
</body>
</html>