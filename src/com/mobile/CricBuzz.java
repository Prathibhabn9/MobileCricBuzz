package com.mobile;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
public class CricBuzz extends SampleMob {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver=capability();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://m.cricbuzz.com/");
		driver.findElement(By.xpath(".//*[contains(text(),'Menu')]")).click();
		driver.findElement(By.xpath(".//*[contains(text(),'Home')]")).click();
		
	
		Thread.sleep(3000);

		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement e=driver.findElement(By.xpath(".//*[contains(text(),'Top Stories')]"));
		js.executeScript("arguments[0].scrollIntoView(false)",e);
		//js.executeScript("scroll(0,200)");
		
		Assert.assertEquals(e.getText().contains("Top"), true);
		
	}

}
