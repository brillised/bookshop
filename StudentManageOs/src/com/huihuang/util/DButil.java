package com.huihuang.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DButil {
	private static String driver;
	private static String url;
	private static String dbUserName;
	private static String dbPassWord;
	
	static{
		driver="com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/studentManage?useUnicode=true&characterEncoding=utf-8";//设置指定数据库的连接地址
		dbUserName="root";
		dbPassWord="";
	}
	
	public  Connection dbOpen(){	
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("*****mysql驱动加载失败****");
		}
		
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(url, dbUserName, dbPassWord);
			System.out.println("****数据库已连接****");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("****数据库连接失败****");
		}

		return conn;
	}
	public static void dbClose(Connection conn,Statement st){
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void dbClose(Connection conn,PreparedStatement pst){
		if(pst!=null){
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void dbClose(Connection conn,PreparedStatement pstm,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstm!=null){
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
