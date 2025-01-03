<%@page import="kr.ac.kopo.item.vo.ItemVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
	 <!-- Custom CSS (Optional) -->
    <link href="css/custom.css" rel="stylesheet">
    <link rel="stylesheet" href="/Holy_Juice_Market/resources/css/footer.css?v=1.0">
    <script src="/Holy_Juice_Market/resources/js/jquery-3.7.1.min.js"></script>
    <script >
    function addToOrder(user_no,item_cd){//구매하기
    	const quantity = document.getElementById("quantity-input");
	   	location.href=`/Holy_Juice_Market/order/orderForm.do?item_cd=${"${item_cd}"}&quantity=${"${quantity.value}"}`
    	
    }
    function addToCart(user_no,item_cd){//장바구니 담기
    	const quantity = document.getElementById("quantity-input");
	   	location.href=`/Holy_Juice_Market/cart/addToCart.do?item_cd=${"${item_cd}"}&user_no=${"${user_no}"}&quantity=${"${quantity.value}"}`
    	
    }
 // JavaScript 로직
	document.addEventListener("DOMContentLoaded", function() {
		const pricePerItem = ${itemVO.price}; // 단가
		const quantityInput = document.getElementById("quantity-input");
		const totalPriceValue = document.getElementById("total-price-value");

		// 버튼 요소 가져오기
		const increaseBtn = document.getElementById("increase-btn");
		const decreaseBtn = document.getElementById("decrease-btn");

		// 수량 증가
		increaseBtn.addEventListener("click", function() {
			let currentQuantity = parseInt(quantityInput.value);
			quantityInput.value = currentQuantity + 1;
			updateTotalPrice();
		});

		// 수량 감소
		decreaseBtn.addEventListener("click", function() {
			let currentQuantity = parseInt(quantityInput.value);
			if (currentQuantity > 1) { // 최소 수량 제한
				quantityInput.value = currentQuantity - 1;
				updateTotalPrice();
			}
		});

		// 총 가격 업데이트
		function updateTotalPrice() {
			const quantity = parseInt(quantityInput.value);
			const totalPrice = pricePerItem * quantity;
			totalPriceValue.textContent = totalPrice; // 총 가격 표시
		}
	});
    </script>
    <style>
    	#product{
    	display: flex;
    	flex-direction: column;
    	align-items: center;
    	justify-content: center;
    	height: 100vh;
    	}
    	#price{
    	 display: flex;
    	 align-items: center;"
    	}
    </style>
</head>
<body>
<header>
		<jsp:include page="/jsp/include/topMenuBar.jsp" />
	</header>
	<section>
	
	<div id="product">
	<h2>${itemVO.item_name }</h2>
	<img class="product-image" src="${ itemVO.img_url }"
						alt="${ itemVO.item_name }"
						style="max-width: 400px; max-height: 400px; object-fit: cover;" />
	<% double price =  ((ItemVO)request.getAttribute("itemVO")).getPrice() * 1.6; 
	   double roundUpPrice = Math.ceil(price);%>
	<div id="price"><h2 style="color: #32CD32;">${ itemVO.price }원 </h2>&nbsp; &nbsp; &nbsp; &nbsp;<h2 style="color: rgb(200, 50, 50); text-decoration: line-through;"><%= (int)roundUpPrice %>원</h2></div>
	
	<div id="quantity-selector" style="margin-top: 20px; display: flex; justify-content: center; align-items: center;">
		<button id="decrease-btn" style="width: 40px; height: 40px;">&lt;</button>
		<input id="quantity-input" type="number" name="quantity" value="1" min="1" 
			style="width: 60px; text-align: center; font-size: 18px;" readonly />
		<button id="increase-btn" style="width: 40px; height: 40px;">&gt;</button>
			<div id="total-price" style="margin-top: 20px;">
				<h4>총 가격: <span id="total-price-value">${itemVO.price}</span>원</h4>
			</div>
	</div>
		<div style="display:flex; align-items: center; ">
		<a onclick="addToOrder('${ user_no }','${ itemVO.item_cd }');"><button>구매하기</button></a>
		<a onclick="addToCart('${ user_no }','${ itemVO.item_cd }');"><button>장바구니에 담기</button></a>
		</div>
	</div>
	
	</section>
	<footer>
		<jsp:include page="/jsp/include/footer.jsp" />
	</footer>
 <!-- Bootstrap JS Bundle (Includes Popper.js) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>