<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="book.vo.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 전체 목록</title>
<style type="text/css">
	table, tr, th, td{
		border: 1px solid black;
	}
</style>
</head>
<body>
<h3>도서 전체 목록</h3>
<hr>
<table>
<tr>
	<th>도서코드</th>
	<th>책 제목</th>
	<th>저자 이름</th>
	<th>책 가격</th>
	<th>도서 ISBN</th>
	<th>출판사</th>
	<th> </th>
</tr>
<c:if test="${not empty books}">
<c:forEach items="${books}" var="book">
<tr>
	<td>${book.bookId}</td>
	<td>
		<a href="${contextPath}/main/detail?bookId=${book.bookId}">${book.title}</a>
	</td>
	<td>${book.author}</td>
	<td><fmt:formatNumber value="${book.price}" type="currency"></fmt:formatNumber></td>
	<td>${book.isbn}</td>
	<td>${book.publish }</td>
	<td><a href="${contextPath}/main/delete?bookId=${book.bookId}">삭제</a></td>
</tr>
</c:forEach>
</c:if>

<c:if test="${empty books}">
<tr>
	<th colspan="7">등록된 도서가 존재하지 않습니다.</th>
</tr>
</c:if>
<tr>
	<td colspan="7" style="text-align: right;">
		<a href="${contextPath}/main/insert">신규 도서 추가</a>
		<a href="${contextPath}/main/menu">메뉴로...</a>
	</td>
</tr>
</table>
</body>
</html>