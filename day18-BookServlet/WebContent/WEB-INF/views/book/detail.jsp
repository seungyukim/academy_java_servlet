<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="book.vo.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 상세 조회</title>
<style type="text/css">
	table, tr, th, td{
		border: 1px solid black;
	}
</style>
</head>
<body>
<h3>도서 상세 조회</h3>
<hr>
<form action="${contextPath}/main/detail" method="post">
	<table>
		<tr>
			<th>도서 코드</th>
			<td>
				<input name="bookId" type="text" required="required" 
				       readonly="readonly"
				       value="${book.bookId}"/>
			</td>
		</tr>
		<tr>
			<th>도서 제목</th>
			<td>
				<input name="title" type="text" 
				       readonly="readonly"
				       value="${book.title}"/>
			</td>
		</tr>
		<tr>
			<th>저자 이름</th>
			<td>
				<input name="author" type="text" 
				       readonly="readonly"
				       value="${book.author}"/>
			</td>
		</tr>
		<tr>
			<th>책 가격</th>
			<td>
				<input name="price" type="number" 
				       readonly="readonly"
				       value="${book.price}"/>
			</td>
		</tr>
		<tr>
			<th>도서 ISBN</th>
			<td>
				<input name="isbn" type="text" 
				       readonly="readonly"
				       value="${book.isbn}"/>
			</td>
		</tr>
		<tr>
			<th>출판사</th>
			<td>
				<input name="publish" type="text" 
				       readonly="readonly"
				       value="${book.publish}"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<a href="${contextPath}/main/list">목록보기</a>
				<a href="${contextPath}/main/update?bookId=${book.bookId}">수정</a>
				<a href="${contextPath}/main/delete?bookId=${book.bookId}">삭제</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>