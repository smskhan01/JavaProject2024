import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserTabSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		//Switch Browser tabs
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator(); //will hold the position of each tab[parentTab ; childTab]
		String parentTab = it.next();
		String childTab = it.next();
		driver.switchTo().window(childTab);
		
		//grab text and print
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

	}

}
