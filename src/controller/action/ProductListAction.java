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

//�ۼ��� : ������ 
//��� : ��ǰ ����Ʈ �������� �̵�  
public class ProductListAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	    HttpSession session = request.getSession();	    
	    String url = "productList/productList.jsp";
	    
	    // ��з��� ���̵��� �����´�.
	    int bigCategoryId = Integer.parseInt(request.getParameter("bigCtryId"));

	    // �Һз��� ���̵��� �����´�. �׸��� NULL���̰ų� ���ڿ��� ��� ���Ƿ� -1 ���� �־ �б� ó���� �ϵ��� �Ͽ���.
	    int smallCategoryId = request.getParameter("smallCtryId") != null && !request.getParameter("smallCtryId").equals("") ? Integer.parseInt(request.getParameter("smallCtryId")) : -1;

	    // ���͸� ����� ���Ĺ�Ŀ� ���� ���� String���� �޾ƿ´�.
	    String sortType = request.getParameter("sortType");

	    BigCategoryVO bigCategory = null;
	    SmallCategoryVO smallCategory = null;
	    ProductListDAO productListDAO = ProductListDAO.getInstance();
	    CategoryDAO categoryDAO = CategoryDAO.getInstance();
	    
	    // �Һз��� �ش��ϴ� ID���� �Ķ���ͷ� �Ѱܼ� �ش��ϴ� ��ǰ ����Ʈ�� �����´�.
	    ArrayList<ProductVO> productList = productListDAO.listProduct(smallCategoryId);	    	  	

	    // �� ī�װ��� �ִ� ��з�, �Һз��� ���� ������ �����´�.
	    ArrayList<BigCategoryVO> cateogoryList = categoryDAO.getCategoryInfo();

	    // �Һз����� ��з� ���̴ٸ� ������� ��з� ID�� �ش��ϴ� ��ǰ ����Ʈ�� �����´�.
	    if(smallCategoryId == -1) {
	    	productList = productListDAO.getProductListByBigId(bigCategoryId);	    	
	    	for(BigCategoryVO bc : cateogoryList) {
	    		if(bc.getId() == bigCategoryId) {
	    			bigCategory = bc;
	    			break;
	    		}
	    	}		    		    	
	    }else { // �Һз� ID���� �ִ� ��� ��з��� �Һз��� �ش��ϴ� ��ǰ ����Ʈ�� ���������� �Ѵ�.   
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
	    
	    // ���� ���� �ִ� ��� ������ ���� ��, ���� ������ ������ �� �ֵ��� �Ͽ���. sortType�� ���� ���� �ʱ⿡ ��ȸ�ߴ� ��ǰ����Ʈ�� ��ȯ�ȴ�.
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
	  	
	  	// request�� �Ӽ����� ���� ���� �Ѱ��ش�. 
	    request.setAttribute("categoryList", cateogoryList);
	    request.setAttribute("bigCategory", bigCategory);
	    request.setAttribute("smallCategory", smallCategory);	    
	    request.setAttribute("productList", productList);
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
