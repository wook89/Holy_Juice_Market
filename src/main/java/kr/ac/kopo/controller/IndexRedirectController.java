package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IndexRedirectController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.sendRedirect("/Holy_Juice_Market/item/list.do");
        return null;  // JSP 경로를 반환하지 않음
    }
}
