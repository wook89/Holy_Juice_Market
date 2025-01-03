<%@page import="java.util.List"%>
<%@page import="kr.ac.kopo.cart.vo.CartVO"%>
<%@page import="kr.ac.kopo.user.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%
if (session.getAttribute("user_no") == null) {

} else {
	int user_no = (int) session.getAttribute("user_no");
%>

<script>

const sessionUserNo = "<%=user_no%>";
console.log("Session User No: ", sessionUserNo);
$(document).ready(function(){
    const userNo = "<%=user_no%>";

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
    	if(data.totalQTY != 0){
		 document.getElementById("myCart").textContent = "Cart("+data.totalQTY+")";
    	}
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
function alertMSG(msg){
	alert(msg);
}
</script>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark"
	style="height: 120px;">
	<a href="/Holy_Juice_Market/index.jsp"> <img
		src="/Holy_Juice_Market/resources/image/holy_juice.png"
		style="height: 120px;">
	</a>
	<div class="container">
		<a class="navbar-brand" href="/Holy_Juice_Market/item/list.do">Home</a>
		<a class="navbar-brand" href="/Holy_Juice_Market/item/bestList.do">월간베스트</a>
		<a class="navbar-brand" href="/Holy_Juice_Market/item/juiceList.do">액상</a>
		<a class="navbar-brand" href="/Holy_Juice_Market/item/vapeList.do">기기</a>
		<a class="navbar-brand" href="/Holy_Juice_Market/item/potList.do">팟</a>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ms-auto">
				<li class="nav-item"><a class="nav-link" href="/Holy_Juice_Market/inquiry/inquiryBoard.do">문의&답변</a></li>
				<c:choose>
					<c:when test="${ empty user_no }">
						<li class="nav-item"><a class="nav-link"
							href="/Holy_Juice_Market/user/joinForm.do">회원가입</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Holy_Juice_Market/user/loginForm.do">LogIn</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link"
							href="/Holy_Juice_Market/user/myPageForm.do">MyPage</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Holy_Juice_Market/user/logout.do">LogOut</a></li>
						<li class="nav-item"><c:choose>
								<c:when test="${cartSize eq 0}">
									<a class="nav-link" id="myCart" href="javascript:void(0);"
										onclick="alertMSG('장바구니가 비어있습니다.');">Cart</a>
								</c:when>
								<c:otherwise>
									<a class="nav-link" id="myCart"
										href="/Holy_Juice_Market/cart/cartItem.do">Cart</a>
								</c:otherwise>
							</c:choose></li>

						<c:choose>
							<c:when test="${ type eq 'S' }">
								<a href="/Holy_Juice_Market/admin/management.do"><button>관리자페이지</button></a>
							</c:when>
						</c:choose>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>
