package controller.action;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.MemberDAO;
import dto.MemberVO;
import utill.AES128;
import utill.Secret;

public class UpdateAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "member/mypage.jsp";
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");

		String pwd = null;

		memberVO.setEmail(request.getParameter("email"));
		memberVO.setPhone_number(request.getParameter("phone_number"));
		memberVO.setAddress(request.getParameter("address"));
		if (request.getParameter("pw") != "") {
			try {
				pwd = new AES128(Secret.USER_INFO_PASSWORD_KEY).encrypt(request.getParameter("pw"));
			} catch (InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | BadPaddingException
					| IllegalBlockSizeException | InvalidAlgorithmParameterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			memberVO.setPw(pwd);
			session.setAttribute("loginUser", memberVO);
		}
		
		// memberVO.setAddress(request.getParameter("addr1") +
		// request.getParameter("addr2"));
		
		session.setAttribute("email", request.getParameter("email"));

		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.updateMember(memberVO);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
