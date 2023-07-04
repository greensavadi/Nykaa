package com.nyka.base;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
//	static Actions a = new Actions(driver);
	
	public static void launchUrl(String url) {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "D:\\Avadi\\workspace\\nyka\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	public static boolean elementDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}
	
	public static boolean elementEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}
	
	public static void clickOnElement(WebElement element) {
		
		if(elementDisplayed(element)) {
			if(elementEnabled(element)) {
				element.click();
			}
		}
	}
	
	public static void input(WebElement element, String value) {
		
		if(elementDisplayed(element)) {
			if(elementEnabled(element)) {
				element.sendKeys(value);
			}
		}
	}
	
	public static void screenShot(String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\screenshots\\"+fileName+".png");
		FileHandler.copy(src, dest);
	}
	
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void explictWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void confirmAlert(String action) {
		if(action.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();
		}else if(action.equalsIgnoreCase("dismiss")){
			driver.switchTo().alert().dismiss();
		}
	}
	
	public static void mouseHover(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();
	}
	
	public static void rightClick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).build().perform();
	}
	
	public static void dragAndDrop(WebElement src, WebElement dest) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, dest).build().perform();
	}
	
	public static void selectDropdown(WebElement element, String option, String value) {
		
		Select s = new Select(element);
		if(option.equalsIgnoreCase("index")) {
			s.selectByIndex(Integer.parseInt(value));
		}else if (option.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		}else if(option.equalsIgnoreCase("text")){
			s.deselectByVisibleText(value);
		}
	}
	
	public static void frameByIndex(int index) {
		driver.switchTo().frame(index);
	}
	
	public static void frameByIdOrName(String value) {
		driver.switchTo().frame(value);
	}
	
	public static void frameByWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public static void switchToWindow(String windowId) {
		Set<String> all_id = driver.getWindowHandles();
		for(String id : all_id) {
			if(id.equals(windowId)) {
				driver.switchTo().window(id);
			}
		}
		
	}
	
	
	
	
	
	
//	select(element, "index", "3")
	
	
	
	
	
	
	
	
	
	
	//confirmAlert("qwer")
	
	
	
	
	
	
	
	

}
