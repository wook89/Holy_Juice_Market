<%@page import="kr.ac.kopo.framework.Dispatcher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shop Homepage</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
	 <!-- Custom CSS (Optional) -->
    <link href="css/custom.css" rel="stylesheet">
<link rel="stylesheet" href="/Holy_Juice_Market/resources/css/product.css?v=1.0">
<link rel="stylesheet" href="/Holy_Juice_Market/resources/css/Pagenation.css">
<link rel="stylesheet" href="/Holy_Juice_Market/resources/css/footer.css?v=1.0">
<script src="/Holy_Juice_Market/resources/js/jquery-3.7.1.min.js"></script>
<script>
	$(document).ready(function() {
 			if(window.location.pathname == '/Holy_Juice_Market/index.jsp') {
			location.href = "/Holy_Juice_Market/item/list.do"
		}
	});
	
	function handleClick(element) {
	    const itemCd = element.getAttribute("data-item-cd");

	    // 해당 값을 서버로 넘기거나 다른 작업 수행
	    console.log("Clicked item_cd:", itemCd);

	    location.href = `/Holy_Juice_Market/item/detail.do?item_cd=${"${itemCd}"}`;
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenuBar.jsp" />
	</header>
	<section>
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
					<div></div>
				</div>
			</c:forEach>
		</div>

	</section>
	
	<div class="pagination">
    <c:if test="${currentPage > 1}">
        <a href="?page=${currentPage - 1}" class="page-link">이전</a>
    </c:if>

    <c:forEach begin="1" end="${totalPages}" var="page">
        <a href="?page=${page}" class="page-link ${currentPage == page ? 'active' : ''}">
            ${page}
        </a>
    </c:forEach>

    <c:if test="${currentPage < totalPages}">
        <a href="?page=${currentPage + 1}" class="page-link">다음</a>
    </c:if>
</div>
	
	<footer>
		<jsp:include page="/jsp/include/footer.jsp" />
	</footer>
 <!-- Bootstrap JS Bundle (Includes Popper.js) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>