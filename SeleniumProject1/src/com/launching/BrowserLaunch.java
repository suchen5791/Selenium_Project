package com.launching;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch {
	
	public static void main(String[] args) {
		
		
		WebDriver driver;
		
		//System.setProperty("webdriver.chrome.driver", "C:/Softwares/Selenium/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("https://bestbuy.com");
		
		//System.setProperty("webdriver.gecko.driver","C:/Softwares/Selenium/geckodriver.exe");
		 driver = new FirefoxDriver();
		driver.get("https://www.amazon.ca");
	}

}
