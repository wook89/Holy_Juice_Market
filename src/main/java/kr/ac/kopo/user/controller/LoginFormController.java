package kr.ac.kopo.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.user.service.UserService;

public class LoginFormController implements Controller {
	private UserService userService;
	
	public LoginFormController() {
		userService = new UserService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/jsp/user/loginForm.jsp";
	}
}
