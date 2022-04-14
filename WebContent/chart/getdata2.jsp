<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="javax.naming.*"%>
<%@page import="javax.sql.*"%>
<%@page import="org.json.JSONObject"%>

<%
Connection con = null;
try {
	Context initContext = new InitialContext();
	Context envContext = (Context) initContext.lookup("java:/comp/env");
	DataSource ds = (DataSource) envContext.lookup("jdbc/oracle");
	con = ds.getConnection();
	ResultSet rs = null;
	List genderList = new LinkedList();
	JSONObject responseObj = new JSONObject();

	String query = "select gender, count(*) cnt from member group by gender";
	PreparedStatement pstm = con.prepareStatement(query);

	rs = pstm.executeQuery();
	JSONObject empObj = null;

	while (rs.next()) {
		String gender = rs.getString("gender");
		int cnt = rs.getInt("cnt");
		empObj = new JSONObject();
		empObj.put("gender", gender);
		empObj.put("cnt", cnt);
		genderList.add(empObj);
	}
	rs.close();
	pstm.close();
	con.close();
	
	responseObj.put("genderList", genderList);
	out.print(responseObj.toString());
} catch (Exception e) {
	e.printStackTrace();
}
%>