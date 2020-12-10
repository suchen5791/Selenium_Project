package com.webdriverscreenshots;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import com.launching.BaseTest;

public class Selfy5 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
        init();
		
		launch("chromebrowser");
		
		navigateUrl("googleurl");

		  List<WebElement> links = driver.findElements(By.tagName("a"));
		  
		  for (int i=0;i<links.size();i++)
		  {
			  //take screen shot only if the link is not empty
			  if(!links.get(i).getText().isEmpty())
			  {
				  String linkName = links.get(i).getText();
				  driver.findElement(By.linkText(linkName)).click();
				  
				  Date dt = new Date();
			      String str = dt.toString().replace(':', '_').replace(' ', '_');
				  				  
				  File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				  FileHandler.copy(srcFile, new File("D:\\SELENIUM\\Webdriver Screen shot\\Selfy3\\"+linkName+str+".png"));
				  
				  driver.navigate().back();
				  links = driver.findElements(By.tagName("a"));
				  
			  }
		   }
		

	}

}
