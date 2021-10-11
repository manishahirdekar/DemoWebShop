package pages;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.Base;
import org.openqa.selenium.support.ui.Select;

public class Checkout extends Base
{
	By billaddr_id = By.name("billing_address_id");
	By country_id = By.name("BillingNewAddress.CountryId");
	By shopaddr_id = By.name("shipping_address_id");
	By city=By.name("BillingNewAddress.City");
	By address1=By.name("BillingNewAddress.Address1");
	By zipcode=By.name("BillingNewAddress.ZipPostalCode");
	By phone=By.name("BillingNewAddress.PhoneNumber");
	By bcontinue = By.xpath("//input[@onclick='Billing.save()']");
	By scontinue= By.xpath("//input[@onclick='Shipping.save()']");
	By smethod =By.xpath("//input[@value='Ground___Shipping.FixedRate']");
	By smcontinue = By.xpath("//input[@onclick='ShippingMethod.save()']");
	By pmethod = By.xpath("//input[@class='button-1 payment-method-next-step-button']");
	By pmcontinue = By.xpath("//input[@onclick='PaymentMethod.save()']");
	By picontinue = By.xpath("//input[@onclick='PaymentInfo.save()']");
	By ccontinue = By.xpath("//input[@class='button-1 confirm-order-next-step-button']");

	public void getUrl() 
	{
       driver.get(prop.getProperty("url"));
	   try 
	   {
		Thread.sleep(50000);
	} 
	   catch (InterruptedException e) 
	   {
		e.printStackTrace();
	}  
	}
	
	public void addressDropdown()
	{
		Select dropbill = new Select(driver.findElement(billaddr_id));
		dropbill.selectByVisibleText("New Address");
	}
	
	public void countryDropdown() 
	{
		Select dropbill = new Select(driver.findElement(country_id));
		dropbill.selectByVisibleText("India");
	}

    public void billingAddress()
    {
    	driver.findElement(city).sendKeys("City");
    	driver.findElement(address1).sendKeys("Address1");
    	driver.findElement(zipcode).sendKeys("ZipCode");
    	driver.findElement(phone).sendKeys("PhoneNumber");
    }
    
    public void  billingContinue() 
    {
		 driver.findElement(bcontinue).click();
	}
    
    public void shippingDropdown()
    {
		Select dropbill = new Select(driver.findElement(shopaddr_id));
		dropbill.selectByIndex(0);
	}
    
    public void  ShippingContinue()
    {
	 driver.findElement(scontinue).click();
    }
   
    public void shippingMethod()
    {
	 driver.findElement(smethod).click();
    }
   
    public void  shippingMethodContinue()
    {
	 driver.findElement(smcontinue).click();
	}
   
   public void paymentMethod() 
   {
	 driver.findElement(pmethod).click();
   }
   
   public void  paymentMethodContinue() 
   {
	 driver.findElement(pmcontinue).click();
   }
   
   public void  paymentInfoContinue()
   {
	 driver.findElement(picontinue).click();
   }
   
   public void  confirmContinue() 
   {
	 driver.findElement(ccontinue).click();
   }
}