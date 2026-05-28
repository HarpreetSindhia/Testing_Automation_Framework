package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import 	static com.constants.Size.*;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {

	private static final String EMAIL_ADDRESS = "sapediw118@soppat.com";
	private static final String PASSWORD = "password";
	
	private static final String SEARCH_TERM = "Printed Summer Dress";
	
	private SearchResultPage searchResultPage;
	
	@BeforeMethod(description = "Verifies if user is logged in the application and search for a product")
	public void setup()
	{
		searchResultPage =	homePage.goToLoginPage().doLoginWith(EMAIL_ADDRESS, PASSWORD).searchProductName(SEARCH_TERM);
	}
	
	@Test
	public void checkout()
	{
		searchResultPage.clickOnProductAt(3).selectSize(M);
	}
}
