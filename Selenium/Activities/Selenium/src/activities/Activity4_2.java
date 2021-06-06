package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		
		driver.get("https://www.training-support.net/selenium/simple-form");
		
		// Print the title.
		System.out.println("The title is : "+driver.getTitle());

		// Find first name and enter first name in it.
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Pankaj");

		// Find last name and enter last name in it.
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Shinde");

		// Find email and enter email id in it.		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@xyz.com");

		// Find contact number and enter phone number.
		driver.findElement(By.xpath("//input[@id='number']")).sendKeys("8587588580");
		
		//Enter Message
        driver.findElement(By.xpath("//textarea")).sendKeys("This is my message");

		// Click on the submit button.
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(5000);

		driver.close();
	}

}
