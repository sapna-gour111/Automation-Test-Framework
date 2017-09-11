package com.servicenow.testscripts;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.servicenow.pageobjects.CreateIncidentFrame;
import com.servicenow.pageobjects.HomePage;
import com.servicenow.utils.Constants;
import com.servicenow.utils.ExcelReader;
import com.servicenow.utils.PropertiesLoader;
import com.servicenow.utils.ToolUtils;

/**
 * This class contains basic regression test cases.
 * 
 * @author Sapna Gour
 *
 */
public class RegressionTest extends BaseTest {

	HomePage homepg;
	ExcelReader readData;
	static String incidentNo;
	static String incidentNumberText;
	static String changeNumberText;
	static PropertiesLoader prop = new PropertiesLoader(Constants.PROPERTY_FILE_PATH);

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
	 * Test Case No: 1. Module/Application name: ESS - Employee Self Service
	 * Description: Validate ESS "Get Help" HAL IT end user properly creates an
	 * Incident for HAL IT Business Services
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	public void verifyIncidentCreationForHALITUserAndBussServ() throws InterruptedException {
		logger.info("*****************************************************************");
		logger.info("RegressionTest - verifyIncidentCreationForHALITUserAndBussServ");
		logger.info("*****************************************************************");

		homepg.clickOnGetHelpOnNewIncidentButton();
		homepg.change.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.clickOnSubmitButton();
		Assert.assertEquals(homepg.change.closeAlertAndGetItsText(), prop.getProperty("essMandatoryFldErrMsg"));
		homepg.gethelponincdntfrm.selectOptionFromClassified();
		Thread.sleep(2000);
		homepg.gethelponincdntfrm.selectExpainationPhrase();
		homepg.gethelponincdntfrm.describeIssue();
		homepg.gethelponincdntfrm.clickOnSubmitButton();
		String appendedMessage = prop.getProperty("incidentOpenedMsg") + "\n" + prop.getProperty("serviceDeskMsg")
				+ "\n" + prop.getProperty("incidentTrackMsg");
		incidentNo = homepg.gethelponincdntfrm.getAttributeValue(homepg.gethelponincdntfrm.incidentNumber);
		Assert.assertEquals(homepg.gethelponincdntfrm.verifyIncidentMessages(), appendedMessage,
				"Failed to verify incident messages");

		// Final Verification
		test.log(LogStatus.PASS, "The test has passed.");
		test.log(LogStatus.PASS,
				"Validation for Incident creation for HAL IT end user and business services is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");

	}

