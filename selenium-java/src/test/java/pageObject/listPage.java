package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class listPage {
	WebDriver driver;
	
	String titleFontName, titleFontSize, titleFontColor;
	String xpathTitle = "//*[@id='main']//table//th/div[text()='Title']";
	By titleHeader = By.xpath(xpathTitle);
	
	String sortIconColor;
	String xpathIconSort;
	
	public listPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getTitleFontName(){
		titleFontName = driver.findElement(By.xpath(xpathTitle)).getCssValue("font-family");
		return titleFontName;
	}

}
