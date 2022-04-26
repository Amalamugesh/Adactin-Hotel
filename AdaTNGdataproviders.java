package org.adactin;

import org.Facebook.Login;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdaTNGdataproviders extends Baseclass {
	

	
		@Test(dataProvider=  "lanch",dataProviderClass = Dataproviders.class)
		private void lanch(String username,String password) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		
			geturl("https://www.adactinhotelapp.com/");
			LoginPom lg = new LoginPom();
			sendkeys(lg.getUser(), username);
			sendkeys(lg.getPass(), password);
			click(lg.getLogin());
			
		
		}
//		@Test(priority =1,dataProvider =  "login",dataProviderClass = Dataproviders.class)
//		private void Login(String username,String password) {
//			
//			geturl("https://www.adactinhotelapp.com/");
//			LoginPom lg = new LoginPom();
//			sendkeys(lg.getUser(), username);
//			sendkeys(lg.getPass(), password);
//			click(lg.getLogin());
//			
//		
//		
//		}
}

