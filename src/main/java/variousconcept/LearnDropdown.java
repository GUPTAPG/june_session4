package variousconcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class LearnDropdown {
	
WebDriver driver;
//Element list
By USER_NAME_FIELD = By.xpath("//input[@id=('username')]");	
By PASSWORD_FIELD = By.xpath("//input[@id=('password')]");
By SIGN_IN_BUTTON_FIELD = By.xpath("//button[@name=('login')]");
By DASHBOARD_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
By CUSTOMER_MENU_FIELD =By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]");
By ADD_CUSTOMER_MENU_FIELD	= By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a") ;
By CONTACT_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5")	;	
By FULL_NAME_FIELD = By.xpath("//*[@id=\"account\"]");
By COMPANY_DROPDOWN_FIELD = By.xpath("//select[@id='cid']");



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
		


driver.findElement(SIGN_IN_BUTTON_FIELD).click();

String dashboardHeaderText = driver.findElement(DASHBOARD_HEADER_FIELD).getText();
//.getTitle is for printing title,we are converting it into string then ptintingout
String dashboardPageTitle = driver.getTitle();
System.out.println("dashboardPageTitle");


//assert 3 condition
//Assert.assertTrue("Dashboard page not found", driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
//getText() is used to covert webelement into string
//Assert.assertEquals("Dashboard page not found", "Dashboard", dashboardHeaderText ); 
	
//page tittle
//Assert.assertEquals("Dashboard page not found", "Dashboard- iBilling", dashboardPageTitle);
Assert.assertEquals("Dashboard page not found", "Dashboard- iBilling", dashboardPageTitle);	
	}	
@Test
public void addCustomerTest() throws InterruptedException {
		
	loginTest();
		driver.findElement(CUSTOMER_MENU_FIELD).click();
		driver.findElement(ADD_CUSTOMER_MENU_FIELD).click();
		Thread.sleep(2000);
	Assert.assertEquals("Dashboard page not found","Add Contact",driver.findElement(CONTACT_HEADER_FIELD).getText());
driver.findElement(FULL_NAME_FIELD).sendKeys("Dheeresh");
//FOR INSERTING VALUE IN DROPDOWN WE HAVE TO CREATE OBJECT OG IT
Select sel = new Select(driver.findElement(COMPANY_DROPDOWN_FIELD));
sel.selectByVisibleText("Techfios");


}
	
		
	

	
	
	
	
}
