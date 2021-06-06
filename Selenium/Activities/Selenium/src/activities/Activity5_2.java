package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		
		driver.get("https://training-support.net/selenium/dynamic-controls");
		
		Thread.sleep(5000);
		
		// Print the title.
		System.out.println("The title is : "+driver.getTitle());

		// Verify check box is not selected.
		boolean checkboxNotSelected = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input")).isSelected();
		
		if(!checkboxNotSelected) 
		{
			System.out.println("Checkbox is not selected.");
		}
		
		// Click on the check box button.
		driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input")).click();
		
		// Verify check box is selected.
		boolean checkboxSelected = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input")).isSelected();
				
		
		if(checkboxSelected)
		{
			System.out.println("Checkbox is selected.");
		}
		
		Thread.sleep(3000);
		
		driver.close();

	}
}
