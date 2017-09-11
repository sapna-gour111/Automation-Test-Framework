package com.servicenow.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.servicenow.pageobjects.HomePage;
import com.servicenow.pageobjects.IncidentOpenFrame;
import com.servicenow.pageobjects.IncidentUpdateFrame;
import com.servicenow.utils.Constants;
import com.servicenow.utils.ExcelReader;
import com.servicenow.utils.PropertiesLoader;
import com.servicenow.utils.ToolUtils;

/**
 * This class contains methods to perform base test actions
 * 
 * @author Sapna Gour
 *
 */
public class IncidentStateChangeTest extends BaseTest {

	HomePage homePage;
	ExcelReader readData;
	WebDriverWait wait;
	final String setupWaitLoadTime = "20";
    static String incidentNumberText = null;
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
		homePage = new HomePage(driver);
		homePage.incidentopenfrm = new IncidentOpenFrame(driver);
		homePage.incidentUpdateFrame = new IncidentUpdateFrame(driver);
		wait = new WebDriverWait(driver, Integer.parseInt(setupWaitLoadTime));
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(setupWaitLoadTime), TimeUnit.SECONDS);
	}

	/**
	 * This test method is to change state of incident and verify
	 * 
	 * @param incidentNumber
	 * @param newState
	 * @param category
	 * @param addComments
	 * @param closureCode
	 * @param CloseNotes
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "Update State Validations", priority = 1)
	public void changeState(String incidentNumber, String newState, String category, String addComments,
			String closureCode, String CloseNotes) throws InterruptedException {
		logger.info("*********************************");
		logger.info("IncidentStateChangeTest - changeState");
		logger.info("*********************************");

		homePage.clickOncreateNewIncidentButton();
		incidentNumberText = homePage.createIncidentFrame.getIncidentNumberText();
		Thread.sleep(10000);
		homePage.createIncidentFrame.setRequestFor(prop.getProperty("requestFor"));
		Thread.sleep(20000);
		Select categorySelect = new Select(homePage.createIncidentFrame.category);
		categorySelect.selectByVisibleText(category);
		homePage.createIncidentFrame.selectBusinessService(businessService);
		Thread.sleep(20000);
		homePage.createIncidentFrame.setShortDescription(prop.getProperty("shortDescription"));
		homePage.createIncidentFrame.clickOnSubmitBtn();
		Thread.sleep(10000);
		homePage.clickOnOpenIncident_Button();
		Thread.sleep(20000);
		homePage.clickOnOpenIncident_Button();
		Thread.sleep(10000);
		homePage.incidentopenfrm.clickOnIncidentNo(incidentNumberText);
		Thread.sleep(10000);
		homePage.incidentUpdateFrame.setIncidentState(newState, category, addComments);
		Thread.sleep(10000);
		homePage.incidentUpdateFrame.clickOnClosureInfoTab();
		Thread.sleep(10000);
		homePage.incidentUpdateFrame.setCloseCode(closureCode);
		Thread.sleep(10000);
		homePage.incidentUpdateFrame.setCloseNotes(CloseNotes);
		Thread.sleep(10000);
		homePage.incidentUpdateFrame.clickOnUpdateBtn();
		Thread.sleep(20000);
		// Final Verification
		homePage.clickOnMyIncidentButton();
		Thread.sleep(20000);
		homePage.gethelponincdntfrm.searchIncidentNumber(incidentNumberText, homePage.gethelponincdntfrm.incidentNumberSearchBox);
		homePage.gethelponincdntfrm.pressEnterUsingKeyboardKey();
		Thread.sleep(20000);
		Assert.assertEquals(newState, homePage.incidentUpdateFrame.getDefaultIncidentState());
		test.log(LogStatus.PASS, "Test for change state of incident is successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	@DataProvider(name = "Update State Validations")
	public Object[][] ServiceOutageValidations() throws Exception {
		readData = new ExcelReader();
		Object[][] retObjArr = readData.excelRead("ServiceNow_TestData.xlsx", "UpdateStateValidate");
		return retObjArr;
	}

}
