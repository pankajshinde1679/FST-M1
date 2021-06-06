package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		
		driver.get("https://www.training-support.net/selenium/simple-form");

		Thread.sleep(2000);
		
		// Print the title.
		System.out.println("The title is : "+driver.getTitle());
		
		// Find first name and enter first name in it.
		driver.findElement(By.id("firstName")).sendKeys("Pankaj");
		
		// Find last name and enter last name in it.
		driver.findElement(By.id("lastName")).sendKeys("Shinde");
		
		// Find email and enter email id in it.		
		driver.findElement(By.id("email")).sendKeys("abc@xyz.com");
		
		// Find contact number and enter phone number.
		driver.findElement(By.id("number")).sendKeys("8587588583");
		
		// Click on the submit button.
		driver.findElement(By.cssSelector(".ui.green.button")).click();		
		
		Thread.sleep(5000);
		
		// Print the new page title.
		System.out.println("The new page title is : "+driver.getTitle());
		
		driver.close();
	}

}
