package com.app.testscripts;

import static java.time.Duration.ofMillis;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
public class SwappingTest extends BaseClass {

	
	
	@Test
	public void swappingMethod()
	{

		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();
		//TouchAction<TouchAction<T>>
		
		driver.findElementByAccessibilityId("Date Widgets").click();
		driver.findElementByAccessibilityId("2. Inline").click();
		driver.findElementByAccessibilityId("9").click();
		//android.widget.RadialTimePickerView$RadialPickerTouchHelper
		//9
		
		//content-desc		15
		//45
		
	AndroidElement first= 	driver.findElementByAccessibilityId("15");
	AndroidElement second= 	driver.findElementByAccessibilityId("45");
	
		TouchAction touch= new TouchAction(driver);
		touch.longPress(LongPressOptions.longPressOptions().withElement(element(first))).waitAction(waitOptions(ofSeconds(2)))
		.moveTo(element(second))
        .release();
		touch.perform();
		
		//driver.pressKeyCode(AndroidKeyCode.HOME);
	}
	
}
