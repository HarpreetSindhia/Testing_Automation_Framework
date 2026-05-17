package com.ui.pojos;

public class User {

	private String emailAddress;
	private String password;
	private String expectedName;
	
	public User(String emailAddress , String password , String expectedName)
	{
		this.emailAddress = emailAddress;
		this.password = password;
		this.expectedName = expectedName;
	}
	
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}
	
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setExpectedName(String expectedName)
	{
		this.expectedName = expectedName;
	}
	
	public String getExpectedName()
	{
		return expectedName;
	}
}
