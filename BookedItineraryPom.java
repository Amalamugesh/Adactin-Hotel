package org.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookedItineraryPom extends Baseclass {

	public BookedItineraryPom() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="(//input[@type='button'])[1]")
	private WebElement cancelorder;
	@FindBy(id="order_id_text")
	private WebElement SearchOrderId;
	@FindBy(id="search_hotel_id")
	private WebElement Gobtn;
	@FindBy(id="search_result_error")
	private WebElement Text;

	public WebElement getCancelorder() {
		return cancelorder;
	}
	public WebElement getSearchOrderId() {
		return SearchOrderId;
	}
	public WebElement getGobtn() {
		return Gobtn;
	}
	public WebElement getText() {
		return Text;
	}




































}