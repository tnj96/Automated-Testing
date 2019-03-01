package com.qa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewUserPage 
{
	@FindBy(className = "username")
	private WebElement username;
	
	@FindBy(className = "password")
	private WebElement password;
	
	@FindBy(className = "FormsButton2")
	private WebElement submitBtn;
	
	public void addUser(String user, String pass)
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		submitBtn.click();
	}
}
