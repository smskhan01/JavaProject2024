import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotHeightAndWidth {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> hdlr = driver.getWindowHandles();
		Iterator<String> it = hdlr.iterator();
		String parentTab = it.next();
		String childTab = it.next();
		driver.switchTo().window(childTab);
		driver.get("https://rahulshettyacademy.com/practice-project");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li/a[text()='Courses']")).click();
		String courseName = driver.findElements(By.cssSelector("h2[data-sentry-element=\"CardTitle\"]")).get(0)
				.getText();
		driver.switchTo().window(parentTab);
		Thread.sleep(2000);
		driver.findElements(By.cssSelector("input[name='name']")).get(0).sendKeys(courseName);

		// Get Screenshot of an element (need to download jar file for FileUtils and
		// store it in Java Build Path --> Libraries)
		/*
		 * File file = courseName.getScreenshotAs(OutputType.FILE);
		 * FileUtils.copyFile(file, new File("logo.png"));
		 */

		// Get Height and Width
		/*
		 * System.out.println(courseName.getRect().getDimension().getHeight());
		 * System.out.println(courseName.getRect().getDimension().getWidth());
		 */
	}

}
