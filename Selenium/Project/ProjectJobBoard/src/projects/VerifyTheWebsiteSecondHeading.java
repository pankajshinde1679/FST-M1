package projects;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class VerifyTheWebsiteSecondHeading {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/");

	}

	@Test
	public void verifySecondHeading() {
		String expectedHeading = "Quia quis non";
				
		// Actual second heading.
		String actualHeading = driver.findElement(By.xpath("//div[@class='entry-content clear']/h2")).getText();
		
		// Verify the heading.
		Assert.assertEquals(actualHeading, expectedHeading, "The Headings didn't matched");
		
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser.
		driver.close();
	}

}
