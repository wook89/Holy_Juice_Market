<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
/* body {
            display: flex;
            justify-content: center; /* 수평 중앙 */
            align-items: center;    /* 수직 중앙 */
            height: 100vh;          /* 화면 높이 100% */
            margin: 0;              /* 여백 제거 */
            background-color: #f0f0f0;
        } */
        
#form {
	padding-left : 50px;
	padding-bottom : 30px;
	width: 300px;
	background-color: lightgray;
	border: 1px solid black;
	text-align: left;
	align-items: center;
	justify-content: center;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenuBar.jsp" />
	</header>
	<!-- item_cd,
						 item_name,
						 description,
						 price,
						 stock,
						 category_id -->
	<section>					 
	<div id="form">
	<h2>상품 등록 폼</h2>
		<form action="/Holy_Juice_Market/admin/insert.do" method="post" enctype="multipart/form-data">
		<br>
			상품명 &nbsp; &nbsp;: <input type="text" name="item_name" required="required"><br><br>
			상품설명 : <textarea rows="" cols="" name="description" required="required"></textarea><br><br>
			가격 &nbsp; &nbsp; &nbsp; : <input type="number" min="0" step="1000" name="price" required="required"><br><br>
			재고 &nbsp; &nbsp; &nbsp; : <input type="number" min="0" step="10" name="stock" required="required"><br><br>
			카테고리 : <select name="category_id" required>
				<option value="">--카테고리--</option>
				<option value="1">액상</option>
				<option value="2">기기</option>
				<option value="3">팟</option>
			</select> <br><br>
			사진 &nbsp; &nbsp; &nbsp; : <input type="file" name="file" required="required"/>
			<br><br>
			<button type="submit">등록</button><br>
		</form>
	</div>
	</section>
	<footer>
		<jsp:include page="/jsp/include/footer.jsp" />
	</footer>
</body>
</html>