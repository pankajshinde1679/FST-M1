package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity8_2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	

		WebDriverWait wait = new WebDriverWait(driver,20);

		driver.get("https://training-support.net/selenium/tables");
		Thread.sleep(2000);

		String title = driver.getTitle();
		System.out.println("The title is : "+title);

		// Find the table rows.
		List<WebElement> listRows = driver.findElements(By.xpath("//table[@id='sortableTable']//tbody/tr"));

		// Print number of rows.
		System.out.println("The rows are : "+listRows.size());

		// Find the table columns.
		List<WebElement> listColumns = driver.findElements(By.xpath("//table[@id='sortableTable']//tbody/tr[1]/td"));

		// Print number of columns.
		System.out.println("The columns are : "+listColumns.size());

		
		// Get the second row, second column.		
		WebElement secRowSecCol = driver.findElement(By.xpath("//table[@id='sortableTable']//tbody/tr[2]/td[2]"));

		// Print cell value.
		System.out.println("The Third row contains: "+secRowSecCol.getText());
		
		// Click on the header name to sort the column.
		driver.findElement(By.xpath("//table[@id='sortableTable']//thead/tr[1]/th")).click();
		
		// Get the new second row, second column.		
		WebElement newSecRowSecCol = driver.findElement(By.xpath("//table[@id='sortableTable']//tbody/tr[2]/td[2]"));

		// Print cell value.
		System.out.println("The Third row contains: "+newSecRowSecCol.getText());

		// Find the table foot.
		List<WebElement> listFoot = driver.findElements(By.xpath("//table[@id='sortableTable']//tfoot/tr/th"));

		for(WebElement web : listFoot)
		{
			if(web.getText().isEmpty())
				break;
			System.out.println("The table footer contains : "+web.getText());
		}
		
		driver.close();


	}

}
