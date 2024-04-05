package com.vtiger.stepdefinitions;

import com.vtiger.pages.AccountPage;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

public class PageObjectManager extends BaseSteps {
	
	public  LoginPage lp;
	public  HomePage hp;
	public  LeadPage ldp;
	public  AccountPage ap;
	
	
	public LoginPage getLoginPage()
	{
		if(lp==null)
		{
			lp = new LoginPage(driver);	
			return lp;
		}
		else 
		{
			return lp;
		}
			
	}
	
	public LeadPage getLeadPage()
	{
		if(ldp==null)
		{
			ldp = new LeadPage(driver);	
			return ldp;
		}
		else 
		{
			return ldp;
		}
			
	}
	
	public HomePage getHomePage()
	{
		if(hp==null)
		{
			hp = new HomePage(driver);	
			return hp;
		}
		else 
		{
			return hp;
		}
			
	}
	
	
	

}
