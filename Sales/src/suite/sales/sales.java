package suite.sales;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sales {
	
public WebDriver driver;
	
	@BeforeTest
	public void LaunchBrowser(){
	System.setProperty("webdriver.chrome.driver","D:\\Elohor\\Selenium\\chromedriver.exe");
	 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
		}

	//register an account
	@Test
	public void register() throws InterruptedException{
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email_create")).sendKeys("eevwrujae@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		//checkbox
		List <WebElement> gender = driver.findElements(By.name("id_gender"));
        int count = gender.size();
		for (int i= 0; i<count; i++)
		{
			String txt = gender.get(i).getText();
			
			gender.get(i).click();
			Thread.sleep(1000);
		}
		
		driver.findElement(By.id("customer_firstname")).sendKeys("Elohor");
		driver.findElement(By.id("customer_lastname")).sendKeys("Peter");
		driver.findElement(By.id("passwd")).sendKeys("glamour1");
		//Dropdown
		WebElement day = driver.findElement(By.id("days"));
        Select d1 = new Select(day);
		d1.selectByIndex(3);
		
		WebElement month = driver.findElement(By.id("months"));
        Select m1 = new Select(month);
		m1.selectByIndex(5);
		
		WebElement year = driver.findElement(By.id("years"));
        Select y1 = new Select(year);
		y1.selectByIndex(11);
		
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.id("company")).sendKeys("Atos");
		driver.findElement(By.id("address1")).sendKeys("tttttt");
		driver.findElement(By.id("city")).sendKeys("Ikeja");
		WebElement state = driver.findElement(By.id("id_state"));
        Select s1 = new Select(state);
		s1.selectByIndex(8);
		
		driver.findElement(By.id("postcode")).sendKeys("99501");
		WebElement country = driver.findElement(By.id("id_country"));
        Select c1 = new Select(country);
		c1.selectByIndex(1);
		
		driver.findElement(By.id("phone")).sendKeys("08067158436");
		//driver.findElement(By.id("alias")).sendKeys("broadstreet");
		driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
	}
	
	    //login
		@Test
		public void login() throws InterruptedException{
			driver.findElement(By.linkText("Sign in")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("email")).sendKeys("eevwrujae@gmail.com");
			driver.findElement(By.id("passwd")).sendKeys("glamour1");
			driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		
				
	}
}

