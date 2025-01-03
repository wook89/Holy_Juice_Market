<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="/Holy_Juice_Market/resources/js/jquery-3.7.1.min.js"></script>
<style>
#base {
    font-family: Arial, sans-serif;
    background-color: #f9f9f9;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

/* 폼 전체를 감싸는 컨테이너 */
#form {
    background-color: #ffffff;
    padding: 20px 30px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    width: 350px;
    text-align: center;
}

/* 제목 스타일 */
#form h2 {
    color: #333333;
    margin-bottom: 20px;
    font-size: 24px;
    font-weight: bold;
}

/* 입력 필드 스타일 */
#form input[type="text"],
#form input[type="password"] {
    width: 100%;
    padding: 10px;
    margin: 10px 0;
    border: 1px solid #cccccc;
    border-radius: 5px;
    box-sizing: border-box;
    font-size: 14px;
}

/* 입력 필드 포커스 스타일 */
#form input:focus {
    border-color: #007bff;
    outline: none;
}

/* 버튼 스타일 */
#form button {
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    padding: 10px 20px;
    font-size: 16px;
    cursor: pointer;
    margin-top: 10px;
    transition: background-color 0.3s ease;
}

#form button:hover {
    background-color: #0056b3;
}

/* 브레이크 줄 간격 조정 */
#form br {
    line-height: 1.5;
}
</style>
</head>
<body>
 <c:if test="${not empty errmsg }">
	<div class="alert alert-danger text-center">
          ${errmsg}
        </div>
</c:if> 
<header>
		<jsp:include page="/jsp/include/topMenuBar.jsp" />
	</header>
<section>
	<div id = base>
	<div id="form">
		<h2>로그인</h2>
		<form action="/Holy_Juice_Market/user/login.do" method="post">
			<br> 아이디 &nbsp; &nbsp;: <input type="text" name="login_id" required="required">
			<br> 비밀번호 &nbsp; &nbsp;: <input type="password" name="login_pw" required="required">
			<br> 
			<br>
			<button type="submit">로그인</button>
			<br>
		</form>
	</div>
	</div>
	</section>
	<footer>
		<jsp:include page="/jsp/include/footer.jsp" />
	</footer>
</body>
</html>