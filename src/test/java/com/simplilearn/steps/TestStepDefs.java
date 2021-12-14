package com.simplilearn.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.simplilearn.BrowserDriver;
import com.simplilearn.swiggy.pageObjects.SearchPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestStepDefs {
	int sum;
	
	WebDriver driver;;
	SearchPage searchPage;
	
	@Before
	public void setup() {
		BrowserDriver browserDriver  = new BrowserDriver();
		driver = browserDriver.getDriver();
		driver.manage().window().maximize();
		searchPage = new SearchPage(driver);
	}
	
	@Given("visit {string}")
	public void visit(String url) throws InterruptedException {
		driver.get(url);
		Thread.sleep(3000);
	}
	
	@Given("location {string}")
	public void setLocation(String location)  throws InterruptedException{
		searchPage.setLocation(location);
		Thread.sleep(3000);
	}

	@When("open search")
	public void openSearch()  throws InterruptedException{
		searchPage.openSearch();
		Thread.sleep(3000);
	}
	
	@When("search {string}")
	public void search(String searchKey)throws InterruptedException {
		searchPage.search(searchKey);
		Thread.sleep(3000);
		searchPage.clearSearch();
	}
		
	@Then("{string} is suggested")
	public void validate(String suggestion) {	
//		Assert.assertTrue(searchPage.hasItem(suggestion));
	}
	
	@After
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
