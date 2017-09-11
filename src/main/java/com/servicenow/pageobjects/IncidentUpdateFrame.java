package com.servicenow.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class IncidentUpdateFrame extends IFrameBase {

	// Update incident button
	@FindBy(xpath = "(.//*[@id='sysverb_update'])[2]")
	public WebElement updateBtn;

	// Incident state drop down
	@FindBy(xpath = "//*[@name='incident.state']/../select")
	public WebElement incidentStateSelect;

	// Incident category drop down
	@FindBy(xpath = "//*[@name='incident.category']/../select")
	public WebElement incidentCategorySelect;

	// Additional comments textarea
	@FindBy(id = "activity-stream-comments-textarea")
	public WebElement additionalComments;

	// notification notification-info outputmsg outputmsg_info
	// outputmsg_has_text
	@FindBy(xpath = "//*[@class='notification notification-info outputmsg outputmsg_info outputmsg_has_text']")
	public WebElement notification;

	// Closure information tab
	@FindBy(xpath = "//div/span[4]/span/span[2]")
	public WebElement closureInfoTab;

	// Select close code drop down
	@FindBy(xpath = "//*[@name='incident.close_code']/../select")
	public WebElement selectCloseCode;

	// Select close note text box
	@FindBy(xpath = "//*[@id='incident.close_notes']")
	public WebElement closeNotes;

	// Status get text
	@FindBy(xpath = "//tbody/tr/td[6]")
	public WebElement status;

	public IncidentUpdateFrame(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnUpdateBtn() {
		logger.info("Clicking on update button");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		updateBtn.click();
		synchronize();
	}

	public String getDefaultIncidentState() {
		logger.info("Getting incident state");
		switchToDefaultiFrame();
		return (status.getText());
	}

	public void setIncidentState(String newState, String category, String addComments) {
		logger.info("Setting incident state");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		Select stateSelect = new Select(incidentStateSelect);
		stateSelect.selectByVisibleText(newState);
		Select categorySelect = new Select(incidentCategorySelect);
		categorySelect.selectByVisibleText(category);
		additionalComments.sendKeys(addComments);
	}

	public String getNotificationText() {
		logger.info("Getting notification state");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		return notification.getText();
	}

	public void clickOnClosureInfoTab() {
		logger.info("Clicking on closure info tab");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		closureInfoTab.click();
		synchronize();
	}

	public void setCloseCode(String closeCode) {
		logger.info("Setting close code");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		Select closeCodeSelect = new Select(selectCloseCode);
		closeCodeSelect.selectByVisibleText(closeCode);
		synchronize();
	}

	public void setCloseNotes(String closeNotesText) {
		logger.info("Setting close notes");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		closeNotes.sendKeys(closeNotesText);
		synchronize();
	}

}
