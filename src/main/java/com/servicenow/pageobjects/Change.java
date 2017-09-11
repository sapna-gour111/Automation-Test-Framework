package com.servicenow.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.servicenow.utils.Constants;
import com.servicenow.utils.PropertiesLoader;

public class Change extends IFrameBase {
	static PropertiesLoader prop = new PropertiesLoader(Constants.PROPERTY_FILE_PATH);
	List<WebElement> list1 = null;
	List<WebElement> list2 = null;
	List<WebElement> list3 = null;

	public Change(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// Change -> Select Change type
	@FindBy(xpath = "//form[@id='wizard']/div[3]/a")
	public WebElement selectChangeType_Link;

	// Change -> Change number text box
	@FindBy(xpath = "//div[@id='element.change_request.number']/div[2]/input[2]")
	public WebElement changeNumberTextBox;

	// Change -> Change request For text box
	@FindBy(xpath = "//input[@id='sys_display.original.change_request.requested_by']")
	public WebElement changeRequestForFromApp;

	// Change -> Change Service Organization
	@FindBy(xpath = "//input[@id='sys_display.original.change_request.u_service_organization']")
	public WebElement changeSerOrg;

	// Change -> Change request For text box
	@FindBy(xpath = "//input[@id='sys_display.change_request.requested_by']")
	public WebElement changeRequestFor;

	// Change -> Change Location
	@FindBy(xpath = "//input[@id='sys_display.original.change_request.location']")
	public WebElement changeLocation;

	// Change -> Change Department
	@FindBy(xpath = "//input[@id='sys_display.original.change_request.u_department']")
	public WebElement changeDepartment;

	// Change -> Change Category
	@FindBy(xpath = "//input[@id='sys_original.change_request.category']")
	public WebElement changeCategory;

	// Change -> Change Assignment Group
	@FindBy(xpath = "//input[@id='sys_display.original.change_request.assignment_group']")
	public WebElement changeAssignGroup;

	// Change -> Change Business Service
	@FindBy(xpath = "//input[@id='sys_display.original.change_request.u_business_service']")
	public WebElement changeBussServiceFromApp;

	// Change -> Change Short Description
	@FindBy(xpath = "//input[@id='sys_display.change_request.short_description']")
	public WebElement changeShortDescFromApp;

	// Change -> Change Request Company
	@FindBy(xpath = "//input[@id='sys_display.original.change_request.company']")
	public WebElement changeCompany;

	// Change -> Change Business Service
	@FindBy(xpath = "//input[@id='sys_display.change_request.u_business_service']")
	public WebElement changeBussService;

	// Change -> Change Short Description
	@FindBy(xpath = "//input[@id='change_request.short_description']")
	public WebElement changeShortDesc;

	// Change -> Change Description
	@FindBy(xpath = "//textarea[@name='change_request.description']")
	public WebElement changeDesc;

	// Change -> Assigned to text box
	@FindBy(id = "sys_display.change_request.assigned_to")
	public WebElement assignedTo;

	// Change -> Change Request add stake Holder
	@FindBy(xpath = "//div[@class='form-group is-required']/div[2]/button[2]")
	public WebElement addStakeHolder;

	// Change -> CTask1 assignment group
	@FindBy(xpath = "//table[@id='change_request.change_task.change_request_table']/tbody/tr/td[7]/a")
	public WebElement cTaskAssGroup;

	// Change -> CTask assigned to field
	@FindBy(xpath = "//table[@id='change_request.change_task.change_request_table']/tbody/tr/td[8]/a")
	public WebElement cTaskAssiTo;

	// Change -> CTask Reject comment
	@FindBy(xpath = "//textarea[@id='activity-stream-comments-textarea']")
	public WebElement rejectComment;

	// Change-> Change Task
	@FindBy(xpath = "//div[@id='tabs2_list']/span[4]/span/span[2]")
	public WebElement changeTaskTab;

	// Change-> Upgrade/Downgrade Change Task button
	@FindBy(xpath = "//span[@class='navbar_ui_actions']/button[4]")
	public WebElement upgradeDowngradeChange;

	// Change-> Upgrade/Downgrade Change Task Type
	@FindBy(xpath = "//div[@id='element.change_request.type']/div[2]/input")
	public WebElement upgradeDowngradeChangeType;

	// Change -> Change Number search box
	@FindBy(css = "#change_request_hide_search>div>div>input")
	public WebElement changeSearchBox;

	// Change -> Change Bread crumb All link
	@FindBy(xpath = "//span[@id='change_request_breadcrumb']/a[1]")
	public WebElement changeAllLink;

	// Change -> Click on Change button
	@FindBy(xpath = "//div[contains(text(),'Create Change')]")
	public WebElement changeButton;

	// Change -> Change Manager
	@FindBy(xpath = "//input[@id='sys_display.change_request.u_change_manager']")
	public WebElement changeMngr;

	// Change -> Start date
	@FindBy(xpath = "//input[@id='change_request.start_date']")
	public WebElement startDate;

	// Change -> End date
	@FindBy(xpath = "//input[@id='change_request.end_date']")
	public WebElement endDate;

	// Change -> Approvers Tab
	@FindBy(xpath = "//div[@id='tabs2_list']/span[3]/span/span[2]")
	public WebElement approversTab;

	// Change -> Change Task link
	@FindBy(xpath = "//table[@id='change_request.change_task.change_request_table']/tbody/tr[1]/td[3]/a")
	public WebElement cTaskLink;

	// Change -> Change The state
	@FindBy(xpath = "//table[@id='change_request.change_task.change_request_table']/tbody/tr[1]/td[6]")
	public WebElement changeState;

	// Change -> Change Request description
	@FindBy(id = "change_request.description")
	public WebElement changeReqDesc;

	// Change -> CTask closure Info
	@FindBy(xpath = "//div[@id='tabs2_section']/span[3]/span[1]")
	public WebElement closureInfo;

	// Change -> CTask close
	@FindBy(xpath = "//div[@class='form_action_button_container']/button[2]")
	public WebElement closetask;

	// Change -> Open CTask to approve
	@FindBy(xpath = "//table[@id='change_request.sysapproval_approver.sysapproval_table']/tbody/tr[1]/td[2]/a")
	public WebElement openCtaskToAppr;

	// Change -> Change CTask state
	@FindBy(xpath = "//select[@id='sysapproval_approver.state']")
	public WebElement selectState;

	// Change -> Update CTask state
	@FindBy(xpath = "//button[@id='sysverb_update']")
	public WebElement updateCTask;

	// Change -> CTask closure notes
	@FindBy(xpath = "//textarea[@id='change_task.close_notes']")
	public WebElement cTaskCloseNotes;

	// Change -> CTask assigned to field
	@FindBy(xpath = "//input[@id='sys_display.change_task.assigned_to']")
	public WebElement cTaskassignTo;

	// Change -> CTask approver list
	@FindBy(xpath = "//table[@id='change_request.sysapproval_approver.sysapproval_table']/tbody/tr/td[3]/a")
	public WebElement approverList;

	// Change -> Change disabled state after wf completion
	@FindBy(xpath = "//select[@name='sys_readonly.change_request.state']")
	public WebElement changedisabledState;

	// Change -> Incident close notes
	@FindBy(id = "incident.close_notes")
	public WebElement closeNote;

	// Change -> Service Owner
	@FindBy(xpath = "//input[@id='sys_display.change_request.u_service_owner']")
	public WebElement serOwner;

	// Change -> Back button
	@FindBy(xpath = "//div[@class='navbar-header']/button[1]")
	public WebElement backButton;

	// Change -> Service Owner
	@FindBy(xpath = "//span[contains(text(),'Schedule')]")
	public WebElement scheduleTab;

	// Change -> ESS Short Description
	@FindBy(xpath = "//div[@class='row sc-row']/div/div[2]/input[2]")
	public WebElement shortDescForEss;

	public void selectChangeTypeFromApp(WebElement ele) {
		logger.info("Selecting Change Type from Change application");
		click(ele);
	}

	public void enterChangeDetailsFromApp() throws InterruptedException {
		logger.info("Filling Change form from Application");
		typeText(changeRequestFor, prop.getProperty("requestFor"));
		typeText(changeBussService, prop.getProperty("busSer"));
		typeText(changeShortDesc, "test");
		typeText(changeDesc, "test");
		typeText(assignedTo, prop.getProperty("requestFor"));
		click(addStakeHolder);
		Thread.sleep(2000);

	}

	public String getCTaskStatus() {
		logger.info("Getting Ctask status");
		click(changeTaskTab);
		int i = 0;
		String state = "";
		list3 = driver
				.findElements(By.xpath("//div[@id='change_request.change_task.change_request']/table/tbody/tr/td[6]"));
		for (i = 0; i < list3.size(); i++) {
			if (list3.get(i).getText().equalsIgnoreCase("New")) {
				state = list3.get(i).getText();

			}
		}
		return state;
	}

	public void upgradeDowngradeChange(WebElement ele) {
		logger.info("Upgrading change");
		click(ele);
	}

	public void enterDesc() throws InterruptedException {
		logger.info("Clicking on pop up");
		typeText(changeDesc, "test");
	}

	public String getChangeNumberText() {
		logger.info("Geting Change Number Text");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		return changeNumberTextBox.getAttribute("value");
	}

	public void createChange() {
		logger.info("Create the Change Request");
		changeButton.click();
	}

	public void enterCloseNotes() throws InterruptedException {
		logger.info("Enter Close Notes");
		typeText(closeNote, "Test close notes ");
	}

	public void clickOnBackButton() throws InterruptedException {
		logger.info("Click On Back Button");
		click(backButton);
	}

	public void enterEssShortDesc() throws InterruptedException {
		logger.info("Enter ESS short descriptin");
		typeText(shortDescForEss, "test");
	}

	public void enterChangeManager() throws InterruptedException {
		logger.info("Enter Change manager");
		typeText(changeMngr, prop.getProperty("requestFor"));
	}

	public void enterServiceOwner() throws InterruptedException {
		logger.info("Enter Service Owner");
		typeText(serOwner, prop.getProperty("requestFor"));
	}

	public void clickOnScheduleTab() {
		logger.info("Click On Schedule tab");
		click(scheduleTab);
	}

	public void enterDatesAndChangeDetails() throws InterruptedException {
		logger.info("Enter start and end change date");
		click(addStakeHolder);
		typeText(changeReqDesc, "test");
		typeText(startDate, prop.getProperty("startDate"));
		typeText(endDate, prop.getProperty("endDate"));
	}

	public void clickOnchangeTask() throws InterruptedException {
		logger.info("Click On Change task");
		Thread.sleep(3000);
		click(changeTaskTab);
	}

	public void selectRequestedCTasks(String state) throws InterruptedException {
		logger.info("Approving CTask");

		int j = 0;
		int i = 0;
		click(approversTab);
		list1 = driver.findElements(
				By.xpath("//table[@id='change_request.sysapproval_approver.sysapproval_table']/tbody/tr/td[3]/a"));
		for (i = 0; i < list1.size(); i++) {
			if (list1.get(i).getText().equalsIgnoreCase("Requested")) {
				j = i + 1;
				driver.findElement(
						By.xpath("//table[@id='change_request.sysapproval_approver.sysapproval_table']/tbody/tr[" + j
								+ " ]/td[2]/a"))
						.click();
				selectOption(selectState, state);
				if (state.equalsIgnoreCase("Rejected")) {
					typeText(rejectComment, "test");
				}
				click(updateCTask);
				Thread.sleep(6000);
				break;
			}
		}
	}

	public void closeCTask() throws InterruptedException {
		logger.info("Close Ctask");
		click(changeTaskTab);
		int j = 0;
		int i = 0;

		list2 = driver
				.findElements(By.xpath("//div[@id='change_request.change_task.change_request']/table/tbody/tr/td[6]"));
		for (i = 0; i < list2.size(); i++) {
			if (list2.get(i).getText().equalsIgnoreCase("New") || list2.get(i).getText().equalsIgnoreCase("Active")) {
				j = i + 1;
				driver.findElement(By.xpath(
						"//table[@id='change_request.change_task.change_request_table']/tbody/tr[" + j + " ]/td[2]/a"))
						.click();
				Thread.sleep(3000);
				clearText(cTaskassignTo);
				typeText(cTaskassignTo, prop.getProperty("requestFor"));
				click(closureInfo);
				typeText(cTaskCloseNotes, "CTask closure notes");
				Thread.sleep(4000);
				click(closetask);
				Thread.sleep(6000);
				break;
			}
		}

	}

}
