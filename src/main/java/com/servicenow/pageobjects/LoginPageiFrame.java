package com.servicenow.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains methods to perform action on web pages iframes
 * 
 * @author Sapna Gour
 *
 */

public class LoginPageiFrame extends IFrameBase {

	final String baseURL = "https://hitachiservicedeskdev.service-now.com";

	// Login - User name text field
	@FindBy(xpath = "//*[@id='username']")
	public WebElement userName_txt;

	// Login - User password text field
	@FindBy(xpath = "//*[@id='password']")
	public WebElement userPassword_txt;

	// Login - Language drop down
	@FindBy(xpath = "//div[@class='panel panel-default']/div[4]/ul/li/button")
	public WebElement language_dropDown;

	// Login - Select English Language
	@FindBy(xpath = "//div[@class='panel panel-default']/div[4]/ul/li/ul/li[1]")
	public WebElement englishLanguage_dropDown;

	// Login - Submit button
	@FindBy(name = "login")
	public WebElement submit_btn;

	public LoginPageiFrame(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to login to application
	 * 
	 * @param username
	 * @param password
	 * @throws InterruptedException
	 */
	protected void logIntoSite(String username, String password) throws InterruptedException {
		logger.info("Logging in to site");
		gotoURL(baseURL);
		selectLanguage();
		Thread.sleep(4000);
		enteruserName(username);
		Thread.sleep(2000);
		enteruserPassword(password);
		clickOnSubmit();
		synchronize();
	}

	/**
	 * This method is used to enter username
	 * 
	 * @param name
	 * @throws InterruptedException
	 */
	private void enteruserName(String name) throws InterruptedException {
		logger.info("Entering username");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		userName_txt.sendKeys(name);
		pressEnterUsingKeyboardKey(userName_txt);
	}

	/**
	 * This method is used to enter password
	 * 
	 * @param password
	 * @throws InterruptedException
	 */
	private void enteruserPassword(String password) throws InterruptedException {
		logger.info("Entering user password");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		userPassword_txt.sendKeys(password);
		click(language_dropDown);
		Thread.sleep(2000);
	}

	/**
	 * This method is used to select language
	 * 
	 * @param language
	 * @throws InterruptedException
	 */
	public void selectLanguage() throws InterruptedException {
		logger.info("Selecting language");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		click(language_dropDown);
		click(englishLanguage_dropDown);
		Thread.sleep(3000);

	}

	/**
	 * This method is used to click on Submit button
	 */
	private void clickOnSubmit() {
		logger.info("Clicking on submit button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		submit_btn.click();
	}
}