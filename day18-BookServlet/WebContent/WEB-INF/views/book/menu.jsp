<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 관리 메뉴</title>
</head>
<body>
<h3>도서 관리 페이지</h3>
<hr>
<!-- ul>(li>a)*2 -->
<ul>
	<li><a href="${contextPath}/main/list">전체 도서 목록</a></li>
	<li><a href="${contextPath}/main/insert">도서 신규 등록</a></li>
	<br/>
	<li><a href="${contextPath}/logout">로그 아웃</a></li>
</ul>
</body>
</html>