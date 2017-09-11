package com.servicenow.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.servicenow.utils.Constants;
import com.servicenow.utils.PropertiesLoader;

public class CreateIncidentFrame extends IFrameBase {

	static PropertiesLoader prop = new PropertiesLoader(Constants.PROPERTY_FILE_PATH);

	// Create New Incident->Incident number text box
	@FindBy(xpath = "//*[contains(@name,'sys_original.incident.number')]/../input[2]")
	public WebElement incidentNumberTextBox;

	// Create New Incident->Opened text box
	@FindBy(xpath = "(//*[@id='sys_readonly.incident.opened_at'])[1]")
	public WebElement incidentOpenedAt;

	// Create New Incident->Request For text box
	@FindBy(xpath = "//*[contains(@class,'input-group')]/input[contains(@id,'sys_display.incident.caller_id')]")
	public WebElement requestFor;

	// Create New Incident->Assigned to text box
	@FindBy(id = "sys_display.incident.assigned_to")
	public WebElement assignedTo;

	// Create New Incident->Company text box
	@FindBy(xpath = "//*[contains(@class,'input-group')]/input[contains(@id,'sys_display.incident.company')]")
	public WebElement company;

	// Create New Incident->Category text box
	@FindBy(xpath = "//*[@name='incident.category']/../select")
	public WebElement category;

	// Create New Incident->Category text box
	@FindBy(xpath = "//select[@id='incident.category']")
	public WebElement category2;

	// Create New Incident-> Sub Category drop down
	@FindBy(id = "incident.subcategory")
	public WebElement subCategory;

	// Create New Incident-> Type Of Issue drop down
	@FindBy(id = "incident.u_type_of_issue")
	public WebElement typeOfIssue;

	// Create New Incident->Business Service text box
	@FindBy(xpath = "//*[contains(@class,'input-group')]/input[contains(@data-ref,'incident.u_business_service')]")
	public WebElement businessService;

	// Create New Incident->Short description text box
	@FindBy(name = "incident.short_description")
	public WebElement shortDescription;

	// Create New Incident->Impact drop down
	@FindBy(xpath = "//*[@name='sys_original.incident.impact']/../select")
	public WebElement incidentImpactSelect;

	// Create New Incident->Company icon value
	@FindBy(id = "view.incident.company")
	public WebElement companyIcon;

	// Create New Incident->Dept icon value
	@FindBy(id = "view.incident.u_department")
	public WebElement deptIcon;

	// Create New Incident->Get Company abbreviation
	@FindBy(id = "core_company.u_company_abbreviation")
	public WebElement companyAbbre;

	// Create New Incident->Company dept abbreviation
	@FindBy(id = "sys_readonly.cmn_department.name")
	public WebElement deptAbbre;

	// Create New Incident->Get Company Code
	@FindBy(id = "core_company.u_company_code")
	public WebElement companyCode;

	// Create New Incident->Urgency drop down
	@FindBy(xpath = "//*[@name='sys_original.incident.urgency']/../select")
	public WebElement incidentUrgencySelect;

	// Create New Incident->Priority drop down
	@FindBy(xpath = "//*[@name='sys_original.incident.priority']/../select")
	public WebElement incidentPrioritySelect;

	// Create New Incident->Submit button
	@FindBy(id = "sysverb_insert")
	public WebElement submitBtn;

	// Create New Incident->Business Service text box
	@FindBy(id = "lookup.incident.u_business_service")
	public WebElement businessSerSearchButton;

	// Create New Incident->Business Service link
	@FindBy(xpath = "//tbody/tr/td[5]/a")
	public WebElement businessSerSearchLink;

	// Create New Incident->Get incident number
	@FindBy(xpath = "//tbody/tr/td[3]/a")
	public WebElement number;

	// Create New Incident->Business service
	@FindBy(id = "sys_display.incident.u_business_service")
	public WebElement businessServices;

	// Create New Incident->Close button
	@FindBy(xpath = "//div[@class='float_right']/a")
	public WebElement closeButton;

	// Create New Incident->Location icon
	@FindBy(id = "view.incident.location")
	public WebElement locIcon;

	// Create New Incident->Location abbreviation
	@FindBy(id = "sys_readonly.cmn_location.name")
	public WebElement locAbbre;

	// Create New Incident->Incident row
	@FindBy(xpath = "//tbody[@class='list2_body']/tr[1]/td[1]/span")
	public WebElement incRow;

	// Create New Incident->Assignment group
	@FindBy(xpath = "//img[@src='/images/icons/user.gif']")
	public WebElement assignGroup;

