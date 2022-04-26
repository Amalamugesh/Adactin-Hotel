package org.adactin;

import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdactinJunit extends Baseclass {
   long EndTime;
   static long Starttime;
	@BeforeClass
	public  static void lanch() {
  
		getChromedriver();
		
		Assert.assertTrue("to validate the url", driver.getCurrentUrl().contains("adactin"));
	}
	@Before
	public void StartTym() {
		togetDate();
		long Starttime = togetStarttime();
	}
	@Test
	public void test() throws IOException, InterruptedException {
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
	
	@After
	public  void after() {
		togetDate();

		long EndTime = togetEndTime();
		long TotalTime = EndTime-Starttime;
		System.out.println(TotalTime);


	}
	@AfterClass
	public static void end() {
		closeBrowser();
	}



}
