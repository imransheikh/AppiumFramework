package com.app.testscripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;

public class BaseClass {

	AndroidDriver<AndroidElement> driver;
	private static AppiumDriverLocalService service;
	@BeforeClass
	public void setUp() throws MalformedURLException {
		startAppiumServer();
		
		//String appPath = System.getProperty("user.dir") + "/Apps/ApiDemos-debug.apk";
		String appPath = System.getProperty("user.dir") + "/Apps/General-Store.apk";
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Imran");
		// capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		capabilities.setCapability(MobileCapabilityType.APP, appPath);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 15);
		
		// If you want to disable the keyboard use these desired capabilities 
		//capabilities.setCapability("unicodeKeyboard", true);
		//capabilities.setCapability("resetKeyboard", true);
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	
	@AfterClass
	public void StopAppiumServer()
	{
		System.out.println("Stopping the server...");
		if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
		  
	}
	
	public void startAppiumServer()
	{
		System.out.println("Starting the server...");
		 AppiumDriverLocalService.buildDefaultService();
		   service = AppiumDriverLocalService.buildDefaultService();
	        service.start();
	        if (service == null || !service.isRunning()) {
	            throw new AppiumServerHasNotBeenStartedLocallyException(
	                "An appium server node is not started!");
	        }
	}

}
