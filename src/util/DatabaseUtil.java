package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
	// DB ����
	// �ٸ� Ŭ�������� ���� ����� �� �ֵ��� static
	public static Connection getConnection() {
		try {
			// DB�� �Է��� ���������� �α����ؼ� ������ ��ȯ
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
