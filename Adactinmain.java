package org.adactin;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import java.lang.String;

public class Adactinmain extends Baseclass {



	public static void main(String[] args) throws InterruptedException, IOException {
        
		
		for (int j = 1; j < 19; j++) {
		
		getChromedriver();
		geturl("https://adactinhotelapp.com/");
		String path = "C:\\Users\\A\\eclipse-workspace\\Myproject\\Excel\\Adactin.xlsx";
		
			for (int i = 1; i <= j; i++) {
				
			
		LoginPom ln = new LoginPom();
		sendkeys(ln.getUser(),ReadExcel(path, "sheet1", i, 0) );
		sendkeys(ln.getPass(), ReadExcel(path, "sheet1", i, 1));
		click(ln.getLogin());
		SearchHotelPom hotel = new SearchHotelPom();
		dropDownByValue(hotel.getLocation(), ReadExcel(path, "sheet1", i, 2));
		clear(hotel.getChkInDate());
		dropDownByValue(hotel.getHotels(), ReadExcel(path, "sheet1", i, 3));
		dropDownByValue(hotel.getRoomType(), ReadExcel(path, "sheet1", i, 4));
		dropDownByValue(hotel.getNumberofRoom(), ReadExcel(path, "sheet1", i, 5));
		sendkeys(hotel.getChkInDate(), "18/04/2022");
		clear(hotel.getChkOutDate());
		sendkeys(hotel.getChkOutDate(), "19/04/2022");
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
		closeBrowser();
		
			
		}
		}
		}
	}
