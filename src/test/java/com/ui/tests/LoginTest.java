package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojos.User;

@Listeners(com.ui.listeners.TestListeners.class)
public class LoginTest extends TestBase2 {

	@Test(description = "Verifies if valid user is able to login to the application " , groups = {"e2e" , "sanity"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class , dataProvider = "LoginTestDataProvider")
	
	
	public void loginTest(User user)
	{
		assertEquals(homePage.goToLoginPage().doLoginWithCreds3(user.getEmailAddress() , user.getPassword()).getUserName(), user.getExpectedName());
		
	}
	
	
	@Test(description = "Verifies if valid user is able to login to the application " , groups = {"e2e" , "sanity"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class , dataProvider = "LoginCSVTestDataProvider",
			retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginTest2(User user)
	{
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress() , user.getPassword()).getUserName(), user.getExpectedName());
	}
	
	
	@Test(description = "Verifies if valid user is able to login to the application " , groups = {"e2e" , "sanity"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class , dataProvider = "LoginExcelDataProvider")
	
	
	public void loginExcelTest(User user)
	{
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress() , user.getPassword()).getUserName(), user.getExpectedName());
		
	}
	

	
	
}
