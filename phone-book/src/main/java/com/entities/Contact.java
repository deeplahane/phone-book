package com.entities;

public class Contact {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPnumber() {
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	private int id;
	private String name;
	private String email;
	private String pnumber;
	private String note;
	private int userId;
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(String name, String email, String pnumber, String note, int userId) {
		super();
		this.name = name;
		this.email = email;
		this.pnumber = pnumber;
		this.note = note;
		this.userId = userId;
	}
	
	public Contact(int id,String name, String email, String pnumber, String note, int userId) {
		super();
		this.id=id;
		this.name = name;
		this.email = email;
		this.pnumber = pnumber;
		this.note = note;
		this.userId = userId;
	}
	
	public Contact(int id,String name, String email, String pnumber, String note) {
		super();
		this.id=id;
		this.name = name;
		this.email = email;
		this.pnumber = pnumber;
		this.note = note;
	}
	
	
}
