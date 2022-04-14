package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDAO;
import dao.ProductDAO;
import dto.BigCategoryVO;
import dto.CategoryVO;
import dto.ProductVO;

public class ProductSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String url = "productList/searchList.jsp";
	    String productName = request.getParameter("productName");
	    
	    ProductDAO productDAO = ProductDAO.getInstance();
	  	CategoryDAO categoryDAO = CategoryDAO.getInstance();
	    
	    ArrayList<BigCategoryVO> menuCateogoryList = categoryDAO.getCategoryInfo();
	    ArrayList<ProductVO> searchList = productDAO.searchList(productName);	 
	    
	    System.out.println(menuCateogoryList);
	    System.out.println(searchList);
	    
	    request.setAttribute("menuCategoryList", menuCateogoryList);
	    request.setAttribute("searchList", searchList);
	    
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
