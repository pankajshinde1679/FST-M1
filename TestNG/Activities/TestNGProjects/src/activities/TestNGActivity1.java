package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestNGActivity1 {
	
	WebDriver driver;
	
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net");
  }
  
  @Test
  public void exampleTestCase() {
	  
	  System.out.println("Print first TestNG class");
	  
	  // Check the title of the page
	  String title = driver.getTitle();

	  //Print the title of the page
	  System.out.println("Page title is: " + title);

	  //Assertion for page title
	  Assert.assertEquals("Training Support", title);

	  //Find the clickable link on the page and click it
	  driver.findElement(By.id("about-link")).click();

	  //Print title of new page
	  System.out.println("New page title is: " + driver.getTitle());

	  Assert.assertEquals(driver.getTitle(), "About Training Support");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
