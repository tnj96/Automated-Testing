package Test;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class ExtraSelenium {
	
	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Applications/chromedriver.exe");
		driver = new ChromeDriver();

	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void screenshotTest() throws IOException {
		driver.get("https://google.com");
		driver.manage().window().maximize();
//		String screenshots;
//		screenshots = "C:/Users/Admin/Pictures";

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String fileName = "test";
		Files.copy(scrFile, new File("C:/Users/Admin/ScreenshotsSelenium/"+fileName +".png"));
//		System.out.println(scrFile.getAbsolutePath());
	}

}
