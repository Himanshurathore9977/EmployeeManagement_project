package com.Entity;

public class EmployeeDAO {
	private String  name ;
	private int  userID ; 
	private String designation ; 
	private int phone_no  ; 
	private String password ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(int phone_no) {
		this.phone_no = phone_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public EmployeeDAO(String name,String password, int userID,  int phone_no, String designation) {
		super();
		this.name = name;
		this.userID = userID;
		this.designation = designation;
		this.phone_no = phone_no;
		this.password = password;
	}  
	public EmployeeDAO() {
		super();
	}	
	
}
