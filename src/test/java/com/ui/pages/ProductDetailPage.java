package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.utility.BrowserUtility;

public class ProductDetailPage extends BrowserUtility {

	public ProductDetailPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	private static final By SIZE_DROP_DOWN_LOCATOR = By.id("group_1");
	
	public ProductDetailPage selectSize(Size size)
	{
		selectFromDropDownNew(SIZE_DROP_DOWN_LOCATOR , size);
		
		ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
		return productDetailPage;
	}
}
