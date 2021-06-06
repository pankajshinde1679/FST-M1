package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	

		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		Thread.sleep(2000);

		String title = driver.getTitle();
		System.out.println("The title is : "+title);

		// Find Simple Alert button.
		WebElement simple = driver.findElement(By.id("simple"));
		
		// Click on Simple Alert button.
		simple.click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		
		// Get the text from the Alert box.
		String text = alert.getText();
		
		// Print the text.
		System.out.println("The text on alert pop-up is : "+text);
		
		// Click on the Ok button to close the window.
		alert.accept();
		
		Thread.sleep(3000);
		
		driver.close();


	}

}
