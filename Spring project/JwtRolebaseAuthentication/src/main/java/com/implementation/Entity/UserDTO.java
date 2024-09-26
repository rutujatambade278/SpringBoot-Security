package com.implementation.Entity;

public class UserDTO {

	private String userName;
    private String password;
    private String email;
    private String role;
	
    
    
    
    
    public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	public UserDTO(String role) {
		super();
		this.role = role;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
    
}

