package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constants.SizePro;
import com.ui.pages.MyAccountPage3;

public class ProductCheckout2 extends TestBase {
	
	private static final String EMAIL_ADDRESS = "dipibe7483@4heats.com";
	
	private static final String PASSWORD = "password";
	
	private static MyAccountPage3 myAccountPage3;
	
	private static final String SEARCH_TERM = "Printed Summer Dress";

	@BeforeMethod(description= "Verifies if user is logged into the application")
	public void setup()
	{
		myAccountPage3 =	homePage.goToLoginPage().doLoginWithCreds3(EMAIL_ADDRESS, PASSWORD);
		
		
	}
	
	@Test(description= "Checkout the Product")
	public void productCheckout()
	{
		myAccountPage3.searchForAProduct(SEARCH_TERM).clickOnTheProductAtIndex(1).selectSize(SizePro.M).goToShoppingCartPage()
		.goToShoppingCartSummaryPage().goToAddressPage().goToShippingPage().selectCheckBox().goToPaymentPage();
		
	}
	
	
}
