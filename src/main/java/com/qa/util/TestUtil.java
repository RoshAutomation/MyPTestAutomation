package com.qa.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	static Workbook book;
	static Sheet sheet;
	
	public static String TESTDATA_SHEET_PATH = "/Users/Roshan Kumar Gupta/workspace"
			+ "/MyPTestAutomation/src/main/java/com/qa/testdata/MyProvideTestData.xlsx";

	public TestUtil(){
		PageFactory.initElements(driver, this);
	}

	public void switchToWindow() throws InterruptedException{
		String parent=driver.getWindowHandle();
		System.out.println(parent);
		Set<String> allWindows=driver.getWindowHandles();
		for(String child:allWindows)
		{
			System.out.println(child);
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);			
				//driver.findElement(By.xpath("//a[@id='flow_11']")).click();	
				Thread.sleep(10000);
				String title=driver.getTitle();
				System.out.println(title);
			}
			
		}
	}
	
	public void ReturnToParent(String parent){
		driver.switchTo().window(parent);
		
	}
		
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		DataFormatter df=new DataFormatter();
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k);
				// System.out.println(data[i][k]);
				data[i][k]=df.formatCellValue((Cell) data[i][k]);
				
				
				
			}
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		}
	
	
	public void btnClick(String xpath){
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void editsetValue(String xpath, String valueToSet){	
		driver.findElement(By.xpath(xpath)).sendKeys(valueToSet);	
	}
	
	public void alertAceept(){
		driver.switchTo().alert().accept();
	}
	
	public boolean isElementPresent(By by) {
	    try {
	        driver.findElement(by);
	        return true;
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
	
	
	
	
	
	

}
