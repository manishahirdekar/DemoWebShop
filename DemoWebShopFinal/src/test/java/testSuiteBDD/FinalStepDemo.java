package testSuiteBDD;

import org.openqa.selenium.By;
import base.Base;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Checkout;
import pages.Registration;
import pages.Reorder;
import pages.Search;
import pages.ShoppingCart;

public class FinalStepDemo extends Base 
{
	//MANISHA
	Registration h=new Registration();
	
    @When("^enter the DemoWebShop url$")
    public void enter_the_demowebshop_url() throws Throwable 
    {
    	//setup();
        h.openUrl();  
    }

    @Then("^user is on the homepage$")
    public void user_is_on_the_homepage() throws Throwable 
    {
    	r1.homepage();
    }
    @When("^click on the register link$")
    public void click_on_the_register_link() throws Throwable 
    {
        h.linkToReg();    
    }

    @Then("^user is on registration page$")
    public void user_is_on_registration_page() throws Throwable 
    {
    	h.validate_register();
    }
    
    @When("^enter (.+),(.+),(.+),(.+),(.+),(.+) and click on register$")
    public void enter_and_click_on_register(String gender, String firstname, String lastname, String email, String password, String confirmpassword) throws Throwable 
    {
    	h.register(gender, firstname, lastname, email, password, confirmpassword);
    	Thread.sleep(5000);
    }

    @And("^click on continue$")
    public void click_on_continue() throws Throwable 
    {
    	h.contToHome();
    }
  
	@When("^click on logout$")
	public void click_on_logout() throws Throwable 
	{
	    h.logout();
	}
	
	@Then("^user is logged out$")
    public void user_is_logged_out() throws Throwable 
	{
	    System.out.println("user is logged out");
	}

    @When("^click on the login link$")
    public void click_on_the_login_link() throws Throwable 
    {
    	h.tologinPage();
    }

    @Then("^user is on login page$")
    public void user_is_on_login_page() throws Throwable 
    {
    	h.validate_login();
    }
    
    @When("^input (.+) and (.+)$")
    public void input_and(String userid, String pwd) throws Throwable 
    {
    	h.login(userid,pwd);
    }

    @And("^click on login$")
    public void click_on_login() throws Throwable 
    {
        h.clickLogin();
        Thread.sleep(2000);
    }
    
    //KAJAL
    Search s=new Search();
    
    @When("^enter book$")
    public void enter_book() throws Throwable 
    {
        s.search();
    }

    @And("^click search$")
    public void click_search() throws Throwable 
    {
  	   	s.click_search();
    }
   
    @Then("^user is on the search page$")
    public void user_is_on_the_search_page() throws Throwable 
    { 
       s.validateTitle();
    }
    
    @When("^hover on computers$")
    public void hover_on_computers() throws Throwable 
    {
      s.searchlink();
    }
   
    @And("^select desktops$")
    public void select_desktops() throws Throwable 
    {                   
    	//Thread.sleep(2000);
    	s.selectDesktop();
    	//driver.findElement(By.xpath("//a[@href='/desktops']")).click();
    }

    @Then("^user is on result page$")                                
    public void user_is_on_result_page() throws Throwable 
    {
  	  s.desktopspage();
    }

    @When("^click on sort by Name:Z to A$")
    public void click_on_sort_by_namez_to_a() throws Throwable 
    {
      s.sort();
    }

    @Then("^sorting is applied on products$")
    public void sorting_is_applied_on_products() throws Throwable 
    {
      System.out.println("Sorting is applied");   
    }
    
    @When("^click on display 4$")
    public void click_on_display_4() throws Throwable 
    {
      s.display();
    }
    
    @When("^click on under twenty five$")
    public void click_on_under_twenty_five() throws Throwable 
    {
      s.filter(); 
    }

    @Then("^filter is applied on products$")
    public void filter_is_applied_on_products() throws Throwable 
    {
       System.out.println("Filter is applied");
       Thread.sleep(2000);
       s.read();
    }
    
    @When("^click on add to cart button$")
    public void click_on_add_to_cart_button() throws Throwable 
    {
      s.addTocart();  
      Thread.sleep(1000);
    }

    @Then("^user is on shopping cart page$")
    public void user_is_on_shopping_cart_page() throws Throwable 
    {
  	  s.product();
    }
      
    //GUNJAN
    ShoppingCart ss = new ShoppingCart();
	
	@Given("^user is on the shopping cart$")
    public void user_is_on_the_shopping_cart() throws Throwable 
	{
		Thread.sleep(2000);
		ss.sCart1();
		System.out.println("Opening shopping cart");
    }

    @When("^enter estimate information$")
    public void enter_estimate_information() throws Throwable 
    {
    	ss.estimateInfo();
    }
    
    @And("^click on estimate button$")
    public void click_on_estimate_button() throws Throwable 
    {
    	ss.eButton();
    }

    @Then("^days required to delivery is diplayed$")
    public void days_required_to_delivery_is_diplayed() throws Throwable 
    {
    	ss.daysDisplay();
    }

    @When("^select checkbox2$")
    public void select_checkbox2() throws Throwable 
    {
    	Thread.sleep(2000);
        ss.checkbox2();
    }
    
    @And("^click on checkout$")
    public void click_on_checkout() throws Throwable 
    {
    	ss.checkoutButton();
    }

    @Then("^user is on checkout$")
    public void user_is_on_checkout() throws Throwable 
    {
       ss.checkoutpage();
    } 

    //SHIVPRIYA
    Checkout c=new Checkout();
    
    @Given("^user is on checkout page$")
    public void user_is_on_checkout_page() throws Throwable 
    {
    	System.out.println("User is on checkout page");
    }
    
