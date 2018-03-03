package com.dazhumei.love.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.dazhumei.love.ip.entity.Testip;
import com.dazhumei.love.ip.service.TestipService;

public class DBManageTest {
	
	
	public static void testipBegain(TestipService testipService) throws SQLException{
		for(int i=1;i<255;i++){
			for(int l=1;l<255;l++){
				for(int m=1;m<255;m++){
					for(int n=1;n<255;n++){
						StringBuffer ip=new StringBuffer();
						ip.append(i).append(",").append(l).append(",").append(m).append(",").append(n);
						getConnect(ip.toString(),testipService);
						System.out.println(ip.toString()+"连不上。。。");
					}
				}
			}
		}
	}
	
	public static void getConnect(String ip,TestipService testipService) throws SQLException {
		Connection con = null;
		String url = "jdbc:mysql://"+ip+":3306/mysql";
		String root = "root";
		String password = "root";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, root, password); // 连接MSSQL
		} catch (Exception e) {
			getConnectTest(url,testipService);
		}finally {
			if(con!=null){
				System.out.println(url);
				System.out.println("root");
				System.out.println("root");
				Testip testip=new Testip();
				testip.setRoot("root");
				testip.setPassword("root");
				testip.setIp(url);
				testip.setSuccess("YES");
				testipService.addTestip(testip);
				con.close();
			}
		}
	}
	
	public static void getConnectTest(String url,TestipService testipService) throws SQLException {
		Connection con2 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con2 = DriverManager.getConnection(url, "root", "123456"); // 连接MSSQL
		} catch (Exception e) {
			Testip testip=new Testip();
			testip.setIp(url);
			testip.setSuccess("NO");
			testipService.addTestip(testip);
		}finally {
			if(con2!=null){
				System.out.println(url);
				System.out.println("root");
				System.out.println("123456");
				Testip testip=new Testip();
				testip.setRoot("root");
				testip.setPassword("123456");
				testip.setIp(url);
				testip.setSuccess("YES");
				testipService.addTestip(testip);
				con2.close();
			}

		}
	}
}
