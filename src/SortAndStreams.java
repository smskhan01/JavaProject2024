import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortAndStreams {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// click on sort
		driver.findElement(By.className("sort-icon")).click();
		// capture all webelements values
		List<WebElement> vegNameElements = driver.findElements(By.xpath("//tr/td[1]"));

		// capture names of all webelements into new list (original) to get names of
		// each veg
		List<String> originalVegNames = vegNameElements.stream().map(s -> s.getText()).collect(Collectors.toList());

		// get sorted name in new list (sorted) to compare with original list
		List<String> sortedVegNames = originalVegNames.stream().sorted().collect(Collectors.toList());

		// compare original vs sorted list
		Assert.assertTrue(originalVegNames.equals(sortedVegNames));

		// get me the price of Brinjal (in first page) --> Scan sorted VegName and
		// getText = vegname then print the price of that veg
		List<String> price = vegNameElements.stream().filter(s -> s.getText().contains("Brinjal"))
				.map(s -> getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a -> System.out.println(a));

		driver.close();
	}

	private static String getPriceVeggie(WebElement s) {
		// travel to next column in the same row
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
