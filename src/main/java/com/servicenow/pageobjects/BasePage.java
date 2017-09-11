package com.servicenow.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

/**
 * This class contains base methods to perform action on web pages
 * 
 * @author Sapna Gour
 *
 */

public class BasePage {

	protected EventFiringWebDriver driver = null;
	final String top_Menu_xpath = "//*[contains(@href,'javascript:void(0)')and contains(text(),'";
	public static Logger logger = LogManager.getLogger();

	public BasePage(EventFiringWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method only checks the DOM, (Ajax or AngularJS) Asynchronous calls
	 * detected by the Jquery - document.readyState.
	 * 
	 * @return
	 */

	private static Predicate<WebDriver> pageIsVisible() {
		return new Predicate<WebDriver>() {
			@Override
			public boolean apply(WebDriver driver) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				if (js.executeScript("return document.readyState").equals("complete")
						&& (Boolean) js.executeScript("return jQuery.active == 0")) {

					return true;
				} else {
					return false;
				}
			}
		};
	}

	/**
	 * This waits up to 'X' seconds before throwing a TimeoutException or if it
	 * finds the element will return it in 0 - 10 seconds. WebDriverWait by
	 * default calls the ExpectedCondition every 500 milliseconds until it
	 * returns successfully. A successful return value for the ExpectedCondition
	 * function type is a Boolean value of true, or a non-null object..
	 */
	public void synchronize() {
		try {
			logger.info("Wait until page is visible");
			new WebDriverWait(driver, 60).until(pageIsVisible());
		} catch (Exception E) {
			System.out.println("Error : synchronize : " + E.getLocalizedMessage());
		}
	}

	/**
	 * This method is used to check whether alert is present or not. If alert is
	 * present it will return true otherwise it will return false
	 * 
	 * @return
	 */
	public boolean isAlertPresent() {
		try {
			logger.info("Checking if alert is present on page");
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * This method is used to check whether alert is present or not. If alert is
	 * present it will close the alert.
	 */
	public void closeAlert() {
		try {
			int i = 0;
			while (i < 3) {
				if (isAlertPresent()) {
					logger.info("---------> closeAlert() found Active Alert, Closing the same");
					driver.switchTo().alert();
					driver.switchTo().alert().accept();
				}
				synchronize();
				i++;
			}
		} catch (NoAlertPresentException ex) {
			logger.info("No Alert present on Webpage : ");
		} catch (Exception E) {
			logger.info("Unable to handle Alert present on Webpage : " + E.getLocalizedMessage());
		}
	}

	/**
	 * This method is used to switch from alert pop up to default window.
	 */
	public void switchToDefaultContent() {
		logger.info("Switching to default window");
		closeAlert();
		driver.switchTo().defaultContent();
		closeAlert();
	}

	/**
	 * This method is used to expand top menu.
	 */
	public void expandTopMenu(String menuItemName) {
		logger.info("Expanding top menu");
		switchToDefaultContent();
		WebElement elem = driver.findElement(By.xpath(top_Menu_xpath + menuItemName + "')]"));
		String temp = elem.getAttribute("class");
		if (temp.equalsIgnoreCase("nav-app collapsed") || temp.equalsIgnoreCase("nav-app nav-open-state")) {
			if (temp.equalsIgnoreCase("nav-app collapsed"))
				elem.click();
			else {
				System.out.println("Main Menu is already expanded");
			}
		} else if (temp.equalsIgnoreCase("nav_menu")) {
			elem.click();
		}

	}

	public void acceptAlert() {
		logger.info("---------> Accepting Alert");
		driver.switchTo().alert();
		driver.switchTo().alert().dismiss();
	}

}