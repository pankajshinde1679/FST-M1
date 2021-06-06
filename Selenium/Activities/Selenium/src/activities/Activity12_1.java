package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity12_1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();

		//Open browser
		driver.get("https://www.training-support.net/selenium/iframes");

		//Print title of page and heading on page
		System.out.println("Page title is: " + driver.getTitle());

		// Find total iFrames.
		int iframes = driver.findElements(By.tagName("iframe")).size();
		System.out.println("The total ifarme is :" +iframes);
		
		// Switch to first frame.
		driver.switchTo().frame(0);
		
		// Get the header of the first frame.
		String header1 = driver.findElement(By.xpath("//div[@class='content']")).getText().trim();
		System.out.println("The header on first Frame is :"+header1);
		
		WebElement button = driver.findElement(By.id("actionButton"));		
		System.out.println("The text on button of first Frame is :"+button.getText().trim());
		
		// Print button color.
		System.out.println("The button color is :"+button.getCssValue("background-color"));
		
		driver.findElement(By.id("actionButton")).click();
			
		// Print new button text.
		System.out.println("The changed text on button of first Frame is :"+button.getText().trim());	
		
		// Print button color.
		System.out.println("The button color is :"+button.getCssValue("background-color"));
		
		// Switch to parent window.
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
		// Switch to first frame.
		driver.switchTo().frame(1);

		// Get the header of the first frame.
		String header2 = driver.findElement(By.xpath("//div[@class='content']")).getText().trim();
		System.out.println("The header on second Frame is :"+header2);

		WebElement button2 = driver.findElement(By.id("actionButton"));		
		System.out.println("The text on button of second Frame is :"+button2.getText().trim());

		// Print button color.
		System.out.println("The button color is :"+button2.getCssValue("background-color"));

		button2.click();

		// Print new button text.
		System.out.println("The changed text on button of second Frame is :"+button2.getText().trim());	

		// Print new button color.
		System.out.println("The new button color is :"+button2.getCssValue("background-color"));
		
		//Switch back to parent page
        driver.switchTo().defaultContent();
 
        //Close browser
        driver.close();
			

	}

}
