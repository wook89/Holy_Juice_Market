package kr.ac.kopo.cart.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.cart.service.CartService;
import kr.ac.kopo.cart.vo.CartVO;
import kr.ac.kopo.controller.Controller;

public class deleteCartItemController implements Controller {
	private CartService cartService;
	
	
	public deleteCartItemController() {
		cartService = new CartService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int item_cd = Integer.parseInt(request.getParameter("item_cd"));
		int user_no = Integer.parseInt(request.getParameter("user_no"));
		CartVO cart = new CartVO(user_no, item_cd);
		cartService.deleteCartInItem(cart);
		List<CartVO> cartList = cartService.selectCart(user_no);
		int cartSize = cartList.size();
        HttpSession session = request.getSession();
		session.setAttribute("cartSize",cartSize);
		
		return "redirect:/cart/cartItem.do?user_no=" + user_no;
	}
}

