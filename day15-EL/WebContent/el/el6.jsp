<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL (6) 내장객체와 맵, 사용자 정의 타입 객체의 사용</title>
</head>
<body>
<%
	// 사용자 정의 타입 Product 객체 생성
	product.Product adidas      = new product.Product("S001", "슈퍼스타", 87200, 5);
	product.Product reebok      = new product.Product("S002", "리복 로얄 테크큐 티", 42000, 20);
	product.Product nike        = new product.Product("S003", "나이키 탄준 샌들", 41300, 30);
	product.Product crocs       = new product.Product("S004", "라이트라이드 샌들 우먼", 40200, 7);
	product.Product birkenstock = new product.Product("S005", "지제 에바", 29000, 15);
	
	// 사용자 정의 타입 객체를 request 에 속성으로 추가
	request.setAttribute("adidas", adidas);
	request.setAttribute("reebok", reebok);
	request.setAttribute("nike", nike);
	request.setAttribute("crocs", adidas);
	request.setAttribute("birkenstock", birkenstock);
	
	// 맵 객체 생성
	java.util.Map<String, product.Product> adidasMap = 
			new java.util.HashMap<>();
	adidasMap.put(adidas.getProdCode(), adidas);
	
	// 맵 객체를 request 에 속성으로 추가
	request.setAttribute("adidasMap", adidasMap);
%>
<h3>EL 의 사용자 정의 객체(빈즈), 맵 객체에서 값 추출</h3>
<pre>
.(도트) 연산자로 값을 추출

1. Product 중 adidas 이름으로 request 에 추가된 객체를 추출
  => 내장객체이름.어트리뷰트이름.필드이름
  
  제품코드 : \${requestScope.adidas.prodCode} = ${requestScope.adidas.prodCode}
  제품이름 : \${requestScope.adidas.prodName} = ${requestScope.adidas.prodName}
  제품가격 : \${requestScope.adidas.price} = ${requestScope.adidas.price}
  제품재고 : \${requestScope.adidas.quantity} = ${requestScope.adidas.quantity}

2. reebok 이름이 requestScope 에만 추가되어 있다면 객체 이름 생략 가능

  제품코드 : \${reebok.prodCode} = ${reebok.prodCode} 
  제품이름 : \${reebok.prodName} = ${reebok.prodName} 
  제품가격 : \${reebok.price} = ${reebok.price} 
  제품재고 : \${reebok.quantity} = ${reebok.quantity} 
  
3. map 으로 추가된 객체를 추출   
   (requestScope 에만 추가되어 있다면 객체 이름 생략 가능)
   
   내장객체이름.어트리뷰트이름.맵의키값
   내장객체이름.어트리뷰트이름.맵의키값.맵객체의필드이름
   
   제품전체 : \${adidasMap.S001} = ${adidasMap.S001}
    
   제품코드 : \${adidasMap.S001.prodCode} = ${adidasMap.S001.prodCode} 
   제품이름 : \${adidasMap.S001.prodName} = ${adidasMap.S001.prodName} 
   제품가격 : \${adidasMap.S001.price} = ${adidasMap.S001.price} 
   제품재고 : \${adidasMap.S001.quantity} = ${adidasMap.S001.quantity} 
</pre>


</body>
</html>








