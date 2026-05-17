package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

	
	
	private LoggerUtility()
	{
		//Constructor cannot be called outside the class
		//Therefore, object cannot be created outside the class
	}
	
	public static Logger getLogger(Class<?> clazz)
	{
		Logger logger = null;
		if(logger == null)
		{
			logger =	LogManager.getLogger(clazz);
		}
		
		return logger;
	}
}
