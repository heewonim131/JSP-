package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
	// DB 연동
	// 다른 클래스에서 쉽게 사용할 수 있도록 static
	public static Connection getConnection() {
		try {
			// DB에 입력한 계정정보로 로그인해서 접속을 반환
			String dbURL = "jdbc:mysql://localhost:3306/LectureEvaluation";
			String dbID = "root";
			String dbPassword = "root";
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
