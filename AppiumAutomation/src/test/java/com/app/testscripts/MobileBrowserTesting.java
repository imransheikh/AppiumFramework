package com.app.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileBrowserTesting {
	
	
	
	
	@Test
	public void MobileBrowser() throws MalformedURLException
	{
		
		AndroidDriver<AndroidElement> driver;
		
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		driver= new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
		
		driver.findElement(By.xpath("//li/a[@routerlink='/products']")).click();
		
		AndroidElement element= driver.findElement(By.xpath("//a[contains(text(),'Devops')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		String nameOfProduct= driver.findElement(By.xpath("//a[contains(text(),'Devops')]")).getText();
		System.out.println("Product name is: " + nameOfProduct);
		
		
		
		
		
		
	}
	

}
