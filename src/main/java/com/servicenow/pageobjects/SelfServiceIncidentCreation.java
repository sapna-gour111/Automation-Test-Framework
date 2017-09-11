package com.servicenow.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.servicenow.utils.Constants;
import com.servicenow.utils.PropertiesLoader;

/**
 * This class contains page objects & methods to perform action on Self service
 * -> Get help on new incident frame
 * 
 */

public class SelfServiceIncidentCreation extends IFrameBase {
	static PropertiesLoader prop = new PropertiesLoader(Constants.PROPERTY_FILE_PATH);

	public SelfServiceIncidentCreation(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// SelfService->Select classification options
	@FindBy(css = "span>div>div:nth-of-type(1)>table>tbody>tr:nth-of-type(1)>td>div>div>div:nth-of-type(2)>select")
	public WebElement selectClassification_Btn;

	// SelfService->Explanation phrase options
	@FindBy(xpath = "//*[@class='form-group  sc-row']/descendant::*[contains(text(),'Select one phrase from the list that best explains')]/../../../descendant::Select")
	public WebElement explainationPhrases;

	// SelfService->Describe issue text field
	@FindBy(css = ".iotd>div>div>div:nth-of-type(2)>textarea")
	public WebElement describeIssueTextFld;

	// SelfService->Submit Button
	@FindBy(css = "#submit_button")
	public WebElement submitButton;

	// SelfService->Incident Status
	@FindBy(css = ".sn-widget>ul>li:nth-of-type(3)>span:nth-of-type(2)>span")
	public WebElement incidentStatus;

	// SelfService->Messages displayed after Incident creation
	@FindBy(css = "#output_messages>div>div>div")
	public WebElement incidentMessages;

	// SelfService->Incident Number
	@FindBy(id = "incident.number")
	public WebElement incidentNumber;

	// SelfService->Incident Number search box
	@FindBy(css = "#incident_hide_search>div>div>input")
	public WebElement incidentNumberSearchBox;

	// SelfService->Incident Number search box to enter key
	@FindBy(xpath = "//input[@class='form-control']")
	public static WebElement incidentNumberSearchBoxXpath;

	// SelfService->Searched incident
	@FindBy(css = ".list2_body>tr>td:nth-of-type(3)>a")
	public WebElement searchedIncident;

	// SelfService->Update incident
	@FindBy(css = "#sysverb_update")
	public WebElement updateIncident;

	// SelfService->Request for text field
	@FindBy(id = "sys_display.incident.caller_id")
	public WebElement requestForFld;

	// SelfService->Edit watch List
	@FindBy(id = "incident.watch_list_unlock")
	public WebElement editWatchList;

	// SelfService->Text value for watch List
	@FindBy(id = "text.value.incident.watch_list")
	public WebElement watchListText;

	// SelfService->Short description
	@FindBy(id = "incident.short_description")
	public WebElement shortDesc;

	// SelfService->Additional activity
	@FindBy(id = "activity-stream-comments-textarea")
	public WebElement addComment;

	// SelfService->Added watch list
	@FindBy(id = "incident.watch_list_nonedit")
	public WebElement addedWatchList;

	// SelfService->Post button
	@FindBy(css = ".activity_table>tbody>tr>td>div>div>div>div>form>div>div:nth-of-type(2)>div>button")
	public WebElement postButton;

	// SelfService->Additional comment text
	@FindBy(css = ".activity_table>tbody>tr>td>div>div>div>div:nth-of-type(3)>ul>li:nth-of-type(1)>div>div:nth-of-type(3)>div>span")
	public WebElement addCommText;

	// SelfService->Email button
	@FindBy(css = "#ddebf22219e0a000f1e33aa03dbcf69e>div:nth-of-type(4)>div>div:nth-of-type(2)>div:nth-of-type(2)>span>div:nth-of-type(3)>span>button")
	public WebElement emailButton;

	// SelfService->Incident header
	@FindBy(css = ".container-fluid")
	public WebElement incidentHeader;

	// SelfService->Context menu > Save
	@FindBy(css = "#context_1>div:nth-of-type(2)")
	public WebElement saveContextBtn;

	// SelfService->Context menu > Export
	@FindBy(css = "#context_1>div:nth-of-type(13)")
	public WebElement exportContextBtn;

	// SelfService->Context menu > Copy URL
	@FindBy(css = "#context_1>div:nth-of-type(17)")
	public WebElement copyURLContextBtn;

	// SelfService->Context menu > Reload Form
	@FindBy(css = "#context_1>div:nth-of-type(21)")
	public WebElement reloadFormContextBtn;

	// SelfService->Incident Number
	@FindBy(id = "incident.number")
	public WebElement incNo_lbl;

	// SelfService->Request for field
	@FindBy(id = "sys_display.incident.caller_id")
	public WebElement reqFor_lbl;

	// SelfService->Opened field
	@FindBy(id = "sys_readonly.incident.opened_at")
	public WebElement opened_lbl;

	// SelfService->Closed field
	@FindBy(xpath = "//span[contains(text(),'Closed')]")
	public WebElement closed_lbl;

	// SelfService->State field
	@FindBy(xpath = "//div[@id='element.incident.state']/div[1]/label/span[2]")
	public WebElement state_lbl;

	// SelfService->Sub State field
	@FindBy(xpath = "//div[@id='element.incident.u_substate']/div[1]/label/span[2]")
	public WebElement subState_lbl;

	// SelfService->Support level field
	@FindBy(xpath = "//div[@id='element.incident.assignment_group.u_support_level']/div[1]/label/span[2]")
	public WebElement supportLevel_lbl;

	// SelfService->Watch List field
	@FindBy(xpath = "//div[@id='element.incident.watch_list']/div[1]/label/span[2]")
	public WebElement watchList_lbl;

	// SelfService->Short description field
	@FindBy(xpath = "//div[@id='element.incident.short_description']/div[1]/label/span[2]")
	public WebElement shortDesc_lbl;

	// SelfService->Request for field
	@FindBy(xpath = "//span[@class='tab_header']/span/span[2]")
	public WebElement activities_lbl;

	// SelfService->User select for Loren Lew
	@FindBy(xpath = "//div[@id='select2-result-label-3']/div[1]")
	public WebElement userSelectForLew;

	// SelfService->User select for Ginny Gulati
	@FindBy(xpath = "//ul[@id='select2-results-2']/li/div/div[1]")
	public WebElement userSelectForGinny;

	// SelfService->Reload button
	@FindBy(xpath = "//div[@id='context_1']//div[contains(text(),'Reload form')]")
	public WebElement reloadButton;

	// SelfService->Go to field
	@FindBy(xpath = "//div[@class='input-group']/span/span/select")
	public WebElement goToDropDownButton;

	// SelfService->Bread crumb All link
	@FindBy(xpath = "//span[@id='incident_breadcrumb']/a")
	public WebElement allLink;

	// SelfService-> Incident Resolved Message
	@FindBy(xpath = "//div[@class='outputmsg_text']")
	public WebElement resolvedMsg;

	public void selectOptionFromClassified() throws InterruptedException {
		logger.info("Selecting option from classified");
		selectClassificationName(selectClassification_Btn, 2);
	}

	public void selectExpainationPhrase() throws InterruptedException {
		logger.info("Selecting explanation phrase");
		selectOptionByIndex(explainationPhrases, 1);
	}

	public void describeIssue() throws InterruptedException {
		logger.info("Entering text in Describe Issue field");
		describeIssueTextFld.sendKeys(prop.getProperty("describeIssueText"));
	}

	public void clickOnSubmitButton() {
		logger.info("Clicking on Submit button");
		submitButton.click();
	}

	public String verifyStateOnewIncident() {
		logger.info("Verifying state of new incident");
		return incidentStatus.getText();
	}

	public String verifyIncidentMessages() {
		logger.info("Verifying messages displayed after incident creation");
		return incidentMessages.getText();
	}

	public String getAttributeValue(WebElement ele) {
		logger.info("Getting incident number");
		return ele.getAttribute("value");
	}

	public void searchIncidentNumber(String number, WebElement ele) throws InterruptedException {
		logger.info("Searching incident by incident number");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		selectOption(goToDropDownButton, "Number");
		ele.clear();
		ele.sendKeys(number);
		pressEnterUsingKeyboardKey(ele);
	}

	public void pressEnterUsingKeyboardKey() throws InterruptedException {
		try {
			logger.info("Press enter key using keyboard key");
			WebDriverWait wait = new WebDriverWait(driver, 300);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@class='form-control']")));
			pressEnterUsingKeyboardKey(incidentNumberSearchBoxXpath);
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

	}

	public void clickOnSearchedIncident() {
		try {
			logger.info("Selecting searched incident");
			WebDriverWait wait = new WebDriverWait(driver, 300);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@class='form-control']")));
			searchedIncident.click();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}
	}

