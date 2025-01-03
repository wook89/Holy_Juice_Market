package kr.ac.kopo.delivery.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.delivery.service.DeliverService;
import kr.ac.kopo.delivery.vo.DeliveryVO;

public class UpdateToDeliveryTypeController implements Controller {
	private DeliverService deliveryService;
	
	public UpdateToDeliveryTypeController() {
		deliveryService = new DeliverService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int user_no = (int)session.getAttribute("user_no");
		int d_no = Integer.parseInt(request.getParameter("delivery_no"));
		System.out.println("user_no : "+user_no+"  d_no : "+d_no);
		deliveryService.updateAllFalse(user_no);
		deliveryService.updateType(d_no);
		return "redirect:/user/myPageForm.do";
	}
}
