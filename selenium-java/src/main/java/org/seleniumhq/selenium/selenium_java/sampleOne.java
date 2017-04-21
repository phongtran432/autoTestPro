package org.seleniumhq.selenium.selenium_java;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    	driver.get("https://www.codestringers.com/mastercontrol/product-style-guide/#/list-page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        By primaryButton = By.xpath("//*[@id='main']/main/div[3]/div[1]/div/div[2]/p/button[text()='Primary Button']");
        By titleHeader = By.xpath("[@id='main']/main/div[2]/section/div/table/thead/tr/th[1]/div[text()='Title']");
        
        String title = driver.findElement(By.xpath("//*[@id='main']//table//th/div[text()='Title']")).getCssValue("color");
        
        System.out.println("The result: " + title);
        
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
        /*WebElement element = driver.findElement(primaryButton);
        
        Actions action = new Actions(driver);
        
        action.clickAndHold(element).perform();

        String bgColor = element.getCssValue("background-color");

        System.out.println("Active: " + bgColor);
       
        action.click(element).perform();
         */        
        
        /*try {
        	Thread.sleep(1000);	
		} catch (Exception e) {
			// TODO: handle exception
		}*/
        
        /*String script = "return window.getComputedStyle(document.querySelector('.sortable.desc'),':after').getPropertyValue('color')";
        //String script = "document.getElementsByClassName('sortable desc').length";
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String content = js.executeScript(script).toString();
        System.out.println("Content: " + content);*/
        
        
/*        String script = "window.getComputedStyle(window.document.querySelector('.sortable.desc'),':after').getPropertyValue('color')";
        if (driver instanceof JavascriptExecutor) {
    		((JavascriptExecutor) driver).executeScript(script);
    	}*/
        
	}

}
