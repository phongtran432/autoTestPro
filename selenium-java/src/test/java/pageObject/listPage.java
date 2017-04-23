package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import theLib.convertColorCode;

public class listPage {
	WebDriver driver;

	String titleFontFamily, titleFontColor;
	String titleFontSize;
	String xpathTitle = "//*[@id='main']//table//th/div[text()='Title']";
	By titleHeader = By.xpath(xpathTitle);

	String sortIconColor;
	String xpathIconSort;

	public listPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitleFontFamily() {
		titleFontFamily = driver.findElement(By.xpath(xpathTitle)).getCssValue("font-family").trim();
		return titleFontFamily;
	}

	public String getTitleFontSize() {
		titleFontSize = driver.findElement(By.xpath(xpathTitle)).getCssValue("font-size");
		return titleFontSize;
	}

	public String getTitleFontColor() {
		titleFontColor = driver.findElement(By.xpath(xpathTitle)).getCssValue("color");
		convertColorCode objConvert = new convertColorCode(titleFontColor);
		return objConvert.convertColorToHex().trim();
	}

	public String getSortIconColor() {
		String script = "return window.getComputedStyle(document.querySelector('.sortable'),':after').getPropertyValue('color')";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		sortIconColor = (String) js.executeScript(script);
		convertColorCode objConvert = new convertColorCode(sortIconColor);
		sortIconColor = objConvert.convertColorToHex();
		return sortIconColor.trim();
	}
}
