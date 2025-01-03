<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom CSS (Optional) -->
<link href="css/custom.css" rel="stylesheet">
<script src="/Holy_Juice_Market/resources/js/jquery-3.7.1.min.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 20px;
        }
        .form-container {
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            background-color: #f9f9f9;
        }
        .form-container div {
            margin-bottom: 15px;
        }
        .form-container label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        .form-container input[type="text"],
        .form-container input[type="password"],
        .form-container input[type="email"],
        .form-container input[type="tel"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-container input[readonly] {
            background-color: #e9ecef;
            cursor: not-allowed;
        }
        .form-container .button-container {
            text-align: center;
        }
        .form-container button {
            padding: 10px 20px;
            border: none;
            background-color: #007bff;
            color: white;
            border-radius: 4px;
            cursor: pointer;
        }
        .form-container button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenuBar.jsp" />
	</header>
	<section>
	
	<div class="form-container">
        <form action="/Holy_Juice_Market/user/updateInfo.do" method="POST">
            <div>
                <label for="user-id">ID</label>
                <input type="text" id="user-id" name="user_id" value="${user.user_id}" readonly>
            </div>
            <div>
                <label for="user-password">Password</label>
                <input type="password" id="user-password" name="password" value="${user.password}" required="required">
            </div>
            <div>
                <label for="user-name">이름</label>
                <input type="text" id="user-name" name="user_name" value="${user.user_name}" required="required">
            </div>
            <div>
                <label for="user-email">Email</label>
                <input type="email" id="user-email" name="email" value="${user.email}" required="required">
            </div>
            <div>
                <label for="user-phone">Phone</label>
                <input type="tel" id="user-phone" name="phone" value="${user.phone}" required="required">
            </div>
            <div class="button-container">
                <button type="submit">정보 수정</button>
            </div>
        </form>
    </div>
	
	</section>
	<footer>
		<jsp:include page="/jsp/include/footer.jsp" />
	</footer>
	<!-- Bootstrap JS Bundle (Includes Popper.js) -->
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>