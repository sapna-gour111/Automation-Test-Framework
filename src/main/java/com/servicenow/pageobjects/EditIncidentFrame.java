package com.servicenow.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.servicenow.utils.Constants;
import com.servicenow.utils.PropertiesLoader;

/**
 * This class contains pageobjects & methods to perform action on web pages
 * 
 * @author Sapna Gour
 *
 */

public class EditIncidentFrame extends IFrameBase {
	static PropertiesLoader prop = new PropertiesLoader(Constants.PROPERTY_FILE_PATH);
	// Edit Incident->Service Outage checkbox
	@FindBy(xpath = "//label[@id='label.ni.incident.u_major_incident']")
	public WebElement serviceOutage_chkbox;

	// Edit Incident->Customer's Contact text box
	@FindBy(xpath = "//*[contains(@class,'input-group')]/input[contains(@data-ref,'incident.u_incident_owner')]")
	public WebElement customerContact_txt;

	// Edit Incident->Business service text box
	@FindBy(xpath = "//*[contains(@class,'input-group')]/input[contains(@data-ref,'incident.u_business_service')]")
	public WebElement businessService_txt;

	// Edit Incident->Configuration item text box
	@FindBy(xpath = "//*[contains(@class,'input-group')]/input[contains(@data-ref,'incident.cmdb_ci')]")
	public WebElement configurationItem_txt;

	// Edit Incident->Service Outage tab
	@FindBy(xpath = "//div/span[5]/span/span[2]")
	public WebElement serviceOutageTab_lnk;

	// Edit Incident->Impacted Company text box
	@FindBy(xpath = "//*[contains(@class,'input-group')]/input[contains(@data-ref,'incident.u_outage_company')]")
	public WebElement impactedCompany_txt;

	// Edit Incident->Outage Importance drop down
	@FindBy(xpath = ".//*[@id='incident.u_outage_importance']")
	public WebElement serviceOutage_imp;

	// Edit Incident->Outage state drop down
	@FindBy(xpath = "//select[@id='incident.u_outage_state']")
	public WebElement serviceOutage_state;

	// Edit Incident->Outage type drop down
	@FindBy(xpath = ".//*[@id='incident.u_outage_type']")
	public WebElement serviceOutage_type;

	// Edit Incident->Impacted Company text box
	@FindBy(xpath = ".//*[@id='sys_display.incident.u_outage_company']")
	public WebElement serviceOutage_comp;

	// Edit Incident->Number of user affected drop down
	@FindBy(xpath = ".//*[@id='incident.u_number_of_users_affected']")
	public WebElement serviceOutage_noofuser;

	// Edit Incident->Outage cause drop down
	@FindBy(xpath = ".//*[@id='incident.u_root_cause']")
	public WebElement serviceOutage_rootcause;

	// Edit Incident->Outage time zone drop down
	@FindBy(xpath = ".//*[@id='incident.u_outage_time_zone']")
	public WebElement serviceOutage_timezone;

	// Edit Incident->Outage outbreak at text box
	@FindBy(xpath = ".//*[@id='incident.u_outage_outbreak_at']")
	public WebElement serviceOutage_outbreak_at;

	// Edit Incident->Outage Recognition at text box
	@FindBy(xpath = ".//*[@id='incident.u_outage_recognition_at']")
	public WebElement serviceOutage_recognization_at;

	// Edit Incident->Outage recovery at text box
	@FindBy(xpath = ".//*[@id='incident.u_outage_recovery_at']")
	public WebElement serviceOutage_recovery_at;

	// Edit Incident->Outage description text box
	@FindBy(xpath = ".//*[@id='incident.u_outage_description']")
	public WebElement serviceOutage_descrip;

	// Edit Incident->Incident Opened at text box
	@FindBy(xpath = ".//*[@id='sys_readonly.incident.opened_at']")
	public WebElement incident_opened_at;

	// Edit Incident->Click on Incident number
	@FindBy(xpath = "//tbody/tr/td[3]/a")
	public WebElement incident_number;

