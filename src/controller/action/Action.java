package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//작성자 : 유지훈 
//기능 : Command 패턴을 사용하기 위해 Action 인터페이스를 구현하였습니다.  
public interface Action {

	 public void execute(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException;

}
