import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practice20 {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		for (int i = 0; i < values.size(); i++) {
			int value = Integer.parseInt(values.get(i).getText().trim());
			sum = sum + value;
			System.out.println(value);
			Thread.sleep(500);
		}
		System.out.println(sum);

		int Total = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, Total);

		Thread.sleep(2000);
		driver.close();
	}

}
