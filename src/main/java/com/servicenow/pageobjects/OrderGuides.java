package com.servicenow.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.servicenow.utils.Constants;
import com.servicenow.utils.PropertiesLoader;

/**
 * This class contains page objects & methods to perform action on Order Guides
 * 
 */

public class OrderGuides extends IFrameBase {
	static PropertiesLoader prop = new PropertiesLoader(Constants.PROPERTY_FILE_PATH);

	public OrderGuides(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// Order Guides->Search Service Catalog
	@FindBy(id = "filter")
	public WebElement searchOrderGuides_TxtBox;

	// Order Guides->Click On Service Catalog link
	@FindBy(css = "li.module-node>a")
	public WebElement serviceCatalog_Link;

	// Order Guides->Click On Personal Computing Assets
	@FindBy(xpath = "//a[contains(text(),'HAL IT Personal Computing Assets')]")
	public WebElement personalComputingasset_Link;

	// Order Guides->Click On Computer Check box
	@FindBy(xpath = "//label[contains(text(),'Computer')]")
	public WebElement computer_Checkbox;

	// Order Guides->Computer check box
	@FindBy(xpath = "//div[@class='io_table col-xs-6 form-field input_controls']/div[1]/input[1]")
	public WebElement comp_Checkbox;

	// Order Guides->Software check box
	@FindBy(xpath = "//div[@class='io_table col-xs-6 form-field input_controls']/div[2]/input[1]")
	public WebElement software_Checkbox;

	// Order Guides->Accessories check box
	@FindBy(xpath = "//div[@class='io_table col-xs-6 form-field input_controls']/div[3]/input[1]")
	public WebElement accessories_Checkbox;

	// Order Guides->Mobile check box
	@FindBy(xpath = "//div[@class='io_table col-xs-6 form-field input_controls']/div[4]/input[1]")
	public WebElement mobile_Checkbox;

	// Order Guides->Click on Software check box
	@FindBy(xpath = "//label[contains(text(),'Software')]")
	public WebElement soft_Checkbox;

	// Order Guides->Click on Accessories check box
	@FindBy(xpath = "//label[contains(text(),'Accessories')]")
	public WebElement access_Checkbox;

	// Order Guides->Click on Mobile check box
	@FindBy(xpath = "//label[contains(text(),'Mobile')]")
	public WebElement mobi_Checkbox;

	// Order Guides->Click on Choose Option Button
	@FindBy(id = "next_page")
	public WebElement chooseOption_Button;

	// Order Guides->Click on Choose Next Tab Button
	@FindBy(id = "next_tab")
	public WebElement chooseNextTab_Button;

	// Order Guides->Click on Equipment Type Button
	// @FindBy(xpath = "//label[contains(text(),'New')]")
	@FindBy(xpath = "//div[@id='IO:e88e251b132c3240e34d51522244b0ec']/fieldset/div[2]/div/span[1]/label")
	public WebElement equipmentType_radioButton;

	// Order Guides->Click on Upgrade Equipment Type Button
	@FindBy(xpath = "//label[contains(text(),'Upgrade')]")
	public WebElement upgradeEquipmentType_radioButton;

	// Order Guides->Click on Transfer Equipment Type Button
	@FindBy(xpath = "//label[contains(text(),'Transfer')]")
	public WebElement transferEquipmentType_radioButton;

	// Order Guides->Click on Laptop Model search icon
	@FindBy(xpath = "//span[@class='input-group-btn']/a")
	public WebElement laptopModel_Search;

	// Order Guides->Type in Laptop Model search box
	@FindBy(xpath = "//select[@id='IO:c6ef615b132c3240e34d51522244b0e2']")
	public WebElement laptopModel_SearchBox;

	// Order Guides->Type in Laptop Model search box
	@FindBy(xpath = "//input[@id='sys_display.IO:e0e84a17136c3240e34d51522244b089']")
	public WebElement laptopModel2_SearchBox;

	// Order Guides->Type in Display Name search box
	@FindBy(xpath = "//table[@id='cmdb_model_table']/thead/tr[2]/td[3]/div/div/div/input")
	public WebElement displayName_SearchBox;

	// Order Guides->Click on Laptop Model link
	@FindBy(xpath = "//tbody/tr[1]/td[3]/a[@class='glide_ref_item_link']")
	public WebElement laptopModel_Link;

	// Order Guides->Click on Do you want to order any software check box
	@FindBy(xpath = "//label[contains(text(),'Do You Want to Order Any Additional Software?')]")
	public WebElement wantToOrderSoft_ChkBox;

	// Order Guides->Click on Do you want to order any accessories check box
	@FindBy(xpath = "//label[contains(text(),'Do You Want to Order Any Additional Accessories?')]")
	public WebElement wantToOrderAccess_ChkBox;

	// Order Guides->Get model text for Software request tab
	@FindBy(xpath = "//tbody/tr[2]/td/div/div/div[2]/input[3]")
	public WebElement softReqModelValue_txt;

	// Order Guides->Get model text for Accessories request tab
	@FindBy(xpath = "//tbody/tr[2]/td/div/div/div[2]/input[3]")
	public WebElement accessReqModelValue_txt;

	// Order Guides->Click on HAL IT Order Computer Tab
	@FindBy(xpath = "//span[contains(text(),'HAL IT Order Computer')]")
	public WebElement orderComputerTab_Tab;

	// Order Guides->Type into HAL IT Computer Asset Tag No
	@FindBy(xpath = "//div[@class='col-xs-6 form-field input_controls']/input[2]")
	public WebElement compAssetTagNo_Txt;

	// Order Guides->Type into Transfer HAL IT Computer Asset Tag No
	@FindBy(xpath = "//tbody/tr[6]/td/div/div/div[2]/input[2]")
	public WebElement transferCompAssetTagNo_Txt;

	// Order Guides->Assigned to label
	@FindBy(xpath = "//span[contains(text(),'Assigned to')]")
	public WebElement assignedTo_lbl;

	// Order Guides->Model Name label
	@FindBy(xpath = "//span[contains(text(),'Assigned to')]")
	public WebElement modelName_lbl;

	// Order Guides->Model Serial Number label
	@FindBy(xpath = "//span[contains(text(),'Model Serial Number')]")
	public WebElement modelSerialNum_lbl;

	// Order Guides->Transfer to label
	@FindBy(xpath = "//span[contains(text(),'Transfer to')]")
	public WebElement transferTo_lbl;

	// Order Guides->Assigned to text
	@FindBy(xpath = "//tbody/tr[1]/td/div[@class='row sc-row']/div/div[2]/input[2]")
	public WebElement getAssignTo_Text;

	// Order Guides->Model Name text
	@FindBy(xpath = "//tbody/tr[2]/td/div[@class='row sc-row']/div/div[2]/input[2]")
	public WebElement getModelName_Text;

	// Order Guides->Model Serial Number text
	@FindBy(xpath = "//tbody/tr[3]/td/div[@class='row sc-row']/div/div[2]/input[2]")
	public WebElement getModelSrNo_Text;

	// Order Guides->Click on Software Request Tab
	@FindBy(xpath = "//span[contains(text(),'HAL IT Software Request')]")
	public WebElement softReq_Tab;

	// Order Guides->Click on Accessories Request Tab
	@FindBy(xpath = "//span[contains(text(),'HAL IT Accessories Request')]")
	public WebElement accessReq_Tab;

	// Order Guides->Click on Mobile Request Tab
	@FindBy(xpath = "//span[@id='tab_ref_6e83d95f13e83240e34d51522244b01b']/span[2]")
	public WebElement mobileReq_Tab;

	// Order Guides->Receiving persons equipment details label
	@FindBy(xpath = "//div[@class='row sc-row']/div/div/label")
	public WebElement recPersonsEquiDetails_Lbl;

	// Order Guides->Software Option label
	@FindBy(xpath = "//span[contains(text(),'Software Options')]")
	public WebElement softOption_Lbl;

	// Order Guides->Accessories Option label
	@FindBy(xpath = "//span[contains(text(),'Accessories Options')]")
	public WebElement accessOption_Lbl;

	// Order Guides->Additional Peripherals Option label
	@FindBy(xpath = "//span[contains(text(),'Additional Accessories Option')]")
	public WebElement addPeripheral_Lbl;

	// Order Guides->Software Option drop down for New Equi Type
	@FindBy(xpath = "//div[@class='col-xs-12 form-field input_controls']/select")
	public WebElement softOption_DropDown;

	// Order Guides->Software Quantity drop down for New Equi Type
	@FindBy(xpath = "//select[@id='IO:96ceb3d213f4f200e34d51522244b099']")
	public WebElement softQuantity_dropDown;

	// Order Guides->Accessories Model drop down for New Equi Type
	@FindBy(xpath = "//select[@id='IO:75443bce13ddfa0048fb58222244b06b']")
	public WebElement softModel_DropDown;

	// Order Guides->Available Accessories drop down for New Equi Type
	@FindBy(xpath = "//select[@id='IO:75845d8413c17600e34d51522244b0c8']")
	public WebElement availAccess_dropDown;

	// Order Guides->Accessories Quantity drop down for New Equi Type
	@FindBy(xpath = "//select[@id='IO:c067114813c17600e34d51522244b043']")
	public WebElement quantity_DropDown;

	// Order Guides->Add record button for New equipment type to add new
	// software
	@FindBy(xpath = "//button[contains(text(),'Add Record')]")
	public WebElement addRecord_Btn;

	// Order Guides->Click on Add button
	@FindBy(xpath = "//a[@id='clickAdd']/button")
	public WebElement add_Btn;

	// Order Guides->Added software record
	@FindBy(xpath = "//table[@id='user_add_dt']/tbody/tr[1]/td[4]")
	public WebElement addedSoftRec_Txt;

	// Order Guides->Software record Unit price
	@FindBy(xpath = "//table[@id='user_add_dt']/tbody/tr[1]/td[9]")
	public WebElement unitPrice_Txt;

	// Order Guides->Software record Quantity
	@FindBy(xpath = "//table[@id='user_add_dt']/tbody/tr[1]/td[8]")
	public WebElement softQuantity_Txt;

	// Order Guides->Software Selected
	@FindBy(xpath = "//table[@id='user_add_dt']/tbody/tr[1]/td[4]")
	public WebElement softSelected_Txt;

	// Order Guides->Software Selected - Update
	@FindBy(xpath = "//td[contains(text(),'Microsoft Office Access')]")
	public WebElement updatedSoftSelected_Txt;

	// Order Guides->Software Total price
	@FindBy(xpath = "//table[@id='user_add_dt']/tbody/tr[1]/td[10]")
	public WebElement softTotalPrice_Txt;

	// Order Guides->Software Cancel Record button
	@FindBy(xpath = "//div[@id='cancel_button']/button")
	public WebElement cancelRec_Btn;

	// Order Guides->Update Record for Software request
	@FindBy(xpath = "//label[contains(text(),'Update')]")
	public WebElement updateRec_Link;

	// Order Guides->Delete record for Software Record
	@FindBy(xpath = "//label[contains(text(),'Delete')]")
	public WebElement deleteRec_Link;

	// Order Guides->Click on Confirm Update Button
	@FindBy(xpath = "// div[@id='push_update']/button")
	public WebElement confirmUpdate_Btn;

	// Order Guides->Additional Accessories
	@FindBy(xpath = "//textarea[@id='IO:2b7602eb13603200e34d51522244b0c9']")
	public WebElement additionalAccess_Txt_Box;

	// Order Guides->Mobile description text area
	@FindBy(xpath = "//textarea[@id='IO:fc63c293136c3240e34d51522244b0a6']")
	public WebElement mobileDesc_TxtBox;

	// Order Guides->Wireless Device radio button
	@FindBy(xpath = "//label[contains(text(),'Wireless Device')]")
	public WebElement wirelessDevice_RadioBtn;

	// Order Guides->Wireless Device radio button
	@FindBy(xpath = "//label[contains(text(),'Other')]")
	public WebElement otherDevice_RadioBtn;

	// Order Guides->Wireless Device Drop down
	@FindBy(xpath = "//select[@id='IO:82c45d771378360048fb58222244b048']")
	public WebElement wirelessDevice_DropDown;

	// Order Guides->Wireless Device Carrier drop down
	@FindBy(xpath = "//select[@id='IO:d3e2cd4713c53a00e34d51522244b067']")
	public WebElement wirelessDeviceCarrier_DropDown;

	// Order Guides->Wireless Device contract drop down
	@FindBy(xpath = "//select[@id='IO:38a3c94713c53a00e34d51522244b090']")
	public WebElement wirelessDeviceContract_DropDown;

	// Order Guides->Wireless Device option radio button
	@FindBy(xpath = "//label[contains(text(),'Domestic')]")
	public WebElement deviceOption_RadioBtn;

	// Order Guides->Smart phone Drop down
	@FindBy(xpath = "//select[@id='IO:f4d08653136c3240e34d51522244b0a8']")
	public WebElement smartphone_DropDown;

	// Order Guides->Smart phone Carrier drop down
	@FindBy(xpath = "//select[@id='IO:779eecf813c9760048fb58222244b0e0']")
	public WebElement smartphoneCarrier_DropDown;

	// Order Guides->Smart phone contract drop down
	@FindBy(xpath = "//select[@id='IO:f66fa0fc13c9760048fb58222244b094']")
	public WebElement smartphoneContract_DropDown;

	// Order Guides->Tablet Drop down
	@FindBy(xpath = "//select[@id='IO:03521d371378360048fb58222244b09d']")
	public WebElement tablet_DropDown;

	// Order Guides->Tablet Carrier drop down
	@FindBy(xpath = "//select[@id='IO:fccd7cc313c53a00e34d51522244b02e']")
	public WebElement tabletCarrier_DropDown;

	// Order Guides->Tablet contract drop down
	@FindBy(xpath = "//select[@id='IO:eb1fb80713c53a00e34d51522244b012']")
	public WebElement tabletContract_DropDown;

	// Order Guides->Click On checkout button
	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	public WebElement checkout_Btn;

	// Order Guides->Click On Submit Order button
	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	public WebElement submitOrder_Btn;

	// Order Guides->Get request Number
	@FindBy(xpath = "//a[@class='linked']")
	public WebElement reqNumber;

	// Order Guides->Smart phone radio button
	@FindBy(xpath = "//label[contains(text(),'Smartphone')]")
	public WebElement smartPhone_RadioBtn;

	// Order Guides->Tablet radio button
	@FindBy(xpath = "//label[contains(text(),'Tablet')]")
	public WebElement tablet_RadioBtn;

	// Order Guides->Mobile Number for Smart phone
	@FindBy(xpath = "//input[@id='IO:e6524e53136c3240e34d51522244b093']")
	public WebElement mobileNo_Txt_Box;

	// Order Guides->Ship to information checkbox
	@FindBy(id = "ni.IO:3055cd1b13e83240e34d51522244b011_label")
	public WebElement shipToInfo_ChkBox;

	// Order Guides->Close setting pop up
	@FindBy(xpath = "//button[@class='btn close icon-cross']")
	public WebElement langClose_Button;

	// Order Guides->Close setting frame
	@FindBy(xpath = "//div[@class='modal-dialog modal-lg']")
	public WebElement langClose_Frame;

	// Order Guides->Upgrade Equi Type
	@FindBy(id = "IO:6521bd5b132c3240e34d51522244b0cc")
	public WebElement upgradeEquiType_dropDown;

	// Order Guides->Type in Laptop Model search box
	@FindBy(xpath = "//input[@id='sys_display.IO:f93c0d2b13e0364048fb58222244b07e']")
	public WebElement laptopModel3_SearchBox;

	public void searchOrderGuides(String language) throws InterruptedException {
		logger.info("Searching for Service Catalog");
		switch (language) {
		case "English":
			typeText(searchOrderGuides_TxtBox, prop.getProperty("serviceCatalogForEn"));
			break;
		case "Japanese":
			typeText(searchOrderGuides_TxtBox, "サービスカタログ");
			break;

		default:
			typeText(searchOrderGuides_TxtBox, prop.getProperty("serviceCatalogForEn"));
			break;
		}
	}

	public void clickOnSerCatalogLink() throws InterruptedException {
		logger.info("Clicking on Service Catalog link");
		switchToDefaultContent();
		click(serviceCatalog_Link);
	}

	public void clickOnPersonalCompuAssetLink() throws InterruptedException {
		logger.info("Clicking on Personal Computing Asset link");
		switchToDefaultiFrame();
		click(personalComputingasset_Link);
	}

	public void clickOnComputerChkBox() throws InterruptedException {
		logger.info("Clicking on Computer checkbox");
		click(computer_Checkbox);
	}

	public void clickOnSoftwareChkBox() throws InterruptedException {
		logger.info("Clicking on Software checkbox");
		click(soft_Checkbox);
	}

	public void clickOnAccessoriesChkBox() throws InterruptedException {
		logger.info("Clicking on Accessories checkbox");
		click(access_Checkbox);
	}

	public void clickOnMobileChkBox() throws InterruptedException {
		logger.info("Clicking on Mobile checkbox");
		click(mobi_Checkbox);
	}

	public String isComputerChecked() throws InterruptedException {
		logger.info("Checking whether Computer checkbox is checked");
		return getAttribute(comp_Checkbox, "value");
	}

	public String isSoftwareChecked() throws InterruptedException {
		logger.info("Checking whether Software checkbox is checked");
		return getAttribute(software_Checkbox, "value");
	}

	public String isAccessoriesChecked() throws InterruptedException {
		logger.info("Checking whether Accessories checkbox is checked");
		return getAttribute(accessories_Checkbox, "value");
	}

	public String isMobileChecked() throws InterruptedException {
		logger.info("Checking whether Mobile checkbox is checked");
		return getAttribute(mobile_Checkbox, "value");
	}

	public void clickOnChooseOptionButton() {
		logger.info("Clicking on Choose Option Button");
		click(chooseOption_Button);
	}

	public void selectUpgradeType() throws InterruptedException {
		logger.info("Clicking on Equipment Type");
		selectOptionByIndex(upgradeEquiType_dropDown, 1);
	}

	public void chooseNextTabButton() {
		logger.info("Clicking on Choose Tab Button");
		click(chooseNextTab_Button);
	}

	public void clickOnCloseButton() {
		logger.info("Clicking on Close Button");
		// switchToDefaultiFrame();
		// switchToiFrame(langClose_Frame);
		click(langClose_Button);
	}

	public void selectNewEquipmentType() {
		logger.info("Clicking on Equipment Type");
		click(equipmentType_radioButton);
	}

	public void selectUpgradeEquipmentType() {
		logger.info("Clicking on Upgrade Equipment Type");
		click(upgradeEquipmentType_radioButton);
	}

	public void selectTransferEquipmentType() {
		logger.info("Clicking on Transfer Equipment Type");
		click(transferEquipmentType_radioButton);
	}

	public void selectLaptopModel() throws InterruptedException {
		logger.info("Selecting laptop model");
		selectOptionByIndex(laptopModel_SearchBox, 1);
		Thread.sleep(2000);
	}

	public void clickOnDoYouWantToOrderSoft() {
		logger.info("Clicking on Do you want to order any software");
		click(wantToOrderSoft_ChkBox);
	}

	public void clickOnDoYouWantToOrderAccess() {
		logger.info("Clicking on Do you want to order any accessories");
		click(wantToOrderAccess_ChkBox);
	}

	public String getModelTextForSoftReq() throws InterruptedException {
		logger.info("Get model text from Software request tab");
		return getAttribute(softReqModelValue_txt, "value");
	}

	public String getModelTextForAccessReq() throws InterruptedException {
		logger.info("Get model text from Accessories request tab");
		return getAttribute(accessReqModelValue_txt, "value");
	}

	public void clickOnOrderCompTab() {
		logger.info("Clicking on HAL IT Order Computer Tab");
		click(orderComputerTab_Tab);
	}

	public void enterAssetTag() throws InterruptedException {
		logger.info("Entering HAL IT asset tag");
		typeText(compAssetTagNo_Txt, prop.getProperty("assetTagNo"));
		pressEnterUsingKeyboardKey(compAssetTagNo_Txt);
		Thread.sleep(1000);
	}

	public void enterAssetTagForTransfer() throws InterruptedException {
		logger.info("Entering HAL IT asset tag for transfer");
		typeText(transferCompAssetTagNo_Txt, prop.getProperty("assetTagNo"));
		pressEnterUsingKeyboardKey(transferCompAssetTagNo_Txt);
		Thread.sleep(1000);
	}

	public void clickOnSoftReqTab() {
		logger.info("Clicking on HAL IT Software Request Tab");
		click(softReq_Tab);
	}

	public void clickOnAccessReqTab() {
		logger.info("Clicking on HAL IT Accessories Request Tab");
		click(accessReq_Tab);
	}

	public void clickOnMobileReqTab() {
		logger.info("Clicking on HAL IT Mobile Request Tab");
		click(mobileReq_Tab);
	}

	public void clickOnAddRecordButton() {
		logger.info("Clicking on Add Record button");
		click(addRecord_Btn);
	}

	public void clickOnAddButton() {
		logger.info("Clicking on Add button");
		click(add_Btn);
	}

	public void selectSoftOptionForNew(String option) throws InterruptedException {
		logger.info("Selecting software option for New equipment type");
		selectOption(softOption_DropDown, option);
	}

	public void selectQuantityForNew(String quantity) throws InterruptedException {
		logger.info("Selecting quantity for New equipment type");
		selectOption(softQuantity_dropDown, quantity);
	}

	public void selectModelTypeForNew(String model) throws InterruptedException {
		logger.info("Selecting Model Type for New equipment type");
		selectOption(softModel_DropDown, model);
	}

	public void selectAccessAvailableForNew(String avlAccess) throws InterruptedException {
		logger.info("Selecting Accessories available for New equipment type");
		selectOption(availAccess_dropDown, avlAccess);
	}

	public void selectQuantityForNewAccess(String quantity) throws InterruptedException {
		logger.info("Selecting software quantity for New equipment type");
		selectOption(quantity_DropDown, quantity);
	}

	public void clickOnCancelRecordButton() {
		logger.info("Clicking on Cancel Record button");
		click(cancelRec_Btn);
	}

	public void clickOnUpdateRecordForSoftRequest() {
		logger.info("Clicking on Update Record button");
		click(updateRec_Link);
	}

	public void clickOnDeleteRecordForSoftRequest() {
		logger.info("Clicking on Delete Record button");
		click(deleteRec_Link);
	}

	public void clickOnConfirmUpdate() {
		logger.info("Clicking on Confirm Update button");
		click(confirmUpdate_Btn);
	}

	public void enterAdditionalAccessories() throws InterruptedException {
		logger.info("Entering value in to additional accessories text box");
		typeText(additionalAccess_Txt_Box, "test");
	}

	public void selectWirelessDeviceRadioButton() {
		logger.info("Clicking on Wireless device radio button");
		click(wirelessDevice_RadioBtn);
	}

	public void selectEquipmentType(WebElement ele1, String device, WebElement ele2, String carrier)
			throws InterruptedException {
		logger.info("Selecting equipment type");
		Thread.sleep(2000);
		selectOption(ele1, device);
		Thread.sleep(2000);
		selectOption(ele2, carrier);
		Thread.sleep(2000);
	}

	public void selectEquipmentTypeByIndex(WebElement ele1, int deviceIndex, WebElement ele2, int carrierIndex)
			throws InterruptedException {
		logger.info("Selecting equipment type by index");
		Thread.sleep(2000);
		selectOptionByIndex(ele1, deviceIndex);
		Thread.sleep(3000);
		selectOptionByIndex(ele2, carrierIndex);
		Thread.sleep(2000);
	}

	public void selectContract(WebElement ele1, String str1) throws InterruptedException {
		logger.info("Selecting contract");
		selectOption(ele1, str1);
	}

	public void selectOtherEquipmentType() {
		logger.info("Clicking on Other radio button");
		click(wirelessDevice_RadioBtn);
		click(otherDevice_RadioBtn);
	}

	public void enterMobileDescription() throws InterruptedException {
		logger.info("Entering text in to mobile description text box");
		typeText(mobileDesc_TxtBox, "test");
	}

	public void clickOnCheckoutButton() {
		logger.info("Clicking on Wireless device radio button");
		click(checkout_Btn);
	}

	public String getRequestNumber() {
		logger.info("Getting Request Number");
		return reqNumber.getText();
	}

	public void clickOnSubmitOrderButton() {
		logger.info("Clicking on submit order button");
		click(submitOrder_Btn);

	}

	public void selectSmartphoneRadioButton() {
		logger.info("Clicking on Smartphone radio button");
		click(smartPhone_RadioBtn);
	}

	public void enterMobileNo() throws InterruptedException {
		logger.info("Entering mobile number for Smart phone");
		typeText(mobileNo_Txt_Box, prop.getProperty("mobileNumber"));
	}

	public void selectTabletRadioButton() {
		logger.info("Clicking on Tablet radio button");
		click(tablet_RadioBtn);
	}

	public void deviceOptionRadioButton() {
		logger.info("Clicking on Device Option radio button");
		click(deviceOption_RadioBtn);
	}

	public void selectShipToInfo() throws InterruptedException {
		logger.info("Selecting ship to information");
		click(shipToInfo_ChkBox);
		Thread.sleep(4000);
	}

}
