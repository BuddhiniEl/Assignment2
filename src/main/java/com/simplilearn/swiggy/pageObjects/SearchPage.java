package com.simplilearn.swiggy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	WebDriver driver = null;
	By openSearchButton = By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/ul/li[5]/div/a/span[2]");
	By locationInput = By.id("location");
	
	By delhiMenuItem = By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div[3]/div[2]/span[2]");
	
	By searchInput = By.xpath("//*[@id=\"root\"]/div[1]/div/div/div/div/div/input");
	
	By searchResults = By.className("nA6kb");
	
	By clearButton = By.className("_3TI86");
	
	public SearchPage(WebDriver driver){
		this.driver = driver;
	}
	
	
	public void setLocation(String location) throws InterruptedException {
		WebElement loc = driver.findElement(locationInput);
		loc.sendKeys(location);
		Thread.sleep(1000);
		driver.findElement(delhiMenuItem).click();
		Thread.sleep(1000);
	}
	
	public void openSearch() {
		driver.findElement(openSearchButton).click();
	}
	
	public void search(String value) {
		WebElement element  = driver.findElement(searchInput);
		element.sendKeys(value);
		element.sendKeys(Keys.ENTER);
	}
	
	public boolean hasItem(String value) {
		List<WebElement> elements = driver.findElements(searchResults);
		for(WebElement ele:elements) {
			if(ele.getText().equals(value)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void clearSearch() {
		driver.findElement(clearButton).click();
	}
}
