package com.project.MavenBuild;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public static String filePath;
	
	//***** Static block for file path ******
	static
	{
		Date dt = new Date();
		filePath = dt.toString().replace(':', '_').replace(' ', '_');
	}

	//******** load data properties ********
	public static void init() throws Exception {
		fis = new FileInputStream(projectPath + "/data.properties");
		p = new Properties();
		p.load(fis);

	//********* load environment properties *********
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

	//******** load Object Repository properties **********
		fis = new FileInputStream(projectPath+"/or.properties");
		orProp = new Properties();
		orProp.load(fis);

	//********* load log4j configuration properties **********
		fis =  new FileInputStream(projectPath+"/log4jconfig.properties");
		PropertyConfigurator.configure(fis);

	//******call getInstance method from ExtentManager.java class *****
		report = ExtentManager.getInstance();
	}
	
	// ********************************  Browser Launchings ************************************
	public static void launch(String browser) {

		if (browser.equals("chrome")) 
		{
			ChromeOptions option = new ChromeOptions();

			option.addArguments("user-data-dir=C:\\Users\\suche\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");

			option.addArguments("--disable-notifications");

			driver = new ChromeDriver(option);

		} else if (browser.equals("firefox")) 
		{
			ProfilesIni p = new ProfilesIni();
			FirefoxProfile profile = p.getProfile("TestProfile1");

			profile.setPreference("dom.webnotifications.enabled", false);

			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);

			driver = new FirefoxDriver(option);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS );
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

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

    
//  ********************************  Get Web Element Information  ***************************************

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
	
//  ********************************  Take Screen Shot  ***************************************

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
	
  //  ********************************  Close Browser  ***************************************
	public static void browserClose()
	{
		driver.quit();
	}
	
//  ********************************  Wait for Element - SYNCHRONIZATION ***************************************
	
	public static void waitForElement(int timeInSeconds, WebElement element, String operationType)
	{
		WebDriverWait wait = new WebDriverWait( driver,timeInSeconds);
		
		if(operationType.equals("visible") )
		{
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		else if(operationType.equals("clickable"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
			
	}
	
// ******************** Generate Random Number ******************
	public int randomNumber()
	{
		Random r = new Random();
		int ran = r.nextInt(999999);
		return ran;
	}
	
// ******************** Select reusable function  for drop downs ******************	
	
	public void selectOption(WebElement locator, int item) 
	{
		Select s = new Select(locator);
		s.selectByIndex(item);
		
		
	}

}




























