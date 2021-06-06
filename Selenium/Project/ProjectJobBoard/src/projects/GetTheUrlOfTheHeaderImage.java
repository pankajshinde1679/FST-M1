package projects;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class GetTheUrlOfTheHeaderImage {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
	}

	@Test
	public void verifyUrl() {

		// Get the URL of the header image.
		String urlImage = driver.findElement(By.xpath("//img[contains(@src,'https://alchemy.hguy.co/jobs')]")).getAttribute("src");

		// Print on console.
		System.out.println("The URL of the image is : "+urlImage);
	}


	@AfterMethod
	public void afterMethod() {
		// Close the browser.
		driver.close();
	}

}
