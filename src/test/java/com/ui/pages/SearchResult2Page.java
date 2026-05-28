package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class SearchResult2Page extends BrowserUtility {

	public SearchResult2Page(WebDriver driver)
	{
		super(driver);
	}
	
	private static final By ALL_PRODUCT_LIST_NAME = By.xpath("//h5[@itemprop='name']/a");
	
	public Boolean isSearchTermPresentInTheProductList(String searchTerm)
	{
		List<String> keywords =	Arrays.asList(searchTerm.toLowerCase().split(" "));
		
		List<String> productList =	getAllVisibleText3(ALL_PRODUCT_LIST_NAME);
		
		Boolean result =	productList.stream().anyMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));
		
		return result;
		
		
	}
	
	
	public ProductDetail2Page clickOnTheProductAtIndex(int index)
	{
		clickOnWebElement(getAllProductList2(ALL_PRODUCT_LIST_NAME).get(index));
		ProductDetail2Page productDetailPage2 = new ProductDetail2Page(getDriver());
		return productDetailPage2;
	}
}
