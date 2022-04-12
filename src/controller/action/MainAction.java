package controller.action;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.ProductDAO;
import dto.CategoryVO;
import dto.ProductVO;

public class MainAction implements Action {
  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {    
	  
	  	String url = "/main.jsp";	 
	  	CategoryDAO categoryDAO = CategoryDAO.getInstance();
	  	ProductDAO productDAO = ProductDAO.getInstance();
	  	
	  	ArrayList<CategoryVO> cateogoryList = categoryDAO.listCategory();
	  	ArrayList<ProductVO> productList = productDAO.productList(2);
	  	
	    request.setAttribute("categoryList", cateogoryList);
	    request.setAttribute("productList", productList);
	    
	    System.out.println(productList);
	  	
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
  }
}//end class