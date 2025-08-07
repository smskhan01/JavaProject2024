import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkboxAndCount {

	public static void main(String[] args) {
		

		WebDriver driver = new ChromeDriver();
	
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).click();
		//Assertion
		System.out.println(driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());
		
		//count element
		System.out.println(driver.findElements(By.cssSelector("[type='checkbox']")).size());
		
		driver.close();

	}

}
