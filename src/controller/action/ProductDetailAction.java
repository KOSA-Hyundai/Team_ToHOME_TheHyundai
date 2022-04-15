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

// �ۼ��� : �迬��, ������
// ���  : ������ ��ǰ�� �� ���� ��� 
public class ProductDetailAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
			
		    // ��ǰ �� ������ ����ϴ� �������� URL ��� ���� 
			String url="productList/productDetail.jsp";
		    
			// id�� �޾ƿ´�.
		    int id = Integer.parseInt(request.getParameter("id"));  
		    
		    ProductDAO productDAO = ProductDAO.getInstance();
		    
		    // ��ǰ �� ���� ���� ���� �� ����� �迭����Ʈ�� ����  
		    ArrayList<ProductVO> productList = productDAO.detailList(id);
		    
		    // ���� request�� ���� 
		    request.setAttribute("productList", productList);
		    
		    // jsp ȭ������ ���� ����. 
		    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		    dispatcher.forward(request, response);
	}
}