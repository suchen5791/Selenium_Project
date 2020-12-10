package com.verifications;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.launching.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC_005 extends BaseTest

{	
	public static void main(String[] args) throws Exception
	{		
		init();
		test = report.startTest("TC_005");
		test.log(LogStatus.INFO, "--------------- Started TC_005--------------------");
		test.log(LogStatus.INFO, "Initializing the dependency files......");
	
		
		launch("chromebrowser");
		test.log(LogStatus.PASS, "Opening the browser :-" + p.getProperty("chromebrowser"));
				
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to :- " + childProp.getProperty("amazonurl"));
		
		 boolean actualResult = driver.findElement(By.linkText("New Releases")).isDisplayed();
		 boolean expectedResult = true;
		 
		 if(!actualResult)
		   System.out.println("link is not displayed");
		 else
			 System.out.println("link is displayed...");
		
		
		
		test.log(LogStatus.INFO, "--------------- Ended TC_005--------------------");
		
		report.endTest(test);
		report.flush();
		
	}
}
