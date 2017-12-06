package com.test.automation.UiAutomation.homePage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.UiAutomation.testBase.TestBase;
import com.test.automation.UiAutomation.uiActions.HomePage;

public class TC001_VerifyLoginWithInvalidCredentials extends TestBase{

	// My second commit
	// This will be shown only after i commit
	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	HomePage homepage;
	
	@BeforeTest
	public void setUp() throws InterruptedException{
		
		init();
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials() throws InterruptedException{
		log.info("===========Starting verifyLoginWithInvalidCredentials test===========");
		homepage=new HomePage(driver);
        homepage.loginToApplication("test@gmail.com", "password123");
        Thread.sleep(3000);
		Assert.assertEquals(homepage.getInvalidText(), "Authentication failed.");
		log.info("===========Finished verifyLoginWithInvalidCredentials test===========");
	}
	
	@AfterTest
	public void endTest(){		
		driver.close();
	}

	//This is my third commit
	//now you can see the difference by color
}
