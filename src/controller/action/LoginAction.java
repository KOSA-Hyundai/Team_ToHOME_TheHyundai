package controller.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.MemberDAO;
import dto.MemberVO;

public class LoginAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "member/login_fail.jsp";
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberVO memberVO = memberDAO.getMember(email);

		if (memberVO != null) {
			if (memberVO.getPw().equals(pw)) { // 암호 확인
				session.removeAttribute("email");
				session.setAttribute("loginUser", memberVO);
				url = "HyundaiServlet?command=main"; // 시작 페이지로
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
