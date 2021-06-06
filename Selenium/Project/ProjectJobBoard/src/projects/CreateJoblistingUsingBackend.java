package projects;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class CreateJoblistingUsingBackend {

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
	public void createJobUsingBackend() {

		String userName = "root";
		// Enter user name.
		driver.findElement(By.id("user_login")).sendKeys(userName);

		// Enter password
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");

		// Click on the Log In button.
		driver.findElement(By.id("wp-submit")).click();

		// Wait for user to login.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='display-name'])[1]")));
		
		Actions action = new Actions(driver);
		
		WebElement jobListing = driver.findElement(By.xpath("//a[@href='edit.php?post_type=job_listing']/div[3]"));
		
		// Click on the Job Listings
		action.moveToElement(jobListing).click().build().perform();
		
		// wait for an element 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='post-search-input']")));
		
		// Click on Add New button.
		driver.findElement(By.xpath("//div[@class='wrap']/a")).click();
		
		// Job titlw.
		String jobTitle = "Video Jokey";
		
		// Enter Position.
		driver.findElement(By.xpath("//textarea[@id='post-title-0']")).sendKeys(jobTitle);
		
		// Enter Company website.
		driver.findElement(By.name("_company_website")).sendKeys("https://w3.ibm.com");
		
		// Enter Company twitter.
		driver.findElement(By.name("_company_twitter")).sendKeys("@IBM");
		
		// Enter Location.
		driver.findElement(By.name("_job_location")).sendKeys("Pune");
		
		// Enter Company name.
		driver.findElement(By.name("_company_name")).sendKeys("IBM");
		
		// Enter Company Tagline.
		driver.findElement(By.name("_company_tagline")).sendKeys("IBM Blue");
		
		// Enter Company Video.
		driver.findElement(By.name("_company_video")).sendKeys("https://www.ibm.com/video");
		
		// Click on Publish button.
		driver.findElement(By.xpath("//button[contains(@class,'publish-panel__toggle editor')]")).click();
		
		// Click on Publish button again.
		driver.findElement(By.xpath("//button[@class='components-button editor-post-publish-panel__toggle editor-post-publish-button__button is-primary']"));
						
		// Click on word press icon.
		driver.findElement(By.xpath("//button[contains(@class,'components-button editor-post-publish-button editor-post-publish-button__button is-primary')]")).click();
		
		// Click on word press icon.
		driver.findElement(By.xpath("//a[@class='components-button edit-post-fullscreen-mode-close has-icon']")).click();
		
		// wait for an element 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='job_position']/a)[1]")));
		
		// Get the job title from the list
		String actualJobTitle = driver.findElement(By.xpath("(//div[@class='job_position']/a)[1]")).getText();
		
		// Verify the job created.
		Assert.assertEquals(actualJobTitle, jobTitle, "The Jobs didn't matched.");
	}


	@AfterMethod
	public void afterMethod() {
		// Close the browser.
		driver.close();
	}

}
