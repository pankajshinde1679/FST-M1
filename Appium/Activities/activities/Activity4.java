package activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class Activity4 {

	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait = null;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pexel4Emulator");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.google.android.dialer");
		caps.setCapability("appActivity", ".extensions.GoogleDialtactsActivity");
		caps.setCapability("noReset", true);

		// Initialize Appium Driver
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);

		// Initialize WebDriverWait.
		wait = new WebDriverWait(driver,30);

	}

	@Test
	public void addContact() throws InterruptedException {

		// Wait for contacts to open.
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.TextView[@text='Contacts']")));

		// Click on Create new contact.
		driver.findElementByXPath("//android.widget.TextView[@text='Create new contact']").click();

		// Wait for Create new contact form to open. 
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.android.contacts:id/photo")));

		// Enter First Name.
		driver.findElementByXPath("//android.widget.EditText[@text='First name']").sendKeys("Aaditya");
		
		// Enter Last Name.
		driver.findElementByXPath("//android.widget.EditText[@text='Last name']").sendKeys("Varma");
		
		// Enter phone number.
		driver.findElementByXPath("//android.widget.EditText[@text='Phone']").sendKeys("999148292");
		
		// Click on Save button.
		driver.findElementById("com.android.contacts:id/editor_menu_save_button").click();
				
		// Wait for contact to load. 
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("com.android.contacts:id/photo")));
									
		// Get the saved name.
		String contactName = driver.findElementById("com.android.contacts:id/title_gradient").getText();		
		
		System.out.println("Contact Name : "+contactName);
		
		// Verify correct name is saved.
		Assert.assertEquals(contactName, "Aaditya Varma");


	}
}
