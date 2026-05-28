package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojos.AddressPojo2;
import com.utility.BrowserUtility;

public class AddressPage3 extends BrowserUtility {

	public AddressPage3(WebDriver driver)
	{
		super(driver);//storing the browser session
	}
	
	private static final By COMPANY_TEXTBOX_LOCATOR = By.id("company");
	private static final By ADDRESS1_TEXTBOX_LOCATOR = By.id("address1");
	private static final By ADDRESS2_TEXTBOX_LOCATOR = By.id("address2");
	private static final By CITY_TEXTBOX_LOCATOR = By.id("city");
	private static final By STATE_TEXTBOX_LOCATOR = By.id("id_state");
	private static final By POSTCODE_TEXTBOX_LOCATOR = By.id("postcode");
	private static final By HOMEPHONE_TEXTBOX_LOCATOR = By.id("phone");
	private static final By MOBILEPHONE_TEXTBOX_LOCATOR = By.id("phone_mobile");
	private static final By ADDITIONAL_INFORMATION_TEXTBOX_LOCATOR = By.id("other");
	private static final By ADDRESS_ALIAS_TEXTBOX_LOCATOR = By.id("alias");
	private static final By SAVE_BUTTON_LOCATOR = By.id("submitAddress");
	private static final By ADDRESS_ALIAS_HEADING_LOCATOR = By.xpath("//li/h3");
	
	private static final By PROCEED_TO_CHECKOUT_LOCATOR = By.xpath("//button[@name='processAddress']");
	
	public  String saveAddress(AddressPojo2 addressPojo2)
	{
		enterText(COMPANY_TEXTBOX_LOCATOR, addressPojo2.getCompany());
		enterText(ADDRESS1_TEXTBOX_LOCATOR, addressPojo2.getAddress1());
		enterText(ADDRESS2_TEXTBOX_LOCATOR, addressPojo2.getAddress2());
		enterText(CITY_TEXTBOX_LOCATOR, addressPojo2.getCity());
		selectFromDropDown(STATE_TEXTBOX_LOCATOR, addressPojo2.getState());
		enterText(POSTCODE_TEXTBOX_LOCATOR, addressPojo2.getPostcode());
		enterText(HOMEPHONE_TEXTBOX_LOCATOR, addressPojo2.getHomePhone());
		enterText(MOBILEPHONE_TEXTBOX_LOCATOR, addressPojo2.getMobilePhone());
		enterText(ADDITIONAL_INFORMATION_TEXTBOX_LOCATOR, addressPojo2.getAdditional_Information());
		clearText(ADDRESS_ALIAS_TEXTBOX_LOCATOR);
		enterText(ADDRESS_ALIAS_TEXTBOX_LOCATOR, addressPojo2.getAddress_Alias());
		clickOn(SAVE_BUTTON_LOCATOR);
		String alias_Heading =	visibleText(ADDRESS_ALIAS_HEADING_LOCATOR);
		return alias_Heading;
		
	}
	
	public ShippingPage goToShippingPage()
	{
		clickOn(PROCEED_TO_CHECKOUT_LOCATOR);
		ShippingPage shippingPage = new ShippingPage(getDriver());
		return shippingPage;
	}
	
	
	
			
}