	/**
	 * Test Case No: 2. Module/Application name: ESS - Employee Self Service
	 * Description: Validate End User has access to existing tickets. Validate
	 * End User has access to different modules.
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2, dataProvider = "ModuleVerifications")
	public void verifyModuleAcccessToEndUser(String homePageModuleName, String getHelpOnNewIncident, String knowledge,
			String serviceCatalog, String connectChat, String myIncident, String myRequestedItems, String myApprovals,
			String watchedIncident, String watchedRequestedItems, String myProfile, String myTaggedDocuments,
			String takeSurvey, String chat, String liveFeed, String myNotificationPreferences, String coordinatorTask)
			throws InterruptedException {
		logger.info("*****************************************************************");
		logger.info("RegressionTest - verifyModuleAcccessToEndUser");
		logger.info("*****************************************************************");

		// Click on LHS Self-Service > Expand/collapse button
		homepg.expandTopMenu("Self-Service");
		Thread.sleep(3000);
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
		homepg.clickOnMyIncidentButton();
		homepg.gethelponincdntfrm.searchIncidentNumber(incidentNo, homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		homepg.gethelponincdntfrm.switchIncidentView("DEFAULT");
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		Thread.sleep(1000);
		homepg.createIncidentFrame.selectOption(homepg.createIncidentFrame.category2, "Network");
		Thread.sleep(1000);
		homepg.gethelponincdntfrm.switchIncidentView("SELF SERVICE");
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.enterAddCommText();
		Thread.sleep(2000);
		Assert.assertEquals(homepg.gethelponincdntfrm.addCommText.getText(), prop.getProperty("addComment"),
				"Failed to verify additional comment field is editable");
		homepg.clickOnMyIncidentButton();
		Thread.sleep(2000);
		homepg.gethelponincdntfrm.searchIncidentNumber(incidentNo, homepg.gethelponincdntfrm.incidentNumberSearchBox);
		Thread.sleep(2000);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		Thread.sleep(2000);
		Assert.assertEquals(incidentNo, homepg.createIncidentFrame.getIncidentNumber(), "Not able to create Incident");
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(4000);
		Assert.assertTrue(homepg.gethelponincdntfrm.incNo_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.reqFor_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.opened_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.state_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.watchList_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.shortDesc_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.subState_lbl.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "The test has passed.");
		test.log(LogStatus.PASS, "Validation for Modules/Applications available for HAL IT end user is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Test Case No: 3. Module/Application name: Incident Ticket Description:
	 * Validate HAL IT Business Services incident ticket
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 3, dataProvider = "Create New Incident")
	public void verifyIncidentCreationFromAppl(String category, String businessService, String shortDescription)
			throws InterruptedException, AWTException {
		logger.info("*****************************************************************");
		logger.info("RegressionTest - verifyHEUIncidentCreationFromAppl");
		logger.info("*****************************************************************");

		homepg.switchToDefaultContent();
		homepg.clickOncreateNewIncidentFullButton();
		incidentNumberText = homepg.createIncidentFrame.getIncidentNumberText();
		homepg.createIncidentFrame.setRequestFor(prop.getProperty("requestFor"));
		homepg.createIncidentFrame.selectOption(homepg.createIncidentFrame.category, category);
		homepg.createIncidentFrame.setShortDescription(prop.getProperty("shortDescription"));
		homepg.createIncidentFrame.selectOption(homepg.createIncidentFrame.subCategory,
				prop.getProperty("subCategory"));
		homepg.createIncidentFrame.setImpactValue();
		homepg.createIncidentFrame.setUrgencyValue();
		homepg.createIncidentFrame.setAssignedToValue(prop.getProperty("assignedToValue"));
		homepg.createIncidentFrame.selectBusinessService(businessService);
		Thread.sleep(4000);
		homepg.createIncidentFrame.selectOption(homepg.createIncidentFrame.typeOfIssue,
				prop.getProperty("typeOfIssue"));
		Thread.sleep(2000);
		homepg.gethelponincdntfrm.contextClick();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.saveContextBtn);
		homepg.clickOnOpenIncident_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incidentNumberText,
				homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		Assert.assertTrue(homepg.createIncidentFrame.incRow.isDisplayed(), "Not able to create Incident");

		// Final Verification
		test.log(LogStatus.PASS, "The test has passed.");
		test.log(LogStatus.PASS,
				"Validation for Incident creation for HAL IT end user and business services is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Test Case No: 1. Module/Application name: Incident Ticket Description:
	 * Validate HAL IT Business Services incident ticket. Mandatory field check
	 * for Incident
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 4)
	public void mandatoryFileldCheckForIncident() throws InterruptedException {
		logger.info("*****************************************************************");
		logger.info("RegressionTest - mandatoryFileldCheckForIncident");
		logger.info("*****************************************************************");

		homepg.clickOncreateNewIncidentFullButton();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.createIncidentFrame.clickOnSubmitBtn();
		Assert.assertEquals(homepg.createIncidentFrame.closeAlertAndGetItsText(), prop.getProperty("incidentErrMsg"));

		// Final Verification
		test.log(LogStatus.PASS, "The test has passed.");
		test.log(LogStatus.PASS, "Validation for mandatory field check on Incident.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 *** Test Case No: 3. Module/Application name: Incident Ticket Description:
	 * Validate HAL IT Business Services incident ticket. Decorative icon check
	 * for Incident
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws AWTException
	 */
	@Test(priority = 5)
	public void dacorativeIconCheckForIncident() throws InterruptedException {
		logger.info("*****************************************************************");
		logger.info("RegressionTest - dacorativeIconCheckForIncident");
		logger.info("*****************************************************************");

		homepg.clickOnOpenIncident_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incidentNumberText,
				homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.switchIncidentView("DEFAULT");
		Thread.sleep(3000);
		Assert.assertTrue(homepg.createIncidentFrame.assignGroup.isDisplayed(), "Assignment group is not displaying.");
		Assert.assertTrue(homepg.createIncidentFrame.businessSer.isDisplayed(), "Business service is not displaying.");
		Assert.assertTrue(homepg.createIncidentFrame.suggestionIcon.isDisplayed(),
				"Suggestion icon is not displaying.");
		Assert.assertTrue(homepg.createIncidentFrame.searchKnow.isDisplayed(),
				"Search knowledge icon is not displaying.");
		Assert.assertTrue(homepg.createIncidentFrame.addMe.isDisplayed(), "Add Me icon is not displaying.");
		Assert.assertTrue(homepg.createIncidentFrame.workNoteList.isDisplayed(),
				"work note list icon is not displaying.");
		Assert.assertTrue(homepg.createIncidentFrame.workNoteGroup.isDisplayed(),
				"Worknote group icon is not displaying.");
		Assert.assertTrue(homepg.createIncidentFrame.watchList.isDisplayed(), "Watch icon is not displaying.");
		Assert.assertTrue(homepg.createIncidentFrame.watchListGroup.isDisplayed(),
				"Watch list group icon is not displaying.");

		// Final Verification
		test.log(LogStatus.PASS, "The test has passed.");
		test.log(LogStatus.PASS, "Validation for decorative icon check on Incident.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Test Case No: 5, 8. Module/Application name: Incident Ticket Description:
	 * Validate Incident ticket escalation to CHG ticket. Taking incident which
	 * is already created using above test cases. Validate HAL IT RFC from INC
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 6, dataProvider = "Create New Incident", dependsOnMethods = "verifyIncidentCreationFromAppl")
	public void VerifyChangeRequestCreation(String category, String businessService, String shortDescription)
			throws InterruptedException {
		logger.info("*****************************************************************");
		logger.info("RegressionTest - VerifyChangeRequestCreation");
		logger.info("*****************************************************************");

		homepg.clickOnOpenIncident_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incidentNumberText,
				homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.switchIncidentView("FAST VIEW");
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.contextClick();
		homepg.change.createChange();
		Thread.sleep(1000);
		homepg.gethelponincdntfrm.selectChangeType("STANDARD");
		changeNumberText = homepg.change.getChangeNumberText();
		homepg.change.enterChangeManager();
		homepg.change.enterServiceOwner();
		Thread.sleep(2000);
		homepg.change.clickOnScheduleTab();
		homepg.change.enterDatesAndChangeDetails();
		Assert.assertEquals(homepg.change.changeRequestForFromApp.getAttribute("value"), prop.getProperty("requestFor"),
				"Request for field is not matching with incident field");
		Assert.assertEquals(homepg.change.changeCompany.getAttribute("value"), prop.getProperty("company"),
				"Company field is not matching with incident field");
		Assert.assertEquals(homepg.change.changeLocation.getAttribute("value"), prop.getProperty("location"),
				"Location field is not matching with incident field");
		Assert.assertEquals(homepg.change.changeDepartment.getAttribute("value"), prop.getProperty("department"),
				"Department field is not matching with incident field");
		Assert.assertEquals(homepg.change.changeCategory.getAttribute("value"), prop.getProperty("catagory"),
				"Category field is not matching with incident field");
		Assert.assertEquals(homepg.change.changeAssignGroup.getAttribute("value"), prop.getProperty("assignmentGroup"),
				"Assignment group field is not matching with incident field");
		Assert.assertEquals(homepg.change.changeBussService.getAttribute("value"), prop.getProperty("businessService"),
				"Business Service field is not matching with incident field");
		Assert.assertEquals(homepg.change.changeShortDesc.getAttribute("value"), shortDescription,
				"Short Description field is not matching with incident field");
		homepg.change.enterDesc();
		homepg.gethelponincdntfrm.contextClick();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.saveContextBtn);
		Thread.sleep(2000);

		// Final Verification
		test.log(LogStatus.PASS, "The test has passed.");
		test.log(LogStatus.PASS, "Validation for Change Request Creation is successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Test Case No: 6, 8. Module/Application name: Change Application
	 * Description: Validate HAL IT Business Services Change Management WF
	 * working. Validate HAL IT RFC from INC
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 7, dependsOnMethods = "VerifyChangeRequestCreation")
	public void VerifyStandardChangeWF() throws InterruptedException {
		logger.info("*****************************************************************");
		logger.info("RegressionTest - VerifyStandardChangeWF");
		logger.info("*****************************************************************");

		homepg.clickOnChange();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.change.changeAllLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(changeNumberText, homepg.change.changeSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(4000);
		homepg.change.clickOnchangeTask();
		Assert.assertTrue(homepg.change.cTaskLink.isDisplayed(), "CTASK is not displaying.");
		homepg.change.closeCTask();
		homepg.change.selectRequestedCTasks("Approved");
		homepg.change.selectRequestedCTasks("Approved");
		homepg.change.closeCTask();
		homepg.change.selectRequestedCTasks("Approved");
		homepg.change.selectRequestedCTasks("Approved");
		homepg.change.selectRequestedCTasks("Approved");
		homepg.change.closeCTask();
		Assert.assertEquals(homepg.change.changedisabledState.getAttribute("disabled"), "true",
				"Change workflow is not completed properly.");

		// Final Verification
		test.log(LogStatus.PASS, "The test has passed.");
		test.log(LogStatus.PASS, "Validation for Standard Change workflow is successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Test Case No: 7. Module/Application name: Change Application Description:
	 * Validate HAL IT Business Services Change Management WF working
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 8)
	public void createAndVerifyChangeFromApp() throws InterruptedException {
		logger.info("*****************************************************************");
		logger.info("RegressionTest - createAndVerifyChangeFromApp");
		logger.info("*****************************************************************");

		homepg.createChange();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.change.selectChangeTypeFromApp(homepg.change.selectChangeType_Link);
		homepg.change.enterChangeDetailsFromApp();
		homepg.gethelponincdntfrm.contextClick();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.saveContextBtn);
		homepg.gethelponincdntfrm.click(homepg.change.changeTaskTab);
		Assert.assertEquals(homepg.change.cTaskAssGroup.getText(), prop.getProperty("assignmentGroup"),
				"Assignment group of Change Request and CTask is not matching.");
		Assert.assertEquals(homepg.change.cTaskAssiTo.getText(), prop.getProperty("requestFor"),
				"Assign to field of Change Request and CTask is not matching.");
		homepg.change.closeCTask();
		homepg.change.selectRequestedCTasks("Approved");
		homepg.change.selectRequestedCTasks("Approved");
		homepg.change.closeCTask();
		homepg.change.selectRequestedCTasks("Approved");
		homepg.change.selectRequestedCTasks("Approved");
		homepg.change.selectRequestedCTasks("Approved");
		homepg.change.closeCTask();
		Assert.assertEquals(homepg.change.changedisabledState.getAttribute("disabled"), "true",
				"Change workflow is not completed properly.");

		// Final Verification
		test.log(LogStatus.PASS, "The test has passed.");
		test.log(LogStatus.PASS, "Validation for Standard Change creation from application is successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Test Case No: 9. Module/Application name: Change Application Description:
	 * Validate Rejection Process
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 9)
	public void verifyChangeRejectionProcess() throws InterruptedException {
		logger.info("*****************************************************************");
		logger.info("RegressionTest - verifyChangeRejectionProcess");
		logger.info("*****************************************************************");

		homepg.createChange();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.change.selectChangeTypeFromApp(homepg.change.selectChangeType_Link);
		homepg.change.enterChangeDetailsFromApp();
		homepg.gethelponincdntfrm.contextClick();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.saveContextBtn);
		homepg.change.closeCTask();
		homepg.change.selectRequestedCTasks("Approved");
		homepg.change.selectRequestedCTasks("Approved");
		homepg.change.closeCTask();
		homepg.change.selectRequestedCTasks("Rejected");

		Assert.assertEquals(homepg.change.getCTaskStatus(), "New",
				"Rejection from Functional Test is creating New CTask.");
		homepg.change.closeCTask();
		homepg.change.selectRequestedCTasks("Approved");
		homepg.change.selectRequestedCTasks("Approved");
		homepg.change.selectRequestedCTasks("Approved");
		homepg.change.selectRequestedCTasks("Approved");
		homepg.change.closeCTask();
		Assert.assertEquals(homepg.change.changedisabledState.getAttribute("disabled"), "true",
				"Change workflow is not completed properly.");

		// Final Verification
		test.log(LogStatus.PASS, "The test has passed.");
		test.log(LogStatus.PASS, "Validation for Change rejection process is successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Test Case No: 10. Module/Application name: Change Application
	 * Description: Validate Upgrade/down grade Process
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 10)
	public void verifyUpgradeDowngradeProcess() throws InterruptedException {
		logger.info("*****************************************************************");
		logger.info("RegressionTest - verifyUpgradeDowngradeProcess");
		logger.info("*****************************************************************");
		String changeNumber = "";
		homepg.createChange();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.change.selectChangeTypeFromApp(homepg.change.selectChangeType_Link);
		changeNumber = homepg.change.getChangeNumberText();
		homepg.change.enterChangeDetailsFromApp();
		homepg.gethelponincdntfrm.contextClick();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.saveContextBtn);
		homepg.change.upgradeDowngradeChange(homepg.change.upgradeDowngradeChange);
		homepg.closeAlert();
		homepg.gethelponincdntfrm.click(homepg.change.changeAllLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(changeNumber, homepg.change.changeSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(4000);
		Assert.assertEquals(homepg.change.upgradeDowngradeChangeType.getAttribute("value"),
				prop.getProperty("comprehensiveChange"), "Upgrade Change is not completed properly.");

		homepg.change.upgradeDowngradeChange(homepg.change.upgradeDowngradeChange);
		homepg.closeAlert();

		homepg.gethelponincdntfrm.click(homepg.change.changeAllLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(changeNumber, homepg.change.changeSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(4000);
		Assert.assertEquals(homepg.change.upgradeDowngradeChangeType.getAttribute("value"),
				prop.getProperty("standardChange"), "Downgrade Change is not completed properly.");
		homepg.createIncidentFrame.clearSearchEmails();
		// Final Verification
		test.log(LogStatus.PASS, "The test has passed.");
		test.log(LogStatus.PASS, "Validation for Change Upgrade/Downgrade process is successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Test Case No: 3,11. Module/Application name: Incident Ticket Description:
	 * Validate HAL IT Business Services incident ticket. Decorative icon
	 * functionality check for Incident Validating adding to Watch list and Work
	 * Notes
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 11)
	public void dacorativeIconFunctionCheckForIncident() throws InterruptedException, AWTException {
		logger.info("*****************************************************************");
		logger.info("RegressionTest - dacorativeIconFunctionCheckForIncident");
		logger.info("*****************************************************************");

		homepg.clickOnOpenIncident_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incidentNumberText,
				homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.createIncidentFrame.clickOnNotes();
		Assert.assertTrue(homepg.createIncidentFrame.watchListAddMe.isDisplayed(), "Add Me icon is not displaying.");
		homepg.gethelponincdntfrm.click(homepg.createIncidentFrame.addMe);
		homepg.gethelponincdntfrm.click(homepg.createIncidentFrame.searchKnow);
		Assert.assertEquals(
				homepg.createIncidentFrame
						.switchToChildWindowAndClose(homepg.createIncidentFrame.searchKnowledgeIconText),
				"Knowledge search results", "Short description - search knowledge icon is not working ");
		homepg.createIncidentFrame.switchToParentWindow();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.createIncidentFrame.addWatchUsers(homepg.createIncidentFrame.watchList,
				homepg.createIncidentFrame.lookUpWatchList, prop.getProperty("watchListUser"));
		homepg.createIncidentFrame.addWatchUsers(homepg.createIncidentFrame.watchListGroup,
				homepg.createIncidentFrame.lookUpwatchListGroup, prop.getProperty("watchListUserGroup"));
		Assert.assertEquals(homepg.createIncidentFrame.getValueFromCompanyIcon(), prop.getProperty("company"));
		homepg.change.clickOnBackButton();
		Thread.sleep(2000);
		homepg.gethelponincdntfrm.switchIncidentView("DEFAULT");
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.createIncidentFrame.assignGroup);
		Assert.assertEquals(
				homepg.createIncidentFrame
						.switchToChildWindowAndClose(homepg.createIncidentFrame.shortDescSuggIconText),
				"Search", "Assignment group dacorative icon is not working ");
		homepg.createIncidentFrame.switchToParentWindow();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		Assert.assertTrue(homepg.createIncidentFrame.businessSer.isDisplayed(),
				"Business service - Business Service Selection icon is not displaying");
		homepg.gethelponincdntfrm.click(homepg.createIncidentFrame.businessSer);
		Assert.assertEquals(homepg.createIncidentFrame.bussServSearCate.getText(),
				prop.getProperty("businesSersSelCatagory"), "Assignment group dacorative icon is not working ");
		homepg.createIncidentFrame.clickOnPopUp();
		Thread.sleep(2000);
		Assert.assertTrue(homepg.createIncidentFrame.suggestionIcon.isDisplayed(),
				"Suggestion icon is not displaying.");
		homepg.gethelponincdntfrm.click(homepg.createIncidentFrame.suggestionIcon);
		Assert.assertEquals(
				homepg.createIncidentFrame.switchToChildWindowAndClose(homepg.createIncidentFrame.assiGroupIconText),
				"Label", "Short description suggestion icon is not working ");
		homepg.createIncidentFrame.switchToParentWindow();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		Assert.assertTrue(homepg.createIncidentFrame.searchKnow.isDisplayed(),
				"Search knowledge icon is not displaying.");
		Assert.assertTrue(homepg.createIncidentFrame.watchListUser.isDisplayed(),
				"Added watch list user is not working.");
		Assert.assertTrue(homepg.createIncidentFrame.workNoteListUser.isDisplayed(),
				"work note list icon is not working.");
		Assert.assertTrue(homepg.createIncidentFrame.workNoteGroup.isDisplayed(),
				"Work note group icon is not displaying.");
		Assert.assertTrue(homepg.createIncidentFrame.watchListGroup.isDisplayed(),
				"Watch list group icon is not displaying.");
		homepg.createIncidentFrame.searchEmails();
		homepg.createIncidentFrame.searchLogs(incidentNumberText);
		Assert.assertTrue(homepg.createIncidentFrame.workNoteUsrAddedMsg.isDisplayed());
		Assert.assertTrue(homepg.createIncidentFrame.watchNoteUsrAddedMsg.isDisplayed());
		Assert.assertTrue(homepg.createIncidentFrame.watchNoteUsrAddedMsg2.isDisplayed());
		homepg.createIncidentFrame.clearSearchEmails();

		// Final Verification
		test.log(LogStatus.PASS, "The test has passed.");
		test.log(LogStatus.PASS, "Validation for decorative icon check on Incident.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Test Case No: 4. Module/Application name: Incident Ticket Description:
	 * Validating Resolution of Incident Ticket. Taking incident which is
	 * already created using above test cases.
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	@Test(priority = 12, dependsOnMethods = "verifyIncidentCreationFromAppl")
	public void VerifyIncidentCloseFunctionality() throws InterruptedException {
		logger.info("*****************************************************************");
		logger.info("RegressionTest - VerifyIncidentCloseFunctionality");
		logger.info("*****************************************************************");

		homepg.clickOnOpenIncident_Button();
		homepg.change.switchToDefaultiFrame();
		homepg.change.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incidentNumberText,
				homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.change.switchIncidentView("FAST VIEW");
		Thread.sleep(3000);
		homepg.change.changeState("RESOLVED");
		homepg.change.enterCloseNotes();
		homepg.change.additionalComment();
		homepg.change.closeCode("CANCELLED");
		homepg.gethelponincdntfrm.contextClick();
		homepg.change.click(homepg.gethelponincdntfrm.saveContextBtn);
		Assert.assertEquals(homepg.gethelponincdntfrm.getText(homepg.gethelponincdntfrm.resolvedMsg),
				prop.getProperty("incResolvedMsg1") + " " + incidentNumberText + " "
						+ (prop.getProperty("incResolvedMsg2")),
				"Problem occurred while resolving the incident.");

		// Final Verification
		test.log(LogStatus.PASS, "The test has passed.");
		test.log(LogStatus.PASS, "Validation for Incident closure functionality is successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	@DataProvider(name = "ModuleVerifications")
	public Object[][] ModuleVerifications() throws Exception {
		readData = new ExcelReader();
		Object[][] retObjArr = readData.excelRead("ServiceNow_TestData.xlsx", "SelfService");
		return retObjArr;
	}

	@DataProvider(name = "Create New Incident")
	public Object[][] CreateNewIncident() throws Exception {
		readData = new ExcelReader();
		Object[][] retObjArr = readData.excelRead("ServiceNow_TestData.xlsx", "CreateNewIncident");
		return retObjArr;
	}
}
