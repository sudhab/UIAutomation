package com.test.automation.UiAutomation.uiActions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement loginEmailAddress;
	
	@FindBy(xpath="//*[@id='passwd']")
	WebElement loginPassword;
	
	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement submitButton;
	
	@FindBy(xpath="//*[@id='center_column']/div[1]/ol/li")
	WebElement authenticationFailed;
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication(String emailAddress, String password) throws InterruptedException{
		
		signIn.click();
		log.info("clicked on sign in and object is "+signIn.toString());
		Thread.sleep(3000);
		loginEmailAddress.sendKeys(emailAddress);
		log.info("entered email address "+emailAddress+" and object is "+loginEmailAddress.toString());
		loginPassword.sendKeys(password);
		Thread.sleep(3000);
		log.info("entered password "+password+" and object is "+loginPassword.toString());
		submitButton.click();
		log.info("clicked on submit button and object is "+submitButton.toString());
		
	}
	
	public String getInvalidText(){
		log.info("error message is "+authenticationFailed.getText());
		return authenticationFailed.getText();
		
	}
	
	public void chooseMenuNumber(int menuNumber){
		WebElement element = driver.findElement(By.cssSelector("[id='block_top_menu']>ul>:nth-child("+menuNumber+")"));
		element.click();
		log.info("Clicked on element: "+element.getText());
	}
	
	public void selectCheckBox(String color){
		
		List<WebElement> selectColor=driver.findElements(By.xpath("//*[@id='ul_layered_id_attribute_group_3']/li/label/a/span"));
		
		for(WebElement e:selectColor){
			System.out.println(e.getText());
			if(e.getText().equalsIgnoreCase(color)){
				
				e.click();
			}
		}
	}
	
	

}
