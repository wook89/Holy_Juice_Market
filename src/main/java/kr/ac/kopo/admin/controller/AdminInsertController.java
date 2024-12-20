package kr.ac.kopo.admin.controller;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.item.service.ItemService;
import kr.ac.kopo.item.vo.ItemVO;


public class AdminInsertController implements Controller {
	private ItemService itemService;
	
	
	public AdminInsertController() {
		itemService = new ItemService();
	}
	
	/*
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("POST 요청 처리 성공!");
		System.out.println("POST 요청 처리 성공 ~");
		
		try {
	        String view = handleRequest(req, resp); // handleRequest 호출
	        req.getRequestDispatcher(view).forward(req, resp); // 반환된 JSP로 포워딩
	    } catch (Exception e) {
	        e.printStackTrace();
	        resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request.");
	    }
	}
	*/

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 // S3 설정
	    final String bucketName = "pcshop1"; // S3 버킷 이름
	    final String region = "ap-northeast-2"; // S3 리전
	    String fileUrl = null;

	    // 멀티파트 요청인지 확인
	    if (request.getContentType() != null && request.getContentType().startsWith("multipart/form-data")) {
	        try {
	            // 파일 데이터를 Part로 읽어오기
	            Part filePart = request.getPart("file"); // input 태그의 name 속성
	            String fileName = UUID.randomUUID().toString() + "_" + filePart.getSubmittedFileName(); // 고유 파일 이름 생성
	            InputStream fileContent = filePart.getInputStream(); // 파일 데이터를 InputStream으로 읽음

	            // S3 클라이언트 생성 (환경 변수에서 자격 증명 사용)
	            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
	                .withRegion(region)
	                .build();

	            // S3에 파일 업로드 (InputStream 사용, ACL 제거)
	            s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileContent, null));
	            // 업로드된 파일의 URL 생성
	            fileUrl = "https://" + bucketName + ".s3." + region + ".amazonaws.com/" + fileName;
	            // 화면에 URL과 이미지를 출력
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    } else {
	    	System.out.println("<p>Invalid request. Please upload an image file.</p>");
	    }
        
	    
		String name = request.getParameter("item_name");
		String description = request.getParameter("description");
		int price = Integer.parseInt(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		int category = Integer.parseInt(request.getParameter("category_id"));
		
		ItemVO item = new ItemVO(name,
								 description,
								 price,
								 stock,
								 category,
								 fileUrl);
		
		boolean isSuccess = itemService.insertItem(item);
		System.out.println("삽입결과 확인 =============="+isSuccess);
		
		/*
		 * List<ItemVO> itemList = itemService.selectAllItem();
		 * request.setAttribute("itemList", itemList);
		 */
		return "redirect:/item/list.do";
		
	}
}
