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
import dto.BigCategoryVO;
import dto.CategoryVO;
import dto.ProductVO;
import dto.SmallCategoryVO;

//작성자 : 유지훈 
//기능 : 상품 리스트 페이지로 이동  
public class ProductListAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	    HttpSession session = request.getSession();	    
	    String url = "productList/productList.jsp";
	    
	    // 대분류의 아이디값을 가져온다.
	    int bigCategoryId = Integer.parseInt(request.getParameter("bigCtryId"));

	    // 소분류의 아이디값을 가져온다. 그리고 NULL값이거나 빈문자열의 경우 임의로 -1 값을 넣어서 분기 처리를 하도록 하였다.
	    int smallCategoryId = request.getParameter("smallCtryId") != null && !request.getParameter("smallCtryId").equals("") ? Integer.parseInt(request.getParameter("smallCtryId")) : -1;

	    // 필터링 기능중 정렬방식에 대한 값을 String으로 받아온다.
	    String sortType = request.getParameter("sortType");

	    BigCategoryVO bigCategory = null;
	    SmallCategoryVO smallCategory = null;
	    ProductListDAO productListDAO = ProductListDAO.getInstance();
	    CategoryDAO categoryDAO = CategoryDAO.getInstance();
	    
	    // 소분류에 해당하는 ID값을 파라미터로 넘겨서 해당하는 상품 리스트를 가져온다.
	    ArrayList<ProductVO> productList = productListDAO.listProduct(smallCategoryId);	    	  	

	    // 각 카테고리에 있는 대분류, 소분류에 대한 정보를 가져온다.
	    ArrayList<BigCategoryVO> cateogoryList = categoryDAO.getCategoryInfo();

	    // 소분류없이 대분류 아이다만 왔을경우 대분류 ID에 해당하는 상품 리스트를 가져온다.
	    if(smallCategoryId == -1) {
	    	productList = productListDAO.getProductListByBigId(bigCategoryId);	    	
	    	for(BigCategoryVO bc : cateogoryList) {
	    		if(bc.getId() == bigCategoryId) {
	    			bigCategory = bc;
	    			break;
	    		}
	    	}		    		    	
	    }else { // 소분류 ID까지 있는 경우 대분류의 소분류에 해당하는 상품 리스트를 가져오도록 한다.   
	    	for(BigCategoryVO bc : cateogoryList) {
	    		for(SmallCategoryVO sc : bc.getSmallCategoryList()) {
	    			if(sc.getId() == smallCategoryId) {
	    				bigCategory = bc;
	    				smallCategory = sc;
	    				break;
	    			}
	    		}
	    	}		    	
	    }
	    
	    // 정렬 값이 있는 경우 가격이 낮은 순, 높은 순으로 정렬할 수 있도록 하였다. sortType이 없는 경우는 초기에 조회했던 상품리스트가 반환된다.
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
	  	
	  	// request에 속성값을 통해 값을 넘겨준다. 
	    request.setAttribute("categoryList", cateogoryList);
	    request.setAttribute("bigCategory", bigCategory);
	    request.setAttribute("smallCategory", smallCategory);	    
	    request.setAttribute("productList", productList);
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
