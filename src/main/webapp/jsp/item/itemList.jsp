<%@page import="kr.ac.kopo.user.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%

	UserVO user = (UserVO)session.getAttribute("user");
	if(user == null){
%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/Holy_Juice_Market/resources/css/product.css?v=1.0">
<link href="css/custom.css" rel="stylesheet">
<script src="/Holy_Juice_Market/resources/js/jquery-3.7.1.min.js"></script>
<%	
	}else{
		int user_no = user.getUser_no();
		%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/Holy_Juice_Market/resources/css/product.css?v=1.0">
<link href="css/custom.css" rel="stylesheet">
<script src="/Holy_Juice_Market/resources/js/jquery-3.7.1.min.js"></script>
<script>
	const sessionUserNo = "<%= user_no %>";
	console.log("Session User No: ", sessionUserNo);
	
	$(document).ready(function(){
	    const userNo = "<%= user_no %>";

	    fetch('/Holy_Juice_Market/include/topMenuBar.do', {
	        method: 'POST',
	        headers: {
	            'Content-Type': 'application/json'
	        },
	        body: JSON.stringify({
	            userNo: userNo
	        })
	    })
	    .then(response => response.json())
	    .then(data => {
			 document.getElementById("myCart").textContent = "Cart("+data.totalQTY+")";
	    })
	    .catch(error => {
	        console.error('서버 통신 오류:', error);
	    });
		
	});
</script>
<%		
	}
%>
<script>

function handleClick(element) {
    const itemCd = element.getAttribute("data-item-cd");

    // 해당 값을 서버로 넘기거나 다른 작업 수행
    console.log("Clicked item_cd:", itemCd);

    location.href = `/Holy_Juice_Market/item/detail.do?item_cd=${"${itemCd}"}`;
}
</script>
<style>

</style>
</head>
<body>
<header>
		<jsp:include page="/jsp/include/topMenuBar.jsp" />
	</header>

<section>
	<h>상품 목록 서비스</h>
	<div class="product-list">
			<c:forEach items="${ itemList }" var="itemVO">
				<div class="product-card" data-item-cd="${ itemVO.item_cd }" onclick="handleClick(this)">
					<!-- 상품 이미지 -->
					<img class="product-image" src="${ itemVO.img_url }"
						alt="${ itemVO.item_name }"
						style="max-width: 200px; max-height: 200px; object-fit: cover;" />
					<!-- 상품 이름 -->
					<h3 class="product-name">${ itemVO.item_name }</h3>
					<!-- 상품 설명 -->
					<p class="product-description">${ itemVO.description }</p>
					<!-- 상품 가격 -->
					<p class="product-price">${ itemVO.price }원</p>
				</div>
			</c:forEach>
		</div>
</section>

<footer>
	<jsp:include page="/jsp/include/footer.jsp" />
</footer>
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
