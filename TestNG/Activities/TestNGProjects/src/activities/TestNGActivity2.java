package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class TestNGActivity2 {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		//Open the browser
        driver.get("https://www.training-support.net/selenium/target-practice");

	}

	@Test
	public void testCase1() {
		//This test case will pass
		String title = driver.getTitle();
		System.out.println("Title is: " + title);
		Assert.assertEquals(title, "Target Practice");
	}

	@Test
	public void testCase2() {
		//This test case will Fail
		WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
		Assert.assertTrue(blackButton.isDisplayed());
		Assert.assertEquals(blackButton.getText(), "black");
	}

	@Test
	public void testCase3() {
		//This test will be skipped and not counted
		String subHeading = driver.findElement(By.className("sub")).getText();
		Assert.assertTrue(subHeading.contains("Practice"));
	}

	@Test
	public void testCase4() {
		//This test will be skipped and will be be shown as skipped
		throw new SkipException("Skipping test case");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
