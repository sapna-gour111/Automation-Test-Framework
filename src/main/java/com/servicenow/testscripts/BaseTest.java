package com.servicenow.testscripts;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentTest;
import com.servicenow.pageobjects.LoginPage;
import com.servicenow.utils.LocalDriverFactory;
import com.servicenow.utils.LocalDriverManager;
import com.servicenow.utils.ToolUtils;
import com.servicenow.utils.reporting.factory.ComplexReportFactory;
import com.servicenow.utils.reporting.factory.CybageReporter;

/**
 * This class contains methods to perform base test actions
 * 
 * @author Sapna Gour
 *
 */
public class BaseTest {

	protected LoginPage loginPage;
	protected ExtentTest test;
	EventFiringWebDriver driver;
	protected CybageReporter reporter;
	protected String temp;
	public static Logger logger = LogManager.getLogger();

	/**
	 * This method takes backup
	 */
	@BeforeSuite
	public void beforeSuiteExecution() {
		logger.info("Taking backup");
		ToolUtils.takeBackUP();
	}

	/**
	 * This method launches web driver and used to login to application
	 * 
	 * @param browser
	 * @param currentInstance
	 * @throws Exception
	 */
	public void setUp(String browser, String currentInstance) throws Exception {
		logger.info("Setting up environment to execute test");
		driver = LocalDriverFactory.createInstance(browser);
		LocalDriverManager.setWebDriver(driver);
		loginPage = new LoginPage(driver);
		loginPage.logIntoSite();
		reporter = new CybageReporter(driver);
	}

	/**
	 * To capture count of test script execution
	 * 
	 * @param itr
	 * @param method
	 */
	@BeforeMethod
	public void startTest(ITestResult itr, Method method) {
		ComplexReportFactory.getTest(method.getDeclaringClass().getSimpleName() + " : " + method.getName(),
				method.getDeclaringClass().getCanonicalName());
		test = ComplexReportFactory.getTest(driver);
		reporter.test = test;
	}

	//@AfterMethod
	public void afterEachTest(ITestResult result, Method method) {
		ComplexReportFactory.closeTest(driver, method.getDeclaringClass().getSimpleName() + " : " + method.getName());
	}

	/**
	 * This method is used to close all the browsers opened by web driver.
	 */
	//@AfterClass
	public void tearDown() {
		EventFiringWebDriver driver = LocalDriverManager.getDriver();
		if (driver != null) {
			logger.info("Quiting driver");
			driver.quit();
		}
	}

	/**
	 * This method is used to close the report and it is used to close all
	 * browsers opened by web driver.
	 */
	//@AfterSuite
	public void afterSuiteExecution() {
		logger.info("Quiting driver");
		ComplexReportFactory.closeReport();
		driver.quit();
	}
}