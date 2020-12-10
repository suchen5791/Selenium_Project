package com.launching;

public class TC_002 extends BaseTest
{

	public static void main(String[] args) throws Exception {
		
		init();
		
		launch("chromebrowser");
		
		navigateUrl("hdfcurl");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
						
		driver.get(childProp.getProperty(url));//hits the server every time to get url (can not go forward/backward or refresh)
		driver.navigate().to(childProp.getProperty(url));//first time gets url from server and later on gets it from local cache
		
		driver.navigate().back();
		driver.navigate().forward();		
		driver.navigate().refresh();
		
		driver.close();//only current window is closed
		driver.quit();//all windows & chrome driver services also get killed-Task manager
		
		
	}

}
