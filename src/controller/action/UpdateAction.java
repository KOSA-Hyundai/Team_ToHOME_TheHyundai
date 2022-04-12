package controller.action;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.MemberDAO;
import dto.MemberVO;

public class UpdateAction implements Action {
  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	  
    String url = "member/updateMember.jsp";     
    HttpSession session = request.getSession();    
    MemberVO memberVO = new MemberVO();    
    memberVO.setEmail(request.getParameter("email"));
    memberVO.setPw(request.getParameter("pw"));
    memberVO.setPhone_number(request.getParameter("phone_number"));
    memberVO.setAddress(request.getParameter("address"));
 
    
    //memberVO.setAddress(request.getParameter("addr1") + request.getParameter("addr2"));  
    
    session.setAttribute("email", request.getParameter("email"));    
    
    MemberDAO memberDAO = MemberDAO.getInstance();
    memberDAO.updateMember(memberVO);    
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }
}
