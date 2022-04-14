package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductVO;

// 작성자 : 정예성
// 기능  : 할인 중인 상품 목록 출력
public class ProductSaleAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 세일중인 상품을 출력하는 화면 경로 url 세팅
		String url = "productList/saleList.jsp";
		
		// 상품 목록을 불러올 객체 생성 
	    ProductDAO productDAO = ProductDAO.getInstance();
	    
	    // 할인중인 상품 목록을 배열리스트에 담는다.
	    ArrayList<ProductVO> productList = productDAO.saleList();	    
	    
	    // 할인중인 상품 목록을 HttpServletrequest에 세팅
	    request.setAttribute("productList", productList);
	    
	    // 설정한 url로 할인중인 상품 목록 response
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
