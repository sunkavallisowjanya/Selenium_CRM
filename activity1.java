package CRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

//Getting the Title of CRM page

public class activity1 {
	
	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  
	  System.setProperty("webdriver.gecko.driver", "C:\\SDET Batch Training Stuff\\geckodriver-v0.27.0-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.get("http://alchemy.hguy.co/crm");
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
	
  }
  
  
  @Test
  public void act1() {
	  
	  String expectedtitle = "SuiteCRM";
	  String actualtitle = driver.getTitle();
	  Assert.assertEquals(actualtitle, expectedtitle);
	  System.out.println("Title name is matched  and title is :"+actualtitle);
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
  }

}
