package com.webdriverscreenshots;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.launching.BaseTest;

public class Selfy4 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		Date dt = new Date();
        System.out.println(dt);
        //convert date format that is supported for saving screen shots
        String str = dt.toString().replace(':', '_').replace(' ', '_');
        System.out.println(str);
		
		init();
		launch("chromebrowser");
		navigateUrl("googleurl");
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile, new File("D:\\SELENIUM\\Webdriver Screen shot\\Selfy3\\"+str+".png"));
		
		
		
		

	}

}
