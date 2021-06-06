package projects;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebElement;

public class CreateANewJobListing {

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
	public void createNewJob() {
		
		// Generate a random number to append to email id to avoid duplication.
		Random rNumber = new Random();
		int number = rNumber.nextInt();
		System.out.println("The random number is: "+number);
		
		// Click the menu item that says “Post a Job”.
		driver.findElement(By.xpath("//a[contains(@href,'post-a-job')]")).click();
		
		// Wait for an element to display.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='field account-sign-in']")));
		
		// Enter email id.
		driver.findElement(By.id("create_account_email")).sendKeys("chef"+number+"@gmail.com");
		
		String jobTitle = "Master Chef";
		
		// Enter job title.
		driver.findElement(By.id("job_title")).sendKeys(jobTitle);
		
		// Enter job location.
		driver.findElement(By.id("job_location")).sendKeys("India");
		
		// Select Job type as Part time.
		Select jobType = new Select(driver.findElement(By.id("job_type")));
		jobType.selectByVisibleText("Part Time");		
	
		// Find total iFrames.
		int iframes = driver.findElements(By.tagName("iframe")).size();
		System.out.println("The total iframes are :" +iframes);
		
		// Switch to first frame.
		driver.switchTo().frame("job_description_ifr");
		
		// Job description.
		String jobDesc = "Specialized in Continental, Multi-cuisine, Chinese, Italian , Indian etc.";
		
		// Enter Job Description. 
		driver.findElement(By.xpath("//body[@id='tinymce']")).click();
		driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys(jobDesc);
		
		// Switch to default website.
		driver.switchTo().defaultContent();
		
		// Enter Application email/URL
		driver.findElement(By.id("application")).sendKeys("http://www.google.com");
		
		// Enter Company Name
		driver.findElement(By.id("company_name")).sendKeys("IBM");
		
		// Enter Website.
		driver.findElement(By.id("company_website")).sendKeys("http://w3.ibm.com");
		
		// Enter tagline.
		driver.findElement(By.id("company_tagline")).sendKeys("IBM Blue");
		
		// Enter video link.
		driver.findElement(By.id("company_video")).sendKeys("https://w3.ibm.com/video");
		
		// Enter twitter username
		driver.findElement(By.id("company_twitter")).sendKeys("@pakajshinde");
		
		// Click on the Preview button.
		driver.findElement(By.name("submit_job")).click();
		
		// Wait for an element to display.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='job_preview_submit_button']")));
		
		// Click on Submit Listing.
		driver.findElement(By.xpath("//input[@id='job_preview_submit_button']")).click();
		
		// Expected string job posted successfully.
		String expectedJobPosted = "Job listed successfully";
		
		// Actual string for job posted successfully.
		String actualJobPosted = driver.findElement(By.xpath("//div[@class='entry-content clear']")).getText();
		
		// Verify that job posted successfully.
		Assert.assertTrue(actualJobPosted.contains(expectedJobPosted), "Job is not posted successfully.");
		
		// Go to Jobs page.
		driver.findElement(By.xpath("//a[contains(@href,'jobs/jobs/')]")).click();
		
		// Wait for Search Jobs button to display.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='search_submit']")));
		
		// Enter the job title.
		driver.findElement(By.id("search_keywords")).sendKeys(jobTitle);
		
		// Click on the Search Jobs button.
		driver.findElement(By.xpath("//div[@class='search_submit']")).click();
		
		// Wait for the table to appear.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='position']/h3")));
		
		// Create an Array List.
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='position']/h3"));
		
		int size = list.size();
		int i=1;
		for(;i<=size;i++)
		{
			String title = driver.findElement(By.xpath("(//div[@class='position']/h3)["+i+"]")).getText().trim();
			if(title.equalsIgnoreCase(jobTitle))
			{
				System.out.println("Yes! Job is listed.");
				break;
			}
			
		}
		if(i==11)
		{
			System.out.println("No! Job is not listed.");
		}
		
		
	}
		

	@AfterMethod
	public void afterMethod() {
		// Close the browser.
		driver.close();
	}


}
