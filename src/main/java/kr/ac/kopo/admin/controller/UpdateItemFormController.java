package kr.ac.kopo.admin.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.item.service.ItemService;
import kr.ac.kopo.item.vo.ItemVO;

public class UpdateItemFormController implements Controller {
	
	private ItemService itemService;
	public UpdateItemFormController() {
		itemService = new ItemService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int item_cd = Integer.parseInt(request.getParameter("item_cd"));
		ItemVO item = itemService.selectOneItem(item_cd);
		request.setAttribute("item", item);
		return "/jsp/admin/updateItemForm.jsp";
	}

}
