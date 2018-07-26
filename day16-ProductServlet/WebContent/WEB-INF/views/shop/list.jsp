<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="shop.vo.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 전체 목록</title>
<style type="text/css">
	table, tr, th, td{
		border: 1px solid black;
	}
</style>
</head>
<body>
<h3>제품 전체 목록</h3>
<hr>
<table>
<tr>
	<th>제품코드</th>
	<th>제품이름</th>
	<th>가격</th>
	<th>재고</th>
</tr>
<c:if test="${not empty products}">
<c:forEach items="${products }" var="product">
<tr>
	<td>${product.prodCode }</td>
	<td>
		<a href="detail?prodCode=${product.prodCode}">${product.prodName }</a>
	</td>
	<td>${product.price }</td>
	<td>${product.quantity }</td>
</tr>
</c:forEach>
</c:if>

<c:if test="${empty products}">
<tr>
	<th colspan="4">등록된 제품이 존재하지 않습니다.</th>
</tr>
</c:if>
</table>
</body>
</html>