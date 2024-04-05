package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.commonActions.PageActions;

public class HomePage extends PageActions {
	
	public HomePage(WebDriver driver)
	{
		super(driver);		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Home123")
	WebElement home_menu;
	
	@FindBy(linkText="Logout")
	WebElement lnk_logout;
	
	
	public boolean verifyHome()
	{
		return element_exist(home_menu,"Home menu is displayed");
	}
	
	public boolean verifyLogout()
	{
		return element_exist(lnk_logout,"Logout link is exist on Home Page");
	}
	
	public void clickHome()
	{
		click_element(home_menu, "Home menu clicked");
	}
	
	public void clickLogout()
	{
		 click_element(lnk_logout,"Logout clicked");
	}


}
