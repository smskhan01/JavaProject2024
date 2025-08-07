import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practice23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Sort
		driver.findElement(By.cssSelector("[aria-sort=\"descending\"]")).click();

		// Collect webelments
		List<WebElement> webElements = driver.findElements(By.xpath("//tr/td[1]"));

		// get the text of each webelement
		List<String> originalNames = webElements.stream().map(s -> s.getText()).collect(Collectors.toList());

		// sort original list for matching
		List<String> sortedNames = originalNames.stream().sorted().collect(Collectors.toList());

		// assert
		Assert.assertTrue(originalNames.equals(sortedNames));

		System.out.println("Test Passed");

		// find the veggie with name = bean then print the price of it
		List<String> price = webElements.stream().filter(s -> s.getText().contains("Brinjal"))
				.map(s -> getVeggiePrice(s)).collect(Collectors.toList());
		price.forEach(a -> System.out.println(a));

		driver.close();
	}

	private static String getVeggiePrice(WebElement s) {
		String veggiePrice = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return veggiePrice;
	}
}
