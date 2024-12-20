package kr.ac.kopo.delivery.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.delivery.service.DeliverService;

public class DeleteToDeliverController implements Controller {
	private DeliverService deliverService;
	
	
	public DeleteToDeliverController() {
		deliverService = new DeliverService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int d_no = Integer.parseInt(request.getParameter("delivery_no"));
		deliverService.deleteADDR(d_no);
		return "redirect:/user/myPageForm.do";
	}

}
