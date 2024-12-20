package kr.ac.kopo.framework;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;
@MultipartConfig(
		maxFileSize = 10485760,
		maxRequestSize = 52428800,
		fileSizeThreshold = 5242880,
		location = "c:/temp1"
)
public class Dispatcher extends HttpServlet{
	private HandlerMapping mappings;
	@Override
	public void init(ServletConfig config) throws ServletException {
		String propName = config.getInitParameter("propName");
		System.out.println("propName : "+propName);
		mappings = new HandlerMapping(propName);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		System.out.println("uri1 = "+uri);
		uri = uri.substring(contextPath.length());
		System.out.println("uri2 = "+uri);////////////////////
		System.out.println(request.getMethod());
		try {
			
			Controller control = mappings.getController(uri);
			System.out.println("control = "+control);////////////////
			String callPage = control.handleRequest(request, response);
			
			if(callPage == null) {}
			else if(callPage.startsWith("redirect:")) {
				callPage = callPage.substring("redirect:".length());
				response.sendRedirect(request.getContextPath()+callPage);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
	}
}
