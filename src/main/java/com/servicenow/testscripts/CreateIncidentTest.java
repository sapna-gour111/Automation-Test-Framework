package com.servicenow.testscripts;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.servicenow.pageobjects.HomePage;
import com.servicenow.utils.Constants;
import com.servicenow.utils.ExcelReader;
import com.servicenow.utils.PropertiesLoader;
import com.servicenow.utils.ToolUtils;

/**
 * This class contains methods to perform test actions
 * 
 * @author Sapna Gour
 *
 */
public class CreateIncidentTest extends BaseTest {

	HomePage homepg;
	ExcelReader readData;
	public static String incidentNumberText;
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
	}

	/**
	 * This test is to create incident
	 * 
	 * @param requestFor
	 * @param company
	 * @param category
	 * @param businessService
	 * @param shortDescription
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "Create New Incident", priority = 1)
	public void createNewIncident(String requestFor, String company, String category, String businessService,
			String shortDescription) throws InterruptedException {
		logger.info("*********************************");
		logger.info("CreateIncidentTest - createNewIncident");
		logger.info("*********************************");

		homepg.clickOncreateNewIncidentFullButton();
		incidentNumberText = homepg.createIncidentFrame.getIncidentNumberText();
		homepg.createIncidentFrame.setRequestFor(prop.getProperty("requestFor"));
		Select categorySelect = new Select(homepg.createIncidentFrame.category);
		categorySelect.selectByVisibleText(category);
		homepg.createIncidentFrame.setShortDescription(prop.getProperty("shortDescription"));
		homepg.createIncidentFrame.selectBusinessService();
		homepg.createIncidentFrame.clickOnSubmitBtn();
		homepg.clickOnOpenIncident_Button();
		homepg.gethelponincdntfrm.searchIncidentNumber(incidentNumberText,
				homepg.gethelponincdntfrm.incidentNumberSearchBox);
		homepg.gethelponincdntfrm.pressEnterUsingKeyboardKey();

		// Final Verification
		Assert.assertEquals(incidentNumberText, homepg.createIncidentFrame.getIncidentNumber(),
				"Not able to create Incident");
		test.log(LogStatus.PASS, incidentNumberText, "Test for create new incident is successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	@DataProvider(name = "Create New Incident")
	public Object[][] ServiceOutageValidations() throws Exception {
		readData = new ExcelReader();
		Object[][] retObjArr = readData.excelRead("ServiceNow_TestData.xlsx", "CreateNewIncident");
		return retObjArr;
	}

}
