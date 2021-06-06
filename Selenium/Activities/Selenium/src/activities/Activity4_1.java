package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		
		driver.get("https://www.training-support.net");

		Thread.sleep(2000);
		
		// Print the title.
		System.out.println("The title is : "+driver.getTitle());
		
		// Find About us link through xpath.
		WebElement aboutUs = driver.findElement(By.xpath("//a[@id='about-link']"));
		
		// Click on the About Us button.
		aboutUs.click();
		
		Thread.sleep(3000);
		
		// Print the new page title.
		System.out.println("The new title is : "+driver.getTitle());
		
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
