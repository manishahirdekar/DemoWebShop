package pages;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import base.Base;

public class Registration extends Base 
{
	By reg=By.xpath("//a[@class='ico-register']");
	By gfemale= By.id("gender-female");
	By gmale= By.id("gender-male");
	By FN=By.name("FirstName");
	By LN=By.name("LastName");
	By emailid=By.name("Email");
	By Pass=By.name("Password");
	By conPass=By.name("ConfirmPassword");
	By Register=By.name("register-button");
	By confirm=By.xpath("//div[@class='result']");
	By cont=By.xpath("//img[@alt='Tricentis Demo Web Shop']");
	By LogPage= By.xpath("//a[@class='ico-login']");
	By LEmail=By.name("Email");
	By LPass=By.id("Password");
	By login=By.xpath("//input[@value='Log in']");
	By Lout = By.xpath("//a[@class='ico-logout']");
	
	public void openUrl()
	{	
		
		driver.get("http://demowebshop.tricentis.com/");
		try 
		{
			Thread.sleep(1000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}	
	}
	
	public void linkToReg()
	{
		driver.findElement(reg).click();
	}
	
	public void register(String gen,String firstname,String lastname,String email,String password,String confirmpwd)
	{
		if(gen.matches("Male"))
			driver.findElement(gmale).click();
		else
			driver.findElement(gfemale).click();
		
		driver.findElement(FN).sendKeys(firstname);
		driver.findElement(LN).sendKeys(lastname);
		driver.findElement(emailid).sendKeys(email);
		driver.findElement(Pass).sendKeys(password);
		driver.findElement(conPass).sendKeys(confirmpwd);
		driver.findElement(Register).click();
		try 
		{
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validate_register() 
	{
		testlog = report.createTest("Validate register page");
		String title = driver.getTitle();
		if(title.contains("Register"))
		{
			System.out.println("User is on register page");
			testlog.log(Status.PASS, "User is on register page");
			takeSS("register.png");
		}
		else
		{
			System.out.println("User is not on register page");
			testlog.log(Status.FAIL, "User is not on register page");
			takeSS("register.png");
		}
	}
	
	public void validate_login() 
	{
		testlog = report.createTest("Validate login page");
		String title = driver.getTitle();
		if(title.contains("Login"))
		{
			System.out.println("User is on login page");
			testlog.log(Status.PASS, "User is on login pag");
			takeSS("login.png");
		}
		else
		{
			System.out.println("User is not on login pag");
			testlog.log(Status.FAIL, "User is not on login pag");
			takeSS("login.png");
		}
	}
	
	public void contToHome()
	{
		String title=driver.getTitle();
		System.out.println(title);
		try 
		{
			Thread.sleep(1000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		driver.findElement(cont).click();
	}
	
	public void logout()
	{
		driver.findElement(Lout).click();
	}
	
	public void tologinPage()
	{
		driver.findElement(LogPage).click();
	}
	
	public void login(String emailid,String Password)
	{
		driver.findElement(LEmail).sendKeys(emailid);
		driver.findElement(LPass).sendKeys(Password);
	}
	
	public void clickLogin()
	{
		driver.findElement(login).click();
	}	
}
