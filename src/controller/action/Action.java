package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�ۼ��� : ������ 
//��� : Command ������ ����ϱ� ���� Action �������̽��� �����Ͽ����ϴ�.  
public interface Action {

	 public void execute(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException;

}
