package controller.action;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// ������ : �α׾ƿ��� ó���ϴ� �κ�
public class LogoutAction implements Action {
  @Override
  public void execute(HttpServletRequest request, 
		  HttpServletResponse response)
      throws ServletException, IOException {
    String url="HyundaiServlet?command=main";
    
    // �α׾ƿ��� ȸ���� ���� ���� ��ȿȭ ��Ŵ
    HttpSession session=request.getSession(false);
    if(session!=null){
      session.invalidate();
    }
    
    // �α׾ƿ� �� ���� �������� �̵�
    request.getRequestDispatcher(url).forward(request, response);  
  }
}//end class