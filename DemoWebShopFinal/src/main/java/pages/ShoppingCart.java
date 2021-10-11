package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.Status;
import base.Base;

public class ShoppingCart extends Base
{
	By scart1 = By.xpath("//a[@class='ico-cart']");	
	By country = By.id("CountryId");
	By state = By.id("StateProvinceId");
	By zipcode  = By.id("ZipPostalCode");
	By ebutton = By.name("estimateshipping");
	By cb2 = By.id("termsofservice");
	By cOut = By.name("checkout");
	
	public void sCart1() 
	{
		try 
		{
			Thread.sleep(1000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		driver.findElement(scart1).click();
	}
	
	public void estimateInfo() 
	{
		try 
		{
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		new Select(driver.findElement(country)).selectByVisibleText("India");
    	Select s1=new Select(driver.findElement(state));
    	s1.selectByIndex(0);
    	driver.findElement(zipcode).sendKeys("415110");
	}
	
	public void eButton() 
	{
		driver.findElement(ebutton).click();	
	}
	
	public void daysDisplay() 
	{
		System.out.println("Days required to delivery is diplayed");
	}
	
	public void checkbox2() 
	{
		driver.findElement(cb2).click();
	}
	
	public void checkoutButton() 
	{
		driver.findElement(cOut).click();
	}
	
	public void checkoutpage() 
	{
		testlog = report.createTest("Validate checkout page");
		String title = driver.getTitle();
		if(title.contains("Checkout"))
		{
			System.out.println("User is on checkout page");
			testlog.log(Status.PASS, "User is on checkout page");
			takeSS("checkout.png");
		}
		else
		{
			System.out.println("User is not on checkout page");
			testlog.log(Status.FAIL, "User is not on checkout page");
			takeSS("checkout.png");
		}	
	}
}