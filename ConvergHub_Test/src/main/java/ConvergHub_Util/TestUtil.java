package ConvergHub_Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import ConvergHub_Base.TestBase;

public class TestUtil extends TestBase {
	public static long Page_load_timeout = 100;
	public static long implicit_wait = 50;
	
	static Workbook book;
	static Sheet sheet;
	
	public static void switchToActiveFrame() {
		driver.switchTo().parentFrame();
	}
	
	
	//To get the test data from excel file	
	public static Object[][] getTestData(String sheetName) {
		String testDataSheetPath = prop.getProperty("TESTDATA_SHEET_PATH");
		
		FileInputStream file = null;
		try {
			file = new FileInputStream(testDataSheetPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}
	
	
}
