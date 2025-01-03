package kr.ac.kopo.inquiry.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.inquiry.service.InquiryBoardService;

public class InquiryBoardController implements Controller {
	private InquiryBoardService inquiryBoardService;
	
	public InquiryBoardController() {
		inquiryBoardService = new InquiryBoardService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/jsp/inquiry/inquiryBoard.jsp";
	}
}
