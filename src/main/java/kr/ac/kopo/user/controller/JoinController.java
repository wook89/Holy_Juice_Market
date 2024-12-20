package kr.ac.kopo.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.user.service.UserService;
import kr.ac.kopo.user.vo.UserVO;

public class JoinController implements Controller{
	private UserService userService;
	public JoinController() {
		userService = new UserService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("조인 컨트롤러 들어왔냐");
		String id = request.getParameter("user_id");
		String pw = request.getParameter("password");
		String name = request.getParameter("user_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("address");
		
		UserVO user = new UserVO(id, pw, name, email, phone);
		System.out.println(user.toString());
		userService.insertUser(user);
		return "redirect:/user/loginForm.do";
	}

	
}
