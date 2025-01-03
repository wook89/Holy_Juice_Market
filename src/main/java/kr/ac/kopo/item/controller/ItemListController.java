package kr.ac.kopo.item.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.item.service.ItemService;
import kr.ac.kopo.item.vo.ItemVO;

public class ItemListController implements Controller {

    private ItemService itemService;

    public ItemListController() {
        itemService = new ItemService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 1. 페이징 관련 변수 설정
        int itemsPerPage = 18; // 한 페이지당 아이템 수
        int currentPage = 1; // 기본값: 1페이지

        // 클라이언트로부터 현재 페이지 번호 받기
        String pageParam = request.getParameter("page");
        if (pageParam != null) {
            currentPage = Integer.parseInt(pageParam);
        }

        // 2. 데이터베이스에서 필요한 범위의 데이터 조회
        int totalItems = itemService.getTotalItems(); // 전체 아이템 수
        int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage); // 전체 페이지 수

        int startRow = (currentPage - 1) * itemsPerPage ; // 시작 행
        int endRow = currentPage * itemsPerPage; // 종료 행

        // 현재 페이지에 해당하는 데이터 조회
        List<ItemVO> itemList = itemService.selectItemsByPage(startRow, endRow);

        // 3. JSP에 데이터 전달
        request.setAttribute("itemList", itemList); // 아이템 목록
        request.setAttribute("currentPage", currentPage); // 현재 페이지 번호
        request.setAttribute("totalPages", totalPages); // 총 페이지 수

        return "/index.jsp"; // 반환할 JSP 경로
    }
}
