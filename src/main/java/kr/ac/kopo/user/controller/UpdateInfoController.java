package kr.ac.kopo.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.user.service.UserService;
import kr.ac.kopo.user.vo.UserVO;

public class UpdateInfoController implements Controller {
	private UserService userService;
	
	
	public UpdateInfoController() {
		userService = new UserService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int user_no = (int)session.getAttribute("user_no");
		String user_id = request.getParameter("user_id");
		String pw = request.getParameter("password");
		String user_name = request.getParameter("user_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		UserVO user = new UserVO(user_no,user_id,pw,user_name,email,phone);
		userService.updateUserInfo(user);
		
		return "/user/myPageForm.do";
	}

}
