package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.commonActions.PageActions;

public class LeadPage extends PageActions {
	
	public LeadPage(WebDriver driver)
	{
		super(driver);		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="New Lead")
	WebElement newlead_menu;
	
	@FindBy(linkText="Leads")
	WebElement leads_menu;
	
	@FindBy(name="lastname")
	WebElement lastname;
	
	@FindBy(name="company")
	WebElement comp;
	
	@FindBy(name="button")
	WebElement save;
	
	
	public void clickNewLead()
	{
		click_element(newlead_menu,"New Lead menu clicked");
	}
	
	public void clickLeads()
	{
		 click_element(leads_menu,"Leads menu clicked");
	}
	
	public void createLead(String lname, String cmp)
	{
		enter_text(lastname,lname,lname+" has been entered into Lastname field");
		enter_text(comp,cmp,cmp+" has been entered into Company field");
		click_element(save,"Save button clicked");
	}

}
