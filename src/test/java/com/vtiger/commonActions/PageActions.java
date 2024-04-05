package com.vtiger.commonActions;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vtiger.stepdefinitions.BaseSteps;

public class PageActions {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	public PageActions(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	}
	
	
	public String getScreenshot() 
	{
		System.out.println("git");
		Date d = new Date();
		DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName = ft.format(d);
		String path = System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/screenshot/"+fileName+".png";
	
		TakesScreenshot ts = ((TakesScreenshot)driver);
		
		File SrcFile=ts.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(path);
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	public void enter_text(WebElement elm, String val,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.clear();
		elm.sendKeys(val);
		BaseSteps.logger.pass(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BaseSteps.logger.fail("Step failed due to exception "+e.getMessage()+"<a href='"+getScreenshot()+"' ><span class='label end-time'>Screenshot</span></a>");
		}
	}
	
	public void click_element(WebElement elm,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(elm));
		elm.click();
		BaseSteps.logger.pass(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BaseSteps.logger.fail("Step failed due to exception "+e.getMessage()+"<a href='"+getScreenshot()+"' ><span class='label end-time'>Screenshot</span></a>");
		}
	}
	
	public boolean element_exist(WebElement elm,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.isDisplayed();
		BaseSteps.logger.pass(msg);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BaseSteps.logger.fail("Step failed due to exception "+e.getMessage()+"<a href='"+getScreenshot()+"' ><span class='label end-time'>Screenshot</span></a>");
			return false;
		}
		
	}
	

}
