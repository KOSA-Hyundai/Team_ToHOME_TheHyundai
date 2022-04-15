package dao;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Struct;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dto.ProductVO;
import oracle.jdbc.internal.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
import utill.DBManager;

//작성자 : 유지훈
// 기능 : 대분류, 소분류 값에 따른 상품 리스트 조회 기능 
public class ProductListDAO {

	  private ProductListDAO() {  } 

	  // 싱글톤 패턴으로 객체르 관리하였다.
	  private static ProductListDAO instance = new ProductListDAO();

	  public static ProductListDAO getInstance() {
	    return instance;
	  }  

	  // 소분류 아이디로 해당하는 상품 리스트를 조회하는 기능 
	  public ArrayList<ProductVO> listProduct(int smallCategoryId) {	  
		    ArrayList<ProductVO> productList = new ArrayList<>();

		    Connection conn = null;
		    CallableStatement ctmt = null;

		    try {
		      conn = DBManager.getConnection();

		   	  // 패키지의 Table Function을 활용
		      ctmt = conn.prepareCall("{ ? = call PRODUCT_LIST_PACKAGE.FN_GET_PROD(?) }");
		      
		      ctmt.registerOutParameter(1, OracleTypes.ARRAY,"PROD_TABLE");
		      ctmt.setInt(2, smallCategoryId);
		      ctmt.execute();	
		      
		      // Array 객체로 받아서 상품 리스트 값을 넣어주었다.
		      Array ts = ctmt.getArray(1);
		      Object[] objArr = (Object[]) ts.getArray();
		      
		      for(int i=0;i<objArr.length;i++) {
		    	  Object[] attrs = null;
		    	  Struct bean = (Struct) objArr[i];
		          attrs = bean.getAttributes();
   		    	  ProductVO product = new ProductVO();		        	

   		    	  List<Object> arr = Arrays.asList(attrs);
   		    	  System.out.println(arr);
   		    	  product.setId(Integer.parseInt(arr.get(0).toString()));
   		    	  product.setProdCategory(Integer.parseInt(arr.get(1).toString()));
   		    	  product.setProdName(String.valueOf(arr.get(2)));
   		    	  product.setProdDetail(String.valueOf(arr.get(3)));		        
   		    	  product.setPrice(Integer.parseInt(arr.get(4).toString()));
   		    	  product.setDiscount(Integer.parseInt(arr.get(5).toString()));
   		    	  product.setPackageType(String.valueOf(arr.get(6)));
		          product.setOrigin(String.valueOf(arr.get(7)));
		          product.setProdImg(String.valueOf(arr.get(8)));
		          productList.add(product);
  	          }		      
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      DBManager.close(conn, ctmt);
		    }
	        return productList;
	  }    

	  // 대분류 아이디에 해당하는 상품 리스트를 조회하는 기능  
	  public ArrayList<ProductVO> getProductListByBigId (int bigCategoryId){
		    ArrayList<ProductVO> productList = new ArrayList<>();

		    Connection conn = null;
		    CallableStatement ctmt = null;

		    try {
		      conn = DBManager.getConnection();

		   	  // 패키지의 Table Function을 활용
		      ctmt = conn.prepareCall("{ ? = call PRODUCT_LIST_PACKAGE.FN_GET_ALL_PROD(?) }");
		      
		      ctmt.registerOutParameter(1, OracleTypes.ARRAY,"PROD_TABLE");
		      ctmt.setInt(2, bigCategoryId);
		      ctmt.execute();	
		      
		      // Array 객체로 받아서 상품 리스트 값을 넣어주었다.
		      Array ts = ctmt.getArray(1);
		      Object[] objArr = (Object[]) ts.getArray();
		      
		      for(int i=0;i<objArr.length;i++) {
		    	  Object[] attrs = null;
		    	  Struct bean = (Struct) objArr[i];
		          attrs = bean.getAttributes();
 		    	  ProductVO product = new ProductVO();		        	

 		    	  List<Object> arr = Arrays.asList(attrs);
 		    	  System.out.println(arr);
 		    	  product.setId(Integer.parseInt(arr.get(0).toString()));
 		    	  product.setProdCategory(Integer.parseInt(arr.get(1).toString()));
 		    	  product.setProdName(String.valueOf(arr.get(2)));
 		    	  product.setProdDetail(String.valueOf(arr.get(3)));		        
 		    	  product.setPrice(Integer.parseInt(arr.get(4).toString()));
 		    	  product.setDiscount(Integer.parseInt(arr.get(5).toString()));
 		    	  product.setPackageType(String.valueOf(arr.get(6)));
		          product.setOrigin(String.valueOf(arr.get(7)));
		          product.setProdImg(String.valueOf(arr.get(8)));
		          productList.add(product);
	          }
		      		      
		      for(ProductVO p : productList) {
		    	  System.out.println(p.toString());
		      }
		      
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      DBManager.close(conn, ctmt);
		    }
			return productList;
	  }
	  
}
