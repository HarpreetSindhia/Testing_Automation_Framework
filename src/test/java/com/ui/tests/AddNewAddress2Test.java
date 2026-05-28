package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage2;
import com.ui.pojos.Address;
import com.utility.FakeReaderUtility;

@Listeners(com.ui.listeners.TestListeners.class)
public class AddNewAddress2Test extends TestBase{

	private static final String EMAIL_ADDRESS = "dipibe7483@4heats.com";
	private static final String PASSWORD = "password";
	
	private MyAccountPage2 myAccountPage;
	
	private Address addressPojo;
	
	@BeforeMethod(description= "Verifies if first time user is able to add new address")
	public void setup()
	{
		myAccountPage =	homePage.goToLoginPage().doLoginWithCreds(EMAIL_ADDRESS, PASSWORD);
		
		addressPojo =	FakeReaderUtility.getAddress();
		
	}
	
	
	@Test(description="Add new address")
	public void addNewAddress()
	{
		String addressAlias =	myAccountPage.goToAddressPage().saveAddress(addressPojo);
		Assert.assertEquals(addressAlias, addressPojo.getAddress_Alias().toUpperCase());
	}
}
