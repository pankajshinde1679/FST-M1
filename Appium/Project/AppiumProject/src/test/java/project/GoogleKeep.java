package project;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GoogleKeep {

	AppiumDriver<MobileElement> driver = null;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pexel4Emulator");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");
		caps.setCapability("noReset", true);

		// Initialize Appium Driver
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
	}

	@Test
	public void googleKeep() throws InterruptedException {
		Thread.sleep(10000);
		// Click on plus icon.
		driver.findElementById("com.google.android.keep:id/new_note_button").click();
		Thread.sleep(3000);

		String createNote = "Create Note";
		// Enter title.
		driver.findElementById("com.google.android.keep:id/editable_title").sendKeys(createNote);
		Thread.sleep(3000);

		// Enter description.
		driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("As part of appium project create a note");
		Thread.sleep(3000);

		// Navigate back.
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Navigate up']").click();
		Thread.sleep(3000);

		// Verify the Note is created successfully.
		String title = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
		System.out.println("The title is : "+title);
		Assert.assertEquals(title,createNote);
	}

	@AfterClass
	public void afterClass() {
		// Close the application.
		driver.quit();
	}

}
