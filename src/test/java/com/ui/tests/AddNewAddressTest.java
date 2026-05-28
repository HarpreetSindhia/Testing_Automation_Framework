package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pojos.AddressPOJO;
import com.utility.FakerUtility;

@Listeners(com.ui.listeners.TestListeners.class)
public class AddNewAddressTest extends TestBase {

	private static final String	EMAIL_ADDRESS = "sapediw118@soppat.com";
	private static final String PASSWORD = "password";
	
	private AddressPOJO addressPojo;
	
	private MyAccountPage myAccountPage;
	
	@BeforeMethod(description =	"Verifies if First Time user is logged into the application")
	public void setup()
	{
		myAccountPage =	homePage.goToLoginPage().doLoginWith(EMAIL_ADDRESS, PASSWORD);
		addressPojo = FakerUtility.getFaker();
	}
	
	@Test(description = "Add new Address")
	public void addNewAddress()
	{
		String newAddress =	myAccountPage.goToAddressPage().saveAddress(addressPojo);
		Assert.assertEquals(newAddress, addressPojo.getAddressAlias().toUpperCase());
	}
}
