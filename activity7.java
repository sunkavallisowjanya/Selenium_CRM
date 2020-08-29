package CRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

//getting mobile number of lead record

public class activity7 {
  
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
  public void act7() throws InterruptedException {
	  
	  Actions action = new Actions(driver);
	  
	//finding sales webelement
      WebElement sales = driver.findElement(By.xpath("//a[@id='grouptab_0']"));
      action.moveToElement(sales).perform();

      //clicking on leads
      driver.findElement(By.xpath("//li[2]//span[2]//ul[1]//li[5]//a[1]")).click();
      Thread.sleep(5000);

      //finding info button
      driver.findElement(By.xpath("//span[@id='adspan_31b10edc-b542-96f2-b543-5f476d36bd6d']//span[@class='suitepicon suitepicon-action-info']")).click();
      Thread.sleep(5000);

      //Printing mobile number of Lead
      String mobilenum = driver.findElement(By.xpath("//span[@class='phone']")).getText();
      
      System.out.println("Mobile number of Lead:" + mobilenum);

  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
  }

}
