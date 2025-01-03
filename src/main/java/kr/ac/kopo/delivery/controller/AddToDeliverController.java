package kr.ac.kopo.delivery.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.delivery.service.DeliverService;
import kr.ac.kopo.delivery.vo.DeliveryVO;
import kr.ac.kopo.user.vo.UserVO;

public class AddToDeliverController implements Controller {
	DeliverService deliverService;
	
	
	public AddToDeliverController() {
		deliverService = new DeliverService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int user_no = (int) session.getAttribute("user_no");
		String alias = request.getParameter("alias");
		String addr = request.getParameter("addr");
		String detail_addr = request.getParameter("detail_addr");
		String postal_code = request.getParameter("postal_code");
		DeliveryVO deliverVO = new DeliveryVO(user_no, addr, detail_addr, postal_code, alias);
		
		List<DeliveryVO> BaseList = deliverService.selectToUserNo(user_no);
		if(BaseList.size() < 5) {
		deliverService.updateAllFalse(user_no);//is_default값 전부 F 로 초기화
		deliverService.insertADDR(deliverVO);// 새로운 배송지 등록하면서 is_default값 T 로 초기화 하기때문
		List<DeliveryVO> deliveryList = deliverService.selectToUserNo(user_no);
		request.setAttribute("deliveryList", deliveryList);
		return "redirect:/user/myPageForm.do";
		}else {
			request.setAttribute("deliveryList", BaseList);
			return "redirect:/user/myPageForm.do?message=1";
		}
		
		
	}

}
