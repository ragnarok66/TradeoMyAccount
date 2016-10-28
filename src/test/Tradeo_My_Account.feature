Feature: Tradeo My Account

@start
  Scenario Outline: Web page is visible
	Given I navigate to Tradeo Home Page "<HomePage>"
	Then I verify the page is visible
    
    Examples: 
    
    | HomePage  |
    | https://tradeo.com/|
 
  
 Scenario Outline: Login Fail
	Given I am on Tradeo Home Page
	When I click SIGN IN button
	Then login popup appears
	When I enter invalid "<username>" and "<password>"
	And I click on commit butoon
	Then Valid error message appears
	
	Examples:
	
	|username|password|
	|Game@gmail.com|password123|
	
 Scenario Outline: Successfull login
	Given I navigate to Tradeo Home Page "<HomePage>"
	When I click SIGN IN button
	Then login popup appears
	When I enter valid "<username>" and "<password>"
	And I click on commit butoon
	Then I am successfully redirected to My Account page

	Examples:
	
	|username|password|HomePage|
	|tradeo.user666@gmail.com|odin.2000|https://tradeo.com/|
	
 Scenario Outline: Successfull logout
	Given I am on My Account Page
	When I click SIGN OUT button
	Then I am redirected to Tradeo Home Page
	
	Examples:
	
	||
	||

#To Be Continued
	
Scenario: Verify 5 basic areas on My Account page
Given I am on My Account page
Then I should have five basic areas "<My Account>" "<Account Status>" "<Copying>" "<Top Traders to Copy>" "<Top Traders to Follow>" 

Scenario: Verify My Account and Account Status in My Account page
Given I am on My Account page
Then My Account is with correct "<MyAccount>"
And All credentials in Account Status are null

Scenario: Verify Copyin area on My Account page
Given I am on My Account page
Then I should see correct message, video area and button with text "<START COPYING TRADES>"

Scenario: Start Copying Trades
Given I am on My Account page
When I click on button START COPYING TRADERS
Then I should be redirected to page traders

Scenario: Verify All popups on page trades
Given I navigate to Traders page from My Account page
Then first Popup should appear with buttons "<Close>","<Next>" and message "<Welcome to our community of Social Traders!>"
When I click on Next button
Then I should see popup with text "<Easily decide who to follow and copy: sort Traders by gain, number of followers or copiers>" and buttons Previous and Next
When I click on Next button
Then I should see third popup with text "<or filter them by different criteria like experience, approach, trade duration, etc.>" and buttons Previous and Next
When I click on Next button
Then I should see fourth popup with text "<If a friend of yours has already joined us search for their name>" and buttons Prevous and Next
When I click on Next button
Then I should see fifth popup with text "<Follow top Traders - receive the news they share and see all their transactions displayed on your chart>" and buttons Previous and Next
When I click on Next button
Then I should see sixed popup with text "<Copy best Traders - check out their account information>" and buttons Previous and Next
When I click on Next button
Then I should see sedmiq popup with text "<click the 'Copy Account' button and let them win money on your behalf>" and buttons Previous and Next
When I click on Next button
Then I should see the final popup with text "<Happy Social Trading!>" and buttons Previous and Close
When I click on button Close
Then I should stay on page Traders

Scenario: Verify Top Traders to Copy area on My Account page
Given I am on My Account page
Then I should see correct message with text "<Choose traders to manage your account>" and 5 available Traders for copy

Scenario: Verify Top Traders to Follow area on My Account page
Given I am on My Account page
Then I should see correct message with text "<The more traders you follow - the more trading activity you will see on your Social WebTrader>" and 5 Traders to follow
