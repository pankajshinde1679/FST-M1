package projects;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NavigateToAnotherPage {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/");

	}

	@Test
	public void navigateToPage() throws InterruptedException {
		
		// Get title of the home page.
		String homePageTitle = driver.getTitle();
		System.out.println("Home Page Title: "+homePageTitle );
		
		// Click on the Jobs link.
		driver.findElement(By.xpath("//a[contains(@href,'jobs/jobs')]")).click();
		
		Thread.sleep(3000);
		
		// Get next page title.
		String nextPageTitle = driver.getTitle();
		System.out.println("Jobs Page Title: "+nextPageTitle );
		
		// Verify user navigated to another page.
		Assert.assertNotSame(nextPageTitle, homePageTitle, "The titles are same.");
		
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser.
		driver.close();
	}

}
