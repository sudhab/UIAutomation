package com.test.automation.UiAutomation.customListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.test.automation.UiAutomation.testBase.TestBase;

public class Listener extends TestBase implements ITestListener{
	
/*	WebDriver driver;
	public Listener(WebDriver driver){
		this.driver=driver;
	}*/

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodName = result.getName();
		
		if(result.isSuccess()){
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			try{
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/test/automation/UiAutomation/screenshot";
				File destFile = new File((String)reportDirectory+"/success_screenshots/"+methodName+"_"+formater.format(calender.getTime())+".png");
				FileUtils.copyFile(srcFile, destFile);
				Reporter.log("<a href='"+destFile.getAbsolutePath()+"'> <img src='"+destFile.getAbsolutePath()+"'height='100' width='100'/> </a>");
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}
	
	

}
