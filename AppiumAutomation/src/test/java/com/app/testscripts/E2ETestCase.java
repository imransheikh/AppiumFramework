package com.app.testscripts;

import java.util.List;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;


public class E2ETestCase extends BaseClass {
	
	
	
	@Test
	public void E2ETestMethod() throws InterruptedException
	{
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//android.widget.Spinner")).click();
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));");
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     
		//driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("Imran");
		driver.hideKeyboard();

		driver.findElements(By.xpath("//android.widget.RadioButton")).get(1).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
        + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
        + "new UiSelector().text(\"Jordan 6 Rings\"));");
		
		
		String selectedProductName="";
		System.out.println("Total size is: " + driver.findElements(By.id("com.androidsample.generalstore:id/rvProductList")).size());
		List<AndroidElement> list= driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		for(int i=0; i<list.size(); i++)
		{
			System.out.println("Text is: " + list.get(i).getText());
			String productName= list.get(i).getText();
			//productName.equals(anObject)
			if(productName.equals("Jordan 6 Rings"))
			{
				selectedProductName= productName;
				System.out.println("I am inside");
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
	
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		
		String productNameAtCheckoutPage= driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		
		System.out.println("Both the product name: " + selectedProductName + "  : " + productNameAtCheckoutPage);
		
		
		driver.findElement(By.xpath("//android.widget.CheckBox")).click();
		
		AndroidElement termsAndConditions= driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		
		
		TouchAction action= new TouchAction(driver);
		action.longPress(LongPressOptions.longPressOptions().withDuration(ofSeconds(2)).withElement(element(termsAndConditions))).release().perform();
		
		String title = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
		System.out.println("Title is: " + title);
		String message= driver.findElement(By.id("android:id/message")).getText();
		System.out.println("Message is: " + message);
		
		driver.findElement(By.xpath("//android.widget.Button[@text='CLOSE']")).click();
		
		
		
	}
	

}
