package com.team2.model;

import java.io.Serializable;

public class Login implements Serializable  {
	 private static final long serialVersionUID = 1L;
	    private String username;
	    private String password;
	    private int isAdmin;
	    
	    
	    
	    
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
		
		public int getIsAdmin() {
			return isAdmin;
		}
		public void setIsAdmin(int isAdmin) {
			this.isAdmin = isAdmin;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		

}
