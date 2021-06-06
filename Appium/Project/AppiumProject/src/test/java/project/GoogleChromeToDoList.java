package project;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class GoogleChromeToDoList {

	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait = null;
	JavascriptExecutor js = null;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pexel4Emulator");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);

		// Initialize Appium Driver
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);

		// Initialize WebDriverWait.
		wait = new WebDriverWait(driver,30);
		
		// Initialize JavascriptExecutor
		//js = (JavascriptExecutor) driver;

		// Open the URL in the Chrome browser.
		driver.get("https://www.training-support.net/selenium");	
	}

	@Test
	public void toDoList() throws InterruptedException {

		// Wait for Search text box to display
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.Button")));
		
		// Click on Get Started! 
		driver.findElementByXPath("//android.widget.Button[contains(@text,'Get Started')]").click();
		
		Thread.sleep(4000);
				
		MobileElement ele = driver.findElementByXPath("//android.view.View[contains(@text,'To-Do List')]");
		
		//js.executeScript("arguments[0].scrollIntoView();", ele);
		
		Thread.sleep(3000);

		//driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollIntoView(text(\"To-Do List\"))")).click();
		
		// Scroll down to To Do list.
		MobileElement toList = driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).getChildByText(UiSelector().className(\"android.view.View\"), \"To-Do List\")"));

		// Click on the To-Do List.
		toList.click();

		// Wait for Search text box to display
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.Button[@text='To-Do List']")));
		
		// Create an array of three tasks
		String[] tasks = {"Add tasks to list","Get number of tasks","Clear the list"};
		
		for(int i=0;i<=tasks.length;i++)
		{
			// Below code enters three tasks.
			driver.findElementById("taskInput").sendKeys(tasks[i]);
			
			// Click on Add Task button.
			driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
			
			// Wait for three seconds.
			Thread.sleep(3000);
		}
		
		// Find the count of the tasks added. 
		List<MobileElement> list = driver.findElementsById("tasksList");
		int size = list.size();
		
		System.out.println("The count of tasks are : " +size);
		
		// Strike through the tasks.
		for(int j=1;j<=size;j++)
		{
			driver.findElementByXPath("//android.view.View[@id='tasksList']//android.view.View["+j+"]").click();
		}
		
		// Clear the list.
		driver.findElementByXPath("//android.view.View[@text='Clear List']").click();
		
		// Verify that there are no task list.		
		Assert.assertTrue(!(driver.findElementByXPath("(//android.view.View[@id='tasksList']//android.view.View)[1]").isDisplayed()));
	}

	@AfterClass
	public void afterClass() {
		// Close the browser.
		driver.quit();
	}

}
