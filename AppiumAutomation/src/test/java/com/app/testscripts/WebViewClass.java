package com.app.testscripts;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;

public class WebViewClass extends BaseClass {
	
	
	@Test
	public void TestWebViewMethod() throws InterruptedException
	{
		
		Thread.sleep(5000);
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
		Thread.sleep(4000);
		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(7000);
		Set<String> context =	driver.getContextHandles();
			for(String str: context)
			{
				System.out.println("Context names are: " + str);
			}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Imran");
		((AndroidDriver<AndroidElement>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		//driver.findElement(By.xpath("(//input[@value='Google Search' and @type='submit'])[2]")).click();
	}

}
