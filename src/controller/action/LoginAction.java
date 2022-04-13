package controller.action;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.MemberDAO;
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
			if (memberVO.getPw().equals(pwd)) { // 암호 확인
				session.removeAttribute("email");
				session.setAttribute("loginUser", memberVO);
				url = "HyundaiServlet?command=main"; // 시작 페이지로
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
