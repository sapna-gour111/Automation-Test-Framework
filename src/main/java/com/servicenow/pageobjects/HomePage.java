package com.servicenow.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * This class contains pageobjects & methods to perform action on web pages
 * 
 * @author Sapna Gour
 *
 */

public class HomePage extends BasePage {

	public IncidentOpenFrame incidentopenfrm;
	public EditIncidentFrame editincidentfrm;
	public SelfServiceIncidentCreation gethelponincdntfrm;
	public CreateIncidentFrame createIncidentFrame;
	public IncidentUpdateFrame incidentUpdateFrame;
	public OrderGuides orderGuides;
	public Change change;
	public FastAndFullView fastAndFullView;

	public HomePage(EventFiringWebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		incidentopenfrm = new IncidentOpenFrame(driver);
		editincidentfrm = new EditIncidentFrame(driver);
		gethelponincdntfrm = new SelfServiceIncidentCreation(driver);
		createIncidentFrame = new CreateIncidentFrame(driver);
		incidentUpdateFrame = new IncidentUpdateFrame(driver);
		orderGuides = new OrderGuides(driver);
		change = new Change(driver);
		fastAndFullView = new FastAndFullView(driver);
	}

	// LHS - Incidents Button
	@FindBy(xpath = "//*[contains(@href,'javascript:void(0)') and contains(text(),'Incident')]")
	private WebElement incident_Btn;
	// LHS - Incidents Menu
	// Sub menus under Incident

	// Open New
	@FindBy(xpath = "//*[@title='Open - Full']")
	private WebElement openIncident_Btn;

	// Open assigned to me inc
	@FindBy(xpath = "//*[@title='Assigned to me - Fast']")
	private WebElement assiToMeFast_Btn;

	// Open assigned to me inc for Full view
	@FindBy(xpath = "//*[@title='Assigned to me - Full']")
	private WebElement assiToMeFull_Btn;

	// Open My Groups
	@FindBy(xpath = "//*[@title='My Groups - Fast']")
	private WebElement myGroupsFast_Btn;

	// Open My Groups - full
	@FindBy(xpath = "//*[@title='My Groups - Full']")
	private WebElement myGroupsFull_Btn;

	// Open All - Fast
	@FindBy(xpath = "//*[@title='All - Fast']")
	private WebElement AllFast_Btn;

	// Open All - Full
	@FindBy(xpath = "//*[@title='All - Full']")
	private WebElement AllFull_Btn;

	// Resolved - Fast
	@FindBy(xpath = "//*[@title='Resolved - Fast']")
	private WebElement resolved_Btn;

	// Resolved - Full
	@FindBy(xpath = "//*[@title='Resolved - Full']")
	private WebElement resolvedFull_Btn;

	// Closed - Fast
	@FindBy(xpath = "//*[@title='Closed - Fast']")
	private WebElement closed_Btn;

	// Closed - Full
	@FindBy(xpath = "//*[@title='Closed - Full']")
	private WebElement closedFull_Btn;

	// Open Un assigned to me - Fast
	@FindBy(xpath = "//*[@title='Open - Unassigned - Fast']")
	private WebElement openUnAssiToMeFast_Btn;

	// Open New
	@FindBy(xpath = "//*[@title='Fast View']")
	private WebElement openIncidentFast_Btn;

	// All Incident
	@FindBy(xpath = "//*[@title='All'  and contains(@href,'incident_list.do')]")
	private WebElement allIncident_Btn;

	// LHS - Self-Service Menu

	// Create New incident - Full view
	@FindBy(xpath = "//*[@title='Create New - Full']")
	private WebElement createNewIncidentFull_Btn;

	// Open New incident - Full view
	@FindBy(xpath = "//*[@title='Open - Full']")
	private WebElement openIncidentFull_Btn;

	// Expand/collapse Self-Service
	@FindBy(css = "ul>li:nth-of-type(4)>span>a")
	private WebElement expandCollapseSelfService_Btn;

	// SelfService->Homepage module
	@FindBy(css = "#collapseId1>li:nth-of-type(1)>a")
	public WebElement homePage_Btn;

	// SelfService->Get help on new incident module
	@FindBy(css = "#collapseId1>li:nth-of-type(2)>a")
	public WebElement getHelpOnNewIncident_Btn;

	// SelfService->Open change
	@FindBy(xpath = "//ul[@id='collapseId22']/li[3]/a")
	public WebElement openChange_Btn;

	// SelfService->Open change
	@FindBy(xpath = "//ul[@id='collapseId22']/li[1]/a")
	public WebElement createChange_Btn;

	// SelfService->Knowledge module
	@FindBy(css = "#collapseId1>li:nth-of-type(3)>a")
	public WebElement knowledge_Btn;

