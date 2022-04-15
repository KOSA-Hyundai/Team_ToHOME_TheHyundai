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

// 작성자 : 고정민
// 기능 : mypage 페이지로 이동
public class MyPageAction implements Action {
  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	  
	// 세션에서 로그인된 회원 정보를 가져옴
    String url = "member/mypage.jsp"; 
    HttpSession session = request.getSession();
    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
  	CategoryDAO categoryDAO = CategoryDAO.getInstance();
  	
    ArrayList<BigCategoryVO> menuCateogoryList = categoryDAO.getCategoryInfo();

    request.setAttribute("menuCategoryList", menuCateogoryList);
    
    // 세션 로그인된 값이 없다면 로그인을 먼저 하도록 이동
    if (loginUser == null) {
      url = "HyundaiServlet?command=login_form";
    } 
    request.getRequestDispatcher(url).forward(request, response);
  }
}
