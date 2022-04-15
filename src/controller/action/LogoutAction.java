package controller.action;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 고정민 : 로그아웃을 처리하는 부분
public class LogoutAction implements Action {
  @Override
  public void execute(HttpServletRequest request, 
		  HttpServletResponse response)
      throws ServletException, IOException {
    String url="HyundaiServlet?command=main";
    
    // 로그아웃할 회원의 세션 값을 무효화 시킴
    HttpSession session=request.getSession(false);
    if(session!=null){
      session.invalidate();
    }
    
    // 로그아웃 후 메인 페이지로 이동
    request.getRequestDispatcher(url).forward(request, response);  
  }
}//end class