import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practice28 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();

		List<WebElement> element = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> original = element.stream().map(s -> s.getText()).collect(Collectors.toList());
		List<String> sorted = original.stream().sorted().collect(Collectors.toList());
		Assert.assertEquals(original, sorted);
		System.out.println("Sorted Test Passed");

		String veg = "Beans";
		String veg1 = "Rice";
		List<String> price = element.stream().filter(s -> s.getText().contains(veg)).map(s -> getVegPrice(s))
				.collect(Collectors.toList());
		price.forEach(a -> System.out.println("Price of " + veg + ": $" + a));

		List<String> price1;
		do {
			List<WebElement> row = driver.findElements(By.xpath("//tr/td[1]"));
			price1 = row.stream().filter(s -> s.getText().contains(veg1)).map(s -> getVegPrice(s))
					.collect(Collectors.toList());
			price1.forEach(a -> System.out.println("Price of " + veg1 + ": $" + a));
			if (price1.size() < 1) {
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}

		} while (price1.size() < 1);

		driver.findElement(By.id("search-field")).sendKeys(veg1);
		List<WebElement> filter = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> filtered = filter.stream().filter(s -> s.getText().contains(veg1))
				.collect(Collectors.toList());
		Assert.assertEquals(filter.size(), filtered.size());
		System.out.println("Filtered Test Passed");
	}

	private static String getVegPrice(WebElement s) {
		// TODO Auto-generated method stub
		String cost = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return cost;
	}
}
