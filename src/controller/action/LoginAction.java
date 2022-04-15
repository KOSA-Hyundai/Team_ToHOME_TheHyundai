package controller.action;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;

import dao.CategoryDAO;
import dao.MemberDAO;
import dto.CartVO;
import dto.BigCategoryVO;
import dto.MemberVO;
import utill.AES128;
import utill.Secret;

// 작성자 : 고정민 
// 기능 : 로그인 처리하는 부분
public class LoginAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실패 시 넘어갈 jsp
		String url = "member/login_fail.jsp";
		HttpSession session = request.getSession();
		
		// 입력 받은 email 값 가져오기
		String email = request.getParameter("email");
		String pwd = null;
		
		
	  	CategoryDAO categoryDAO = CategoryDAO.getInstance();
	  	
	    ArrayList<BigCategoryVO> menuCateogoryList = categoryDAO.getCategoryInfo();
	    
	    // 입력받은 비밀번호를 암호화하여 DB에 저장된 암호화된 값과 비교하도록 함
		try {
			pwd = new AES128(Secret.USER_INFO_PASSWORD_KEY).encrypt(request.getParameter("pw"));
		} catch (InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | BadPaddingException
				| IllegalBlockSizeException | InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 로그인 처리를 다룰 DAO 객체 선언
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		// 입력한 값을 DB에서 조회하여 memberVO에 저장
		MemberVO memberVO = memberDAO.getMember(email);
		 
		// 입력한 값이 DB에 존재한다면 
		if (memberVO != null) {
			// 입력받은 비밀번호와 DB에 저장된 비밀번호가 같으면 로그인 성공
			if (memberVO.getPw().equals(pwd)) { 
				// 로그인된 유저 정보로 세션 값 설정
				session.removeAttribute("email");
				session.setAttribute("loginUser", memberVO);
				CartDAO cartDAO = CartDAO.getInstance();
				MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
				
				// 헤더에서 장바구니 목록 개수를 표현하기 위해 장바구니 사이즈도 세션에 설정
				ArrayList<CartVO> cartList = cartDAO.listCart(loginUser.getEmail());
				int cartCount = cartList.size();
				session.setAttribute("cartCount", cartCount);
				
				// 메인페이지로 넘어가며 로그인 마무리 
				url = "HyundaiServlet?command=main";
			}
		}
		
		// 입력받은 값이 DB에 존재하지 않는 경우 로그인 실패. login_fail.jsp로 넘어감
		request.setAttribute("menuCategoryList", menuCateogoryList);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
