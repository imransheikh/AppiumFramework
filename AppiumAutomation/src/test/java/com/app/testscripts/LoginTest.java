package com.app.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;


public class LoginTest extends BaseClass {
	
	
	@Test
	public void loginTestMethod() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.Spinner")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));");
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("Imran");
		driver.hideKeyboard();

		driver.findElements(By.xpath("//android.widget.RadioButton")).get(1).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	}

}
