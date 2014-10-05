package edu.umd.enpm613.dto;

public class LoginDTO {
	
	String userId;
	String password;
	String user_role;
	public String getUserId() {
		return userId;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
