package kr.ac.kopo.item.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.item.service.ItemService;
import kr.ac.kopo.item.vo.ItemVO;

public class DetailController implements Controller {
	ItemService itemService;
	
	public DetailController() {
		itemService = new ItemService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int item_cd = Integer.parseInt(request.getParameter("item_cd"));
		System.out.println(item_cd);
		ItemVO item = itemService.selectOneItem(item_cd);
		request.setAttribute("itemVO", item);
		return "/jsp/item/detailItem.jsp";
	}

}
