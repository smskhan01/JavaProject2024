import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practice26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String veggie = "Beans";

		// sort
		driver.findElement(By.xpath("//tr/th[1]")).click();

		// get web elements
		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));

		// get text and save as array for comparing
		List<String> original = elements.stream().map(s -> s.getText()).collect(Collectors.toList());
		// sort the original list for comparing
		List<String> sorted = original.stream().sorted().collect(Collectors.toList());
		// assert
		Assert.assertEquals(original, sorted);
		System.out.println("Sort test PASSED");

		// get the price of beans
		List<String> price = elements.stream().filter(s -> s.getText().contains(veggie)).map(s -> getVeggiePrice(s))
				.collect(Collectors.toList());
		price.forEach(a -> System.out.println("Price of " + veggie + ": $" + a));
		
		//get the price of Rice using pagination
		List<String> price1;
		String veggie1 = "Rice";
		do {
			List<WebElement> element = driver.findElements(By.xpath("//tr/td[1]"));
			price1 = element.stream().filter(s -> s.getText().contains(veggie1)).map(s -> getVeggiePrice(s)).collect(Collectors.toList());
			price1.forEach(z -> System.out.println("Price of " + veggie1 +  " : $" + z));
			if(price1.size() < 1)
			{
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
		}while(price1.size() < 1);

	}

	private static String getVeggiePrice(WebElement s) {
		// TODO Auto-generated method stub
		String priceTag = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceTag;
	}

}
