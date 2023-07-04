package com.nyka.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nyka.base.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//a[@href='https://www.nykaa.com/sp/mom-and-baby-native/mom-and-baby']")
	private WebElement mom_and_baby;
	
	@FindBy(xpath = "//a[text()='Baby Powder']")
	private WebElement baby_powder;

	public WebElement getMom_and_baby() {
		return mom_and_baby;
	}

	public WebElement getBaby_powder() {
		return baby_powder;
	}
	
	
	
	
	

}
