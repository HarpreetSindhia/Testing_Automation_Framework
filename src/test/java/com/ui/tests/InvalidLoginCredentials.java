package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojos.User;

@Listeners(com.ui.listeners.TestListeners.class)
public class InvalidLoginCredentials extends TestBase2 {

	private static final String INVALID_EMAILADDRESS = "sapediw118@soppat.com";
	
	private static final String PASSWORD = "passworl";
	
	@Test(description = "Verifies if user gets error message entering invalid credentials " , groups = {"e2e" , "sanity"})
	
	public void loginInvalidCredentials()
	{
		assertEquals(homePage.goToLoginPage().invalidLoginCredentials(INVALID_EMAILADDRESS, PASSWORD).getErrorMessage(),"Authentication failed.");
		
	}
	
	
	
	
}
