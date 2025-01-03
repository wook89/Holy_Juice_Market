package kr.ac.kopo.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.user.service.UserService;
import kr.ac.kopo.user.vo.UserVO;

public class UpdateInfoFormController implements Controller {
	UserService userService;
	public UpdateInfoFormController() {
		userService = new UserService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int user_no = (int)session.getAttribute("user_no");
		UserVO user = userService.selectOneUser(user_no);
		request.setAttribute("user", user);
		return "/jsp/user/updateInfoForm.jsp";
	}
}
