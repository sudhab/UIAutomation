package com.test.automation.UiAutomation.testBase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.test.automation.UiAutomation.customListener.WebEventListener;

public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public WebDriver dr;
	String url = "http://automationpractice.com/index.php";
	String browser = "firefox";
	public EventFiringWebDriver driver;
	public WebEventListener eventListener;
	
	public EventFiringWebDriver getDriver() {
		return driver;
	}

	public void setDriver(EventFiringWebDriver driver) {
		this.driver = driver;
	}

	
	public void init() throws InterruptedException{
		
		selectBrowser(browser);
		//listener = new Listener(driver);
		getUrl(url);
		String log4jConfPath="log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
	}
	
	public void selectBrowser(String browser){
		
		if(browser.equalsIgnoreCase("firefox")){
			log.info("creating object of "+browser);
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			dr=new FirefoxDriver();
			driver=new EventFiringWebDriver(dr);
			eventListener=new WebEventListener();
			driver.register(eventListener);
		}
		
	}
	
	public void getUrl(String url) throws InterruptedException{
		log.info("Navigating to "+url);
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	

}
