<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 작성</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom CSS (Optional) -->
<link href="css/custom.css" rel="stylesheet">
<script src="/Holy_Juice_Market/resources/js/jquery-3.7.1.min.js"></script>
    <style>
        #mainDIV {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            display: flex;
            height: 100vh;
            justify-content: center;
            align-items: center;
        }

        #inquiry-form {
            width: 40%;
            padding: 20px;
            background-color: #ffffff;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        #inquiry-form h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        #inquiry-form label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
            color: #555;
        }

        #inquiry-form textarea {
            width: 100%;
            height: 150px;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
            resize: none;
        }

        #inquiry-form button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        #inquiry-form button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<header>
		<jsp:include page="/jsp/include/topMenuBar.jsp" />
	</header>
	<section>
	
	<div id="mainDIV">
    <div id="inquiry-form">
        <h2>문의 작성</h2>
        <form action="/submitInquiry" method="post">

            <!-- CONTENT -->
            <label for="content">문의 내용</label>
            <textarea id="content" name="content" required placeholder="문의 내용을 입력해주세요"></textarea>
            <br>

            <!-- 제출 버튼 -->
            <button type="submit">문의 등록</button>
        </form>
    </div>
    </div>
    
    </section>
	<footer>
		<jsp:include page="/jsp/include/footer.jsp" />
	</footer>
	<!-- Bootstrap JS Bundle (Includes Popper.js) -->
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>