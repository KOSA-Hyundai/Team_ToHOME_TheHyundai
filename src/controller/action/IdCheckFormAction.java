package controller.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

public class IdCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/email_check_false.jsp";
		String email = request.getParameter("email").trim();
		MemberDAO memberDAO = MemberDAO.getInstance();
		int message = memberDAO.confirmID(email);
		if (message != 1) { // ม฿บน พฦดิ
			url = "member/email_check_true.jsp";
		}
		request.setAttribute("message", message);
		request.setAttribute("email", email);
		request.getRequestDispatcher(url).forward(request, response);
	}
}// end class