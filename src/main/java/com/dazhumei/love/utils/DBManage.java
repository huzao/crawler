package com.dazhumei.love.utils;

import java.sql.*;

public class DBManage {
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	// 连接MSSQL
	//static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//static String url = "jdbc:sqlserver://localhost;databasename=mysql";
	// 连接MySQL
	 static String driver = "com.mysql.jdbc.Driver";
	 static String url = "jdbc:mysql://localhost:3306/mysql";
	// 连接Oracle
	// static String driver = "oracle.jdbc.driver.OracleDriver";// 连接驱动
	// static String url = "jdbc:oracle:thin:@localhost:1521:ORCL";// 访问oracle路径
	private static Connection getConnect() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "root"); // 连接MSSQL
			// con = DriverManager.getConnection(url,"root","root"); //连接mysql
			// con = DriverManager.getConnection(url,"scott","tiger"); //连接mysql
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getConnectTest() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "root"); // 连接MSSQL
			// con = DriverManager.getConnection(url,"root","root"); //连接mysql
			// con = DriverManager.getConnection(url,"scott","tiger"); //连接mysql
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static ResultSet getResultSet(String sql) {
		con = getConnect();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static ResultSet getResultSet(String sql, Object[] params) {
		con = getConnect();
		try {
			ps = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++)
				ps.setObject(i + 1, params[i]);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static int modifyEntiy(String sql, Object[] params) {
		int num = 0;
		con = getConnect();
		try {
			ps = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			num = ps.executeUpdate();
			closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	public static void closeAll() {
		if (ps != null) {
			try {
				ps.close();
				ps = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
