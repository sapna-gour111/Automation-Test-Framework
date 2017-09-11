package com.servicenow.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FastAndFullView extends IFrameBase {

	public FastAndFullView(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// View -> Modules available under Fast View
	@FindBy(xpath = "//ul[@id='collapseId13']/li[1]/ul/li[1]/a")
	public WebElement createNewFast_Link;

	// View -> Modules available under Fast View
	@FindBy(xpath = "//ul[@id='collapseId14']/li[2]/a")
	public WebElement assignToMeFast_Link;

	// View -> Modules available under Fast View
	@FindBy(xpath = "//ul[@id='collapseId14']/li[3]/a")
	public WebElement openFast_Link;

	// View -> Modules available under Fast View
	@FindBy(xpath = "//ul[@id='collapseId14']/li[4]/a")
	public WebElement openUnassignFast_Link;

	// View -> Modules available under Fast View
	@FindBy(xpath = "//ul[@id='collapseId14']/li[5]/a")
	public WebElement myGroupFast_Link;

	// View -> Modules available under Fast View
	@FindBy(xpath = "//ul[@id='collapseId14']/li[6]/a")
	public WebElement myGroupUnassignFast_Link;

	// View -> Modules available under Fast View
	@FindBy(xpath = "//ul[@id='collapseId14']/li[7]/a")
	public WebElement resolvedFast_Link;

	// View -> Modules available under Fast View
	@FindBy(xpath = "//ul[@id='collapseId14']/li[8]/a")
	public WebElement closedFast_Link;

	// View -> Modules available under Fast View
	@FindBy(xpath = "//ul[@id='collapseId14']/li[9]/a")
	public WebElement allFast_Link;

	// View -> Modules available under Full View
	@FindBy(xpath = "//ul[@id='collapseId15']/li[1]/a")
	public WebElement createNewFull_Link;

	// View -> Modules available under Full View
	@FindBy(xpath = "//ul[@id='collapseId15']/li[2]/a")
	public WebElement assignToMeFull_Link;

	// View -> Modules available under Full View
	@FindBy(xpath = "//ul[@id='collapseId15']/li[3]/a")
	public WebElement openFull_Link;

	// View -> Modules available under Full View
	@FindBy(xpath = "//ul[@id='collapseId15']/li[4]/a")
	public WebElement openUnassignFull_Link;

	// View -> Modules available under Full View
	@FindBy(xpath = "//ul[@id='collapseId15']/li[5]/a")
	public WebElement myGroupFull_Link;

	// View -> Modules available under Full View
	@FindBy(xpath = "//ul[@id='collapseId15']/li[6]/a")
	public WebElement myGroupUnassignFull_Link;

	// View -> Modules available under Full View
	@FindBy(xpath = "//ul[@id='collapseId15']/li[7]/a")
	public WebElement resolvedFull_Link;

	// View -> Modules available under Full View
	@FindBy(xpath = "//ul[@id='collapseId15']/li[8]/a")
	public WebElement closedFull_Link;

	// View -> Modules available under Full View
	@FindBy(xpath = "//ul[@id='collapseId15']/li[9]/a")
	public WebElement allFull_Link;

	// View -> Incident Contact type
	@FindBy(id = "incident.contact_type")
	public WebElement contactType_Link;

	// View -> Company
	@FindBy(id = "sys_display.incident.company")
	public WebElement company_Link;

	// View -> Business service
	@FindBy(id = "sys_display.incident.cmdb_ci")
	public WebElement bussServ_Link;

	// View -> Configuration item
	@FindBy(id = "sys_display.incident.cmdb_ci")
	public WebElement confItem_Link;

	// View -> Type of issue
	@FindBy(id = "incident.u_type_of_issue")
	public WebElement typeOfIssue_Link;

	// View -> Category
	@FindBy(id = "incident.category")
	public WebElement category_Link;

	// View -> Sub category
	@FindBy(id = "incident.subcategory")
	public WebElement subCate_Link;

	// View -> Short description
	@FindBy(id = "incident.short_description")
	public WebElement shortDesc_Link;

	// View -> Description
	@FindBy(id = "incident.description")
	public WebElement description_Link;

	// View -> Watch list
	@FindBy(id = "incident.watch_list_unlock")
	public WebElement watchList_Link;

	// View -> Watch group
	@FindBy(id = "incident.u_watch_group_unlock")
	public WebElement watchGroup_Link;

	// View -> Work note
	@FindBy(id = "incident.work_notes_list_unlock")
	public WebElement workNote_Link;

	// View -> Work note group
	@FindBy(id = "incident.u_work_notes_group_unlock")
	public WebElement workNoteGroup_Link;

	// View -> Additional comment
	@FindBy(id = "incident.comments")
	public WebElement addComment_Link;

	// View -> Work note
	@FindBy(id = "incident.work_notes")
	public WebElement comment_Link;

	// View -> Close code
	@FindBy(id = "incident.close_code")
	public WebElement closeCode_Link;

	// View -> Opened
	@FindBy(id = "sys_readonly.incident.opened_at")
	public WebElement opened_Link;

	// View -> State
	@FindBy(id = "incident.state")
	public WebElement state_Link;

	// View -> Sub state
	@FindBy(id = "incident.u_substate")
	public WebElement subState_Link;

	// View -> Assignment group
	@FindBy(id = "sys_display.incident.assignment_group")
	public WebElement assignGroup_Link;

	// View -> Assigned To field
	@FindBy(id = "sys_display.incident.assigned_to")
	public WebElement assignTo_Link;

	// View -> Service Organization.
	@FindBy(id = "sys_display.incident.u_service_organization")
	public WebElement serOrg_Link;

	// View -> Impact field
	@FindBy(id = "incident.impact")
	public WebElement impact_Link;

	// View -> Urgency field
	@FindBy(id = "incident.urgency")
	public WebElement urgency_Link;

	// View -> Priority
	@FindBy(id = "sys_readonly.incident.priority")
	public WebElement priority_Link;

	// View -> Desire solution date
	@FindBy(id = "incident.due_date")
	public WebElement desireDate_Link;

	// View -> Close Notes
	@FindBy(id = "incident.close_notes")
	public WebElement closeNotes_Link;

	// View -> Notes tab
	@FindBy(xpath = "//div[@id='tabs2_section']/span[1]/span/span[2]")
	public WebElement notes_Tab;

	// View -> Time stamps and attachment tab
	@FindBy(xpath = "//div[@id='tabs2_section']/span[2]/span/span[2]")
	public WebElement timespampAndAttachment_Tab;

	// View -> Related Records tab
	@FindBy(xpath = "//div[@id='tabs2_section']/span[3]/span/span[2]")
	public WebElement relatedRecords_Tab;

	// View -> Closure Information tab
	@FindBy(xpath = "//div[@id='tabs2_section']/span[4]/span/span[2]")
	public WebElement closureInfo_Tab;

	// View -> Add comment for full view
	@FindBy(id = "activity-stream-comments-textarea")
	public WebElement addCommentForFullView;

	public void selectChangeTypeFromApp(WebElement ele) {
		logger.info("Selecting Change Type from Change application");
		click(ele);
	}

}
