package variousconcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class homework4 {
WebDriver driver;
By USERNAME_FIELD = By.xpath("//input[@id=('username')]");
By PASSWORD_FIELD = By.xpath("//input[@id=('password')]");
By SIGNIN_FIELD = By.xpath("//button[@name=('login')]");
By DASHBOARD_HEADER_FIELD = By.xpath("//h2[text()= ' Dashboard ']");
By CUSTOMER_MENU_FIELD = By.xpath("//span[contains(text(), 'Customers')]");
By ADD_CUSTOMER_MENU_FIELD= By.xpath("//a[text()= 'Add Customer']");
By CONTACT_HEADER_FIELD = By.xpath("//h5[text()='Add Contact']")	;	
By FULL_NAME_FIELD = By.xpath("//input[@id ='account']");
By COMPANY_DROPDOWN_FIELD = By.xpath("//select[@id='cid']");
By EMAIL_FIELD = By.xpath("//input[@id= 'email']");
By PHONE_FIELD = By.xpath("//input[@id='phone']");
By ADDRESS_FIELD = By.xpath("//input[@id='address']");
By CITY_FIELD =By.xpath("//input[@id='city']");
By STATE_FIELD =By.xpath("//input[@id= 'state']");
By ZIP_FIELD =By.xpath("//input[@id= 'zip']");
By COUNTRY_FIELD = By.xpath("//select[@id='country']");
By SAVE_FIELD = By.xpath("//button[@id='submit']");
By LISTCUSTOMER_DROPDOWN_FIELD = By.xpath("//a[contains(text(),'List Customers')]");
By SEARCH_FIELD = By.xpath("//input[@id='foo_filter']");
@Before
public void init() {
	System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
driver= new ChromeDriver();
driver.manage().deleteAllCookies();
driver.get("https://www.techfios.com/billing/?ng=admin/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}
@Test
public void loginTest() {
	driver.findElement(USERNAME_FIELD).sendKeys("demo@techfios.com");
driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
driver.findElement(SIGNIN_FIELD).click();
driver.findElement(DASHBOARD_HEADER_FIELD);
String dashboardHeaderText = driver.findElement(DASHBOARD_HEADER_FIELD).getText();
//String dashboardPageTitle = driver.getTitle();
//System.out.println("dashboardPageTitle");
Assert.assertEquals("Dashboard page not found", "Dashboard",dashboardHeaderText );
}
@Test
public void addCustomerTest() throws InterruptedException {
	loginTest();	
driver.findElement(CUSTOMER_MENU_FIELD).click();
driver.findElement(ADD_CUSTOMER_MENU_FIELD).click();
Thread.sleep(0);
String contactheadertext = driver.findElement(CONTACT_HEADER_FIELD).getText();
//Assert.assertEquals("Dashboard page not found","Add Contact",contactheadertext);
//Assert.assertEquals("Dashboard" , dashboardHeaderText, "Dsahboard pagenot found");
driver.findElement(FULL_NAME_FIELD).sendKeys("Priya");
//DROPDOWN
Select sel = new Select(driver.findElement(COMPANY_DROPDOWN_FIELD));
sel.selectByVisibleText("Techfios");
driver.findElement(EMAIL_FIELD).sendKeys("priyagupta959@gmail.com");
driver.findElement(PHONE_FIELD).sendKeys("6144070073");
driver.findElement(ADDRESS_FIELD).sendKeys("7117 bronco");
driver.findElement(CITY_FIELD).sendKeys("Dallas");
driver.findElement(STATE_FIELD).sendKeys("Texas");
driver.findElement(ZIP_FIELD).sendKeys("75048");

Select sell = new Select(driver.findElement(COUNTRY_FIELD));
sell.selectByVisibleText("United States");

driver.findElement(SAVE_FIELD).click();

driver.findElement(LISTCUSTOMER_DROPDOWN_FIELD).click();
driver.findElement(SEARCH_FIELD).sendKeys("priya");

}

}


