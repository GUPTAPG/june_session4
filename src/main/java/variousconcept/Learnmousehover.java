package variousconcept;

	import java.util.concurrent.TimeUnit;

	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
	
	public class Learnmousehover {
	
		WebDriver driver;

		@Before
	    public void init() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.dell.com/en-us");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		}
		
		@Test
		public void mouseHoverTest() {
By COMPUTORS_AND_ACCESSORIES_FIELD = By.xpath("//span[text()='Computers & Accessories']");
By MONITORS_FIELD =  By.xpath("//button[text()='Monitors']");
By VIEW_All_MONITORS_FIELD = By.xpath("//a[text()='View all Monitors']");
	
Actions action = new Actions(driver);
action.moveToElement(driver.findElement(COMPUTORS_AND_ACCESSORIES_FIELD)).build().perform();
//action.moveToElement(driver.findElement(MONITORS_FIELD)).build().perform();
//driver.findElement(VIEW_All_MONITORS_FIELD).click();
		
		
		}

}
