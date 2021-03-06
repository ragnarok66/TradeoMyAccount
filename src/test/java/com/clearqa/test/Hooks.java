/*package com.clearqa.test;

public class Hooks {

}


import java.net.MalformedURLException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
public class Hooks{
    public static WebDriver driver;
    
    @Before
    *//**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     *//*
    public void openBrowser() throws MalformedURLException {
    	System.out.println("Called openBrowser");
    	driver = new ChromeDriver();
    	driver.manage().deleteAllCookies();
    }
 
    
    @After
    *//**
     * Embed a screenshot in test report if test is marked as failed
     *//*
    public void embedScreenshot(Scenario scenario) {
       
        if(scenario.isFailed()) {
        try {
        	 scenario.write("Current Page URL is " + driver.getCurrentUrl());
//            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        
        }
        driver.quit();
        
    }
    
}*/
package com.clearqa.test;
import java.net.MalformedURLException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
/*import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;*/
public class Hooks{
    public static WebDriver driver;
    
    @Before("@start")
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() throws MalformedURLException {
        //String browser = System.getProperty("BROWSER");
       String browser = System.setProperty("webdriver.chrome.driver", "/C:/chromedriver.exe");
       driver = new ChromeDriver();
       //String phantomjs_dir = System.getenv("PHANTOMJS_PATH");
        /*switch (browser)
        {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "phantomjs":
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,phantomjs_dir+"//phantomjs.exe");
                driver = new PhantomJSDriver(caps);
                break;
            default:
                driver = new ChromeDriver();
                break;
        }*/
   	    System.out.println("Opening Browser...."+browser);
    	driver.manage().deleteAllCookies();
    }
 
    @After("@end")
    
    /** 
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {
        if(scenario.isFailed()) {
        	try {
        		 scenario.write("Current Page URL is " + driver.getCurrentUrl());
//           	 byte[] screenshot = getScreenshotAs(OutputType.BYTES);
        		 byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        		 scenario.embed(screenshot, "image/png");
        		} catch (WebDriverException somePlatformsDontSupportScreenshots) {
        			System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        			}
        }
       driver.quit();
    }
    
}