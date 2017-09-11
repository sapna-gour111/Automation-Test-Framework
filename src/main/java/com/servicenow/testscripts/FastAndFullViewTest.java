package com.servicenow.testscripts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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

public class FastAndFullViewTest extends BaseTest {
	HomePage homepg;
	ExcelReader readData;
	static PropertiesLoader prop = new PropertiesLoader(Constants.PROPERTY_FILE_PATH);
	static String incNumber = "";
	static String incidentNumber = "";
	static String incNumberForFullView = "";

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
	 * Views : Test Case No-1. Verify modules available under fast view module
	 * 
	 */
	@Test(priority = 1)
	public void verifyAvailableModulesForFastView() throws InterruptedException {
		logger.info("*********************************");
		logger.info("SelfServiceTest - verifyAvailableModulesForSelfService");
		logger.info("*********************************");
		homepg.expandTopMenu("Incident");
		homepg.expandTopMenu("Fast View");

		Assert.assertEquals(homepg.fastAndFullView.createNewFast_Link.getText(), Constants.CREATENEWFAST,
				"Create New - Fast module is not displaying under Fast - View");
		Assert.assertEquals(homepg.fastAndFullView.assignToMeFast_Link.getText(), Constants.ASSIGNEDTOMEFAST,
				"Assigned to me - Fast module is not displaying under Fast - View");
		Assert.assertEquals(homepg.fastAndFullView.openFast_Link.getText(), Constants.OPENFAST,
				"Create New - Fast module is not displaying under Fast - View");
		Assert.assertEquals(homepg.fastAndFullView.openUnassignFast_Link.getText(), Constants.OPENUNASSIGNEDFAST,
				"Open Unassigned - Fast module is not openUnassignFast_Link under Fast - View");
		Assert.assertEquals(homepg.fastAndFullView.myGroupFast_Link.getText(), Constants.MYGROUPSFAST,
				"My Groups - Fast module is not displaying under Fast - View");
		Assert.assertEquals(homepg.fastAndFullView.myGroupUnassignFast_Link.getText(), Constants.MYGROUPSUNASSIGNEDFAST,
				"My Groups Unassigned - Fast module is not displaying under Fast - View");
		Assert.assertEquals(homepg.fastAndFullView.resolvedFast_Link.getText(), Constants.RESOLVEDFAST,
				"Resolved - Fast module is not displaying under Fast - View");
		Assert.assertEquals(homepg.fastAndFullView.closedFast_Link.getText(), Constants.CLOSEDFAST,
				"Closed - Fast module is not displaying under Fast - View");
		Assert.assertEquals(homepg.fastAndFullView.allFast_Link.getText(), Constants.ALLFAST,
				"All - Fast module is not displaying under Fast - View");

		// Final Verification
		test.log(LogStatus.PASS, "Validation for available modules for Fast-View is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Views : Test Case No-2. Verify modules available under full view module
	 * 
	 */
	@Test(priority = 2)
	public void verifyAvailableModulesForFullView() throws InterruptedException {
		logger.info("*********************************");
		logger.info("SelfServiceTest - verifyAvailableModulesForFullView");
		logger.info("*********************************");
		homepg.expandTopMenu("Incident");
		homepg.expandTopMenu("Fast View");

		Assert.assertEquals(homepg.fastAndFullView.createNewFull_Link.getText(), Constants.CREATENEWFULL,
				"Create New - Full module is not displaying under Full - View");
		Assert.assertEquals(homepg.fastAndFullView.assignToMeFull_Link.getText(), Constants.ASSIGNEDTOMEFULL,
				"Assigned to me - Full module is not displaying under Full - View");
		Assert.assertEquals(homepg.fastAndFullView.openFull_Link.getText(), Constants.OPENFULL,
				"Create New - Full module is not displaying under Full - View");
		Assert.assertEquals(homepg.fastAndFullView.openUnassignFull_Link.getText(), Constants.OPENUNASSIGNEDFULL,
				"Open Unassigned - Full module is not openUnassignFast_Link under Full - View");
		Assert.assertEquals(homepg.fastAndFullView.myGroupFull_Link.getText(), Constants.MYGROUPSFULL,
				"My Groups - Full module is not displaying under Full - View");
		Assert.assertEquals(homepg.fastAndFullView.myGroupUnassignFull_Link.getText(), Constants.MYGROUPSUNASSIGNEDFULL,
				"My Groups Unassigned - Full module is not displaying under Full - View");
		Assert.assertEquals(homepg.fastAndFullView.resolvedFull_Link.getText(), Constants.RESOLVEDFULL,
				"Resolved - Full module is not displaying under Full - View");
		Assert.assertEquals(homepg.fastAndFullView.closedFull_Link.getText(), Constants.CLOSEDFULL,
				"Closed - Full module is not displaying under Full - View");
		Assert.assertEquals(homepg.fastAndFullView.allFull_Link.getText(), Constants.ALLFULL,
				"All - Full module is not displaying under Full - View");

		// Final Verification
		test.log(LogStatus.PASS, "Validation for available modules for Fast-View is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Views :Test Case No-3. Verify fields available under fast view module
	 * 
	 */
	@Test(priority = 3)
	public void verifyFastViewForIncCreation() throws InterruptedException {
		logger.info("*********************************");
		logger.info("SelfServiceTest - verifyFastViewForIncCreation");
		logger.info("*********************************");
		homepg.expandTopMenu("Incident");
		homepg.expandTopMenu("Fast View");

		homepg.fastAndFullView.click(homepg.fastAndFullView.createNewFast_Link);
		homepg.fastAndFullView.switchToDefaultiFrame();
		Assert.assertTrue(homepg.gethelponincdntfrm.incNo_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.reqFor_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.opened_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.state_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.watchList_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.shortDesc_lbl.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.closeCode_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subState_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignTo_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.serOrg_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.impact_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.urgency_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.priority_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.desireDate_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.closeNotes_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.comment_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.addComment_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNoteGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNote_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchList_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.description_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.shortDesc_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subCate_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.category_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.typeOfIssue_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.confItem_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.bussServ_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.company_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.contactType_Link.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Fast-View Incident creation fields is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Views :Test Case No-4. Verify fields available under full view module
	 * 
	 */
	@Test(priority = 4)
	public void verifyFullViewForIncCreation() throws InterruptedException {
		logger.info("*********************************");
		logger.info("SelfServiceTest - verifyFullViewForIncCreation");
		logger.info("*********************************");
		homepg.expandTopMenu("Incident");
		homepg.expandTopMenu("Full View");

		homepg.fastAndFullView.click(homepg.fastAndFullView.createNewFull_Link);
		homepg.fastAndFullView.switchToDefaultiFrame();
		Assert.assertTrue(homepg.gethelponincdntfrm.incNo_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.reqFor_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.opened_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.state_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.watchList_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.shortDesc_lbl.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subState_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignTo_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.serOrg_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.impact_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.urgency_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.priority_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.comment_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.addComment_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNoteGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNote_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchList_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.description_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.shortDesc_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subCate_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.category_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.typeOfIssue_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.confItem_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.bussServ_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.company_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.contactType_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.notes_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.timespampAndAttachment_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.relatedRecords_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.closureInfo_Tab.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Full-View Incident creation fields is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Views :Test Case No-5. Verify Incident creation for Fast View.
	 * 
	 */
	@Test(priority = 5)
	public void verifyIncidentCreationForFastView() throws InterruptedException {
		logger.info("*********************************");
		logger.info("SelfServiceTest - verifyIncidentCreationForFastView");
		logger.info("*********************************");
		homepg.expandTopMenu("Incident");
		homepg.expandTopMenu("Fast View");

		homepg.fastAndFullView.click(homepg.fastAndFullView.createNewFast_Link);
		homepg.fastAndFullView.switchToDefaultiFrame();
		incNumber = homepg.createIncidentFrame.getIncidentNumberText();

		homepg.createIncidentFrame.setRequestFor(prop.getProperty("requestFor"));
		homepg.createIncidentFrame.selectOption(homepg.createIncidentFrame.category, prop.getProperty("catagory"));
		homepg.createIncidentFrame.setShortDescription(prop.getProperty("shortDescription"));
		homepg.createIncidentFrame.selectOption(homepg.createIncidentFrame.subCategory,
				prop.getProperty("subCategory"));
		homepg.createIncidentFrame.setImpactValue();
		homepg.createIncidentFrame.setUrgencyValue();
		homepg.createIncidentFrame.setAssignedToValue(prop.getProperty("assignedToValue"));
		homepg.createIncidentFrame.selectBusinessService(prop.getProperty("busSer"));
		Thread.sleep(4000);
		homepg.createIncidentFrame.selectOption(homepg.createIncidentFrame.typeOfIssue,
				prop.getProperty("typeOfIssue"));
		Thread.sleep(2000);
		homepg.gethelponincdntfrm.contextClick();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.saveContextBtn);
		homepg.clickOnOpenIncidentFast_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incNumber, homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		Assert.assertTrue(homepg.createIncidentFrame.incRow.isDisplayed(), "Not able to create Incident");

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Incident creation for Fast-View is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Views :Test Case No-6. Verify Open Incident for Fast View.
	 * 
	 */
	@Test(priority = 6, dependsOnMethods = "verifyIncidentCreationForFastView")
	public void verifyOpenIncidentForFastView() throws InterruptedException {
		logger.info("*********************************");
		logger.info("SelfServiceTest - verifyOpenIncidentForFastView");
		logger.info("*********************************");

		homepg.clickOnOpenIncidentFast_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incNumber, homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		Assert.assertTrue(homepg.gethelponincdntfrm.incNo_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.reqFor_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.opened_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.state_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.watchList_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.shortDesc_lbl.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subState_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignTo_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.serOrg_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.impact_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.urgency_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.priority_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.comment_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.addComment_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNoteGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNote_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchList_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.description_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.shortDesc_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subCate_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.category_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.typeOfIssue_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.confItem_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.bussServ_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.company_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.contactType_Link.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Open Incident for Fast-View is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Views :Test Case No-7. Verify Assigned to me - Fast View.
	 * 
	 */
	@Test(priority = 7, dependsOnMethods = "verifyIncidentCreationForFastView")
	public void verifyAssignedToMeForFastView() throws InterruptedException {
		logger.info("*********************************");
		logger.info("SelfServiceTest - verifyAssignedToMeForFastView");
		logger.info("*********************************");

		homepg.clickOnAssignedToMeFast_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incNumber, homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		Assert.assertEquals(homepg.createIncidentFrame.assignedTo.getAttribute("value"),
				prop.getProperty("requestFor"));
		Assert.assertTrue(homepg.gethelponincdntfrm.incNo_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.reqFor_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.opened_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.state_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.watchList_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.shortDesc_lbl.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subState_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignTo_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.serOrg_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.impact_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.urgency_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.priority_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.comment_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.addComment_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNoteGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNote_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchList_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.description_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.shortDesc_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subCate_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.category_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.typeOfIssue_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.confItem_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.bussServ_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.company_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.contactType_Link.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Assigned to me for Fast-View is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Views :Test Case No-8. Verify Open - Unassigned - Fast.
	 * 
	 */
	@Test(priority = 8)
	public void verifyOpenUnassignedForFastView() throws InterruptedException {
		logger.info("*********************************");
		logger.info("SelfServiceTest - verifyOpenUnassignedForFastView");
		logger.info("*********************************");

		homepg.expandTopMenu("Incident");
		homepg.expandTopMenu("Fast View");

		homepg.fastAndFullView.click(homepg.fastAndFullView.createNewFast_Link);
		homepg.fastAndFullView.switchToDefaultiFrame();
		incidentNumber = homepg.createIncidentFrame.getIncidentNumberText();

		homepg.createIncidentFrame.setRequestFor(prop.getProperty("requestFor"));
		homepg.createIncidentFrame.selectOption(homepg.createIncidentFrame.category, prop.getProperty("catagory"));
		homepg.createIncidentFrame.setShortDescription(prop.getProperty("shortDescription"));
		homepg.createIncidentFrame.selectOption(homepg.createIncidentFrame.subCategory,
				prop.getProperty("subCategory"));
		homepg.createIncidentFrame.setImpactValue();
		homepg.createIncidentFrame.setUrgencyValue();
		homepg.createIncidentFrame.setAssignedToValue(prop.getProperty("assignedToValueOtherUser"));
		homepg.createIncidentFrame.selectBusinessService(prop.getProperty("busSer"));
		Thread.sleep(4000);
		homepg.createIncidentFrame.selectOption(homepg.createIncidentFrame.typeOfIssue,
				prop.getProperty("typeOfIssue"));
		Thread.sleep(2000);
		homepg.gethelponincdntfrm.contextClick();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.saveContextBtn);
		homepg.clickOnOpenUnAssignedToMeFast_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incidentNumber,
				homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		Assert.assertEquals(homepg.createIncidentFrame.assignedTo.getAttribute("value"),
				prop.getProperty("assignedToValueOtherUser"));
		Assert.assertTrue(homepg.gethelponincdntfrm.incNo_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.reqFor_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.opened_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.state_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.watchList_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.shortDesc_lbl.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subState_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignTo_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.serOrg_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.impact_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.urgency_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.priority_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.comment_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.addComment_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNoteGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNote_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchList_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.description_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.shortDesc_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subCate_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.category_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.typeOfIssue_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.confItem_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.bussServ_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.company_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.contactType_Link.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for OPne UnAssigned for Fast-View is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Views :Test Case No-9. Verify My Groups - Fast module.
	 * 
	 */
	@Test(priority = 9, dependsOnMethods = "verifyIncidentCreationForFastView")
	public void verifyMyGroupsFastView() throws InterruptedException {
		logger.info("**********************************************");
		logger.info("SelfServiceTest - verifyMyGroupsFastView");
		logger.info("**********************************************");

		homepg.clickOnMyGroupsFast_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incNumber, homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		Assert.assertTrue(homepg.gethelponincdntfrm.incNo_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.reqFor_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.opened_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.state_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.watchList_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.shortDesc_lbl.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subState_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignTo_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.serOrg_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.impact_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.urgency_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.priority_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.comment_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.addComment_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNoteGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNote_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchList_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.description_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.shortDesc_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subCate_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.category_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.typeOfIssue_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.confItem_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.bussServ_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.company_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.contactType_Link.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for My Groups for Fast-View is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Views :Test Case No-10. Verify All - Fast module.
	 * 
	 */
	@Test(priority = 10, dependsOnMethods = "verifyIncidentCreationForFastView")
	public void verifyAllFastView() throws InterruptedException {
		logger.info("**********************************************");
		logger.info("SelfServiceTest - verifyAllFastView");
		logger.info("**********************************************");

		homepg.clickOnAllFast_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incNumber, homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		Assert.assertTrue(homepg.gethelponincdntfrm.incNo_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.reqFor_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.opened_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.state_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.watchList_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.shortDesc_lbl.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subState_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignTo_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.serOrg_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.impact_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.urgency_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.priority_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.comment_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.addComment_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNoteGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNote_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchList_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.description_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.shortDesc_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subCate_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.category_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.typeOfIssue_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.confItem_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.bussServ_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.company_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.contactType_Link.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for My Groups for Fast-View is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Views :Test Case No-11. Verify Resolved - Fast module.
	 * 
	 */
	@Test(priority = 11, dependsOnMethods = "verifyIncidentCreationForFastView")
	public void verifyResolvedFastView() throws InterruptedException {

		logger.info("**********************************************");
		logger.info("SelfServiceTest - verifyResolvedFastView");
		logger.info("**********************************************");

		homepg.clickOnOpenIncidentFast_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incNumber, homepg.gethelponincdntfrm.incidentNumberSearchBox);

		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.change.changeState("RESOLVED");
		homepg.change.enterCloseNotes();
		homepg.change.additionalComment();
		homepg.change.closeCode("CANCELLED");
		homepg.gethelponincdntfrm.contextClick();
		homepg.change.click(homepg.gethelponincdntfrm.saveContextBtn);
		Assert.assertEquals(homepg.gethelponincdntfrm.getText(homepg.gethelponincdntfrm.resolvedMsg),
				prop.getProperty("incResolvedMsg1") + " " + incNumber + " " + (prop.getProperty("incResolvedMsg2")),
				"Problem occurred while resolving the incident.");

		homepg.clickOnResolvedFast_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.searchIncidentNumber(incNumber, homepg.gethelponincdntfrm.incidentNumberSearchBox);

		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		Assert.assertEquals(homepg.gethelponincdntfrm.inputState.getAttribute("value"), "6");
		Assert.assertTrue(homepg.gethelponincdntfrm.incNo_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.reqFor_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.opened_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.state_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.watchList_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.shortDesc_lbl.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subState_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignTo_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.serOrg_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.impact_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.urgency_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.priority_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.comment_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.addComment_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNoteGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNote_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchList_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.description_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.shortDesc_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subCate_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.category_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.typeOfIssue_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.confItem_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.bussServ_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.company_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.contactType_Link.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Resolved Fast is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Views :Test Case No-12. Verify Closed - Fast module.
	 * 
	 */
	@Test(priority = 12, dependsOnMethods = "verifyResolvedFastView")
	public void verifyClosedFastView() throws InterruptedException {
		logger.info("**********************************************");
		logger.info("SelfServiceTest - verifyClosedFastView");
		logger.info("**********************************************");

		homepg.clickOnResolvedFast_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.searchIncidentNumber(incNumber, homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.change.changeState("REOPENED");
		homepg.gethelponincdntfrm.contextClick();
		homepg.change.click(homepg.gethelponincdntfrm.saveContextBtn);
		Thread.sleep(3000);
		homepg.change.changeState("CLOSED");
		homepg.change.enterCloseNotes();
		homepg.change.additionalComment();
		homepg.change.closeCode("CANCELLED");
		homepg.gethelponincdntfrm.contextClick();
		homepg.change.click(homepg.gethelponincdntfrm.saveContextBtn);
		homepg.clickOnClosed_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.searchIncidentNumber(incNumber, homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		Assert.assertEquals(homepg.gethelponincdntfrm.inputState.getAttribute("value"), "7");
		Assert.assertTrue(homepg.gethelponincdntfrm.incNo_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.reqFor_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.opened_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.state_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.watchList_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.shortDesc_lbl.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignTo_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.serOrg_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.impact_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.urgency_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.priority_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.addComment_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.description_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.shortDesc_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subCate_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.category_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.typeOfIssue_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.confItem_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.bussServ_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.company_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.contactType_Link.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Closed Fast is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Views :Test Case No-13. Verify Incident creation for Full View.
	 * 
	 */
	@Test(priority = 13)
	public void verifyIncidentCreationForFullView() throws InterruptedException {
		logger.info("*********************************");
		logger.info("SelfServiceTest - verifyIncidentCreationForFullView");
		logger.info("*********************************");
		homepg.expandTopMenu("Incident");
		homepg.expandTopMenu("Full View");

		homepg.fastAndFullView.click(homepg.fastAndFullView.createNewFull_Link);
		homepg.fastAndFullView.switchToDefaultiFrame();
		incNumberForFullView = homepg.createIncidentFrame.getIncidentNumberText();

		homepg.createIncidentFrame.setRequestFor(prop.getProperty("requestFor"));
		homepg.createIncidentFrame.selectOption(homepg.createIncidentFrame.category, prop.getProperty("catagory"));
		homepg.createIncidentFrame.setShortDescription(prop.getProperty("shortDescription"));
		homepg.createIncidentFrame.selectOption(homepg.createIncidentFrame.subCategory,
				prop.getProperty("subCategory"));
		homepg.createIncidentFrame.setImpactValue();
		homepg.createIncidentFrame.setUrgencyValue();
		homepg.createIncidentFrame.setAssignedToValue(prop.getProperty("assignedToValue"));
		homepg.createIncidentFrame.selectBusinessService(prop.getProperty("busSer"));
		Thread.sleep(4000);
		homepg.createIncidentFrame.selectOption(homepg.createIncidentFrame.typeOfIssue,
				prop.getProperty("typeOfIssue"));
		Thread.sleep(2000);
		homepg.gethelponincdntfrm.contextClick();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.saveContextBtn);

		homepg.clickOnOpenIncidentFull_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incNumberForFullView,
				homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		Assert.assertTrue(homepg.createIncidentFrame.incRow.isDisplayed(), "Not able to create Incident");
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.fastAndFullView.switchToDefaultiFrame();
		Assert.assertTrue(homepg.gethelponincdntfrm.incNo_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.reqFor_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.opened_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.state_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.watchList_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.shortDesc_lbl.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subState_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignTo_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.serOrg_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.impact_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.urgency_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.priority_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNoteGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNote_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchList_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.description_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.shortDesc_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subCate_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.category_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.typeOfIssue_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.confItem_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.bussServ_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.company_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.contactType_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.notes_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.timespampAndAttachment_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.relatedRecords_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.closureInfo_Tab.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Incident creation for Full-View is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Views :Test Case No-14. Verify Open Incident for Full View.
	 * 
	 */
	@Test(priority = 14, dependsOnMethods = "verifyIncidentCreationForFullView")
	public void verifyOpenIncidentForFullView() throws InterruptedException {
		logger.info("*********************************");
		logger.info("SelfServiceTest - verifyOpenIncidentForFullView");
		logger.info("*********************************");

		homepg.clickOnOpenIncidentFull_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incNumberForFullView,
				homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.fastAndFullView.switchToDefaultiFrame();
		Assert.assertTrue(homepg.gethelponincdntfrm.incNo_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.reqFor_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.opened_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.state_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.watchList_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.shortDesc_lbl.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subState_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignTo_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.serOrg_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.impact_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.urgency_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.priority_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNoteGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNote_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchList_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.description_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.shortDesc_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subCate_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.category_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.typeOfIssue_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.confItem_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.bussServ_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.company_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.contactType_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.notes_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.timespampAndAttachment_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.relatedRecords_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.closureInfo_Tab.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Open Incident for Full-View is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Views :Test Case No-15. Verify Assigned to me - Full View.
	 * 
	 */
	@Test(priority = 15, dependsOnMethods = "verifyIncidentCreationForFullView")
	public void verifyAssignedToMeForFullView() throws InterruptedException {
		logger.info("**************************************************");
		logger.info("SelfServiceTest - verifyAssignedToMeForFullView");
		logger.info("***************************************************");

		homepg.clickOnAssignedToMeFull_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incNumberForFullView,
				homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		Assert.assertEquals(homepg.createIncidentFrame.assignedTo.getAttribute("value"),
				prop.getProperty("requestFor"));
		Assert.assertTrue(homepg.gethelponincdntfrm.incNo_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.reqFor_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.opened_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.state_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.watchList_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.shortDesc_lbl.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subState_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignTo_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.serOrg_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.impact_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.urgency_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.priority_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNoteGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNote_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchList_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.description_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.shortDesc_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subCate_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.category_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.typeOfIssue_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.confItem_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.bussServ_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.company_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.contactType_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.notes_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.timespampAndAttachment_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.relatedRecords_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.closureInfo_Tab.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Assigned to me for Full-View is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Views :Test Case No-16. Verify My Groups - Full module.
	 * 
	 */
	@Test(priority = 16, dependsOnMethods = "verifyIncidentCreationForFullView")
	public void verifyMyGroupsFullView() throws InterruptedException {
		logger.info("**********************************************");
		logger.info("SelfServiceTest - verifyMyGroupsFullView");
		logger.info("**********************************************");

		homepg.clickOnMyGroupsFull_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incNumberForFullView,
				homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		Assert.assertTrue(homepg.gethelponincdntfrm.incNo_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.reqFor_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.opened_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.state_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.watchList_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.shortDesc_lbl.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subState_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignTo_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.serOrg_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.impact_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.urgency_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.priority_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNoteGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNote_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchList_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.description_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.shortDesc_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subCate_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.category_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.typeOfIssue_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.confItem_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.bussServ_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.company_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.contactType_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.notes_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.timespampAndAttachment_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.relatedRecords_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.closureInfo_Tab.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for My Groups for Full-View is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Views :Test Case No-17. Verify All - Full module.
	 * 
	 */
	@Test(priority = 17, dependsOnMethods = "verifyIncidentCreationForFullView")
	public void verifyAllFullView() throws InterruptedException {
		logger.info("**********************************************");
		logger.info("SelfServiceTest - verifyAllFullView");
		logger.info("**********************************************");

		homepg.clickOnAllFull_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incNumberForFullView,
				homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		Assert.assertTrue(homepg.gethelponincdntfrm.incNo_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.reqFor_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.opened_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.state_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.watchList_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.shortDesc_lbl.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subState_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignTo_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.serOrg_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.impact_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.urgency_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.priority_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNoteGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNote_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchList_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.description_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.shortDesc_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subCate_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.category_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.typeOfIssue_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.confItem_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.bussServ_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.company_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.contactType_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.notes_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.timespampAndAttachment_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.relatedRecords_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.closureInfo_Tab.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for My Groups for Full-View is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Views :Test Case No-18. Verify Resolved - Full module.
	 * 
	 */
	@Test(priority = 18, dependsOnMethods = "verifyIncidentCreationForFullView")
	public void verifyResolvedFullView() throws InterruptedException {

		logger.info("**********************************************");
		logger.info("SelfServiceTest - verifyResolvedFullView");
		logger.info("**********************************************");

		homepg.clickOnOpenIncidentFull_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incNumberForFullView,
				homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.change.changeState("RESOLVED");
		homepg.change.typeText(homepg.fastAndFullView.addCommentForFullView, "test");
		homepg.gethelponincdntfrm.click(homepg.fastAndFullView.closureInfo_Tab);
		homepg.change.enterCloseNotes();
		homepg.change.closeCode("CANCELLED");
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.contextClick();
		homepg.change.click(homepg.gethelponincdntfrm.saveContextBtn);
		Assert.assertEquals(homepg.gethelponincdntfrm.getText(homepg.gethelponincdntfrm.resolvedMsg),
				prop.getProperty("incResolvedMsg1") + " " + incNumberForFullView + " "
						+ (prop.getProperty("incResolvedMsg2")),
				"Problem occurred while resolving the incident.");
		homepg.clickOnResolvedFull_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incNumberForFullView,
				homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		Assert.assertEquals(homepg.gethelponincdntfrm.inputState.getAttribute("value"), "6");
		Assert.assertTrue(homepg.gethelponincdntfrm.incNo_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.reqFor_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.opened_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.state_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.shortDesc_lbl.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subState_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignTo_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.serOrg_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.impact_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.urgency_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.priority_Link.isDisplayed());
		homepg.editincidentfrm.click(homepg.editincidentfrm.notesTab);
		Assert.assertTrue(homepg.fastAndFullView.workNoteGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.workNote_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.watchList_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.description_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.shortDesc_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subCate_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.category_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.typeOfIssue_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.confItem_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.bussServ_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.company_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.contactType_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.notes_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.timespampAndAttachment_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.relatedRecords_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.closureInfo_Tab.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Resolved Full is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Views :Test Case No-19. Verify Closed - Fast module.
	 * 
	 */
	@Test(priority = 19, dependsOnMethods = "verifyIncidentCreationForFullView")
	public void verifyClosedFullView() throws InterruptedException {
		logger.info("**********************************************");
		logger.info("SelfServiceTest - verifyClosedFullView");
		logger.info("**********************************************");

		homepg.clickOnResolvedFull_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incNumberForFullView,
				homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.change.changeState("REOPENED");
		homepg.gethelponincdntfrm.contextClick();
		homepg.change.click(homepg.gethelponincdntfrm.saveContextBtn);
		Thread.sleep(3000);
		homepg.clickOnResolvedFull_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.click(homepg.gethelponincdntfrm.allLink);
		homepg.gethelponincdntfrm.searchIncidentNumber(incNumberForFullView,
				homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.change.changeState("CLOSED");
		homepg.editincidentfrm.click(homepg.editincidentfrm.notesTab);
		homepg.change.typeText(homepg.fastAndFullView.addCommentForFullView, "test");
		homepg.gethelponincdntfrm.click(homepg.fastAndFullView.closureInfo_Tab);
		homepg.change.enterCloseNotes();
		homepg.change.closeCode("CANCELLED");
		homepg.gethelponincdntfrm.contextClick();
		homepg.change.click(homepg.gethelponincdntfrm.saveContextBtn);
		homepg.clickOnClosedFull_Button();
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		homepg.gethelponincdntfrm.searchIncidentNumber(incNumberForFullView,
				homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		homepg.gethelponincdntfrm.clickOnSearchedIncident();
		Thread.sleep(3000);
		homepg.gethelponincdntfrm.switchToDefaultiFrame();
		Assert.assertEquals(homepg.gethelponincdntfrm.inputState.getAttribute("value"), "7");
		homepg.editincidentfrm.click(homepg.editincidentfrm.notesTab);
		Assert.assertTrue(homepg.gethelponincdntfrm.incNo_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.reqFor_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.opened_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.state_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.watchList_lbl.isDisplayed());
		Assert.assertTrue(homepg.gethelponincdntfrm.shortDesc_lbl.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignGroup_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.assignTo_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.serOrg_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.impact_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.urgency_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.priority_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.description_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.shortDesc_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.subCate_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.category_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.typeOfIssue_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.confItem_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.bussServ_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.company_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.contactType_Link.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.notes_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.timespampAndAttachment_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.relatedRecords_Tab.isDisplayed());
		Assert.assertTrue(homepg.fastAndFullView.closureInfo_Tab.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Closed Full is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

}
