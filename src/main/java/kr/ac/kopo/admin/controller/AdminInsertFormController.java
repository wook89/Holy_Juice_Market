package kr.ac.kopo.admin.controller;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;


public class AdminInsertFormController implements Controller {
	
	public AdminInsertFormController() {
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/jsp/admin/insertItem.jsp";
	}
}
