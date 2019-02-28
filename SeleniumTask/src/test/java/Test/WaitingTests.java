package Test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitingTests {
	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Applications/chromedriver.exe");
	}
	
	@Test
	@Ignore
	public void implicitTest() {
		driver = new ChromeDriver();
		driver.get("https://christophperrins.github.io/TestingSite/");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement shafeeq = driver.findElement(By.xpath("//*[@id=\"quote\"]/h2"));
//		shafeeq.isDisplayed();
	}
	
	@Test
//	@Ignore
	public void explicitTest() {
		driver = new ChromeDriver();
		driver.get("https://christophperrins.github.io/TestingSite/");
		WebElement shaf = (new WebDriverWait(driver, 6)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"quote\"]/h2")));
//		shaf.isDisplayed();
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}

}
