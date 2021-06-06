package projects;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginIntoTheWebsiteBackend {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");		
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}

	@Test
	public void login() {
		
		String userName = "root";
		// Enter user name.
		driver.findElement(By.id("user_login")).sendKeys(userName);
		
		// Enter password
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		
		// Click on the Log In button.
		driver.findElement(By.id("wp-submit")).click();
		
		// Get the user name.
		String actualUsername = driver.findElement(By.xpath("(//span[@class='display-name'])[1]")).getText();
		
		// Wait for user to login.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='display-name'])[1]")));
		
		// Verify that correct user has logged in.
		Assert.assertTrue(actualUsername.equalsIgnoreCase(userName),"Username is incorrect.");
	}
	
	
	@AfterMethod
	public void afterMethod() {
		// Close the browser.
		driver.close();
	}
}
