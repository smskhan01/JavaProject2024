import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Create Actions driver
		Actions a = new Actions(driver);

		// declare web element move as variable
		WebElement move = driver.findElement(By.id("mousehover"));

		// to scroll to view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", move);

		// to hoverover
		a.moveToElement(move).build().perform();
		
		Thread.sleep(2000);
		
		// Right click in mouse
		a.moveToElement(move).contextClick().build().perform();
		
		Thread.sleep(2000);

		// declare input box web element as variable
		WebElement inputBox = driver.findElement(By.id("autocomplete"));

		Thread.sleep(2000);

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputBox);

		// type in cap letter with actions
		a.moveToElement(inputBox).click().keyDown(Keys.SHIFT).sendKeys("united").build().perform();

		Thread.sleep(2000);

		// how to double click
		a.moveToElement(inputBox).doubleClick().build().perform();

	}

}
