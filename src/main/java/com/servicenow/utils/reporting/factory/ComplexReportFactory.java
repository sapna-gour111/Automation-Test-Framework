package com.servicenow.utils.reporting.factory;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.servicenow.utils.ToolUtils;
import com.servicenow.utils.WebDriverListener;

/**
 * Implementation of Extent reports
 * 
 * @author Vishal Jalgaonkar
 *
 */

public class ComplexReportFactory {

	public static ExtentReports reporter;
	public static Map<Long, String> threadToExtentTestMap = new HashMap<Long, String>();
	public static Map<String, ExtentTest> nameToTestMap = new HashMap<String, ExtentTest>();
	public static Map<ExtentTest, WebDriverListener> driverToTestMap = new HashMap<ExtentTest, WebDriverListener>();
	public static Logger logger = LogManager.getLogger();

	private synchronized static ExtentReports getExtentReport() {
		if (reporter == null) {
			reporter = new ExtentReports(System.getProperty("user.dir") + "\\Extent-Reports\\ExecutionReport_"
					+ ToolUtils.returnUniqueNumber() + ".html", true, DisplayOrder.NEWEST_FIRST);
		}
		return reporter;
	}

	public synchronized static ExtentTest getTest(String testName, String testDescription) {

		// if this test has already been created return
		if (!nameToTestMap.containsKey(testName)) {
			Long threadID = Thread.currentThread().getId();
			ExtentTest test = getExtentReport().startTest(testName, testDescription);
			nameToTestMap.put(testName, test);
			threadToExtentTestMap.put(threadID, testName);

		}
		return nameToTestMap.get(testName);
	}

	public synchronized static ExtentTest getTest(String testName) {
		return getTest(testName, "");
	}

	/**
	 * At any given instance there will be only one test running in a thread. We
	 * are already maintaining a thread to extentest map. This method should be
	 * used after some part of the code has already called getTest with proper
	 * testcase name and/or description.
	 * 
	 * Reason: This method is not for creating test but getting an existing test
	 * reporter. sometime you are in a utility function and want to log
	 * something from there. Utility function or similar code sections are not
	 * bound to a test hence we cannot get a reporter via test name, unless we
	 * pass test name in all method calls. Which will be an overhead and a rigid
	 * design. However, there is one common association which is the thread ID.
	 * When testng executes a test it puts it launches a new thread, assuming
	 * test level threading, all tests will have a unique thread id hence call
	 * to this function will return the right extent test to use
	 */
	public synchronized static ExtentTest getTest(EventFiringWebDriver driver) {
		Long threadID = Thread.currentThread().getId();

		if (threadToExtentTestMap.containsKey(threadID)) {
			String testName = threadToExtentTestMap.get(threadID);
			ExtentTest test = nameToTestMap.get(testName);
			if (driver != null) {
				WebDriverListener wdl = ToolUtils.registerListener(driver, test);
				driverToTestMap.put(test, wdl);
			}
			//logger.info("ComplexReportFactory : getTest ");
			return test;
		}
		return null;
	}

	public synchronized static void closeTest(EventFiringWebDriver driver, String testName) {
		if (!testName.isEmpty()) {
			ExtentTest test = getTest(testName);
			ToolUtils.unregisterListener(driver, driverToTestMap.get(test));
			getExtentReport().endTest(test);
		}
	}

	public synchronized static void closeTest(ExtentTest test) {
		if (test != null) {
			getExtentReport().endTest(test);
		}
	}

	public synchronized static void closeTest() {
		EventFiringWebDriver driver = null;
		ExtentTest test = getTest(driver);
		closeTest(test);
	}

	public synchronized static void closeReport() {
		if (reporter != null) {
			//logger.info("ComplexReportFactory : closeReport");			
			reporter.flush();
			reporter.close();
		}
	}

}
