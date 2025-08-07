import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchBrowserTabAndWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		// driver.switchTo().newWindow(WindowType.WINDOW);

		// set up window/tab handlers
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parenttab = it.next();
		String childtab = it.next();

		// switch to child tab
		Thread.sleep(2000);
		driver.switchTo().window(childtab);
		driver.get("https://rahulshettyacademy.com/");
		driver.findElement(By.xpath("//a[text()='Courses']")).click();
		Thread.sleep(2000);
		List<WebElement> courses = driver.findElements(By.cssSelector("h2[data-sentry-element='CardTitle']"));
		String courseName = courses.get(0).getText();
		System.out.println(courseName);

		// Switch to parent window/tab
		Thread.sleep(2000);
		driver.switchTo().window(parenttab);
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys(courseName);
		System.out.print("Run ended");
		driver.quit();
	}
}
