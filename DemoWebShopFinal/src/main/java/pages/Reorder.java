package pages;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
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
import com.aventstack.extentreports.Status;
import base.Base;

//reorder [Prathmesh Kshirsagar]
public class Reorder extends Base
{	
	By hLink = By.linkText("Click here for order details.");
	By cButton = By.xpath("//input[@class='button-2 order-completed-continue-button']");
	By pInvoice = By.xpath("//a[@class='button-2 pdf-order-button']");
	By pButton = By.xpath("//a[@class='button-2 print-order-button']");
	By rButton = By.xpath("//input[@class='button-1 re-order-button']");
	By eQuantity = By.xpath("//table[@class='cart']/tbody/tr/td[@class='qty nobr']/input");
	By eEmail = By.name("Email");
	By uCart = By.xpath("//input[@class='button-2 update-cart-button']");
	By cShopButton = By.xpath("//input[@class='button-2 continue-shopping-button']");
	By newPrint = By.xpath("//cr-button[@class='action-button']");
	By cancelButton = By.xpath("//cr-button[@class='cancel-button']");
	
	
	public void openurl()
	{
		driver.get("http://demowebshop.tricentis.com/");
	}
	
	public void checkoutCompletedUrl()
	{
		driver.get(prop.getProperty("url_1"));
	}
	
	public void hyperLink() 
	{
		driver.findElement(hLink).click();
	}
	
	public void orderDetails() 
	{
		System.out.println("User is on order details page");
	}
	
	public void continueButton() 
	{
		driver.findElement(cButton).click();	
	}
	
	public void homepage() 
	{
		testlog = report.createTest("Validate homepage");
		String title = driver.getTitle();
		if(title.contains("Demo Web Shop"))
		{
			System.out.println("User is on home page");
			testlog.log(Status.PASS, "User is on home page");
			takeSS("home.png");
		}
		else
		{
			System.out.println("User is not on home page");
			testlog.log(Status.FAIL, "User is not on home page");
			takeSS("home.png");
		}
		
	}	
	
	public void pdfInvoice()
	{
		driver.findElement(pInvoice).click();
	}
	
	public void printButton()
	{
		driver.findElement(pButton).click();
	}
	
	public void cancelButton()
	{
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			String str;
			ArrayList<String> lst = new ArrayList<String>(driver.getWindowHandles());
			System.out.println(lst.size());
			driver.switchTo().window(lst.get(1));
			str = driver.getCurrentUrl();
			System.out.println(str);
			if(str.contains("print"))
			{
				System.out.println("Invoice is printed");
				try 
				{
					Thread.sleep(1000);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
				driver.close();
			}
			driver.switchTo().window(lst.get(0));
	}
	
	public void reorderButton()
	{
		driver.findElement(By.xpath("//input[@class='button-1 re-order-button']")).click();
	}
	
	public void shoppingCart()
	{
		testlog = report.createTest("Validate shoppingcart page");
		String title = driver.getTitle();
		if(title.contains("Shopping Cart"))
		{
			System.out.println("Title contains Shopping Cart");
			testlog.log(Status.PASS, "Title contains Shopping Carte");
			takeSS("shoppingC.png");
		}
		else
		{
			System.out.println("Title does not contains Shopping Cart");
			testlog.log(Status.FAIL, "Title contains Shopping Carte");
			takeSS("shoppingC.png");
		}
	}
	
	public void enterQuantity()
	{
		driver.findElement(eQuantity).click();
		driver.findElement(eQuantity).clear();
		driver.findElement(eQuantity).sendKeys("5");
	}

	public void updateShoppingCart()
	{
		driver.findElement(uCart).click();
	}
	
	public void continueShoppingButton()
	{
		driver.findElement(cShopButton).click();
	}

	public void booksResultPage()
	{
		testlog = report.createTest("Validate books result page");
		String title = driver.getTitle();
		if(title.contains("Books"))
		{
			System.out.println("User is on books result page");
			testlog.log(Status.PASS, "User is on books result page");
			takeSS("Rpage.png");
		}
		else
		{
			System.out.println("User is not on books result page");
			testlog.log(Status.PASS, "User is not  on books result page");
			takeSS("Rpage.png");
		}
	}
}