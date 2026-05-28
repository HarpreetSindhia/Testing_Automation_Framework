package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShoppingCartPage extends BrowserUtility {

	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	private static final By PROCEED_TO_CHECKOUT_LOCATOR = By.xpath("//a[@title='Proceed to checkout']");
	
	public ShoppingCartSummaryPage goToShoppingCartSummaryPage()
	{
		clickOn(PROCEED_TO_CHECKOUT_LOCATOR);
		ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(getDriver());
		return shoppingCartSummaryPage;
	}
}
