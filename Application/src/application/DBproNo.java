package application;

import common.*;
import java.sql.*;

//数据库 项目名称与项目编号 查询
public class DBproNo {
	private Connection con = null;		//连接数据库
	private String name;		//项目名称
	private String no;		//项目编号
	
	//通过 编号获取名称
	public String getName(String no) {
		Statement sql = null;
		ResultSet rs = null;
		try {
			con = DBconnection.getConnection();
			sql = con.createStatement();
			//查询名称
			rs = sql.executeQuery("select * from projectNo where pro_No = " + no + ";");
			while(rs.next()) {
				name = rs.getString("pro_Name");
			}
			rs.close();
			sql.close();
		}catch(SQLException e) {
			System.out.println("获取名称失败！");
		}finally {
			DBconnection.closeConnection();
		}
		
		return name;
	}
	//通过 名称获取编号
	public String getNo(String name) {
		Statement sql = null;
		ResultSet rs = null;
		try {
			con = DBconnection.getConnection();
			sql = con.createStatement();
			//查询编号
			rs = sql.executeQuery("select * from projectNo where pro_Name = " + name + ";");
			while(rs.next()) {
				no = rs.getString("pro_No");
			}
			rs.close();
			sql.close();
		}catch(SQLException e) {
			System.out.println("获取编号失败！");
		}finally {
			DBconnection.closeConnection();
		}
		
		return no;
	}
}
