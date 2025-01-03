<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
/* 전체 폼 컨테이너 스타일 */
#form {
    width: 30%; /* 폼 너비 */
    margin: 30px auto; /* 화면 중앙 정렬 */
    padding: 20px;
    background-color: #f9f9f9; /* 폼 배경색 */
    border: 1px solid #ddd; /* 테두리 */
    border-radius: 10px; /* 둥근 모서리 */
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
    font-family: Arial, sans-serif;
}

/* 제목 스타일 */
#form h2 {
    text-align: center;
    color: #333;
    margin-bottom: 20px;
}

/* 라벨과 입력 필드 정렬 */
#form form {
    display: flex;
    flex-direction: column;
    gap: 15px; /* 입력 필드 간격 */
}

#form label {
    font-weight: bold;
    margin-bottom: 5px;
    color: #555;
}

/* 입력 필드 스타일 */
#form input[type="text"],
#form input[type="number"],
#form textarea,
#form select,
#form input[type="file"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 14px;
    box-sizing: border-box;
}

/* 입력 필드 포커스 효과 */
#form input:focus,
#form textarea:focus,
#form select:focus {
    border-color: #007bff;
    outline: none;
}

/* 버튼 스타일 */
#form button {
    width: 100%;
    padding: 12px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

#form button:hover {
    background-color: #0056b3;
}

/* 반응형 디자인 */
@media (max-width: 768px) {
    #form {
        width: 90%; /* 작은 화면에서는 너비를 줄임 */
    }
}

</style>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenuBar.jsp" />
	</header>
	<section>					 
	<div id="form">
	<h2>상품 등록 폼</h2>
		<form action="/Holy_Juice_Market/admin/insert.do" method="post" enctype="multipart/form-data">
		<br>
			상품명  <input type="text" name="item_name" required="required">
			상품설명  <textarea rows="" cols="" name="description" required="required"></textarea>
			가격  <input type="number" min="0" step="1000" name="price" required="required">
			재고  <input type="number" min="0" step="10" name="stock" required="required">
			카테고리  <select name="category_id" required>
				<option value="">--카테고리--</option>
				<option value="1">액상</option>
				<option value="2">기기</option>
				<option value="3">팟</option>
			</select> <br><br>
			사진  <input type="file" name="file" required="required"/>
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