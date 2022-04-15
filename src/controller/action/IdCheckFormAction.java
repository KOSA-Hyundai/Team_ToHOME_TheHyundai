package controller.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

// �ۼ��� : ������
// ��� : �̸��� �ߺ� Ȯ���� �ϴºκ��� ó��
public class IdCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/email_check_false.jsp";
		String email = request.getParameter("email").trim();
		
		// �ߺ� Ȯ���� DAO ��ü ����
		MemberDAO memberDAO = MemberDAO.getInstance();
		// ���� ���� message ������ ���� ( 1 : �ߺ� / -1 : ��� ����)
		int message = memberDAO.confirmID(email);
		
		// �ߺ��� �ƴ� ���
		if (message != 1) {
			// �̸��� ����� ������ email_check_true.jsp�� �Ѿ���� ����
			url = "member/email_check_true.jsp";
		}
		
		request.setAttribute("message", message);
		request.setAttribute("email", email);
		// �ߺ��� ��� email_check_false.jsp�� �Ѿ���� ����
		request.getRequestDispatcher(url).forward(request, response);
	}
}// end class