package com.test.automation.UiAutomation.homePage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.UiAutomation.testBase.TestBase;
import com.test.automation.UiAutomation.uiActions.HomePage;

public class TC002_SelectMenu extends TestBase{

	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	HomePage homepage;
	
	@BeforeTest
	public void setUp() throws InterruptedException{
		
		init();
	}
	
	@Test
	public void selectMenu() throws InterruptedException{
		homepage=new HomePage(driver);
		Thread.sleep(3000);
		homepage.chooseMenuNumber(1);
       // driver.findElement(By.cssSelector("[id='ul_layered_id_attribute_group_3']>:last-child>:nth-child(2)>:nth-child(1)")).click();
        homepage.selectCheckBox("(1)");
	}
}
