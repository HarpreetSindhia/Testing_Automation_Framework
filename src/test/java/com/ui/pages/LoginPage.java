package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	private static final By EMAIL_ADDRESS_TEXT_BOX_LOCATOR = By.id("email");
	
	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	
	private static final By SIGN_IN_BUTTON_LOCATOR = By.id("SubmitLogin");
	
	private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[contains(@class,'alert-danger')]/ol/li");
	
	
	public MyAccountPage doLoginWith(String emailAddress, String password)
	{
		enterText(EMAIL_ADDRESS_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SIGN_IN_BUTTON_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
	}
	
	public MyAccountPage2 doLoginWithCreds(String emailAddress, String password)
	{
		enterText(EMAIL_ADDRESS_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SIGN_IN_BUTTON_LOCATOR);
		MyAccountPage2 myAccountPage2 = new MyAccountPage2(getDriver());
		return myAccountPage2;
	}
	
	public MyAccountPage3 doLoginWithCreds3(String emailAddress, String password)
	{
		enterText(EMAIL_ADDRESS_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SIGN_IN_BUTTON_LOCATOR);
		MyAccountPage3 myAccountPage3 = new MyAccountPage3(getDriver());
		return myAccountPage3;
	}
	
	public LoginPage invalidLoginCredentials(String emailAddress , String password)
	{
		enterText(EMAIL_ADDRESS_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SIGN_IN_BUTTON_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	
	public String getErrorMessage()
	{
		return visibleText(ERROR_MESSAGE_LOCATOR);
	}
}
