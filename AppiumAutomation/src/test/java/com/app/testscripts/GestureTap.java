package com.app.testscripts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

import java.util.List;

public class GestureTap extends BaseClass {
	
	
	@Test
	public void TestSingleTap()
	{
		
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();
		//TouchAction<TouchAction<T>>
		
		AndroidElement androidElement= driver.findElementByAccessibilityId("Expandable Lists");
		TouchAction touch=	new TouchAction(driver);
		touch.tap(tapOptions().withElement(element(androidElement)))
        .waitAction(waitOptions(ofMillis(250))).perform();
		
		
		List<AndroidElement> elements = driver.findElements(By.xpath("//android.widget.TextView"));
		for (int i = 0; i < elements.size(); i++) {
			String str = elements.get(i).getText();
			System.out.println("Text are: " + str);
			if (str.contains("Custom Adapter")) {
				elements.get(i).click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']")).click();
		
		AndroidElement peopleName= driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		touch.longPress(LongPressOptions.longPressOptions().withElement(element(peopleName)))
		.waitAction(waitOptions(ofMillis(250))).release().perform();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Sample action']")).click();
		
		

	}

}
