package kr.ac.kopo.order.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.cart.vo.CartVO;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.item.service.ItemService;
import kr.ac.kopo.item.vo.ItemVO;
import kr.ac.kopo.order.service.OrderService;
import kr.ac.kopo.order.vo.OrderVO;

public class OrderFormController implements Controller {
	private OrderService orderService;
	private ItemService itemService;

	public OrderFormController() {
		orderService = new OrderService();
		itemService = new ItemService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int item_cd = Integer.parseInt(request.getParameter("item_cd"));
		int user_no = (int)session.getAttribute("user_no");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		/* item_url,item_name,item_price */
		ItemVO item = itemService.selectOneItem(item_cd);//해당 아이템의 이미지,상품명,가격의 속성값을 추출하기위해
		List<OrderVO> orderList = List.of(new OrderVO( user_no,item_cd, quantity, item.getImg_url(),item.getItem_name(),item.getPrice()));
		request.setAttribute("item_cd", item_cd);
		request.setAttribute("quantity", quantity);
		request.setAttribute("orderList", orderList);
		request.setAttribute("totalPrice", item.getPrice());
		
		return "/jsp/order/orderForm.jsp";
	}
}
