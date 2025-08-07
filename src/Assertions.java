import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assertions {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		for(int i = 1; i<5; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		//Assertion Equals
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		
		
		driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();
		
		//Assertion True
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).isSelected());
		
		//Assertion False
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).isSelected());
		

	}

}
