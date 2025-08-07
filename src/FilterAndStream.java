import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterAndStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		String product = "Rice";
		// filter
		driver.findElement(By.id("search-field")).sendKeys(product);
		// get web elements for result row to be used to find result row count
		List<WebElement> results = driver.findElements(By.xpath("//tr/td[1]"));
		// filter with stream and to get the row count
		List<WebElement> filtered = results.stream().filter(veg -> veg.getText().contains(product))
				.collect(Collectors.toList());
		Assert.assertEquals(results.size(), filtered.size());
		System.out.println("Size count passed");
		driver.close();
	}

}