	// Create New Incident->Business service
	@FindBy(xpath = "//img[@src='/BS_Search.pngx']")
	public WebElement businessSer;

	// Create New Incident->Suggestion icon
	@FindBy(xpath = "//a[@id='lookup.incident.short_description']")
	public WebElement suggestionIcon;

	// Create New Incident->Search Knowledge.
	@FindBy(xpath = "//div[@id='element.incident.short_description']/div[3]/a[2]")
	public WebElement searchKnow;

	// Create New Incident-> Business Service Search Category.
	@FindBy(xpath = "//table/tbody/tr[1]/td/table/tbody/tr/td[2]")
	public WebElement bussServSearCate;

	// Create New Incident->Add Me icon
	@FindBy(xpath = "//button[@id='add_me_locked.incident.work_notes_list']")
	public WebElement addMe;

	// Create New Incident->Watch List Add Me icon
	@FindBy(xpath = "//button[@id='add_me_locked.incident.watch_list']")
	public WebElement watchListAddMe;

	// Create New Incident->Work note list icon
	@FindBy(xpath = "//button[@id='incident.work_notes_list_unlock']")
	public WebElement workNoteList;

	// Create New Incident-> Work note group icon
	@FindBy(xpath = "//button[@id='incident.u_work_notes_group_unlock']")
	public WebElement workNoteGroup;

	// Create New Incident->Watch list icon
	@FindBy(xpath = "//button[@id='incident.watch_list_unlock']")
	public WebElement watchList;

	// Create New Incident-> Watch list group icon
	@FindBy(xpath = "//button[@id='incident.u_watch_group_unlock']")
	public WebElement watchListGroup;

	// Create New Incident-> Lookup for Watch list
	@FindBy(xpath = "//button[@id='lookup.incident.watch_list']")
	public WebElement lookUpWatchList;

	// Create New Incident-> Watch list group look up
	@FindBy(xpath = "//button[@id='lookup.incident.u_watch_group']")
	public WebElement lookUpwatchListGroup;

	// Create New Incident-> Business services text box
	@FindBy(id = "sys_display.incident.u_business_service")
	public WebElement busiSerTxtBox;

	// Create New Incident-> Click on Notes
	@FindBy(xpath = "//div[@id='tabs2_section']/span[1]/span/span[2]")
	public WebElement notes;

	// Create New Incident-> Close pop up
	@FindBy(xpath = "//table[@class='drag_section_header']/tbody/tr/td[4]/span/img")
	public WebElement closePopUp;

	// Create New Incident-> Child window text for verification for short
	// description suggestion
	@FindBy(xpath = "//span[@id='sys_user_hide_search']/span")
	public WebElement shortDescSuggIconText;

	// Create New Incident-> Child window text for verification for assignment
	// group icon
	@FindBy(xpath = "//a[contains(text(),'Label')]")
	public WebElement assiGroupIconText;

	// Create New Incident-> Child window text for verification for Search
	// Knowledge
	// group icon
	@FindBy(xpath = "//div[contains(text(),'Knowledge search results')]")
	public WebElement searchKnowledgeIconText;

	// Watch list user
	@FindBy(xpath = "//p[@id='incident.watch_list_nonedit']")
	public WebElement watchListUser;

	// Work note list add me
	@FindBy(xpath = "//button[@id='add_me_locked.incident.work_notes_list']")
	public WebElement addMeForWorkNoteList;

	// Work note list user
	@FindBy(xpath = "//p[@id='incident.work_notes_list_nonedit']")
	public WebElement workNoteListUser;

	// Work group look up
	@FindBy(xpath = "//button[@id='lookup.incident.u_watch_group']")
	public WebElement workGroupLookUp;

	// Work Note group look up
	@FindBy(xpath = "//button[@id='lookup.incident.u_work_notes_group']")
	public WebElement workNoteGroupLookUp;

	// Work group lock icon
	@FindBy(xpath = "//button[@id='incident.u_watch_group_lock']")
	public WebElement workGroupLockIcon;

	// Work note group lock icon
	@FindBy(xpath = "//button[@id='incident.u_work_notes_group_lock']")
	public WebElement workNoteGroupLockIcon;

	// Watch List search drop down
	@FindBy(tagName = "select")
	public WebElement watchListDropDown;

	// Watch search text box
	@FindBy(xpath = "//div[@class='container-fluid ']/span/div/div/input")
	public WebElement watchSearchBox;

	// Top most entry
	@FindBy(xpath = "//tbody[@class='list2_body']/tr[1]/td[3]/a")
	public WebElement searchedTopEntry;

	// Business Service icon
	@FindBy(xpath = "//img[@src='/BS_Search.pngx']")
	public WebElement bussServIcon;

