package com.servicenow.utils;

import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * This class mediates i.e setter getter methods for webdriver instance to a
 * Thread.
 * 
 * @author Vishal Jalgaonkar
 *
 */

public class LocalDriverManager {
	private static ThreadLocal<EventFiringWebDriver> webDriver = new ThreadLocal<EventFiringWebDriver>();

	public static EventFiringWebDriver getDriver() {
		return webDriver.get();
	}

	public static void setWebDriver(EventFiringWebDriver driver) {
		webDriver.set(driver);
	}
}