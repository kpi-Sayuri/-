package common;

import java.sql.*;

//���ݿ� ������ر�
public class DBconnection {
	private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:oracle";
	private static String userName = "sayuri";
	private static String password = "sayuri";
	private static Connection con = null;
	
	//���ݿ�����
	public static Connection getConnection() {
		try {
			Class.forName("oralce.jdbc.driver.OracleDriver");		//��������
			System.out.println("���ݿ���������ɹ���");
			con = DriverManager.getConnection(url, userName, password);		//��������
			if(con != null)
				System.out.println("�ɹ����ӵ�Oracle���ݿ⣡");
			else
				System.out.println("���ӵ�Oracle���ݿ�ʧ�ܣ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	//���ݿ�ر�
	public static void closeConnection() {
		try {
			con.close();
			con = null;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
