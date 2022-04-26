package org.adactin;

import java.io.IOException;

import org.checkerframework.checker.units.qual.g;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdactinTestNGUsingDataDriven extends Baseclass {
	
	
	@BeforeClass
    private void lanchbrowser() {
		
		getChromedriver();
		geturl("https://adactinhotelapp.com/");
	}
	
	@BeforeMethod
	private void statrtTime() {
		
		togetDate();
		togetStarttime();
		

	}
	
	@Test
	private void test() throws IOException, InterruptedException {
		 int i =1;
			String path = "C:\\Users\\A\\eclipse-workspace\\Myproject\\Excel\\Adactin.xlsx";
			LoginPom ln = new LoginPom();
			sendkeys(ln.getUser(),ReadExcel(path, "sheet1", i, 0) );
			Assert.assertEquals("to validate the username ", "amalamugesh",togetattribute(ln.getUser()));
			sendkeys(ln.getPass(), ReadExcel(path, "sheet1", i, 1));
			click(ln.getLogin());
			SearchHotelPom hotel = new SearchHotelPom();
			dropDownByValue(hotel.getLocation(), ReadExcel(path, "sheet1", i, 2));
			clear(hotel.getChkInDate());
			dropDownByValue(hotel.getHotels(), ReadExcel(path, "sheet1", i, 3));
			dropDownByValue(hotel.getRoomType(), ReadExcel(path, "sheet1", i, 4));
			dropDownByValue(hotel.getNumberofRoom(), ReadExcel(path, "sheet1", i, 5));
			sendkeys(hotel.getChkInDate(), ReadExcel(path, "sheet1", i, 6));
			clear(hotel.getChkOutDate());
			sendkeys(hotel.getChkOutDate(), ReadExcel(path, "sheet1", i, 7));
			dropDownByValue(hotel.getAdutlsPerRoom(), ReadExcel(path, "sheet1", i, 8));
			dropDownByValue(hotel.getChildPerRoom(), ReadExcel(path, "sheet1", i, 9));
			click(hotel.getSearch());

			Select_Hotel_pagePom hp = new Select_Hotel_pagePom();
			click(hp.getRadio());
			click(hp.getContinuebutton());

			Book_a_hotel bh = new Book_a_hotel();
			sendkeys(bh.getFirstname(), ReadExcel(path, "sheet1", i, 10));
			sendkeys(bh.getLastname(), ReadExcel(path, "sheet1", i, 11));
			sendkeys(bh.getBillingaddress(), ReadExcel(path, "sheet1", i, 12));
			sendkeys(bh.getCreditcardno(), ReadExcel(path, "sheet1", i,13));
			dropDownByValue(bh.getCreditcardType(), ReadExcel(path, "sheet1", i, 14));
			dropDownByValue(bh.getExpirymonth(), ReadExcel(path, "sheet1", i, 15));
			dropDownByValue(bh.getExpiryyear(), ReadExcel(path, "sheet1", i, 16));
			sendkeys(bh.getCCV(), ReadExcel(path, "sheet1", i, 17));
			click(bh.getBooknow());
			Thread.sleep(5000);

			Book_confirmationPom bc = new Book_confirmationPom();
			String getattribute = togetattribute(bc.getOrder_no());
			writeexcel(path, "sheet1", i, 18, getattribute);
			
			click(bc.getMy_itinerary());
			
			BookedItineraryPom BI = new BookedItineraryPom();
			click(BI.getCancelorder());
			alretaccept();
			String togetText = togetText(BI.getText());
			writeexcel(path, "sheet1", i, 19, togetText);
			sendkeys(BI.getSearchOrderId(), getattribute);
			click(BI.getGobtn());
			

	}
	
	
	@AfterMethod
	private void endtime() {
		
	togetEndTime();
	

		
	}
	
	@AfterClass
	private void quit() {
		closeBrowser();

	}
	
	
	
	
	
	

}
