import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarAndAssertion {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// click to open calendar
		driver.findElement(By.cssSelector(".react-date-picker__calendar-button")).click();
		// navigate to year
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		Thread.sleep(1000);

		String Month = "5";
		String Day = "15";
		String Year = "2025";
		String[] date = { Month, Day, Year };

		// Select year
		driver.findElement(By.xpath("//button[text()='" + Year + "']")).click();
		// Select month
		// ***Convert String value to Integer "Integer.parseInt(Month)"
		driver.findElements(By.tagName("abbr")).get(Integer.parseInt(Month) - 1).click();
		// Select day
		driver.findElement(By.xpath("//abbr[text()='" + Day + "']")).click();

		// Assert selected date
		List<WebElement> dates = driver.findElements(By.className("react-date-picker__inputGroup__input"));
		for (int i = 0; i < dates.size(); i++) {
			System.out.println(dates.get(i).getDomAttribute("value"));
			Assert.assertEquals(dates.get(i).getDomAttribute("value"), date[i]);
		}
		driver.close();
	}

}
