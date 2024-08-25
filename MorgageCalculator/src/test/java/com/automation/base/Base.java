package com.automation.base;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.libraries.GlobalSelenium;

public class Base {

	public WebDriver driver;
	public GlobalSelenium myLibrary;
	
	@BeforeMethod
	public void beforeEachTest() {
		myLibrary = new GlobalSelenium();
		driver = myLibrary.startAChromeBrowser();
	}

	@AfterMethod
	public void afterEachTest() {
		myLibrary.cleanUpAfterEachTest();
	}
	
	
}
