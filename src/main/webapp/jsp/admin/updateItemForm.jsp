<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품정보 업데이트 페이지</title>
<style>
body {
	display: flex;
	justify-content: center; /* 수평 중앙 */
	align-items: center; /* 수직 중앙 */
	height: 100vh; /* 화면 높이 100% */
	margin: 0; /* 여백 제거 */
	background-color: #f0f0f0;
}

#form {
	padding-left: 50px;
	padding-bottom: 30px;
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

	<!-- item_cd,
						 item_name,
						 description,
						 price,
						 stock,
						 category_id -->
	<div id="form">
		<h2>상품 등록 폼</h2>
		<form action="/Holy_Juice_Market/admin/updateItem.do" method="post"
			enctype="multipart/form-data">
			<br> <input type="hidden" name="item_cd"
				 value="${ item.item_cd }"><br> <br>
			상품명 &nbsp; &nbsp;: <input type="text" name="item_name"
				value="${item.item_name }"><br> <br> 상품설명 :
			<textarea rows="" cols="" name="description">${item.description }</textarea>
			<br> <br> 가격 &nbsp; &nbsp; &nbsp; : <input type="number"
				min="0" step="1000" name="price" value="${item.price }"><br>
			<br> 재고 &nbsp; &nbsp; &nbsp; : <input type="number" min="0"
				step="10" name="stock" value="${item.stock }"><br> <br>
			카테고리 : <select name="category_id" value="${item.category_id }"
				required>
				<option value="">--카테고리--</option>
				<option value="1">액상</option>
				<option value="2">기기</option>
				<option value="3">팟</option>
			</select> <br> <br> 사진 &nbsp; &nbsp; &nbsp; : <input type="file"
				name="file" required="required" /> <br> 현재 업로드된 파일:
			<c:if test="${item.img_url != null}">
				<span>${item.img_url}</span>
			</c:if>
			<br>
			<button type="submit">등록</button>
			<br>
		</form>
	</div>
</body>
</html>