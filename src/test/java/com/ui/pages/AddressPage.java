package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojos.AddressPOJO;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility {

	public AddressPage(WebDriver driver)
	{
		super(driver);
	}
	
	private static final By COMPANY_TEXT_BOX_LOCATOR = By.id("company");
	
	private static final By ADDRESS1_TEXT_BOX_LOCATOR = By.id("address1");
	
	private static final By ADDRESS2_TEXT_BOX_LOCATOR = By.id("address2");
	
	private static final By CITY_TEXT_BOX_LOCATOR = By.id("city");
	
	private static final By STATE_TEXT_BOX_LOCATOR = By.id("id_state");
	
	private static final By POSTAL_CODE_TEXT_BOX_LOCATOR = By.id("postcode");
	
	private static final By HOME_PHONE_TEXT_BOX_LOCATOR = By.id("phone");
	
	private static final By MOBILE_PHONE_TEXT_BOX_LOCATOR = By.id("phone_mobile");
	
	private static final By ADDITIONAL_INFORMATION_TEXT_BOX_LOCATOR = By.id("other");
	
	private static final By ADDRESS_ALIAS_LOCATOR = By.id("alias");
	
	private static final By SAVE_BUTTON_TEXTBOX_LOCATOR = By.id("submitAddress");
	
	private static final By ADDRESS_HEADING_LOCATOR = By.tagName("h3");
	
	
	public String saveAddress(AddressPOJO addressPojo)
	{
		enterText(COMPANY_TEXT_BOX_LOCATOR , addressPojo.getCompany());
		enterText(ADDRESS1_TEXT_BOX_LOCATOR , addressPojo.getAddressLine1());
		enterText(ADDRESS2_TEXT_BOX_LOCATOR, addressPojo.getAddressLine2());
		enterText(CITY_TEXT_BOX_LOCATOR, addressPojo.getCity());
		selectFromDropDown(STATE_TEXT_BOX_LOCATOR , addressPojo.getState());
		enterText(POSTAL_CODE_TEXT_BOX_LOCATOR, addressPojo.getPostalCode());
		enterText(HOME_PHONE_TEXT_BOX_LOCATOR, addressPojo.getHomePhoneNumber());
		enterText(MOBILE_PHONE_TEXT_BOX_LOCATOR, addressPojo.getMobilePhoneNunber());
		enterText(ADDITIONAL_INFORMATION_TEXT_BOX_LOCATOR , addressPojo.getAdditionalInformation());
		clearText(ADDRESS_ALIAS_LOCATOR);
		enterText(ADDRESS_ALIAS_LOCATOR , addressPojo.getAddressAlias());
		clickOn(SAVE_BUTTON_TEXTBOX_LOCATOR);
		String newAddress =	visibleText(ADDRESS_HEADING_LOCATOR);
		return newAddress;
		
		
		
	}
	
}
