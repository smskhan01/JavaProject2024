import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RetryWithCorrectUsername {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String password = "learning";
		String correctEmailID = "rahulshettyacademy";

		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();

		// get the window handle for browser tab switching
		Set<String> windows = driver.getWindowHandles();
		// to define driver to iterate though different tabs
		Iterator<String> it = windows.iterator();
		// Declare variable for the different tabs
		String parentTab = it.next();
		String childTab = it.next();

		// Switch to child tab
		driver.switchTo().window(childTab);
		System.out.println(driver.findElement(By.cssSelector("p[class='im-para red']")).getText());

		// Split and Trim text()
		String emailID = driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("at")[1].trim()
				.split(" ")[0];

		// Swich to parent tab
		driver.switchTo().window(parentTab);
		Thread.sleep(3000);

		// Retry username code
		try {
			WebElement usernameField = driver.findElement(By.id("username"));
			WebElement passwordField = driver.findElement(By.id("password"));
			WebElement agreementCheckbox = driver.findElement(By.id("terms"));
			WebElement loginButton = driver.findElement(By.id("signInBtn"));

			// Incorrect username:
			usernameField.sendKeys(emailID);
			passwordField.sendKeys(password);
			agreementCheckbox.click();
			loginButton.click();

			// Wait for error message
			Thread.sleep(2000);

			// Check if error message is displayed
			WebElement errorMessage = driver.findElement(By.cssSelector("div.alert strong"));
			if (errorMessage.isDisplayed()) {
				System.out.println("Wrong username detected. Retrying with correct username...");
				usernameField.clear();
				// Correct username:
				usernameField.sendKeys(correctEmailID );
				loginButton.click();
			}

			// Optionally check login success here
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

}
