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

// �ۼ��� : ������ 
// ��� : �α��� ó���ϴ� �κ�
public class LoginAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���� �� �Ѿ jsp
		String url = "member/login_fail.jsp";
		HttpSession session = request.getSession();
		
		// �Է� ���� email �� ��������
		String email = request.getParameter("email");
		String pwd = null;
		
		
	  	CategoryDAO categoryDAO = CategoryDAO.getInstance();
	  	
	    ArrayList<BigCategoryVO> menuCateogoryList = categoryDAO.getCategoryInfo();
	    
	    // �Է¹��� ��й�ȣ�� ��ȣȭ�Ͽ� DB�� ����� ��ȣȭ�� ���� ���ϵ��� ��
		try {
			pwd = new AES128(Secret.USER_INFO_PASSWORD_KEY).encrypt(request.getParameter("pw"));
		} catch (InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | BadPaddingException
				| IllegalBlockSizeException | InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// �α��� ó���� �ٷ� DAO ��ü ����
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		// �Է��� ���� DB���� ��ȸ�Ͽ� memberVO�� ����
		MemberVO memberVO = memberDAO.getMember(email);
		 
		// �Է��� ���� DB�� �����Ѵٸ� 
		if (memberVO != null) {
			// �Է¹��� ��й�ȣ�� DB�� ����� ��й�ȣ�� ������ �α��� ����
			if (memberVO.getPw().equals(pwd)) { 
				// �α��ε� ���� ������ ���� �� ����
				session.removeAttribute("email");
				session.setAttribute("loginUser", memberVO);
				CartDAO cartDAO = CartDAO.getInstance();
				MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
				
				// ������� ��ٱ��� ��� ������ ǥ���ϱ� ���� ��ٱ��� ����� ���ǿ� ����
				ArrayList<CartVO> cartList = cartDAO.listCart(loginUser.getEmail());
				int cartCount = cartList.size();
				session.setAttribute("cartCount", cartCount);
				
				// ������������ �Ѿ�� �α��� ������ 
				url = "HyundaiServlet?command=main";
			}
		}
		
		// �Է¹��� ���� DB�� �������� �ʴ� ��� �α��� ����. login_fail.jsp�� �Ѿ
		request.setAttribute("menuCategoryList", menuCateogoryList);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
