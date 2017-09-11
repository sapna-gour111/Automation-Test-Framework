package com.servicenow.utils;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileExistsException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Implementation of various utility functions required for framework classes.
 * 
 * @author Vishal Jalgaonkar
 *
 */

public class ToolUtils {
	public static Logger logger = LogManager.getLogger();

	/**
	 * To get current working directory
	 * 
	 * @return current working directory
	 */
	public static String getCurrentDir() {
		logger.info("Getting current URL");
		String currentDir = System.getProperty("user.dir");
		return currentDir;
	}

	/**
	 * This method returns unique number. We can append time stamp to any number
	 * to generate unique number
	 * 
	 * @return
	 */
	public static String returnUniqueNumber() {
		logger.info("Getting unique number while appending time stamp to it");
		return new SimpleDateFormat("ddMMyyyyhhmmss").format(new Date());
	}

	/**
	 * This method captures screenshot
	 * 
	 * @param driver
	 * @param test
	 */
	public static void captureScreenshot(WebDriver driver, ExtentTest test) {
		logger.info("Capturing screenshot");
		String file_name = "img_" + System.currentTimeMillis() % 10000000 + ".png";
		String images_filepath = ".\\Extent-Reports\\" + file_name;
		test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(".\\" + file_name));
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(images_filepath));
		} catch (Exception e) {
		}
	}

	/**
	 * This method takes backup
	 */
	public static void takeBackUP() {
		logger.info("Taking back up");
		File source_files = new File(System.getProperty("user.dir") + "\\Extent-Reports");
		File backup_files = new File(System.getProperty("user.dir") + "\\Extent-Reports\\Backup");

		/**
		 * Backup Steps 1.List all files present in Extent-Reports folder.
		 * 2.Using for loop,Move all the Extent-Reports file to
		 * Extent-Reports/Backup folder.
		 **/

		if (source_files.isDirectory()) {
			File[] contents = source_files.listFiles();
			for (File file : contents) {
				if (file.isFile()) {
					try {
						FileUtils.moveFileToDirectory(file, backup_files, true);
					} catch (FileExistsException e) {

						/**
						 * If by chance any file is present in backup and same
						 * file is present in Result folder then it will throw
						 * error "FileExistsException", In this case we need to
						 * remove the Duplicate file present in Result to avoid
						 * further error.
						 **/
						System.out.println(
								"Error : FileExistsException : " + e.getMessage() + ", Hence removing this File.");
						boolean success = file.delete();
						if (!success)
							throw new IllegalArgumentException("Delete: deletion failed on " + file.getName());
					} catch (IOException e) {
						System.out.println("IOException : " + e.getMessage());
					}
				}
			}
		}
	}

	/**
	 * This is to register listeners
	 * 
	 * @param driver
	 * @param test
	 * @return
	 */
	public static WebDriverListener registerListener(EventFiringWebDriver driver, ExtentTest test) {
		WebDriverListener wdl = new WebDriverListener(test);
		driver.register(wdl);
		return wdl;
	}

	/**
	 * This is to unregistered listners
	 * 
	 * @param driver
	 * @param wdl
	 */
	public static void unregisterListener(EventFiringWebDriver driver, WebDriverListener wdl) {
		driver.unregister(wdl);
	}

	/**
	 * This method is to get current time
	 * 
	 * @return
	 */
	public static String getCurrTime() {
		logger.info("Getting current time");
		Format formatter = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ss");
		return formatter.format(Calendar.getInstance().getTime());
	}
}
