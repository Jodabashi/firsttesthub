package com.learning.automation.test;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.automation.base.Base;

public class UpdatedMorgageCalculatorTests extends Base{

	private String websiteURL = "https://www.mortgagecalculator.net/";	
		
	
	@Test
	public void buyATownHouseTest() {
		// navigate to the website url
		myLibrary.gotoWebsite(websiteURL);		
		//myLibrary.delay(2);
		
		// get website title and verify it		
		String actualTitle = myLibrary.getWebsiteTitle();		
		System.out.println("website title: " + actualTitle);
		String expectedTitle = "Mortgage Calculator 2024 - FREE Calculator Tool (ZERO Ads)";		
		assertEquals(actualTitle, expectedTitle);
				
		// Step1: locating morgage amount text field		
		myLibrary.enterText(By.id("amount"), "900000");
		//myLibrary.delay(2);
				
		// Step2: locating interest rate text field
		myLibrary.enterText(By.name("rate"), "7");		
		//myLibrary.delay(2);
		
		// Step3.1: locating Amortization Period - year text field
		myLibrary.enterText(By.id("amortizationYears"), "29");		
		//myLibrary.delay(2);
		
		// Step3.2: locating Amortization Period - month text field
		myLibrary.enterText(By.id("amortizationMonths"), "10");		
		//myLibrary.delay(2);
		
		// Step4.1: locating Start date - month
		myLibrary.selectDropDown(By.id("startMonth"), "9");	
		//myLibrary.delay(2);		
		
		// Step4.2: locating Start date - year
		myLibrary.selectDropDown(By.id("startYear"), "2026");
		//myLibrary.delay(2);		
		
		// Step5.1: locating interest term - years
		myLibrary.enterText(By.id("interestTermYears"), "45");	
		//myLibrary.delay(2);
		
		// Step5.2: locating interest term - months
		myLibrary.enterText(By.id("interestTermMonths"), "11");		
		//myLibrary.delay(2);
		
		// Step6: locating payment period - semi-monthly 
		myLibrary.selectDropDown(By.id("paymentMode"), "Semi-Monthly");		
		//myLibrary.delay(2);
		
		// Step7: locating interest type - fixed
		myLibrary.selectDropDown(By.id("interestType"), "Fixed");	
		//myLibrary.delay(2);
		
		
		// Step8: locating CalculateNow button and Click
		myLibrary.clickButton(By.cssSelector("#button"));		
		
		// we delay selenium for 5 seconds to let browser displays the result data
		myLibrary.delay(5);
		
		// locate the area first		
		assertEquals(getMonthlyPaymentAmount(), "$5,997.78");
	}
	
	// helper method
	private String getMonthlyPaymentAmount() {
		String paymentAmount = null;
		
		WebElement reslutBoxAreaElem = driver.findElement(By.className("resultBox"));
		List<WebElement> liList =  reslutBoxAreaElem.findElements(By.tagName("li"));
		// extract the first li element from the list
		WebElement firstLiElem = liList.get(0);
		WebElement inputElem = firstLiElem.findElement(By.tagName("input"));
		String actualMonthlyPayment = inputElem.getAttribute("value");
		System.out.println("actual monthly payment is: " + actualMonthlyPayment);
		paymentAmount = actualMonthlyPayment;
		
		return paymentAmount;
	}
	
}

// https://www.pluralsight.com/resources/blog/guides/getting-started-with-page-object-pattern-for-your-selenium-tests
// this website is recommended to improve skills after working 




