package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestNGActivity6 {

	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		//Create a new instance of the Firefox driver		
		driver = new FirefoxDriver();

		wait = new WebDriverWait(driver, 10);
		//Open browser
		driver.get("https://www.training-support.net/selenium/login-form");		 
	}

	@Test
	@Parameters({"username","password"})
	public void loginForm(String username, String password) {
		//Find username and pasword fields
		WebElement usernameField = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));

		// Wait for the form to load.
		wait.until(ExpectedConditions.visibilityOf(usernameField));
		
		//Enter values
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);

		//Click Log in
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		//Assert Message
		String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
		Assert.assertEquals(loginMessage, "Welcome Back, admin");
	}

	@AfterClass
	public void afterClass() {
		// Close the browser
		driver.close();
	}

}
