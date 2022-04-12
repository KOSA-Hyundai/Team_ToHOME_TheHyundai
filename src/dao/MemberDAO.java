package dao;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.Arrays;
import java.util.List;

import dto.MemberVO;
import oracle.jdbc.OracleTypes;
import utill.DBManager;

public class MemberDAO {
	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	public void insertMember(MemberVO memberVO) {

		String runSP = "call MEMBER_PACKAGE.MEMBER_JOIN(?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		CallableStatement callableStatement = null;
		
		try {
			conn = DBManager.getConnection();
			callableStatement = conn.prepareCall(runSP);
			callableStatement.setString(1, memberVO.getEmail());
			callableStatement.setString(2, memberVO.getName());
			callableStatement.setString(3, memberVO.getPw());
			callableStatement.setString(4, memberVO.getPhone_number());
			callableStatement.setString(5, memberVO.getBirth());
			callableStatement.setString(6, memberVO.getGender());
			callableStatement.setString(7, memberVO.getAddress());

			callableStatement.executeUpdate();
			System.out.println("성공");
		} catch (SQLException e) {
			System.err.format("SQL State: %s\\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, callableStatement);
		}
	}

	public MemberVO getMember(String email) {

		MemberVO memberVO = new MemberVO();

		Connection conn = null;
		CallableStatement ctmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			ctmt = conn.prepareCall("{?= call member_package.fn_get_member_info(?)}");
			ctmt.registerOutParameter(1, OracleTypes.ARRAY, "MEMBER_TABLE");
			ctmt.setString(2, email);
			ctmt.execute();
			Array ts = ctmt.getArray(1);
			Object[] objArr = (Object[]) ts.getArray();

			rs = ts.getResultSet();
			
			for (int i = 0; i < objArr.length; i++) {
				Object[] attrs = null;
				Struct bean = (Struct) objArr[i];
				attrs = bean.getAttributes();
				
				List<Object> arr = Arrays.asList(attrs);
				memberVO.setEmail(String.valueOf(arr.get(0)));
				memberVO.setName(String.valueOf(arr.get(1)));
				memberVO.setPw(String.valueOf(arr.get(2)));
				memberVO.setPhone_number(String.valueOf(arr.get(3)));
				memberVO.setBirth(String.valueOf(arr.get(4)));
				memberVO.setGender(String.valueOf(arr.get(5)));
				memberVO.setAddress(String.valueOf(arr.get(6)));
			}
		} catch (SQLException e) {
			System.err.format("SQL State: %s\\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ctmt, rs);
		}
		return memberVO;
	}
	
	public void updateMember(MemberVO memberVO) {

		String runSP = "call MEMBER_PACKAGE.MEMBER_UPDATE(?, ?, ?, ?)";
		Connection conn = null;
		CallableStatement ctmt = null;;
		
		try {
			conn = DBManager.getConnection();
			ctmt = conn.prepareCall(runSP);
			ctmt.setString(1, memberVO.getEmail());
			ctmt.setString(2, memberVO.getPw());
			ctmt.setString(3, memberVO.getPhone_number());
			ctmt.setString(4, memberVO.getAddress());
			
			ctmt.executeUpdate();
			System.out.println("성공");
		} catch (SQLException e) {
			System.err.format("SQL State: %s\\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ctmt);
		} 
	}
}