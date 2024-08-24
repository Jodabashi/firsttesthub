package com.learning.automation.test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumMethods {

	private WebDriver driver;

	@BeforeMethod
	public void beforeEachTest() throws Exception {
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		//startChromeInHeadlessMode();  // this if we want to run the test in background, called the method at the end here
		Thread.sleep(3 * 1000);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterEachTest() throws Exception {
		Thread.sleep(5 * 1000);
		// close the browser
		driver.close();
		// kill the driver object or process
		driver.quit();
	}

	@Test(enabled = true, priority = 10)
	public void practiceSeleniumMethodsTest() throws Exception {
		// Step3: navigate to website url
		driver.get("https://www.costco.com/");

		// Step4: Getting the website title
		String actualWebsiteTitle = driver.getTitle();
		System.out.println("Website title: " + actualWebsiteTitle);

		// Step5: naviagte to amazon.com
		driver.navigate().to("https://www.amazon.com/");
		System.out.println("Website2 title: " + driver.getTitle());

		// delay for 2 second
		Thread.sleep(2 * 1000);

		// Step6: backward to previous website url
		driver.navigate().back();

		// delay for 2 second
		Thread.sleep(2 * 1000);

		// Step7: forward to already visited website
		driver.navigate().forward();
		Thread.sleep(2 * 1000);

		// Step8: refresh or reload the website page
		driver.navigate().refresh();
		Thread.sleep(2 * 1000);

		// Step9: get html page source
		String htmlPageSource = driver.getPageSource();
		System.out.println("html page source ---------------");
		System.out.println(htmlPageSource);
	}

	@Test(enabled = true, priority = 1)
	public void searchAllTheLinks() throws Exception {
		driver.get("https://www.costco.com/");

		// wait until page load complete
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		// to get all the links for the webpage, we need to locate <a> tag

		List<WebElement> allLinksElements = driver.findElements(By.tagName("a"));

		// total number of links
		int totalLinks = allLinksElements.size();
		System.out.println("Total Links: " + totalLinks);

		// Problem1: let's print the each link with text they contain
		int counter = 1;
		int counterNoTextLink = 1;
		int counterWithTextLink = 1;

		List<WebElement> LinksNoText = new ArrayList<WebElement>();
		List<WebElement> LinksWithText = new ArrayList<WebElement>();

		for (WebElement link : allLinksElements) {
			String linkTxt = link.getText();
			if (linkTxt.isEmpty() == true) {
				counterNoTextLink++;
				LinksNoText.add(link);
			} else {
				counterWithTextLink++;
				LinksWithText.add(link);
			}

			System.out.println(counter + ") Link Test ---> " + linkTxt);

			counter++; // counter = counter + 1;
		}
		System.out.println("Total links with no text: " + counterNoTextLink);
		System.out.println("Total links with text: " + counterWithTextLink);

		System.out.println("ArrayList -> Total links with no text: " + LinksNoText.size());
		System.out.println("ArrayList -> Total links with with text: " + LinksWithText.size());

		// Problem 2: Print total number of links with text
		// Print total number of links without text		
	}
	
	
	
	public void startChromeInHeadlessMode() {
		
		// start chrome in background so we do not see what happen
		
		ChromeOptions options = new ChromeOptions();
		
		// the following " ** " should be exactly as written
		options.addArguments("headless");
		options.addArguments("window-size=1400,800");
		System.out.println("Chrome browser is starting in Headless mode...");
		
		driver = new ChromeDriver(options);
	}
	
	

}



