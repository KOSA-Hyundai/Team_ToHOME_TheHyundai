package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductVO;

// �ۼ��� : ������
// ���  : ���� ���� ��ǰ ��� ���
public class ProductSaleAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// �������� ��ǰ�� ����ϴ� ȭ�� ��� url ����
		String url = "productList/saleList.jsp";
		
		// ��ǰ ����� �ҷ��� ��ü ���� 
	    ProductDAO productDAO = ProductDAO.getInstance();
	    
	    // �������� ��ǰ ����� �迭����Ʈ�� ��´�.
	    ArrayList<ProductVO> productList = productDAO.saleList();	    
	    
	    // �������� ��ǰ ����� HttpServletrequest�� ����
	    request.setAttribute("productList", productList);
	    
	    // ������ url�� �������� ��ǰ ��� response
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
