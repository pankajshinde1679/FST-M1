package projects;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class VerifyTheWebsiteHeading {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
	}

	@Test
	public void verifyWebSiteHeading() {

		// Expected heading.
		String expectedHeading = "Welcome to Alchemy Jobs";

		// Get the heading of the page.
		String actualHeading = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();

		// Verify actual and expected heading.
		Assert.assertEquals(actualHeading, expectedHeading, "The Headings didn't matched");


	}
	@AfterMethod
	public void afterMethod() {
		// Close the browser.
		driver.close();
	}

}
