package com.verifications;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.launching.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC_008 extends BaseTest

{	
	public static void main(String[] args) throws Exception
	{		
		init();
		test = report.startTest("TC_008");
		test.log(LogStatus.INFO, "--------------- Started TC_008--------------------");
		test.log(LogStatus.INFO, "Initializing the dependency files......");
			
		launch("chromebrowser");
		test.log(LogStatus.PASS, "Opening the browser :-" + p.getProperty("chromebrowser"));
				
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to :- " + childProp.getProperty("amazonurl"));
		
		String expectedLink = "new Releases";
		
		if(!isElementEqual(expectedLink))
			reportFailure("Both links are not equal...!");
		else
			reportSuccess("Both links are equal...");
						
		
		test.log(LogStatus.INFO, "--------------- Ended TC_008--------------------");
		
		report.endTest(test);
		report.flush();
		
	}
	
}
