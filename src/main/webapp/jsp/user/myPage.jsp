<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
<script src="/Holy_Juice_Market/resources/js/jquery-3.7.1.min.js"></script>
<style>
    .delivery-container {
        display: flex;
        flex-direction: column;
        width: 100%;
        border: 1px solid #ddd;
        border-radius: 8px;
        overflow: hidden;
    }

    .delivery-header, .delivery-row {
        display: flex;
        align-items: center;
        padding: 10px 0;
        border-bottom: 1px solid #ddd;
    }

    .delivery-header {
        font-weight: bold;
        background-color: #f9f9f9;
    }

    .delivery-row:last-child {
        border-bottom: none;
    }

    .delivery-column {
        flex: 1;
        text-align: center;
        padding: 0 10px;
    }

    .delivery-column.action {
        flex: 0 0 150px; /* 액션 열은 고정 크기 */
        text-align: center;
    }

    button {
        padding: 5px 10px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    button:hover {
        background-color: #0056b3;
    }
</style>
<script>
	
	function deleteDelivery(d_no,d_alias){
		if (confirm(`${"${d_alias}"} 배송지를 삭제하시겠습니까?`)) {
            // 사용자가 확인을 누르면 해당 URL로 이동
            location.href =`/Holy_Juice_Market/deliver/deleteToDeliver.do?delivery_no=${"${d_no}"}`;
        } else {
            // 취소를 누르면 아무 동작도 하지 않음
            return false;
        }
	}
	function updateDeliveryType(d_no,d_alias){
		if (confirm(`${"${d_alias}"} 배송지가 기본배송지로 등록되었습니다.`)) {
            // 사용자가 확인을 누르면 해당 URL로 이동
            location.href =`/Holy_Juice_Market/deliver/updateToDeliveryType.do?delivery_no=${"${d_no}"}`;
        } else {
            // 취소를 누르면 아무 동작도 하지 않음
            return false;
        }
	}
</script>
</head>
<body>
<header>
		<jsp:include page="/jsp/include/topMenuBar.jsp" />
	</header>
	<section>
<c:if test="${param.message eq 1}">
	<script>
		alert('배송지는 다섯개 이상 추가할 수 없습니다.')	
	</script>
</c:if>
	 <form action="/Holy_Juice_Market/deliver/addToDeliver.do" method="post">
        <div>
            <label for="alias">주소지 별칭 (예: 집, 회사)</label><br>
            <input type="text" id="alias" name="alias" required>
        </div>
        <div>
            <label for="address">주소</label><br>
            <input type="text" id="address" name="addr" required>
        </div>
        <div>
            <label for="detailedAddress">상세주소</label><br>
            <input type="text" id="detailedAddress" name="detail_addr" required>
        </div>
        <div>
            <label for="zipcode">우편번호</label><br>
            <input type="text" id="zipcode" name="postal_code" required>
        </div>
        <div>
            <button type="submit">배송지 추가</button>
        </div>
    </form>

    <!-- 저장된 배송지 리스트 -->
    
    <div class="delivery-container">
    <!-- Header Row -->
    <div class="delivery-header">
        <div class="delivery-column">배송지 별칭</div>
        <div class="delivery-column">주소</div>
        <div class="delivery-column">우편번호</div>
        <div class="delivery-column">액션</div>
    </div>

    <!-- Dynamic Rows -->
    <c:forEach items="${deliveryList}" var="deliveryVO">
        <div class="delivery-row">
            <div class="delivery-column">${deliveryVO.alias}</div>
            <div class="delivery-column">${deliveryVO.addr} ${deliveryVO.detail_addr}</div>
            <div class="delivery-column">${deliveryVO.postal_code}</div>
            <div class="delivery-column button">
                <a href="javascript:void(0);"
                onclick="updateDeliveryType('${deliveryVO.delivery_no}','${deliveryVO.alias}')"><button>기본배송지로 등록</button></a>
                <a href="javascript:void(0);"
                onclick="deleteDelivery('${deliveryVO.delivery_no}','${deliveryVO.alias}')"><button>삭제</button></a>
            </div>
        </div>
    </c:forEach>
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