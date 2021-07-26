package com.app.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class DragAndDropTest extends BaseClass {
	
	
	@Test
	public void testDragAndDropMethod()
	{
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();
		driver.findElementByAccessibilityId("Drag and Drop").click();
		
		AndroidElement firstElement= driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		AndroidElement secondElement= driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
		TouchAction action = new TouchAction(driver);
		action.longPress(LongPressOptions.longPressOptions().withElement(element(firstElement))).waitAction(waitOptions(ofSeconds(3)))
		.moveTo(element(secondElement)).release().perform();
		
		System.out.println("Dropped Text displayed: " + driver.findElement(By.xpath("//android.widget.TextView[@text='Dropped!']")).isDisplayed());
		
	
		
		//resource id  io.appium.android.apis:id/drag_dot_1
		//io.appium.android.apis:id/drag_dot_3
		//io.appium.android.apis:id/drag_dot_2
	}
}
