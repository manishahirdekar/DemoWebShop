@DemoWebShop
Feature: Demo Web Shop

#Manisha 
@websiteurl
Scenario: website URL is working
#Given user has opened browser
When enter the DemoWebShop url
Then user is on the homepage

@registrationpage
Scenario: open registration page
Given user is on the homepage
When click on the register link 
Then user is on registration page

@newregistration
Scenario Outline: new user registration
Given user is on registration page 
When enter <gender>,<firstName>,<lastName>,<email>,<password>,<confirmPassword> and click on register
And click on continue
Then user is on the homepage
Examples: 
	|gender|firstName|lastName|email|password|confirmPassword|
	|Male|Sherlock|Holmes|Mhirdekar767689@gmail.com|Iam5herlocked|Iam5herlocked|

@logout
Scenario: Logout
Given user is on the homepage
When click on logout
Then user is logged out

@loginpage
Scenario: open login page
Given user is on the homepage
When click on the login link 
Then user is on login page

@newlogin
Scenario Outline: log in user
Given user is on login page
When input <userid> and <pwd>
And click on login
Examples:
	|userid|pwd|
	|hirdekar2@gmail.com|qwerty@123|
	
		
#Kajal
@search
Scenario: search store
Given user is on the homepage
When enter book 
And  click search
Then user is on the search page

@products
Scenario: product display
Given user is on the search page
When hover on computers 
And select desktops
Then user is on result page

@Sort
Scenario: sort by
Given user is on result page
When click on sort by Name:Z to A
Then sorting is applied on products
When click on display 4
Then user is on result page

@filter
Scenario: filter by
Given: user is on the result page
When click on under twenty five
Then filter is applied on products

@Addtocart
Scenario: add to cart
Given user is on result page
When click on add to cart button
Then user is on shopping cart page


#GUNJAN
@scart1
Scenario: shopping cart
Given user is on the shopping cart
When enter estimate information
And click on estimate button
Then days required to delivery is diplayed

@checkout1
Scenario: checkbox
When select checkbox2
And click on checkout
Then user is on checkout


#SHIVPRIYA
@billingaddress
Scenario Outline: billing address
Given user is on checkout page 
When Select new adrress and enter details <Country> and <City> and <Address1> and <ZipCode> and <PhoneNumber>
Then click on billingContinue
Examples: 
|Country|City|Address1|ZipCode|PhoneNumber| 
|India|Karad|DuttNagar|415110|8899889988|
       
@shippingaddress
Scenario Outline: shipping address
Given user is at shipping address 
When user select shipping address
Then click on shipping continue  

@shippingmethod
Scenario: shipping method
Given user is at shipping method
When click on shipping radio button
Then click on shipping method continue
  
@paymentmethod
Scenario: payment method
Given user is at payment method
When click on payment radio button 
Then click on payment method continue
  
@paymentinformation
Scenario: payment information
Given user is at payment information
Then click on payment information continue
  
@confirmbutton
Scenario: confirm button
Given user is at confirm order 
Then click on confirm

#PRATHMESH
@orederhyperlink
Scenario: order details hyperlink
Given order successful
When click on hyperlink of order details
Then user is on order details page

@pdfinvoice
Scenario: pdf invoice button
Given user is on order details page
When click on pdf invoice button
Then order details pdf is downloaded in computer

@print
Scenario: print button
Given user is on order details page
When click on print button
Then new tab of order details page is displayed

@reorder
Scenario: reorder button
Given user is on order details page
When click on reorder button
Then user is on shopping cart

@updateshoppingcart
Scenario: update shopping cart button
Given user is on shopping cart
When enter changed quantity of product
And click on update shopping cart button
Then new quantity of product is displayed and saved

@continueshopping
Scenario: continue shopping button
Given user is on shopping cart
When click on continue shopping button
Then user is on the result page
Then user is on checkout completed page

@continuebutton
Scenario: click on continue button
When click on continue button
Then user is on the the homepage
	