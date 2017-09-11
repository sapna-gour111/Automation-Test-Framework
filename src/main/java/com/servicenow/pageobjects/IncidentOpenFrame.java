package com.servicenow.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains pageobjects & methods to perform action on web pages
 * 
 * @author Sapna Gour
 *
 */

public class IncidentOpenFrame extends IFrameBase {

	public IncidentOpenFrame(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to click on incident number
	 * 
	 * @param incidentNumber
	 */
	public void clickOnIncidentNo(String incidentNumber) {
		logger.info("Clicking on incident nubmer");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		driver.findElement(By.xpath("//a[contains(text(),'" + incidentNumber + "')]")).click();
		closeAlert();
		synchronize();
	}
}