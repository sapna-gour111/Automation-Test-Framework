package com.servicenow.testscripts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.servicenow.pageobjects.HomePage;
import com.servicenow.utils.Constants;
import com.servicenow.utils.ExcelReader;
import com.servicenow.utils.PropertiesLoader;
import com.servicenow.utils.ToolUtils;

/**
 * This class contains methods to perform test actions
 * 
 * @author Sapna Gour
 *
 */

public class ServiceOutageTest extends BaseTest {

	HomePage homepg;
	ExcelReader readData;
	static PropertiesLoader prop = new PropertiesLoader(Constants.PROPERTY_FILE_PATH);
	final String serviceOutage_verify_failure = "Unable to verify that the serviceOutage checkbox is displayed.";
	final String serviceOutage_tab_failure = "Unable to verify that the serviceOutage tab is displayed.";
	final String serviceOutage_Importance_failure = "Unable to find the field serviceOutage_Importance in Service Outage tab";
	final String serviceOutage_State_failure = "Unable to find the field serviceOutage state in Service Outage tab";
	final String serviceOutage_type_failure = "Unable to find the field serviceOutage type in Service Outage tab";
	final String serviceOutage_ImpCompnay_failure = "Unable to find the field serviceOutage Impacted Company in Service Outage tab";
	final String serviceOutage_noofuser_failure = "Unable to find the field serviceOutage Impacted Company in Service Outage tab";
	final String serviceOutage_rootcause_failure = "Unable to find the field serviceOutage Impacted Company in Service Outage tab";
	final String serviceOutage_timezone_failure = "Unable to find the field serviceOutage Impacted Company in Service Outage tab";
	final String serviceOutage_outbreakat_failure = "Unable to find the field serviceOutage Impacted Company in Service Outage tab";
	final String serviceOutage_recognization_at = "Unable to find the field serviceOutage Impacted Company in Service Outage tab";
	final String serviceOutage_recovery_at = "Unable to find the field serviceOutage Impacted Company in Service Outage tab";
	final String serviceOutage_descrip = "Unable to find the field serviceOutage Impacted Company in Service Outage tab";
	final String serviceOutage_Time_failure = " Outage time is not mactching";
	static String incidentNumberText;

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
	}

	/**
	 * This test is to verify service outage validations It checks Service
	 * Outage check box is available or not. Click on Service Outage checkbox
	 * and verify fields present on Outage tab.
	 * 
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	public void verifyServiceOutageValidations() throws InterruptedException {
		logger.info("**************************************************");
		logger.info("ServiceOutageTest - verifyServiceOutageValidations");
		logger.info("**************************************************");

		homepg.clickOncreateNewIncidentFullButton();
		homepg.editincidentfrm.switchToDefaultiFrame();
		// Verify that the serviceOutage check box is visible
		Assert.assertTrue(homepg.editincidentfrm.serviceOutage_chkbox.isDisplayed(),
				"Service Outage checkbox is not displaying");
		homepg.editincidentfrm.clickOnserviceOutage();
		Thread.sleep(2000);
		// Verify serviceOutage tab is visible
		Assert.assertTrue(homepg.editincidentfrm.serviceOutageTab_lnk.isDisplayed(), serviceOutage_tab_failure);
		homepg.editincidentfrm.clickOnServiceOutageTab();
		Assert.assertTrue(homepg.editincidentfrm.serviceOutage_imp.isDisplayed(), serviceOutage_Importance_failure);
		Assert.assertTrue(homepg.editincidentfrm.serviceOutage_state.isDisplayed(), serviceOutage_State_failure);
		Assert.assertTrue(homepg.editincidentfrm.serviceOutage_type.isDisplayed(), serviceOutage_type_failure);
		Assert.assertTrue(homepg.editincidentfrm.serviceOutage_comp.isDisplayed(), serviceOutage_ImpCompnay_failure);
		Assert.assertTrue(homepg.editincidentfrm.serviceOutage_noofuser.isDisplayed(), serviceOutage_noofuser_failure);
		Assert.assertTrue(homepg.editincidentfrm.serviceOutage_rootcause.isDisplayed(),
				serviceOutage_rootcause_failure);
		Assert.assertTrue(homepg.editincidentfrm.serviceOutage_timezone.isDisplayed(), serviceOutage_timezone_failure);
		Assert.assertTrue(homepg.editincidentfrm.serviceOutage_outbreak_at.isDisplayed(),
				serviceOutage_outbreakat_failure);
		Assert.assertTrue(homepg.editincidentfrm.serviceOutage_recognization_at.isDisplayed(),
				serviceOutage_recognization_at);
		Assert.assertTrue(homepg.editincidentfrm.serviceOutage_recovery_at.isDisplayed(), serviceOutage_recovery_at);
		Assert.assertTrue(homepg.editincidentfrm.serviceOutage_descrip.isDisplayed(), serviceOutage_descrip);

		// Final Verification
		test.log(LogStatus.PASS, "Verified that Service Outage checkbox is visible and SONGS fields are displaying.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");

	}

	/**
	 * This test is to verify service outage state.
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	public void verifyOutageState() throws InterruptedException {
		logger.info("**************************************");
		logger.info("ServiceOutageTest - verifyOutageState");
		logger.info("**************************************");
		// Verify serviceOutage State is visible
		Assert.assertTrue(homepg.editincidentfrm.serviceOutage_state.isDisplayed(),
				"Unable to verify service outage state");
		String state = homepg.editincidentfrm.verifyOutageState();
		Assert.assertTrue(state.equalsIgnoreCase("Investigating"),
				"Unable to verify state, Expected : " + "Investigating, Actual :" + state);
		// Final Verification
		test.log(LogStatus.PASS, "Validation for service outage state is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * This test is to validate SONG incident creation.
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 3)
	public void validateSONGIncidentCreation() throws InterruptedException {
		logger.info("***************************************************");
		logger.info("ServiceOutageTest - validateSONGIncidentCreation");
		logger.info("***************************************************");

		homepg.clickOncreateNewIncidentFullButton();
		incidentNumberText = homepg.createIncidentFrame.getIncidentNumberText();
		homepg.createIncidentFrame.setRequestFor(prop.getProperty("requestFor"));
		homepg.createIncidentFrame.selectOption(homepg.createIncidentFrame.category, "Application");
		homepg.createIncidentFrame.setShortDescription(prop.getProperty("shortDescription"));
		homepg.createIncidentFrame.selectOption(homepg.createIncidentFrame.subCategory,
				prop.getProperty("subCategory"));
		homepg.createIncidentFrame.setImpactValue();
		homepg.createIncidentFrame.setUrgencyValue();
		homepg.createIncidentFrame.setAssignedToValue(prop.getProperty("assignedToValue"));
		homepg.createIncidentFrame.selectBusinessServiceAltOtion();
		Thread.sleep(4000);
		homepg.createIncidentFrame.selectOption(homepg.createIncidentFrame.typeOfIssue,
				prop.getProperty("typeOfIssue"));
		Thread.sleep(2000);
		// Verify that the serviceOutage check box is visible
		Assert.assertTrue(homepg.editincidentfrm.serviceOutage_chkbox.isDisplayed(), serviceOutage_verify_failure);
		homepg.editincidentfrm.clickOnserviceOutage();
		Thread.sleep(2000);
		homepg.editincidentfrm.clickOnServiceOutageTab();
		homepg.editincidentfrm.selectOutageType(prop.getProperty("outageType"));
		homepg.editincidentfrm.selectNoOfUser(prop.getProperty("noofuser"));
		homepg.gethelponincdntfrm.contextClick();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.saveContextBtn);
		homepg.editincidentfrm.closeAlert();
		Thread.sleep(2000);
		homepg.createIncidentFrame.click(homepg.editincidentfrm.SONGS_preview_ok_button);

		Assert.assertTrue(homepg.editincidentfrm.outageAnnouncMsg.isDisplayed(),
				"Outage Announcement message is not displaying");

		// Final Verification
		test.log(LogStatus.PASS, "Validation for SONG incident creation is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * This test is to verify Edit SONG incident functionality.
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 4)
	public void editSONGIncident() throws InterruptedException {
		logger.info("*********************************");
		logger.info("ServiceOutageTest - editSONGIncident");
		logger.info("*********************************");

		homepg.clickOnOpenIncident_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incidentNumberText,
				homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		// homepg.gethelponincdntfrm.switchIncidentView("DEFAULT");
		homepg.editincidentfrm.selectOutageType(prop.getProperty("updateOutageType"));
		homepg.editincidentfrm.selectNoOfUser(prop.getProperty("updateNoOfUser"));
		homepg.gethelponincdntfrm.contextClick();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.saveContextBtn);
		homepg.editincidentfrm.closeAlert();
		Thread.sleep(2000);
		homepg.createIncidentFrame.click(homepg.editincidentfrm.SONGS_preview_ok_button);

		Assert.assertTrue(homepg.editincidentfrm.outageAnnouncMsg.isDisplayed(),
				"Outage Announcement message is not displaying");

		// Final Verification
		test.log(LogStatus.PASS, "Validation for edit existing SONG incident is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * This test is to verify Close existing SONG incident functionality.
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 5)
	public void closeSONGIncident() throws InterruptedException {
		logger.info("*********************************");
		logger.info("ServiceOutageTest - closeSONGIncident");
		logger.info("*********************************");

		homepg.clickOnOpenIncident_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incidentNumberText,
				homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		homepg.gethelponincdntfrm.changeState("RESOLVED");
		homepg.gethelponincdntfrm.click(homepg.editincidentfrm.closureInfoTab);
		homepg.gethelponincdntfrm.enterCloseNotes();
		homepg.gethelponincdntfrm.closeCode("CANCELLED");

		homepg.gethelponincdntfrm.click(homepg.editincidentfrm.notesTab);
		homepg.gethelponincdntfrm.enterAddCommText();

		homepg.editincidentfrm.clickOnServiceOutageTab();
		homepg.editincidentfrm.selectOutageCause(prop.getProperty("outageCause"));
		homepg.editincidentfrm.selectoutageRecovery(prop.getProperty("recoveryValue"));
		homepg.editincidentfrm.closeAlert();
		homepg.gethelponincdntfrm.contextClick();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.saveContextBtn);
		Thread.sleep(1000);
		try {
			homepg.editincidentfrm.cloeAlert2();
			Thread.sleep(1000);
			homepg.editincidentfrm.cloeAlert2();
			Thread.sleep(1000);
			homepg.createIncidentFrame.click(homepg.editincidentfrm.SONGS_preview_ok_button);
			homepg.editincidentfrm.cloeAlert2();
		} catch (Exception e) {
			System.out.println(e);
		}
		Assert.assertEquals(homepg.gethelponincdntfrm.getText(homepg.editincidentfrm.songIncResolvedMsg2),
				prop.getProperty("incResolvedMsg1") + " " + incidentNumberText + " "
						+ (prop.getProperty("incResolvedMsg2")),
				"Problem occurred while resolving the incident.");

		Assert.assertTrue(homepg.editincidentfrm.outageAnnouncMsg2.isDisplayed(),
				"Outage Announcement message is not displaying");

		// Final Verification
		test.log(LogStatus.PASS, "Validation for close existing SONG incident is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}
}