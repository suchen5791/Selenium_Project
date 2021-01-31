package switches;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowsHandle
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Softwares\\Selenium\\chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.sc.com/in/bank-with-us/online-banking-login/");
		System.out.println(driver.getTitle());
		 String parentWindow = driver.getWindowHandle();
		 System.out.println("Parent Windowid : " + parentWindow);
		 
		 driver.findElement(By.xpath("//a[@title='Apply Now']")).click();
		 
		  Set<String> multiWindows = driver.getWindowHandles();
		  Iterator<String> itr = multiWindows.iterator();
		  while(itr.hasNext())
		  {
			  String currentWindow = itr.next();
			  System.out.println("Window id's : " + currentWindow);
			  if(!currentWindow.equals(parentWindow))
			  {
				  driver.switchTo().window(currentWindow);
			  }
		  }
		  
		   String childwindowTitle = driver.getTitle();
		   System.out.println("ChildWindow Title :" + childwindowTitle);
		   
		   driver.close();
		   
		   driver.switchTo().window(parentWindow);
		   System.out.println("Parent window title :"+ driver.getTitle());

	}

}
