package test3.test3;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GridExampleTest {
	
	public RemoteWebDriver driver;
	public static String appURL = "http://www.google.com";
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		/*ChromeOptions options1 = new ChromeOptions();
		options1.addArguments("test-type");
		capabilities.setCapability("webdriver.chrome.driver", "D:\\com.gridTest\\Drivers\\chromedriver.exechromedriver.exe");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options1);*/
		driver = new RemoteWebDriver(new URL("http://192.168.8.22:55561/wd/hub"), capabilities);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testGooglePageTitleInIEBrowser() {
		System.out.println("*** Navigation to Application ***");
		driver.navigate().to(appURL);
		String strPageTitle = driver.getTitle();
		System.out.println("*** Verifying page title ***");
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
	}
	
	@AfterTest
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}