package activities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11_4 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		//Open browser
		driver.get("https://www.training-support.net/selenium/tab-opener");

		//Print title of page and heading on page
		System.out.println("Page title is: " + driver.getTitle());

		// Get the parent window handle.
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window: " + parentWindow);

		// Click on the Click Me! button.
		driver.findElement(By.id("launcher")).click();

		// Wait for new tab to open.
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// Get widow handles.
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("All window handles: " + allWindowHandles);
		Iterator<String> i1=allWindowHandles.iterator();
		String newTab = null;
		while(i1.hasNext())
		{
			newTab = i1.next();
			
			if(!parentWindow.equalsIgnoreCase(newTab))
			{
				driver.switchTo().window(newTab);
				Thread.sleep(3000);
				
			}
		}

		// Get the title of new tab and print.
		System.out.println("The title of new tab is :" +driver.getTitle());
		
		// Get the Message and Print.
		String newTabMsg = driver.findElement(By.xpath("//div[@class='sub header']")).getText(); 
		
		System.out.println("Message on new tab is : "+newTabMsg);
		
		// CLick on the Open Another One! button.
		driver.findElement(By.id("actionButton")).click();

		// Wait until another tab opens.
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));

		allWindowHandles = driver.getWindowHandles();
		System.out.println("All window handles: " + allWindowHandles);
		Iterator<String> i2 = allWindowHandles.iterator();
		String newTabWindow=null;
		while(i2.hasNext())
		{
			newTabWindow = i2.next();
			
			if(!(parentWindow.equalsIgnoreCase(newTabWindow)&&(newTab.equalsIgnoreCase(newTabWindow))))
			{
				driver.switchTo().window(newTabWindow);
			}
		}

		//Print the handle of the current window
		System.out.println("New tab handle: " + driver.getWindowHandle());

		//Wait for the newest tab to load completely
		wait.until(ExpectedConditions.titleIs("Newtab2"));

		//Print New Tab Title
		System.out.println("New Tab Title is: " + driver.getTitle());

		// Get the Message and Print.
		String newTabText = driver.findElement(By.xpath("//div[@class='sub header']")).getText();        
		System.out.println("Message on new tab is : "+newTabText);

		// Close all the browsers.
		driver.quit();	
		
	}

}
