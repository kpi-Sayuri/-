package application;

import common.*;
import java.sql.*;

//���ݿ� ��Ŀ��������Ŀ��� ��ѯ
public class DBproNo {
	private Connection con = null;		//�������ݿ�
	private String name;		//��Ŀ����
	private String no;		//��Ŀ���
	
	//ͨ�� ��Ż�ȡ����
	public String getName(String no) {
		Statement sql = null;
		ResultSet rs = null;
		try {
			con = DBconnection.getConnection();
			sql = con.createStatement();
			//��ѯ����
			rs = sql.executeQuery("select * from projectNo where pro_No = " + no + ";");
			while(rs.next()) {
				name = rs.getString("pro_Name");
			}
			rs.close();
			sql.close();
		}catch(SQLException e) {
			System.out.println("��ȡ����ʧ�ܣ�");
		}finally {
			DBconnection.closeConnection();
		}
		
		return name;
	}
	//ͨ�� ���ƻ�ȡ���
	public String getNo(String name) {
		Statement sql = null;
		ResultSet rs = null;
		try {
			con = DBconnection.getConnection();
			sql = con.createStatement();
			//��ѯ���
			rs = sql.executeQuery("select * from projectNo where pro_Name = " + name + ";");
			while(rs.next()) {
				no = rs.getString("pro_No");
			}
			rs.close();
			sql.close();
		}catch(SQLException e) {
			System.out.println("��ȡ���ʧ�ܣ�");
		}finally {
			DBconnection.closeConnection();
		}
		
		return no;
	}
}
