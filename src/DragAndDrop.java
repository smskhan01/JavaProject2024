import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://jqueryui.com/droppable/");

		// Declare action driver for drag and drop
		Actions a = new Actions(driver);

		WebElement iFrame = driver.findElement(By.cssSelector("iframe[class='demo-frame']"));
		// switch to iframe first
		driver.switchTo().frame(iFrame);

		// **Have to switch to iframe first before declaring WebElement for source -->
		// target
		WebElement dragThis = driver.findElement(By.id("draggable"));
		WebElement dragTo = driver.findElement(By.id("droppable"));
		// drag and drop
		a.dragAndDrop(dragThis, dragTo).build().perform();

		// to switch back to normal mode from iframe
		driver.switchTo().defaultContent();

	}

}
