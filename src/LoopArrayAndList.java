import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.internal.junit.ArrayAsserts;

public class LoopArrayAndList {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		List<WebElement> product = driver.findElements(By.cssSelector(".product .product-name"));
		Thread.sleep(3000);

		// Order 1 item
		String veggie = "Banana";
		for (int i = 0; i < product.size(); i++) {
			String productName = product.get(i).getText().split("-")[0].trim();

			if (productName.contains(veggie)) {
				driver.findElements(By.xpath("//*[text()='ADD TO CART']")).get(i).click();
				break;
			}
		}

		Thread.sleep(3000);
        // Scroll to the top of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");

		// Order multiple item
		// create an array to list the products
		String[] veggieNames = { "Cauliflower", "Mushroom", "Onion" };
		int ordered = 0;
		for (int i = 0; i < product.size(); i++) {
			String productName = product.get(i).getText().split("-")[0].trim();

			List<String> veggieNamesList = Arrays.asList(veggieNames);
			if (veggieNamesList.contains(productName)) {
				Thread.sleep(2000);
				driver.findElements(By.xpath("//*[text()='ADD TO CART']")).get(i).click();
				ordered++;

				if (ordered == veggieNamesList.size()) {
					break;
				}
			}
		}

	}

}
