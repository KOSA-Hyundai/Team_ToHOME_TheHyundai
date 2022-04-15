package controller.action;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dto.BigCategoryVO;


// 작성자 : 고정민
// 기능 : 로그인 페이지로 이동
public class LoginFormAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {    
    String url = "member/login.jsp";       
  	CategoryDAO categoryDAO = CategoryDAO.getInstance();

  	ArrayList<BigCategoryVO> menuCateogoryList = categoryDAO.getCategoryInfo();

  	request.setAttribute("menuCategoryList", menuCateogoryList);
    RequestDispatcher dispatcher=request.getRequestDispatcher(url);
    dispatcher.forward(request, response);    
  }
}//end class