package switches;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AlertHandling 
{
	WebDriver driver;

  @BeforeMethod
  public void beforeMethod()
  {
	  System.setProperty("webdriver.chrome.driver","C:\\Softwares\\Selenium\\chromedriver88\\chromedriver.exe" );
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  driver.navigate().to("http://demo.guru99.com/selenium/delete_customer.php");
	  
  }
  
  @Test
  public void f() throws InterruptedException
  {
	  driver.findElement(By.name("cusid")).sendKeys("56789");
	  driver.findElement(By.name("submit")).submit();
	  
	  Thread.sleep(5000);
	  
	  Alert al = driver.switchTo().alert();
	  
	  System.out.println(al.getText());
	  String expval = "Do you really want to delete this Customer?";
	  Assert.assertEquals(al.getText(), expval);
	 // al.accept();
	  al.dismiss();
	  
  }

  @AfterMethod
  public void afterMethod()
  {
	  
	 driver.quit();
  }

}
