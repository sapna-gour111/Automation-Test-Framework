package com.servicenow.testscripts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.servicenow.pageobjects.HomePage;
import com.servicenow.utils.ToolUtils;

/**
 * Test script to validate all modules present under Incident Overview is not
 * present for this user.
 */
public class IncidentModulesTest extends BaseTest {

	HomePage homePage;

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
		homePage = new HomePage(driver);
	}

	/**
	 * This test is to validate incident modules.
	 */
	@Test(priority = 1)
	public void validateIncidentModules() {
		logger.info("*********************************");
		logger.info("IncidentModulesTest - validateIncidentModules");
		logger.info("*********************************");
		Assert.assertEquals(homePage.createNewIncident.getText(), "Create New - Fast", "Create New is not displayed");
		Assert.assertEquals(homePage.assignToMeIncident.getText(), "Assigned to me - Fast",
				"Assing to me is not displayed");
		test.log(LogStatus.FAIL, "test failure ");
		Assert.assertEquals(homePage.openIncident.getText(), "Open - Fast", "Open is not displayed");
		Assert.assertEquals(homePage.openUnassignedIncident.getText(), "Open - Unassigned - Fast",
				"Open Unassigned is not displayed");
		Assert.assertEquals(homePage.myGroupsIncident.getText(), "My Groups - Fast", "My Groups is not displayed");
		Assert.assertEquals(homePage.myGroupsUnassignedIncident.getText(), "My Groups - Unassigned - Fast",
				"My Groups - Unassigned is not displayed");
		Assert.assertEquals(homePage.resolvedIncident.getText(), "Resolved - Fast", "Resolved is not displayed");
		Assert.assertEquals(homePage.closedIncident.getText(), "Closed - Fast", "Close is not displayed");
		Assert.assertEquals(homePage.allIncident.getText(), "All - Fast", "All incident is not displayed");
		test.log(LogStatus.PASS, "Test for validating incident modules is successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}
}
