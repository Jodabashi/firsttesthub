package com.learning.automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.base.Base;

public class FileUploadTest extends Base{

	private String uploadWebsiteURL = "https://html.com/input-type-file/";
	
	@Test(enabled = false)
	public void fileUploadTest1() {
		myLibrary.gotoWebsite(uploadWebsiteURL);
		
		WebElement uploadElem = driver.findElement(By.id("fileupload"));
		//myLibrary.scrollToElement(uploadElem);
		myLibrary.scrollIntoView(uploadElem);
		myLibrary.delay(3);		
		String abPath = myLibrary.getAbsuluteFilePath("src/test/resources/testData.txt");		
		uploadElem.sendKeys(abPath);		
	}
	
	@Test(enabled = true)
	public void fileUploadTest2() {
		myLibrary.gotoWebsite(uploadWebsiteURL);
		myLibrary.fileUpload(By.id("fileupload"), "src/test/resources/testData.txt");
			
	}
	
}




