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

// �ۼ��� : ������, ������
// ���  : ���� ȭ�� ī�װ�, ��ǰ ����Ʈ ���
public class MainAction implements Action {
  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {    
	  
	  	// ����ȭ������ forward url ����
	  	String url = "/main.jsp"; 
	  	
	  	// ī�װ� ��Ͽ� �ѷ��� ��ǰ �롤�Һз� �׸��� ������ DAO ��ü ����
	  	CategoryDAO categoryDAO = CategoryDAO.getInstance();
	  	
	  	// ����ȭ�� ��ǰ����Ʈ�� �ѷ��� ��ǰ ����� ������ ProductDAO ��ü ����
	  	ProductDAO productDAO = ProductDAO.getInstance();
	  	
	  	// ī�װ� ����Ʈ�� �迭����Ʈ�� ����ش�. 
	    ArrayList<BigCategoryVO> menuCateogoryList = categoryDAO.getCategoryInfo();
	  	
	    // ����ȭ�鿡 Ư�� ��з� ��ǰ�� �迭 ����Ʈ�� ����ش�.
	  	ArrayList<ProductVO> productList = productDAO.productList(2);
	  	ArrayList<ProductVO> productList2 = productDAO.productList(52);
	  	
	  	// ������ �迭 ����Ʈ�� HttpServletrequest�� ����
	    request.setAttribute("menuCategoryList", menuCateogoryList);
	    request.setAttribute("productList", productList);
	    request.setAttribute("productList2", productList2);
	    
	    // ������ url�� response�� ���� 
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
  }
}