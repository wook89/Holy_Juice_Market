<style>
#footer {
	margin-top:200px;
    background-color: #121212; /* 딥 블랙 배경 */
    color: #ffffff; /* 화이트 텍스트 */
    padding: 20px 0;
    font-family: Arial, sans-serif;
}

/* Footer 컨테이너 */
.footer-container {
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    max-width: 1200px;
    margin: 0 auto;
    padding: 0 20px;
    flex-wrap: wrap;
}

/* Footer 섹션 */
.footer-section {
    flex: 1;
    margin: 10px;
    min-width: 250px; /* 작은 화면에서도 레이아웃 유지 */
}

/* 섹션 제목 */
.footer-section h3 {
    font-size: 18px;
    border-bottom: 2px solid #ffffff;
    padding-bottom: 5px;
    margin-bottom: 15px;
    color: #f1f1f1;
}

/* 섹션 텍스트 */
.footer-section p {
    font-size: 14px;
    line-height: 1.6;
    margin: 0 0 10px;
    color: #bdbdbd; /* 연한 회색 */
}

/* 퀵 링크 스타일 */
.footer-section ul {
    list-style: none;
    padding: 0;
}

.footer-section ul li {
    margin-bottom: 10px;
}

.footer-section ul li a {
    text-decoration: none;
    color: #ffffff;
    font-size: 14px;
    transition: color 0.3s;
}

.footer-section ul li a:hover {
    color: #d1d1d1; /* 링크 호버 색상 */
}

/* Footer 하단 영역 */
.footer-bottom {
    background-color: #1c1c1c; /* 다크 그레이 */
    text-align: center;
    padding: 10px 0;
    font-size: 12px;
    color: #aaaaaa; /* 라이트 그레이 */
}

/* 반응형 디자인 */
@media (max-width: 768px) {
    .footer-container {
        flex-direction: column;
        text-align: center;
    }

    .footer-section {
        margin-bottom: 20px;
    }
}
</style>
<footer id="footer">
    <div class="footer-container">
        <div class="footer-section">
            <h3>About Us</h3>
            <p>We are committed to delivering the best service and products to our customers. Your satisfaction is our priority.</p>
        </div>
        <div class="footer-section">
            <h3>Contact Us</h3>
            <p>Email: contact@example.com</p>
            <p>Phone: +123-456-7890</p>
            <p>Address: 123 Main Street, City, Country</p>
        </div>
    </div>
    <div class="footer-bottom">
        <p>&copy; 2024 Holy Juice. All Rights Reserved.</p>
    </div>
</footer>