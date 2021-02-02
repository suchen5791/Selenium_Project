package webTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable2 
{

	public static void main(String[] args) throws Exception 
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Softwares\\Selenium\\chromedriver88\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.tripadvisor.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[text()='More']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.name("Flights")).click();

	}

}
