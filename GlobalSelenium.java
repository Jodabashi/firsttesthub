package com.automation.libraries;


import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GlobalSelenium {

	private WebDriver driver;
	
	public WebDriver startAChromeBrowser() {
		driver = new ChromeDriver();
		delay(5);
		driver.manage().window().maximize();		
		return driver;
	}
	
	public void cleanUpAfterEachTest() {
		delay(5);
		// close the browser
		driver.close();
		// kill the driver object or process
		driver.quit();
	}
	
	public void gotoWebsite(String url) {
		driver.get(url);
	}
	
	public String getWebsiteTitle() {
		String title = null;
		title = driver.getTitle();
		return title;
	}
	
	public void enterText(By by, String textValue) {
		WebElement element = driver.findElement(by);		
		element.clear();
		element.sendKeys(textValue);
	}
	
	public void selectDropDown(By by, String visibleTextOption) {	
		// this for the basic selector, when appear as a date grid
		WebElement element = driver.findElement(by);
		Select select = new Select(element);
		select.selectByVisibleText(visibleTextOption);		
	}
	
	public void clickButton(By by) {
		WebElement element = driver.findElement(by);
		element.click();
	}
	
	public void delay(double inSeconds) {
		try {
			long millisec = (long)(inSeconds * 1000);			
			Thread.sleep(millisec);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	// to show that the file uploaded in a browser 
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	
	// move the page to the upload - move to an element
	public void scrollIntoView(WebElement element) {		
		Actions actions = new Actions(driver);
		actions.scrollToElement(element);		
		//actions.moveToElement(element);	
		actions.build().perform();
	}
	
	public void fileUpload(By by, String uploadFilePath) {
		WebElement uploadElem = driver.findElement(by);		
		scrollIntoView(uploadElem);
		//delay(3);		
		String abPath = getAbsuluteFilePath(uploadFilePath);		
		uploadElem.sendKeys(abPath);
	}
	
	
	
	
	
	
	
	////////////////////// this is java utility methods///
	//////////// temporarily we will have them here //////
	
	public String getAbsuluteFilePath(String relativePath) {
		String finalPath = null;		
		File file = new File(relativePath);
		// getAbsolutePath is a JAVA method to locate the path in anywhere the file move, like if it moved to server
		finalPath = file.getAbsolutePath();		
		System.out.println("file full path: " + finalPath);
		return finalPath;
		
	}
}



