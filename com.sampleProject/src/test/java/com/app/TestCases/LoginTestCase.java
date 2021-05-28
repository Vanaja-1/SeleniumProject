package com.app.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class LoginTestCase 
{
	public static WebDriver driver;
	//public static CaptureScreens capture = new CaptureScreens();
	public static ExtentReports extent = new ExtentReports("./testreports/testreport",true);
	public static ExtentTest report = extent.startTest("Login Test");
	
	@BeforeTest
	public void launchBrowser() {
	
		System.setProperty("webdriver.chrome.driver","./appDrivers/chromedriver.exe");
	    driver= new ChromeDriver();
	    driver.get("https://www.mycontactform.com/");
	    System.out.println("Launching browser");
	    Reporter.log("Invoke browser");
	    report.log(LogStatus.INFO, "Invoke Browser");
	    
	}
	    @Test
    public void verifymaventest()
    {
        driver.findElement(By.name("user")).sendKeys("tester");
        System.out.println("Enter name");
        
        Reporter.log("verifyusername");
        report.log(LogStatus.INFO, "test username");
             
      
        driver.findElement(By.name("pass")).sendKeys("admin");
        System.out.println("Enter password");
        
        Reporter.log("verifypassword");
        report.log(LogStatus.INFO, "tset password");
        
      WebElement loginbutton = driver.findElement(By.name("btnSubmit"));
      loginbutton.click();
        System.out.println("Click login button");
        
        Reporter.log("verify login button");
        report.log(LogStatus.INFO, "login button");
        
        if(loginbutton.isEnabled()) {
        	loginbutton.click();
        	report.log(LogStatus.PASS, "step performed");
        }
        else
        {
        	report.log(LogStatus.FAIL, "step failed");
        }
        
        
        
    }
    
    @AfterTest
    public void closingbrowser() {
    	driver.close();
    	System.out.println("closing driver");
    }
    
    
    
    
    
    
    
    
}
