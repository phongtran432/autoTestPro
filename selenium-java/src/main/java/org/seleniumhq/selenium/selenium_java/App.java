package org.seleniumhq.selenium.selenium_java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.Select;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
    	String filePath = "fileInput/ocTestData.xlsx";
    	FileInputStream inputStream = new FileInputStream(new File(filePath));
    	Workbook workbook = new XSSFWorkbook(inputStream);
    	Sheet firstSheet = workbook.getSheetAt(0);
    	Iterator<Row> iterator = firstSheet.iterator();
    	int countRow = 0;
    	
    	while (iterator.hasNext()){
    		Row nextRow = iterator.next();
    		Iterator<Cell>cellIterator = nextRow.cellIterator();
    		
    		
    		while(cellIterator.hasNext()){
    			Cell cell = cellIterator.next();
    			
    			switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				}
    			System.out.print("||");
    		}
    		System.out.println("");
    		countRow++;
    	}
    	
    	System.out.print("Total row: " + countRow);
    	/*WebDriver driver;
    	System.setProperty("webdriver.gecko.driver","driver//geckodriver.exe");
    	driver = new FirefoxDriver();
        driver.get("https://provider.liveandworkwell.com");
        WebElement menuTelementalHealth = driver.findElement(By.xpath("//li/a[text() = 'Telemental Health']"));
        menuTelementalHealth.click();
        WebElement classofTelementalHealth = driver.findElement(By.xpath("//li[a[contains(text(),'Telemental Health')]]"));
        System.out.println("class: " + classofTelementalHealth.getAttribute("class"));
       // Select locationsCombo = new Select(driver.findElement(By.xpath("//div[label[contains(text(),'What state are you located in?')]]/select[@id='stateSelect']")));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement locationsCombo = driver.findElement(By.xpath("//div[label[contains(text(),'What state are you located in?')]]/select[@id='stateSelect']"));
        //System.out.println(locationsCombo.getText());
        List<WebElement> options = locationsCombo.findElements(By.tagName("option"));

        for (WebElement option : options) {

        if("Indiana".equals(option.getText().trim()))

         option.click();   
    }
*/           	
}}
