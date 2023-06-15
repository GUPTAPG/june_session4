package variousconcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearbPopup {
	WebDriver driver;
	@Before
    public void init() {
	
	System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		@Test
	public void alertPopupTest() throws InterruptedException {
	Thread.sleep(3000);	
	driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/div/input[2]")).click();
	String alertmessage= driver.switchTo().alert().getText();
	
	driver.switchTo().alert().accept();
	
		
		System.out.println("alertmessage");
		
		}
	
}
