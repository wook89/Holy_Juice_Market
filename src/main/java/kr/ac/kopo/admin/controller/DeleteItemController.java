package kr.ac.kopo.admin.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.item.service.ItemService;

public class DeleteItemController implements Controller {
	private ItemService itemService;
	
	
	public DeleteItemController() {
		itemService = new ItemService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int item_cd = Integer.parseInt(request.getParameter("item_cd"));
		System.out.println("item_cd:"+item_cd);
			itemService.deleteItem(item_cd);
		return "redirect:/admin/list.do";
	}

}
