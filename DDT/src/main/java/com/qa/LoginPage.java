package com.qa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(className = "username")
	private WebElement username;
	
	@FindBy(className = "password")
	private WebElement password;
	
	@FindBy(className = "FormsButton2")
	private WebElement submitBtn;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement loginAttempt;
	
	public void loginUser(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		submitBtn.click();
	}
	
	public String loginAttemptText()
	{
		return loginAttempt.getText();
	}

}
