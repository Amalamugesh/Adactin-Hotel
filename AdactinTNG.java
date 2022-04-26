package org.adactin;


import org.testng.annotations.Parameters;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactinTNG extends Baseclass{
	@Test()
	@Parameters({"Browser","username","password"})
	private void lanch(String Browser,String username,String password) {
		if (Browser.equals("Chrome")){
			getChromedriver();
			 
		}

	else if (Browser.equals("Edge")) {
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
}else if (Browser.equals("FireFox")) {
	getFireFoxdriver();
	
}
		geturl("https://www.adactinhotelapp.com/");
		LoginPom lg = new LoginPom();
		sendkeys(lg.getUser(), username);
		sendkeys(lg.getPass(), password);
		click(lg.getLogin());
		
	}
	
//	 @Test()
//	   @Parameters({})
//		private void login(String username, String password ) {
//		
//		
//	 }
	 
//	 @Test()
//	 @Parameters({"location","Hotel","RoomType","NumberofRooms","CheckInDate","CheckOutDate","AProom","CProom"})
//	 private void Sera(String location,String Hotel ,String RoomType, String NumberofRooms,String CheckInDate,String CheckOutDate, String AProom,String CProom) {
//	
//		SearchHotelPom hotel = new SearchHotelPom();
//		dropDownByValue(hotel.getLocation(), location );
//		clear(hotel.getChkInDate());
//		dropDownByValue(hotel.getHotels(),Hotel );
//		dropDownByValue(hotel.getRoomType(),RoomType);
//		dropDownByValue(hotel.getNumberofRoom(),NumberofRooms );
//		sendkeys(hotel.getChkInDate(),CheckInDate );
//		clear(hotel.getChkOutDate());
//		sendkeys(hotel.getChkOutDate(),CheckOutDate );
//		dropDownByValue(hotel.getAdutlsPerRoom(),AProom );
//		dropDownByValue(hotel.getChildPerRoom(),CProom );
//		click(hotel.getSearch());
//		Select_Hotel_pagePom hp = new Select_Hotel_pagePom();
//		click(hp.getRadio());
//		click(hp.getContinuebutton());
//	 }
//	 @Test()
//	 @Parameters({"Fname","Lname","address","CrdNo","CrdType","Eyear","CVV"})
//	 private void Booking(String Fname,String Lname,String address,String CrdNo,String CrdType,String Eyear,String CVV) throws InterruptedException {
//		 Book_a_hotel bh = new Book_a_hotel();
//			sendkeys(bh.getFirstname(), Fname);
//			sendkeys(bh.getLastname(), Lname);
//			sendkeys(bh.getBillingaddress(), address);
//			sendkeys(bh.getCreditcardno(), CrdNo);
//			dropDownByValue(bh.getCreditcardType(),CrdType);
//			dropDownByIndex(bh.getExpirymonth(), 2);
//			dropDownByValue(bh.getExpiryyear(), Eyear);
//			sendkeys(bh.getCCV(), CVV);
//			click(bh.getBooknow());
//			Thread.sleep(5000);
//			Book_confirmationPom bc = new Book_confirmationPom();
//			String getattribute = togetattribute(bc.getOrder_no());
//			System.out.println(getattribute);
//			click(bc.getMy_itinerary());
//			
//			
//
//	}

	
	}
	 
