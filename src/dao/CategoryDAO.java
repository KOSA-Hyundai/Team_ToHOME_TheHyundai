package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import utill.DBManager;
import dto.CategoryVO;

public class CategoryDAO {
	private CategoryDAO() {}
	private static CategoryDAO instance = new CategoryDAO();
	public static CategoryDAO getInstance() {
		return instance;
	}
	
	// 카테고리 목록 출력하는 기능 
	public ArrayList<CategoryVO> listCategory(){
		ArrayList<CategoryVO> categoryList = new ArrayList<CategoryVO>();
		String sql = "select * from table(product_list_package.fn_category_prod)";
		Connection conn = null;
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			csmt = conn.prepareCall(sql);
			rs = csmt.executeQuery();
			while (rs.next()) {
				CategoryVO category = new CategoryVO();
			    category.setBigCategory(rs.getString("prod_big_category"));
			    	
			    String[] smallCategory = rs.getString("prod_small_category").split(",");
			    	
			    category.setSmallCategory(smallCategory);
			    	
			    categoryList.add(category);
			}
			} catch (Exception e) {
			      e.printStackTrace();
			  } finally {
			      DBManager.close(conn, csmt, rs);
			    }
			
		return categoryList;
		}

}
