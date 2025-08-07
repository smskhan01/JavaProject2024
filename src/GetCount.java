import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// get count of all links in the page
		// links normally has tagName = a (anchor)
		System.out.println("Total links in this page are: " + driver.findElements(By.tagName("a")).size());
		Thread.sleep(3000);

		// To find links only in a specific section (footer)
		WebElement footerSection = driver.findElement(By.id("gf-BIG"));
		System.out.println("Total links at the footer section are: " + footerSection.findElements(By.tagName("a")).size());
		Thread.sleep(3000);

		driver.close();

	}

}