	// Click on OK button
	@FindBy(xpath = "//button[@id='ok_button']")
	public WebElement okButton;

	// Business Services category
	@FindBy(xpath = "//select[@id='category']")
	public WebElement catagory;

	// Business Services sub category
	@FindBy(xpath = "//select[@id='subcategory']")
	public WebElement subCatagory;

	// Business Services - Business Service
	@FindBy(xpath = "//select[@id='businessService']")
	public WebElement busServices;

	// Business Services - Email drop down
	@FindBy(xpath = "//div[@class='input-group']/span/span/select")
	public WebElement emailDropDown;

	// Business Services - Email search box
	@FindBy(xpath = "//div[@class='input-group']/input")
	public WebElement emailSearchBox;

	// Business Services - Sort Created option
	@FindBy(xpath = "//table[@id='sys_email_table']/thead/tr[1]/th[3]/span/a")
	public WebElement sortCreatedLink;

	// Business Services - Email subject box
	@FindBy(xpath = "//table[@id='sys_email_table']/thead/tr[2]/td[5]/div/div/div/input")
	public WebElement emailSubjectBox;

	// Business Services - Work Note User Added Message
	@FindBy(xpath = "//table[@id='sys_email_table']/tbody/tr[1]/td[5]")
	public WebElement workNoteUsrAddedMsg;

	// Business Services - Watch List User Added Message
	@FindBy(xpath = "//table[@id='sys_email_table']/tbody/tr[3]/td[5]")
	public WebElement watchNoteUsrAddedMsg;

	// Business Services - Watch List User Added Message2
	@FindBy(xpath = "//table[@id='sys_email_table']/tbody/tr[5]/td[5]")
	public WebElement watchNoteUsrAddedMsg2;

	// Order Guides->Search Email
	@FindBy(id = "filter")
	public WebElement emails_TxtBox;

	// Email
	@FindBy(css = "ul#collapseId3>li:nth-of-type(1)>a")
	public WebElement emails_Link;

	public CreateIncidentFrame(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnSubmitBtn() throws InterruptedException {
		logger.info("Clicking on submit button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		submitBtn.click();
		Thread.sleep(10000);
	}

	public String getDefaultImpactValue() {
		logger.info("Getting default impact value");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		Select impactSelect = new Select(incidentImpactSelect);
		String impactDefaultText = impactSelect.getFirstSelectedOption().getText();
		return impactDefaultText;
	}

	public String getDefaultUrgencyValue() {
		logger.info("Getting default urgency value");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		Select urgencySelect = new Select(incidentUrgencySelect);
		String urgencyDefaultText = urgencySelect.getFirstSelectedOption().getText();
		return urgencyDefaultText;
	}

	public String getDefaultPriorityValue() {
		logger.info("Getting default priority value");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		Select prioritySelect = new Select(incidentPrioritySelect);
		String priorityDefaultText = prioritySelect.getFirstSelectedOption().getText();
		return priorityDefaultText;
	}

	public void setRequestFor(String requestForValue) throws InterruptedException {
		logger.info("Setting Request For value");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		requestFor.sendKeys(requestForValue);
		Thread.sleep(3000);
	}

	public void setCompany(String companyValue) {
		logger.info("Setting Company value");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		company.sendKeys(companyValue);
	}

	public void setBusinessService(String businessServiceValue) {
		logger.info("Setting Business Service value");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		businessService.sendKeys(businessServiceValue);
	}

	public void setShortDescription(String shortDescriptionValue) {
		logger.info("Setting value for Short Description");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		shortDescription.sendKeys(shortDescriptionValue);
	}

	public String getIncidentNumberText() {
		logger.info("Geting Incident Number Text");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		return incidentNumberTextBox.getAttribute("value");
	}

	public String getIncidentOpenedAtText() {
		logger.info("Getting Incident Opened At text");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		return incidentOpenedAt.getAttribute("value");

	}

	public void pressEnterUsingKeyboardKey22(WebElement ele) throws InterruptedException {
		logger.info("Pressing enter using keys present on keyboard");
		ele.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", searchedTopEntry);

	}

	public void selectBusinessService(String businessService) throws InterruptedException {
		logger.info("Setting Business Services");
		typeText(busiSerTxtBox, businessService);
	}

	public void selectBusinessServiceAltOtion() throws InterruptedException {
		logger.info("Setting Business Services");
		click(bussServIcon);
		Thread.sleep(2000);
		selectOption(catagory, "Data Center");
		Thread.sleep(2000);
		selectOption(subCatagory, "Server Environment (Delivery of HW/SW)");
		Thread.sleep(2000);
		selectOption(busServices, "HAL IT Data Center Services");
		Thread.sleep(2000);
		click(okButton);
	}

	public String getIncidentNumber() throws InterruptedException {
		logger.info("Getting incident number");
		return (number.getText());
	}

	public void setImpactValue() throws InterruptedException {
		logger.info("Setting Impact value");
		selectOption(incidentImpactSelect, prop.getProperty("impact"));
	}

	public void setAssignedToValue(String assignedToValue) throws InterruptedException {
		logger.info("Setting Assigned To value");
		assignedTo.sendKeys(assignedToValue);
		Thread.sleep(3000);
	}

	public void setUrgencyValue() throws InterruptedException {
		logger.info("Setting Urgency value");
		selectOption(incidentUrgencySelect, prop.getProperty("urgency"));
		Thread.sleep(2000);
	}

	public String getValueFromCompanyIcon() throws InterruptedException, AWTException {
		logger.info("Getting value from Company icon");
		// Thread.sleep(1000);
		click(companyIcon);
		Thread.sleep(3000);
		// Robot robot = new Robot();
		// robot.keyPress(KeyEvent.VK_SHIFT);
		String company_part1 = getAttribute(companyAbbre, "value");
		String company_part2 = getAttribute(companyCode, "value");
		// robot.keyRelease(KeyEvent.VK_SHIFT);
		Thread.sleep(2000);
		String company = company_part1 + " - " + company_part2;
		return company;

	}

	public void close() {
		logger.info("Clicking on Close button");
		click(closeButton);
	}

	public void clickOnNotes() {
		logger.info("Clicking on Notes button");
		click(notes);
	}

	public String getValueFromDeptIcon() throws InterruptedException, AWTException {
		logger.info("Getting value from department icon");
		Thread.sleep(2000);
		moveToElement(deptIcon);
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_SHIFT);
		String deptValue = getAttribute(deptAbbre, "value");
		robot.keyRelease(KeyEvent.VK_SHIFT);
		return deptValue;
	}

	public String getValueFromLocationIcon() throws InterruptedException, AWTException {
		logger.info("Getting value from location icon");
		Thread.sleep(2000);
		moveToElement(locIcon);
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_SHIFT);
		String locationValue = getAttribute(locAbbre, "value");
		robot.keyRelease(KeyEvent.VK_SHIFT);
		return locationValue;
	}

