package com.connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	private static Connection conn;
	
	public static Connection getCon() {
		
		try {
			if(conn==null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/phone_book?useSSL=false&autoReconnect=true","root","Deeplahane2001#1");
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
