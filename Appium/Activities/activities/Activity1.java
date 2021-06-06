package activities;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Activity1 {

	// Instantiate Appium Driver
	AppiumDriver<MobileElement> driver = null;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pexel4Emulator");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.android.calculator2");
		caps.setCapability("appActivity", ".Calculator");
		caps.setCapability("noReset", true);
		
		// Initialize the driver.
		 driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}

	@Test
	public void calc() {
		System.out.println("Hurray! The calculator opened.");
	}

	@AfterClass
	public void afterClass() {
	}

}
