package CRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

//getting color of navigation bar

public class activity5 {
  
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
  public void act5() {
	  
	//identifying nav color xpath
      WebElement nav = driver.findElement(By.xpath("//div[@class=\"desktop-toolbar\" and  @id=\"toolbar\"]"));

      //getting color value
      System.out.println("Colour of navigation bar:" + nav.getCssValue("color"));
  }

  

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
