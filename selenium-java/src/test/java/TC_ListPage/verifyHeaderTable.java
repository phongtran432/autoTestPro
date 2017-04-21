package TC_ListPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.listPage;
import position.interactivePosition;
import theLib.readExcelFile;

public class verifyHeaderTable {
	WebDriver driver;
	listPage objListPage;
    String fontFamilyExpectation;
    
    String expectationFilePath = "expectationFile/ListPage.xlsx";
    String headerTableSheet = "header_table";
    String titleRow = "TITLE";
    String titleFontFamily;
    String titleFontSize;
    String titleFontColor;
    String titleSortIconColor;
    
    String productRow = "PRODUCT";
    String productFontFamily;
    String productFontSize;
    String productFontColor;
    String prodoctSortIconColor;
    
    String NumberRow = "NUMBER";
	
    readExcelFile objExcel;
    
    @BeforeTest
    public void setUp(){
    	System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
    	driver = new ChromeDriver();
        driver.get("https://www.codestringers.com/mastercontrol/product-style-guide/#/list-page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
   @Test(priority=0)
   public void verify_Header() throws IOException{
	   objListPage = new listPage(driver);
	   System.out.println("Result: " + objListPage.getTitleFontName());
	   objExcel = new readExcelFile(expectationFilePath, headerTableSheet, titleRow);
	   System.out.println("Row value: " + objExcel.getRowValues());
   }
}
