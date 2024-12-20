package kr.ac.kopo.cart.controller;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.cart.service.CartService;
import kr.ac.kopo.cart.vo.CartVO;
import kr.ac.kopo.controller.Controller;

public class UpdateQuantityController implements Controller {
    private CartService cartService;

    public UpdateQuantityController() {
        cartService = new CartService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String qtt = request.getParameter("qty");
    	System.out.println("====================================="+qtt );
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
        int item_cd = Integer.parseInt(jsonMap.get("itemCode"));
        int user_no = Integer.parseInt(jsonMap.get("userNo"));
        int qty = Integer.parseInt(jsonMap.get("qty"));
        System.out.println("json item_cd ========================="+item_cd);
        System.out.println("json user_no ========================="+user_no);
        System.out.println("json qty ========================="+qty);
        CartVO cart = new CartVO(user_no,item_cd,qty);
        CartVO cart2 = cartService.selectCart(cart);
        boolean success = cartService.updateQuantity(cart);
        System.out.println(success);
        List<CartVO> cartList = cartService.selectCart(user_no);
        HttpSession session = request.getSession();
		session.setAttribute("cartList",cartList);
        int totalPrice = 0;
        int totalQTY = 0;
        for(CartVO cartVO : cartList) {
        	totalPrice += (cartVO.getPrice()*cartVO.getQty());
        	totalQTY += cartVO.getQty();
        }
        System.out.println("totalPrice ============== : "+totalPrice);
        
        int price = cart2.getPrice();
        int subtotalPrice = price*qty;
        System.out.println("---------------"+subtotalPrice);
        // 비즈니스 로직 처리
        
        // JSON 응답 작성
        String jsonResponse = "{"
                + "\"status\":\"" + (success ? "true" : "false") + "\","
                + "\"message\":\"" + (success ? "수량이 성공적으로 업데이트되었습니다." : "수량 업데이트에 실패했습니다.") + "\","
                + "\"subtotalPrice\":\"" + subtotalPrice + "\","
                 + "\"totalPrice\":\"" + totalPrice + "\","
                 + "\"totalQTY\":\"" + totalQTY + "\""
                + "}";
        // 응답 설정
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println(jsonResponse);
        response.getWriter().write(jsonResponse);

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
