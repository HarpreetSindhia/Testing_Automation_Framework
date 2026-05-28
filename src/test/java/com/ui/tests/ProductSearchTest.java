package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

public class ProductSearchTest extends TestBase{
	
	private MyAccountPage myAccountPage;
	
	private static final String SEARCH_TERM = "Printed Summer Dress";
	
	private static final String EMAIL_ADDRESS = "sapediw118@soppat.com";
	private static final String PASSWORD = "password";
	

	@BeforeMethod(description = "Verfies if valid user logs into the application")
	public void setup()
	{
		myAccountPage =	homePage.goToLoginPage().doLoginWith(EMAIL_ADDRESS, PASSWORD);
	}
	
	@Test(description = "Verfies if logged in user is able to search for a product and correct search results are displayed" , 
			groups = {"e2e" , "sanity"})
	
	
	public void verifySearchItem()
	{
		Boolean result =	myAccountPage.searchProductName(SEARCH_TERM).verifySearchItemIsPresentInProductList(SEARCH_TERM);
		Assert.assertEquals(result, true );
	}
}
