package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	

		driver.get("https://www.training-support.net/selenium/input-events");
		Thread.sleep(2000);

		String title = driver.getTitle();
		System.out.println("The title is : "+title);
		
		Actions actions = new Actions(driver);
		
		WebElement keyPressed = driver.findElement(By.id("keyPressed"));
		
		// Press the key of your first name in caps
		Action sequenceFirst = actions.sendKeys("P").build();
		sequenceFirst.perform();
		String keyPressedText = keyPressed.getText();
		
		System.out.println("The key pressed is : "+keyPressedText);
		
		//Press CTRL+a and the CTRL+c to copy all the text on the page.
		Action sequenceSec = actions.keyDown(Keys.CONTROL)
				.sendKeys("a")
				.sendKeys("c")
				.keyUp(Keys.CONTROL)
				.build();
		sequenceSec.perform();
		
		keyPressedText = keyPressed.getText();
		
		System.out.println("The second key pressed is : "+keyPressedText);		
				
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
