package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.ProductVO;
import utill.DBManager;

// 작성자 : 정예성
public class ProductDAO {
	// Singletone 방식 적용 
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
	
	// 할인중인 상품 목록 출력 기능
	public ArrayList<ProductVO> saleList(){
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		
		// 할인 중인 상품 테이블을 출력하는 PL/SQL Function (Tablefunction 사용)  
		String sql = "SELECT * FROM TABLE(PRODUCT_LIST_PACKAGE.FN_SALE_PROD)";
		Connection conn = null;
		
		// 패키지 함수를 사용하므로 CallableStatement로 선언 
		CallableStatement csmt = null;
		
		// 실행 결과를 담을 ResultSet 선언
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			csmt = conn.prepareCall(sql);
			
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
	
	public ArrayList<ProductVO> detailList(int id){
	      ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
	      String sql = "SELECT * FROM TABLE(PRODUCT_LIST_PACKAGE.FN_DETAIL_PROD(?))";
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
}
