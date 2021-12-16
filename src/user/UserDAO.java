package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DatabaseUtil;

public class UserDAO {
	// 로그인
	public int login(String userID, String userPassword) {
		// 입력한 아이디를 이용해 비밀번호 조회 후 로그인 처리
		String sql = "SELECT userPassword FROM USER WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(userPassword)) {
					return 1;	// 로그인 성공
				}
				else {
					return 0;	// 비밀번호 틀림
				}
			}
			return -1;	//아이디 없음
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if (conn != null) conn.close();} catch (SQLException e) {e.printStackTrace();}
			try {if (pstmt != null) pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			try {if (rs != null) rs.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return -2;	// 데이터베이스 오류
	}
	
	// 회원가입
	public int join(UserDTO user) {
		String sql = "INSERT INTO USER VALUES (?, ?, ?, ?, false)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserEmail());
			pstmt.setString(4, user.getUserEmailHash());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if (conn != null) conn.close();} catch (SQLException e) {e.printStackTrace();}
			try {if (pstmt != null) pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			try {if (rs != null) rs.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return -1;	// 회원가입 실패
	}
	
	// 이메일 반환
	public String getUserEmail(String userID) {
		String sql = "SELECT userEmail FROM USER WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if (conn != null) conn.close();} catch (SQLException e) {e.printStackTrace();}
			try {if (pstmt != null) pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			try {if (rs != null) rs.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return null;	// 데이터베이스 오류
	}	
	
	// 이메일 인증 확인 (평가 등록 가능 여부를 판단)
	public boolean getUserEmailChecked(String userID) {
		String sql = "SELECT userEmailChecked FROM USER WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getBoolean(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if (conn != null) conn.close();} catch (SQLException e) {e.printStackTrace();}
			try {if (pstmt != null) pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			try {if (rs != null) rs.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return false;	// 데이터베이스 오류
	}
	
	// 이메일 인증 처리
	public boolean setUserEmailChecked(String userID) {
		String sql = "UPDATE USER SET userEmailChecked = true WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if (conn != null) conn.close();} catch (SQLException e) {e.printStackTrace();}
			try {if (pstmt != null) pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			try {if (rs != null) rs.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return false;	// 데이터베이스 오류
	}
}
