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
import dto.BigCategoryDTO;
import dto.MemberVO;
import utill.AES128;
import utill.Secret;

public class LoginAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "member/login_fail.jsp";
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String pwd = null;
	  	CategoryDAO categoryDAO = CategoryDAO.getInstance();
	    ArrayList<BigCategoryDTO> menuCateogoryList = categoryDAO.getCategoryInfo();
		try {
			pwd = new AES128(Secret.USER_INFO_PASSWORD_KEY).encrypt(request.getParameter("pw"));
		} catch (InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | BadPaddingException
				| IllegalBlockSizeException | InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberVO memberVO = memberDAO.getMember(email);
		
		if (memberVO != null) {
			if (memberVO.getPw().equals(pwd)) { // ��ȣ Ȯ��
				session.removeAttribute("email");
				session.setAttribute("loginUser", memberVO);
				CartDAO cartDAO = CartDAO.getInstance();
				MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
				ArrayList<CartVO> cartList = cartDAO.listCart(loginUser.getEmail());
				int cartCount = cartList.size();
				session.setAttribute("cartCount", cartCount);
				url = "HyundaiServlet?command=main"; // ���� ��������
			}
		}
		request.setAttribute("menuCategoryList", menuCateogoryList);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
