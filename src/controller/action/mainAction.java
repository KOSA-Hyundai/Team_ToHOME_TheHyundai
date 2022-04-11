package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import vo.CategoryVO;

public class mainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				String url = "/main.jsp";	    
				CategoryDAO categoryDAO = CategoryDAO.getInstance();
			    ArrayList<CategoryVO> categoryList = categoryDAO.listCategory();
			    request.setAttribute("categoryList", categoryList);
			    
			    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			    dispatcher.forward(request, response);
	}

}
