import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WhileAndNextTab {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		List<WebElement> findlinks = driver.findElements(By.cssSelector("#gf-BIG td:nth-child(1) ul li a"));
		System.out.println("Total links: " + findlinks.size());

		// click and open each tab
		for (int i = 1; i < findlinks.size(); i++) {
			// Control + click actions
			String controlEnter = Keys.chord(Keys.CONTROL, Keys.ENTER);
			// Click on links
			findlinks.get(i).sendKeys(controlEnter);
			Thread.sleep(1000);
		}

		// declare window handles and iterator to move to next tab
		Set<String> a = driver.getWindowHandles();
		Iterator<String> it = a.iterator();
		
		//While loop to go through each tabs -- while user for unknowns amount of iterations**
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println("The page tittle is: " + driver.getTitle());
		}

		// To close 1 tab: .close()
		// To close multiple tabs: .quit()
		driver.quit();

	}

}
