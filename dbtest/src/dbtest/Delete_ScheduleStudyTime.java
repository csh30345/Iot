package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextArea;

public class Delete_ScheduleStudyTime {
public static void delete(String serialnum ,String studytime , String date, String subject, JTextArea txtArea) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3309/o2b2", "root", "1234");
		
		String sql = "Delete from schedulestudytime where serialnum = ? and studytime= ? and date= ? and subject= ?";
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, serialnum);
		pstmt.setString(2, studytime);
		pstmt.setString(3, date);
		pstmt.setString(4, subject);
		
		txtArea.append("���� �Ǿ����ϴ�.\n");
		
		int count = pstmt.executeUpdate();
		if (count == 0) {
			System.out.println("����� row: "+ count);
		}
		
		
		

	} catch (Exception e) {
		txtArea.append("������ ���� �ٽ��ѹ� Ȯ���� �ּ���.\n");
		e.printStackTrace();

	} finally {
		try {
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
}