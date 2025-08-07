import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AssertDisableAndEnabled {

	private static final boolean WebElement = false;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		//Currency
		WebElement dropdownOptions = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(dropdownOptions);
		dropdown.selectByVisibleText("USD");
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "USD");
		
		//From
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("li a[text=\"Jaipur (JAI)\"]")).click();
		
		//To  
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_destinationStation1_CTNR a[text=\"Jammu (IXJ)\"]")).click();
		
		//Checkbox
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		
		//Country
		driver.findElement(By.id("autosuggest")).sendKeys("united");
		Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		for (WebElement option : options)
				{
					if (option.getText().equals("United States (USA)"))
					{
						option.click();
						break;
					}
				}
		
		
		//OneWay (Radio Button)
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected());
		
		//Depart date enabled
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_view_date1")).isEnabled());
		
		//Return date disabled (** NOT WORKING)
		//Assert.assertFalse(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		
		//Round Trip (Radio Button)
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		//Return date enabled
		Assert.assertTrue(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		
		
	}

}
