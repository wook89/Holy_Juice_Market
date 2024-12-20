package kr.ac.kopo.cart.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.cart.service.CartService;
import kr.ac.kopo.cart.vo.CartVO;
import kr.ac.kopo.controller.Controller;

public class CartItemController implements Controller {
	private CartService cartService;

	public CartItemController() {
		cartService = new CartService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//int user_no = Integer.parseInt(request.getParameter("user_no"));
		HttpSession session = request.getSession();
		int user_no = (int) session.getAttribute("user_no");
		// System.out.println("=========================================================no"+user_no);
		List<CartVO> cartList = cartService.selectCart(user_no);
		int totalPrice = 0;
		for (CartVO cartVO : cartList) {
			totalPrice += (cartVO.getPrice() * cartVO.getQty());
		}
		request.setAttribute("cartList", cartList);
		request.setAttribute("totalPrice", totalPrice);
		if (cartList.size() == 0) {
			return "/item/list.do";
		} else {
			return "/jsp/cart/myCart.jsp";
		}
	}
}
