<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
	 <!-- Custom CSS (Optional) -->
    <link href="css/custom.css" rel="stylesheet">
<script>
	
</script>
<style>
       body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        header {
            text-align: center;
            padding: 15px 0;
        }
        section {
            text-align: center;
            margin-left: 20px;
        }
        /* 테이블을 별도로 가운데 정렬 */
        .table-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: calc(100vh - 150px); /* 헤더 높이를 뺀 값으로 조정 */
        }
        table {
            border-collapse: collapse;
            width: 80%;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #007bff;
            color: white;
            text-align: center;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        caption {
            caption-side: top;
            font-size: 1.5em;
            font-weight: bold;
            margin-bottom: 10px;
        }
     
</style>
</head>
    <script>
        function confirmNavigation(item_name,item_cd) {
        	console.log(item_name)
        	alert(item_cd)
            if (confirm(`${"${item_name}"} 상품을 삭제하시겠습니까?`)) {
                // 사용자가 확인을 누르면 해당 URL로 이동
                location.href =`/Holy_Juice_Market/admin/deleteItem.do?item_cd=${"${item_cd}"}`;
            } else {
                // 취소를 누르면 아무 동작도 하지 않음
                return false;
            }
        }
        
        function navigateToSelect(value) {
            // 선택된 값에 따라 URL 이동
            if (value === "all") {
				location.href = "/Holy_Juice_Market/admin/list.do"
            } else if (value === "juice") {
                location.href = "/Holy_Juice_Market/admin/JuiceList.do";
            } else if (value === "vape") {
                location.href = "/Holy_Juice_Market/admin/VapeList.do";
            } else if (value === "pot") {
                location.href = "/Holy_Juice_Market/admin/PotList.do";
            }
        }
    </script>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenuBar.jsp" />
		<br>
		<jsp:include page="/jsp/include/radioSelect.jsp"/>
	</header>

<section>
	<table border="1">
		<tr>
			<th>상품코드</th>
			<th>상품명</th>
			<th>설명</th>
			<th>가격</th>
			<th>재고</th>
			<th>카테고리</th>
			<th>등록일</th>
			<th>수정일</th>
			<th>관리</th>
		</tr>
		<c:forEach items="${ itemList }" var="itemVO">
		<tr>
			<td>${ itemVO.item_cd }</td>
			<td>${ itemVO.item_name }</td>
			<td>${ itemVO.description }</td>
			<td>${ itemVO.price }</td>			
			<td>${ itemVO.stock }</td>
			<td>${ itemVO.category_name }</td>
			<td>${ itemVO.create_at }</td>
			<td>${ itemVO.update_at }</td>
			<td> 
			<a href="/Holy_Juice_Market/admin/updateItemForm.do?item_cd=${ itemVO.item_cd }"><button>수정</button></a>&nbsp
			<a href="javascript:void(0);"
			   onclick="confirmNavigation('${ itemVO.item_name }','${ itemVO.item_cd }');"><button>삭제</button></a>
			</td>
		</tr>
		</c:forEach>
	</table>
</section>

	<footer>
		<jsp:include page="/jsp/include/footer.jsp" />
	</footer>
</body>
</html>