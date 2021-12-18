package com.simplilearn;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserDriver {
	
	WebDriver driver = null;
	
	public WebDriver getDriver() throws MalformedURLException {
		if (driver == null) {
			 String hub = "http://localhost:4444/wd/hub";
	         DesiredCapabilities cap = new DesiredCapabilities();
	         cap.setBrowserName("firefox");
	         
	         driver = new RemoteWebDriver(new URL(hub), cap);
		}
		return driver;
	}
}
