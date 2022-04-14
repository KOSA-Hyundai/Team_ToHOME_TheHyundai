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

//@WebServlet("/productList/*")
public class ProductDetailAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
			 
			String url="productList/productDetail.jsp";
		    HttpSession session = request.getSession();
		    
		    int id = Integer.parseInt(request.getParameter("id"));  
		    
		    ProductDAO productDAO = ProductDAO.getInstance();
		    
		    ArrayList<ProductVO> productList = productDAO.detailList(id);
		    
		    System.out.println(productList);
		    
		    request.setAttribute("productList", productList);    
		    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		    dispatcher.forward(request, response);
	}
}