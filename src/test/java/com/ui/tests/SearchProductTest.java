package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage3;

public class SearchProductTest extends TestBase{
	
	private static final String EMAIL_ADDRESS = "dipibe7483@4heats.com";
	private static final String PASSWORD = "password";
	
	private static MyAccountPage3 myAccountPage3;
	
	private static final String SEARCH_TERM = "Printed Summer Dress";

	@BeforeMethod(description= "User needs to be logged in to search for a product")
	public void setup()
	{
		myAccountPage3 =	homePage.goToLoginPage().doLoginWithCreds3(EMAIL_ADDRESS, PASSWORD);
	}
	
	@Test(description = "Verifies if logged in user is able to search for a product and correct search"
			+ "search results are displayed")
	public void searchProduct()
	{
		Boolean result =	myAccountPage3.searchForAProduct(SEARCH_TERM).isSearchTermPresentInTheProductList(SEARCH_TERM);
		
		Assert.assertTrue(result);
	}
}
