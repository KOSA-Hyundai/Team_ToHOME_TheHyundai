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

public class ProductListDAO {

	  private ProductListDAO() {  } 

	  private static ProductListDAO instance = new ProductListDAO();

	  public static ProductListDAO getInstance() {
	    return instance;
	  }  

	  @SuppressWarnings("deprecation")
	public ArrayList<ProductVO> listProduct(int categoryNumber) {	  
		    ArrayList<ProductVO> productList = new ArrayList<>();

		    Connection conn = null;
		    CallableStatement ctmt = null;
		    ResultSet rs = null;    

		    try {
		      conn = DBManager.getConnection();
		      ctmt = conn.prepareCall("{ ? = call PRODUCT_LIST_PACKAGE.FN_GET_PROD(?) }");
		      
		      ctmt.registerOutParameter(1, OracleTypes.ARRAY,"PROD_TABLE");
		      ctmt.setInt(2, categoryNumber);
		      ctmt.execute();	
		      
		      Array ts = ctmt.getArray(1);
		      Object[] objArr = (Object[]) ts.getArray();

		      rs = ts.getResultSet();
		      
		      for(int i=0;i<objArr.length;i++) {
		    	  Object[] attrs = null;
		    	  Struct bean = (Struct) objArr[i];
		          attrs = bean.getAttributes();
   		    	  ProductVO product = new ProductVO();		        	

   		    	  List<Object> arr = Arrays.asList(attrs);
//   		    	  System.out.println(arr);
   		    	  product.setId(Integer.parseInt(arr.get(0).toString()));
   		    	  product.setProdCategory(Integer.parseInt(arr.get(1).toString()));
   		    	  product.setProdName(String.valueOf(arr.get(2)));
   		    	  product.setProdDetail(String.valueOf(arr.get(3)));		        
   		    	  product.setPrice(Integer.parseInt(arr.get(4).toString()));
   		    	  product.setDiscount(Integer.parseInt(arr.get(5).toString()));
   		    	  product.setPackageType(String.valueOf(arr.get(6)));
		          product.setOrigin(String.valueOf(arr.get(7)));
		          product.setProdImage(String.valueOf(arr.get(8)));
		          productList.add(product);
  	          }
		      		      
		      for(ProductVO p : productList) {
		    	  System.out.println(p.toString());
		      }
		      
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      DBManager.close(conn, ctmt, rs);
		    }
	        return productList;
	  }    
}
