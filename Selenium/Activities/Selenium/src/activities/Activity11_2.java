package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	

		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		Thread.sleep(2000);

		String title = driver.getTitle();
		System.out.println("The title is : "+title);

		// Find Simple Alert button.
		WebElement confirmation = driver.findElement(By.id("confirm"));
		
		// Click on Confirmation Alert button.
		confirmation.click();
		
		Thread.sleep(3000);
		
		Alert alertAccept = driver.switchTo().alert();
		
		// Get the text from the Alert box.
		String text = alertAccept.getText();
		
		// Print the text.
		System.out.println("The text on alert pop-up is : "+text);
		
		// Click on the Ok button to close the window.
		alertAccept.accept();
		
		// Click on Confirmation Alert button.
		confirmation.click();

		Thread.sleep(3000);

		Alert alertDismiss = driver.switchTo().alert();

		// Get the text from the Alert box.
		text = alertDismiss.getText();

		// Print the text.
		System.out.println("The text on alert pop-up is : "+text);

		// Click on the Ok button to close the window.
		alertDismiss.dismiss();

		Thread.sleep(3000);
		
		driver.close();

	}

}
