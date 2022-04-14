package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import dto.ReviewDTO;
import utill.DBManager;

public class ReviewDAO {
	public ReviewDAO() {
	}

	private static ReviewDAO reviewDAO = new ReviewDAO();

	public static ReviewDAO getInstance() {
		return reviewDAO;
	}

	/*
	 * public void addReview(ReviewDTO review) { reviewDAO.insertReview(review); }
	 * 
	 * public ReviewDTO viewReview(int id) { ReviewDTO review = null; review =
	 * reviewDAO.selectReview(id); return review; }
	 */

	public ArrayList<ReviewDTO> listReviews(int prod_id) {
		ArrayList<ReviewDTO> reviewsList = new ArrayList<ReviewDTO>();
		String sql = "select * from review r join member m on r.user_id = m.id where r.prod_id = ?";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prod_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReviewDTO review = new ReviewDTO();
				review.setId(rs.getInt("id"));
				review.setUser_id(rs.getInt("user_id"));
				review.setProd_id(rs.getInt("prod_id"));
				review.setContents(rs.getString("contents"));
				review.setScore(rs.getString("score"));
				review.setCreate_date(rs.getTimestamp("create_date"));
				review.setName(rs.getString("name"));
				reviewsList.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return reviewsList;
	}

	
	  public void insertReview(ReviewDTO review) { //DTO 전달받아 입력 프로시저 실행, DTO 전달 후 소멸 
		  String sql = "insert into review(user_id, prod_id, name, contents, score) values(?, ?, ?, ?, ?)";
		  Connection conn = null; 
		  ResultSet rs = null; 
		  PreparedStatement pstmt = null;
 
		  try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareCall(sql);
				pstmt.setInt(1, review.getUser_id());
				pstmt.setInt(2, review.getProd_id());
				pstmt.setString(3, review.getName());
				pstmt.setString(4, review.getContents()); 
				pstmt.setString(5,review.getScore()); 
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
	  } 

//	  public void updateReview(ReviewDTO reviewDTO) { //DTO 전달받아 입력 프로시저 실행, DTO
//	  전달 후 소멸 String sql; try { sql =
//	  "{call review_package.review_update(?,?,?,?)}"; cstmt = con.prepareCall(sql);
//	  cstmt.setInt(1, reviewDTO.getId()); cstmt.setString(2,
//	  reviewDTO.getContents()); cstmt.setString(3, reviewDTO.getScore());
//	  cstmt.setTimestamp(4, reviewDTO.getCreate_date()); cstmt.executeUpdate();
//	  
//	  cstmt.close(); } catch(SQLException e) { e.printStackTrace(); } } public void
//	  deleteReview(int id) { //DTO 전달받아 입력 프로시저 실행, DTO 전달 후 소멸 ReviewDTO reviewDTO
//	  = null; String sql; try { sql = "{call review_package.review_delete(?)}";
//	  cstmt = con.prepareCall(sql); cstmt.setInt(1, reviewDTO.getId());
//	  cstmt.executeUpdate();
//	  
//	  cstmt.close(); } catch(SQLException e) { e.printStackTrace(); } }
	  
//	  ReviewDTO selectReview(int id){ ReviewDTO reviewDTO = new ReviewDTO(); try{
//	  con = DBManager.getConnection(); String query
//	  ="select id,user_id,prod_id,contents,  score, create_date" +" from review"
//	  +" where id=?"; System.out.println(query); pstmt =
//	  con.prepareStatement(query); pstmt.setInt(1, id); ResultSet rs
//	  =pstmt.executeQuery(); rs.next(); int _id =rs.getInt("id"); int
//	  user_id=rs.getInt("user_id"); int prod_id=rs.getInt("prod_id"); String
//	  contents =rs.getString("contents"); String score = rs.getString("score");
//	  Timestamp create_date = rs.getTimestamp("create_date");
//	  
//	  review.setId(_id); review.setUser_id (user_id); review.setProd_id(prod_id);
//	  review.setContents(contents); review.setScore(score);
//	  review.setCreate_date(create_date); rs.close(); pstmt.close(); con.close();
//	  }catch(Exception e){ e.printStackTrace(); } return review; }
//	  
//	  public List getReviews(int prod_id) { List reviewsList = new ArrayList();
//	  String sql = "select * from table(review_package.fn_print_review_pipe(?))";
//	  Connection con = null; CallableStatement cstmt = null; try { con =
//	  DBManager.getConnection(); cstmt = con.prepareCall(sql); cstmt.setInt(1,
//	  prod_id); ResultSet rs = cstmt.executeQuery(); if (rs.next()) { ReviewDTO
//	  review = new ReviewDTO(); review.setId(rs.getInt("id"));
//	  review.setUser_id(rs.getInt("user_id"));
//	  review.setProd_id(rs.getInt("prod_id"));
//	  review.setContents(rs.getString("contents"));
//	  review.setScore(rs.getString("score"));
//	  review.setCreate_date(rs.getTimestamp("create_date"));
//	  reviewsList.add(review); } rs.close(); cstmt.close(); con.close(); } catch
//	  (Exception e) { e.printStackTrace(); } finally { DBManager.close(con, cstmt,
//	  rs); } return reviewsList;
//	  
//	  }
	 
}