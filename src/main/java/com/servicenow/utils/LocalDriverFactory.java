package com.servicenow.utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * This class return the instance of webdriver to the caller.
 * 
 * @author Vishal Jalgaonkar
 *
 */

public class LocalDriverFactory {

	public static EventFiringWebDriver createInstance(String browserName) {
		EventFiringWebDriver edwdriver = null;
		WebDriver driver = null;

		if (browserName.toLowerCase().contains("firefox")) {
			driver = new FirefoxDriver();
		}
		if (browserName.toLowerCase().contains("internet")) {
			DesiredCapabilities browserCapabillities = DesiredCapabilities.internetExplorer();
			browserCapabillities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			browserCapabillities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
					true);
			File file1 = new File(Constants.DRIVEREXEs_PATH + "IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file1.getAbsolutePath());
			driver = new InternetExplorerDriver(browserCapabillities);
		}
		if (browserName.toLowerCase().contains("chrome")) {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--test-type");
			File file = null;
			try {
				file = File.createTempFile("chrome_usr_dir", "");
			} catch (IOException e) {
			}
			file.delete();
			file.mkdir();
			String[] switches = { "user-data-dir=" + file.getAbsolutePath(), "start-maximized",
					"ignore-certificate-errors" };
			capabilities.setCapability("chrome.switches", switches);
			File file1 = new File(Constants.DRIVEREXEs_PATH + "chromedriver.exe");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
			options.addArguments("no-sandbox");
			driver = new ChromeDriver(capabilities);
			//driver = new ChromeDriver(options);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		edwdriver = new EventFiringWebDriver(driver);
		return edwdriver;
	}
}