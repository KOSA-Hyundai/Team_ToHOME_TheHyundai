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

// 작성자 : 고정민
// 기능 : 사용자의 장바구니 목록을 조회
public class CartListAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "cart/cartList.jsp";
		
		// 세션 값으로부터 로그인된 사용자의 정보를 가져옴
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		// 로그인된 사용자가 없다면 로그인을 먼저 하도록 설정
		if (loginUser == null) {
			url = "HyundaiServlet?command=login_form";
		}
		else {
			// 장바구니 목록을 담을 DAO 객체를 선언
			CartDAO cartDAO = CartDAO.getInstance();
			
			// DAO에서 장바구니에 추가한 정보를 가져옴
			ArrayList<CartVO> cartList = cartDAO.listCart(loginUser.getEmail());
			
			// 장바구니 정보와 상품 정보를 같이 담을 VO 리스트 객체 선언
			ArrayList<ProductInCartVO> picList = new ArrayList<>();
			
			
		  	CategoryDAO categoryDAO = CategoryDAO.getInstance();
		  	ArrayList<BigCategoryVO> menuCateogoryList = categoryDAO.getCategoryInfo();
			
		  	// 장바구니에 담긴 상품의 정보를 담을 객체 선언
			ProductVO prod = new ProductVO();
			
			// 장바구니의 총 가격을 담을 변수
			int totalPrice = 0;
			
			// 장바구니 사이즈만큼 상품의 정보를 가져온 후 리스트에 저장
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
			
			// 저장된 리스트에서 상품의 값을 더해가며 총 상품 가격을 계산
			for (ProductInCartVO p : picList) {
				System.out.println(p.getProdName());
				totalPrice += p.getPrice();	
			}
			
			// 각 정보들을 request에 설정
			request.setAttribute("menuCategoryList", menuCateogoryList);
			request.setAttribute("cartList", cartList);
			request.setAttribute("prodInCartList", picList);
			request.setAttribute("totalPrice", totalPrice);
		}
		
		// 장바구니 목록을 조회하는 페이지로 이동
		request.getRequestDispatcher(url).forward(request, response);
	}
}// end class