	// SelfService->Service Catelog module
	@FindBy(css = "#collapseId1>li:nth-of-type(4)>a")
	public WebElement serviceCatalog_Btn;

	// SelfService->Connect Chat module
	@FindBy(css = "#collapseId1>li:nth-of-type(5)>ul>li:nth-of-type(1)>a")
	public WebElement connectChat_Btn;

	// SelfService->My Incident module
	@FindBy(css = "#collapseId1>li:nth-of-type(5)>ul>li:nth-of-type(1)>a")
	public WebElement myIncident_Btn;

	// SelfService->My requested items module
	@FindBy(css = "#collapseId1>li:nth-of-type(5)>ul>li:nth-of-type(2)>a")
	public WebElement myRequestedItems_Btn;

	// SelfService->My approvals module
	@FindBy(css = "#collapseId1>li:nth-of-type(5)>ul>li:nth-of-type(3)>a")
	public WebElement myApprovals_Btn;

	// SelfService->Watched incident module
	@FindBy(css = "#collapseId1>li:nth-of-type(5)>ul>li:nth-of-type(4)>a")
	public WebElement watchedIncident_Btn;

	// SelfService->Watched requested items module
	@FindBy(css = "#collapseId1>li:nth-of-type(5)>ul>li:nth-of-type(5)>a")
	public WebElement watchedRequestedItems_Btn;

	// SelfService->My profile module
	@FindBy(css = "ul#collapseId1>li:nth-of-type(7)>ul>li:nth-of-type(1)>a")
	public WebElement myProfile_Btn;

	// SelfService->My Tagged Documents module
	@FindBy(css = "ul#collapseId1>li:nth-of-type(7)>ul>li:nth-of-type(2)>a")
	public WebElement myTaggedDocuments_Btn;

	// SelfService->Take Survey module
	@FindBy(css = "ul#collapseId1>li:nth-of-type(7)>ul>li:nth-of-type(2)>a")
	public WebElement takeSurvey_Btn;

	// SelfService->Chat module
	@FindBy(css = "ul#collapseId1>li:nth-of-type(8)>ul>li:nth-of-type(1)>a")
	public WebElement chat_Btn;

	// SelfService->Live Feed module
	@FindBy(css = "ul#collapseId1>li:nth-of-type(8)>ul>li:nth-of-type(2)>a")
	public WebElement liveFeed_Btn;

	// SelfService->My Notification Preferences module
	@FindBy(css = "ul#collapseId1>li:nth-of-type(8)>ul>li:nth-of-type(3)>a")
	public WebElement myNotificationPreferences_Btn;

	// SelfService->Coordinator Task module
	@FindBy(css = "ul.nav-application-tree>li:nth-of-type(1)>ul>li:nth-of-type(6)>a")
	public WebElement coordinatorTask_Btn;
	// Create New
	// duplicate elemnent
	@FindBy(xpath = "//*[@title='Create New - Fast']")
	public WebElement createNewIncident;

	// Assign to me
	@FindBy(xpath = "//*[@title='Assigned to me - Fast']")
	public WebElement assignToMeIncident;

	// Open
	@FindBy(xpath = "//*[@title='Fast View']")
	public WebElement openIncident;

	// Open - Unassigned
	@FindBy(xpath = "//*[@title='Open - Unassigned - Fast']") //
	public WebElement openUnassignedIncident;

	// My Groups
	@FindBy(xpath = "//*[@title='My Groups - Fast']") //
	public WebElement myGroupsIncident;

	// My Groups Unassigned
	@FindBy(xpath = "//*[@title='My Groups - Unassigned - Fast']")
	public WebElement myGroupsUnassignedIncident;

	// Resolved
	@FindBy(xpath = "//*[@title='Resolved - Fast']")
	public WebElement resolvedIncident;

	// Closed
	@FindBy(xpath = "//*[@title='Closed - Fast']")
	public WebElement closedIncident;

	// All
	@FindBy(xpath = "//*[@title='All - Fast']")
	public WebElement allIncident;

	// Email
	@FindBy(css = "ul#collapseId210>li:nth-of-type(8)>ul>a")
	public WebElement emails_Btn;

	/*
	 * // Critical Incident Map
	 * 
	 * @FindBy(xpath =
	 * "//*[@title='See locations of all active Priority 1 Incidents']") public
	 * WebElement criticalIncidentMap;
	 */

