package activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

public class Activity3 {
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
	public void calculate() {

		int expectedAdd = 14;
		int expectedSubtract = 5;
		int expectedMultiply = 500;
		int expectedDivide = 25;

		/*
		 * Calculate Addition
		 */
		// Click on digit 5.
		driver.findElementById("digit_5").click();

		// Click on plus.
		driver.findElementByXPath("//android.widget.Button[@content-desc='plus']").click();

		// Click on digit 9;
		driver.findElementById("digit_9").click();

		// Click on Equal symbol.
		driver.findElementByXPath("//android.widget.Button[@content-desc='equals']").click();

		// Get the result.
		String addResult = driver.findElementById("com.android.calculator2:id/result").getText();

		/*
		 * Calculate Subtraction
		 */

		// Click on digit 10.
		driver.findElementById("digit_1").click();
		driver.findElementById("digit_0").click();

		// Click on minus.
		driver.findElementByXPath("//android.widget.Button[@content-desc='minus']").click();

		// Click on digit 5;
		driver.findElementById("digit_5").click();

		// Click on Equal symbol.
		driver.findElementByXPath("//android.widget.Button[@content-desc='equals']").click();

		// Get the result.
		String minusResult = driver.findElementById("com.android.calculator2:id/result").getText();

		/*
		 * Calculate Multiplication
		 */

		// Click on digit 5.
		driver.findElementById("digit_5").click();

		// Click on minus.
		driver.findElementByXPath("//android.widget.Button[@content-desc='multiply']").click();

		// Click on 100;
		driver.findElementById("digit_1").click();
		driver.findElementById("digit_0").click();
		driver.findElementById("digit_0").click();

		// Click on Equal symbol.
		driver.findElementByXPath("//android.widget.Button[@content-desc='equals']").click();

		// Get the result.
		String mulResult = driver.findElementById("com.android.calculator2:id/result").getText();


		/*
		 * Calculate Division
		 */
		// Click on digit 5 and then 0.
		driver.findElementById("digit_5").click();
		driver.findElementById("digit_0").click();

		// Click on minus.
		driver.findElementByXPath("//android.widget.Button[@content-desc='divide']").click();

		// Click on 2;
		driver.findElementById("digit_2").click();		

		// Click on Equal symbol.
		driver.findElementByXPath("//android.widget.Button[@content-desc='equals']").click();

		// Get the result.
		String divideResult = driver.findElementById("com.android.calculator2:id/result").getText();
		
		// Convert all strings to integers.		
		int actualAdd = Integer.parseInt(addResult);
		int actualSubtract = Integer.parseInt(minusResult);
		int actualMultiply = Integer.parseInt(mulResult);
		int actualDivide = Integer.parseInt(divideResult);
		
		// Verify the results.
		Assert.assertEquals(expectedAdd, actualAdd);
		Assert.assertEquals(expectedSubtract, actualSubtract);
		Assert.assertEquals(expectedMultiply, actualMultiply);
		Assert.assertEquals(expectedDivide, actualDivide);
		

	}

	@AfterClass
	public void afterClass() {
		// Close the app.
		driver.quit();
	}
}
