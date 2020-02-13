package org.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.entity.login;


public class Logindao {
	public static int login(login login)// 1:��¼�ɹ� 0����¼ʧ�ܣ��û������������� -1��ϵͳ�쳣
	{
		
		String URL = "jdbc:mysql://localhost:3306/studyjsp";
		String USERNAME = "root";
		String PWD = "123456";
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		int result=-1;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PWD);
			String sql = "select count(*) from login where name=? and pwd =?";
		    pstmt= connection.prepareStatement(sql);
		    pstmt.setString(1, login.getName());
		    pstmt.setString(2, login.getPwd());
            rs = pstmt.executeQuery(); 
           
			if (rs.next()) {
			result = rs.getInt(1);
			}
			if (result>0) {//��½�ɹ�
				return 1;
			}
			else {
				return 0;//��½ʧ�ܣ�������û�������
			}
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return -1;//��½ʧ�ܣ�ϵͳ����
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;//��½ʧ�ܣ�ϵͳ����
		} catch (Exception e) {
			e.printStackTrace();
			return -1;//��½ʧ�ܣ�ϵͳ����
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();// ����.����
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}

	
	
}
