package org.adactin;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Select_Hotel_pagePom extends Baseclass {
    
	public Select_Hotel_pagePom() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id="radiobutton_0")
	private WebElement radio;
	
	@FindBy(id="continue")
	private WebElement continuebutton;

	public WebElement getRadio() {
		return radio;
	}

	public WebElement getContinuebutton() {
		return continuebutton;
	}
	
	
	

}
