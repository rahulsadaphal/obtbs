package com.manipal.model;

public class User 
{
	private String userId;
	private String userUsername;
	private String userPassword;
	private String userFirstname;
	private String userLastname;
	private String userEmail;
	private String userGender;
	private long userContact;
	private String status;
	
//---------------------------------------------------------------
	public User()
	{
		
	}
	
	
	public User(String userId, String userUsername, String userPassword,
		String userFirstname, String userLastname, String userEmail,
		String userGender, long userContact, String status) {
	super();
	this.userId = userId;
	this.userUsername = userUsername;
	this.userPassword = userPassword;
	this.userFirstname = userFirstname;
	this.userLastname = userLastname;
	this.userEmail = userEmail;
	this.userGender = userGender;
	this.userContact = userContact;
	this.status = status;
}


	public User(String userUsername, String userPassword, String userFirstname,
			String userLastname, String userEmail, String userGender,
			long userContact) {
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userFirstname = userFirstname;
		this.userLastname = userLastname;
		this.userEmail = userEmail;
		this.userGender = userGender;
		this.userContact = userContact;
	}
//---------------------------------------------------------------
	
	public String getUserUsername() {
		return userUsername;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserFirstname() {
		return userFirstname;
	}
	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}
	public String getUserLastname() {
		return userLastname;
	}
	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public long getUserContact() {
		return userContact;
	}
	public void setUserContact(long userContact) {
		this.userContact = userContact;
	}
	
	
	
}
