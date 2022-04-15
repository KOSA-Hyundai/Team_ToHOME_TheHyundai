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
// 기능 : 회원가입 > H.Point 통합회원과 일반회원가입을 나뉜 페이지로 넘어감
public class JoinStep1Action implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {    
    String url = "/member/joinStep1.jsp";  

    CategoryDAO categoryDAO = CategoryDAO.getInstance();
    ArrayList<BigCategoryVO> menuCateogoryList = categoryDAO.getCategoryInfo();

    request.setAttribute("menuCategoryList", menuCateogoryList);
    RequestDispatcher dispatcher=request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }
}