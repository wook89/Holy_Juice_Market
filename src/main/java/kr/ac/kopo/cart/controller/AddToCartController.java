package kr.ac.kopo.cart.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.cart.service.CartService;
import kr.ac.kopo.cart.vo.CartVO;
import kr.ac.kopo.controller.Controller;

public class AddToCartController implements Controller {
	private CartService cartService;

	public AddToCartController() {
		cartService = new CartService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int qty;
		int user_no = Integer.parseInt(request.getParameter("user_no"));
		int item_cd = Integer.parseInt(request.getParameter("item_cd"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		CartVO cart = new CartVO(user_no,item_cd,quantity);
		CartVO existingCart = cartService.selectOneCartInItem(cart);
		if(existingCart != null) {
			cart.setQty(existingCart.getQty()+quantity);
			cartService.updateToItemQTY(cart);
		}else {
			cartService.addToCart(cart);
		}
		List<CartVO> cartList = cartService.selectCart(user_no);
		int cartSize = cartList.size();
        HttpSession session = request.getSession();
		session.setAttribute("cartSize",cartSize);
		return "redirect:/item/list.do";
	}

}
