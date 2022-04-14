package controller.action;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import dao.ReviewDAO;
import dto.MemberVO;
import dto.ProductVO;
import dto.ReviewDTO;
import utill.DBManager;

public class ReviewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		
		String url="review/listReviews.jsp";
		HttpSession session = request.getSession();
		
	    int prod_id = Integer.parseInt(request.getParameter("prod_id"));  
	    System.out.println(prod_id);
	    
	    ReviewDAO reviewDAO = ReviewDAO.getInstance();
	    
	    ArrayList<ReviewDTO> reviewsList = reviewDAO.listReviews(prod_id); 
	    
	    System.out.println(reviewsList);
	    
	    request.setAttribute("reviewsList", reviewsList);   
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}
}


