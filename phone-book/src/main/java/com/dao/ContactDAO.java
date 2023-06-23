package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entities.Contact;

public class ContactDAO {

	private Connection conn;
	
	public ContactDAO(Connection conn) {
		super();
		this.conn=conn;
	}
	
	public boolean addContact(Contact c) {
		boolean f=false;
		try {
			
			String q="INSERT INTO contacts(name,email,pnumber,note,userid) VALUES(?,?,?,?,?);";
			PreparedStatement pst=conn.prepareStatement(q);
			pst.setString(1, c.getName());
			pst.setString(2, c.getEmail());
			pst.setString(3, c.getPnumber());
			pst.setString(4, c.getNote());
			pst.setInt(5, c.getUserId());
			
			int i=pst.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Contact> getContactsById(int id) {
		List<Contact> list=new ArrayList<Contact>();
		Contact c=null;
		try {
			
			String q="SELECT * FROM contacts WHERE userid=?;";
			PreparedStatement pst=conn.prepareStatement(q);
			pst.setInt(1, id);
			
			ResultSet rs=pst.executeQuery();
			

			while(rs.next()) {
				c=new Contact();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPnumber(rs.getString(4));
				c.setNote(rs.getString(5));
				c.setUserId(rs.getInt(6));
				list.add(c);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Contact getContactById(int id) {
		Contact c=new Contact();
		try {
			
			String q="SELECT * FROM contacts WHERE id=?;";
			PreparedStatement pst=conn.prepareStatement(q);
			pst.setInt(1, id);
			
			ResultSet rs=pst.executeQuery();
			

			while(rs.next()) {
				c=new Contact();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPnumber(rs.getString(4));
				c.setNote(rs.getString(5));
				c.setUserId(rs.getInt(6));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	public boolean updateContact(Contact c) {
		boolean f=false;
		try {
			
			String q="UPDATE contacts SET name=?, email=?, pnumber=?, note=? WHERE id=?;";
			PreparedStatement pst=conn.prepareStatement(q);
			
			pst.setString(1, c.getName());
			pst.setString(2, c.getEmail());
			pst.setString(3, c.getPnumber());
			pst.setString(4, c.getNote());
			pst.setInt(5, c.getId());
			
			
			int i=pst.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteContact(int id) {
		boolean f=false;
		try {
			
			String q="DELETE FROM contacts WHERE id=?;";
			PreparedStatement pst=conn.prepareStatement(q);
			
			pst.setInt(1, id);
			
			int i=pst.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
}
