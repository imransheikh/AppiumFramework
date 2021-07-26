package com.app.testscripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;

public class Views extends BaseClass {
	
	
	@Test
	public void testViewMethod()
	{
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();
		List<AndroidElement> ele= driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().clickable(true)"));
		System.out.println("Size is: " + ele.size());
	}
	

}
