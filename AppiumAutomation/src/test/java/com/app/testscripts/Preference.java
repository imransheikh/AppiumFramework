package com.app.testscripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Preference extends BaseClass {
	
	
	
	@Test
	public void TestPreferenceMethod() throws MalformedURLException
	{
		
			driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		    
		    driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		    
		    driver.findElement(By.id("android:id/checkbox")).click();
		    
		    driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		    
		    driver.findElement(By.id("android:id/edit")).sendKeys("Imran");
		    
		   // driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		    driver.findElements(By.xpath("//android.widget.Button")).get(1).click();


	}

}
