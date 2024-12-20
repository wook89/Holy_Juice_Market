<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
/* body {
	display: flex;
	justify-content: center; /* 수평 중앙 */
	align-items: center; /* 수직 중앙 */
	height: 100vh; /* 화면 높이 100% */
	margin: 0; /* 여백 제거 */
	background-color: #f0f0f0;
} */

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
<header>
		<jsp:include page="/jsp/include/topMenuBar.jsp" />
	</header>
<section>
	<div id="form">
		<h2>회원 가입</h2>
		<form action="/Holy_Juice_Market/user/join.do" method="post">
			<br> 아이디 &nbsp; &nbsp;: <input type="text" name="user_id" required="required">
			<br> 비밀번호 &nbsp; &nbsp;: <input type="password" name="password" required="required">
			<br> 이름 &nbsp; &nbsp;: <input type="text" name="user_name" required="required">
			<br> Email &nbsp; &nbsp; &nbsp;: <input type="text" name="email" required="required"><br>
			<br> 전화번호 &nbsp; &nbsp; &nbsp;: <input type="text" name="phone" required="required"><br>
			<br> 
			<br>
			<button type="submit">가입</button>
			<br>
		</form>
	</div>
	</section>
	<footer>
		<jsp:include page="/jsp/include/footer.jsp" />
	</footer>
</body>
</html>