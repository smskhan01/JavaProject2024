import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practice25 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();

		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> original = elements.stream().map(s -> s.getText()).collect(Collectors.toList());
		List<String> sorted = original.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(original.equals(sorted));
		System.out.println("Sorted test passed");

		List<String> price1 = elements.stream().filter(s -> s.getText().contains("Beans"))
				.map(s -> getVeggiePrices(s)).collect(Collectors.toList());
		price1.forEach(a -> System.out.println(a));

		List<String> price;
		do {
			List<WebElement> row = driver.findElements(By.xpath("//tr/td[1]"));
			price = row.stream().filter(s -> s.getText().contains("Rice")).map(s -> getVeggiePrices(s))
					.collect(Collectors.toList());
			price.forEach(s -> System.out.println(s));
			if (price.size() < 1) {
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
		} while (price.size() < 1);
	}

	private static String getVeggiePrices(WebElement s) {
		String value = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return value;
	}
}
