package kr.ac.kopo.admin.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;

public class AdminManagementController implements Controller {
	
	public AdminManagementController() {
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/jsp/admin/admin.jsp";
	}
}
