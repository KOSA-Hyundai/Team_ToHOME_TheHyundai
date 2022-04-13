  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@page import="java.sql.*" %>
  <%@page import="java.util.*" %>
  <%@page import="org.json.JSONObject" %>

<%
    Connection con= null;
	String url="jdbc:oracle:thin:@DB202204041648_high?TNS_ADMIN=//Users//gojeongmin//dev//oracle-wallet//Wallet_DB202204041648//";
	String uid="HYUNDAI_TOHOME_USER";
	String pwd="Hyndaiteam1234";
	String driver="oracle.jdbc.driver.OracleDriver";
 	try{
  		Class.forName(driver).newInstance();
		con =      
		DriverManager.getConnection(url,uid,pwd);

      ResultSet rs = null;
      List productDetails = new LinkedList();
      JSONObject responseObj = new JSONObject();

       String query = "SELECT BC.CTGR_NAME, COUNT(BC.CTGR_NAME) CNT FROM PRODUCT P JOIN SMALL_CATEGORY SC ON P.PROD_CATEGORY = SC.ID JOIN BIG_CATEGORY BC ON SC.BIG_CATEGORY_ID = BC.ID GROUP BY BC.CTGR_NAME ORDER BY COUNT(BC.CTGR_NAME)";
       PreparedStatement pstm= con.prepareStatement(query);

       rs = pstm.executeQuery();
       JSONObject empObj = null;

        while (rs.next()) {
        	String bigCategory = rs.getString("ctgr_name");
            int cnt = rs.getInt("cnt");
            empObj = new JSONObject();
            empObj.put("bigCategory", bigCategory);
            empObj.put("cnt", cnt);                                 
            productDetails.add(empObj);
        }
        responseObj.put("productDetails", productDetails);
    out.print(responseObj.toString());
    }
    catch(Exception e){
        e.printStackTrace();
    }
 %>