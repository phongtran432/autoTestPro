package org.seleniumhq.selenium.selenium_java;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;



public class sampleOne {

	public static void main(String[] args) {
		WebDriver driver;
		/*System.setProperty("webdriver.gecko.driver","driver//geckodriver.exe");
    	driver = new FirefoxDriver();*/
    	System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.get("https://www.codestringers.com/mastercontrol/product-style-guide/#/buttons");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        By primaryButton = By.xpath("//*[@id='main']/main/div[3]/div[1]/div/div[2]/p/button[text()='Primary Button']");
        
        /***
         * get CSS Attribute when hover
         */
        /*Actions builder = new Actions(driver);
        
        WebElement element = driver.findElement(By.xpath("//*[@id='main']/main/div[3]/div[1]/div/div[2]/div[1]/button[1]"));

        builder.moveToElement(element).perform();   

        String bgColor = element.getCssValue("background-color");

        System.out.println("After hover: " + bgColor);
         */
        
        /***
         * get CSS Attribute when focus
         */
       /*  
        WebElement element = driver.findElement(primaryButton);
        
        element.click();   

        String bgColor = element.getCssValue("background-color");

        System.out.println("Focus: " + bgColor);
        */
        
        /***
         * get CSS Attribute when active
         */
        WebElement element = driver.findElement(primaryButton);
        
        Actions action = new Actions(driver);
        
        action.clickAndHold(element).perform();

        String bgColor = element.getCssValue("background-color");

        System.out.println("Active: " + bgColor);
       
        action.click(element).perform();
        
	}

}
