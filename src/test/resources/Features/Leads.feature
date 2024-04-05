@lead
Feature: leads functionlity


Scenario: login
Given user should on login page
When user enters valid credentials and click on login button
Then user should be navigated to home page


Scenario: create multiple lead
When user click on new lead link and fill all mandatory fields as "<lname>" , "<comp>" and click on save
|lname | comp |
|modi 1| bjp1|
|modi 1| bjp1|
|modi 1| bjp1|
Then lead should be created successfully


