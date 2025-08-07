import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class iFrame {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://jqueryui.com/droppable/");

		Actions a = new Actions(driver);
		// to find the # for iframe in the page
		System.out.println("This page has only: " + driver.findElements(By.tagName("iframe")).size());
		Thread.sleep(3000);

		// iframe can be called by index, webelement and name or Id
		// switch to iframe first
		WebElement iFrame = driver.findElement(By.cssSelector("iframe.demo-frame"));
		driver.switchTo().frame(iFrame);
		
		//by index
		//driver.switchTo().frame(0);
		
		// **Have to switch to iframe first before declaring WebElement for source -->
		// target
		WebElement dragThis = driver.findElement(By.id("draggable"));
		WebElement dragTo = driver.findElement(By.id("droppable"));
		a.dragAndDrop(dragThis, dragTo).build().perform();
		Thread.sleep(2000);

		// to switch back to normal mode from iframe
		driver.switchTo().defaultContent();
		driver.close();

	}

}
