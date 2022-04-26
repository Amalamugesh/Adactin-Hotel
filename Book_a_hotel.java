package org.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Book_a_hotel extends Baseclass {
	
	public Book_a_hotel() {
		
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="first_name")
	private WebElement firstname;
	
	
	@FindBy(id="last_name")
	private WebElement lastname;
	
	@FindBy(id="address")
	private WebElement billingaddress;
	
	@FindBy(id="cc_num")
	private WebElement creditcardno;
	
	@FindBy(id="cc_type")
	private WebElement creditcardType;
	
	@FindBy(id="cc_exp_month")
	private WebElement expirymonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement expiryyear;
	
	@FindBy(id="cc_cvv")
	private WebElement CCV;
	
	@FindBy(id="book_now")
	private WebElement Booknow;

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getBillingaddress() {
		return billingaddress;
	}

	public WebElement getCreditcardno() {
		return creditcardno;
	}

	public WebElement getCreditcardType() {
		return creditcardType;
	}

	public WebElement getExpirymonth() {
		return expirymonth;
	}

	public WebElement getExpiryyear() {
		return expiryyear;
	}

	public WebElement getCCV() {
		return CCV;
	}

	public WebElement getBooknow() {
		return Booknow;
	}
	
	
	
}
