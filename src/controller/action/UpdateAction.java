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

// 작성자 : 고정민
// 기능 : 회원 정보 변경 로직을 처리
public class UpdateAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "member/mypage.jsp";
		
		// 세션 값으로부터 로그인된 사용자의 정보를 받아옴
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");

		String pwd = null;
		
		// 입력받은 값을 memberVO에 저장
		memberVO.setEmail(request.getParameter("email"));
		memberVO.setPhone_number(request.getParameter("phone_number"));
		memberVO.setAddress(request.getParameter("address"));
		
		// 새롭게 변경할 비밀번호를 입력했다면 비밀번호를 AES128로 암호화하여 pwd에 설정하고 세션 값을 변경함
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
		
		session.setAttribute("email", request.getParameter("email"));
		
		// 회원 정보를 수정할 memberDAO 객체를 선언
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		// DAO에서 회원정보변경하는 로직을 처리
		memberDAO.updateMember(memberVO);
		
		// 회원 정보 변경이 완료되면 mypage.jsp로 넘어가도록 설정
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
