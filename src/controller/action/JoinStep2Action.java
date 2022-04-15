package controller.action;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// �ۼ��� : ������ 
// ��� : (H.Pointȸ�����԰� �Ϲ� ȸ������ �� �Ϲ� ȸ������)���� �Ѿ
public class JoinStep2Action implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {    
    String url = "/member/joinStep2.jsp";  
    
    RequestDispatcher dispatcher=request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }
}