package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDAO;
import dao.ProductDAO;
import dto.BigCategoryDTO;
import dto.CategoryVO;
import dto.ProductVO;

// �ۼ��� : ������
// ���  : �˻��� ��ǰ ��� ���
public class ProductSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// �˻��� ��ǰ ����ϴ� ȭ�� url ���� 
		String url = "productList/searchList.jsp";
		
		// �˻��� ��ǰ �̸��� request ��ü�κ��� �޾ƿ� 
	    String productName = request.getParameter("productName");
	    
	    // �˻��� ��ǰ�� �ҷ����� ������ �����ϱ� ���� DAO ���� 
	    ProductDAO productDAO = ProductDAO.getInstance();
	    
	    // ��� ī�װ� ��� 
	  	CategoryDAO categoryDAO = CategoryDAO.getInstance();
	    
	  	// ��� ī�װ� ��� 
	    ArrayList<BigCategoryDTO> menuCateogoryList = categoryDAO.getCategoryInfo();
	    
	    // �˻��� ��ǰ�̸��� �Ķ���ͷ� �����Ͽ� �˻� ��� ��ǰ ����Ʈ�� ���� �迭����Ʈ ���� 
	    ArrayList<ProductVO> searchList = productDAO.searchList(productName);	 
	    
	    // ������ �迭 ����Ʈ���� HttpServletrequest�� ���� 
	    request.setAttribute("menuCategoryList", menuCateogoryList);
	    request.setAttribute("searchList", searchList);
	    
	    // ������ url�� �� ����
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
