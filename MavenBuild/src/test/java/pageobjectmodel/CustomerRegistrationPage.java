package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project.MavenBuild.BaseTest;

public class CustomerRegistrationPage extends BaseTest
{
	@FindBy(xpath="//a[@class='login']")public WebElement signIn;
	@FindBy(id="email_create")public WebElement custEmail;
	@FindBy(id="SubmitCreate")public WebElement Submit;
	@FindBy(id="id_gender1")public WebElement Title_gen1;
	@FindBy(id="id_gender2")public WebElement Title_gen2;
	@FindBy(id="customer_firstname")public WebElement FirstName;
	@FindBy(id="customer_lastname")public WebElement LastName;
	@FindBy(id="passwd")public WebElement custPassword;
	@FindBy(id="days")public WebElement DOB_day;
	@FindBy(id="months")public WebElement DOB_month;
	@FindBy(id="years")public WebElement DOB_year;
	@FindBy(id="firstname")public WebElement FirstName_address;
	@FindBy(id="lastname")public WebElement LastName_address;
	@FindBy(id="company")public WebElement Company;
	@FindBy(id="address1")public WebElement Address_1;
	@FindBy(id="address2")public WebElement Address_2;
	@FindBy(id="city")public WebElement City;
	@FindBy(id="id_state") public WebElement State;
	@FindBy(id="postcode") public WebElement Postcode;
	@FindBy(id="id_country") public WebElement Country;
	@FindBy(id="other") public WebElement TextArea;
	@FindBy(id="phone") public WebElement Phone;
	@FindBy(id="phone_mobile") public WebElement Mobile_Phone;
	@FindBy(id="alias") public WebElement Alias_address;
	@FindBy(id="submitAccount") WebElement submitAccount;
	
	public CustomerRegistrationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void customerRegistration() throws InterruptedException
	{
		signIn.click();
		
		//Thread.sleep(3000);
		waitForElement(60,custEmail,"visible");
				
		custEmail.sendKeys("qatest87487@gmail.com");
		Submit.click();
		
		//Thread.sleep(3000);
		waitForElement(30, Title_gen1,"clickable");
		
		Title_gen1.click();
		
		FirstName.sendKeys("qa");
		LastName.sendKeys("test");
		custPassword.sendKeys("password");
		
		DOB_day.sendKeys("1");
		DOB_month.sendKeys("2");
		DOB_year.sendKeys("3");
		Address_1.sendKeys("hyderabad");
		City.sendKeys("hyderabad");
		State.sendKeys("california");
		Postcode.sendKeys("23456");
		Country.sendKeys("United States");
		Mobile_Phone.sendKeys("1234567890");
        //submitAccount.click();		
	}
	

}
