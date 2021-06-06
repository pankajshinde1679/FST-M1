package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		driver.get("https://training-support.net/selenium/ajax");
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		System.out.println("The title is : "+title);
		
		driver.findElement(By.xpath("//button[@class='ui violet button']")).click();
		
		WebElement hello = driver.findElement(By.xpath("//div[@id='ajax-content']/h1"));
		
		WebElement late = driver.findElement(By.xpath("//div[@id='ajax-content']/h3"));
		
		wait.until(ExpectedConditions.textToBePresentInElementValue(hello, "HELLO!"));
		
		String message = hello.getText();
		
		System.out.println("The message is : "+message);
		
		wait.until(ExpectedConditions.textToBePresentInElementValue(hello, "I'm late!"));
		
		String lateMessage = late.getText();
		
		System.out.println("The message is : "+lateMessage);
		
		Thread.sleep(5000);
		
		driver.close();
	}

}
