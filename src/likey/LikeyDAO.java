package likey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DatabaseUtil;

public class LikeyDAO {
	
	// 추천하기
	public int like(String userID, String evaluationID, String userIP) {
		String sql = "INSERT INTO LIKEY VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, evaluationID);
			pstmt.setString(3, userIP);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if (conn != null) conn.close();} catch (SQLException e) {e.printStackTrace();}
			try {if (pstmt != null) pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			try {if (rs != null) rs.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return -1;	// 추천 중복 오류
	}
}
