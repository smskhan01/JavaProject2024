import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * ID
		 * Xpath				Ex.://p[@class='error']
		 * CSS Selector			Ex.: p[class='error']
		 * name
		 * Class Name
		 * Tag Name
		 * Link Text
		 * Partial Link Text
		 * 
		 * Attributes and Value
		 * 
		 * By Text with xpath: //button[text()='Log Out'] OR //*[text()='Log Out']
		 *
		 */
			
			WebDriver driver = new ChromeDriver();
			
			//Adding wait, this will wait for 5 seconds if step completes early then it will automatically continue
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			//Signin Page
			driver.get("https://rahulshettyacademy.com/locatorspractice/");
			driver.findElement(By.id("inputUsername")).sendKeys("Anthony");
			driver.findElement(By.name("inputPassword")).sendKeys("Test");
			//CSS Selector examples
			driver.findElement(By.cssSelector("button.submit")).click();
			System.out.println(driver.findElement(By.cssSelector("p[class='error']")).getText());
			driver.findElement(By.linkText("Forgot your password?")).click();
			
			//declare wait for 1 sec
			Thread.sleep(1000);
			
			//Forget PW Page
			//xPath examples
			driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John Joe");
			
			//xpath by tag name only and index
			//to move from parent tag to child tag only user 1 "/"
			driver.findElement(By.xpath("//form/input[2]")).sendKeys("test@test.com");
			
			//ccsSelection by index
			driver.findElement(By.cssSelector("input[type=\"text\"]:nth-child(4)")).sendKeys("718-447-8746");
			
			driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
					
			// Grab text and print
			System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());
			Assert.assertEquals(false, null);
			
			//driver.close();

	}

}
