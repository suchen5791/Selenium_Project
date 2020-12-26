package com.project.MavenBuild;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TNG_002 extends BaseTest
{
  @BeforeMethod
  public void startProcess() throws Exception {
	  
	  System.out.println("StratProcess");
	  
	  init();
		test = report.startTest("TNG_002");
		test.log(LogStatus.INFO, "--------------- Started TN_002--------------------");
		test.log(LogStatus.INFO, "Initializing the dependency files......");
	
		
		launch("chromebrowser");
		test.log(LogStatus.PASS, "Opening the browser :-" + p.getProperty("chromebrowser"));
		
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to :- " + childProp.getProperty("amazonurl"));
  }
  
  @Test
  public void amazon() {
	  
	  System.out.println("Amazon Test");	  
	  selectOption("amazondropdown_id","Books" );
		test.log(LogStatus.FAIL, "Selected the option books by using the locator :- " + orProp.getProperty("amazondropdown_id"));
		
				
		type("amazonsearchtext_name","Harry Potter" );
		test.log(LogStatus.INFO, "Entered the test Harry Potter by using  locator :-" + orProp.getProperty("amazonsearchtext_name"));
	
		
		clickElement("amazonsearchbutton_xpath");
		test.log(LogStatus.ERROR, "Clicked on search button by using the locator :-"+ orProp.getProperty("amazonsearchbutton_xpath"));
  }
  

  @AfterMethod
  public void endProcess() {
	  
	  System.out.println("EndProcess");	  
	  report.endTest(test);
	  report.flush();
	  
	  driver.quit();
  }

}
