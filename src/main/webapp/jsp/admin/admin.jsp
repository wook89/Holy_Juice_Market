<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지</title>
<style>
/* 전체 페이지 스타일 */
#mainDIV {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    background-color: #f9f9f9; /* 배경색 */
    height: 100vh; /* 전체 높이를 화면 높이로 설정 */
    display: flex;
    justify-content: center;
    align-items: center;
}

</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="/Holy_Juice_Market/resources/css/footer.css?v=1.0">
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenuBar.jsp" />
	</header>
	<section>
		<div id="mainDIV">
			<a href="/Holy_Juice_Market/admin/insertForm.do"><button>상품등록</button></a>&nbsp;
			<a href="/Holy_Juice_Market/admin/list.do"><button>상품수정&삭제</button></a>
		</div>
	</section>
	<footer>
		<jsp:include page="/jsp/include/footer.jsp" />
	</footer>
</body>
</html>