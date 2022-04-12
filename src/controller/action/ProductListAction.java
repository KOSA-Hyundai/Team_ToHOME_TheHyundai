package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductListDAO;
import dto.ProductVO;

public class ProductListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	    HttpSession session = request.getSession();
	    
	    System.out.println("여기까지 성공 ");
//	    String url = "mypage/orderList.jsp";    
//	    HttpSession session = request.getSession();
//	    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");    
//	    
//	    if (loginUser == null) {
//	      url = "NonageServlet?command=login_form";
//	    } 
//	    else {
//	      OrderDAO orderDAO = OrderDAO.getInstance();
//	      int oseq=Integer.parseInt(request.getParameter("oseq"));
//	      ArrayList<OrderVO> orderList = 
//	    		  orderDAO.listOrderById(loginUser.getId(), "1", oseq);
//	      int totalPrice=0;
//	      for(OrderVO orderVO :orderList){
//	        totalPrice+=orderVO.getPrice2()*orderVO.getQuantity();
//	      }      
//	      request.setAttribute("orderList", orderList);
//	      request.setAttribute("totalPrice", totalPrice);
//	    }
//	    request.getRequestDispatcher(url).forward(request, response);

	    
	    String url = "productList/productList.jsp";
	    int categoryId = Integer.parseInt(request.getParameter("category_id"));
	    ProductListDAO productListDAO = ProductListDAO.getInstance();
	    ArrayList<ProductVO> productList = productListDAO.listProduct(categoryId);	    
	    
	    request.setAttribute("productList", productList);
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
