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
import kr.ac.kopo.item.service.ItemService;
import kr.ac.kopo.item.vo.ItemVO;
import kr.ac.kopo.order.service.OrderService;
import kr.ac.kopo.order.vo.OrderVO;
import kr.ac.kopo.user.vo.UserVO;

public class OrderController implements Controller {
	private OrderService orderService;
	private ItemService itemService;
	private DeliverService deliveryService;
	

	public OrderController() {
		orderService = new OrderService();
		itemService = new ItemService();
		deliveryService = new DeliverService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int item_cd = Integer.parseInt(request.getParameter("item_cd"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int user_no = (int)session.getAttribute("user_no");
		DeliveryVO deliVO = deliveryService.selectBase(user_no);
		int addr = deliVO.getDelivery_no();
		
		  ItemVO item = itemService.selectOneItem(item_cd);//해당 아이템의 이미지,상품명,가격의 속성값을 추출하기위해 
		  List<OrderVO> orderList = List.of(new OrderVO( user_no,item_cd,
		  quantity, item.getImg_url(),item.getItem_name(),item.getPrice()));
		 
			orderList.get(0).setDelivery_no(addr);
			orderList.get(0).setLine_no(1);
			
			orderService.insertOne(orderList.get(0));
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
