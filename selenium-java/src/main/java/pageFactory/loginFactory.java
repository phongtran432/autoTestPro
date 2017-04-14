package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginFactory {
	WebDriver driver;
	@FindBy(name="uid")
	WebElement userName;
	
	public void setUserName (String strUserName){
		userName.sendKeys(strUserName);
	}
}
