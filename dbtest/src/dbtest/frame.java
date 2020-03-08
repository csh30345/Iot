package dbtest;

import java.sql.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class frame {
	public static void main(String[] args) {
		
		// String profileval =null;
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel("DATABASE");
		JButton btnGet = new JButton("�� �޾ƿ���");
		JButton btnExit = new JButton("�����ϱ�");
		JButton btnClear = new JButton("Ŭ����");
		JTextArea txtArea = new JTextArea();
		JPanel buttJPanel1 = new JPanel();
		
		
		////////////////////////////////////////////////////////////////////////

		frame.setResizable(false); // �Ժη� ũ������ x
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(840,600));
		frame.setSize(840,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �ڹ� ���α׷��� ���� �� �ൿ ����
		frame.add(panel);
		
		
		panel.setLayout(new BorderLayout()); // Ư���� �κп� ���̺��� ��ġ��Ų��
		panel.add(label, BorderLayout.NORTH);
		panel.add(buttJPanel1, BorderLayout.WEST);
		panel.add(txtArea, BorderLayout.CENTER);
		
		buttJPanel1.add(btnGet);
		buttJPanel1.add(btnClear);
		buttJPanel1.add(btnExit);
		
		// btnGet ������ �׼�
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//
				String profileval = null;
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;

				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/o2b2", "root", "1234");

					stmt = conn.createStatement();

					String sql = "SELECT * FROM profile;";

					rs = stmt.executeQuery(sql);

					while (rs.next()) {
						// ���ڵ��� Į���� �迭�� �޸� 0���� �������� �ʰ� 1���� �����Ѵ�.
						// �����ͺ��̽����� �������� �������� Ÿ�Կ� �°� getString �Ǵ� getInt ���� ȣ���Ѵ�.
						String serialnum = rs.getString(1);
						String phonenum = rs.getString(2);
						String password1 = rs.getString(3);

						profileval = serialnum + " " + phonenum + " " + password1 + " ";

					
					}

				} catch (Exception e1) {

					e1.printStackTrace();

				} finally {
					try {
						if (conn != null && !conn.isClosed()) {
							conn.close();
						}
						if (stmt != null && !stmt.isClosed()) {
							stmt.close();
						}
						if (rs != null && !rs.isClosed()) {
							rs.close();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				//
				
				
				txtArea.append(profileval);
			}
		});
		
		// DATA Clear
		btnClear.addActionListener(new ActionListener() { 

			public void actionPerformed(ActionEvent e) {
				txtArea.setText("");
			}
		});
		
		// progrem exit
		btnExit.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		
	}
}