	// Edit Incident->SONGS preview OK button
	@FindBy(xpath = "//button[@class='btn btn-default']")
	public WebElement SONGS_preview_ok_button;

	// Edit Incident->SONGS announcement message
	@FindBy(xpath = "//div[@class='outputmsg_text']")
	public WebElement outageAnnouncMsg;

	// Edit Incident->Closure Information tab
	@FindBy(xpath = "//div[@id='tabs2_section']/span[4]/span[1]/span[2]")
	public WebElement closureInfoTab;

	// Edit Incident->Notes tab
	@FindBy(xpath = "//div[@id='tabs2_section']/span[1]/span[1]/span[2]")
	public WebElement notesTab;

	// Edit Incident->SONG incident resolve message
	@FindBy(xpath = "//div[@class='outputmsg_div']/div[1]/div[1]/div[1]")
	public WebElement songIncResolvedMsg;

	// Edit Incident->SONG incident resolve message
	@FindBy(xpath = "//div[@class='outputmsg_div']/div[1]/div[1]")
	public WebElement songIncResolvedMsg2;

	// Edit Incident->SONG incident announcement message2
	@FindBy(xpath = "//div[@class='outputmsg_div']/div[2]/div[1]")
	public WebElement outageAnnouncMsg2;

	public EditIncidentFrame(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnserviceOutage() throws InterruptedException {
		logger.info("Clicking on Service Outage");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		serviceOutage_chkbox.click();
	}

	public String getcustomerContact() {
		logger.info("Geting Customer contacts");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		return customerContact_txt.getAttribute("value");
	}

	public void clearBusinessService() {
		logger.info("Clearing business service");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		businessService_txt.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		businessService_txt.sendKeys(Keys.DELETE);
	}

	public void clickOnBusinessService() {
		logger.info("Clicking on business service");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		businessService_txt.click();
	}

	public void clickOnconfigurationItem() {
		logger.info("Clicking on configuration item");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		configurationItem_txt.clear();
		configurationItem_txt.click();
	}

	public void clickOnServiceOutageTab() {
		logger.info("Clicking on Service Outage tab");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		serviceOutageTab_lnk.click();
	}

	public void clickOnSearchedIncident() {
		logger.info("Clicking on searched incident number");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		incident_number.click();
	}

	public void typeBusinessService(String value) {
		logger.info("Setting Business service value");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		clearBusinessService();
		businessService_txt.sendKeys(value);
	}

	public String verifyOutageState() {
		logger.info("Verifying outage state");
		Select selectList = new Select(serviceOutage_state);
		String selectedText = selectList.getFirstSelectedOption().getText();
		return selectedText;
	}

	public String outageOutbreakAt() {
		logger.info("Getting outage break at value");
		String outbreakAt = serviceOutage_outbreak_at.getAttribute("value");
		return outbreakAt;
	}

	public String incidentOpenedAt() {
		logger.info("Getting incident opened at value");
		String openedAt = incident_opened_at.getAttribute("value");
		return openedAt;
	}

	public String outageRecoveryAt() {
		logger.info("Getting outage recovery at value");
		String recoveryAt = serviceOutage_recovery_at.getAttribute("value");
		return recoveryAt;
	}

	public void selectOutageType(String outageType) throws InterruptedException {
		logger.info("Selecting Outage Type");
		selectOption(serviceOutage_type, outageType);
	}

	public void selectNoOfUser(String noofuser) throws InterruptedException {
		logger.info("Selecting number of user");
		selectOption(serviceOutage_noofuser, noofuser);

	}

	public void selectoutageRecovery(String recoveryValue) throws InterruptedException {
		logger.info("Selecting recovery value");
		typeText(serviceOutage_recovery_at, recoveryValue);

	}

	public void selectOutageCause(String outageCause) throws InterruptedException {
		logger.info("Selecting outage cause");
		selectOption(serviceOutage_rootcause, outageCause);

	}

}