package com.servicenow.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	/**
	 * This class contains generic methods which return the data to the caller
	 * in String n-array,it is noted that the first row i.e headers will be
	 * ignored/not added in the returned data.
	 * 
	 * @author Vishal Jalgaonkar
	 *
	 */

	public static Logger logger = LogManager.getLogger();

	// Generic Function to Excel Read
	public String[][] excelRead(String _fileName, String _sheetName) throws Exception {
		try {
			String data[][] = null;
			File file = new File(System.getProperty("user.dir") + "\\Test Data\\" + _fileName);
			InputStream fis = new FileInputStream(file);
			Workbook workbook = null;
			String fileExtension = _fileName.substring(_fileName.indexOf("."));
			if (fileExtension.equals(".xlsx")) {
				workbook = new XSSFWorkbook(fis);
			} else if (fileExtension.equals(".xls")) {
				workbook = new HSSFWorkbook(fis);
			}

			Sheet sheet = workbook.getSheet(_sheetName);
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			Row row = sheet.getRow(0);
			int colCount = row.getLastCellNum();
			data = new String[rowCount][colCount];

			for (int i = 0; i < rowCount + 1; i++) {
				row = sheet.getRow(i);
				if (i == 0) {
				} else {
					for (int j = 0; j < colCount; j++) {
						Cell cell = row.getCell(j);
						if (cell.getCellType() == Cell.CELL_TYPE_STRING) {

							data[i - 1][j] = cell.getStringCellValue();

						}
						if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {

							data[i - 1][j] = cell.getStringCellValue();
						}

					}
				}
			}
			return data;
		} catch (NullPointerException e) {
			logger.error("Error : Worksheet might be missing/improper in TestData xls.");
			throw e;
		} catch (Exception e) {
			logger.error("Error : " + e.getLocalizedMessage());
			throw e;
		}
	}
}