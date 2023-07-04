package com.nyka;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.nyka.base.BaseClass;
import com.nyka.pom.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 extends BaseClass {
	
	public static void main(String[] args) {
		
		HomePage hp;
		launchUrl("https://www.nykaa.com/");
		hp = new HomePage(driver);
		mouseHover(hp.getMom_and_baby());
		
		clickOnElement(hp.getBaby_powder());
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> itr = windowHandles.iterator();
		itr.next();
		String powder_search_tab = itr.next();
		
		switchToWindow(powder_search_tab);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000);");
		
		
		
	}

}
