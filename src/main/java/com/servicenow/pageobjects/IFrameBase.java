package com.servicenow.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;
import com.servicenow.utils.Constants;
import com.servicenow.utils.PropertiesLoader;

/**
 * This class contains base methods to perform action on web pages iframes
 * 
 * @author Sapna Gour
 *
 */

public class IFrameBase {

	protected WebDriver driver = null;
	By errorMessagelbl = By.id("ctl00_ErrorControl1");
	static String mainiframe = new PropertiesLoader(Constants.CONFIG_FILE_PATH).getProperty("mainiframe");
	String Parent_Window = null;
	static String Parent_Window2 = null;

	// Update Incident Button
	@FindBy(xpath = "//*[@class='navbar_ui_actions']/descendant::*[contains(text(),'Update')]")
	public WebElement updateIncident_button;

	// Search groups
	@FindBy(tagName = "select")
	public WebElement searchGroups;

	// Search groups text box
	@FindBy(xpath = "//div[@class='input-group']/input")
	public WebElement searchGroupsTextBox;

	// Searched groups
	@FindBy(xpath = "//tbody[@class='list2_body']/tr/td[3]/a")
	public WebElement searchedGroup;

	// Default view
	@FindBy(xpath = "//div[contains(text(),'Default view')]")
	public WebElement defaultView;

	// Fast view
	@FindBy(xpath = "//div[contains(text(),'Fast')]")
	public WebElement fastView;

	// Self Service view
	@FindBy(xpath = "//div[contains(text(),'Self Service')]")
	public WebElement selfServiceView;

	// Click on View
	@FindBy(xpath = "//div[contains(text(),'View')]")
	public WebElement view;

	// Change -> Incident close notes
	@FindBy(id = "incident.close_notes")
	public WebElement closeNote;

	// Click on Additional Action
	@FindBy(xpath = "//div[@class='navbar-header']/button[2]")
	public WebElement additionalAction;

	// Click on State drop down
	@FindBy(xpath = "//select[@id='incident.state']")
	public WebElement stateDropDown;

	// Click on State drop down
	@FindBy(xpath = "//input[@name='sys_original.incident.state']")
	public WebElement inputState;

	// Click on Close Code drop down
	@FindBy(id = "incident.close_code")
	public WebElement closeCodeDropDown;

	// Add additional comment
	@FindBy(id = "incident.comments")
	public WebElement addComment;

	// Change Drop Down
	@FindBy(xpath = "//select[@id='chang_type']")
	public WebElement changeDropDown;

	// Switch To Full View
	@FindBy(xpath = "// a[contains(text(),'Switch to Full View')]")
	public WebElement switchToFullView;

	// Change Drop Down
	@FindBy(xpath = "//input[@name='Submit']")
	public WebElement changesubmitButton;

	public static Logger logger = LogManager.getLogger();

	public IFrameBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to switch to iframe using locator of iframe.
	 * 
	 * @param element
	 */
	public void switchToiFrame(final WebElement element) {
		logger.info("Switching to iFrame");
		closeAlert();
		driver.switchTo().frame(element);
	}

	/**
	 * This method is used to switch to iframe using index of iframe.
	 * 
	 * @param index
	 */
	public void switchToiFrame(int index) {
		logger.info("Switching to iFrame");
		closeAlert();
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch to iframe using id of iframe.
	 * 
	 * @param id
	 */
	public void switchToiFrame(String id) {
		logger.info("Switching to default iFrame");
		closeAlert();
		driver.switchTo().frame(id);
	}

	/**
	 * This method is used to switch to default iframe present on the
	 * application.
	 */
	public void switchToDefaultiFrame() {
		logger.info("Switching to default iFrame");
		closeAlert();
		driver.switchTo().defaultContent();
		if (driver.findElements(By.tagName("iframe")).size() > 0) {
			driver.switchTo().frame(mainiframe);
		}
	}

	/**
	 * This method is used to switch to Full view
	 */
	public void switchToFullView() {
		logger.info("Switching to Full view");
		click(switchToFullView);
	}

	/**
	 * This method is to click on update incident button
	 */
	public void clickOnUpdateIncident() {
		logger.info("Clicking on update incident button");
		switchToDefaultiFrame();
		updateIncident_button.click();
	}

	/**
	 * This method is used to switch to default window from iframe.
	 */
	public void switchToDefaultContent() {
		logger.info("Switching to default window");
		closeAlert();
		driver.switchTo().defaultContent();
		closeAlert();
	}

	/**
	 * This method only checks the DOM, (Ajax or AngularJS) Asynchronous calls
	 * cannot be detected by the document.readyState.
	 * 
	 * @return
	 */
	private static Predicate<WebDriver> pageIsVisible() {
		return new Predicate<WebDriver>() {
			@Override
			public boolean apply(WebDriver driver) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				if (js.executeScript("return document.readyState").equals("complete")
						&& (Boolean) js.executeScript("return jQuery.active == 0")) {

					return true;
				} else {
					return false;
				}
			}
		};
	}

