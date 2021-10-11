package pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.Status;
import base.Base;

public class Search extends Base 
{
	By search = By.id("small-searchterms");                                               
	By sbtn=By.xpath("//input[@class='button-1 search-box-button']");
	By slink=By.xpath("//a[@href='/computers']");                                         
	By link =By.xpath("//a[@href='/desktops']");
	By sort =By.id("products-orderby");                                                   
	By display =By.id("products-pagesize");                                               
	By filter =By.id("products-viewmode");                                                
	By addtocart1 =By.xpath("//input[@class='button-2 product-box-add-to-cart-button']"); 
	By clkSearch = By.xpath("//input[@class='button-1 search-box-button']");
	By addtocart2 =By.id("add-to-cart-button-72");                                        
	
	public void openurl()
	{
		driver.get("http://demowebshop.tricentis.com/");
	}
	
	public void search()
	{
		try 
    	{
   			Thread.sleep(1000);
   		} catch (InterruptedException e) {
   			e.printStackTrace();
   		}
		driver.findElement(search).sendKeys("book");
    }
	
	public void click_search() 
	{
		 driver.findElement(clkSearch).click();
	}
	
	public void validateTitle()
	{
		try 
		{
			Thread.sleep(1000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		testlog = report.createTest("Validate search page");
		String title = driver.getTitle();
		if(title.contains("Search"))
		{
			System.out.println("User is on search page");
			testlog.log(Status.PASS, "User is on search page");
			takeSS("search.png");
		}
		else
		{
			System.out.println("User is on search page");
			testlog.log(Status.FAIL, "User is on search page");
			takeSS("search.png");
		}	
	}
	
    public void searchlink() 
    {
	    WebElement w=driver.findElement(slink);
	    Actions a=new Actions(driver);
	    a.moveToElement(w).perform();
	    //driver.findElement(link).click(); 
    }    
       
    public void selectDesktop() 
    {
  	    driver.findElement(link).click(); 
    }
    
    public void desktopspage() 
	{
		testlog = report.createTest("Validate Desktops page");
		String title = driver.getTitle();
		if(title.contains("Desktops"))
		{
			System.out.println("User is on Desktops page");
			testlog.log(Status.PASS, "User is on Desktops page");
			takeSS("Desktops.png");
		}
		else
		{
			System.out.println("User is not on Desktops page");
			testlog.log(Status.FAIL, "User is not on Desktops page");
			takeSS("Desktops.png");
		}
	}
           
    public  void sort() 
    {
    	 Select s = new Select(driver.findElement(sort));
    	 s.selectByIndex(1);  
    }
      
    public void display()
    {
    	Select s = new Select(driver.findElement(display));
 	    s.selectByIndex(1); 
    } 
      
    public void filter()
    {
    	Select s = new Select(driver.findElement(filter));
	    s.selectByIndex(1); 
    }
    
    public void read() throws IOException
    {
    	FileInputStream fin=new FileInputStream("C:/Users/hp/Desktop/Demo.xlsx");	
		XSSFWorkbook wb =new XSSFWorkbook(fin);			
		XSSFSheet ws=wb.getSheet("Sheet1");
		Row row;
	
		try 
		{
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		List <WebElement> L1 = driver.findElements(By.xpath("//h2[@class='product-title']"));
		
		String str;
		for(int i=0;i<L1.size();i++)
		{
			//System.out.println(L1.get(i));
			row=ws.createRow(i);
			str = L1.get(i).getText();
			row.createCell(0).setCellValue(i+1);
			row.createCell(1).setCellValue(str);
		}
		
		FileOutputStream fout=new FileOutputStream("C:/Users/hp/Desktop/Demo.xlsx");
		wb.write(fout);
		wb.close();
    }
        
    public void addTocart()
    {
    	driver.findElement(addtocart1).click();           
    	driver.findElement(addtocart2).click();             
    	   try 
    	   {
			Thread.sleep(2000);
    	   }
			catch (InterruptedException e) 
    	   {
			e.printStackTrace();
    	   }
    }
    
    public void product() 
	{
		testlog = report.createTest("Validate product");
		String title = driver.getTitle();
		if(title.contains("cheap computer"))
		{
			System.out.println("product selected");
			testlog.log(Status.PASS, "product selected");
			takeSS("shoppingCart.png");
		}
		else
		{
			System.out.println("product not selected");
			testlog.log(Status.FAIL, "product not selecteds");
			takeSS("shoppingCart.png");
		}
	}
}