	public void clickOnPopUp() throws InterruptedException {
		logger.info("Clicking on pop up");
		click(closePopUp);
		Thread.sleep(2000);
	}

	public void selectWatchGroups() throws InterruptedException {
		logger.info("Selecting watch groups");
		click(watchListGroup);
		click(workGroupLookUp);
		switchToChildWindowAndSelectGroup();
		switchToDefaultiFrame();
		click(workGroupLockIcon);
	}

	public void selectNotesGroups() throws InterruptedException {
		logger.info("Selecting notes groups");
		click(workNoteGroup);
		click(workNoteGroupLookUp);
		switchToChildWindowAndSelectGroup();
		switchToDefaultiFrame();
		click(workNoteGroupLockIcon);
	}

	public void searchLogs(String inc) throws InterruptedException {
		logger.info("Search Email Logs");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		typeText(emailSubjectBox, inc);
		pressEnterUsingKeyboardKey(emailSubjectBox);

	}

	public String getSubjectTextFromEmails(WebElement ele, String text) throws InterruptedException {
		logger.info("Gettimg Subject Text From Emails");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();

		return text;

	}

	public void addWatchUsers(WebElement unlockIcon, WebElement lookUp, String userGroup) throws InterruptedException {
		logger.info("Add watch users");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		String gg = getParentWindowHandle();
		click(unlockIcon);
		click(lookUp);
		switchToChildWindow();
		selectOption(watchListDropDown, "for text");
		typeText(watchSearchBox, userGroup);
		pressEnterUsingKeyboardKey22(watchSearchBox);
		Thread.sleep(2000);
		switchToParentWindowTry(gg);
		Thread.sleep(2000);
		switchToDefaultiFrame();
	}

	public void searchEmails() throws InterruptedException {
		Thread.sleep(5000);
		switchToDefaultContent();
		Thread.sleep(4000);
		typeText(emails_TxtBox, prop.getProperty("emails"));
		Thread.sleep(5000);
		switchToDefaultContent();
		click(emails_Link);
	}

	public void clearSearchEmails() throws InterruptedException {
		Thread.sleep(5000);
		switchToDefaultContent();
		Thread.sleep(4000);
		clearText(emails_TxtBox);
		Thread.sleep(5000);
		switchToDefaultContent();
	}
}
