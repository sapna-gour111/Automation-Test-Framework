package com.servicenow.utils.reporting.factory;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * A bridge between Testclasses and Pageobjects
 * 
 * @author Vishal Jalgaonkar
 *
 */
public class CybageReporter {

	public EventFiringWebDriver driver;
	public ExtentTest test;

	public CybageReporter(EventFiringWebDriver driver) {
		this.driver = driver;
	}
}
