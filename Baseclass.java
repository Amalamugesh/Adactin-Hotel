package org.adactin;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static String String;
	// 1
	protected static WebDriver driver;

	public static void getChromedriver() { // 2
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		driver = new ChromeDriver(options);
	}
	public static void getFireFoxdriver() { // 2
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
		public static void geturl(String url) { // 3
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static WebElement findElementByxpath(String locator) { // 4

		WebElement Element = driver.findElement(By.xpath(locator));
		return Element;
		
	}

	public static WebElement findElementByclassname(String locator) { // 5
		WebElement Element = driver.findElement(By.className(locator));
		return Element;
	}

	public static WebElement findElementByname(String locator) { // 5
		WebElement Element = driver.findElement(By.name(locator));
		return Element;
	}

	public static WebElement findElementByID(String locator) { // 5
		WebElement Element = driver.findElement(By.id(locator));
		return Element;
	}

	public static void sendkeys(WebElement element, String data) {

		element.sendKeys(data);
	}

	public static void clear(WebElement element) {
		element.clear();

	}

	public static void click(WebElement element) {
		element.click();

	}
	
	
	public static void scrolldown(WebElement Ele_ref) { // 8
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Ele_ref);
	}

	public static void scrollup(WebElement Ele_ref) { // 9
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", Ele_ref);
		
	}

	public static WebElement javascriptSetAttribute(WebElement element, String input) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value',input)", element);
		return element;

	}

	public static void toGetWindow(int index) { // 10
		String par = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> l = new ArrayList<String>();
		l.addAll(windowHandles);
		driver.switchTo().window(l.get(index));
	}

	public void screenShotrobot(String path) throws AWTException, IOException { // 11

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage Sourcefile = robot.createScreenCapture(rectangle);
		File destinatiofile = new File(path);
		ImageIO.write(Sourcefile, "jpeg", destinatiofile);
	}

	public void mouseover(WebElement locator) { // 16
		Actions action = new Actions(driver);
		action.moveToElement(locator).perform();

	}

	public void dragAndDrop(WebElement Source_locator, WebElement target_locator) { // 17
		Actions action = new Actions(driver);
		action.dragAndDrop(Source_locator, target_locator);

	}

	public static String ReadExcel(String path, String sheetName, int rowindex, int cellindex) throws IOException { // 7
		String data = null;
		File file = new File(path);
		FileInputStream Fls = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(Fls);
		Sheet sheet = w.getSheet(sheetName);
		Row row = sheet.getRow(rowindex);
		Cell cell = row.getCell(cellindex);
		int type = cell.getCellType();
		if (type == 1) {
			data = cell.getStringCellValue();
		} else if (type == 0) {

			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
				data = dateformat.format(dateCellValue);
			} else {
				double d = cell.getNumericCellValue();
				long l = (long) d;
				data = String.valueOf(l);
			}
		}

		return data;

	}

	public static void writeexcel(String path, String sheetName, int rowvalue, int cellvalue, String value)
			throws IOException {

		File file = new File(path);
		FileInputStream fln= new  FileInputStream(file);
		Workbook w = new XSSFWorkbook(fln);
		Sheet s = w.getSheet(sheetName);
		Row r = s.getRow(rowvalue);
		Cell c = r.createCell(cellvalue);
		c.setCellValue(value);
	    FileOutputStream fout =new FileOutputStream(file);
	    w.write(fout);

	}

	public static void updateExcel(String path, String Sheetname, int index, int index1, String valueNeedtoBereplace,
			String ValueneedToBeupdated) throws IOException {

		File file = new File(path);
		FileInputStream fln = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fln);
		Sheet s = w.getSheet(Sheetname);
		Row row = s.getRow(index);
		Cell cell = row.getCell(index1);
		String Value = cell.getStringCellValue();

		if (Value.contains(valueNeedtoBereplace)) {

			cell.setCellValue(ValueneedToBeupdated);
		}

		FileOutputStream fOut = new FileOutputStream(file);
		w.write(fOut);

	}

	public static void dropDownByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	public static void dropDownByValue(WebElement element, String Value) {
		Select select = new Select(element);
		select.selectByValue(Value);

	}

	public static void dropDownByVisibletext(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);

	}

	public static String togetText(WebElement element) {

		String text = element.getText();
		return text;
	}

	public static String togetattribute(WebElement element) {

		String attribute = element.getAttribute("value");
		return attribute;

	}

	public static void alretaccept() {
		driver.switchTo().alert().accept();

	}
	
	public static void alretReject() {
		
		driver.switchTo().alert().dismiss();
	}
	
	
	public static void uploadfile(String Filelocation) throws AWTException {

    StringSelection selection = new StringSelection(Filelocation);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void closeBrowser() {
		driver.close();

	}
	public static Date togetDate() {
		Date d =new Date();
		System.out.println("StartDate :"+ d);
		return d;

	}
	public static long togetStarttime() {
		
		long StartTime = System.currentTimeMillis();
 	   System.out.println("StartTime: "+StartTime);
	return StartTime;
      
	}
	public static long togetEndTime() {
		
		long endtym = System.currentTimeMillis();
 	   System.out.println("EndTime: "+endtym);
	     return endtym;

	}
	
	public static void toEnter() throws AWTException {
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
	
	public static void ImWait(int sec) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(sec));

	}
	

	}
	

	

