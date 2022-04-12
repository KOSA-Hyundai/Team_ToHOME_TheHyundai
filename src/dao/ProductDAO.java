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
		String sql = "select * from table(product_list_package.fn_main_prod(?))";
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
				product.setProdCategory(rs.getInt("prod_category"));;
				product.setProdName(rs.getString("prod_name"));	
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
	
	// 메인 페이지 상품 검색 기능 
	public ArrayList<ProductVO> searchList(String name){
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		String sql = "SELECT ID, PROD_CATEGORY, PROD_NAME, PROD_DETAIL, PRICE, DISCOUNT, PACKAGE_TYPE, ORIGIN, PROD_IMG FROM TABLE(PRODUCT_LIST_PACKAGE.FN_SEARCH_PROD(?))";
		Connection conn = null;
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			csmt = conn.prepareCall(sql);
			csmt.setString(1, name);
			
			rs = csmt.executeQuery();
			while (rs.next()) {
				ProductVO product = new ProductVO();
				product.setId(rs.getInt("id"));
				product.setProdCategory(rs.getInt("prod_category"));;
				product.setProdName(rs.getString("prod_name"));	
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
}
