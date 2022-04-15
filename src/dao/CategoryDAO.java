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

// 작성자 : 유지훈
// 기능 : 대분류 카테고리 정보와 소분류 카테고리 정보 모두를 가져온다.
public class CategoryDAO {
	private CategoryDAO() {}

	// 싱글톤으로 관리하도록 구현했다.
	private static CategoryDAO instance = new CategoryDAO();
	
	public static CategoryDAO getInstance() {
		return instance;
	}
		
	public ArrayList<BigCategoryVO> getCategoryInfo() {
		
		// 패키지의 Table Function을 활용
		String sql = "{ ? = call PRODUCT_LIST_PACKAGE.FN_GET_CATEGORY_INFO}";
		Connection conn = null;
		CallableStatement csmt = null;  
		
		//대분류에 대한 Category를 HashMap을 통해 생성
		HashMap<Integer, BigCategoryVO> categoryMap = new HashMap<>();
	    ArrayList<BigCategoryVO> categoryList = null;
		
		try {			
			conn = DBManager.getConnection(); 
			csmt = conn.prepareCall(sql);
			
			// Table Tpye으로 반환 값을 받도록 하였다.
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
	        
	        // HashMap을 ArrayList으로 바꿔주는 기능 
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
