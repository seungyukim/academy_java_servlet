<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보 수정</title>
<style type="text/css">
	table, tr, th, td{
		border: 1px solid black;
	}
</style>
</head>
<body>
<h3>도서 정보 수정</h3>
<hr>
<form action="${contextPath}/main/update" method="post">
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
			<th>책 제목</th>
			<td>
				<input name="title" type="text" 
				       value="${book.title}"/>
			</td>
		</tr>
		<tr>
			<th>저자 이름</th>
			<td>
				<input name="author" type="text" 
				       value="${book.author}"/>
			</td>
		</tr>
		<tr>
			<th>책 가격</th>
			<td>
				<input name="price" type="number" 
				       value="${book.price}"/>
			</td>
		</tr>
		<tr>
			<th>도서 ISBN</th>
			<td>
				<input name="isbn" type="text" 
				       value="${book.isbn}"/>
			</td>
		</tr>
		<tr>
			<th>출판사</th>
			<td>
				<input name="publish" type="text" 
				       value="${book.publish}"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<a href="${contextPath}/main/list">목록보기</a>
				<a href="${contextPath}/main/detail?bookId=${book.bookId}">수정 취소</a>
				<input type="submit" value="저장">
				<input type="reset" value="초기화">
			</td>
		</tr>
	</table>
</form>
</body>
</html>