package webTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable3 
{

	public static void main(String[] args) 
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Softwares\\Selenium\\chromedriver88\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://money.rediff.com/gainers");
		driver.manage().window().maximize();
		
		  String value = driver.findElement(By.xpath("//div[@id='leftcontainer']/table/tbody/tr[2]/td[4]")).getText();
		  System.out.println(value);
		  
		  String value1 = driver.findElement(By.xpath("//a[contains(text(),'R J Bio Tech Ltd.')]/parent::*/following-sibling::td[3]")).getText();
		  System.out.println(value1);
		
	}

}
