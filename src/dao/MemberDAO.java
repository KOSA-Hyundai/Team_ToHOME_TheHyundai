package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MemberVO;
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

		try {
			Connection conn = DBManager.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			callableStatement.setString(1, memberVO.getEmail());
			callableStatement.setString(2, memberVO.getName());
			callableStatement.setString(3, memberVO.getPw());
			callableStatement.setString(4, memberVO.getPhone_number());
			callableStatement.setString(5, memberVO.getBirth());
			callableStatement.setString(6, memberVO.getGender());
			callableStatement.setString(7, memberVO.getAddress());

			callableStatement.executeUpdate();
			System.out.println("¼º°ø");
		} catch (SQLException e) {
			System.err.format("SQL State: %s\\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MemberVO getMember(String email) {

		MemberVO memberVO = null;
		String sql = "select * from vw_member_info where email=?";
		Connection connn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connn = DBManager.getConnection();
			pstmt = connn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setEmail(rs.getString("email"));
				memberVO.setName(rs.getString("name"));
				memberVO.setPw(rs.getString("pw"));
				memberVO.setPhone_number(rs.getString("phone_number"));
				memberVO.setBirth(rs.getString("birth"));
				memberVO.setGender(rs.getString("gender"));
				memberVO.setAddress(rs.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connn, pstmt, rs);
		}
		return memberVO;
	}
	
/*

	public ArrayList<MemberVO> listMember(String member_name) {

		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		String sql = "select * from member " + " where name like '%'||?||'%' " + " order by indate desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (member_name == "") {
				pstmt.setString(1, "%");
			} else {
				pstmt.setString(1, member_name);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setZipNum(rs.getString("zip_num"));
				memberVO.setAddress(rs.getString("address"));
				memberVO.setPhone(rs.getString("phone"));
				memberVO.setUseyn(rs.getString("useyn"));
				memberVO.setIndate(rs.getTimestamp("indate"));
				memberList.add(memberVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return memberList;
	}*/
}