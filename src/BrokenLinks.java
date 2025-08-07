import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Soft Assertion
		SoftAssert a = new SoftAssert();

		// Scroll to the bottom
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");

		// get the single url
		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getDomAttribute("href");
		// open open connection method is present in URL class
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		// what kind of https method () are you calling?
		conn.setRequestMethod("HEAD");
		// make the connection
		conn.connect();
		// get the response code from the call
		int ResCode = conn.getResponseCode();
		System.out.println("This is for single link validation: " + ResCode);
		
		//**soft Assertion
		a.assertTrue(ResCode<400, "The respose code is from soft assertion " + ResCode + " so this test failed");
		
		//Hard assertion
//		if(ResCode > 400)
//		{
//			Assert.assertTrue(false, "The respose code is from hard assertion " + ResCode + " so this test failed");
//		}
		
		//must declare this to report soft assertion result
		a.assertAll();

		// ---------------------------------------------
		/*
		 * //to get all urls List<WebElement> links =
		 * driver.findElements(By.cssSelector("li[class='gf-li'] a")); for(int i = 0 ; i
		 * < links.size(); i++) { String urls = links.get(i).getDomAttribute("href");
		 * HttpURLConnection conn = (HttpURLConnection) new URL(urls).openConnection();
		 * conn.setRequestMethod("HEAD"); conn.connect(); int ResCode1 =
		 * conn.getResponseCode(); System.out.println(ResCode1); if (ResCode1 > 400) {
		 * System.out.println("This is the failed link: " + links.get(i).getText() +
		 * " with status code: " + ResCode1); //Assert.assertTrue(false);
		 * 
		 * }
		 * 
		 * }
		 */
		Thread.sleep(3000);
		driver.close();
	}

}
