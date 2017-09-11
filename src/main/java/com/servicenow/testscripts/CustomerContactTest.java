package com.servicenow.testscripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.servicenow.pageobjects.HomePage;
import com.servicenow.utils.ExcelReader;
import com.servicenow.utils.ToolUtils;

/**
 * This class contains methods to perform test actions
 * 
 * @author Sapna Gour
 *
 */

public class CustomerContactTest extends BaseTest {

	HomePage homepg;
	ExcelReader readData;

	/**
	 * Setup method to create base for all subsequent test methods
	 * 
	 * @param browser
	 *            - Browser Name
	 */
	public static Logger logger = LogManager.getLogger();

	final String serviceOutage_verify_failure = "Unable to verify that the serviceOutage checkbox is displayed.";

	@BeforeClass
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) throws Exception {
		super.setUp(browser, this.getClass().getSimpleName());
		homepg = new HomePage(driver);
	}

	/**
	 * Row 43
	 * 
	 * Test Scenario : Customer Contact for SONGS Test Steps : 1. Login with
	 * user of group "SONGS ESS User". 2. Go to Incident -> Open. 3. View any
	 * existing incident where customer contact is empty 4. Check flag Service
	 * Outage Customer Contact's should be updated as current logged in user
	 */
	@Test(dataProvider = "Customer Contact Validations", priority = 1)
	public void verifyCustomerContactForServiceOutage(String incidentid, String expected_email)
			throws InterruptedException {
		logger.info("*********************************");
		logger.info("CustomerContactTest - verifyCustomerContactForServiceOutage");
		logger.info("*********************************");
		// Click on LHS Incident > Open
		homepg.clickOnOpenIncident_Button();
		Thread.sleep(10000);
		// Click on an Incident Number
		homepg.incidentopenfrm.clickOnIncidentNo(incidentid);
		Thread.sleep(10000);
		// Check flag Service Outage
		homepg.editincidentfrm.clickOnserviceOutage();
		Thread.sleep(10000);
		// Verify Customer Contact's should be updated as current logged in user
		temp = homepg.editincidentfrm.getcustomerContact();
		Assert.assertTrue(temp.toLowerCase().contains(expected_email.toLowerCase()),
				"Unable to verify the Customer Contact, Actual : " + temp + " , Expected : " + expected_email);
		// Final Verification
		test.log(LogStatus.PASS, "Test for validating contact for service outage is successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Row 59
	 * 
	 * Test Scenario : SONGS V3 Test Steps : 1. Login with user of group
	 * "SONGS ESS User". 2. Go to Incident -> Open. 3. View any existing
	 * incident where customer contact is empty 4. Check flag Service Outage
	 * Customer Contact's should be updated as current logged in user
	 */
	@Test(dataProvider = "Business Service Attribute Validations", priority = 2)
	public void verifyBusinessServiceMandatoryTest(String incidentid, String param) throws InterruptedException {
		logger.info("*********************************");
		logger.info("CustomerContactTest - verifyBusinessServiceMandatoryTest");
		logger.info("*********************************");
		// Click on LHS Incident > Open
		homepg.clickOnOpenIncident_Button();
		Thread.sleep(10000);
		// Click on an Incident Number
		homepg.incidentopenfrm.clickOnIncidentNo(incidentid);
		Thread.sleep(10000);
		homepg.editincidentfrm.clearBusinessService();
		homepg.switchToDefaultContent();
		homepg.editincidentfrm.clickOnconfigurationItem();
		Thread.sleep(20000);
		homepg.editincidentfrm.clickOnUpdateIncident();
		Thread.sleep(10000);
		temp = homepg.editincidentfrm.closeAlertAndGetItsText();
		Assert.assertTrue(temp.toLowerCase().contains("business service"),
				"Unable to verify Manadatory field Business Service, Actual : " + temp);
		test.log(LogStatus.PASS, "Test for validating business service mandatory fields is successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Row 61
	 * 
	 * Test Scenario : SONGS V3 Test Steps: 1. Login with user of group
	 * "SONGS ESS User". 2. Go to ESS view of Incident list (Self Service-> My
	 * Incidents). 3. Open existing SONGS incident and see Service Outage
	 * section Impacted Company attribute will be visible and it is not set as
	 * mandatory
	 */
	@Test(dataProvider = "Outage Company Attribute Validations", priority = 3)
	public void outageCompanyAttributeTest(String incidentid, String param) throws InterruptedException {
		logger.info("*********************************");
		logger.info("CustomerContactTest - outageCompanyAttributeTest");
		logger.info("*********************************");
		// Click on LHS Incident > Open
		homepg.clickOnOpenIncident_Button();
		Thread.sleep(10000);
		// Click on an Incident Number
		homepg.incidentopenfrm.clickOnIncidentNo(incidentid);
		Thread.sleep(10000);
		// Click on flag Service Outage
		homepg.editincidentfrm.clickOnserviceOutage();
		Thread.sleep(10000);
		// Click on Service Outage Tab
		homepg.editincidentfrm.clickOnServiceOutageTab();
		Thread.sleep(5000);
		Assert.assertTrue(homepg.editincidentfrm.impactedCompany_txt.isDisplayed(),
				"Unable to verify field Impacted Company is visible.");
		temp = homepg.editincidentfrm.impactedCompany_txt.getAttribute("mandatory");
		Assert.assertTrue(temp == null, "Unable to verify field Impacted Company is Mandatory.");
		test.log(LogStatus.PASS, "Test for validating outage company attribute is successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	@DataProvider(name = "Customer Contact Validations")
	public Object[][] CustomerContactForServiceOutageValidations() throws Exception {
		readData = new ExcelReader();
		Object[][] retObjArr = readData.excelRead("ServiceNow_TestData.xlsx", "CustomerContact");
		return retObjArr;
	}

	@DataProvider(name = "Business Service Attribute Validations")
	public Object[][] BusinessServiceMandatoryTest() throws Exception {
		readData = new ExcelReader();
		Object[][] retObjArr = readData.excelRead("ServiceNow_TestData.xlsx", "BusinessService");
		return retObjArr;
	}

	@DataProvider(name = "Outage Company Attribute Validations")
	public Object[][] OutageCompanyAttributeTest() throws Exception {
		readData = new ExcelReader();
		Object[][] retObjArr = readData.excelRead("ServiceNow_TestData.xlsx", "OutageCompany");
		return retObjArr;
	}
}