package kr.ac.kopo.order.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.cart.service.CartService;
import kr.ac.kopo.cart.vo.CartVO;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.delivery.vo.DeliveryVO;
import kr.ac.kopo.item.service.ItemService;
import kr.ac.kopo.item.vo.ItemVO;
import kr.ac.kopo.order.service.OrderService;
import kr.ac.kopo.order.vo.OrderVO;
import kr.ac.kopo.user.vo.UserVO;

public class OrderController implements Controller {
	private OrderService orderService;
	private CartService cartService;
	private ItemService itemService;

	public OrderController() {
		orderService = new OrderService();
		cartService = new CartService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		List<DeliveryVO> deliveryList = (List<DeliveryVO>) session.getAttribute("deliveryList");
		List<CartVO> cartList = (List<CartVO>) session.getAttribute("cartList");
		List<OrderVO> orderList = (List<OrderVO>) session.getAttribute("orderList");
		UserVO user = (UserVO) session.getAttribute("user");
		int addr = Integer.parseInt(request.getParameter("selectedAddress"));
		if(orderList == null || orderList.size() == 0 ) {
		int user_no = user.getUser_no();
		
		for (int i = 0; i < cartList.size(); i++) {
			cartList.get(i).setDelivery_no(addr);
			cartList.get(i).setLine_no(i+1);
		}
		/*
		 * int item_cd = cartList.get(0).getItem_cd(); int order_qty =
		 * cartList.get(0).getQty(); ItemVO item = itemService.selectOneItem(item_cd);
		 * item.setStock(item.getStock()-order_qty); itemService.updateStock(item);
		 */
			orderService.insertFirst(cartList.get(0));
		for (int i = 1; i < cartList.size(); i++) {
			orderService.insertAfter(cartList.get(i));
		}
			cartService.deleteAllCart(user_no);
			//session.removeAttribute("cartList");
		}else {
			orderList.get(0).setDelivery_no(addr);
			orderList.get(0).setLine_no(1);
			
			orderService.insertOne(orderList.get(0));
			session.removeAttribute("orderList");
		}
		/*
		 * (usre, item, qty) Sqlsession.insert("nameSpace.firstInsert");
		 * 
		 * firstInsert : seq_ORDER_ID.nextval line_no : 1
		 * 
		 * for(int i = 1; i < itemList.length; i++) {
		 * Sqlsession.insert("nameSpace.nextInsert"); nextInsert : seq_ORDER_ID.currval
		 * line_no : i + 1 }
		 */

		return "redirect:/item/list.do";
	}

}
