package com.qa.cucumber;

import java.awt.Window;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Applications/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void teardown(){
		driver.quit();
	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address() throws Throwable {
		driver.get("http://www.practiceselenium.com/welcome.html");
		driver.manage().window().maximize();
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() throws Throwable {
	    WebElement menu = driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a"));
	    menu.click();
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() throws Throwable {
		WebElement menu = driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a"));
		assertEquals("", "http://www.practiceselenium.com/menu.html", driver.getCurrentUrl());
		
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() throws Throwable {
	    WebElement checkoutBtn = driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a"));
	    checkoutBtn.click();
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() throws Throwable {
	   assertEquals("", "http://www.practiceselenium.com/check-out.html", driver.getCurrentUrl());
	}

}
