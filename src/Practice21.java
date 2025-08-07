import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practice21 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// JavaScript executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll Window:
		js.executeScript("window.scrollBy(0,500)");
		// Scroll frame
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		// sum up column values
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		int amount1 = 0;

		for (int i = 0; i < values.size(); i++) {
			int amount = Integer.parseInt(values.get(i).getText());
			amount1 = amount;
			System.out.print(amount1 + "\n");
			sum = sum + amount;
			Thread.sleep(500);
		}
		System.out.println(sum);

		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());

		Assert.assertEquals(sum, total);
		driver.close();
	}

}
