package projects;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class VerifyTheWebsiteTitle {

	WebDriver driver; 

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
	}

	@Test
	public void verifyWebSiteTitle() {

		// Get the title of the website.
		String actualTitle = driver.getTitle();		

		String expectedTitle = "Alchemy Jobs – Job Board Application";

		// Make sure it matches “Alchemy Jobs – Job Board Application” exactly
		Assert.assertEquals(actualTitle, expectedTitle, "The title didn't matched.");

	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser.
		driver.close();
	}

}
