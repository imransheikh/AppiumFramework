package com.app.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GetToastMessage extends BaseClass {

	
	

	@Test
	public void toastTestMethod() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElements(By.xpath("//android.widget.RadioButton")).get(1).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(500);
		String toastMsg= driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
		//String toastMsg= driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.println("Toast message is: " + toastMsg);
	}

}
