package kr.ac.kopo.user.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.cart.service.CartService;
import kr.ac.kopo.cart.vo.CartVO;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.delivery.service.DeliverService;
import kr.ac.kopo.delivery.vo.DeliveryVO;
import kr.ac.kopo.login.vo.LoginVO;
import kr.ac.kopo.user.service.UserService;
import kr.ac.kopo.user.vo.UserVO;

public class LoginController implements Controller {
	private UserService userService;
	private CartService cartService;
	private DeliverService deliverService;
	
	public LoginController() {
		userService = new UserService();
		cartService = new CartService();
		deliverService = new DeliverService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("login_id");
		String pw = request.getParameter("login_pw");
		LoginVO log = new LoginVO(id, pw);
		UserVO user = userService.login(log);
		int user_no = user.getUser_no();
		int totalQTY = 0;
		List<CartVO> cartList = cartService.selectCart(user_no);
		int cartSize = cartList.size();
		List<DeliveryVO> deliveryList = deliverService.selectToUserNo(user_no);
		for(CartVO cartvo : cartList) {
			totalQTY += cartvo.getQty();
		}
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user_no", user_no);
			session.setAttribute("cartSize", cartSize);
			return "redirect:/item/list.do";
		} else {
			request.setAttribute("errmsg", "아이디 또는 비밀번호가 잘못되었습니다.");
			return "/jsp/user/loginForm.jsp";
		}
	}

}
