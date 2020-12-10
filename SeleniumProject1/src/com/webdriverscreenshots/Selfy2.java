package com.webdriverscreenshots;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import com.launching.BaseTest;

public class Selfy2 extends BaseTest
{

	public static void main(String[] args) throws Exception
	{
		
		init();
		
		launch("chromebrowser");
		
		navigateUrl("amazonurl");
		
		 List<WebElement> links = driver.findElements(By.linkText("Rajinikanth"));
		 
		 if(links.size()==0)
		 {
				File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(srcFile, new File("D:\\SELENIUM\\Webdriver Screen shot\\amazon1.jpeg"));
		 }

	}

}
