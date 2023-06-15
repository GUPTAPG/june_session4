package variousconcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Learnkeyboardevent {
	WebDriver driver;

	By USER_NAME_FIELD = By.xpath("//input[@id=('username')]");	
	By PASSWORD_FIELD = By.xpath("//input[@id=('password')]");
	By SIGN_IN_BUTTON_FIELD = By.xpath("//button[@name=('login')]");


	@Before
    public void init() {
	
	System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.get("https://www.techfios.com/billing/?ng=admin/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	@Test
	public void loginTest() {
		

driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
//we are not clicking here we are using action with keyboard

//creating object

Actions action = new Actions(driver);

action.sendKeys(Keys.ENTER).build().perform();
//for runtime compilation we do build and perform
	}

}
