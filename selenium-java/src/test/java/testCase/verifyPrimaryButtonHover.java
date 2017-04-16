package testCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.HomePage;
import pages.Login;
import position.interactivePosition;

public class verifyPrimaryButtonHover {

	WebDriver driver;
	interactivePosition objInteractive;
    
    @BeforeTest
    public void setUp(){
    	System.setProperty("webdriver.gecko.driver","driver//geckodriver.exe");
    	driver = new FirefoxDriver();
        driver.get("https://www.codestringers.com/mastercontrol/product-style-guide/#/buttons");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
   @Test(priority=0)
   public void verify_backgroundColorHover(){
	   objInteractive = new interactivePosition(driver);
	   //System.out.println("Background color: " + objInteractive.getBackgroundColorActive());
   }
    
   /*// public void test_Home_Page_Appear_Correct(){

        //Create Login Page object

    objLogin = new Login(driver);

    //Verify login page title

    String loginPageTitle = objLogin.getLoginTitle();

    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

    //login to application

    objLogin.loginToGuru99("mgr123", "mgr!23");

    // go the next page

    objHomePage = new HomePage(driver);

    //Verify home page

    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
    }*/

}
