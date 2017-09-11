package com.servicenow.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Implementation of WebDriverEventListener methods
 * 
 * @author Vishal Jalgaonkar
 *
 */

public class WebDriverListener implements WebDriverEventListener {

	ExtentTest test;

	public WebDriverListener(ExtentTest test) {
		this.test = test;
	}

	WebElement lastElement;
	String originalValue;

	/**
	 * This method tells what should happen before navigating to application
	 */
	public void beforeNavigateTo(String url, WebDriver driver) {
		test.log(LogStatus.INFO, "Trying to Navigate to " + url);

	}

	/**
	 * This method tells what should happen after navigating to application
	 */
	public void afterNavigateTo(String url, WebDriver driver) {
		test.log(LogStatus.INFO, "Navigated to " + url);

	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {

	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
	}

	/**
	 * This method tells what should happen before clicking on any element
	 */
	public void beforeClickOn(WebElement element, WebDriver driver) {
		if (!isAlertPresent(driver)) {
			test.log(LogStatus.INFO, "Before Clicking on " + element);
		}
	}

	/**
	 * This method tells what should happen after clicking on any element
	 */
	public void afterClickOn(WebElement element, WebDriver driver) {
		if (!isAlertPresent(driver)) {
			test.log(LogStatus.INFO, "After Clicked on " + element);
		}
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		lastElement = element;
		originalValue = element.getText();

		if (originalValue.isEmpty()) {
			originalValue = element.getAttribute("value");
		}
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		lastElement = element;
		String changedValue = "";
		try {
			changedValue = element.getText();
		} catch (StaleElementReferenceException e) {
			test.log(LogStatus.ERROR,
					"Could not log change of element, because of a stale element reference exception.");
			return;
		}
		if (changedValue.isEmpty()) {
			changedValue = element.getAttribute("value");
		}

		if (changedValue.length() > 1) {
			test.log(LogStatus.INFO, "Changing value in element found " + lastElement + " from '" + originalValue
					+ "' to '" + changedValue + "'");
		}
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method tells what should happen if exception occurs
	 */
	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("WebDriverListener : In exception : " + throwable.getLocalizedMessage());
		test.log(LogStatus.FAIL, "Error : " + throwable.getLocalizedMessage());
		ToolUtils.captureScreenshot(driver, test);
	}

	/**
	 * This method is to wait for given time period
	 * 
	 * @param timeSecs
	 */
	public void waitfor(int timeSecs) {
		try {
			Thread.sleep(timeSecs * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * his method is to check whether alert is present or not
	 * 
	 * @param driver
	 * @return
	 */
	protected boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {

	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {

	}
}