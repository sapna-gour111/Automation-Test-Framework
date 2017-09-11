package com.servicenow.pageobjects;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.servicenow.utils.ExcelReader;

/**
 * This class contains methods to perform action on web pages
 * 
 * @author Sapna Gour
 *
 */

public class LoginPage extends BasePage {

	public LoginPageiFrame loginiframe = null;

	public LoginPage(EventFiringWebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		loginiframe = new LoginPageiFrame(driver);
	}

	/**
	 * This method is used to login to application
	 * 
	 * @param username
	 * @param password
	 * @throws InterruptedException
	 */
	public void logIntoSite(String username, String password) throws InterruptedException {
		logger.info("Logging in to the application");
		loginiframe.logIntoSite(username, password);
	}

	/**
	 * This method ReadExcel Logic for data driven inputs.
	 * 
	 * @throws Exception
	 */
	public void logIntoSite() throws Exception {
		ExcelReader readData = new ExcelReader();
		String[][] retObjArr = readData.excelRead("ServiceNow_TestData.xlsx", "Execution");
		logIntoSite(retObjArr[0][0], retObjArr[0][1]);
		Thread.sleep(10000);
	}
}