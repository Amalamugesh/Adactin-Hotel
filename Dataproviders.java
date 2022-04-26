package org.adactin;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviders {

	@DataProvider(name="lanch")
	public Object[][] lanch() {
	
		return new Object[][] {{"amalamugesh","Kebalevijo@007"},{"nanjilrk","Nanjil@31"}};
	}
	
//	@DataProvider(name="login")
//	public Object[][] login() {
//		
//		return new Object[][] {{"amalamugesh","Kebalevijo@007"},{"nanjilrk","Nanjil@31"}};
//	}

}


