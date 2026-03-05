Feature: Article Place Order

Scenario: User Login
Given User is on login page
When User enters "agalya.s@gmail.com" and "agalya"
Then User should be on Home Page

Scenario Outline: Create an Article
Given User should be on Home Page
When User creates new article "<title>" "<desc>" "<maincnt>" "<tag>"
Then Article is Created "<title>"
Examples:
|title|desc|maincnt|tag|
|Go Lang1AZ9C|Go Language|Go Language by Google|GoGoogle|

Scenario: Update an Article
Given Article is Created "Go Lang1AZ9C"
When User updates article
|Go Lang1AZ9B|
Then Article is Updated "Go Lang1AZ9B"

Scenario: Delete an Article
Given Article is Created "Go Lang1AZ9B"
When User deletes article
|title|
|Go Lang1AZ9B|
Then Article is Deleted "Go Lang1AZ9B"