	public void clickOncreateNewIncidentFullButton() {
		logger.info("Clicking on create new incident button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		expandTopMenu("Incident");
		createNewIncidentFull_Btn.click();
		closeAlert();
		synchronize();
	}

	public void clickOnOpenIncident_Button() throws InterruptedException {
		logger.info("Clicking on Open incident button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		expandTopMenu("Incident");
		openIncident_Btn.click();
		closeAlert();
		synchronize();
	}

	public void clickOnAssignedToMeFast_Button() throws InterruptedException {
		logger.info("Clicking on Assigned to me - Fast button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		expandTopMenu("Incident");
		assiToMeFast_Btn.click();
		closeAlert();
		synchronize();
	}

	public void clickOnAssignedToMeFull_Button() throws InterruptedException {
		logger.info("Clicking on Assigned to me - Full button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		expandTopMenu("Incident");
		assiToMeFull_Btn.click();
		closeAlert();
		synchronize();
	}

	public void clickOnMyGroupsFast_Button() throws InterruptedException {
		logger.info("Clicking on My Groups - Fast button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		expandTopMenu("Incident");
		myGroupsFast_Btn.click();
		closeAlert();
		synchronize();
	}

	public void clickOnMyGroupsFull_Button() throws InterruptedException {
		logger.info("Clicking on My Groups - Full button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		expandTopMenu("Incident");
		myGroupsFull_Btn.click();
		closeAlert();
		synchronize();
	}

	public void clickOnAllFast_Button() throws InterruptedException {
		logger.info("Clicking on All - Fast button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		expandTopMenu("Incident");
		AllFast_Btn.click();
		closeAlert();
		synchronize();
	}

	public void clickOnAllFull_Button() throws InterruptedException {
		logger.info("Clicking on All - Full button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		expandTopMenu("Incident");
		AllFull_Btn.click();
		closeAlert();
		synchronize();
	}

	public void clickOnResolvedFast_Button() throws InterruptedException {
		logger.info("Clicking on Resolved - Fast button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		expandTopMenu("Incident");
		resolved_Btn.click();
		closeAlert();
		synchronize();
	}

	public void clickOnResolvedFull_Button() throws InterruptedException {
		logger.info("Clicking on Resolved - Full button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		expandTopMenu("Incident");
		resolvedFull_Btn.click();
		closeAlert();
		synchronize();
	}

	public void clickOnClosed_Button() throws InterruptedException {
		logger.info("Clicking on Closed - Fast button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		expandTopMenu("Incident");
		closed_Btn.click();
		closeAlert();
		synchronize();
	}

	public void clickOnClosedFull_Button() throws InterruptedException {
		logger.info("Clicking on Closed - Full button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		expandTopMenu("Incident");
		closedFull_Btn.click();
		closeAlert();
		synchronize();
	}

	public void clickOnOpenUnAssignedToMeFast_Button() throws InterruptedException {
		logger.info("Clicking on OPen UnAssigned to me - Fast button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		expandTopMenu("Incident");
		openUnAssiToMeFast_Btn.click();
		closeAlert();
		synchronize();
	}

	public void clickOnOpenIncidentFast_Button() throws InterruptedException {
		logger.info("Clicking on Open incident button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		expandTopMenu("Incident");
		openIncidentFast_Btn.click();
		closeAlert();
		synchronize();
	}

	public void clickOnAllIncidentButton() {
		logger.info("Clicking on all incident button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		expandTopMenu("Incident");
		allIncident_Btn.click();
		closeAlert();
		synchronize();
	}

	public void clickOnOpenIncidentFull_Button() {
		logger.info("Clicking on Open Incident - Full button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		expandTopMenu("Incident");
		openIncidentFull_Btn.click();
		closeAlert();
		synchronize();
	}

	public void clickOnGetHelpOnNewIncidentButton() throws InterruptedException {
		logger.info("Clicking on help on new incident button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		expandTopMenu("Self-Service");
		getHelpOnNewIncident_Btn.click();
		closeAlert();
		Thread.sleep(5000);
		// synchronize();

	}

	public void clickOnChange() throws InterruptedException {
		logger.info("Clicking on Change");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		expandTopMenu("Change");
		openChange_Btn.click();
		closeAlert();
		Thread.sleep(5000);
		// synchronize();
	}

	public void createChange() throws InterruptedException {
		logger.info("Creating Change from Application");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		expandTopMenu("Change");
		createChange_Btn.click();
		closeAlert();
		Thread.sleep(5000);
		// synchronize();
	}

	public void searchEmailLogs() throws InterruptedException {
		logger.info("Search Email Logs");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		Thread.sleep(4000);
		expandTopMenu("System Logs");
		Thread.sleep(4000);
		emails_Btn.click();
		closeAlert();
		synchronize();
	}

	public void clickOnMyIncidentButton() {
		logger.info("Clicking on my incident button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultContent();
		myIncident_Btn.click();
		closeAlert();
		synchronize();
	}

}