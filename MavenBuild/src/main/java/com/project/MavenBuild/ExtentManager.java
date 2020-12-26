package com.project.MavenBuild;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager extends BaseTest
{

	public static ExtentReports report;
	
	public static ExtentReports getInstance()
	{
		if(report==null)
		{
		//set path to Html Reports folder	
			report = new ExtentReports(projectPath+"//HtmlReports//report.html");
		//load xml config file
		    report.loadConfig(new File(projectPath+"//extentreportconfig.xml"));
		    
		    report.addSystemInfo("Selenium Language Binding", "3.141.59");
		    report.addSystemInfo("Environment", parentProp.getProperty("env"));
		    
		}
		
		return report;
		
	}
	
	
}
