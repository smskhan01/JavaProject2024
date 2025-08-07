import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scroll_Sum {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// declare JavaScript executor for web driver
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// can be run directly in browser devtool = window.scrollBy(0,500)
		// Scroll entire browser window
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);

		// scroll in the table area
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		// sum up the all the values in the table
		List<WebElement> values = (driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)")));

		int sum = 0;

		for (int i = 0; i < values.size(); i++) {
			int amount = Integer.parseInt(values.get(i).getText().trim());
			sum = sum + amount;
		}

		System.out.println(sum);

		// Assert summed and display totals
		int total = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(total, sum);

		driver.close();

	}

}
