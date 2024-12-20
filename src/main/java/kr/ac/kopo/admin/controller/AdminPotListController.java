package kr.ac.kopo.admin.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.item.service.ItemService;
import kr.ac.kopo.item.vo.ItemVO;

public class AdminPotListController implements Controller {
	private ItemService itemService;

	public AdminPotListController() {
		itemService = new ItemService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ItemVO> itemList = itemService.selectAllPot();
		request.setAttribute("itemList", itemList);
		return "/jsp/admin/selectAllItem_admin.jsp";
	}

}
