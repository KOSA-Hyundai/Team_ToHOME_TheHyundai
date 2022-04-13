package controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDAO;
import dao.ProductDAO;
import dao.ProductListDAO;
import dto.BigCategoryDTO;
import dto.CategoryVO;
import dto.ProductVO;
import dto.SmallCategoryDTO;

public class ProductListAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	    HttpSession session = request.getSession();	    
	    String url = "productList/productList.jsp";
	    int bigCategoryId = Integer.parseInt(request.getParameter("bigCtryId"));
	    int smallCategoryId = request.getParameter("smallCtryId") != null ? Integer.parseInt(request.getParameter("smallCtryId")) : -1;
	    String sortType = request.getParameter("sortType");

	    BigCategoryDTO bigCategory = null;
	    SmallCategoryDTO smallCategory = null;
	    ProductListDAO productListDAO = ProductListDAO.getInstance();
	    CategoryDAO categoryDAO = CategoryDAO.getInstance();
	    ArrayList<ProductVO> productList = productListDAO.listProduct(smallCategoryId);	    	  	
	    ArrayList<BigCategoryDTO> cateogoryList = categoryDAO.getCategoryInfo();
	    for(BigCategoryDTO bc : cateogoryList) {
	    	for(SmallCategoryDTO sc : bc.getSmallCategoryList()) {
	    		if(sc.getId() == smallCategoryId) {
	    			bigCategory = bc;
	    			smallCategory = sc;
	    			break;
	    		}
	    	}
	    }	
	    	    
	  	switch (sortType) {
		case "lowPrice":
			productList = (ArrayList<ProductVO>) productList.stream()
							.sorted((p1, p2) ->
								p1.getPrice() * (1 - (p1.getDiscount() / 100)) - p2.getPrice() * (1 - (p2.getDiscount() / 100)))
							.collect(Collectors.toList());												
			
			break;
		case "highPrice":
			productList = (ArrayList<ProductVO>) productList.stream()
							.sorted((p1, p2) ->
								p2.getPrice() * (1 - (p2.getDiscount() / 100)) - p1.getPrice() * (1 - (p1.getDiscount() / 100)))
							.collect(Collectors.toList());														
			break;
		default:
			break;
		}	  	
	  	
	    request.setAttribute("categoryList", cateogoryList);
	    request.setAttribute("bigCategory", bigCategory);
	    request.setAttribute("smallCategory", smallCategory);	    
	    request.setAttribute("productList", productList);
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
