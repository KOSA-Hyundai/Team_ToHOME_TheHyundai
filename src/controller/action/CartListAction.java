package controller.action;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.CartDAO;
import dto.CartVO;
import dto.MemberVO;
import dto.ProductInCartVO;
import dto.ProductVO;

public class CartListAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "cart/cartList.jsp";

		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if (loginUser == null) {
			url = "HyundaiServlet?command=login_form";
		} else {
			CartDAO cartDAO = CartDAO.getInstance();
			ArrayList<CartVO> cartList = cartDAO.listCart(loginUser.getEmail());
			ArrayList<ProductInCartVO> picList = new ArrayList<>();
			
			ProductVO prod = new ProductVO();
			int totalPrice = 0;
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
			for (ProductInCartVO p : picList) {
				System.out.println(p.getProdName());
				totalPrice += p.getPrice();	
			}
			request.setAttribute("cartList", cartList);
			request.setAttribute("prodInCartList", picList);
			request.setAttribute("totalPrice", totalPrice);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}// end class