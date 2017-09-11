package com.servicenow.testscripts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.servicenow.pageobjects.CreateIncidentFrame;
import com.servicenow.pageobjects.HomePage;
import com.servicenow.utils.ExcelReader;
import com.servicenow.utils.ToolUtils;

/**
 * This class contains methods to perform test actions
 * 
 * @author Sapna Gour
 *
 */
public class ValidateDefaultImpactUrgencyPriorityValuesTest extends BaseTest {

	HomePage homepg;
	ExcelReader readData;

	/**
	 * Setup method to create base for all subsequent test methods
	 * 
	 * @param browser
	 *            - Browser Name
	 */
	@BeforeClass
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) throws Exception {
		super.setUp(browser, this.getClass().getSimpleName());
		homepg = new HomePage(driver);
		homepg.createIncidentFrame = (CreateIncidentFrame) new CreateIncidentFrame(driver);
	}

	/**
	 * This test is to validate default values of urgency and priority.
	 * 
	 * @param impactTextExpected
	 * @param urgencyTextExpected
	 * @param priorityTextExpected
	 */
	@Test(dataProvider = "ImpactUrgencyPriorityValidations", priority = 1)
	public void validateDefaultValuesOfImpactUrgencyPriority(String impactTextExpected, String urgencyTextExpected,
			String priorityTextExpected) {
		logger.info("*********************************");
		logger.info("ValidateDefaultImpactUrgencyPriorityValuesTest - validateDefaultValuesOfImpactUrgencyPriority");
		logger.info("*********************************");
		homepg.clickOncreateNewIncidentFullButton();
		// switch to iFrame
		Assert.assertTrue(impactTextExpected.equalsIgnoreCase(homepg.createIncidentFrame.getDefaultImpactValue()),
				"Impact value is not matching with expected");
		Assert.assertTrue(urgencyTextExpected.equalsIgnoreCase(homepg.createIncidentFrame.getDefaultUrgencyValue()),
				"Urgency value is not matching with expected");
		Assert.assertTrue(priorityTextExpected.equalsIgnoreCase(homepg.createIncidentFrame.getDefaultPriorityValue()),
				"Priority value is not matching with expected");
		// Final Verification
		test.log(LogStatus.PASS, "The test has passed.");
		test.log(LogStatus.PASS, "Validation for default value of impact urgency priority is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");

	}

	@DataProvider(name = "ImpactUrgencyPriorityValidations")
	public Object[][] ServiceOutageValidations() throws Exception {
		readData = new ExcelReader();
		Object[][] retObjArr = readData.excelRead("ServiceNow_TestData.xlsx", "ImpactUrgencyPriority");
		return retObjArr;
	}

}
