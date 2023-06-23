package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entities.User;

public class UserDAO {

	private Connection conn;
	
	public UserDAO(Connection conn) {
		super();
		this.conn=conn;
	}
	
	public boolean addUser(User u) {
		boolean f = false;

		try {
			
			String q="INSERT INTO user(name,email,password) VALUES(?,?,?); ";
			PreparedStatement pst=conn.prepareStatement(q);
			pst.setString(1, u.getName());
			pst.setString(2, u.getEmail());
			pst.setString(3, u.getPassword());
			
			int v=pst.executeUpdate();
			
			if(v==1){
				f=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public User login(String email,String password) {
		User u=null;
		
		try{
			
			String 	q="SELECT * FROM user WHERE email=? AND password=?;";
			PreparedStatement pst=conn.prepareStatement(q);
			pst.setString(1, email);
			pst.setString(2, password);
			
			ResultSet rs=pst.executeQuery();
			
		while(rs.next()) {
				u=new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
}
