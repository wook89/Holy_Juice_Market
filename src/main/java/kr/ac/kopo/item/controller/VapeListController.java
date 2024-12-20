package kr.ac.kopo.item.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.item.service.ItemService;
import kr.ac.kopo.item.vo.ItemVO;

public class VapeListController implements Controller{
	private ItemService itemService;
	public VapeListController() {
		itemService = new ItemService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ItemVO> itemList = itemService.selectAllVape();
		request.setAttribute("itemList", itemList);
		return "/jsp/item/itemList.jsp";
	}

}
