@shri
Feature: login functionality

Background: 
Given user should on login page

@testdt
Scenario: verify_valid_login_TC01
When user enters valid credentials and click on login button
Then user should be navigated to home page
And user can validate logout link

@testdt
Scenario: verify_Invalid_login_TC02
When user enters invalid credentials and click on login button
Then user should be navigated to login page
And user can validate error message

@smoke @invalid
Scenario Outline: invalid login2_"<TCName>"
When user enters invalid credentials as userid "<userid>" and password "<password>" click on login button
Then user should be navigated to login page
And user can validate error message
And close browser
Examples:
|userid | password|TCName|
|admin1 | pass1   |TC01|
|admin2 | pass2   |TC02|
|admin3 | pass3   |TC03|

@sanity
Scenario: invalid login3
When user enters invalid credentials and click on login button
Then user should be navigated to login page
And user can validate error message


