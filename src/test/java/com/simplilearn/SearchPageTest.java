package com.simplilearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.simplilearn.swiggy.pageObjects.SearchPage;

@Test
public class SearchPageTest {
	WebDriver driver = null;
	
	@BeforeTest
	public void setUp() throws Exception {
		BrowserDriver browserDriver = new BrowserDriver();
		driver = browserDriver.getDriver();
	}
	
	
	@Test
	public void searchPizza() throws Exception {
		SearchPage searchPage = new SearchPage(driver);
		driver.manage().window().maximize();
		driver.get("https://www.swiggy.com/");
		Thread.sleep(3000);
		searchPage.setLocation("New Delhi, Delhi, India");
		Thread.sleep(1000);
		searchPage.openSearch();
		Thread.sleep(1000);
		searchPage.search("pizza");
		Thread.sleep(8000);
		
		Assert.assertTrue(searchPage.hasItem("Pizza Pizza"));
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