    @When("^Select new adrress and enter details (.+) and (.+) and (.+) and (.+) and (.+)$")
    public void select_new_adrress_and_enter_details_and_and_and_and(String country, String city, String address1, String zipcode, String phonenumber) throws Throwable 
    {
    	c.addressDropdown();
		c.countryDropdown();
		c.billingAddress();  
    }
    
    @Then("^click on billingContinue$")
    public void click_on_billingcontinue() throws Throwable 
    {
		c.billingContinue();
    }

    @Given("^user is at shipping address$")
    public void user_is_at_shipping_address() throws Throwable 
    {
    	System.out.println("Select Shipping Address");
    }
    
    @When("^user select shipping address$")
    public void user_select_shipping_address() throws Throwable 
    {
		c.shippingDropdown();
    }
    
    @Then("^click on shipping continue$")
    public void click_on_shipping_continue() throws Throwable 
    {
		c.ShippingContinue();
    }

    @Given("^user is at shipping method$")
    public void user_is_at_shipping_method() throws Throwable 
    {
    	System.out.println("Select Shipping Method");
    }
    
    @When("^click on shipping radio button$")
    public void click_on_shipping_radio_button() throws Throwable 
    {
		c.shippingMethod();
    }
    
    @Then("^click on shipping method continue$")
    public void click_on_shipping_method_continue() throws Throwable 
    {
		c.shippingMethodContinue();
    }

    @Given("^user is at payment method$")
    public void user_is_at_payment_method() throws Throwable 
    {
    	System.out.println("Select Payment Address");
    }

    @When("^click on payment radio button$")
    public void click_on_payment_radio_button() throws Throwable 
    {
		c.paymentMethod();
    }
    
    @Then("^click on payment method continue$")
    public void click_on_payment_method_continue() throws Throwable 
    {
		c.paymentMethodContinue();
    }

    @Given("^user is at payment information$")
    public void user_is_at_payment_information() throws Throwable 
    {
    	System.out.println("Payment Information");
    }
    
    @Then("^click on payment information continue$")
    public void click_on_payment_information_continue() throws Throwable 
    {
		c.paymentInfoContinue();
    }

    @Given("^user is at confirm order$")
    public void user_is_at_confirm_order() throws Throwable 
    {
    	System.out.println("Confirm Order");
    }
    
    @Then("^click on confirm$")
    public void click_on_confirm() throws Throwable 
    {
		c.confirmContinue();
    }  
    
    //PRATHMESH
    Reorder r1 = new Reorder();
	
    @Given("^order successful$")
    public void order_successful() throws Throwable 
    {
        System.out.println("Order successful");
    }

    @When("^click on hyperlink of order details$")
    public void click_on_hyperlink_of_order_details() throws Throwable 
    {
       r1.hyperLink();
       Thread.sleep(2000);
    }

    @Then("^user is on order details page$")
    public void user_is_on_order_details_page() throws Throwable 
    {
        System.out.println("User is on order details page");
        Thread.sleep(2000);
    }  

    @When("^click on pdf invoice button$")
    public void click_on_pdf_invoice_button() throws Throwable 
    {
       r1.pdfInvoice();
       Thread.sleep(2000);
    }

    @Then("^order details pdf is downloaded in computer$")
    public void order_details_pdf_is_downloaded_in_computer() throws Throwable 
    {
        System.out.println("Pdf downloaded");
        Thread.sleep(2000);
    }
    
    @When("^click on print button$")
    public void click_on_print_button() throws Throwable 
    {
        r1.printButton();
        Thread.sleep(2000);
    }

    @Then("^new tab of order details page is displayed$")
    public void new_tab_of_order_details_page_is_displayed() throws Throwable
    {
       System.out.println("new tab opened");
       r1.cancelButton();
       Thread.sleep(2000);
    }

    @When("^click on reorder button$")
    public void click_on_reorder_button() throws Throwable 
    {
        r1.reorderButton();
        Thread.sleep(2000);
    }

    @Then("^user is on shopping cart$")
    public void user_is_on_shopping_cart() throws Throwable 
    {
        System.out.println("User is on shoppping cart page");
        Thread.sleep(2000);
    }

    @When("^enter changed quantity of product$")
    public void enter_changed_quantity_of_product() throws Throwable 
    {
       r1.enterQuantity();
       Thread.sleep(2000);
    }
    
    @And("^click on update shopping cart button$")
    public void click_on_update_shopping_cart_button() throws Throwable 
    {
        r1.updateShoppingCart();
        Thread.sleep(2000);
    }

    @Then("^new quantity of product is displayed and saved$")
    public void new_quantity_of_product_is_displayed_and_saved() throws Throwable 
    {
        System.out.println("quantity channged");
        Thread.sleep(2000);
    }

    @When("^click on continue shopping button$")
    public void click_on_continue_shopping_button() throws Throwable 
    {
        r1.continueShoppingButton();
        Thread.sleep(2000);
    }
    
    @Then("^user is on the result page$")
    public void user_is_on_the_result_page() throws Throwable 
    {
    	System.out.println("User is on result page");  
    	Thread.sleep(2000);
    }
    
    @Then("^user is on checkout completed page$")
    public void user_is_on_checkout_completed_page() throws Throwable 
    {
    	r1.checkoutCompletedUrl();
        System.out.println("user is on checkout completed page");
        Thread.sleep(2000);
    }  
    
    @When("^click on continue button$")
    public void click_on_continue_button() throws Throwable 
    {
        r1.continueButton();
        Thread.sleep(2000);
    }
    
    @Then("^user is on the the homepage$")
    public void user_is_on_the_the_homepage() throws Throwable 
    {
       System.out.println("User is on the home page");
       r1.homepage();
       Thread.sleep(1000);
    }
}


    


