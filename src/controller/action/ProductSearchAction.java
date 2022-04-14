package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDAO;
import dao.ProductDAO;
import dto.BigCategoryDTO;
import dto.CategoryVO;
import dto.ProductVO;

// 작성자 : 정예성
// 기능  : 검색한 상품 목록 출력
public class ProductSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 검색한 상품 출력하는 화면 url 세팅 
		String url = "productList/searchList.jsp";
		
		// 검색한 상품 이름을 request 객체로부터 받아옴 
	    String productName = request.getParameter("productName");
	    
	    // 검색한 상품을 불러오는 쿼리를 실행하기 위한 DAO 선언 
	    ProductDAO productDAO = ProductDAO.getInstance();
	    
	    // 헤더 카테고리 출력 
	  	CategoryDAO categoryDAO = CategoryDAO.getInstance();
	    
	  	// 헤더 카테고리 출력 
	    ArrayList<BigCategoryDTO> menuCateogoryList = categoryDAO.getCategoryInfo();
	    
	    // 검색한 상품이름을 파라미터로 전달하여 검색 결과 상품 리스트를 담은 배열리스트 선언 
	    ArrayList<ProductVO> searchList = productDAO.searchList(productName);	 
	    
	    // 각각의 배열 리스트들을 HttpServletrequest에 세팅 
	    request.setAttribute("menuCategoryList", menuCateogoryList);
	    request.setAttribute("searchList", searchList);
	    
	    // 설정한 url로 값 전달
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
