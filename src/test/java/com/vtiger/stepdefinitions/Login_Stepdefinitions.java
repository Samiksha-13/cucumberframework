package com.vtiger.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Stepdefinitions extends PageObjectManager {
	

@Before
public void getScenario(Scenario scenario) throws Exception
{
	TCName = scenario.getName();
	initiation();
	logger = extent.createTest(TCName);
}

@After
public void saveresult()
{
	extent.flush();
}
	

@Given("user should on login page")
public void user_should_on_login_page() throws Exception {
   
	lauchApp();
	
}
@When("user enters valid credentials and click on login button")
public void user_enters_valid_credentials_and_click_on_login_button() {
	
	getLoginPage().login(dt.get(TCName).get("userid"), dt.get(TCName).get("password"));
    
}
@Then("user should be navigated to home page")
public void user_should_be_navigated_to_home_page() {
   
	getHomePage().verifyHome();
}
@Then("user can validate logout link")
public void user_can_validate_logout_link() {
	getHomePage().verifyLogout();
	getHomePage().clickLogout();
	
}

@When("user enters invalid credentials and click on login button")
public void invalidlogin() {
	
	getLoginPage().login(dt.get(TCName).get("userid"), dt.get(TCName).get("password"));
    
}
@Then("user should be navigated to login page")
public void navigated_to_login_page() {
	getLoginPage().verifyusername();
}
@Then("user can validate error message")
public void error_message() {
	
	getLoginPage().verifyErrorMsg();
    
}


@When("user enters invalid credentials as userid {string} and password {string} click on login button")
public void user_enters_invalid_credentials_as_userid_and_password_click_on_login_button(String userid, String pass) {
	getLoginPage().login(userid, pass);
}

@Then("close browser")
public void close_browser() {
	driver.quit();
    
}


@When("user click on new lead link and fill all mandatory fields as {string} , {string} and click on save")
public void user_click_on_new_lead_link_and_fill_all_mandatory_fields_as_and_click_on_save(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
   
	List<Map<String,String>> map = dataTable.asMaps();
	for(Map<String,String> m:map)
	{
		getLeadPage().clickNewLead();
		getLeadPage().createLead(m.get("lname"), m.get("comp"));
	}
	
}
@Then("lead should be created successfully")
public void lead_should_be_created_successfully() {
   
}







}
