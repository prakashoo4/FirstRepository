package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static void getDriver(String url) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	// Locaters

	public static WebElement locaterId(String id) {
		WebElement findElement = driver.findElement(By.id(id));
		return findElement;
	}

	public static WebElement locatername(String name) {
		WebElement findElement = driver.findElement(By.name(name));
		return findElement;
	}

	public static WebElement locaterXpath(String xpath) {
		WebElement findElement = driver.findElement(By.xpath(xpath));
		return findElement;
	}

	public static void buttonClick(WebElement findElement) {
		findElement.click();
	}

	// ScreenShot
	public static void ScreenShot(String facebookss) {

		try {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File sourcefile = ts.getScreenshotAs(OutputType.FILE);
			File targetfile = new File("C:\\Users\\ELCOT\\Documents\\ScreenShots mvn" + facebookss + ".png");
			FileUtils.copyFile(sourcefile, targetfile);
			System.out.println("ScreenShot Saved Successfully");

		} catch (Exception e) {

		}
	}
	// Alert

	public static void SimpleAlert() {

		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void confirmAlertaccept() {

		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void comfirmAlertdismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public static void promptAlertaccept(String keysToSend) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(keysToSend);
		alert.accept();
	}

	public static void promptAlertdismiss(String keysToSend) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(keysToSend);
		alert.dismiss();
	}

	// Actions


	public static void mouseoverAction(WebElement FindElement) {

		Actions act = new Actions(driver);
		act.moveToElement(FindElement).perform();
	}

	public static void doubleClick(WebElement findElement) {

		Actions act = new Actions(driver);
		act.doubleClick(findElement).perform();
	}

	public static void rightClick(WebElement findElement) {

		Actions act = new Actions(driver);
		act.contextClick(findElement).perform();
	}

	public static void dragAndDrop(WebElement source, WebElement target) {

		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();

	}

	// Select

	public static void byIndex(WebElement findElement, int index) {

		Select s = new Select(findElement);
		s.selectByIndex(index);
	}

	public static void byValue(WebElement findElement, String value) {

		Select s = new Select(findElement);
		s.selectByValue(value);
	}

	public static void byVisibleText(WebElement findElement, String text) {

		Select s = new Select(findElement);
		s.selectByVisibleText(text);
	}
	
	// Data Driven Excell
	public static String readExcel( String filename,String sheetname,int rowNumber, int cellNumber) {
		String Value = null;
		try {
			File file = new File("C:\\Users\\ELCOT\\Documents\\Excel Files\\"+filename+".xlsx");

			FileInputStream stream = new FileInputStream(file);

			@SuppressWarnings("resource")
			Workbook book = new XSSFWorkbook(stream);

			Sheet sheet = book.getSheet(sheetname);

			Row row = sheet.getRow(rowNumber);

			Cell cell = row.getCell(cellNumber);

			CellType cellType = cell.getCellType();
			
			switch (cellType) {
			case STRING:
				Value = cell.getStringCellValue();

				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
					Value = simple.format(dateCellValue);

				} else {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					BigDecimal valueOf = BigDecimal.valueOf(l);
					Value = valueOf.toString();
				}
				break;

			default:
				System.out.println("None");

				break;

			}
			return Value;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return Value;
	}
	
	// Frames
	public static void switchToFrame(WebElement findElement) {
		driver.switchTo().frame(findElement);
	}
	// Navigation commands - pass URL
	public static void toNavigateToAnotherURL(String url) {
		driver.navigate().to(url);
	}
	// Navigation commands - to Back the WebPage
	public static void toGetBackThePreviousWebPage() {
		driver.navigate().back();
	}
	// Navigation commands - to Forward the WebPage
	public static void toForwardTheWebPage() {
		driver.navigate().forward();
	}
	// Navigation commands - to Refresh the WebPage
	
	public static void toRefreshTheWebPage() {
		driver.navigate().refresh();
	}

	public static void A_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
	}
	// Robot - B
	public static void B_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_B);
		r.keyRelease(KeyEvent.VK_B);
	}
	// Robot - C
	public static void C_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);
	}
	// Robot - D
	public static void D_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_D);
	}
	// Robot - E
	public static void E_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_E);
		r.keyRelease(KeyEvent.VK_E);
	}
	// Robot - F
	public static void F_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_F);
		r.keyRelease(KeyEvent.VK_F);
	}
	// Robot - G
	public static void G_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_G);
		r.keyRelease(KeyEvent.VK_G);
	}
	// Robot - H
	public static void H_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_H);
		r.keyRelease(KeyEvent.VK_H);
	}
	// Robot - I
	public static void I_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_I);
		r.keyRelease(KeyEvent.VK_I);
	}
	// Robot - J
	public static void J_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_J);
		r.keyRelease(KeyEvent.VK_J);
	}
	// Robot - K
	public static void K_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_K);
		r.keyRelease(KeyEvent.VK_K);
	}
	// Robot - L
	public static void L_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_L);
		r.keyRelease(KeyEvent.VK_L);
	}
	// Robot - M
	public static void M_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_M);
		r.keyRelease(KeyEvent.VK_M);
	}
	// Robot - N
	public static void N_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_N);
	}
	// Robot - O
	public static void O_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_O);
		r.keyRelease(KeyEvent.VK_O);
	}
	// Robot - P
	public static void P_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_P);
		r.keyRelease(KeyEvent.VK_P);
	}
	// Robot - Q
	public static void Q_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_Q);
		r.keyRelease(KeyEvent.VK_Q);
	}
	// Robot - R
	public static void R_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_R);
		r.keyRelease(KeyEvent.VK_R);
	}
	// Robot - S
	public static void S_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_S);
	}
	// Robot - T
	public static void T_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_T);
	}
	// Robot - U
	public static void U_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_U);
		r.keyRelease(KeyEvent.VK_U);
	}
	// Robot - V
	public static void V_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
	}
	// Robot - W
	public static void W_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_W);
		r.keyRelease(KeyEvent.VK_W);
	}
	// Robot - X
	public static void X_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_X);
	}
	// Robot - Y
	public static void Y_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_Y);
		r.keyRelease(KeyEvent.VK_Y);
	}
	// Robot - Z
	public static void Z_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_Z);
		r.keyRelease(KeyEvent.VK_Z);
	}
	// Robot - 0
	public static void Zero_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_0);
		r.keyRelease(KeyEvent.VK_0);
	}
	// Robot - 1
	public static void One_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_1);
		r.keyRelease(KeyEvent.VK_1);
	}
	// Robot - 2
	public static void Two_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_2);
		r.keyRelease(KeyEvent.VK_2);
	}
	// Robot - 3
	public static void Three_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_3);
		r.keyRelease(KeyEvent.VK_3);
	}
	// Robot - 4
	public static void Four_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_4);
		r.keyRelease(KeyEvent.VK_4);
	}
	// Robot - 5
	public static void Five_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_5);
		r.keyRelease(KeyEvent.VK_5);
	}
	// Robot - 6
	public static void Six_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_6);
		r.keyRelease(KeyEvent.VK_6);
	}
	// Robot - 7
	public static void Seven_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_7);
		r.keyRelease(KeyEvent.VK_7);
	}
	// Robot - 8
	public static void Eight_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_8);
		r.keyRelease(KeyEvent.VK_8);
	}
	// Robot - 9
	public static void Nine_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_9);
		r.keyRelease(KeyEvent.VK_9);
	}
	// Robot - Exclamation
	public static void Exclamation_Robot() throws AWTException{
		Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_1);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_1);
	}
	// Robot - At
	public static void At_Robot() throws AWTException{
		Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_2);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_2);
	}
	// Robot - Hash
	public static void Hash_Robot() throws AWTException{
		Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_3);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_3);
	}
	// Robot - Dollar
	public static void Dollar_Robot() throws AWTException{
		Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_4);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_4);
	}
	// Robot - Percent
	public static void Percent_Robot() throws AWTException{
		Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_5);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_5);
	}
	// Robot - Exponential
	public static void Exponential_Robot() throws AWTException{
		Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_6);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_6);
	}
	// Robot - Ambersand
	public static void Ampersand_Robot() throws AWTException{
		Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_7);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_7);
	}
	// Robot - Asterisk
	public static void Asterisk_Robot() throws AWTException{
		Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_8);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_8);
	}
	// Robot - Open Bracket
	public static void OpenBracket_Robot() throws AWTException{
		Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_9);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_9);
	}
	// Robot - Closed Bracket
	public static void ClosedBracket_Robot() throws AWTException{
		Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_0);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_0);
	}
	// Robot - Tab
	public static void Tab_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	// Robot - Capslock
	public static void Capslock_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CAPS_LOCK);
		r.keyRelease(KeyEvent.VK_CAPS_LOCK);
	}
	// Robot - Alt
	public static void Alt_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ALT);
		r.keyRelease(KeyEvent.VK_ALT);
	}
	// Robot - Space
	public static void Sapce_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_SPACE);
		r.keyRelease(KeyEvent.VK_SPACE);
	}
	// Robot - BackSpace
	public static void Backspace_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
	}
	// Robot - Backquote
	public static void Backquote_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_BACK_QUOTE);
		r.keyRelease(KeyEvent.VK_BACK_QUOTE);
	}
	// Robot - BackSlash
	public static void Backslash_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_BACK_SLASH);
		r.keyRelease(KeyEvent.VK_BACK_SLASH);
	}
	// Robot - Underscore
	public static void Underscore_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_UNDERSCORE);
		r.keyRelease(KeyEvent.VK_UNDERSCORE);
	}
	// Robot - Dot
	public static void Dot_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PERIOD);
		r.keyRelease(KeyEvent.VK_PERIOD);
	}
	// Robot - Enter
	public static void Enter_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	// Robot - Escape
	public static void Escape_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
	}
	// Robot - Slash
	public static void Slash_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_SLASH);
		r.keyRelease(KeyEvent.VK_SLASH);
	}
	// Robot - Add
	public static void Add_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ADD);
		r.keyRelease(KeyEvent.VK_ADD);
	}
	// Robot - Subtract
	public static void Subtract_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_SUBTRACT);
		r.keyRelease(KeyEvent.VK_SUBTRACT);
	}
	// Robot - Divide
	public static void Divide_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DIVIDE);
		r.keyRelease(KeyEvent.VK_DIVIDE);
	}
	// Robot - Equal
	public static void Equal_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_EQUALS);
		r.keyRelease(KeyEvent.VK_EQUALS);
	}
	// Robot - colon
	public static void Colon_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_COLON);
		r.keyRelease(KeyEvent.VK_COLON);
	}
	// Robot - Semicolon
	public static void Semicolon_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_SEMICOLON);
		r.keyRelease(KeyEvent.VK_SEMICOLON);
	}
	// Robot - Home
	public static void Home_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_HOME);
		r.keyRelease(KeyEvent.VK_HOME);
	}
	// Robot - End
	public static void End_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_END);
		r.keyRelease(KeyEvent.VK_END);
	}
	// Robot - PageUp
	public static void PageUp_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
	}
	// Robot - PageDown
	public static void PageDown_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}
	// Robot - Up
	public static void Up_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}
	// Robot - Down
	public static void Down_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	// Robot - Right
	public static void Right_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_RIGHT);
		r.keyRelease(KeyEvent.VK_RIGHT);
	}
	// Robot - Left
	public static void Left_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
	}
	// Robot - NumLock
	public static void NumLock_Robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_NUM_LOCK);
		r.keyRelease(KeyEvent.VK_NUM_LOCK);
	}
}



