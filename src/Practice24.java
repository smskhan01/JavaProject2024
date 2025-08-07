import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practice24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Sort
		driver.findElement(By.xpath("//tr/th[1]")).click();
		// Collect webelements
		List<WebElement> webElement = driver.findElements(By.xpath("//tr/td[1]"));
		// get the text out of each web elements
		List<String> original = webElement.stream().map(s -> s.getText()).collect(Collectors.toList());
		// sort the original to compare
		List<?> sorted = original.stream().sorted().collect(Collectors.toList());

		// Compare
		Assert.assertTrue(original.equals(sorted));
		System.out.println("Test passed");
		
		// Print veggie price (from sibling column)
		List<String> price = webElement.stream().filter(s -> s.getText().contains("Beans")).map(s -> getVeggiesPrice(s))
				.collect(Collectors.toList());
		price.forEach(s -> System.out.println(s));
		
		//Pagination
		List<String> price1;
		do {
			// Collect webelements with different name to re-use in the loop
			List<WebElement> row = driver.findElements(By.xpath("//tr/td[1]"));
			price1 = row.stream().filter(s -> s.getText().contains("Rice")).map(s -> getVeggiesPrice(s))
					.collect(Collectors.toList());
			price1.forEach(a -> System.out.println(a));
		if(price1.size() < 1) 
		{
			driver.findElement(By.cssSelector("[aria-label=\"Next\"]")).click();
		}
		}while(price1.size() < 1);
		
	}

	private static String getVeggiesPrice(WebElement s) {
		// TODO Auto-generated method stub
		String cost = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return cost;
	}

}
