package org.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPom extends Baseclass {
	
	public LoginPom() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="username")
	private WebElement user;
	@FindBy(id="password")
	private WebElement pass;
	@FindBy(id="username")
	private WebElement user1;
	@FindBy(id="password")
	private WebElement pass1;
	@FindBy(id="login")
	private WebElement login;
	public WebElement getUser() {
		return user;
	}
	public WebElement getPass() {
		return pass;
	}
	public WebElement getUser1() {
		return user1;
	}
	public WebElement getPass1() {
		return pass1;
	}
	public WebElement getLogin() {
		return login;
	}
	

}
