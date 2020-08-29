package CRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

//Open the accounts page and print the contents of the table

public class activity8 {
	WebDriver driver;
	String username = "admin";
	String pwd  = "pa$$w0rd";

	  
	  @BeforeMethod
	  public void beforeMethod() throws InterruptedException {
		  
		  System.setProperty("webdriver.gecko.driver", "C:\\SDET Batch Training Stuff\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.get("http://alchemy.hguy.co/crm");
		  driver.manage().window().maximize();
		  Thread.sleep(3000);
		 //identifying user id
	      WebElement userid = driver.findElement(By.xpath("//input[@placeholder=\"Username\" and @id=\"user_name\"]"));
	      userid.sendKeys(username);

	      //identifying pwd
	      WebElement pswd = driver.findElement(By.xpath("//input[@type=\"password\" and @placeholder=\"Password\"]"));
	      pswd.sendKeys(pwd);

	      //identifying login button
	      WebElement login_btn = driver.findElement(By.xpath("//input[@title=\"Log In\"]"));
	      login_btn.click();
	      Thread.sleep(3000);
		
	  }
	  
	  @Test
	  public void act8() throws InterruptedException {
		  
		  Actions action = new Actions(driver);
		  
		  //finding sales webelement
	        WebElement sales = driver.findElement(By.xpath("//a[@id='grouptab_0']"));
	        action.moveToElement(sales).perform();

	        //clicking on Accounts
	        driver.findElement(By.xpath("//li[2]//span[2]//ul[1]//li[2]//a[1]")).click();
	        
	        Thread.sleep(3000);
	        
	        for (int i = 1; i <=10 ; i++) {
	        	
	        	if(i%2!=0)
				{
				String name = driver.findElement(By.xpath("//*[@id=\"MassUpdate\"]/div[3]/table/tbody/tr["+ i +"]/td[3]/b/a")).getText();
				System.out.println("Name is "+ name);
				
				}	
	        	
	        }
		   
	  }


  @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
  }

}
