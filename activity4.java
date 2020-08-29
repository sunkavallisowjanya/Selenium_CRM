package CRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

//Login to CRM and verfiy the home page
public class activity4 {
  
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
		
	  }
  
  
  @Test
  public void act4() throws InterruptedException {
	  
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

      //verifying for ALL text is present on Navigation bar
      boolean vryel = driver.findElement(By.xpath("//a[@id=\"grouptab_5\" and @href=\"#\" ]")).isDisplayed();

      //printing result based on boolean condition.
      if (vryel) {
          System.out.println("Home page loaded successfully");
          
      } else {
          System.out.println("Home page not loaded successfully.");
      }

      Thread.sleep(5000);
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
  }

}
