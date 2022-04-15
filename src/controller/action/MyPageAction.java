package controller.action;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDAO;
import dto.BigCategoryVO;
import dto.MemberVO;

// �ۼ��� : ������
// ��� : mypage �������� �̵�
public class MyPageAction implements Action {
  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	  
	// ���ǿ��� �α��ε� ȸ�� ������ ������
    String url = "member/mypage.jsp"; 
    HttpSession session = request.getSession();
    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
  	CategoryDAO categoryDAO = CategoryDAO.getInstance();
  	
    ArrayList<BigCategoryVO> menuCateogoryList = categoryDAO.getCategoryInfo();

    request.setAttribute("menuCategoryList", menuCateogoryList);
    
    // ���� �α��ε� ���� ���ٸ� �α����� ���� �ϵ��� �̵�
    if (loginUser == null) {
      url = "HyundaiServlet?command=login_form";
    } 
    request.getRequestDispatcher(url).forward(request, response);
  }
}
