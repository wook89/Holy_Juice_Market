<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom CSS (Optional) -->
<link href="css/custom.css" rel="stylesheet">
<style>
.cartList {
    width: 80%; /* 본문의 넓이 설정 */
    margin: 0 auto; /* 좌우 중앙 정렬 */
    padding: 0 15%; /* 좌우 공백 추가 (15%씩) */
    box-sizing: border-box; /* 패딩 포함한 전체 크기 계산 */
}

/* 각 장바구니 항목 */
.cartItem {
    display: flex; /* Flexbox 적용 */
    align-items: center; /* 세로 가운데 정렬 */
    justify-content: space-between; /* 좌우 여백 조정 */
    gap: 20px; /* 각 항목 간의 간격 */
    padding: 10px 0; /* 위아래 여백 */
    border-bottom: 1px solid #ccc; /* 각 행의 구분선 */
}
.header {
    display: flex; /* Flexbox 적용 */
    align-items: center; /* 세로 가운데 정렬 */
    justify-content: space-between; /* 좌우 여백 조정 */
    gap: 200px; /* 각 항목 간의 간격 */
    padding: 10px 0; /* 위아래 여백 */
}

/* 내부 항목 크기 조정 */
.cartItem > div, .cartItem > img {
    flex: 1; /* 모든 항목의 크기를 균등 분배 */
    text-align: center; /* 텍스트 가운데 정렬 */
}
.itemName {
    flex: 2; /* 이름 항목에 더 많은 공간 할당 */
}
.itemQty, .itemPrice {
    flex: 1; /* 수량 및 가격 항목은 기본 공간 할당 */
}
.itemPrice{
	display: flex; /* Flexbox 적용 */
    align-items: center; /* 세로 가운데 정렬 */
    justify-content: space-between; 
}
</style>
<script src="/Holy_Juice_Market/resources/js/jquery-3.7.1.min.js"></script>
<script>
function updateQuantity(action,item_cd,item_name) {
    // 수량 input 요소 가져오기
    const quantityInput = document.getElementById(item_name);
    let currentQuantity = parseInt(quantityInput.value);
    // 수량 증가/감소 처리
    if (action === 'increase') {
        currentQuantity += 1;
    } else if (action === 'decrease' && currentQuantity > 1) {
        currentQuantity -= 1;
    } else {
        return; // 감소 시 수량이 1보다 작아지지 않도록 처리
    }

    // 수량 업데이트
    quantityInput.value = currentQuantity;

    // 서버로 데이터 전송
    const itemCode = "${cartVO.item_cd}"; // 서버로 보낼 상품 코드
    const userNo = "${user.user_no}";

    fetch('/Holy_Juice_Market/cart/updateQuantity.do', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            itemCode: item_cd,
            userNo: userNo,
            qty:currentQuantity
        })
    })
    .then(response => response.json())
    .then(data => {
		 document.getElementById(`subtotalPrice_${"${item_cd}"}`).textContent = data.subtotalPrice + " 원";
		 document.getElementById("totalPrice").textContent = data.totalPrice + " 원";
		 document.getElementById("myCart").textContent = "Cart("+data.totalQTY+")";
        if (data.status) {
            console.log('수량 업데이트 성공');
        } else {
            console.error('수량 업데이트 실패:', data.message);
            alert('수량 업데이트에 실패했습니다.');
        }
    })
    .catch(error => {
        console.error('서버 통신 오류:', error);
        alert('서버와의 통신에 문제가 발생했습니다.');
    });
}
/////////////////////////////////////////////////////////////////////////////////////


function order(){
	location.href="/Holy_Juice_Market/order/cartOrder.do"
   }

</script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenuBar.jsp" />
	</header>
	
	
	<section>
	
		<div class="cartList">
		<hr>
					<div class="header">
					<div class="itemName"><h2>상품정보</h2></div>
					<div class="itemQty"><h2>수량</h2></div>
					<div class="itemPrice"><h2>가격</h2></div>
					</div>
			<hr>
			<c:forEach items="${orderList}" var="orderVO">
				<div class="cartItem">
					<img alt="${orderVO.item_name }" src="${orderVO.img_url }"
						style="max-width: 90px; max-height: 90px; object-fit: cover;">
					<div class="itemName">
						<h4>${orderVO.item_name }</h4>
					</div>
					<div class="itemQty">
						<h4>${orderVO.qty }</h4>
					</div>
					<div class="itemPrice" >
						<h3 id="subtotalPrice_${orderVO.item_cd}" style="margin-left: 140px;"> ${orderVO.qty * orderVO.price}</h3>
					</div>
				</div>
			</c:forEach><br>
				<div style="display: flex;justify-content: flex-end; margin-right:10px; ">
					<h3>합계 :</h3> <h3 id="totalPrice">${totalPrice}원</h3>
				</div><br>
				<div style="display: flex; justify-content: center; margin-right:10px;">
					<a onclick="order();"><button>결제</button></a>
				</div>
				
		</div>
	</section>
	<footer>
		<jsp:include page="/jsp/include/footer.jsp" />
	</footer>
	<!-- Bootstrap JS Bundle (Includes Popper.js) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>