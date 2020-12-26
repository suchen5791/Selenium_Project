package com.project.MavenBuild;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {

	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties parentProp;
	public static Properties childProp;
	public static Properties orProp;
	public static ExtentReports report;
	public static ExtentTest test;

	// load data properties
	public static void init() throws Exception {
		fis = new FileInputStream(projectPath + "/data.properties");
		p = new Properties();
		p.load(fis);

		// load environment properties
		fis = new FileInputStream(projectPath + "/environment.properties");
		parentProp = new Properties();
		parentProp.load(fis);
		String e = parentProp.getProperty("env");
		System.out.println(e);

		fis = new FileInputStream(projectPath + "/" + e + ".properties");
		childProp = new Properties();
		childProp.load(fis);
		String value = childProp.getProperty("amazonurl");
		System.out.println(value);

		// load Object Repository properties
		fis = new FileInputStream(projectPath+"/or.properties");
		orProp = new Properties();
		orProp.load(fis);

		// load log4j configuration properties
		fis =  new FileInputStream(projectPath+"/log4jconfig.properties");
		PropertyConfigurator.configure(fis);

		//call getInstance method from ExtentManager.java class
		report = ExtentManager.getInstance();
	}

	public static void launch(String browser) {

		if (p.getProperty(browser).equals("chrome")) 
		{
			ChromeOptions option = new ChromeOptions();

			option.addArguments("user-data-dir=C:\\Users\\suche\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");

			option.addArguments("--disable-notifications");

			driver = new ChromeDriver(option);

		} else if (p.getProperty(browser).equals("firefox")) 
		{
			ProfilesIni p = new ProfilesIni();
			FirefoxProfile profile = p.getProfile("TestProfile1");

			profile.setPreference("dom.webnotifications.enabled", false);

			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);

			driver = new FirefoxDriver(option);
		}

	}

	public static void navigateUrl(String url) {

		//driver.get(childProp.getProperty(url));
		driver.navigate().to(childProp.getProperty(url));
	}

	public static void clickElement(String locatorKey) 
	{
		getElement(locatorKey).click();
		//driver.findElement(By.xpath(orProp.getProperty(locatorKey))).click();
	}

	public static void type(String locatorKey, String text)
	{
		getElement(locatorKey).sendKeys(text);
		//driver.findElement(By.name(orProp.getProperty(locatorKey))).sendKeys(text);
	}

	public static void selectOption(String locatorKey, String item)
	{
		getElement(locatorKey).sendKeys(item);
		//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(item);
	}



	public static WebElement getElement(String locatorKey) 
	{
		WebElement element=null;

		if(locatorKey.endsWith("_id")) {
			element = driver.findElement(By.id(orProp.getProperty(locatorKey)));
		}else if (locatorKey.endsWith("_name")) {
			element = driver.findElement(By.name(orProp.getProperty(locatorKey)));
		}else if (locatorKey.endsWith("_classname")) {
			element = driver.findElement(By.className(orProp.getProperty(locatorKey)));
		}else if (locatorKey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(orProp.getProperty(locatorKey)));
		}else if (locatorKey.endsWith("_cssSelector")) {
			element = driver.findElement(By.cssSelector(orProp.getProperty(locatorKey)));
		}else if (locatorKey.endsWith("_linktext")) {
			element = driver.findElement(By.linkText(orProp.getProperty(locatorKey)));
		}else if (locatorKey.endsWith("_partiallinktext")) {
			element = driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey)));
		}

		return element;

	}

	// ********************************  Verifications  ************************************
	public static boolean isElementEqual(String expectedLink)
	{
		String actualLink = driver.findElement(By.linkText("New Releases")).getText();
		if(actualLink.equals(expectedLink))
			return true;
		else
			return false;
	}


	//  ********************************  Reporting  ***************************************


	public static void reportSuccess(String passMessage) 
	{
		test.log(LogStatus.PASS, passMessage);
	}

	public static void reportFailure(String failMessage) throws Exception 
	{
		test.log(LogStatus.FAIL, failMessage);
		takeScreenshot();

	}

	public static void takeScreenshot() throws Exception 
	{
		Date dt=new Date();
		System.out.println(dt);
		String dateFormat=dt.toString().replace(":", "_").replace(" ", "_")+".png";		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//adding screenshot to failurescreenshot folder
		FileHandler.copy(scrFile, new File(projectPath+"\\failurescreenshots\\"+dateFormat));
		
		//html Reports attachment
		test.log(LogStatus.INFO, "Screenshot --->" +test.addScreenCapture(projectPath+"\\failurescreenshots\\"+dateFormat));
		
	}



}




























