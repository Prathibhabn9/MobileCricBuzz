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

public class WebApp extends SampleMob {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver=capability();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		driver.findElement(By.xpath(".//*[@name='q']")).sendKeys("IBM");
		driver.findElement(By.xpath(".//*[@name='q']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		List<AndroidElement>lt=driver.findElements(By.tagName("a"));
		System.out.println(lt.size());
		
//		for(int i=0;i<lt.size();i++)
//		{
//			System.out.println(lt.get(i).getText());
//		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement e=driver.findElement(By.xpath(".//*[contains(text(),'IBM - Wikipedia')]"));
		js.executeScript("arguments[0].scrollIntoView(false)",e);
		//js.executeScript("scroll(0,200)");
		e.click();
	}

}
