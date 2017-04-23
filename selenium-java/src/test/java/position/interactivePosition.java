package position;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import theLib.convertColorCode;

public class interactivePosition {
	WebDriver driver;
	By primaryButton = By.xpath("//*[@id='main']/main/div[3]/div[1]/div/div[2]/p/button[text()='Primary Button']");
	String backgroundColorActive;
	convertColorCode objConvert;
	
	public interactivePosition(WebDriver driver){
		this.driver = driver;
	}
	
	public String getBackgroundColorNormal(){
		/*backgroundColorActive = driver.findElement(primaryButton).getCssValue("background-color");
		objConvert = new convertColorCode();
		return objConvert.convertColorToHex(backgroundColorActive);*/
		return "";
	}
	
	public String getBackgroundColorHover(){
		
		return "";
	}
}
