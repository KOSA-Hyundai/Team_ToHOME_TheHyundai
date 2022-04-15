package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;

//작성자 : 유지훈 
//기능 : HyundaiServlet요청시 command값에 따라 객체를 생성하여 전달해준다. 
@WebServlet("/HyundaiServlet")
public class HyundaiServlet extends HttpServlet{

	  private static final long serialVersionUID = 1L;

	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String command = request.getParameter("command");
	    System.out.println("HyundaiServlet : " + command);

	    // 싱글톤으로 관리하는 ActionFactory로 인스턴스를 가져온다. 
	    ActionFactory af = ActionFactory.getInstance();
	    
	    // command값에 따라 맞는 객체를 생성해준다. 
	    Action action = af.getAction(command);

	    if (action != null) {
	      action.execute(request, response);
	    }
	  }

	  protected void doPost(HttpServletRequest request,
	      HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    doGet(request, response);
	  }
	
}
