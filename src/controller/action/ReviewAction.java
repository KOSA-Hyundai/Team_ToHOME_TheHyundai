package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDAO;
import dto.ReviewVO;

// 작성자 : 김연식
// 기능  : 리뷰 목록 조회
public class ReviewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		
		String url="review/listReviews.jsp";
		
	    int prod_id = Integer.parseInt(request.getParameter("prod_id"));  
	    
	    ReviewDAO reviewDAO = ReviewDAO.getInstance();
	    
	    ArrayList<ReviewVO> reviewsList = reviewDAO.listReviews(prod_id); 
	    
	    request.setAttribute("reviewsList", reviewsList);   
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}
}


