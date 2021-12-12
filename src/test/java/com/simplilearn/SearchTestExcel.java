package com.simplilearn;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.simplilearn.swiggy.pageObjects.SearchPage;

public class SearchTestExcel {
	WebDriver driver = null;
	SearchPage searchPage = null;
	
	@BeforeTest
	public void setUp() throws Exception {
		BrowserDriver browserDriver = new BrowserDriver();
		driver = browserDriver.getDriver();
		searchPage = new SearchPage(driver);
		driver.manage().window().maximize();
		
		driver.get("https://www.swiggy.com/");
		
		//Set location to New Delhi
		Thread.sleep(3000);
		searchPage.setLocation("New Delhi, Delhi, India");
		Thread.sleep(3000);
		
		//Open search
		searchPage.openSearch();
		Thread.sleep(1000);
	}
	
	@DataProvider
	public Object[][] searchData() throws Exception{
		ExcelData excelData = new ExcelData();
		return excelData.getData();
	}
	
	@Test(dataProvider = "searchData")
	public void search(String key, String item) throws Exception {
		searchPage.search(key);
		Thread.sleep(3000);
		Assert.assertTrue(searchPage.hasItem(item));
		searchPage.clearSearch();
		Thread.sleep(500);
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
