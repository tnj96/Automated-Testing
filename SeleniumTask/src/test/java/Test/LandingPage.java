package Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage 
{
	@FindBy(id = "search_query_top")
	private WebElement searchbox;
	
	public void searchFor(String searchText) {
		searchbox.sendKeys(searchText);
		searchbox.submit();
	}

}
