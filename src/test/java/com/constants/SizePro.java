package com.constants;

public enum SizePro {

	S("1"),
	M("2"),
	L("3");
	
	private final String value;
	
	SizePro(String value)
	{
		this.value = value;
	}
	
	public String getValue()
	{
		return value;
	}
}
