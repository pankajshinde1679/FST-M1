package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12_2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();

		//Open browser
		driver.get("https://www.training-support.net/selenium/nested-iframes");

		//Print title of page and heading on page
		System.out.println("Page title is: " + driver.getTitle());

		// Find total iFrames.
		int iframes = driver.findElements(By.tagName("iframe")).size();
		System.out.println("The total ifarme is :" +iframes);
		
		// Switch to parent frame.
		driver.switchTo().frame(0);
		
		int iframesInside = driver.findElements(By.tagName("iframe")).size();
		System.out.println("The total ifarme in nested frames are :" +iframesInside);
		
		// Switch to frame first.
		driver.switchTo().frame(0);
		
		WebElement header1 = driver.findElement(By.xpath("//div[@class='content']"));
		
		System.out.println("The header of first frame is : "+header1.getText().trim());
		
		Thread.sleep(3000);
				
		// Switch to default page.
		driver.switchTo().defaultContent();
		
		// Switch to Parent frame again.
		driver.switchTo().frame(0);
		
		Thread.sleep(3000);
		
		// Switch to second frame.
		driver.switchTo().frame(1);
		
		WebElement header2 = driver.findElement(By.xpath("//div[@class='content']"));
		
		System.out.println("The header of secod frame is : "+header2.getText().trim());

		// Switch back to parent frame.
		driver.switchTo().parentFrame();

		// Switch to default page.
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
