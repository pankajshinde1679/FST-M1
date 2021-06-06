package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		driver.get("https://training-support.net/selenium/dynamic-controls");
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		System.out.println("The title is : "+title);

		driver.findElement(By.xpath("//button[@id='toggleCheckbox']")).click();
		
		// Wait till element disappears
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='dynamicCheckbox']")));
		
		Thread.sleep(5000);
		
		driver.close();
		
	}

}
