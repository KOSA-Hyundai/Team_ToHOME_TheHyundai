package controller.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

// 작성자 : 고정민
// 기능 : 이메일 중복 확인을 하는부분을 처리
public class IdCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/email_check_false.jsp";
		String email = request.getParameter("email").trim();
		
		// 중복 확인할 DAO 객체 선언
		MemberDAO memberDAO = MemberDAO.getInstance();
		// 리턴 값을 message 변수에 저장 ( 1 : 중복 / -1 : 사용 가능)
		int message = memberDAO.confirmID(email);
		
		// 중복이 아닌 경우
		if (message != 1) {
			// 이메일 사용이 가능함 email_check_true.jsp로 넘어가도록 설정
			url = "member/email_check_true.jsp";
		}
		
		request.setAttribute("message", message);
		request.setAttribute("email", email);
		// 중복인 경우 email_check_false.jsp로 넘어가도록 설정
		request.getRequestDispatcher(url).forward(request, response);
	}
}// end class