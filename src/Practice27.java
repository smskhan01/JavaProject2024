import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Practice27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String veggie = "Beans";

		List<WebElement> veggieElement = driver.findElements(By.cssSelector("div.product h4.product-name"));
		for (int i = 0; i < veggieElement.size(); i++) {
			String vegName = veggieElement.get(i).getText();
			if (vegName.contains(veggie)) {
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
			}
		}

		driver.findElement(By.xpath("//div[3]/div[3]/button[1]")).click();
		driver.findElement(By.cssSelector("[alt=\"Cart\"]")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		List<WebElement> priceElements = driver.findElements(By.xpath("//tbody/tr/td[5]/p"));
		int sum = 0;
		for (int i = 0; i < priceElements.size(); i++) {
			String value = priceElements.get(i).getText().trim();
			int price = Integer.valueOf(value);
			sum = sum + price;
		}

		String totValue = driver.findElement(By.className("discountAmt")).getText().trim();
		int total = Integer.valueOf(totValue);
		Assert.assertEquals(sum, total);
		System.out.println("Total test passed");
		Assert.assertEquals(priceElements.size(), 2);
		System.out.println("Total size test passed");
		driver.findElement(By.xpath("//button[text()= 'Place Order']")).click();

		WebElement dropdown = driver.findElement(By.xpath("//select"));
		Select select = new Select(dropdown);
		select.selectByValue("Bangladesh");
		driver.findElement(By.className("chkAgree")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		driver.close();
	}

}
