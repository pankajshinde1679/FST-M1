package project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GoogleTasks {


	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait = new WebDriverWait(driver,30);

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pexel4Emulator");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", ".ui.TaskListsActivity");
		caps.setCapability("noReset", true);

		// Initialize Appium Driver
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
	}

	@Test
	public void googleTasks() throws InterruptedException {
		// Create first task.
		Thread.sleep(10000);

		// Click on the new task.
		driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
		Thread.sleep(3000);
		
		// Add title.
		driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Tasks");
		Thread.sleep(3000);
		
		// Click on done button.
		driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();

		// Create Second task.
		driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
		Thread.sleep(3000);
		driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Keep");
		driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();

		// Create third task.
		driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
		Thread.sleep(3000);
		driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete the second Activity Google Keep");
		driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();

	}


	@AfterClass
	public void afterClass() {
		// Close the app.
		driver.quit();
	}

}
