package TC_ListPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.steadystate.css.userdata.UserDataConstants;

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
    readExcelFile objTitle;
    readExcelFile objProduct;
    readExcelFile objNumber;
    
    @BeforeTest
    public void setUp(){
    	System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
    	driver = new ChromeDriver();
        driver.get("https://www.codestringers.com/mastercontrol/product-style-guide/#/list-page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
   @Test(priority=0)
   public void verify_Title() throws IOException{
	   objListPage = new listPage(driver);
	   String fonFamily = objListPage.getTitleFontFamily();
	   String fontSize = objListPage.getTitleFontSize();
	   String fontColor = objListPage.getTitleFontColor();
	   String sortIconColor = objListPage.getSortIconColor(); 
	   
	   System.out.println("Title Font Color: " + fontColor);
	   System.out.println("Sort icon color: " + sortIconColor);
	   
	   objTitle = new readExcelFile(expectationFilePath, headerTableSheet, titleRow);
	   String fontFamilyExpectation = objTitle.getFontFamily(objTitle.getRowValues());
	   String fontSizeExpectation = objTitle.getFontSize(objTitle.getRowValues());
	   String fontColorExpectation = objTitle.getFontColor(objTitle.getRowValues());
	   String sortIconColorExpectation = objTitle.getSortIconColor(objTitle.getRowValues());
	   
	   System.out.println("Title Font Color expectation: " + fontColorExpectation);
	   System.out.println("Sort icon color expectation: " + sortIconColorExpectation);
	   
	   System.out.println("Font fonFamily: " + fonFamily);
	   System.out.println("Font fontFamilyExpectation: " + fontFamilyExpectation);
	   
	   if(fonFamily.contains(fontFamilyExpectation)){
		   if(fontSize.equals(fontSizeExpectation)){
			   System.out.println("Test Case1: Passed");
		   }
	   }else{
		   System.out.println("Test Case: Failed");}
	   
	   if(fontColor.toLowerCase().equals(fontColorExpectation.toLowerCase())){
		   System.out.println("Test Case2: Passed");
	   }
   }
   
   @AfterMethod
   public void afterMethod(){
	   driver.quit();
   }
}
