package kr.ac.kopo.include.controller;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.cart.service.CartService;
import kr.ac.kopo.cart.vo.CartVO;
import kr.ac.kopo.controller.Controller;

public class topMenuBarController implements Controller {
	private CartService cartService;
	public topMenuBarController() {
		cartService = new CartService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 요청 본문 읽기
        StringBuilder requestBody = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
        }
        // JSON 데이터 파싱 (수동 처리)
        Map<String, String> jsonMap = parseJson(requestBody.toString());
        System.out.println(jsonMap);
        // 파싱된 값 가져오기
        int user_no = Integer.parseInt(jsonMap.get("userNo"));
        System.out.println("json user_no ========================="+user_no);
        List<CartVO> cartList = cartService.selectCart(user_no);
        int totalPrice = 0;
        int totalQTY = 0;
        for(CartVO cartVO : cartList) {
        	totalPrice += (cartVO.getPrice()*cartVO.getQty());
        	totalQTY += cartVO.getQty();
        }
        String jsonResponse = "{"
                 + "\"totalPrice\":\"" + totalPrice + "\","
                 + "\"totalQTY\":\"" + totalQTY + "\""
                + "}";
        // 응답 설정
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println(jsonResponse);
        response.getWriter().write(jsonResponse);
        HttpSession session = request.getSession();
        return null; // 비동기 응답이므로 뷰를 반환하지 않음
    }
	
    // JSON 문자열을 Map으로 파싱하는 유틸리티 메서드
    private Map<String, String> parseJson(String jsonString) {
        Map<String, String> map = new HashMap<>();
        jsonString = jsonString.trim().replaceAll("[{}\"]", ""); // 중괄호와 따옴표 제거
        String[] pairs = jsonString.split(",");

        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            if (keyValue.length == 2) {
                map.put(keyValue[0].trim(), keyValue[1].trim());
            }
        }
        return map;
    }

}
