package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class MyAccountPage3 extends BrowserUtility {

	public MyAccountPage3(WebDriver driver)
	{
		super(driver);
	}
	
	private static final By ADD_MY_NEW_ADDRESS_LOCATOR = By.xpath("//li/a[@title='Add my first address']");
	
	private static final By SEARCH_TEXTBOX_LOCATOR = By.id("search_query_top");
	
	
	
	public AddressPage3 goToAddressPage()
	{
		clickOn(ADD_MY_NEW_ADDRESS_LOCATOR);
		AddressPage3 addressPage3 = new AddressPage3(getDriver());
		return addressPage3;
	}
	
	public SearchResult2Page searchForAProduct(String searchTerm)
	{
		enterText(SEARCH_TEXTBOX_LOCATOR, searchTerm);
		enterSpecialKey(SEARCH_TEXTBOX_LOCATOR, Keys.ENTER);
		SearchResult2Page searchResultPage2 = new SearchResult2Page(getDriver());
		return searchResultPage2;
	}
}
