package org.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.entity.login;


public class Logindao {
	public static int login(login login)// 1:登录成功 0：登录失败（用户名或密码有误） -1：系统异常
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
			if (result>0) {//登陆成功
				return 1;
			}
			else {
				return 0;//登陆失败（密码或用户名错误）
			}
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return -1;//登陆失败（系统错误）
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;//登陆失败（系统错误）
		} catch (Exception e) {
			e.printStackTrace();
			return -1;//登陆失败（系统错误）
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();// 对象.方法
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}

	
	
}
