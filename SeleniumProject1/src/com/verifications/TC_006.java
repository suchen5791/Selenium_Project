package com.verifications;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.launching.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC_006 extends BaseTest

{	
	public static void main(String[] args) throws Exception
	{		
		init();
		test = report.startTest("TC_006");
		test.log(LogStatus.INFO, "--------------- Started TC_006--------------------");
		test.log(LogStatus.INFO, "Initializing the dependency files......");
	
		
		launch("chromebrowser");
		test.log(LogStatus.PASS, "Opening the browser :-" + p.getProperty("chromebrowser"));
				
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to :- " + childProp.getProperty("amazonurl"));
		
		String actualLink = driver.findElement(By.linkText("New Releases")).getText();
		String expectedLink = "Releases";
		
		System.out.println("Actual Link : " + actualLink);
		System.out.println("Actual Link : " + expectedLink);
		
		//if(actualLink.equals(expectedLink))
		//if(actualLink.equalsIgnaoreCase(expectedLink))
		if(actualLink.contains(expectedLink))
			System.out.println("Both links are equal...");
		else
			System.out.println("Both links are not equal...");
		  
			
		test.log(LogStatus.INFO, "--------------- Ended TC_006--------------------");
		
		report.endTest(test);
		report.flush();
		
	}
}
