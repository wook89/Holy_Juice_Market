package kr.ac.kopo.order.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.cart.service.CartService;
import kr.ac.kopo.cart.vo.CartVO;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.delivery.service.DeliverService;
import kr.ac.kopo.delivery.vo.DeliveryVO;
import kr.ac.kopo.order.service.OrderService;

public class CartOrderController implements Controller {
	private OrderService orderService;
	private CartService cartService;
	private DeliverService deliveryService;

	
	public CartOrderController() {
		orderService = new OrderService();
		cartService = new CartService();
		deliveryService = new DeliverService();

	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int user_no = (int)session.getAttribute("user_no");
		System.out.println(user_no);
		DeliveryVO deliVO = deliveryService.selectBase(user_no);
		int addr = deliVO.getDelivery_no();
		
		List<CartVO> cartList = cartService.selectCart(user_no);
		
		for (int i = 0; i < cartList.size(); i++) {
			cartList.get(i).setDelivery_no(addr);
			cartList.get(i).setLine_no(i+1);
		}
			orderService.insertFirst(cartList.get(0));
		for (int i = 1; i < cartList.size(); i++) {
			orderService.insertAfter(cartList.get(i));
		}
			cartService.deleteAllCart(user_no);
		return "redirect:/item/list.do";
	}

}
