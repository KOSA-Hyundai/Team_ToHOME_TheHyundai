package controller.action;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dto.BigCategoryVO;

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