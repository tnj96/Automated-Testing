package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Testing 
{
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Applications/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void searchTest()
	{
		driver.get("http://automationpractice.com/index.php");
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.searchFor("dress");
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}

}
