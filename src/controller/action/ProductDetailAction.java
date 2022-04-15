package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import dto.ProductVO;

// 작성자 : 김연식, 정예성
// 기능  : 선택한 상품의 상세 정보 출력 
public class ProductDetailAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
			
		    // 상품 상세 정보를 출력하는 페이지로 URL 경로 지정 
			String url="productList/productDetail.jsp";
		    
			// id를 받아온다.
		    int id = Integer.parseInt(request.getParameter("id"));  
		    
		    ProductDAO productDAO = ProductDAO.getInstance();
		    
		    // 상품 상세 정보 쿼리 실행 후 결과값 배열리스트에 저장  
		    ArrayList<ProductVO> productList = productDAO.detailList(id);
		    
		    // 값을 request에 세팅 
		    request.setAttribute("productList", productList);
		    
		    // jsp 화면으로 값을 전달. 
		    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		    dispatcher.forward(request, response);
	}
}