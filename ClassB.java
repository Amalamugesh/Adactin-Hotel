package org.adactin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClassB extends Baseclass {
	@Test()

	private void login() {
		getChromedriver();
		geturl("https://www.facebook.com/");
		WebElement user = findElementByID("email");
		user.sendKeys("9952623804");
		WebElement pass = findElementByID("pass");
		pass.sendKeys("Kebalevijo@007");
		findElementByname("login").click();
	}

//	@Test(priority =2)
//
//	private void Sera() {
//		SearchHotelPom hotel = new SearchHotelPom();
//		dropDownByValue(hotel.getLocation(), "Sydney" );
//		clear(hotel.getChkInDate());
//		dropDownByValue(hotel.getHotels(),"Hotel Creek" );
//		dropDownByValue(hotel.getRoomType(),"Standard");
//		dropDownByValue(hotel.getNumberofRoom(),"2" );
//		sendkeys(hotel.getChkInDate(),"25/04/2022" );
//		clear(hotel.getChkOutDate());
//		sendkeys(hotel.getChkOutDate(),"26/04/2022" );
//		dropDownByValue(hotel.getAdutlsPerRoom(),"2" );
//		dropDownByValue(hotel.getChildPerRoom(),"0" );
//		click(hotel.getSearch());
//		Select_Hotel_pagePom hp = new Select_Hotel_pagePom();
//		click(hp.getRadio());
//		click(hp.getContinuebutton());
//	}
//	@Test(priority=3)
//		 private void Booking() throws InterruptedException {
//		Book_a_hotel bh = new Book_a_hotel();
//		sendkeys(bh.getFirstname(), "AmalaMugesh");
//		sendkeys(bh.getLastname(), "j");
//		sendkeys(bh.getBillingaddress(), "abakdviasd");
//		sendkeys(bh.getCreditcardno(), "1234567894563214");
//		dropDownByValue(bh.getCreditcardType(),"VISA");
//		dropDownByIndex(bh.getExpirymonth(), 2);
//		dropDownByValue(bh.getExpiryyear(), "2022");
//		sendkeys(bh.getCCV(), "123");
//		click(bh.getBooknow());
//		Thread.sleep(5000);
//		Book_confirmationPom bc = new Book_confirmationPom();
//		String getattribute = togetattribute(bc.getOrder_no());
//		System.out.println(getattribute);
//		click(bc.getMy_itinerary());
//
//
//
//	}


}






