package org.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPom extends Baseclass {
	
	public SearchHotelPom() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="location")
	private WebElement location;
	@FindBy(id="hotels")
	private WebElement Hotels;
	@FindBy(id="room_type")
	private WebElement RoomType;
	@FindBy(id="room_nos")
	private WebElement NumberofRoom;
	@FindBy(id="datepick_in")
	private WebElement ChkInDate;
	@FindBy(id="datepick_out")
	private WebElement ChkOutDate;
	
	@FindBy(id="adult_room")
	private WebElement AdutlsPerRoom;
	@FindBy(id="child_room")
	private WebElement ChildPerRoom;
	@FindBy(id="Submit")
	private WebElement search;
	public WebElement getLocation() {
		return location;
	}
	public WebElement getHotels() {
		return Hotels;
	}
	public WebElement getRoomType() {
		return RoomType;
	}
	public WebElement getNumberofRoom() {
		return NumberofRoom;
	}
	public WebElement getChkInDate() {
		return ChkInDate;
	}
	public WebElement getChkOutDate() {
		return ChkOutDate;
	}
	public WebElement getAdutlsPerRoom() {
		return AdutlsPerRoom;
	}
	public WebElement getChildPerRoom() {
		return ChildPerRoom;
	}
	public WebElement getSearch() {
		return search;
	}
	
    
	
	
	

}
