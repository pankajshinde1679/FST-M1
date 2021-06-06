package projects;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class ApplyToAJob {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");		
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://alchemy.hguy.co/jobs/");

		
	}

	@Test
	public void applyForJob() throws InterruptedException {
		
		// Click on the Jobs link.
		driver.findElement(By.xpath("//a[contains(@href,'jobs/jobs/')]")).click();
		
		// Enter Banking as the search term.
		driver.findElement(By.id("search_keywords")).sendKeys("Banking");

		// Click on the Search Jobs button.
		driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
		
		// Wait for table to appear.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='job_listings']")));
		
		// Click on any one of the job listed.
		driver.findElement(By.xpath("//ul[@class='job_listings']/li[1]/a")).click();
		
		// Wait for Apply Job button to display.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='application_button button']")));
		
		// Click on Apply Job button.
		driver.findElement(By.xpath("//input[@class='application_button button']")).click();
						
		// Get the email.
		String emailId = driver.findElement(By.xpath("//a[@class='job_application_email']")).getText();
		
		System.out.println("The email id is : "+emailId);
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser.
		driver.close();
	}

}
