package org.seleniumhq.selenium.selenium_java;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	WebDriver driver;
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
        System.out.println("Debug");
}}
