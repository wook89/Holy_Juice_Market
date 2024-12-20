<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenuBar.jsp" />
	</header>

<section>

	<a href="/Holy_Juice_Market/admin/insertForm.do"><button>상품 등록</button></a>
	<a href="/Holy_Juice_Market/admin/list.do"><button>상품 수정&삭제</button></a>
	
</section>

<footer>
	<jsp:include page="/jsp/include/footer.jsp" />
</footer>	
</body>
</html>