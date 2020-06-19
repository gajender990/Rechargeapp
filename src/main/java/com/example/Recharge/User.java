package com.example.Recharge;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userdetails")
public class User {
	@Id
	private String username;
	private String name;
	
	private String password;
	public void setname(String name) {
		this.name=name;
	}
	
	public void setusername(String username) {
		this.username=username;
		
	}

	public void setpassword(String password) {
		this.password=password;
	}
	
	public String getname() {
		return name;
	}
	public String username() {
		return username;
	}
	public String getpassword() {
		return password;
	}
}
