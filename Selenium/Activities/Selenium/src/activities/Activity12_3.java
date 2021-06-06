package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity12_3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		
		driver.get("https://www.training-support.net/selenium/popups");
		Thread.sleep(2000);
		
		System.out.println("The title is : "+driver.getTitle());
		
		Actions action = new Actions(driver);
		
		WebElement signIn = driver.findElement(By.xpath("//button[contains(@class,'orange button')]"));
		
		action.moveToElement(signIn).pause(Duration.ofSeconds(3)).build().perform();
		
		String tooltip = signIn.getAttribute("data-tooltip");
		
		System.out.println("The tool tip is :" +tooltip);
	
		signIn.click();
		
		driver.findElement(By.id("username")).sendKeys("admin");
		
		driver.findElement(By.id("password")).sendKeys("password");
		
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		Thread.sleep(3000);
	
		driver.close();
	}

}
