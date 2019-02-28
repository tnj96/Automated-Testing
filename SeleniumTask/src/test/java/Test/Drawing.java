package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Drawing 
{
	WebDriver driver;
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Applications/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youidraw.com/apps/painter/");
	}
	
	@Test
	public void searchTest()
	{
		
		Actions action = new Actions(driver);
		
		WebElement brushSelect = driver.findElement(By.xpath("//*[@id=\"brush\"]"));
		brushSelect.click();
		
		WebElement canvas = driver.findElement(By.xpath("//*[@id=\"catch\"]"));
		action.moveToElement(canvas).moveByOffset(-450, -200).clickAndHold().moveByOffset(200, 0).release().perform();
		action.moveToElement(canvas).moveByOffset(-350, -200).clickAndHold().moveByOffset(0, 200).release().perform();
		
		action.moveToElement(canvas).moveByOffset(-220, -200).clickAndHold().moveByOffset(-70, 200).release().perform();
		action.moveToElement(canvas).moveByOffset(-220, -200).clickAndHold().moveByOffset(70, 200).release().perform();
		action.moveToElement(canvas).moveByOffset(-250, -90).clickAndHold().moveByOffset(70, 0).release().perform();

		action.moveToElement(canvas).moveByOffset(-130, -200).clickAndHold().moveByOffset(0, 200).release().perform();
		action.moveToElement(canvas).moveByOffset(-130, 0).clickAndHold().moveByOffset(90, 0).release().perform();

		action.moveToElement(canvas).moveByOffset(-10, -200).clickAndHold().moveByOffset(0, 200).release().perform();
		action.moveToElement(canvas).moveByOffset(-10, -200).clickAndHold().moveByOffset(70, 0).release().perform();
		action.moveToElement(canvas).moveByOffset(-10, -100).clickAndHold().moveByOffset(70, 0).release().perform();
		action.moveToElement(canvas).moveByOffset(-10, 0).clickAndHold().moveByOffset(70, 0).release().perform();


	}
	
//	@After
//	public void teardown()
//	{
//		driver.quit();
//	}


}
