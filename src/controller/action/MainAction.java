package controller.action;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.ProductDAO;
import dto.BigCategoryVO;
import dto.CategoryVO;
import dto.ProductVO;

// 작성자 : 정예성, 유지훈
// 기능  : 메인 화면 카테고리, 상품 리스트 출력
public class MainAction implements Action {
  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {    
	  
	  	// 메인화면으로 forward url 설정
	  	String url = "/main.jsp"; 
	  	
	  	// 카테고리 목록에 뿌려줄 상품 대·소분류 항목을 가져올 DAO 객체 선언
	  	CategoryDAO categoryDAO = CategoryDAO.getInstance();
	  	
	  	// 메인화면 상품리스트에 뿌려줄 상품 목록을 가져올 ProductDAO 객체 선언
	  	ProductDAO productDAO = ProductDAO.getInstance();
	  	
	  	// 카테고리 리스트를 배열리스트에 담아준다. 
	    ArrayList<BigCategoryVO> menuCateogoryList = categoryDAO.getCategoryInfo();
	  	
	    // 메인화면에 특정 대분류 상품을 배열 리스트에 담아준다.
	  	ArrayList<ProductVO> productList = productDAO.productList(2);
	  	ArrayList<ProductVO> productList2 = productDAO.productList(52);
	  	
	  	// 각각의 배열 리스트를 HttpServletrequest에 세팅
	    request.setAttribute("menuCategoryList", menuCateogoryList);
	    request.setAttribute("productList", productList);
	    request.setAttribute("productList2", productList2);
	    
	    // 설정한 url로 response값 전달 
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
  }
}