<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="/Holy_Juice_Market/resources/js/jquery-3.7.1.min.js"></script>
<script>
	$(document).ready(function(){
	});
</script>
</head>
<body>
<%-- <c:if test="${not empty requestScope.errmsg }">
	<div class="alert alert-danger text-center">
          ${requestScope.errMsg}
        </div>
</c:if> --%>
<header>
		<jsp:include page="/jsp/include/topMenuBar.jsp" />
	</header>
<section>
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
	</section>
	<footer>
		<jsp:include page="/jsp/include/footer.jsp" />
	</footer>
</body>
</html>