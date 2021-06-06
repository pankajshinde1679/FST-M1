package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		
		driver.get("https://training-support.net/selenium/dynamic-controls");
		
		// Print the title.
		System.out.println("The title is : "+driver.getTitle());

		// Verify check box is present.
		boolean checkboxPresent = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']")).isDisplayed();
		
		if(checkboxPresent) 
		{
			System.out.println("Checkbox is displayed.");
		}
		
		// Click on the Remove Check box button.
		driver.findElement(By.xpath("//button[@id='toggleCheckbox']")).click();
		
		// Verify check box is not present.
		//boolean checkboxRemoved = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']")).isDisplayed();
		
		if(!driver.findElement(By.xpath("//div[@id='dynamicCheckbox']")).isDisplayed())
		{
			System.out.println("Checkbox is removed.");
		}
		
		Thread.sleep(3000);
		
		driver.close();

	}

}
