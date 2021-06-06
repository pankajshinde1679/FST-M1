package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity9_2 {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	

		driver.get("https://training-support.net/selenium/selects");
		Thread.sleep(2000);

		String title = driver.getTitle();
		System.out.println("The title is : "+title);

		WebElement web = driver.findElement(By.xpath("//select[@id='multi-select']"));
		
		Select sel = new Select(web);
		
		if(sel.isMultiple())
		{
			// Select the 'JavaScript' option by visible text.
			sel.selectByVisibleText("Javascript");
			
			// Select the 'NodeJS' option by value.
			sel.selectByValue("node");
			
			// Select the 4th, 5th, and the 6th options by index.
			sel.selectByIndex(5);
			sel.selectByIndex(6);
			sel.selectByIndex(7);
			
			// De-select the 'NodeJS' option by value attribute.
			sel.deselectByValue("node");
			
			// De-select the 7th option by index.
			sel.deselectByIndex(7);
			
			// Print the first selected option
			WebElement firstSel = sel.getFirstSelectedOption();
			System.out.println("First selected option is : "+firstSel.getText());
			
			// Print all selected options.
			List<WebElement> selected = sel.getOptions();
			for(WebElement item : selected)
			{
				if(item.isSelected())
					System.out.println(item.getText());
			}
			
			// De-select all selected options.
			sel.deselectAll();				
		}
		
		Thread.sleep(5000);
		
		driver.close();

	}

}
