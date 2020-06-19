package com.example.Recharge;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {
@Id
private String username;
private String password;

public void setUsername(String username)
{
	this.username=username;
}

public String getUsername()
{
	return username;
}

public void setPassword(String Password)
{
	this.password=Password;
}

public String getPassword()
{
	return password;
}

}
