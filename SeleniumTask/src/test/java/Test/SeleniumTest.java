package Test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumTest 
{
	WebDriver driver;
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Applications/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	@Ignore
	public void methodTest()
	{
		driver.get("http://thedemosite.co.uk/");
		driver.manage().window().maximize();
	}
	
	@Test
	@Ignore
	public void task1()
	{
		driver.get("http://thedemosite.co.uk/");
		WebElement checkElement = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		checkElement.click();		
	}
	
	@Test
	@Ignore
	public void createUser()
	{
		driver.get("http://thedemosite.co.uk/addauser.php");
		WebElement username = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		username.sendKeys("myusername");
		
		WebElement password = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		password.sendKeys("Apassword");
		
		WebElement save = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
		save.click();
	}
	
	@Test
	@Ignore
	public void shoppingSite() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		
		WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
		searchBar.sendKeys("dress");
		WebElement searchBtn = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button"));
		searchBtn.click();
		
//		driver.get("http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=");
		WebElement chosenDress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img"));

		chosenDress.click();
		
		driver.get("http://automationpractice.com/index.php?id_product=4&controller=product&search_query=dress&results=7");
		WebElement addDress = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));

		addDress.click();
		
		WebElement isAdded = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]"));
		isAdded.isDisplayed();
		Thread.sleep(10000);
		WebElement goCheckout = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"));
		goCheckout.click();
		
		WebElement checkout = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]"));
		checkout.click();
		WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		email.sendKeys("fakeaccount123@yahoo.com");
		WebElement pword = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
		pword.sendKeys("fake123");
		WebElement enter = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]"));
		enter.click();
		
		WebElement addressConf = driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button"));
		addressConf.click();
		
		WebElement deliveryConf = driver.findElement(By.xpath("//*[@id=\"cgv\"]"));
		deliveryConf.click();
		
		WebElement proceed = driver.findElement(By.xpath("//*[@id=\"form\"]/p/button"));
		proceed.click();
		
		WebElement pay = driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a"));
		pay.click();
		
		WebElement confOrder = driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button"));
		confOrder.click();
	}
	
	@Test
//	@Ignore
	public void phpTravel()
	{
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/hotels/search/01-03-2019/03-03-2019/3/0");
		
//		WebElement table = 
		
		boolean found = false;
		int counter = 1;
		while(!found)
		{
			List<WebElement> location = driver.findElements(By.tagName("td"));
			for(int i = 0; i<location.size(); i++)
			{
				WebElement row = location.get(i);
				
				for (WebElement anchor: row.findElements(By.tagName("a"))) {

					if (anchor.getAttribute("title").equals("London")) {
						found = true;

						WebElement btnWrapper = row.findElement(By.cssSelector(".col-md-3.col-xs-4.col-sm-4.go-left.pull-right.price_tab"));
						WebElement ele = btnWrapper.findElement(By.tagName("a"));
						WebElement element = driver.findElement(By.id("collapse4"));
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
						
						WebDriverWait waity = new WebDriverWait(driver, 10);
						waity.until(ExpectedConditions.visibilityOf(ele));
						ele.click();
						break;
					}
				}
				if (found) break;
			}
			if (found) break;
			counter++;
			WebElement pageNumList = driver.findElement(By.className("pagination"));
			List<WebElement> pageNums = pageNumList.findElements(By.tagName("li"));
			for (WebElement pageNum : pageNums) {

				if(pageNum.getText().equals(""+counter)) {
					pageNum.findElement(By.tagName("a")).click();
					break;
				}
			}
		}
			
			
				
				
//				if(ele.getText().contains("london")) {
//					WebElement details = driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[5]/div/div[3]/div[1]/div/table/tbody/tr[1]/td/div[3]/a/button"));
//					details.click();
//					break;
//				}
//				else {
//					WebElement next = driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[5]/div/div[3]/div[2]/ul/li[5]/a"));
//					next.click();
//				}
//			}
			
//			location = driver.findElements(By.xpath("//*[@id=\"body-section\"]/div[5]/div/div[3]/div[1]/div/table/tbody/tr[1]/td"));
//		}
	
	
	}

}
