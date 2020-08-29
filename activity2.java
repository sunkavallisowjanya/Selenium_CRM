package CRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;


//Getting Heade image URL

public class activity2 {
  
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
  public void act2() {
	  
	//getting img url
      String img = driver.findElement(By.xpath("//img[@alt=\"SuiteCRM\"]")).getAttribute("src");

      //printing URl
      System.out.print(img);
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
  }

}
