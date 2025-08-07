import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserCertificate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//To get more info, visit: "https://developer.chrome.com/docs/chromedriver/capabilities"
		//Block pops ups
		//Change download directory 
			
		// Import Browser options driver (Chrome)
		ChromeOptions options = new ChromeOptions();
		// Accept insure browser certificates
		options.setAcceptInsecureCerts(true);

		// Pass the Options driver in web driver
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		// delete browser cookies
		driver.manage().deleteAllCookies();

		driver.get("https://expired.badssl.com/");
		String pagetittle = driver.getTitle();
		System.out.println("Page tittle is: " + pagetittle);
		Thread.sleep(2000);
		driver.close();

	}
}