	public void editNumberFld() throws InterruptedException {
		logger.info("Editing number field");
		incidentNumber.clear();
		incidentNumber.sendKeys(prop.getProperty("numberFld"));
	}

	public void editReqForFld() throws InterruptedException {
		logger.info("Editing request for field");
		requestForFld.clear();
		requestForFld.sendKeys(prop.getProperty("requestForFld"));
	}

	public void editWatchList() throws InterruptedException {
		logger.info("Editing watch List");
		editWatchList.click();
		watchListText.clear();
		watchListText.sendKeys(prop.getProperty("watchListText"));
		emailButton.click();
	}

	public void enterShortDesc() throws InterruptedException {
		logger.info("Entering short description");
		shortDesc.clear();
		shortDesc.sendKeys(prop.getProperty("shortDesc"));
	}

	public void enterAddCommText() throws InterruptedException {
		logger.info("Adding additional comment for activity");
		addComment.clear();
		addComment.sendKeys(prop.getProperty("addComment"));
		postButton.click();
	}

	public void clickOnUpdateIncident() {
		logger.info("Clicking on update incident button");
		updateIncident.click();
	}

	public void contextClick() {
		logger.info("Right clicking on element");
		Actions act = new Actions(driver);
		act.contextClick(incidentHeader).perform();
	}

	public void reloadForm() {
		logger.info("Reload the form");
		reloadButton.click();
	}

}
