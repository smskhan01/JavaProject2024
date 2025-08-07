import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdowns {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
	
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		//Dropdowns by Select Options
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); 
		Select dropdown = new Select(staticDropdown);
		
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//Next Dropdown
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
//		for(int i=1; i<5 ; i++)
//		{
//		driver.findElement(By.id("hrefIncAdt")).click();
//		}
		
		//OR
		int i = 1;
		while(i<5)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		//Next dropdowns
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click();
		//OR
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD']")).click();
		
		//Auto Suggestion Dropdonw
		driver.findElement(By.id("autosuggest")).sendKeys("united");
		Thread.sleep(2000);
		
		List<WebElement> options = driver.findElements(By.cssSelector("li[class=\"ui-menu-item\"] a"));
		
		for(WebElement option : options)
		{
			if (option.getText().equals("United States (USA)"))
			{
				option.click();
				break;
			}
		}
		
		driver.close();

	}

}
