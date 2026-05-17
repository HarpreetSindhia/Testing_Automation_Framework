package com.ui.pojos;

public class Environment {

	private	String url;
	
	private int MAX_NUMBER_OF_ATTEMPTS;
	
	public void setURL(String url)
	{
		this.url = url;
	}
	
	public String getURL()
	{
		return url;
	}
	
	
	public void setMax_Number_Of_Attempts(int MAX_NUMBER_OF_ATTEMPTS)
	{
		this.MAX_NUMBER_OF_ATTEMPTS = MAX_NUMBER_OF_ATTEMPTS;
	}
	
	public int getMAX_NUMBER_OF_ATTEMPTS()
	{
		return MAX_NUMBER_OF_ATTEMPTS;
	}
}
