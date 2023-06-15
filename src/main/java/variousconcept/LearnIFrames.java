package variousconcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnIFrames {


		WebDriver driver;
		@Before
	    public void init() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		@Test
		public void IframeTest() {
driver.switchTo().frame("packageListFrame");
driver.findElement(By.linkText("java.applet")).click();

//before jumping into next frame use this
driver.switchTo().parentFrame();
driver.switchTo().frame("packageFrame");
driver.findElement(By.linkText("AppletContext")).click();


}
}