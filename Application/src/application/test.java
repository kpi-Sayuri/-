package application;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.*;

public class test {
	private Connection con = null;		//�������ݿ�
	public test(){
		Statement sql = null;
		ResultSet rs = null;
		try {
			con = DBconnection.getConnection();
			if(con != null)
			sql = con.createStatement();
			rs = sql.executeQuery("select * from SC;");
			while(rs.next()) {
				System.out.println(rs.getString("pro_Name"));
			}
			rs.close();
			sql.close();
		}catch(SQLException e) {
			System.out.println("��ȡ����ʧ�ܣ�");
		}finally {
			DBconnection.closeConnection();
		}
			
	}
}
