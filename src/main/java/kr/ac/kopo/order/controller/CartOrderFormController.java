package kr.ac.kopo.order.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.cart.service.CartService;
import kr.ac.kopo.cart.vo.CartVO;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.order.service.OrderService;
import kr.ac.kopo.order.vo.OrderVO;

public class CartOrderFormController implements Controller {
	private OrderService orderService;
	private CartService cartService;
	public CartOrderFormController() {
		orderService = new OrderService();
		cartService = new CartService(); 
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		HttpSession session = request.getSession();
		int user_no = (int) session.getAttribute("user_no");
		
		List<CartVO> cartList = cartService.selectCart(user_no);
		int totalPrice = 0;
		for (CartVO cart : cartList) {
			totalPrice += cart.getPrice()*cart.getQty();
			orderList.add(OrderVO.from(cart));/*여기도 이미지,상품명,가격 추가해줘야할듯 12-16(완료) */
		}
		request.setAttribute("orderList", orderList);
		request.setAttribute("totalPrice", totalPrice);		
		return "/jsp/order/cartOrderForm.jsp";
	}

}
