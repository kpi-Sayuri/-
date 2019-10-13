package common;

import java.sql.*;

//数据库 连接与关闭
public class DBconnection {
	private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:oracle";
	private static String userName = "sayuri";
	private static String password = "sayuri";
	private static Connection con = null;
	
	//数据库连接
	public static Connection getConnection() {
		try {
			Class.forName("oralce.jdbc.driver.OracleDriver");		//加载驱动
			System.out.println("数据库加载驱动成功！");
			con = DriverManager.getConnection(url, userName, password);		//创建连接
			if(con != null)
				System.out.println("成功连接到Oracle数据库！");
			else
				System.out.println("连接到Oracle数据库失败！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	//数据库关闭
	public static void closeConnection() {
		try {
			con.close();
			con = null;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
