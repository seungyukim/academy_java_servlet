<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="2;url=${next}">
<title>시스템 메시지</title>
</head>
<body>
<%--이 페이지로 이동이 되었을 때는 request객체에 message라는 이름의 속성이 설정된 상태이다
	message 속성을 EL을 이용하여 출력만 하는 페이지 --%>
	
${message}	
</body>
</html>