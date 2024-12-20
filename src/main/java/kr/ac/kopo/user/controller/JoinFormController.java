package kr.ac.kopo.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.user.service.UserService;

public class JoinFormController implements Controller {
	private UserService userService;
	public JoinFormController() {
		userService = new UserService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("조인폼 컨트롤러 들어왔냐");
		return "/jsp/user/joinForm.jsp";
	}
	
	
}
