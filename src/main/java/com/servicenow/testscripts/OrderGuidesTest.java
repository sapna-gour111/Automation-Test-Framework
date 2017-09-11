package com.servicenow.testscripts;

import java.io.UnsupportedEncodingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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
 * This class contains test cases for Order Guides Application
 */
public class OrderGuidesTest extends BaseTest {
	static PropertiesLoader prop = new PropertiesLoader(Constants.PROPERTY_FILE_PATH);
	String incidentNo = null;
	HomePage homepg;
	ExcelReader readData;
	public static Logger logger = LogManager.getLogger();

	/**
	 * Setup method to create base for all subsequent test methods
	 * 
	 * @param browser-
	 *            Browser Name
	 */
	@BeforeClass
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) throws Exception {
		super.setUp(browser, this.getClass().getSimpleName());
		homepg = new HomePage(driver);
	}

	/**
	 * Order Guides: Test Case No-1. Selection of order items.
	 * 
	 * @throws UnsupportedEncodingException
	 * 
	 */
	@Test(priority = 1)
	@Parameters({ "Language" })
	public void verifyOrderItemSelection(String language) throws InterruptedException, UnsupportedEncodingException {
		logger.info("*********************************");
		logger.info("OrderGuidesTest - verifyOrderItemSelection");
		logger.info("*********************************");

		homepg.orderGuides.selectLanguage(language);
		if (language.equalsIgnoreCase("English")) {
			homepg.orderGuides.clickOnCloseButton();
			Thread.sleep(2000);
		}
		homepg.orderGuides.searchOrderGuides(language);
		homepg.orderGuides.clickOnSerCatalogLink();
		Thread.sleep(2000);
		homepg.orderGuides.clickOnPersonalCompuAssetLink();
		Thread.sleep(3000);
		homepg.orderGuides.clickOnComputerChkBox();
		Assert.assertEquals(homepg.orderGuides.isComputerChecked(), "true");
		Assert.assertEquals(homepg.orderGuides.isSoftwareChecked(), "true");
		Assert.assertEquals(homepg.orderGuides.isAccessoriesChecked(), "true");
		Assert.assertEquals(homepg.orderGuides.isMobileChecked(), "false");
		homepg.orderGuides.clickOnComputerChkBox();
		homepg.orderGuides.clickOnSoftwareChkBox();
		Assert.assertEquals(homepg.orderGuides.isComputerChecked(), "false");
		Assert.assertEquals(homepg.orderGuides.isSoftwareChecked(), "true");
		Assert.assertEquals(homepg.orderGuides.isAccessoriesChecked(), "false");
		Assert.assertEquals(homepg.orderGuides.isMobileChecked(), "false");
		homepg.orderGuides.clickOnSoftwareChkBox();
		homepg.orderGuides.clickOnAccessoriesChkBox();
		Assert.assertEquals(homepg.orderGuides.isComputerChecked(), "false");
		Assert.assertEquals(homepg.orderGuides.isSoftwareChecked(), "false");
		Assert.assertEquals(homepg.orderGuides.isAccessoriesChecked(), "true");
		Assert.assertEquals(homepg.orderGuides.isMobileChecked(), "false");
		homepg.orderGuides.clickOnAccessoriesChkBox();
		homepg.orderGuides.clickOnMobileChkBox();
		Assert.assertEquals(homepg.orderGuides.isComputerChecked(), "false");
		Assert.assertEquals(homepg.orderGuides.isSoftwareChecked(), "false");
		Assert.assertEquals(homepg.orderGuides.isAccessoriesChecked(), "false");
		Assert.assertEquals(homepg.orderGuides.isMobileChecked(), "true");
		// Final Verification
		test.log(LogStatus.PASS, "Validation for Order Item Selection is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Order Guides: Test Case No-2. Retention of laptop model for "New"
	 * equipment type.Error message verification for accessories.
	 * 
	 */
	@Test(priority = 2)
	public void verifyLaptopModelRetentionForNew() throws InterruptedException {
		logger.info("*********************************");
		logger.info("OrderGuidesTest - verifyLaptopModelRetentionForNew");
		logger.info("*********************************");

		homepg.orderGuides.clickOnComputerChkBox();
		homepg.orderGuides.clickOnChooseOptionButton();
		homepg.orderGuides.selectNewEquipmentType();
		homepg.orderGuides.selectLaptopModel();
		homepg.orderGuides.chooseNextTabButton();
		homepg.orderGuides.clickOnDoYouWantToOrderSoft();
		Assert.assertEquals(homepg.orderGuides.getModelTextForSoftReq(), prop.getProperty("laptopModel"));
		homepg.orderGuides.chooseNextTabButton();
		Assert.assertEquals(homepg.orderGuides.getErrMessage(), prop.getProperty("softwareErrMsg"));
		homepg.orderGuides.clickOnDoYouWantToOrderSoft();

		homepg.orderGuides.chooseNextTabButton();
		homepg.orderGuides.clickOnDoYouWantToOrderAccess();
		Assert.assertEquals(homepg.orderGuides.getModelTextForAccessReq(), prop.getProperty("laptopModel"));
		homepg.orderGuides.chooseNextTabButton();
		Assert.assertEquals(homepg.orderGuides.getErrMessage(), prop.getProperty("accessErrMsg"));
		homepg.orderGuides.clickOnDoYouWantToOrderAccess();

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Laptop Model Retention For New Equipment Type is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Order Guides: Test Case No-3. Retention of laptop model for "Upgrade"
	 * equipment type and field validations.
	 * 
	 */
	@Test(priority = 3)
	public void verifyLaptopModelRetentionForUpgrade() throws InterruptedException {
		logger.info("*********************************");
		logger.info("OrderGuidesTest - verifyLaptopModelRetentionForUpgrade");
		logger.info("*********************************");

		homepg.orderGuides.clickOnOrderCompTab();
		homepg.orderGuides.selectUpgradeEquipmentType();
		homepg.orderGuides.selectUpgradeType();

		homepg.orderGuides.chooseNextTabButton();
		homepg.orderGuides.clickOnDoYouWantToOrderSoft();
		Assert.assertEquals(homepg.orderGuides.getModelTextForSoftReq(), prop.getProperty("laptopModel"));
		homepg.orderGuides.chooseNextTabButton();
		Assert.assertEquals(homepg.orderGuides.getErrMessage(), prop.getProperty("softwareErrMsg"));
		homepg.orderGuides.clickOnDoYouWantToOrderSoft();
		homepg.orderGuides.chooseNextTabButton();
		homepg.orderGuides.clickOnDoYouWantToOrderAccess();
		Assert.assertEquals(homepg.orderGuides.getModelTextForAccessReq(), prop.getProperty("laptopModel"));
		homepg.orderGuides.chooseNextTabButton();
		Assert.assertEquals(homepg.orderGuides.getErrMessage(), prop.getProperty("accessErrMsg"));
		homepg.orderGuides.clickOnDoYouWantToOrderAccess();

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Laptop Model Retention For Upgrade Equipment Type is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Order Guides: Test Case No-4. Retention of laptop model for "Transfer"
	 * equipment type and field validation
	 * 
	 */
	@Test(priority = 4)
	public void verifyLaptopModelRetentionForTransfer() throws InterruptedException {
		logger.info("*********************************");
		logger.info("OrderGuidesTest - verifyLaptopModelRetentionForTransfer");
		logger.info("*********************************");

		homepg.orderGuides.clickOnOrderCompTab();
		homepg.orderGuides.selectTransferEquipmentType();
		homepg.orderGuides.enterAssetTagForTransfer();
		Assert.assertTrue(homepg.orderGuides.assignedTo_lbl.isDisplayed());
		Assert.assertTrue(homepg.orderGuides.modelName_lbl.isDisplayed());
		Assert.assertTrue(homepg.orderGuides.modelSerialNum_lbl.isDisplayed());
		Assert.assertTrue(homepg.orderGuides.transferTo_lbl.isDisplayed());

		homepg.orderGuides.chooseNextTabButton();
		homepg.orderGuides.clickOnDoYouWantToOrderSoft();
		Assert.assertEquals(homepg.orderGuides.getModelTextForSoftReq(), prop.getProperty("modelName"));
		homepg.orderGuides.chooseNextTabButton();
		Assert.assertEquals(homepg.orderGuides.getErrMessage(), prop.getProperty("softwareErrMsg"));
		homepg.orderGuides.clickOnDoYouWantToOrderSoft();
		homepg.orderGuides.chooseNextTabButton();
		homepg.orderGuides.clickOnDoYouWantToOrderAccess();
		Assert.assertEquals(homepg.orderGuides.getModelTextForAccessReq(), prop.getProperty("modelName"));
		homepg.orderGuides.chooseNextTabButton();
		Assert.assertEquals(homepg.orderGuides.getErrMessage(), prop.getProperty("accessErrMsg"));
		homepg.orderGuides.clickOnDoYouWantToOrderAccess();

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Laptop Model Retention For Transfer Equipment Type is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Order Guides: Test Case No-5,9. Verify software order and accessories
	 * order checkbox.
	 * 
	 */
	@Test(priority = 5)
	public void verifySoftAccessOrderCheckbox() throws InterruptedException {
		logger.info("*********************************");
		logger.info("OrderGuidesTest - verifySoftAccessOrderCheckbox");
		logger.info("*********************************");

		Thread.sleep(2000);
		homepg.orderGuides.clickOnSoftReqTab();
		Thread.sleep(2000);
		// homepg.orderGuides.clickOnDoYouWantToOrderSoft();
		Assert.assertFalse(homepg.orderGuides.laptopModel2_SearchBox.isDisplayed());
		homepg.orderGuides.clickOnDoYouWantToOrderSoft();
		Assert.assertTrue(homepg.orderGuides.laptopModel2_SearchBox.isDisplayed());
		Assert.assertTrue(homepg.orderGuides.recPersonsEquiDetails_Lbl.isDisplayed());
		Assert.assertTrue(homepg.orderGuides.softOption_Lbl.isDisplayed());
		homepg.orderGuides.clickOnDoYouWantToOrderSoft();
		homepg.orderGuides.clickOnAccessReqTab();
		Assert.assertFalse(homepg.orderGuides.laptopModel3_SearchBox.isDisplayed());
		homepg.orderGuides.clickOnDoYouWantToOrderAccess();
		Assert.assertTrue(homepg.orderGuides.laptopModel3_SearchBox.isDisplayed());
		Assert.assertTrue(homepg.orderGuides.recPersonsEquiDetails_Lbl.isDisplayed());
		Assert.assertTrue(homepg.orderGuides.accessOption_Lbl.isDisplayed());
		Assert.assertTrue(homepg.orderGuides.addPeripheral_Lbl.isDisplayed());
		homepg.orderGuides.clickOnDoYouWantToOrderAccess();
		// Final Verification
		test.log(LogStatus.PASS, "Validation for software and accessories order checkbox is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Order Guides: Test Case No-6. Verify Add New software for New equipment
	 * type.
	 * 
	 */
	@Test(priority = 6)
	public void verifyAddNewSoftwareForNewEquipType() throws InterruptedException {
		logger.info("*********************************");
		logger.info("OrderGuidesTest - verifyAddSoftwareForNewType");
		logger.info("*********************************");

		homepg.orderGuides.clickOnOrderCompTab();
		homepg.orderGuides.selectNewEquipmentType();
		homepg.orderGuides.selectLaptopModel();
		homepg.orderGuides.chooseNextTabButton();
		Thread.sleep(3000);
		homepg.orderGuides.clickOnDoYouWantToOrderSoft();
		Thread.sleep(2000);
		homepg.orderGuides.clickOnAddButton();
		homepg.orderGuides.clickOnAddRecordButton();
		Assert.assertTrue(homepg.orderGuides.isAlertPresent());
		homepg.orderGuides.closeAlert();
		homepg.orderGuides.selectSoftOptionForNew(prop.getProperty("softOptionForNew"));
		homepg.orderGuides.selectQuantityForNew(prop.getProperty("softQuantity"));
		homepg.orderGuides.clickOnAddRecordButton();
		Thread.sleep(3000);
		Assert.assertTrue(homepg.orderGuides.addedSoftRec_Txt.isDisplayed());
		try {
			if (homepg.orderGuides.unitPrice_Txt.getText().equals(prop.getProperty("unitPrice"))
					&& homepg.orderGuides.softQuantity_Txt.getText().equals(prop.getProperty("softQuantity"))) {
				float unitPriceAndQuantity = Float.parseFloat(prop.getProperty("unitPrice").substring(1, 7))
						* Integer.parseInt(prop.getProperty("softQuantity"));
				Assert.assertEquals(unitPriceAndQuantity,
						Float.parseFloat(homepg.orderGuides.softTotalPrice_Txt.getText().substring(1, 7)));
			}
		} catch (Exception e) {
			logger.info(e);
		}
		homepg.orderGuides.clickOnAddButton();
		Assert.assertTrue(homepg.orderGuides.softQuantity_dropDown.isDisplayed());
		homepg.orderGuides.clickOnCancelRecordButton();
		Assert.assertFalse(homepg.orderGuides.softQuantity_dropDown.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Add New Software for New equipment type is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Order Guides: Test Case No-7. Verify Update Record for Software Request.
	 * 
	 */
	@Test(priority = 7)
	public void verifyUpdateRecordForSoftRequest() throws InterruptedException {
		logger.info("*********************************");
		logger.info("OrderGuidesTest - verifyUpdateRecordForSoftRequest");
		logger.info("*********************************");

		Thread.sleep(2000);
		homepg.orderGuides.clickOnUpdateRecordForSoftRequest();
		Thread.sleep(2000);
		homepg.orderGuides.selectSoftOptionForNew(prop.getProperty("softUpdatedOption"));
		Thread.sleep(2000);
		homepg.orderGuides.selectQuantityForNew(prop.getProperty("softUpdatedQuantity"));
		Thread.sleep(2000);
		homepg.orderGuides.clickOnConfirmUpdate();
		Thread.sleep(3000);
		Assert.assertEquals(homepg.orderGuides.softSelected_Txt.getText(), prop.getProperty("softUpdatedOption"));
		Assert.assertEquals(homepg.orderGuides.softQuantity_Txt.getText(), prop.getProperty("softUpdatedQuantity"));

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Update record for software request is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Order Guides: Test Case No-8. Verify Delete Record for Software Request.
	 * /
	 */
	@Test(priority = 8)
	public void verifyDeleteRecordForSoftRequest() throws InterruptedException {
		logger.info("*********************************");
		logger.info("OrderGuidesTest - verifyDeleteRecordForSoftRequest");
		logger.info("*********************************");

		Thread.sleep(2000);
		homepg.orderGuides.clickOnDeleteRecordForSoftRequest();
		Thread.sleep(2000);
		Assert.assertEquals(homepg.orderGuides.softSelected_Txt.getText(), prop.getProperty("softDeletedRec"));

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Delete record for software request is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Order Guides: Test Case No-10. Verify Add New Record for Accessories.
	 */
	@Test(priority = 9)
	public void verifyAddNewRecordForAccessories() throws InterruptedException {
		logger.info("*********************************");
		logger.info("OrderGuidesTest - verifyAddNewRecordForAccessories");
		logger.info("*********************************");

		homepg.orderGuides.clickOnDoYouWantToOrderSoft();
		homepg.orderGuides.clickOnAccessReqTab();
		homepg.orderGuides.clickOnDoYouWantToOrderAccess();
		Thread.sleep(2000);
		homepg.orderGuides.clickOnAddButton();
		homepg.orderGuides.clickOnAddRecordButton();
		Assert.assertTrue(homepg.orderGuides.isAlertPresent());
		homepg.orderGuides.closeAlert();
		homepg.orderGuides.selectModelTypeForNew(prop.getProperty("accessModelType"));
		homepg.orderGuides.selectAccessAvailableForNew("Lenovo ThinkPad Pro Dock - 90 W");
		homepg.orderGuides.selectQuantityForNewAccess(prop.getProperty("accessQuantity"));
		homepg.orderGuides.clickOnAddRecordButton();
		Thread.sleep(3000);
		Assert.assertTrue(homepg.orderGuides.addedSoftRec_Txt.isDisplayed());
		homepg.orderGuides.enterAdditionalAccessories();
		try {
			if (homepg.orderGuides.unitPrice_Txt.getText().equals(prop.getProperty("unitPriceForAccess"))
					&& homepg.orderGuides.softQuantity_Txt.getText().equals(prop.getProperty("softQuantity"))) {
				float unitPriceAndQuantity = Float.parseFloat(prop.getProperty("unitPrice").substring(1, 4))
						* Integer.parseInt(prop.getProperty("softQuantity"));
				Assert.assertEquals(unitPriceAndQuantity,
						Float.parseFloat(homepg.orderGuides.softTotalPrice_Txt.getText().substring(1, 4)));
			}
		} catch (Exception e) {
			logger.info(e);
		}

		homepg.orderGuides.clickOnAddButton();
		Assert.assertTrue(homepg.orderGuides.quantity_DropDown.isDisplayed());
		homepg.orderGuides.clickOnCancelRecordButton();
		Assert.assertFalse(homepg.orderGuides.quantity_DropDown.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Add New record for Accessories is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Order Guides: Test Case No-11. Verify Update Record for Accessories
	 * Request.
	 * 
	 */
	@Test(priority = 10)
	public void verifyUpdateRecordForAccessRequest() throws InterruptedException {
		logger.info("*********************************");
		logger.info("OrderGuidesTest - verifyUpdateRecordForAccessRequest");
		logger.info("*********************************");

		Thread.sleep(2000);
		homepg.orderGuides.clickOnUpdateRecordForSoftRequest();
		Thread.sleep(2000);
		homepg.orderGuides.selectModelTypeForNew(prop.getProperty("accessUpdatedOption"));
		Thread.sleep(3000);
		homepg.orderGuides.selectOptionByIndex(homepg.orderGuides.availAccess_dropDown, 1);
		Thread.sleep(2000);
		homepg.orderGuides.selectQuantityForNewAccess(prop.getProperty("softUpdatedQuantity"));
		Thread.sleep(2000);
		homepg.orderGuides.clickOnConfirmUpdate();
		Thread.sleep(3000);
		Assert.assertEquals(homepg.orderGuides.softSelected_Txt.getText(), "Lenovo ThinkPad Battery 76+ (6 cell)");
		Assert.assertEquals(homepg.orderGuides.softQuantity_Txt.getText(), prop.getProperty("softUpdatedQuantity"));

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Update record for Accessories request is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Order Guides: Test Case No-12. Verify Delete Record for Accessories
	 * Request.
	 */
	@Test(priority = 11)
	public void verifyDeleteRecordForAccessReq() throws InterruptedException {
		logger.info("*********************************");
		logger.info("OrderGuidesTest - verifyDeleteRecordForAccessReq");
		logger.info("*********************************");

		Thread.sleep(2000);
		homepg.orderGuides.clickOnDeleteRecordForSoftRequest();
		Thread.sleep(2000);
		Assert.assertEquals(homepg.orderGuides.softSelected_Txt.getText(), prop.getProperty("softDeletedRec"));

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Delete record for accessories request is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Order Guides: Test Case No-13,14,15,16. Verify Mobile request for
	 * Equipment type Smart phone, Tablet, Wireless device and Other.
	 */
	@Test(priority = 12)
	public void verifyWirelessDeviceMobileReq() throws InterruptedException {
		logger.info("*********************************");
		logger.info("OrderGuidesTest - verifyWirelessDeviceMobileReq");
		logger.info("*********************************");

		homepg.orderGuides.clickOnDoYouWantToOrderAccess();
		homepg.orderGuides.refreshPage();
		Thread.sleep(5000);
		homepg.orderGuides.switchToDefaultiFrame();
		homepg.orderGuides.clickOnMobileReqTab();
		homepg.orderGuides.selectSmartphoneRadioButton();
		Thread.sleep(1000);
		homepg.orderGuides.selectEquipmentTypeByIndex(homepg.orderGuides.smartphone_DropDown, 4,
				homepg.orderGuides.smartphoneCarrier_DropDown, 1);
		homepg.orderGuides.selectOptionByIndex(homepg.orderGuides.smartphoneContract_DropDown, 1);
		homepg.orderGuides.deviceOptionRadioButton();
		homepg.orderGuides.enterMobileNo();
		Assert.assertTrue(homepg.orderGuides.smartphone_DropDown.isDisplayed());
		homepg.orderGuides.selectSmartphoneRadioButton();
		homepg.orderGuides.selectTabletRadioButton();
		homepg.orderGuides.selectEquipmentType(homepg.orderGuides.tablet_DropDown, prop.getProperty("tabletDevice"),
				homepg.orderGuides.tabletCarrier_DropDown, prop.getProperty("tabletCarrier"));
		homepg.orderGuides.selectOptionByIndex(homepg.orderGuides.tabletContract_DropDown, 1);
		Assert.assertTrue(homepg.orderGuides.tablet_DropDown.isDisplayed());
		homepg.orderGuides.selectTabletRadioButton();
		homepg.orderGuides.selectWirelessDeviceRadioButton();
		homepg.orderGuides.selectEquipmentType(homepg.orderGuides.wirelessDevice_DropDown,
				prop.getProperty("wirelessDevice"), homepg.orderGuides.wirelessDeviceCarrier_DropDown,
				prop.getProperty("wirelessCarrier"));
		homepg.orderGuides.selectOptionByIndex(homepg.orderGuides.wirelessDeviceContract_DropDown, 1);
		Assert.assertTrue(homepg.orderGuides.wirelessDevice_DropDown.isDisplayed());
		homepg.orderGuides.selectWirelessDeviceRadioButton();
		homepg.orderGuides.selectOtherEquipmentType();
		homepg.orderGuides.enterMobileDescription();

		// Final Verification
		test.log(LogStatus.PASS, "Validation for Delete record for accessories request is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Order Guides: Test Case No-17. End to End scenario for New Equipment type
	 * 
	 * @throws UnsupportedEncodingException
	 */
	@Test(priority = 13)
	@Parameters({ "Language" })
	public void verifyEndToEndScenarioForNewEquipType(String language)
			throws InterruptedException, UnsupportedEncodingException {
		logger.info("*********************************");
		logger.info("OrderGuidesTest - verifyEndToEndScenarioForNewEquip");
		logger.info("*********************************");

		homepg.orderGuides.switchToDefaultContent();
		homepg.orderGuides.searchOrderGuides(language);
		homepg.orderGuides.clickOnSerCatalogLink();
		homepg.orderGuides.clickOnPersonalCompuAssetLink();
		Thread.sleep(2000);
		homepg.orderGuides.clickOnComputerChkBox();
		homepg.orderGuides.clickOnMobileChkBox();
		homepg.orderGuides.clickOnChooseOptionButton();
		homepg.orderGuides.selectNewEquipmentType();
		homepg.orderGuides.selectLaptopModel();
		homepg.orderGuides.chooseNextTabButton();
		homepg.orderGuides.clickOnDoYouWantToOrderSoft();
		Thread.sleep(3000);
		homepg.orderGuides.clickOnAddButton();
		homepg.orderGuides.selectSoftOptionForNew(prop.getProperty("softOptionForNew"));
		homepg.orderGuides.selectQuantityForNew(prop.getProperty("softQuantity"));
		homepg.orderGuides.clickOnAddRecordButton();
		Thread.sleep(3000);
		homepg.orderGuides.chooseNextTabButton();
		homepg.orderGuides.clickOnDoYouWantToOrderAccess();
		Thread.sleep(3000);
		homepg.orderGuides.clickOnAddButton();
		homepg.orderGuides.selectModelTypeForNew(prop.getProperty("accessModelType"));
		homepg.orderGuides.selectOptionByIndex(homepg.orderGuides.availAccess_dropDown, 1);
		homepg.orderGuides.selectQuantityForNewAccess(prop.getProperty("accessQuantity"));
		homepg.orderGuides.clickOnAddRecordButton();
		Thread.sleep(3000);
		homepg.orderGuides.chooseNextTabButton();
		homepg.orderGuides.selectWirelessDeviceRadioButton();
		homepg.orderGuides.selectEquipmentType(homepg.orderGuides.wirelessDevice_DropDown,
				prop.getProperty("wirelessDevice"), homepg.orderGuides.wirelessDeviceCarrier_DropDown,
				prop.getProperty("wirelessCarrier"));
		homepg.orderGuides.selectOptionByIndex(homepg.orderGuides.wirelessDeviceContract_DropDown, 1);
		homepg.orderGuides.clickOnCheckoutButton();
		Thread.sleep(3000);
		homepg.orderGuides.clickOnSubmitOrderButton();
		Thread.sleep(3000);
		Assert.assertTrue(homepg.orderGuides.reqNumber.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for End To End scenario for New Equipment Type is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Order Guides: Test Case No-18. End to End scenario for Upgrade Equipment
	 * type
	 * 
	 * @throws UnsupportedEncodingException
	 */
	@Test(priority = 14)
	@Parameters({ "Language" })
	public void verifyEndToEndScenarioForUpgradeEquipType(String language)
			throws InterruptedException, UnsupportedEncodingException {
		logger.info("*********************************");
		logger.info("OrderGuidesTest - verifyEndToEndScenarioForUpgradeEquipType");
		logger.info("*********************************");

		homepg.orderGuides.switchToDefaultContent();
		homepg.orderGuides.searchOrderGuides(language);
		homepg.orderGuides.clickOnSerCatalogLink();
		homepg.orderGuides.clickOnPersonalCompuAssetLink();
		Thread.sleep(2000);
		homepg.orderGuides.clickOnComputerChkBox();
		homepg.orderGuides.clickOnMobileChkBox();
		homepg.orderGuides.clickOnChooseOptionButton();
		homepg.orderGuides.selectUpgradeEquipmentType();
		homepg.orderGuides.selectUpgradeType();

		// homepg.orderGuides.enterAssetTag();
		Thread.sleep(3000);
		homepg.orderGuides.chooseNextTabButton();
		homepg.orderGuides.clickOnDoYouWantToOrderSoft();
		Thread.sleep(3000);
		homepg.orderGuides.clickOnAddButton();
		homepg.orderGuides.selectSoftOptionForNew(prop.getProperty("softOptionForNew"));
		homepg.orderGuides.selectQuantityForNew(prop.getProperty("softQuantity"));
		homepg.orderGuides.clickOnAddRecordButton();
		Thread.sleep(3000);
		homepg.orderGuides.chooseNextTabButton();
		homepg.orderGuides.clickOnDoYouWantToOrderAccess();
		Thread.sleep(3000);
		homepg.orderGuides.clickOnAddButton();
		homepg.orderGuides.selectModelTypeForNew(prop.getProperty("accessModelType"));
		homepg.orderGuides.selectOptionByIndex(homepg.orderGuides.availAccess_dropDown, 1);
		homepg.orderGuides.selectQuantityForNewAccess(prop.getProperty("accessQuantity"));
		homepg.orderGuides.clickOnAddRecordButton();
		Thread.sleep(3000);
		homepg.orderGuides.chooseNextTabButton();
		homepg.orderGuides.selectWirelessDeviceRadioButton();
		homepg.orderGuides.selectEquipmentType(homepg.orderGuides.wirelessDevice_DropDown,
				prop.getProperty("wirelessDevice"), homepg.orderGuides.wirelessDeviceCarrier_DropDown,
				prop.getProperty("wirelessCarrier"));
		homepg.orderGuides.selectOptionByIndex(homepg.orderGuides.wirelessDeviceContract_DropDown, 1);
		homepg.orderGuides.clickOnCheckoutButton();
		Thread.sleep(3000);
		homepg.orderGuides.clickOnSubmitOrderButton();
		Thread.sleep(3000);
		Assert.assertTrue(homepg.orderGuides.reqNumber.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for End To End scenario for Upgrade Equipment Type is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

	/**
	 * Order Guides: Test Case No-19. End to End scenario for Upgrade Equipment
	 * type
	 * 
	 * @throws UnsupportedEncodingException
	 */
	@Test(priority = 15)
	@Parameters({ "Language" })
	public void verifyEndToEndScenarioForTransferEquipType(String language)
			throws InterruptedException, UnsupportedEncodingException {
		logger.info("*********************************");
		logger.info("OrderGuidesTest - verifyEndToEndScenarioForTransferEquipType");
		logger.info("*********************************");

		homepg.orderGuides.switchToDefaultContent();
		homepg.orderGuides.searchOrderGuides(language);
		homepg.orderGuides.clickOnSerCatalogLink();
		homepg.orderGuides.clickOnPersonalCompuAssetLink();
		Thread.sleep(2000);
		homepg.orderGuides.clickOnComputerChkBox();
		homepg.orderGuides.clickOnMobileChkBox();
		homepg.orderGuides.clickOnChooseOptionButton();
		homepg.orderGuides.selectTransferEquipmentType();
		Thread.sleep(1000);
		homepg.orderGuides.enterAssetTagForTransfer();
		Thread.sleep(1000);
		homepg.orderGuides.chooseNextTabButton();
		homepg.orderGuides.clickOnDoYouWantToOrderSoft();
		Thread.sleep(3000);
		homepg.orderGuides.clickOnAddButton();
		homepg.orderGuides.selectSoftOptionForNew(prop.getProperty("softOptionForNew"));
		homepg.orderGuides.selectQuantityForNew(prop.getProperty("softQuantity"));
		homepg.orderGuides.clickOnAddRecordButton();
		Thread.sleep(3000);
		homepg.orderGuides.chooseNextTabButton();
		homepg.orderGuides.clickOnDoYouWantToOrderAccess();
		Thread.sleep(3000);
		homepg.orderGuides.clickOnAddButton();
		homepg.orderGuides.selectModelTypeForNew(prop.getProperty("accessModelType"));
		homepg.orderGuides.selectOptionByIndex(homepg.orderGuides.availAccess_dropDown, 1);
		homepg.orderGuides.selectQuantityForNewAccess(prop.getProperty("accessQuantity"));
		homepg.orderGuides.clickOnAddRecordButton();
		Thread.sleep(3000);
		homepg.orderGuides.chooseNextTabButton();
		homepg.orderGuides.selectWirelessDeviceRadioButton();
		homepg.orderGuides.selectEquipmentType(homepg.orderGuides.wirelessDevice_DropDown,
				prop.getProperty("wirelessDevice"), homepg.orderGuides.wirelessDeviceCarrier_DropDown,
				prop.getProperty("wirelessCarrier"));
		homepg.orderGuides.selectOptionByIndex(homepg.orderGuides.wirelessDeviceContract_DropDown, 1);
		homepg.orderGuides.clickOnCheckoutButton();
		Thread.sleep(3000);
		homepg.orderGuides.clickOnSubmitOrderButton();
		Thread.sleep(3000);
		Assert.assertTrue(homepg.orderGuides.reqNumber.isDisplayed());

		// Final Verification
		test.log(LogStatus.PASS, "Validation for End To End scenario for Transfer Equipment Type is Successful.");
		ToolUtils.captureScreenshot(driver, test);
		logger.info("Test case end----------------------------------------------------------------------------");
	}

}