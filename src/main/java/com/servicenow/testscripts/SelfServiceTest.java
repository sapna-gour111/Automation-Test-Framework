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
import com.servicenow.utils.Constants;
import com.servicenow.utils.ExcelReader;
import com.servicenow.utils.PropertiesLoader;
import com.servicenow.utils.ToolUtils;

/**
 * This class contains test cases for Self-Service module
 */
public class SelfServiceTest extends BaseTest {
	static PropertiesLoader prop = new PropertiesLoader(Constants.PROPERTY_FILE_PATH);
	String incidentNo = null;
	HomePage homepg;
	ExcelReader readData;
	public static Logger logger = LogManager.getLogger();

	/**
	 * Setup method to create base for all subsequent test methods
	 * 
	 * @param browser-
	 *            Browser Name
	 */
	@BeforeClass
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) throws Exception {
		super.setUp(browser, this.getClass().getSimpleName());
		homepg = new HomePage(driver);
	}

	/**
	 * Self Service:Test Case No-1 Verify modules available under Self-Service
	 * link
	 * 
	 * @param homePageModuleName
	 * @param getHelpOnNewIncident
	 * @param knowledge
	 * @param serviceCatalog
	 * @param connectChat
	 * @param myIncident
	 * @param myRequestedItems
	 * @param myApprovals
	 * @param watchedIncident
	 * @param watchedRequestedItems
	 * @param myProfile
	 * @param myTaggedDocuments
	 * @param takeSurvey
	 * @param chat
	 * @param liveFeed
	 * @param myNotificationPreferences
	 * @param coordinatorTask
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "Self-Service Validations", priority = 1)
	public void verifyAvailableModulesForSelfService(String homePageModuleName, String getHelpOnNewIncident,
			String knowledge, String serviceCatalog, String connectChat, String myIncident, String myRequestedItems,
			String myApprovals, String watchedIncident, String watchedRequestedItems, String myProfile,
			String myTaggedDocuments, String takeSurvey, String chat, String liveFeed, String myNotificationPreferences,
			String coordinatorTask) throws InterruptedException {
		logger.info("*********************************");
		logger.info("SelfServiceTest - verifyAvailableModulesForSelfService");
		logger.info("*********************************");
		// Click on LHS Self-Service > Expand/collapse button
		homepg.expandTopMenu("Self-Service");
		Thread.sleep(10000);
		// Verify modules available after expanding Self-Service link
		Assert.assertEquals(homepg.homePage_Btn.getText(), homePageModuleName,
				"Homepage module is not displaying under self service");
		Assert.assertEquals(homepg.getHelpOnNewIncident_Btn.getText(), getHelpOnNewIncident,
				"Get help on new incident module is not displaying under self service");
		Assert.assertEquals(homepg.knowledge_Btn.getText(), knowledge,
				"Knowledge module is not displaying under self service");
		Assert.assertEquals(homepg.serviceCatalog_Btn.getText(), serviceCatalog,
				"Service Catelog module is not displaying under self service");
		Assert.assertEquals(homepg.myIncident_Btn.getText(), myIncident,
				"My incident module is not displaying under self service");
		Assert.assertEquals(homepg.myRequestedItems_Btn.getText(), myRequestedItems,
				"My requested items module is not displaying under self service");
		Assert.assertEquals(homepg.myApprovals_Btn.getText(), myApprovals,
				"My approvals module is not displaying under self service");
		Assert.assertEquals(homepg.watchedIncident_Btn.getText(), watchedIncident,
				"Watched incident module is not displaying under self service");
		Assert.assertEquals(homepg.watchedRequestedItems_Btn.getText(), watchedRequestedItems,
				"Watched requested items module is not displaying under self service");
		Assert.assertEquals(homepg.myProfile_Btn.getText(), myProfile,
				"My profile module is not displaying under self service");
		Assert.assertEquals(homepg.takeSurvey_Btn.getText(), takeSurvey,
				"Take survey module is not displaying under self service");
		Assert.assertEquals(homepg.chat_Btn.getText(), chat, "Chat module is not displaying under self service");
		Assert.assertEquals(homepg.liveFeed_Btn.getText(), liveFeed,
				"Live feed module is not displaying under self service");
		Assert.assertEquals(homepg.coordinatorTask_Btn.getText(), coordinatorTask,
				"Co-ordinator task module is not displaying under self service");
		// Final Verification
		test.log(LogStatus.PASS, "Validation for available modules for Self-Service is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Self Service:Test Case No-2 Verify classified available for
	 * "Get help on a new incident".Also, it verifies explanation phrases
	 * available for selected classified
	 * 
	 * @throws InterruptedException
	 * @throws Exception
	 */
	@Test(priority = 2)
	public void verifyChoicesForClassificationAndExplaination() throws InterruptedException {

		logger.info("*********************************");
		logger.info("SelfServiceTest - verifyChoicesForClassificationAndExplaination");
		logger.info("*********************************");
		// Click on LHS Self-Service > Get help on a new incident
		homepg.clickOnGetHelpOnNewIncidentButton();
		Thread.sleep(10000);
		// Verify classified available for Get help on a new incident
		Assert.assertTrue(
				homepg.gethelponincdntfrm.getOptionsForList(homepg.gethelponincdntfrm.selectClassification_Btn)
						.containsAll(Constants.CLASSIFICATION_OPTIONS),
				"Failed to verify available classification options");
		// Select any classified
		homepg.gethelponincdntfrm.selectOptionFromClassified();
		Thread.sleep(10000);
		// Verify available phrases for selected classified
		Assert.assertTrue(homepg.gethelponincdntfrm.getOptionsForList(homepg.gethelponincdntfrm.explainationPhrases)
				.containsAll(Constants.EXPLAINATION_PHRASES), "Failed to verify available explaination phrases");
		test.log(LogStatus.PASS, "Validation for choices available for classification and explaination is successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Self Service:Test Case No-3 and 4. Enter details and submit incident and
	 * Verify submitted incident.
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 3)
	public void verifySubmitIncident() throws InterruptedException {
		logger.info("*********************************");
		logger.info("SelfServiceTest - verifySubmitIncident");
		logger.info("*********************************");
		// Click on LHS Self-Service > Get help on a new incident
		homepg.clickOnGetHelpOnNewIncidentButton();
		Thread.sleep(15000);
		homepg.gethelponincdntfrm.selectOptionFromClassified();
		Thread.sleep(5000);
		homepg.gethelponincdntfrm.selectExpainationPhrase();
		Thread.sleep(5000);
		homepg.gethelponincdntfrm.describeIssue();
		Thread.sleep(5000);
		homepg.gethelponincdntfrm.clickOnSubmitButton();
		Thread.sleep(20000);
		Assert.assertEquals(homepg.gethelponincdntfrm.verifyStateOnewIncident(), prop.getProperty("incidentStatus"),
				"Failed to verify incident status");
		String appendedMessage = prop.getProperty("incidentOpenedMsg") + "\n" + prop.getProperty("serviceDeskMsg")
				+ "\n" + prop.getProperty("incidentTrackMsg");
		incidentNo = homepg.gethelponincdntfrm.getAttributeValue(homepg.gethelponincdntfrm.incidentNumber);
		Assert.assertEquals(homepg.gethelponincdntfrm.verifyIncidentMessages(), appendedMessage,
				"Failed to verify incident messages");
		test.log(LogStatus.PASS, "Validation for submit incident and message,status verification is successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Self Service:Test Case No-5. Verify fields present on recently created
	 * incident
	 * 
	 * @throws InterruptedException
	 * 
	 */
	@Test(dependsOnMethods = { "verifySubmitIncident" }, priority = 4)
	public void verifyIncidentFields() throws InterruptedException {
		logger.info("*********************************");
		logger.info("SelfServiceTest - verifyIncidentFields");
		logger.info("*********************************");
		// Click on LHS Self-Service > Get help on a new incident
		homepg.clickOnMyIncidentButton();
		Thread.sleep(20000);
		homepg.gethelponincdntfrm.searchIncidentNumber(incidentNo, homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(20000);
		homepg.gethelponincdntfrm.editNumberFld();
		homepg.gethelponincdntfrm.editReqForFld();
		homepg.gethelponincdntfrm.editWatchList();
		homepg.gethelponincdntfrm.enterShortDesc();
		homepg.gethelponincdntfrm.enterAddCommText();
		homepg.gethelponincdntfrm.clickOnUpdateIncident();
		homepg.closeAlert();
		Assert.assertEquals(homepg.gethelponincdntfrm.getAttributeValue(homepg.gethelponincdntfrm.incidentNumber),
				prop.getProperty("numberFld"), "Failed to verify number field is editable");
		Assert.assertEquals(homepg.gethelponincdntfrm.getAttributeValue(homepg.gethelponincdntfrm.requestForFld),
				prop.getProperty("requestForFld"), "Failed to verify request for field is editable");
		Assert.assertEquals(homepg.gethelponincdntfrm.addedWatchList.getText(), prop.getProperty("watchListText"), "");
		Assert.assertEquals(homepg.gethelponincdntfrm.getAttributeValue(homepg.gethelponincdntfrm.shortDesc),
				prop.getProperty("shortDesc"), "Failed to verify short description field is editable");
		Assert.assertEquals(homepg.gethelponincdntfrm.addCommText.getText(), prop.getProperty("addComment"),
				"Failed to verify additional comment");
		test.log(LogStatus.PASS, "Validation for submit incident and message,status verification is successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Self Service:Test Case No-6. Verify fields present in context menu when
	 * user right clicks on header of recently created incident
	 * 
	 * @throws InterruptedException
	 */
	@Test(dependsOnMethods = { "verifySubmitIncident" }, priority = 5)
	public void verifyContextMenuFields() throws InterruptedException {
		logger.info("*********************************");
		logger.info("SelfServiceTest - verifyContextMenuFields");
		logger.info("*********************************");
		// Click on LHS Self-Service > Expand/collapse button
		homepg.clickOnMyIncidentButton();
		Thread.sleep(20000);
		homepg.gethelponincdntfrm.searchIncidentNumber(incidentNo, homepg.gethelponincdntfrm.incidentNumberSearchBox);
		Thread.sleep(20000);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		Thread.sleep(20000);
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(30000);
		homepg.gethelponincdntfrm.contextClick();
		Assert.assertEquals(homepg.gethelponincdntfrm.saveContextBtn.getText(), prop.getProperty("saveContextButton"),
				"Save option is not present in context menu");
		Assert.assertEquals(homepg.gethelponincdntfrm.exportContextBtn.getText(),
				prop.getProperty("exportContextButton"), "Export option is not present in context menu");
		Assert.assertEquals(homepg.gethelponincdntfrm.copyURLContextBtn.getText(),
				prop.getProperty("copyURLContextButton"), "Copy URL option is not present in context menu");
		Assert.assertEquals(homepg.gethelponincdntfrm.reloadFormContextBtn.getText(),
				prop.getProperty("reloadFormContextButton"), "Reload form option is not present in context menu");
		Thread.sleep(10000);
		test.log(LogStatus.PASS, "Validation for submit incident and message,status verification is successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	@DataProvider(name = "Self-Service Validations")
	public Object[][] SelfServiceValidations() throws Exception {
		readData = new ExcelReader();
		Object[][] retObjArr = readData.excelRead("ServiceNow_TestData.xlsx", "SelfService");
		return retObjArr;
	}
}