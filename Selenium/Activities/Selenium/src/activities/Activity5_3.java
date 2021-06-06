package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		
		driver.get("https://training-support.net/selenium/dynamic-controls");
		
		Thread.sleep(5000);
		
		// Print the title.
		System.out.println("The title is : "+driver.getTitle());

		// Verify check box is not selected.
		boolean textDisabled = driver.findElement(By.xpath("//div[@id='dynamicText']/input")).isEnabled();
		
		if(!textDisabled) 
		{
			System.out.println("Text box is disabled.");
		}
		
		// Click on the Enable Input button.
		driver.findElement(By.xpath("//button[@id='toggleInput']")).click();
		
		// Verify check box is selected.
		boolean textEnabled = driver.findElement(By.xpath("//button[@id='toggleInput']")).isEnabled();
				
		
		if(textEnabled)
		{
			System.out.println("Text box is enabled");
		}
		
		Thread.sleep(3000);
		
		driver.close();

	}

}
