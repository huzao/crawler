package com.dazhumei.love.test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test_01 {
	
	public static void main(String[] args) throws IOException {
		for(int i=298;i<=560;i=i+10){
			int sta=438;
			int end=447;
			if((i+9)>560){
				end=560;
			}else {
				end=i+9;
			}
			try {
//				URL temp = new URL("http://localhost:8080/crawler/controller/beginSelectOneBarFromTest?sta="+sta+"&end="+end+"&name=武汉纺织大学外经贸学院"+"&baseurl=baseurl1"+"&barid=AD9596A7C9504B828B662FC5A7E6CDDD");
				URL temp = new URL("http://119.23.31.208:8080/crawler/controller/beginSelectOneBarFromTest");
				
				HttpURLConnection connection=(HttpURLConnection) temp.openConnection();
				String param1="&sta="+sta;
				String param2="&end="+end;
				String param3="&name=武汉纺织大学外经贸学院";
				String param4="&baseurl=http://tieba.baidu.com";
				String param5="&barid=AD9596A7C9504B828B662FC5A7E6CDDD";
				//设置参数
				connection.setDoOutput(true);   //需要输出
				connection.setDoInput(true);   //需要输入
				connection.setUseCaches(false);  //不允许缓存
				connection.setRequestMethod("POST");   //设置POST方式连接
			    //设置请求属性
				connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				connection.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
				connection.setRequestProperty("Charset", "UTF-8");

	            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));

	            writer.write(param1);
	            writer.write(param2);
	            writer.write(param3);
	            writer.write(param4);
	            writer.write(param5);

	            writer.flush();

	            int responseCode =connection.getResponseCode();//

	            if (responseCode == 200) {
	            	System.out.println("http://119.23.31.208:8080/crawler/controller/beginSelectOneBarFromTest?sta="+sta+"&end="+end+"&name=武汉纺织大学外经贸学院"+"&baseurl=http://tieba.baidu.com"+"&barid=AD9596A7C9504B828B662FC5A7E6CDDD");
	            }

//				URLConnection uc = temp.openConnection();
//				uc.setConnectTimeout(10000);
//				uc.setReadTimeout(10000);
//				uc.setDoInput (true);
//				uc.setDoOutput(true);
//				uc.setRequestMethod("POST");
//				uc.addRequestProperty("User-Agent",
//						"Mozilla/5.0 (iPad; U; CPU OS 4_3_3 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5");
//				temp.openStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
