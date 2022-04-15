package controller.action;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.CartDAO;
import dao.CategoryDAO;
import dto.BigCategoryVO;
import dto.CartVO;
import dto.MemberVO;
import dto.ProductInCartVO;
import dto.ProductVO;

// �ۼ��� : ������
// ��� : ������� ��ٱ��� ����� ��ȸ
public class CartListAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "cart/cartList.jsp";
		
		// ���� �����κ��� �α��ε� ������� ������ ������
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		// �α��ε� ����ڰ� ���ٸ� �α����� ���� �ϵ��� ����
		if (loginUser == null) {
			url = "HyundaiServlet?command=login_form";
		}
		else {
			// ��ٱ��� ����� ���� DAO ��ü�� ����
			CartDAO cartDAO = CartDAO.getInstance();
			
			// DAO���� ��ٱ��Ͽ� �߰��� ������ ������
			ArrayList<CartVO> cartList = cartDAO.listCart(loginUser.getEmail());
			
			// ��ٱ��� ������ ��ǰ ������ ���� ���� VO ����Ʈ ��ü ����
			ArrayList<ProductInCartVO> picList = new ArrayList<>();
			
			
		  	CategoryDAO categoryDAO = CategoryDAO.getInstance();
		  	ArrayList<BigCategoryVO> menuCateogoryList = categoryDAO.getCategoryInfo();
			
		  	// ��ٱ��Ͽ� ��� ��ǰ�� ������ ���� ��ü ����
			ProductVO prod = new ProductVO();
			
			// ��ٱ����� �� ������ ���� ����
			int totalPrice = 0;
			
			// ��ٱ��� �����ŭ ��ǰ�� ������ ������ �� ����Ʈ�� ����
			for (CartVO cartVO : cartList) {
				ProductInCartVO pic = new ProductInCartVO ();
				prod = cartDAO.getProductInCart(cartVO.getProd_id());
				pic.setId(prod.getId());
				pic.setProdCategory(prod.getProdCategory());
				pic.setProdName(prod.getProdName());
				pic.setProdDetail(prod.getProdDetail());
				pic.setPrice(prod.getPrice());
				pic.setDiscount(prod.getDiscount());
				pic.setPackageType(prod.getPackageType());
				pic.setOrigin(prod.getOrigin());
				pic.setProdImg(prod.getProdImg());
				pic.setQty(cartVO.getQty());
				picList.add(pic);
			}
			
			// ����� ����Ʈ���� ��ǰ�� ���� ���ذ��� �� ��ǰ ������ ���
			for (ProductInCartVO p : picList) {
				System.out.println(p.getProdName());
				totalPrice += p.getPrice();	
			}
			
			// �� �������� request�� ����
			request.setAttribute("menuCategoryList", menuCateogoryList);
			request.setAttribute("cartList", cartList);
			request.setAttribute("prodInCartList", picList);
			request.setAttribute("totalPrice", totalPrice);
		}
		
		// ��ٱ��� ����� ��ȸ�ϴ� �������� �̵�
		request.getRequestDispatcher(url).forward(request, response);
	}
}// end class