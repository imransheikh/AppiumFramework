package com.app.testscripts;

import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

import java.util.List;

public class ScrollingTest  extends BaseClass {

	
	
	@Test
	public void swappingMethod()
	{

		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();
		
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Visibility\"));");
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
			
		
		driver
        .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
        + ".resourceId(\"android:id/list\")).scrollIntoView("
        + "new UiSelector().text(\"Radio Group\"));");
        
       
	}

}
