package com.constants;

public enum Size1 {

	S("1"),
	M("2"),
	L("3");
	
	private final String value;
	
	
	Size1(String value)
	{
		this.value= value;
	}
	
	public String getValue()
	{
		return value;
	}
}
