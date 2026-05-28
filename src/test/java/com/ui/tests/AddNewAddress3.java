package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage3;
import com.ui.pojos.AddressPojo2;
import com.utility.FakeReader2Utility;

public class AddNewAddress3  extends TestBase2 {

	private static final String EMAIL_ADDRESS = "dipibe7483@4heats.com";
	
	private static final String PASSWORD = "password";
	
	private MyAccountPage3 myAccountPage3;
	
	private static AddressPojo2 addressPojo2;
	
	@BeforeMethod(description= "Verfies if first time user is able to add a new address")
	public void setup()
	{
		myAccountPage3 = homePage.goToLoginPage().doLoginWithCreds3(EMAIL_ADDRESS, PASSWORD);
		addressPojo2 =	FakeReader2Utility.getAddress();
		
	}
	
	@Test(description= "Add a new address")
	public void addNewAddress()
	{
		String alias_Heading =	myAccountPage3.goToAddressPage().saveAddress(addressPojo2);
		Assert.assertEquals(alias_Heading, addressPojo2.getAddress_Alias().toUpperCase());
	}
}
