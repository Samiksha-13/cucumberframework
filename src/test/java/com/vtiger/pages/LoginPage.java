package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.commonActions.PageActions;

public class LoginPage extends PageActions {
	
	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);		
		PageFactory.initElements(driver, this);
	}
	
	//String userid = "user_name";
	//By userid = By.name("user_name");
	
	@FindBy(name="user_name")
	WebElement userid;
	
	@FindBy(name="user_password")
	WebElement password;
	
	@FindBy(name="Login")
	WebElement login;
	
	@FindBy(xpath="//*[contains(text(),'123You must specify a valid username and password.')]")
	WebElement errormsg;
	
	@FindBy(xpath="//img[@src='include/images/vtiger-crm.gif']")
	WebElement logo;
	
	
	
	public void login(String user, String pass)
	{		
		enter_text(userid,user,user+" has been entered into username field");
		enter_text(password,pass,pass+" has been entered into password field");
		click_element(login,"login button clicked");
	}
	
	
	public boolean verifyusername()
	{
		return element_exist(userid,"username field is exist on login page");
	}
	
	public boolean verifyLogo()
	{
		return element_exist(logo,"Logo is displayed on login page");
	}
	
	public boolean verifyErrorMsg()
	{
		return element_exist(errormsg,"Error message validated successfully");
	}

}
