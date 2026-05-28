package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.SizePro;
import com.utility.BrowserUtility;

public class ProductDetail2Page extends BrowserUtility{

	public ProductDetail2Page(WebDriver driver)
	{
		super(driver);
	}
	
	private static final By SIZE_DROP_DOWN_LOCATOR = By.xpath("//select[@id='group_1']");
	
	private static final By ADD_TO_CART_SHOPPING_LOCATOR = By.xpath("//p/button[@name='Submit']");
	
	public ProductDetail2Page selectSize(SizePro pro)
	{
		selectFromDropDownEnumValue(SIZE_DROP_DOWN_LOCATOR , pro );
		ProductDetail2Page productDetailPage2 = new ProductDetail2Page(getDriver());
		return productDetailPage2;
	}
	
	public ShoppingCartPage goToShoppingCartPage()
	{
		clickOn(ADD_TO_CART_SHOPPING_LOCATOR);
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());
		return shoppingCartPage;
	}
}
