package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.ProductVO;
import utill.DBManager;


public class ProductDAO {
	private ProductDAO() {}
	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	
	// 메인 페이지 상품 리스트 출력하는 기능
	public ArrayList<ProductVO> productList(int id){
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		String sql = "select * from table(product_list_package.fn_get_prod(?))";
		Connection conn = null;
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			csmt = conn.prepareCall(sql);
			csmt.setInt(1, id);
			
			rs = csmt.executeQuery();
			while (rs.next()) {
				ProductVO product = new ProductVO();
				product.setId(rs.getInt("id"));
				product.setProdName(rs.getString("prod_name"));
				product.setProdCategory(rs.getInt("prod_category"));
				product.setProdDetail(rs.getString("prod_detail"));
				product.setPrice(rs.getInt("price"));
				product.setDiscount(rs.getInt("discount"));
				product.setPackageType(rs.getString("package_type"));
				product.setOrigin(rs.getString("origin"));
				product.setProdImg(rs.getString("prod_img"));
				
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, csmt, rs);
		}
		
		return productList;		
	}
	
//	// 메인 페이지 상품 검색 기능 
//	public ArrayList<ProductVO> productList(String name){
//		
//		
//		//return productList;
//	}
	
}
