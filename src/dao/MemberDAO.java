package dao;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.Arrays;
import java.util.List;

import dto.MemberVO;
import oracle.jdbc.OracleTypes;
import utill.DBManager;

// 작성자 : 고정민
// 기능 : 회원과 관련된 기능을 처리
public class MemberDAO {
	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	// 회원가입 기능
	public void insertMember(MemberVO memberVO) {
		
		// 전달받은 memberVO 값을 member_join 프로시저에 입력값으로 넣음
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
		} catch (SQLException e) {
			System.err.format("SQL State: %s\\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, callableStatement);
		}
	}

	// 회원의 정보를 조회하는 기능 (로그인과 회원정보 수정 시 필요)
	public MemberVO getMember(String email) {

		MemberVO memberVO = new MemberVO();

		Connection conn = null;
		CallableStatement ctmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			
			// 회원의 정보를 가져올 FN_GET_MEMBER_INFO 함수를 호출하는 쿼리
			ctmt = conn.prepareCall("{?= call member_package.fn_get_member_info(?)}");
			ctmt.registerOutParameter(1, OracleTypes.ARRAY, "MEMBER_TABLE"); // 출력값을 테이블 형식으로 지정
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

	// 회원 정보 수정 기능
	public void updateMember(MemberVO memberVO) {
		// 회원 정보 수정을 처리할 MEMBER_UPDATE 프로시저를 호출하는 쿼리
		String runSP = "call MEMBER_PACKAGE.MEMBER_UPDATE(?, ?, ?, ?)";
		Connection conn = null;
		CallableStatement ctmt = null;

		try {
			conn = DBManager.getConnection();
			ctmt = conn.prepareCall(runSP);
			ctmt.setString(1, memberVO.getEmail());
			ctmt.setString(2, memberVO.getPw());
			ctmt.setString(3, memberVO.getPhone_number());
			ctmt.setString(4, memberVO.getAddress());

			ctmt.executeUpdate();
		} catch (SQLException e) {
			System.err.format("SQL State: %s\\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ctmt);
		}
	}

	public int confirmID(String email) {
		int result = -1;
		String sql = "select * from member where email=?";
		Connection connn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connn = DBManager.getConnection();
			pstmt = connn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connn, pstmt, rs);
		}
		return result;
	}
}