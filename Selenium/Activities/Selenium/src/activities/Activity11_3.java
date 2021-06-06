package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_3 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	

		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		Thread.sleep(2000);

		String title = driver.getTitle();
		System.out.println("The title is : "+title);

		// Find Simple Alert button.
		WebElement prompt = driver.findElement(By.id("prompt"));

		// Click on Simple Alert button.
		prompt.click();

		Thread.sleep(3000);

		Alert alert = driver.switchTo().alert();
		
		// Click on the Ok button to close the window.
		alert.sendKeys("Yes, you are!");
		
		Thread.sleep(2000);
		
		// Click on OK button.
		alert.accept();
		
		driver.close();

	}

}
