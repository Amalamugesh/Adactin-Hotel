package org.adactin;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Book_confirmationPom extends Baseclass {
     
	public Book_confirmationPom() {

		PageFactory.initElements(driver, this);
	}

	@FindAll({@FindBy (id = "order_no"),@FindBy(name="order_no")})
	private WebElement order_no;

	@FindBy(id = "my_itinerary")
	private WebElement my_itinerary;

	public WebElement getMy_itinerary() {
		return my_itinerary;
	}

	public WebElement getOrder_no() {
		return order_no;
	}

}