	/**
	 * This waits up to 'X' seconds before throwing a TimeoutException or if it
	 * finds the element will return it in 0 - 10 seconds. WebDriverWait by
	 * default calls the ExpectedCondition every 500 milliseconds until it
	 * returns successfully. A successful return value for the ExpectedCondition
	 * function type is a Boolean value of true, or a non-null object..
	 */
	public void synchronize() {
		try {
			logger.info("Waiting for element to be visible");
			new WebDriverWait(driver, 60).until(pageIsVisible());
		} catch (Exception E) {
			logger.error("Error synchronize() : ", E.getLocalizedMessage());
		}
	}

	/**
	 * This method is used to go to perticular url
	 * 
	 * @param URL
	 */
	public void gotoURL(String URL) {
		logger.info("Navigating to URL");
		driver.get(URL);
	}

	/**
	 * This method is used to check whether alert is present or not.
	 * 
	 * @return
	 */
	public boolean isAlertPresent() {
		try {
			logger.info("Checking if alert is present on page");
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void cloeAlert2() {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to close the alert
	 */
	public void closeAlert() {
		logger.info("Closing alert");
		try {
			int i = 0;
			while (i < 3) {
				if (isAlertPresent()) {
					logger.info("---------> closeAlert() found Active Alert, Closing the same");
					driver.switchTo().alert();
					driver.switchTo().alert().accept();
				}
				synchronize();
				i++;
			}
		} catch (NoAlertPresentException ex) {
			logger.info("No Alert present on Webpage : ");
		} catch (Exception E) {
			logger.info("Unable to handle Alert present on Webpage : " + E.getLocalizedMessage());
		}
	}

	/**
	 * This method is used to get text present on alert window and to close
	 * alert
	 * 
	 * @return
	 */
	public String closeAlertAndGetItsText() {
		logger.info("Closing alert and getting its text");
		boolean acceptNextAlert = true;
		try {
			Alert _alert = driver.switchTo().alert();
			String alertText = _alert.getText();
			if (acceptNextAlert) {
				_alert.accept();
			} else {
				_alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	public String getParentWindowHandle() {
		Parent_Window2 = driver.getWindowHandle();
		System.out.println("caught parent window" + Parent_Window2);
		return Parent_Window2;
	}

	/**
	 * This method is used to switch to child window
	 */
	public void switchToChildWindow() {
		logger.info("Switching to child window");
		// Storing parent window reference into a String Variable
		// Parent_Window = driver.getWindowHandle();
		// Switching from parent window to child window
		for (String Child_Window : driver.getWindowHandles()) {
			driver.switchTo().window(Child_Window);
		}
	}

	/**
	 * This method is used to switch to child window and close it
	 * 
	 * @throws InterruptedException
	 */
	public String switchToChildWindowAndClose(WebElement ele) throws InterruptedException {
		logger.info("Switching to child window and closing it");
		String userText = "";
		// Storing parent window reference into a String Variable
		Parent_Window = driver.getWindowHandle();
		// Switching from parent window to child window
		for (String Child_Window : driver.getWindowHandles()) {
			driver.switchTo().window(Child_Window);
		}
		userText = getText(ele);
		return userText;
	}

	/**
	 * This method is used to switch to child window and select group
	 * 
	 * @throws InterruptedException
	 */
	public void switchToChildWindowAndSelectGroup() throws InterruptedException {
		logger.info("Switching to child window and selecting group");
		// Storing parent window reference into a String Variable
		Parent_Window = driver.getWindowHandle();
		// Switching from parent window to child window
		for (String Child_Window : driver.getWindowHandles()) {
			driver.switchTo().window(Child_Window);
		}
		selectOption(searchGroups, "for text");
		Thread.sleep(2000);
		typeText(searchGroupsTextBox, "Global ITSM System Support");
		Thread.sleep(2000);
		pressEnterUsingKeyboardKey(searchGroupsTextBox);
		Thread.sleep(2000);
		click(searchedGroup);
		switchToParentWindow();
		switchToParentWindow();
		switchToDefaultiFrame();

	}

	/**
	 * This method is used to switch to child window and close it
	 * 
	 * @throws InterruptedException
	 */
	public String switchToBussSelCatGetTextAndClose() throws InterruptedException {
		logger.info("Switching to Business selection catagory get text and close it");
		String text = "";
		// Storing parent window reference into a String Variable
		Parent_Window = driver.getWindowHandle();
		// Switching from parent window to child window
		for (String Child_Window : driver.getWindowHandles()) {
			driver.switchTo().window(Child_Window);
		}
		text = getText(driver.findElement(By.xpath("//span[@id='sys_user_hide_search']/span")));
		return text;
	}

	/**
	 * This method is used to switch to parent window
	 */
	public void switchToParentWindow() {
		logger.info("Switching to parent window");
		// Switching back to Parent Window
		driver.switchTo().window(Parent_Window);
	}

	/**
	 * This method is used to switch to parent window
	 */
	public void switchToParentWindowTry(String Parent_Window) {
		logger.info("Switching to parent window");
		// Switching back to Parent Window
		System.out.println(Parent_Window);
		driver.switchTo().window(Parent_Window);
	}

	/**
	 * This method is used to set attribute value.
	 * 
	 * @param Elementid
	 * @param Attribute
	 * @param Value
	 */
	public void setAttributeValue(String Elementid, String Attribute, String Value) {
		logger.info("Setting attribute value");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"document.getElementById('" + Elementid + "').setAttribute('" + Attribute + "', '" + Value + "')");
	}

	public List<String> getOptionsForList(WebElement ele) {
		logger.info("Getting all options from any drop down list");
		List<String> actualList = new ArrayList<String>();
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		Select select = new Select(ele);
		List<WebElement> itemList = select.getOptions();
		for (int i = 0; i < itemList.size(); i++) {
			actualList.add(itemList.get(i).getText());
		}
		return actualList;
	}

	public void selectOption(WebElement ele, String selectText) throws InterruptedException {
		logger.info("Selecting option from drop down");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		// switchToDefaultiFrame();
		Select select = new Select(ele);
		select.selectByVisibleText(selectText);
		Thread.sleep(1000);
	}

	public void selectOptionByIndex(WebElement ele, int index) throws InterruptedException {
		logger.info("Selecting option from drop down by index");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		Select select = new Select(ele);
		select.selectByIndex(index);
		Thread.sleep(1000);
	}

	public void selectClassificationName(WebElement ele, int index) throws InterruptedException {
		logger.info("Selecting option from classification drop down");
		/**
		 * This method is to switch to default i-frame and it is being called
		 * from IFrameBase class.
		 */
		switchToDefaultiFrame();
		Select select = new Select(ele);
		select.selectByIndex(index);
		Thread.sleep(1000);

	}

	public void click(WebElement ele) {
		logger.info("Clicking on element");
		ele.click();
	}

	public void typeText(WebElement ele, String text) throws InterruptedException {
		logger.info("Typing text in to text box");
		ele.sendKeys(text);

	}

	public void clearText(WebElement ele) {
		logger.info("Clearing text field");
		ele.clear();

	}

	public String getText(WebElement ele) {
		logger.info("Getting text of an element");
		return ele.getText();
	}

	public void pressEnterUsingKeyboardKey(WebElement ele) throws InterruptedException {
		logger.info("Pressing enter using keys present on keyboard");
		Actions action = new Actions(driver);
		action.sendKeys(ele, Keys.ENTER).build().perform();
	}

	public void moveToElement(WebElement ele) {
		logger.info("Moving to element");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
	}

	public String getAttribute(WebElement ele, String attribute) throws InterruptedException {
		logger.info("Getting attribute for an element");
		String str = ele.getAttribute(attribute);
		return str;
	}

	public void waitUntilElementIsVisible(WebElement ele) {
		logger.info("Waiting for element to become visible.");
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void refreshPage() {
		logger.info("Refreshing the page.");
		driver.navigate().refresh();
	}

	/**
	 * This method is used to click on language setting gear.
	 * 
	 * @throws InterruptedException
	 */
	public void selectLanguage(String language) throws InterruptedException {
		logger.info("Click on language setting gear button");
		driver.findElement(By.id("nav-settings-button")).click();
		Thread.sleep(2000);
		WebElement elem = driver.findElement(By.id("language_picker_select"));
		selectOption(elem, language);
		Thread.sleep(3000);

	}

	/**
	 * This method is used to get error message for verification.
	 * 
	 * 
	 */
	public String getErrMessage() throws InterruptedException {
		logger.info("Getting error message");
		String errMsg = closeAlertAndGetItsText();
		return errMsg;

	}

	/**
	 * This method is used to Impersonate the user.
	 * 
	 * @throws InterruptedException
	 */
	public void imperonateUser(String user, WebElement ele) throws InterruptedException {
		logger.info("Impersonating the user");
		driver.findElement(By.xpath("//button[@id='user_info_dropdown']/span[2]")).click();
		click(driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[2]/a")));
		driver.findElement(By.id("select2-chosen-2")).click();
		typeText(driver.findElement(By.id("s2id_autogen2_search")), user);
		Thread.sleep(5000);
		click(ele);
		Thread.sleep(3000);
	}

	/**
	 * This method is used to switch the incident views.
	 */
	public void switchIncidentView(String viewName) throws InterruptedException {
		logger.info("Switch the incident view");
		Thread.sleep(3000);
		click(additionalAction);
		Thread.sleep(1000);
		click(view);
		Thread.sleep(1000);
		switch (viewName) {
		case "DEFAULT":
			click(defaultView);
			Thread.sleep(3000);
			break;
		case "SELF SERVICE":
			click(selfServiceView);
			break;
		case "FAST VIEW":
			click(fastView);
			break;
		}
	}

	/**
	 * This method is used to change state of the incident.
	 */
	public void changeState(String stateName) throws InterruptedException {
		logger.info("Change the state of incident");
		switch (stateName) {
		case "RESOLVED":
			selectOption(stateDropDown, "Resolved");
			break;
		case "CLOSED":
			selectOption(stateDropDown, "Closed");
			break;
		case "REOPENED":
			selectOption(stateDropDown, "Reopened");
			break;
		}
	}

	/**
	 * This method is used to select close code.
	 */
	public void closeCode(String codeName) throws InterruptedException {
		logger.info("Select close code");
		switch (codeName) {
		case "CANCELLED":
			selectOption(closeCodeDropDown, "Cancelled");
			break;
		}
	}

	/**
	 * This method is used to add additional comment.
	 */
	public void additionalComment() throws InterruptedException {
		logger.info("Entering additional comment");
		typeText(addComment, "test");
	}

	public void enterCloseNotes() throws InterruptedException {
		logger.info("Enter Close Notes");
		typeText(closeNote, "Test close notes ");
	}

	/**
	 * This method is used to select Change type.
	 */
	public void selectChangeType(String changeType) throws InterruptedException {
		logger.info("Selecting type of change.");
		switch (changeType) {
		case "STANDARD":
			selectOption(changeDropDown, "Standard");
			break;
		}
		click(changesubmitButton);
		Thread.sleep(2000);
	}

}