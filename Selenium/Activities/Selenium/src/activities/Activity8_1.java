package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity8_1 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		driver.get("https://training-support.net/selenium/tables");
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		System.out.println("The title is : "+title);
		
		// Find the table rows.
		List<WebElement> listRows = driver.findElements(By.xpath("//table[@class='ui celled striped table']//tbody/tr"));
		
		// Print number of rows.
		System.out.println("The rows are : "+listRows.size());
		
		// Find the table columns.
		List<WebElement> listColumns = driver.findElements(By.xpath("//table[@class='ui celled striped table']//tbody/tr[1]/td"));
		
		// Print number of columns.
		System.out.println("The columns are : "+listColumns.size());
		
		// Get the third row.		
		List<WebElement> thirdRow = driver.findElements(By.xpath("//table[@class='ui celled striped table']//tbody/tr[3]/td"));
		
		for(WebElement web : thirdRow)
		{
			System.out.println("The Third row contains: "+web.getText());
		}
		
		// Get the second row, second column.		
		WebElement secRowSecCol = driver.findElement(By.xpath("//table[@class='ui celled striped table']//tbody/tr[2]/td[2]"));
		
		// Print cell value.
		System.out.println("The Third row contains: "+secRowSecCol.getText());
		
		driver.close();
				
	}

}
