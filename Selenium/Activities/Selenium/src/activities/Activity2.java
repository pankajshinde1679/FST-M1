package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		
		driver.get("https://www.training-support.net");

		Thread.sleep(2000);
		
		// Print the title.
		System.out.println("The title is : "+driver.getTitle());
		
		// Find element with id.
		WebElement withId = driver.findElement(By.id("about-link"));
		System.out.println("The Id prints : "+withId.getText());
		
		// Find element with Class.
		WebElement withClassName = driver.findElement(By.className("green"));
		System.out.println("The class name prints : "+withClassName.getText());

		// Find element with Link Text.
		WebElement withLinkText = driver.findElement(By.linkText("About Us"));
		System.out.println("The Link Text prints : "+withLinkText.getText());
		
		// Find element with CSS Selector Text.
		WebElement withCss = driver.findElement(By.cssSelector("a#about-link"));
		System.out.println("The CSS Selector prints : "+withCss.getText());
			
		driver.close();
		
		
	}

}
