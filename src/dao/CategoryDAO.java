package dao;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import utill.DBManager;
import dto.BigCategoryVO;
import dto.CategoryVO;
import dto.ProductVO;
import dto.SmallCategoryVO;
import oracle.jdbc.internal.OracleTypes;

public class CategoryDAO {
	private CategoryDAO() {}
	private static CategoryDAO instance = new CategoryDAO();
	public static CategoryDAO getInstance() {
		return instance;
	}
	
		
	public ArrayList<BigCategoryVO> getCategoryInfo() {
		
		String sql = "{ ? = call PRODUCT_LIST_PACKAGE.FN_GET_CATEGORY_INFO}";
		Connection conn = null;
		CallableStatement csmt = null;  
		
		HashMap<Integer, BigCategoryVO> categoryMap = new HashMap<>();
	    ArrayList<BigCategoryVO> categoryList = null;
		
		try {			
			conn = DBManager.getConnection(); 
			csmt = conn.prepareCall(sql);
			
			csmt.registerOutParameter(1, OracleTypes.ARRAY,"CATEGORY_INFO_TABLE");
	        csmt.execute();	

	        Array ts = csmt.getArray(1);
	        Object[] objArr = (Object[]) ts.getArray();

	        for(int i=0;i<objArr.length;i++) {
		    	  Object[] attrs = null;
		    	  Struct bean = (Struct) objArr[i];
		          attrs = bean.getAttributes();
		    	  List<Object> arr = Arrays.asList(attrs);

		    	  int bigCategoryId = Integer.parseInt(arr.get(0).toString());
		    	  int smallCategoryId = Integer.parseInt(arr.get(1).toString());
		    	  String bigCtryName = String.valueOf(arr.get(2));
		    	  String smallCtryName = String.valueOf(arr.get(3));
		    	  
		    	  SmallCategoryVO smallCategoryDTO = new SmallCategoryVO(smallCategoryId, smallCtryName);
		    	  if(!categoryMap.containsKey(bigCategoryId)) {		    		  
		    		  BigCategoryVO bigCategoryDTO = new BigCategoryVO(bigCategoryId, bigCtryName);
		    		  categoryMap.put(bigCategoryId, bigCategoryDTO);
		    	  }
		    	  categoryMap.get(bigCategoryId).addSmallCategory(smallCategoryDTO);  	        
  	        }	        
	        
	        categoryList = categoryMap.values().stream()
	                .collect(Collectors.toCollection(ArrayList::new));
	        
		}catch (Exception e) {
			e.printStackTrace();			
		} finally {
		    DBManager.close(conn, csmt);			
		}
	 	
		return categoryList;
	}

}
