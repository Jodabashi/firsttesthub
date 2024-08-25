package com.learning.automation.test;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MorgageCalculatorTests {
	
	private String websiteURL = "https://www.mortgagecalculator.net/";
		
	private WebDriver driver;
	
	
	@Test
	
	public void buyATownHouseTest () throws InterruptedException {
		
		//open a Chrome browser
		driver = new ChromeDriver();
		// slow adding values
		Thread.sleep(3*1000);
				
		// maximize the browser window
		driver.manage().window().maximize();
		Thread.sleep(2*1000);
		
		// navigate to the website URL
		driver.get(websiteURL);
		Thread.sleep(2*1000);
		
		// get WebSite title and verify it. when open the web HTML we find it under Hear -- title, then copy and paste it down
		String actualTitle = driver.getTitle();
		System.out.println("website title: " + actualTitle);
		String expectedTitle = "Mortgage Calculator 2024 - FREE Calculator Tool (ZERO Ads)";
				
		assertEquals(actualTitle, expectedTitle);
		
		
		// Step 1 : locating morgage amount text field, by clicking on website over the label of it, right click -inspect-
		// then when select the label it will highlighted in inspect, then find the  Id  "amount' 
		// webElement is a data type in Selenium same as webDriver
		WebElement MorgageAmountElement = driver.findElement(By.id("amount"));
		// clear the value in website
		MorgageAmountElement.clear();
		// sendkeys receive String value only
		MorgageAmountElement.sendKeys("900000");
		//Thread.sleep(2*1000);
		
		// Step 2 : Locating interest rate text field, same but here we will try to find  name  " "
		WebElement intRateElement = driver.findElement(By.name("rate"));
		intRateElement.clear();
		intRateElement.sendKeys("7");
		//Thread.sleep(2*1000);
		
		// step 3.1 : locating Amortization Period - year text field
		WebElement amortYear = driver.findElement(By.id("amortizationYears"));
		amortYear.clear();
		amortYear.sendKeys("29");
		//Thread.sleep(2*1000);
		
		// step 3.2 : locating Amortization Period - month text field
		WebElement amortMonth = driver.findElement(By.id("amortizationMonths"));
		amortMonth.clear();
		amortMonth.sendKeys("10");
		//Thread.sleep(2*1000);
		
		// Step 4.1 : locating Start date - Month
		// we use different type coz we test a selected menu 
		WebElement startMonthElement =  driver.findElement(By.id("startMonth"));
		Select startMonthSelect = new Select (startMonthElement);
		// in the HTML, selectByVisibleText appears out of " ". selectByValue appears inside ""
		startMonthSelect.selectByVisibleText("9");
		//Thread.sleep(2*1000);
		
		// Step 4.1 : locating Start date - Year
		WebElement startYearElement =  driver.findElement(By.id("startYear"));
		Select startYearSelect = new Select (startYearElement);
		startYearSelect.selectByVisibleText("2026");
		//Thread.sleep(2*1000);
		
		// Step 5.1 : Locating interest term -Years
		WebElement intTermYearElement = driver.findElement(By.id("interestTermYears"));
		intTermYearElement.clear();
		intTermYearElement.sendKeys("45");
		//Thread.sleep(2*1000);
		
		// Step 5.2 : Locating interest term -Months
		WebElement intTermMonthElement = driver.findElement(By.id("interestTermMonths"));
		intTermMonthElement.clear();
		intTermMonthElement.sendKeys("11");
		//Thread.sleep(2*1000);
		
		// Step 6 : Locating Payment period
		WebElement paymentPeriodElem = driver.findElement(By.id("paymentMode"));
		Select paymentPeriodSelect = new Select (paymentPeriodElem);
		paymentPeriodSelect.selectByVisibleText("Semi-Monthly");
		//Thread.sleep(2*1000);
		
		// Step 7 : Locating Interest Type - fixed
		WebElement interestTypeElem = driver.findElement(By.id("interestType"));
		Select interestTypeSelect = new Select (interestTypeElem);
		interestTypeSelect.selectByVisibleText("Fixed");
		//Thread.sleep(2*1000);
				
		// Step 8 : Locating CalculatorNow button and Click
		WebElement calculateButtonElem = driver.findElement(By.cssSelector("#button"));
		calculateButtonElem.click();
		
		
		// we have to delay Selenium for 5Sec at least to get the test result otherwise we get the web defult value
		Thread.sleep(5*1000);
		
		
		
		// To evaluate the test with the expecting result
		
		// locate the area first 
		WebElement resultBoxAreaElem = driver.findElement(By.className("resultBox"));
		List<WebElement> liList = resultBoxAreaElem.findElements(By.tagName("li"));
		
		// extract the first li element from the list
		WebElement fistLiElem = liList.get(0);
		WebElement inputElem =  fistLiElem.findElement(By.tagName("input"));
		String actualMonthlyPayment = inputElem.getAttribute("value");
		System.out.println("actual Monthly payment is: " + actualMonthlyPayment);
		
		assertEquals(actualMonthlyPayment, "$5,997.78");
		
		
		
		
		
				
		// pause the running program- selenium, delay 10 seconds
		Thread.sleep(10*1000);
		
		
		// close the browser - WebDriver object still alive , we need to do the next also
		driver.close ();
		
		// kill the WebDriver object / process - make driver = null
		driver.quit();
		
		
		
		
	}
	
	
}
