package test3.test3;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class ParallelExec {
	public static RemoteWebDriver driver;
	public static String appURL = "http://www.google.com";
	
	
	@BeforeTest
	@Parameters({"remoteurl"})
	public void setUp(String remoteurl) throws MalformedURLException {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setBrowserName("chrome");
		driver = new RemoteWebDriver(new URL(remoteurl), capabilities);
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
	}

  @Test
  public void f() {
	  
		System.out.println("*** Navigation to Application ***");
		String strPageTitle = driver.getTitle();
		System.out.println("*** Verifying page title ***");
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
  }

  public void f1() {
	  
		System.out.println("*** Navigation to Application ***");
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
