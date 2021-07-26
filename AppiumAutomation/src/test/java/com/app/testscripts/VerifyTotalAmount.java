package com.app.testscripts;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;

public class VerifyTotalAmount	extends BaseClass{
	
	@Test
	public void E2ETestMethod() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("Imran");
		driver.hideKeyboard();

		driver.findElements(By.xpath("//android.widget.RadioButton")).get(1).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		
		int size=	driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).size();
		System.out.println("Size is: " + size);
		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
		
		
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
		
		driver
        .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
        + ".resourceId(\"com.androidsample.generalstore:id/rvCartProductList\")).scrollIntoView("
        + "new UiSelector().text(\"Jordan 6 Rings\"));");
		
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));");
		Double productPrice=0.0;
		List<AndroidElement> list1= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		for(int i=0; i<list1.size(); i++)
		{
			System.out.println("Text is: " + list1.get(i).getText());
			String pro= list1.get(i).getText();
			String str = pro;
			int nbr = 1;
			str = str.replaceAll("^.{" + nbr + "}", "");//Output = amaica
			System.out.println(str);
			

			
			Double parseIntProduct=Double.parseDouble(str);  
			productPrice = productPrice+parseIntProduct;
			System.out.println("Price are : " + parseIntProduct);
			System.out.println("Total price is: " + productPrice);
	
		}
		
		String totalPrice= driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		String str = totalPrice;
		int nbr = 1;
		str = str.replaceAll("^.{" + nbr + "}", "");//Output = amaica
		System.out.println(str);
		

		
		Double totalPriceInDouble=Double.parseDouble(str); 
		System.out.println("Total Price at checkout : " + totalPriceInDouble);
		
		
	/*	
		driver.findElement(By.xpath("//android.widget.CheckBox")).click();
		AndroidElement termsAndConditions= driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
				
		TouchAction action= new TouchAction(driver);
		action.longPress(LongPressOptions.longPressOptions().withDuration(ofSeconds(2)).withElement(element(termsAndConditions))).release().perform();
		
		String title = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
		System.out.println("Title is: " + title);
		String message= driver.findElement(By.id("android:id/message")).getText();
		System.out.println("Message is: " + message);
		
		driver.findElement(By.xpath("//android.widget.Button[@text='CLOSE']")).click();
		
	*/	
		
	}

}
