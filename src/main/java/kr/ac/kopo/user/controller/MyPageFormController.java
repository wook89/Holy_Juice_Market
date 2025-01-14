package kr.ac.kopo.user.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.delivery.service.DeliverService;
import kr.ac.kopo.delivery.vo.DeliveryVO;
import kr.ac.kopo.user.service.UserService;
import kr.ac.kopo.user.vo.UserVO;

public class MyPageFormController implements Controller {
	private UserService userService;
	private DeliverService deliverService;
	
	public MyPageFormController() {
		userService = new UserService();
		deliverService = new DeliverService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int user_no = (int)session.getAttribute("user_no");
		List<DeliveryVO> deliveryList = deliverService.selectToUserNo(user_no);
		DeliveryVO baseDelivery = deliverService.selectBase(user_no);
		UserVO user = userService.selectOneUser(user_no);
		System.out.println(user.toString());
		request.setAttribute("deliveryList", deliveryList);
		request.setAttribute("baseDelivery", baseDelivery);
		request.setAttribute("user", user);
		return "/jsp/user/myPage.jsp";
	}

}
